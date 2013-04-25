package gfx;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class SpriteLoader {
	
	private Texture sprite;
	
	public void loadSprite(String path){
		try{
			sprite = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
		}catch(IOException e){
		}
	}
	
	public Texture getSprite(){
		return sprite;
	}
}
