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
	public static final int MINVELY = -8; //The minimum velocity for the Y coordinate
	public static final int velocityX = 5;  //The velocity for the X coordinate
	public static int velocityY; //The velocity for the Y coordinate, Is not given a number since it will change all the time
	public static final float velReducer = 0.1f;
	
	Collision coll; //The class used to check for collisions
	Rectangle collisionRectangle; //Rectangle used to check for collisions
	
	//Temporary variables
	public static float velocityXTemp = -8; //Negative 4 makes the ball start moving towards the player
	public static float velocityYTemp = 0; //Ball Y velocity makes it stay in center of screen in the start
	
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
			//TEMP CODE///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			reverseX();
			break;
		
		case 2: 
			//The player scored a point
			
			//TEMP CODE///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			reverseX();
			break;
			
		case 3:
			//The ball hit the top of the screen, Reverse the Y velocity so it starts falling down
			velocityYTemp = Math.abs(velocityYTemp); //Using Math.abs to make a negative number positive.
			break;
			
		case 4: 
			//The ball hit the bottom of the screen, Reverse the Y velocity so it starts going up
			velocityYTemp = velocityYTemp - velocityYTemp * 2; //Makes the Y velocity go negative which is up on the screen
			break;
		}
		
		checkPaddleCollision(collisionRectangle); // Check if the ball collided with either the players paddle or the enemies paddle
		
		ballX += velocityXTemp; //Adds the velocity to the balls X coordinate
		ballY += velocityYTemp; //Adds the velocity to the balls Y coordinate
	}
	
	//Method to check if the ball collided with a paddle
	public void checkPaddleCollision(Rectangle rect){
		
		//Checks if the ball did collide with the players paddle
		rect = Player.getPlayerCollisionRect();
		if(coll.checkCollision(rect) == true){
			reverseX(); //Reverses the X velocity
			
			//Emulates the effect of ball moving up if it hits above the center of the paddle vice versa
			velocityYTemp = ((getCenter() - Player.getCenter()) * velReducer);
		}
		
		//Checks if the ball did collide with the enemies paddle
		rect = Enemy.getEnemyCollisionRect();
		if(coll.checkCollision(rect) == true){
			reverseX(); //Reverses the X velocity
			
			//Emulates the effect of ball moving up if it hits above the center of the paddle vice versa
			velocityYTemp = ((getCenter() - Player.getCenter()) * velReducer);
		}
		
		if(velocityYTemp < MINVELY){ //If the velocity Y is less than the minimum set it to the minimum
			velocityYTemp = MINVELY;
		}
		else if(velocityYTemp > MAXVELY){ //If the velocity Y is greater than the maximum set it to the maximum
			velocityYTemp = MAXVELY;
		}
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
	
	//Reverses the X velocity by making a positive number negative and negative number positive
	public void reverseX(){
		if(velocityXTemp == 8){ //If the ball should reverse to going left on the screen
			velocityXTemp = -8;
		}
		else if(velocityXTemp == -8){ //If the ball should reverse to going right on the screen
			velocityXTemp = 8;
		}
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
