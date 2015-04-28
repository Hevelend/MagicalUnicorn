package ca.magical.unicorn.maps;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ca.magical.unicorn.enemies.FlyingDrop;
import ca.magical.unicorn.enemies.Yeti;
import ca.magical.unicorn.objects.CandyCane;
import ca.magical.unicorn.objects.Cookie;
import ca.magical.unicorn.objects.SharpWood;
import ca.magical.unicorn.panda.PandaLevel2;

public class EasterIsland extends Map {
	
	public EasterIsland(){
		super();
		try {
			map = new TiledMap("res/map/EasterIsland2.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initObjects() {
		Cookie cookie = new Cookie(534,358);
		cookie.neonMode();
		cookieList.add(cookie);
		
		CandyCane candy = new CandyCane(5449,580);
		candy.neonMode();
		goodObjectList.add(candy);
	}
	
	@Override
	public void initEnemies() {	
		Yeti yetiti = new Yeti(27776,645);
		yetiti.neonMode();
		yetiList.add(yetiti);
		
		FlyingDrop ghostbliblou = new FlyingDrop(9268,245);
		ghostbliblou.neonMode();
		ghostList.add(ghostbliblou);
		
		this.panda = new PandaLevel2(13461,556);
		this.panda.neonMode();
	}
}
