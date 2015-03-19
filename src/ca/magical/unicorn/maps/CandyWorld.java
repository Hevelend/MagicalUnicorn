package ca.magical.unicorn.maps;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class CandyWorld {
	private TiledMap map;
	
	public CandyWorld(){
		try {
			map = new TiledMap("res/map/CandyWorld.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public TiledMap getMap() {
		return map;
	}
	
	public int getMapWidth(){
		return this.map.getWidth();
	}
	
	public int getMapTiledHeight(){
		return this.map.getWidth();
	}
	
	public int getLayerIndex(){
		return this.map.getLayerIndex("solid");
	}
	
	public int getMapTiledWidth(){
		return this.map.getTileWidth();
	}
	
	public Image getMapTileImage(int x, int y, int layer){
		return this.map.getTileImage(x, y, layer);
	}
	
	public void candyWorldRender(){
		this.map.render(0, 0, 0);
		this.map.render(0, 0, 1);
		this.map.render(0, 0, 2);
	}
}
