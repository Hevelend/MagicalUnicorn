package ca.magical.unicorn.enemies;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class FlyingDrop extends Enemies{
	
	public FlyingDrop(float _x, float _y) {
		super(_x, _y);
		setTypeEnemy(1);
		
	}

	public void initEnemy() throws SlickException{
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/enemies/FlyingDrop_SpriteSheet.png", 98,108);
    	this.animations[0] = loadAnimation(mySpriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(mySpriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(mySpriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(mySpriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(mySpriteSheet, 1, 4, 0);
        this.animations[5] = loadAnimation(mySpriteSheet, 1, 4, 1);
        this.animations[6] = loadAnimation(mySpriteSheet, 1, 4, 2);
        this.animations[7] = loadAnimation(mySpriteSheet, 1, 4, 3);
    }
	
	
}
