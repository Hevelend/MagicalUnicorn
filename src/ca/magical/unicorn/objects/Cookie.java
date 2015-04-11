package ca.magical.unicorn.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ca.magical.unicorn.collision.Box;

public class Cookie {
	protected float x, y; // Position de l'objet
	Image cookieFace; // Image du cookie
	Box collider; // Boite de collision du cookie
	
	public Cookie(float _x, float _y) {
		x = _x;
		y = _y;
		
		try {
			cookieFace = new Image("res/objects/cookie.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		collider = new Box(_x, _y, cookieFace);
	}
	
	public void cookieRender(Graphics g) {
		g.drawImage(cookieFace, x, y);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public Box getBox() {
		return collider;
	}
}
