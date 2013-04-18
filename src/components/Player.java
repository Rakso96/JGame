package components;

import engine.GameFrame;

public class Player {
	
	//The players cordinates X and Y
	public static int playerX = 50;
	public static int playerY = GameFrame.HEIGHT / 2; //Makes the player start in the middle of the screen
	
	//The velocity of the player (the speed of player movement)
	private float velocity = 5f;
	
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
}
