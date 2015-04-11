package ca.magical.unicorn.maps;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ca.magical.unicorn.objects.Cookie;

public class Map {
	protected TiledMap map;
	protected ArrayList<Cookie> cookieList = new ArrayList<>();
	
	public Map(){
		try {
			map = new TiledMap("res/map/CandyWorld.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		initObjects();
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
	
	public void candyWorldRender(Graphics g) throws SlickException{
		this.map.render(0, 0, 0);
		this.map.render(0, 0, 1);
		this.map.render(0, 0, 2);
		
		for (int i = 0; i < cookieList.size(); i++) {
			cookieList.get(i).cookieRender(g);
		}
	}
	
	public void initObjects() {
		Cookie cookie = new Cookie(200,550);
		cookieList.add(cookie);
		cookie = new Cookie(500,580);
		cookieList.add(cookie);
	}
	
	public ArrayList<Cookie> getCookieList() {
		return cookieList;
	}
	
	public void setCookieList(ArrayList<Cookie> _cookieList) {
		cookieList = _cookieList;
	}
}
