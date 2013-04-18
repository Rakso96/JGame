package gfx;

import org.lwjgl.opengl.*;

import components.Player;

public class Renderer {
	
	//Integers used for player cordinates, Taken from player class by using Static variables
	int playerX;
	int playerY;
	
	public Renderer(){
		
	}
	
	public void initRenderer(){
		//Initialize opengl
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity(); // Resets any previous projection matrices
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	public void update(){
		GL11.glClear( GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT );
		
		playerX = Player.playerX;
		playerY = Player.playerY;
		
		//Draw a square used temporary as the player
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2i(playerX, playerY); //Top left 
			GL11.glVertex2i(playerX + 50, playerY); // Top right
			GL11.glVertex2i(playerX + 50, playerY + 50); // bottom right
			GL11.glVertex2i(playerX, playerY + 50); // bottom left
		GL11.glEnd();
	}
}
