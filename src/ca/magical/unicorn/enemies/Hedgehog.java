package ca.magical.unicorn.enemies;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Hedgehog extends Thread{
	private float x, y; // Position de spawn du personnage
	private int direction = 2, oldDirection = 2; // Orientation du personnage
	private boolean moving = false; // True = Personnage en mouvement
	private Animation[] animations = new Animation[8]; // Taille de l'animation
	
	
	public  Hedgehog(float _x, float _y) {
		super();
		this.x = _x;
		this.y = _y;
	}
	
    public void initHedgehog() throws SlickException {
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/enemies/Hedgehog_SpriteSheet.png", 50, 40);
    	this.animations[0] = loadAnimation(mySpriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(mySpriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(mySpriteSheet, 1, 4, 0);
        this.animations[3] = loadAnimation(mySpriteSheet, 1, 4, 1);
    }
    
    public Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        
        return animation;
    }
    
    public void run(int delta){
    	while(true){
    		int cpt=0;
    		//rightMoving(delta);
	    		/*if (cpt <= 20){
	    		rightMoving(delta);
	    		cpt++;
	    		}
	    		else if(cpt==40){
	    			cpt=0;
	    		}
	    		else{
	    		leftMoving(delta);
	    		cpt++;
	    		}*/
    	}
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
    

    //fonction qui permet à l'IA de bouger à gauche
    private void leftMoving(int delta) {
		if(moving ){
	    	Robot robot;
			try {
				robot = new Robot();
				
					robot.keyRelease(KeyEvent.VK_LEFT);
					robot.keyPress(KeyEvent.VK_LEFT);
				
			} catch (AWTException e) {
				e.printStackTrace();
			}
			this.y += .2f * delta;
		}
		moving = false;
    }
    
    //fonction qui permet à l'IA de bouger à droite
    private void rightMoving(int delta) {
		if(moving ){
	    	Robot robot;
			try {
				robot = new Robot();
				
					robot.keyRelease(KeyEvent.VK_RIGHT);
					robot.keyPress(KeyEvent.VK_RIGHT);
				
			} catch (AWTException e) {
				e.printStackTrace();
			}
			this.y += .2f * delta;
		}
		moving = false;
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
    
    public void setOldDirection (int oldDirection){
    	this.oldDirection= oldDirection;
    }
}
