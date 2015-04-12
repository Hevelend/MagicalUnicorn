package ca.magical.unicorn.maps;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class EnchantedForest extends Map {
	
	public EnchantedForest(){
		super();
		try {
			map = new TiledMap("res/map/EnchantedForest.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
