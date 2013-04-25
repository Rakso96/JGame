package engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import components.ScoreHolder;

import engine.KeypressHandler;
import gfx.Renderer;

public class GameFrame {
	//The resolution of the game
	public static int HEIGHT = 600;
	public static int WIDTH = 800;
	
	//boolean to see if the game should be running
	boolean running;
	public static boolean mainMenu;
	
	//The class that we call to update for key-presses
	KeypressHandler keyHandler = new KeypressHandler();
	Renderer renderer = new Renderer(); //Class that handles rendering 
	ScoreHolder scoreHolder = new ScoreHolder(); //Class that lets us draw score to the screen
	
	/**
	MainMenu menu; //The main menu of the game
	**/
	
	
	//Constructor
	public GameFrame(){
		running = true;
		mainMenu = true;
	}
	
	//Initializes the game Frame
	public void initFrame(){
		try{
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT)); //sets the resolution in new DisplayMode(int,int)
			Display.setTitle("Pong Rebirth"); //Set title for the frame
			Display.create(); //Initiate the frame
		}
		catch(LWJGLException e){
			
		}
		
		scoreHolder.LoadFont(); //Load the font used to draw text to the screen
		//Initialize the key Handler and what's connected with the key handler
		keyHandler.initKeyHandler();
		renderer.initRenderer(); //Initialize the renderer for the game
		
		/**
		menu = new MainMenu();
		**/
	}
	
	//Updates the game Frame
	public void updateFrame(){
		if(Display.isCloseRequested()){ //Closes the game if you press X in the corner
			closeGame();
		}
		
		//Loop for user browsing the main menu, When he hits play menu.GetFinished returns true and this code will skip and menu will not be displayed anymore
		/**if(menu.getFinished() == false){
			
			menu.updateMenu(keyHandler); //Updates the main menu to check if the user wants to check help section etc etc
			
			Display.update();//Updates the display
			Display.sync(60); //Syncs the fps to 60
		}**/
			//Update for key presses
			keyHandler.update();
			
			//Update the renderer that is supposed to draw everything to the screen
			renderer.update();
			
			Display.update(); //Updates the display
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
