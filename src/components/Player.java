package components;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import engine.GameFrame;
import gfx.SpriteLoader;

public class Player {
	
	//The players cordinates X and Y
	public static int playerX = 50;
	public static int playerY = GameFrame.HEIGHT / 2 - 75; //Makes the player start in the middle of the screen
	
	public static final int playerWidth = 32;
	public static final int playerHeight = 128;
	
	//The velocity of the player (the speed of player movement)
	private float velocity = 4f;
	
	public Player(){
		
	}
	
	//The player is moving up
	public void playerMovingUp(){
		playerY -= velocity;
	}
	
	//The player is moving down
	public void playerMovingDown(){
		playerY += velocity;
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
}
