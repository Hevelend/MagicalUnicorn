package ca.magical.unicorn.enemies;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

import ca.magical.unicorn.characters.Character;
import ca.magical.unicorn.collision.Box;

public class Enemies extends Thread{
	private float x, y; // Position de spawn du personnage
	private int direction = 2;// Orientation du personnage
	private boolean moving = false; // True = Personnage en mouvement
	protected Animation[] animations = new Animation[8]; // Taille de l'animation
	protected int typeEnemy=0;
	private Sound hurt_sound;
	protected Box collider; // Boite de collision du cookie
	protected int width = 64, height = 64;
	protected int timerTemp = 0;
	
	public  Enemies(float _x, float _y) {
		super();
		this.x = _x;
		this.y = _y;
		try {
			initEnemy();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			hurt_sound = new Sound("res/sound/hurt_sound.ogg");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		collider = new Box(_x, _y, _x + width, _y + height);
	}

    public void initEnemy() throws SlickException{
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/enemies/Yeti_SpriteSheet.png", 64,64);
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
    
    public void run(){
    	while(true){
			setMoving(true);
			setDirection(2);
			restTime();
			setDirection(0);
			restTime();
    	}
    }
    
    public void restTime(){
    	try {
    		if (getTypeEnemy() == 1) //si c'est FlyingDrop
    			Thread.sleep(5000);
    		else
    			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void updateEnemy(int delta) {
    	float futurX = getFuturX(delta);
		setX(futurX);
		this.collider.setCoord(futurX, this.y);
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
        switch (this.direction) {
	        case 0: 
	        	if(timerTemp > 50) {
	        		futurY = this.y - .05f * delta;
	        	} else {
	        		futurY = this.y + .05f * delta;
	        	}
	        	break;
	        case 2: 
	        	if(timerTemp > 50) {
	        		futurY = this.y + .05f * delta;
	        	} else {
	        		futurY = this.y - .05f * delta;
	        	}
	        	break;
        }
        
        if(timerTemp >= 100) {
        	timerTemp = 0;
        } else {
        	timerTemp ++;
        }
        
        return futurY;
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
	
	public void setY(float _y) {
		this.y = _y;
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
	
	public void setTypeEnemy(int typeEnemy){
		this.typeEnemy = typeEnemy;
	}
	
	public int getTypeEnemy(){
		return typeEnemy;
	}
	
	public Animation renderAnim() {
		return this.getAnimations()[this.getDirection() + (this.isMoving() ? 4 : 0)];
	}
	
	public void useEffect(Character player) {
		if(player.getTimerEffect() >= 180) {
			player.playerDamage((float) 0.5);
			player.setTimerEffect();
			hurt_sound.play();
		}
	}
	
	public Box getBox() {
		return collider;
	}
	
	public void setWidth(int _width) {
		this.width = _width;
	}
	
	public void setHeight(int _height) {
		this.height = _height;
	}
	
	public void setBox(Box _box) {
		this.collider = _box;
	}
	
	public void neonMode() {
    	SpriteSheet mySpriteSheet = null;
		try {
			mySpriteSheet = new SpriteSheet("res/enemies/Yeti_SpriteSheet_neon.png", 64,64);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
