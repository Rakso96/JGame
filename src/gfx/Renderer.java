package gfx;

import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.Texture;
import components.Ball;
import components.Enemy;
import components.Player;
import components.ScoreHolder;
import engine.GameFrame;

public class Renderer {
	
	SpriteLoader spriteLoader;
	Texture player;
	Texture ball;
	Texture enemy;
	
	private String pathPlayer = "res/PaddleFinished.png";
	private String pathBall = "res/BallFinished.png";
	private String pathEnemy = "res/EnemyFinished.png";
	public Renderer(){
		
	}
	
	public void initRenderer(){
		//Initialize OpenGL
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH); //The default shade model is smooth http://www.khronos.org/opengles/sdk/1.1/docs/man/glShadeModel.xml        
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);//Clear the transparent color off the screen                
        GL11.glClearDepth(1); //glClearDepth specifies the depth value used by glClear to clear the depth buffer. Values specified by glClearDepth are clamped to the range 0 1 .       
        
        GL11.glEnable(GL11.GL_BLEND); //Used to enable Transparency
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA); //Used to enable Transparency
        
        GL11.glViewport(0,0, GameFrame.WIDTH,GameFrame.HEIGHT);
		GL11.glMatrixMode(GL11.GL_MODELVIEW); // manipulates objects in the world matrix.
		
		GL11.glMatrixMode(GL11.GL_PROJECTION); //Sets the matrix mode to the matrix mode who makes the view frustrum (Stympad)
		GL11.glLoadIdentity(); // Resets any previous projection matrices
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);//manipulates objects in the world matrix.
		
		spriteLoader = new SpriteLoader();
		player = Player.getSprite(pathPlayer, spriteLoader);
		ball = Ball.getSprite(pathBall, spriteLoader);
		enemy = Enemy.getSprite(pathEnemy, spriteLoader);
	}
	
	public void update(){
		//Cleans the screen from previous draws.
		GL11.glClear( GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT );
		if(GameFrame.mainMenu == true){
			ScoreHolder.DrawText(GameFrame.WIDTH / 2 - 90, GameFrame.HEIGHT / 2 - 150, "Pong Rebirth");
			ScoreHolder.DrawText(GameFrame.WIDTH / 2 - 140, GameFrame.HEIGHT / 2 - 50, "Press ENTER to Start!");
		}
		if(GameFrame.mainMenu == false){
			
		//Draws the player to the screen
		Player.Draw(player);
		
		//Draw the enemy to the screen
		Enemy.Draw(enemy);
		
		//Draws the ball to the screen
		Ball.Draw(ball);
		}
	}
}
