package ca.magical.unicorn.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import ca.magical.unicorn.collision.Box;
import ca.magical.unicorn.characters.Character;

public class Object {
	protected float x, y; // Position de l'objet
	protected Image objectFace; // Image du cookie
	protected Box collider; // Boite de collision du cookie
	protected Graphics graph;
	protected float timerEffect; // timer pour les dégâts
	
	public Object(float _x, float _y) {
		x = _x;
		y = _y;
		
		try {
			objectFace = new Image("res/objects/cookie.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		collider = new Box(_x, _y, objectFace);
	}
	
	public void objectRender(Graphics g) {
		g.drawImage(objectFace, x, y);
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
	
	public void setObjectFace(Image img) {
		objectFace = img;
		collider = new Box(this.x, this.y, img);
	}
	
	public void useEffect(Character player) {
		player.addCookies();
	}
	
	public void setGraph(Graphics g) {
		graph = g;
	}
	
	public void neonMode() {
		
	}
}
