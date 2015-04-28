package ca.magical.unicorn.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ca.magical.unicorn.characters.Character;

public class CandyCane extends Object {

	public CandyCane(float _x, float _y) {
		super(_x, _y);
		
		Image img = null;
		try {
			img = new Image("res/objects/candycane.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		this.setObjectFace(img);
	}
	
	@Override
	public void useEffect(Character player) {
		player.playerCare((float) 0.5);
	}
}
