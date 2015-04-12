package ca.magical.unicorn.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ca.magical.unicorn.characters.Character;

public class SharpWood extends Object {
	
	public SharpWood(float _x, float _y) {
		super(_x, _y);
		
		Image img = null;
		try {
			img = new Image("res/objects/sharpwood.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		this.setObjectFace(img);
	}
	
	@Override
	public void useEffect(Character player) {
		if(timerEffect >= 2000) {
			player.playerDamage((float) 0.5);
			timerEffect = 0;
		} else {
			timerEffect ++;
		}
	}
}
