package gfx;

import java.io.IOException;

import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import components.Ball;
import components.Enemy;
import components.Player;
import engine.GameFrame;

public class Renderer {
	
	SpriteLoader spriteLoader;
	Texture player;
	Texture ball;
	Texture enemy;
	
	private String pathPlayer = "res/PaddleTemp.png";
	private String pathBall = "res/BallTemp.png";
	private String pathEnemy = "res/EnemyTemp.png";
	
	//Temporary----------------------------------------------------------------------------------------------------------------------------------------
	private String background = "res/eightBackground.png";
	Texture backgroundImage;
	
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
		enemy = Enemy.getSprite(pathEnemy, spriteLoader);
		
		//Temporary-------------------------------------------------------------------------------------------------------------------------------------
		try{
			backgroundImage = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(background));
		}catch(IOException e){
			
		}
	}
	
	public void update(){
		//Cleans the screen from previous draws.
		GL11.glClear( GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT );
		
		//TEMP CODE_----------------------------------------------------------------------------------------------------------------------------
		backgroundImage.bind();
		GL11.glBegin(GL11.GL_QUADS);
				
			GL11.glTexCoord2f(0, 0);  //Top left
			GL11.glVertex2f(0, 0);
			
			GL11.glTexCoord2f(1,0);    //Top right
			GL11.glVertex2f( GameFrame.WIDTH + 220, 0);
			
			GL11.glTexCoord2f(1, 1); //Bottom right
			GL11.glVertex2f(GameFrame.WIDTH + 220, GameFrame.HEIGHT + 500);
			
			GL11.glTexCoord2f(0, 1); //Bottom left
			GL11.glVertex2f(0, GameFrame.HEIGHT + 500);
					
		GL11.glEnd();
		
		//Draws the player to the screen
		Player.Draw(player);
		
		//Draw the enemy to the screen
		Enemy.Draw(enemy);
		
		//Draws the ball to the screen
		Ball.Draw(ball);
	}
}
