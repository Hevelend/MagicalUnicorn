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
		Cookie cookie = new Cookie(783,409);
		cookieList.add(cookie);
		cookie = new Cookie(864,376);
		cookieList.add(cookie);
		cookie = new Cookie(943,409);
		cookieList.add(cookie);
		cookie = new Cookie(1611,315);
		cookieList.add(cookie);
		cookie = new Cookie(1825,419);
		cookieList.add(cookie);
		cookie = new Cookie(2640,437);
		cookieList.add(cookie);
		cookie = new Cookie(2652,437);
		cookieList.add(cookie);
		cookie = new Cookie(2749,437);
		cookieList.add(cookie);
		cookie = new Cookie(2843,437);
		cookieList.add(cookie);
		cookie = new Cookie(3159,236);
		cookieList.add(cookie);
		cookie = new Cookie(3257,166);
		cookieList.add(cookie);
		cookie = new Cookie(3448,396);
		cookieList.add(cookie);
		cookie = new Cookie(3729,142);
		cookieList.add(cookie);
		cookie = new Cookie(4039,637);
		cookieList.add(cookie);
		cookie = new Cookie(4297,565);
		cookieList.add(cookie);
		cookie = new Cookie(4853,340);
		cookieList.add(cookie);
		cookie = new Cookie(5194,575);
		cookieList.add(cookie);
		cookie = new Cookie(5337,493);
		cookieList.add(cookie);
		cookie = new Cookie(5525,432);
		cookieList.add(cookie);
		cookie = new Cookie(5763,291);
		cookieList.add(cookie);
		cookie = new Cookie(6248,322);
		cookieList.add(cookie);
		cookie = new Cookie(6319,322);
		cookieList.add(cookie);
		cookie = new Cookie(6522,322);
		cookieList.add(cookie);
		cookie = new Cookie(6938,304);
		cookieList.add(cookie);
		cookie = new Cookie(7096,648);
		cookieList.add(cookie);
		cookie = new Cookie(7209,648);
		cookieList.add(cookie);
		cookie = new Cookie(6349,648);
		cookieList.add(cookie);
		cookie = new Cookie(7645,430);
		cookieList.add(cookie);
		cookie = new Cookie(7976,348);
		cookieList.add(cookie);
		cookie = new Cookie(8138,243);
		cookieList.add(cookie);
		cookie = new Cookie(8213,243);
		cookieList.add(cookie);
		cookie = new Cookie(8444,373);
		cookieList.add(cookie);
		cookie = new Cookie(8873,479);
		cookieList.add(cookie);
		cookie = new Cookie(8589,622);
		cookieList.add(cookie);
		cookie = new Cookie(9182,540);
		cookieList.add(cookie);
		cookie = new Cookie(9464,540);
		cookieList.add(cookie);
		cookie = new Cookie(9328,450);
		cookieList.add(cookie);
		cookie = new Cookie(9673,424);
		cookieList.add(cookie);
		cookie = new Cookie(9811,321);
		cookieList.add(cookie);
		cookie = new Cookie(10447,518);
		cookieList.add(cookie);
		cookie = new Cookie(10866,338);
		cookieList.add(cookie);
		cookie = new Cookie(10984,432);
		cookieList.add(cookie);
		cookie = new Cookie(11360,243);
		cookieList.add(cookie);
		cookie = new Cookie(11493,314);
		cookieList.add(cookie);
		cookie = new Cookie(12262,215);
		cookieList.add(cookie);
		cookie = new Cookie(11881,421);
		cookieList.add(cookie);
		cookie = new Cookie(12238,439);
		cookieList.add(cookie);
		cookie = new Cookie(12471,574);
		cookieList.add(cookie);
		cookie = new Cookie(12882,665);
		cookieList.add(cookie);
		cookie = new Cookie(13084,665);
		cookieList.add(cookie);
		cookie = new Cookie(13425,665);
		cookieList.add(cookie);
		cookie = new Cookie(13326,311);
		cookieList.add(cookie);
		cookie = new Cookie(13033,201);
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
