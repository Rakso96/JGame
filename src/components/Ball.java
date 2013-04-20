package components;

import engine.GameFrame;
import gfx.SpriteLoader;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Ball {
	
	public static final int ballWidth = 16; // The balls width
	public static final int ballHeight = 16; //the balls height
	
	public static int ballX = GameFrame.WIDTH / 2 - ballWidth / 2; //Makes the ball start in the middle of the screen
	public static int ballY = GameFrame.HEIGHT / 2 - ballHeight / 2; //Makes the ball start in the middle of the screen
	
	public static final int MAXVELY = 10; //The maximum velocity for the Y cordinate
	public static final int velocityX = 5; //The maximum velocity for the X cordinate
	
	//Temporary variables
	public static final int velocityXTemp = 4;
	private boolean test = false;
	
	public Ball(){
		
	}
	
	public void updateBall(){
		//Temporary solution of the ball not going out of the screen
		if(test == false){
			ballX -= velocityXTemp;
		}
		if(test == true){
			ballX += velocityXTemp;
		}
		
		if(ballX <= 0){
			test = true;
		}
		if(ballX + ballWidth >= GameFrame.WIDTH){
			test = false;
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
	
	//Method that calls into the SpriteLoader class and loads the sprite needed for the player
	public static Texture getSprite(String path, SpriteLoader spriteLoader){
		spriteLoader.loadSprite(path); 
		return spriteLoader.getSprite();
	}
}
