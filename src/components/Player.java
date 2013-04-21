package components;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import engine.Collision;
import engine.GameFrame;
import gfx.SpriteLoader;

public class Player {
	
	public static final int playerWidth = 32; // The width of the player
	public static final int playerHeight = 128; //The height of the player
	
	public static int playerX = 50; //The players X coordinate
	public static int playerY = GameFrame.HEIGHT / 2 - playerHeight / 2; //(The players Y coordinate) Makes the player start in the middle of the screen
	
	public static int playerCenter; //Used in the method getCenter() to get the Y coordinate of the center of the player
	
	//The velocity of the player (the speed of player movement)
	private int velocity = 4;
	
	//The class used to check for collisions
	private static Collision coll;
	
	public Player(){
		initPlayerRect();
	}
	
	//Initiates the player rectangle used for collisions
	public void initPlayerRect(){
		coll = new Collision();
		coll.newCollisionRect(playerX, playerY, playerWidth, playerHeight);
	}
	
	//The player is moving up
	public void playerMovingUp(){
		//If the player is colliding with the top of the screen we wont let him go any further up
		if(coll.checkBoundariesCollision() != 3){
			playerY -= velocity;
		}
		//Update the location of the players collision rectangle
		coll.update(playerX, playerY);
	}
	
	//The player is moving down
	public void playerMovingDown(){
		//If the player is colliding with the bottom of the screen we wont let him go any further down
		if(coll.checkBoundariesCollision() != 4){
			playerY += velocity;
		}
		//Update the location of the players collision rectangle
		coll.update(playerX, playerY);
	}
	
	public static Rectangle getplayerCollisionRect(){
		return coll.getRect();
	}
	
	public static void Draw(Texture player){
		//Binds the player texture
		player.bind();
		
		//Draw the player texture
		GL11.glBegin(GL11.GL_QUADS);
		
			GL11.glTexCoord2f(0, 0);  //Top left
			GL11.glVertex2f(playerX, playerY);
	
			GL11.glTexCoord2f(1,0);    //Top right
			GL11.glVertex2f(playerX + playerWidth, playerY);
	
			GL11.glTexCoord2f(1, 1); //Bottom right
			GL11.glVertex2f(playerX + playerWidth, playerY + playerHeight);
	
			GL11.glTexCoord2f(0, 1); //Bottom left
			GL11.glVertex2f(playerX, playerY + playerHeight);
			
		GL11.glEnd();
	}
	
	//Method that calls into the SpriteLoader class and loads the sprite needed for the player
	public static Texture getSprite(String path, SpriteLoader spriteLoader){
		spriteLoader.loadSprite(path); 
		return spriteLoader.getSprite();
	}
	
	//Method that returns the players X coordinate
	public int getX(){
		return playerX;
	}
	
	//Method that returns the players Y coordinate
	public int getY(){
		return playerY;
	}
	
	//Method that returns the Y coordinate of the center of the player
	public static int getCenter(){
		playerCenter = playerY + playerHeight / 2;
		return playerCenter;
	}
}
