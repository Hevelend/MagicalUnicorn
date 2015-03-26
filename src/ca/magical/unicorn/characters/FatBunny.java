package ca.magical.unicorn.characters;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class FatBunny {
	private float x, y; // Position de spawn du personnage
	private int direction = 2, oldDirection = 2; // Orientation du personnage
	private boolean moving = false; // True = Personnage en mouvement
	private boolean jumping = false; // True = Personnage saute
	private boolean moveAfterJump = false; // True = la licorne courrais avant le saut
	private int jumpingTimer = 0, decrementTimer = 40; // Temporisation du saut
	private Animation[] animations = new Animation[8]; // Taille de l'animation
	
	
	public FatBunny(float _x, float _y) {
		super();
		this.x = _x;
		this.y = _y;
		
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
    
    public Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        
        return animation;
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
    
    public float getFuturY(int delta) {
        float futurY = this.y;
        if(jumping){
	        if(jumpingTimer < 40 && decrementTimer == 40 ) {
		        if(this.direction == 1 || this.direction == 3) {
		        	futurY = this.y - .2f * delta;
		        	jumpingTimer ++;
		        }
	        } else if(decrementTimer > 0 && jumpingTimer == 40){
	        	if(this.direction == 1 || this.direction == 3) {
		        	futurY = this.y + .2f * delta;
		        	decrementTimer --;
		        }
	        }
	        if(decrementTimer == 0 && jumpingTimer == 40){
	        	jumping = false;
	        	decrementTimer = 40;
	        	jumpingTimer = 0;
	        	letMoving(delta);
	        }
	        this.y += .2f * delta;
        }
        return futurY;
    }
    
    private void letMoving(int delta) {
		if(moving && moveAfterJump){
	    	Robot robot;
			try {
				robot = new Robot();
				if(oldDirection == 2) {
					robot.keyRelease(KeyEvent.VK_RIGHT);
					robot.keyPress(KeyEvent.VK_RIGHT);
				} else {
					robot.keyRelease(KeyEvent.VK_LEFT);
					robot.keyPress(KeyEvent.VK_LEFT);
				}
			} catch (AWTException e) {
				e.printStackTrace();
			}
			moveAfterJump = false;
		}
		moving = false;
    }
    
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
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

	public boolean isJumping() {
		return jumping;
	}
	
	public void setJumping(boolean jumping){
		this.jumping = jumping;
	}
	
	public void setMoveAfterJump(boolean moveAfterJump){
		this.moveAfterJump = moveAfterJump;
	}

	public Animation[] getAnimations() {
		return animations;
	}
    
    public void setOldDirection (int oldDirection){
    	this.oldDirection= oldDirection;
    }

}
