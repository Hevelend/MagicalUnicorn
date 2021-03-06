package ca.magical.unicorn.characters;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class FatBunny extends Character {
		
	public FatBunny(float _x, float _y) {
		super(_x, _y, 64, 64);
	}
	
	public FatBunny(float _x, float _y, Graphics g) {
		super(_x, _y, 64, 64, g);
	}
	
	@Override
    public void initCharacter() throws SlickException {
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
    
	@Override
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
	        	oldDirection = direction;
	        	direction = -1;
	        	jumping = false;
	        	decrementTimer = 40;
	        	jumpingTimer = 0;
	        }
        } else if (falling) {
        	if(fallingTimer < 20) {
	        	futurY = this.y + .2f * delta;
	        	fallingTimer ++;
	        }
	        if(fallingTimer == 20){
	        	fallingTimer = 0;
	        }
        }
        return futurY;
    }
	
	@Override
	public float getFuturX(int delta) {
		float futurX = this.x;
        switch (this.direction) {
	        case 0: 
	        	if(!this.falling){ 
	        		futurX = this.x - .2f * delta;
	        	}
	        	break;
	        case 1:
	        	if(this.jumping) {
	        		futurX = this.x - .18f * delta;
	        	}
	        	break;
	        case 2:
	        	if(!this.falling){ 
	        		futurX = this.x + .2f * delta;
	        	}
	        	break;
	        case 3: 
	        	if(this.jumping) {
	        		futurX = this.x + .18f * delta;
	        	}
	        	break;
        }
        return futurX;
    }
    
	@Override
    protected void letMoving(int delta) {
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

	@Override
	public void neonMode() {
    	SpriteSheet mySpriteSheet = null;
		try {
			mySpriteSheet = new SpriteSheet("res/character/FatBunny_SpriteSheet_neon.png", 64, 64);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.animations[0] = loadAnimation(mySpriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(mySpriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(mySpriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(mySpriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(mySpriteSheet, 1, 6, 0);
        this.animations[5] = loadAnimation(mySpriteSheet, 1, 6, 1);
        this.animations[6] = loadAnimation(mySpriteSheet, 1, 6, 2);
        this.animations[7] = loadAnimation(mySpriteSheet, 1, 6, 3);
    }
}
