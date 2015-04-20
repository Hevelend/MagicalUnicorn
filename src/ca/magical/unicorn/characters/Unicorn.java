package ca.magical.unicorn.characters;

import ca.magical.unicorn.collision.Box;

public class Unicorn extends Character {
	
	public Unicorn(float _x, float _y) {
		super(_x, _y);
		this.getBox().setWidth(this.getBox().getWidth() - 20);
		this.getBox().setHeight(this.getBox().getHeight() - 15);
	}
	
}
