package ca.magical.unicorn.maps;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class CandyWorld {
	private TiledMap map;
	ArrayList<ColliderCoord> coordList = new ArrayList<>();
	
	public CandyWorld(){
		try {
			map = new TiledMap("res/map/CandyWorld.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < this.getMapTiledHeight(); i ++){
			for(int j = 0; j < this.getMapTiledWidth(); j ++){
				Image tile = this.getMapTileImage((int) j / this.getMapWidth(), (int) i / this.getMapHeight(), this.map.getLayerIndex("solid"));
		        boolean collision = tile != null;
		        if (collision) {
		        	ColliderCoord coord = new ColliderCoord();
		            Color color = tile.getColor((int) j % this.getMapWidth(), (int) i % this.getMapHeight());
		            if(color.getAlpha() > 0) {
		            	coord = new ColliderCoord(j, i, true);
		            	System.out.println("\n PLOOOOOOOOOOOOOOOOOOOP");
		            } else {
		            	coord = new ColliderCoord(j, i, false);
		            	System.out.println("\n PLIIIIIIIIIIIIIIIIIIIP");
		            }
		            coordList.add(coord);
		        }
			}
		}
	}

	public TiledMap getMap() {
		return map;
	}
	
	public int getMapWidth(){
		return this.map.getWidth();
	}
	
	public int getMapHeight(){
		return this.map.getHeight();
	}
	
	public int getMapTiledHeight(){
		return this.map.getTileHeight();
	}
	
	public int getMapLayerIndex(){
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
	
	public boolean isCollision(int x, int y){
		boolean ifCollision = false;
		
		System.out.println("\n");
		System.out.println("------------------------------------------------------------");
		System.out.println("\n");
		for (ColliderCoord coord : coordList) {
			System.out.println("Coord : " + coord.getX() + " / " + coord.getY() + " -> " + coord.isCollider());
			System.out.println("\n");
			if(coord.getX() == x && coord.getY() == y){
				ifCollision = coord.isCollider();
			}
		}
		
		return ifCollision;
	}
}
