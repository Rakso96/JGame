package engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import engine.KeypressHandler;
import gfx.Renderer;

public class GameFrame {
	
	//boolean to see if the game should be running
	boolean running;
	
	//The class that we call to update for keypresses
	KeypressHandler keyHandler = new KeypressHandler();
	Renderer renderer = new Renderer();
	
	
	//Constructor
	public GameFrame(){
		running = true;
	}
	
	//Initializes the game Frame
	public void initFrame(){
		try{
			Display.setDisplayMode(new DisplayMode(800, 600)); //sets the resolution in new DisplayMode(int,int)
			Display.setTitle("Dodger 2.0"); //Set title for the frame
			Display.create(); //Initiate the frame
		}
		catch(LWJGLException e){
			
		}
		
		//Initialize the key Handler and whats connected with the keyhandler
		keyHandler.initKeyHandler();
		renderer.initRenderer();
	}
	
	//Updates the game Frame
	public void updateFrame(){
		if(Display.isCloseRequested()){
			closeGame();
		}	
		
		//Update for keypresses
		keyHandler.update();
		
		//Update the renderer that is supposed to draw everything to the screen
		renderer.update();
		
		Display.update();
		Display.sync(60); //Syncs the Display to stay at 60 fps
	}
	
	//Method used in Main to check if the game is still supposed to be running
	public boolean isRunning(){
		
		return running;
	}
	
	//Methond called when its time to close the game
	public void closeGame(){
		running = false;
		Display.destroy(); //Destroy the frame
		System.exit(0);
	}
}
