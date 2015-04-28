package ca.magical.unicorn.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cookie extends Object {
	
	public Cookie(float _x, float _y) {
		super(_x, _y);
	}
	
	@Override
	public void neonMode() {
		try {
			this.objectFace = new Image("res/objects/cookie_neon.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
