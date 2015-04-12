package ca.magical.unicorn.maps;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ca.magical.unicorn.objects.CandyCane;
import ca.magical.unicorn.objects.Cookie;
import ca.magical.unicorn.objects.SharpWood;
import ca.magical.unicorn.objects.Object;

public class Map {
	protected TiledMap map;
	protected ArrayList<Cookie> cookieList = new ArrayList<>();
	protected ArrayList<Object> badObjectList = new ArrayList<>();
	protected ArrayList<Object> goodObjectList = new ArrayList<>();
	
	public Map(){		
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
			cookieList.get(i).objectRender(g);
		}
		
		for (int j = 0; j < badObjectList.size(); j++) {
			badObjectList.get(j).objectRender(g);
		}
		
		for (int k = 0; k < goodObjectList.size(); k++) {
			goodObjectList.get(k).objectRender(g);
		}
	}
	
	public void initObjects() {
		Cookie cookie = new Cookie(200,550);
		cookieList.add(cookie);
		cookie = new Cookie(500,580);
		cookieList.add(cookie);
		
		SharpWood sharpwood = new SharpWood(400,650);
		badObjectList.add(sharpwood);
		sharpwood = new SharpWood(432,650);
		badObjectList.add(sharpwood);
		
		CandyCane candy = new CandyCane(700,580);
		goodObjectList.add(candy);
		candy = new CandyCane(780,600);
		goodObjectList.add(candy);
	}
	
	public ArrayList<Cookie> getCookieList() {
		return cookieList;
	}
	
	public ArrayList<Object> getBadObjectList() {
		return badObjectList;
	}
	
	public ArrayList<Object> getGoodObjectList() {
		return goodObjectList;
	}
	
	public void setCookieList(ArrayList<Cookie> _cookieList) {
		cookieList = _cookieList;
	}
}
