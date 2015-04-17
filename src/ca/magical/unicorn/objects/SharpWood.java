package ca.magical.unicorn.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import ca.magical.unicorn.characters.Character;

public class SharpWood extends Object {
	private Sound hurt_sound;
	
	public SharpWood(float _x, float _y) {
		super(_x, _y);
		
		Image img = null;
		try {
			img = new Image("res/objects/sharpwood.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		this.setObjectFace(img);
		
		try {
			hurt_sound = new Sound("res/sound/hurt_sound.ogg");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void useEffect(Character player) {
		if(player.getTimerEffect() >= 180) {
			player.playerDamage((float) 0.5);
			player.setTimerEffect();
			hurt_sound.play();
		}
	}
}
