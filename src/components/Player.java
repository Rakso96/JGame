package components;

public class Player {
	
	//The players cordinates X and Y
	public static int playerX = 100;
	public static int playerY = 100;
	
	private float velocity = 2f;
	
	public Player(){
		
	}
	
	public void playerMovingRight(){
		playerX += velocity;
		System.out.println("PLAYER MOVING: " + playerX);
	}
	
	public void playerMovingLeft(){
		
	}
	
	public void playerMovingUp(){
		playerY -= velocity;
	}
	
	public void playerMovingDown(){
		playerY += velocity;
	}
}
