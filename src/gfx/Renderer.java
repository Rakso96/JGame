package gfx;

import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.Texture;

import components.Ball;
import components.Player;

public class Renderer {
	
	SpriteLoader spriteLoader;
	Texture player;
	Texture ball;
	
	private String pathPlayer = "res/PaddleTemp.png";
	private String pathBall = "res/BallTemp.png";
	
	public Renderer(){
		
	}
	
	public void initRenderer(){
		//Initialize OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity(); // Resets any previous projection matrices
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
		GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
		
		spriteLoader = new SpriteLoader();
		player = Player.getSprite(pathPlayer, spriteLoader);
		ball = Ball.getSprite(pathBall, spriteLoader);
	}
	
	public void update(){
		//Cleans the screen from previous draws.
		GL11.glClear( GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT );
		
		//Draws the player to the screen
		Player.Draw(player);
		
		//Draws the ball to the screen
		Ball.Draw(ball);
	}
}
