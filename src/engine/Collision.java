package engine;

import org.lwjgl.util.Rectangle;

public class Collision {
	
	Rectangle objectRectangle;
	
	public Collision(){
		
	}
	
	//Mainly updates the x and y coordinate for the rectangle
	public void update(int x, int y){
		objectRectangle.setX(x);
		objectRectangle.setY(y);
	}
	
	//Creates a new Rectangle that will be used to check if a collision happened
	public void newCollisionRect(int ballX, int ballY, int width, int height){
		objectRectangle = new Rectangle();
		objectRectangle.setBounds(ballX, ballY, width, height);
	}
	
	//Checks if the object is colliding with the screen boundaries, Thought is a switch statement is going to be used together with this
	public int checkBoundariesCollision(){
		if(objectRectangle.getX() <= 0 ){
			return 1;
		}
		else if(objectRectangle.getX() + objectRectangle.getWidth() >= GameFrame.WIDTH){
			return 2;
		}
		else if(objectRectangle.getY() <= 0){
			return 3; 
		}
		else if(objectRectangle.getY() + objectRectangle.getHeight() >= GameFrame.HEIGHT){
			return 4;
		}
		return 0; //Didn't collide with any of the screen boundaries
	}
	
	public boolean checkCollision(Rectangle rect){
		
		//Collision between another rectangle was found
		if(objectRectangle.intersects(rect)){
			return true; //Collision was found
		}
		return false;//No collision was found
	}
	
	//Returns the rectangle used for collisions
	public Rectangle getRect(){
		return objectRectangle;
	}
}
