package components;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class ScoreHolder {
	
	
	static TrueTypeFont font;
	
	public ScoreHolder(){
		
	}
	
	public void LoadFont(){
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("res/visitorFont.ttf");
	 
			Font fontLoad = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			fontLoad = fontLoad.deriveFont(24f); // set font size
			font = new TrueTypeFont(fontLoad, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void DrawText(int x, int y, String text){
		font.drawString(x, y, text, Color.white);
	}
}
