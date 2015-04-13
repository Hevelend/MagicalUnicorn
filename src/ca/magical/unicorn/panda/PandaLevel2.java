package ca.magical.unicorn.panda;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class PandaLevel2 extends PandaEnigma {
	
	public PandaLevel2(float _x, float _y) {
		super(_x, _y);
	}
	
	@Override
	public void initPanda() throws SlickException{
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/WisePanda/WisePandaLevel2.png", 98,93);
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
