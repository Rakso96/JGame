package jGame;

import engine.GameFrame;

public class Main {

	/**
	 * @param args
	 */
	
	GameFrame Frame;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame Frame = new GameFrame(); //the main frame that holds every puzzle peice together
		Frame.initFrame();
		
		//Game loop, Closes when game should close
		while(Frame.isRunning() == true){
			Frame.updateFrame();
		}
	}
}
