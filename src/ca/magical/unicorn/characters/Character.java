package ca.magical.unicorn.characters;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import ca.magical.unicorn.collision.Box;
import ca.magical.unicorn.maps.Map;

public class Character {
	protected float				 x, y; // Position de spawn du personnage
	protected int				direction = -1, oldDirection = 2; // Orientation du personnage
	protected boolean 			moving = false; // True = Personnage en mouvement
	protected boolean 			jumping = false; // True = Personnage saute
	protected boolean 			moveAfterJump = false; // True = la licorne courrais avant le saut
	protected int 				jumpingTimer = 0, decrementTimer = 40; // Temporisation du saut
	protected int				fallingTimer = 20, decrementFallingTimer = 20; // Temporisation falling
	protected Animation[] 		animations = new Animation[8]; // Taille de l'animation
	protected float 			Health = 3; // Vie du joueur
	protected int 				NBCookies = 0; // Nombre de cookies du joueur
	protected Box 				collider; // Boite de collision
	protected int 				width = 192, height = 142; // Dimensions de l'image
	protected boolean 			passProcess = false; // Eviter certains traitement inutile
	protected float 			timerEffect = 180;
	private boolean 			falling = false; // True = Personnage tombe
	
	public Character(float _x, float _y) {
		super();
		this.x = _x;
		this.y = _y;
		collider = new Box(_x, _y, _x + width, _y + height);
	}
	
	public Character(float _x, float _y, int _width, int _height) {
		super();
		this.x = _x;
		this.y = _y;
		this.width = _width;
		this.height = _height;
		collider = new Box(_x, _y, _x + width, _y + height);
	}
	
	public Character(float _x, float _y, int _width, int _height, Graphics g) {
		super();
		this.x = _x;
		this.y = _y;
		this.width = _width;
		this.height = _height;
		collider = new Box(_x, _y, _x + width, _y + height, g);
	}
	
	public Character(float _x, float _y, Graphics g) {
		super(); 
		this.x = _x;
		this.y = _y;
		collider = new Box(_x, _y, _x + width, _y + height, g);
	}
	
    public void initCharacter() throws SlickException {
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/character/Unicorn_SpriteSheet.png", width, height);
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
    
    protected void letMoving(int delta) {
//		if(moving && moveAfterJump){
//	    	Robot robot;
//			try {
//				robot = new Robot();
//				if(oldDirection == 2) {
//					robot.keyRelease(KeyEvent.VK_RIGHT);
//					robot.keyPress(KeyEvent.VK_RIGHT);
//				} else {
//					robot.keyRelease(KeyEvent.VK_LEFT);
//					robot.keyPress(KeyEvent.VK_LEFT);
//				}
//			} catch (AWTException e) {
//				e.printStackTrace();
//			}
//			moveAfterJump = false;
//			this.y += .2f * delta;
//		}
//		moving = false;
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
	
	public boolean isFalling() {
		return falling;
	}
	
	public void setFalling(boolean falling){
		this.falling = falling;
	}
	
	public void setMoveAfterJump(boolean moveAfterJump){
		this.moveAfterJump = moveAfterJump;
	}

	public Animation[] getAnimations() {
		return animations;
	}
	
	public int getOldDirection() {
		return this.oldDirection;
	}
    
    public void setOldDirection (int oldDirection){
    	this.oldDirection= oldDirection;
    }

    public float getHealth(){
    	return this.Health;
    }
    
    public void playerDamage(float damage){
    	Health = Health - damage;
    }
    
    public void playerCare(float care){
    	Health = Health + care;
    }
    
    public int getCookies(){
    	return this.NBCookies;
    }
    
    public void addCookies(){
    	NBCookies ++;
    }
    
    public void setCookies(int _nbCookies){
    	NBCookies = _nbCookies;
    }
    
    public Box getBox() {
    	return collider;
    }
    
    public void setBox(Box _collider) {
    	collider = _collider;
    }
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
    public void setWidth(int _width) {
    	width = _width;
    }
    
    public void setHeight(int _height) {
    	height = _height;
    }
    
    public void applyEffects(Map map, Character player) {
    	for (int i = 0; i < map.getCookieList().size(); i++) {
    		if(map.getCookieList().get(i).getBox().collide(player.getBox())){
    			map.getCookieList().get(i).useEffect(player);
    			map.getCookieList().remove(i);
    			i = map.getCookieList().size();
    			passProcess = true;
    		}
		}
    	
    	if(!passProcess){
    		for (int j = 0; j < map.getBadObjectList().size(); j++) {
	    		if(map.getBadObjectList().get(j).getBox().collide(player.getBox())){
	    			map.getBadObjectList().get(j).useEffect(player);
	    			j = map.getBadObjectList().size();
	    			passProcess = true;
	    		}
    		}
		}
    	if(!passProcess){
    		for (int l = 0; l < map.getGhostList().size(); l++) {
	    		if(map.getGhostList().get(l).getBox().collide(player.getBox())){
	    			map.getGhostList().get(l).useEffect(player);
	    			l = map.getGhostList().size();
	    			passProcess = true;
	    		}
    		}
		}
    	
    	if(!passProcess){
    		for (int m = 0; m < map.getYetiList().size(); m++) {
	    		if(map.getYetiList().get(m).getBox().collide(player.getBox())){
	    			map.getYetiList().get(m).useEffect(player);
	    			m = map.getYetiList().size();
	    			passProcess = true;
	    		}
    		}
		}
    	if(!passProcess) {
    		for (int k = 0; k < map.getGoodObjectList().size(); k++) {
	    		if(map.getGoodObjectList().get(k).getBox().collide(player.getBox())){
	    			map.getGoodObjectList().get(k).useEffect(player);
	    			map.getGoodObjectList().remove(k);
	    			k = map.getGoodObjectList().size();
	    		}
    		}
		}
    	
    	passProcess = false;
    	this.addTimeEffect();
    }
    
    public float getTimerEffect() {
    	return this.timerEffect;
    }
    
    public void setTimerEffect() {
    	this.timerEffect = 0;
    }
    
    public void addTimeEffect() {
    	this.timerEffect ++;
    }
}
