package ca.magical.unicorn.maps;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ca.magical.unicorn.panda.PandaLevel2;

public class EnchantedForest extends Map {
	
	public EnchantedForest(){
		super();
		try {
			map = new TiledMap("res/map/EnchantedForest.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void initObjects() {
		
	}

	@Override
	public void initEnemies() {	
		this.panda = new PandaLevel2(1100,622);
	}
}
