package ca.magical.unicorn.enemies;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Hedgehog extends Thread{
	private float x, y; // Position de spawn du personnage
	private int direction = 2, oldDirection = 2; // Orientation du personnage
	private boolean moving = false; // True = Personnage en mouvement
	private Animation[] animations = new Animation[8]; // Taille de l'animation
	private boolean moveAfterJump=false;
	
	public  Hedgehog(float _x, float _y) {
		super();
		this.x = _x;
		this.y = _y;
		try {
			initCharacter();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initFatBunny() throws SlickException {
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/character/FatBunny_SpriteSheet.png", 64, 64);
    	this.animations[0] = loadAnimation(mySpriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(mySpriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(mySpriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(mySpriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(mySpriteSheet, 1, 6, 0);
        this.animations[5] = loadAnimation(mySpriteSheet, 1, 6, 1);
        this.animations[6] = loadAnimation(mySpriteSheet, 1, 6, 2);
        this.animations[7] = loadAnimation(mySpriteSheet, 1, 6, 3);
    }
	
	public void initHedgehog() throws SlickException {
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/enemies/Hedgehog_SpriteSheet.png", 50, 40);
    	this.animations[0] = loadAnimation(mySpriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(mySpriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(mySpriteSheet, 1, 4, 0);
        this.animations[3] = loadAnimation(mySpriteSheet, 1, 4, 1);
    }
	
    public void initCharacter() throws SlickException {
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/character/Unicorn_SpriteSheet.png", 192, 142);
    	this.animations[0] = loadAnimation(mySpriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(mySpriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(mySpriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(mySpriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(mySpriteSheet, 1, 8, 0);
        this.animations[5] = loadAnimation(mySpriteSheet, 1, 8, 1);
        this.animations[6] = loadAnimation(mySpriteSheet, 1, 8, 2);
        this.animations[7] = loadAnimation(mySpriteSheet, 1, 8, 3);
    }
    public Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        
        return animation;
    }
    
    public void run(){
    	while(true){    		
    		try {
    			setMoving(true);
    			setDirection(2);
				Thread.sleep(4000);
				setDirection(0);
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    }
    public void updateEnemy(int delta) {
    	float futurX = getFuturX(delta);
		setX(futurX);
    }
    
    public float getFuturX(int delta) {
        float futurX = this.x;
        switch (this.direction) {
	        case 0: 
	        	futurX = this.x - .2f * delta;
	        	break;
	        case 1: 
	        	futurX = this.x - .08f * delta;
	        	break;
	        case 2: 
	        	futurX = this.x + .2f * delta;
	        	break;
	        case 3: 
	        	futurX = this.x + .08f * delta;
	        	break;
        }
        return futurX;
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
