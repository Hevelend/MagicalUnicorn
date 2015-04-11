package ca.magical.unicorn.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cookie {
	protected float x, y; // Position de l'objet
	Image cookieFace; // Image du cookie
	
	public Cookie(float _x, float _y) {
		x = _x;
		y = _y;
		try {
			cookieFace = new Image("res/objects/cookie.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void cookieRender(Graphics g) {
		g.drawImage(cookieFace, x, y);
	}
}
