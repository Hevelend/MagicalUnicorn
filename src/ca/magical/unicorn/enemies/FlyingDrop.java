package ca.magical.unicorn.enemies;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import ca.magical.unicorn.collision.Box;

public class FlyingDrop extends Enemies{
	
	public FlyingDrop(float _x, float _y) {
		super(_x, _y);
		setTypeEnemy(1);
		
		setWidth(98);
		setHeight(108);
		Box boxcollide = new Box(_x, _y, _x + width, _y + height);
		this.setBox(boxcollide);
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
	
	@Override
	 public void updateEnemy(int delta) {
    	float futurX = getFuturX(delta);
    	float futurY = getFuturY(delta);
		setX(futurX);
		setY(futurY);
		this.collider.setCoord(futurX, futurY);
    }
}
