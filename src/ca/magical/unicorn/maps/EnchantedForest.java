package ca.magical.unicorn.maps;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ca.magical.unicorn.enemies.FlyingDrop;
import ca.magical.unicorn.enemies.Yeti;
import ca.magical.unicorn.objects.CandyCane;
import ca.magical.unicorn.objects.Cookie;
import ca.magical.unicorn.objects.SharpWood;
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
		Cookie cookie = new Cookie(534,358);
		cookieList.add(cookie);
		cookie = new Cookie(1123,386);
		cookieList.add(cookie);
		cookie = new Cookie(1132,421);
		cookieList.add(cookie);
		cookie = new Cookie(2230,422);
		cookieList.add(cookie);
		cookie = new Cookie(2377,422);
		cookieList.add(cookie);
		cookie = new Cookie(2482,422);
		cookieList.add(cookie);
		cookie = new Cookie(3772,422);
		cookieList.add(cookie);
		cookie = new Cookie(3980,422);
		cookieList.add(cookie);
		cookie = new Cookie(4142,422);
		cookieList.add(cookie);
		cookie = new Cookie(4765,422);
		cookieList.add(cookie);
		cookie = new Cookie(4942,422);
		cookieList.add(cookie);
		cookie = new Cookie(5221,422);
		cookieList.add(cookie);
		cookie = new Cookie(5680,422);
		cookieList.add(cookie);
		cookie = new Cookie(6013,422);
		cookieList.add(cookie);
		cookie = new Cookie(6854,386);
		cookieList.add(cookie);
		cookie = new Cookie(7207,386);
		cookieList.add(cookie);
		cookie = new Cookie(4837,557);
		cookieList.add(cookie);
		cookie = new Cookie(4954,557);
		cookieList.add(cookie);
		cookie = new Cookie(5056,557);
		cookieList.add(cookie);
		cookie = new Cookie(5128,557);
		cookieList.add(cookie);
		cookie = new Cookie(5224,557);
		cookieList.add(cookie);
		cookie = new Cookie(5335,557);
		cookieList.add(cookie);
		cookie = new Cookie(17663,557);
		cookieList.add(cookie);
		cookie = new Cookie(17801,557);
		cookieList.add(cookie);
		cookie = new Cookie(17903,557);
		cookieList.add(cookie);
		cookie = new Cookie(18007,557);
		cookieList.add(cookie);
		cookie = new Cookie(18127,557);
		cookieList.add(cookie);cookie = new Cookie(8589,622);
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
		cookie = new Cookie(30383,635);
		cookieList.add(cookie);
		cookie = new Cookie(30544,635);
		cookieList.add(cookie);
		cookie = new Cookie(30644,635);
		cookieList.add(cookie);
		cookie = new Cookie(60744,635);
		cookieList.add(cookie);
		cookie = new Cookie(30844,635);
		cookieList.add(cookie);
		cookie = new Cookie(30944,635);
		cookieList.add(cookie);
		cookie = new Cookie(31044,635);
		cookieList.add(cookie);
		cookie = new Cookie(31144,635);
		cookieList.add(cookie);
		cookie = new Cookie(31244,635);
		cookieList.add(cookie);
		cookie = new Cookie(31244,635);
		cookieList.add(cookie);
		cookie = new Cookie(31344,635);
		cookieList.add(cookie);
		cookie = new Cookie(31444,635);
		cookieList.add(cookie);
		cookie = new Cookie(31544,635);
		cookieList.add(cookie);
		cookie = new Cookie(31644,635);
		cookieList.add(cookie);
		cookie = new Cookie(31744,635);
		cookieList.add(cookie);
		cookie = new Cookie(31844,635);
		cookieList.add(cookie);
		cookie = new Cookie(27248,275);
		cookieList.add(cookie);
		cookie = new Cookie(25273,275);
		cookieList.add(cookie);
		cookie = new Cookie(20879,275);
		cookieList.add(cookie);
		cookie = new Cookie(20447,275);
		cookieList.add(cookie);
		cookie = new Cookie(17221,275);
		cookieList.add(cookie);
		cookie = new Cookie(1547,257);
		cookieList.add(cookie);
		
		
		SharpWood sharpwood = new SharpWood(400,650);
		badObjectList.add(sharpwood);
		sharpwood = new SharpWood(432,650);
		badObjectList.add(sharpwood);
		
		SharpWood sharpwood1 = new SharpWood(2729,650);
		badObjectList.add(sharpwood1);
		sharpwood1 = new SharpWood(2761,650);
		badObjectList.add(sharpwood1);
		
		SharpWood sharpwood2 = new SharpWood(5579,650);
		badObjectList.add(sharpwood2);
		sharpwood2 = new SharpWood(5611,650);
		badObjectList.add(sharpwood2);
		
		SharpWood sharpwood3 = new SharpWood(7352,650);
		badObjectList.add(sharpwood3);
		sharpwood3 = new SharpWood(7384,650);
		badObjectList.add(sharpwood3);
		
		SharpWood sharpwood4 = new SharpWood(12113,650);
		badObjectList.add(sharpwood4);
		sharpwood4 = new SharpWood(12145,650);
		badObjectList.add(sharpwood4);
		
		SharpWood sharpwood5 = new SharpWood(16270,650);
		badObjectList.add(sharpwood5);
		sharpwood5 = new SharpWood(16302,650);
		badObjectList.add(sharpwood5);
		
		SharpWood sharpwood6 = new SharpWood(18563,650);
		badObjectList.add(sharpwood6);
		sharpwood6 = new SharpWood(18595,650);
		badObjectList.add(sharpwood6);
		
		SharpWood sharpwood7 = new SharpWood(25460,650);
		badObjectList.add(sharpwood7);
		sharpwood7 = new SharpWood(25492,650);
		badObjectList.add(sharpwood7);
		
		SharpWood sharpwood8 = new SharpWood(28339,650);
		badObjectList.add(sharpwood8);
		sharpwood8 = new SharpWood(28371,650);
		badObjectList.add(sharpwood8);
		
		SharpWood sharpwood9 = new SharpWood(31775,650);
		badObjectList.add(sharpwood9);
		sharpwood9 = new SharpWood(31807,650);
		badObjectList.add(sharpwood9);
		
		CandyCane candy = new CandyCane(5449,580);
		goodObjectList.add(candy);
		candy = new CandyCane(6938,182);
		goodObjectList.add(candy);
		candy = new CandyCane(10924,362);
		goodObjectList.add(candy);
		candy = new CandyCane(20867,316);
		goodObjectList.add(candy);
		
	}

	@Override
	public void initEnemies() {	
		Yeti yetiti = new Yeti(27776,645);
		yetiList.add(yetiti);
		
		Yeti yetititi = new Yeti(30947,645);
		yetiList.add(yetititi);
		
		Yeti yetitititi = new Yeti(2807,645);
		yetiList.add(yetitititi);
		
		FlyingDrop ghostbliblou = new FlyingDrop(9268,245);
		ghostList.add(ghostbliblou);
		
		FlyingDrop ghost = new FlyingDrop(22085,245);
		ghostList.add(ghost);
		
		FlyingDrop drop = new FlyingDrop(24851,245);
		ghostList.add(drop);
		
		FlyingDrop dropBis = new FlyingDrop(24851,245);
		ghostList.add(dropBis);
		
		this.panda = new PandaLevel2(15575,402);
	}
}
