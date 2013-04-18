package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private final int playerSizeX = 8;
	private final int playerSizeY = 16;
	
	private String path = "res/sheet.png";
	
	private BufferedImage spriteSheet;
	
	public void loadSpriteSheet(){
		try{
			spriteSheet = ImageIO.read(new File(path));
		}catch(IOException e){
			
		}
	}
	
	public BufferedImage getSprite(int xPos, int yPos, int width, int height){
		//BufferedImage.getSubimage parameters explanation: x = coordinate of the upper left corner, y = coordinate of the upper left corner
		//width = the sprites width, height = sprites height
		return spriteSheet.getSubimage(xPos, yPos, width, height);
	}
}
