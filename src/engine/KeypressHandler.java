package engine;

import org.lwjgl.input.Keyboard;

import components.Player;

public class KeypressHandler {
	
	Player player = new Player();
	
	public KeypressHandler(){
		
	}
	
	//Initialize whats going to be used together with the keyhandler
	public void initKeyHandler(){
		
	}
	
	//The update methods called often to see if any keys were pressed
	public void update(){
		while(Keyboard.next()){
			
			//If key escape is down we shut the application down
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				System.exit(0);
			}
			
			/**
			 * CURRENTLY U HAVE TO RAPIDLY PRESS KEY_RIGHT TO MOVE I NEED TO FIX IF U HOLD A BUTTON IT KEEPS MOVING
			 * KEEP IN MIND TO FIX HOLDING 2 BUTTONS TO MOVE AT THE SAME TIME..................
			 */
			
			//else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			else if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
				if(Keyboard.getEventKeyState()){
					System.out.println("KEY DOWN!");
					player.playerMovingRight();
				}
				else{
					System.out.println("KEY RELEASED!");
				}
			}
		}
	}
}
