package ca.magical.unicorn.panda;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class PandaEnigma {
	private float x, y; // Position de spawn du personnage
	protected Animation[] animations = new Animation[8]; // Taille de l'animation
	private int direction = 0;// Orientation du personnage
	private boolean moving = false; // True = Personnage en mouvement
	
	public  PandaEnigma(float _x, float _y) {
		super();
		this.x = _x;
		this.y = _y;
		try {
			initPanda();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

    public void initPanda() throws SlickException{
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/WisePanda/WisePandaLevel1.png", 63,100);
    	this.animations[0] = loadAnimation(mySpriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(mySpriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(mySpriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(mySpriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(mySpriteSheet, 1, 4, 0);
        this.animations[5] = loadAnimation(mySpriteSheet, 1, 4, 1);
        this.animations[6] = loadAnimation(mySpriteSheet, 1, 4, 2);
        this.animations[7] = loadAnimation(mySpriteSheet, 1, 4, 3);
    }
    public Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        
        return animation;
    }
    public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	public void setX(float x) {
		this.x = x;
	}

	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}
	
	public void setMoving(boolean moving){
		this.moving = moving;
	}


	public Animation[] getAnimations() {
		return animations;
	}
}
