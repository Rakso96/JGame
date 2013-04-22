package components;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import engine.Collision;
import engine.GameFrame;
import gfx.SpriteLoader;

public class Enemy {
	
	
	public static final int enemyWidth = 32; // The width of the enemy
	public static final int enemyHeight = 128; //The height of the enemy
	
	public static int enemyX = GameFrame.WIDTH - (enemyWidth + 50); //The enemy's X coordinate
	public static int enemyY = GameFrame.HEIGHT / 2 - enemyHeight / 2; //(The enemy's Y coordinate) Makes the enemy start in the middle of the screen
	
	public static int enemyCenter; //Used in the method getCenter() to get the Y coordinate of the center of the enemy
	
	//The velocity of the enemy (the speed of enemy movement)
	private int velocity = 4;
	
	//The class used to check for collisions
	private static Collision coll;
	
	public Enemy(){
		initEnemyRect();
	}
	
	//Initiates the enemy's rectangle used for collisions
	public void initEnemyRect(){
		coll = new Collision();
		coll.newCollisionRect(enemyX, enemyY, enemyWidth, enemyHeight);
	}
	
	public void update(int ballX, int ballY){
		
	}
	
	//The enemy is moving up
	public void enemyMovingUp(){
		//If the enemy is colliding with the top of the screen we wont let him go any further up
		if(coll.checkBoundariesCollision() != 3){
			enemyY -= velocity;
		}
		//Update the location of the enemy's collision rectangle
		coll.update(enemyX, enemyY);
	}
	
	//The enemy is moving down
	public void enemyMovingDown(){
		//If the enemy is colliding with the bottom of the screen we wont let him go any further down
		if(coll.checkBoundariesCollision() != 4){
			enemyY += velocity;
		}
		//Update the location of the enemy's collision rectangle
		coll.update(enemyX, enemyY);
	}
	
	public static void Draw(Texture enemy){
		//Binds the enemy texture
		enemy.bind();
		
		//Draw the enemy's texture
		GL11.glBegin(GL11.GL_QUADS);
		
			GL11.glTexCoord2f(0, 0);  //Top left
			GL11.glVertex2f(enemyX, enemyY);
	
			GL11.glTexCoord2f(1,0);    //Top right
			GL11.glVertex2f(enemyX + enemyWidth, enemyY);
	
			GL11.glTexCoord2f(1, 1); //Bottom right
			GL11.glVertex2f(enemyX + enemyWidth, enemyY + enemyHeight);
	
			GL11.glTexCoord2f(0, 1); //Bottom left
			GL11.glVertex2f(enemyX, enemyY + enemyHeight);
			
		GL11.glEnd();
	}
	
	//Method that calls into the SpriteLoader class and loads the sprite needed for the enemy
	public static Texture getSprite(String path, SpriteLoader spriteLoader){
		spriteLoader.loadSprite(path); 
		return spriteLoader.getSprite();
	}
	
	public static Rectangle getEnemyCollisionRect(){
		return coll.getRect();
	}
	
	//Method that returns the enemy's X coordinate
	public int getX(){
		return enemyX;
	}
	
	//Method that returns the enemy's Y coordinate
	public int getY(){
		return enemyY;
	}
	
	//Method that returns the Y coordinate of the center of the enemy
	public static int getCenter(){
		enemyCenter = enemyY + enemyHeight / 2;
		return enemyCenter;
	}
}
