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
	
	int mouseX; //Mainly used to get mouse cords for MainMenu
	int mouseY; //Mainly used to get mouse cords for MainMenu
	
	public KeypressHandler(){
		
	}
	
	//Initialize what's going to be used together with the key-handler
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
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				GameFrame.mainMenu = false;
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
		}
		//If the down key is pressed move the player down
		if(moveDown == true){
			player.playerMovingDown();
		}
		
		if(GameFrame.mainMenu == false){
			//Updates the ball (The velocity etc changes)
			ball.updateBall();
			
			//Updates the enemy with the balls position so he knows where to go
			enemy.update(ball.getCenter(), ball.getXVelocity());
		}
	}
	
	/**public int mainMenuUpdate(){ //Method that is used only while the main menu is active
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		if(mouseX > 320 | !(mouseX > 450)){ //Checking if the mouse is inside a "box" of the play button
			if(mouseY > 405 | !(mouseY > 475)){ //Checking if the mouse is inside a "box" of the play button
				if(Mouse.isButtonDown(0) == true){ //Checking if the user clicked the left mouse button
					return 1; //Starts the game
				}
			}
		}
		while (Keyboard.next()){
			if(Keyboard.getEventKey() == Keyboard.KEY_RETURN){
				return 1;
			}
			
			//If key escape is down we shut the application down
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				System.exit(0);
			}
		}
		return 0;
	}**/
	
}
