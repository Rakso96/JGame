package components;

import engine.Collision;
import engine.GameFrame;
import gfx.SpriteLoader;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

public class Ball {
	
	public static final int ballWidth = 16; // The balls width
	public static final int ballHeight = 16; //the balls height
	
	public static int ballX = GameFrame.WIDTH / 2 - ballWidth / 2; //Makes the ball start in the middle of the screen
	public static int ballY = GameFrame.HEIGHT / 2 - ballHeight / 2; //Makes the ball start in the middle of the screen
	public int ballCenter; //Used in the method getCenter() to get the Y coordinate of the center of the ball
	
	public static final int MAXVELY = 8; //The maximum velocity for the Y coordinate
	public static final int velocityX = 5; //The maximum velocity for the X coordinate
	
	Collision coll; //The class used to check for collisions
	Rectangle collisionRectangle; //Rectangle used to check for collisions
	
	//Temporary variables
	public static int velocityXTemp = -4; //Negative 4 makes the ball start moving towards the player
	public static int velocityYTemp = 0; //Ball Y velocity makes it stay in center of screen in the start
	public static final int MINVELY = -8;
	
	
	public Ball(){
		initBallRect();
	}
	
	//Initiates the ball rectangle used for collisions
	public void initBallRect(){
		coll = new Collision();
		coll.newCollisionRect(ballX, ballY, ballWidth, ballHeight);
	}
	
	public void updateBall(){
		coll.update(ballX, ballY); //Update the location of the balls collision rectangle
		
		switch(coll.checkBoundariesCollision()){
		case 1: 
			//The Enemy scored a point (AI enemy)
			break;
		
		case 2: 
			//The player scored a point
			break;
			
		case 3:
			//The ball hit the top of the screen, Reverse the Y velocity so it starts falling down
			break;
			
		case 4: 
			//The ball hit the bottom of the screen, Reverse the Y velocity so it starts going up
			break;
		}
		
		checkPaddleCollision(collisionRectangle); // Check if the ball collided with either the players paddle or the enemies paddle
		
		ballX += velocityXTemp; //Adds the velocity to the balls X coordinate
		ballY += velocityYTemp; //Adds the velocity to the balls Y coordinate
	}
	
	//Method to check if the ball collided with a paddle
	public void checkPaddleCollision(Rectangle rect){
		
		//Checks if the ball did collide with the players paddle
		rect = Player.getplayerCollisionRect();
		if(coll.checkCollision(rect) == true){
			velocityXTemp = 4; //Makes the X velocity into positive number so the balls goes the opposite direction of the player
		}
		
		//Checks if the ball did collide with the enemies paddle CODE NEEDS TO BE IMPLEMENTED UNDER THIS COMMENT
	}
	
	public static void Draw(Texture ball){
		//Binds the player texture
		ball.bind();
				
		//Draw the player texture
		GL11.glBegin(GL11.GL_QUADS);
				
			GL11.glTexCoord2f(0, 0);  //Top left
			GL11.glVertex2f(ballX, ballY);
			
			GL11.glTexCoord2f(1,0);    //Top right
			GL11.glVertex2f(ballX + ballWidth, ballY);
		
			GL11.glTexCoord2f(1, 1); //Bottom right
			GL11.glVertex2f(ballX + ballWidth, ballY + ballHeight);
			
			GL11.glTexCoord2f(0, 1); //Bottom left
			GL11.glVertex2f(ballX, ballY + ballHeight);
					
		GL11.glEnd();
	}
	
	//Method that calls into the SpriteLoader class and loads the sprite needed for the player
	public static Texture getSprite(String path, SpriteLoader spriteLoader){
		spriteLoader.loadSprite(path); 
		return spriteLoader.getSprite();
	}
	
	//Method that returns the balls X coordinate
	public int getX(){
		return ballX;
	}
	
	//Method that returns the balls Y coordinate
	public int getY(){
		return ballY;
	}
	
	//Method that returns the Y coordinate of the center of the ball
	public int getCenter(){
		ballCenter = ballY + ballHeight / 2;
		return ballCenter;
	}
}
