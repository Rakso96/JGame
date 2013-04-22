package engine;

import org.lwjgl.input.Keyboard;

import components.Ball;
import components.Enemy;
import components.Player;

public class KeypressHandler {
	
	Player player = new Player();
	Ball ball = new Ball();
	Enemy enemy = new Enemy();
	boolean moveUp; //Boolean used to see if the up button is being held or not
	boolean moveDown; //Boolean used to see if the down button is being held or not
	
	public KeypressHandler(){
		
	}
	
	//Initialize whats going to be used together with the keyhandler
	public void initKeyHandler(){
		//Initiate variables
		moveUp = false; 
		moveDown = false;
	}
	
	//The update methods called often to see if any keys were pressed
	public void update(){
		while(Keyboard.next()){
			
			//If key escape is down we shut the application down
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				System.exit(0);
			}
			
			//If key up was pressed move up to move the player up
			else if(Keyboard.getEventKey() == Keyboard.KEY_UP) {
				if(Keyboard.getEventKeyState()){
					moveUp = true;
				}
				else{
					moveUp = false;
				}
			}
			//If key down was pressed move down to move the player down
			else if(Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
				if(Keyboard.getEventKeyState()){
					moveDown = true;
				}
				else{
					moveDown = false;
				}
			}
		}
		//If the up key is pressed move the player up
		if(moveUp == true){
			player.playerMovingUp();
			enemy.enemyMovingUp(); /////////////////////////////////////////////////
		}
		//If the down key is pressed move the player down
		if(moveDown == true){
			player.playerMovingDown();
			enemy.enemyMovingDown();//////////////////////////////////////////////////
		}
		
		
		//Updates the ball (The velocity etc changes)
		ball.updateBall();
		//Updates the enemy with the balls position so he knows where to go
		enemy.update(ball.getX(), ball.getY());
	}
	
}
