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
		cookie = new Cookie(638,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(744,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(860,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(3754,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(3889,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(3974,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(4778,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(4904,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(5031,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(5356,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(5507,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(5607,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(7287,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(7655,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(9160,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(8068,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(8856,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(13735,438);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(2125,211);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(2250,211);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(2371,211);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(9766,211);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(9930,211);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(10091,211);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(10520,211);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(13034,211);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(9766,235);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(9930,235);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(10091,235);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(539,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(790,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(950,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(1152,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(1290,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(1535,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(1906,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(2722,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(3040,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(4048,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(5170,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(3224,632);
		cookie.neonMode();
		cookieList.add(cookie);
		cookie = new Cookie(6318,632);
		cookie.neonMode();
		cookieList.add(cookie);
		
		
		
		CandyCane candy = new CandyCane(2280,161);
		candy.neonMode();
		goodObjectList.add(candy);
		candy = new CandyCane(3395,564);
		candy.neonMode();
		goodObjectList.add(candy);
		candy = new CandyCane(7853,340);
		candy.neonMode();
		goodObjectList.add(candy);
		candy = new CandyCane(9893,173);
		candy.neonMode();
		goodObjectList.add(candy);
		candy = new CandyCane(11751,642);
		candy.neonMode();
		goodObjectList.add(candy);
		
		
	}
	
	@Override
	public void initEnemies() {	
		Yeti yetiti = new Yeti(3752,645);
		yetiti.neonMode();
		yetiList.add(yetiti);
		
		FlyingDrop ghostbliblou = new FlyingDrop(7266,308);
		ghostbliblou.neonMode();
		ghostList.add(ghostbliblou);
		
		this.panda = new PandaLevel2(13461,556);
		this.panda.neonMode();
	}
}
