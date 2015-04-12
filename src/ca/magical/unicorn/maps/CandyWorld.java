package ca.magical.unicorn.maps;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class CandyWorld extends Map {
	
	public CandyWorld(){
		super();
		try {
			map = new TiledMap("res/map/CandyWorld.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
}
