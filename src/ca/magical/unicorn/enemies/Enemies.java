package ca.magical.unicorn.enemies;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Enemies extends Thread{
	private float x, y; // Position de spawn du personnage
	private int direction = 2;// Orientation du personnage
	private boolean moving = false; // True = Personnage en mouvement
	protected Animation[] animations = new Animation[8]; // Taille de l'animation
	protected int typeEnemy=0;
	
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
	public void setTypeEnemy(int typeEnemy){
		this.typeEnemy = typeEnemy;
	}
	public int getTypeEnemy(){
		return typeEnemy;
	}
}
