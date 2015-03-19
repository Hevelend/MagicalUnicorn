package ca.magical.unicorn;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException; 
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState; 
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class WindowGame extends BasicGameState {
	public static final int ID = 1;
	private GameContainer container;
	private TiledMap map;
	private float x = 140, y = 575; // Position de spawn du personnage
	private int direction = 2, oldDirection = 2; // Orientation du personnage
	private boolean moving = false; // True = Personnage en mouvement
	private boolean jumping = false; // True = Personnage saute
	private boolean moveAfterJump = false; // True = la licorne courrais avant le saut
	private int jumpingTimer = 0, decrementTimer = 40; // Temporisation du saut
	private Animation[] animations = new Animation[8]; // Taille de l'animation
	private float xCamera = x, yCamera = y, oldxCamera = 0;

	@Override
	public int getID() {
		return ID;
	}
	
	@Override
    public void keyReleased(int key, char c) {
		if(!jumping){
		switch (key) {
			case Input.KEY_SPACE: 
	        	if(this.direction == 0) {
	        		oldDirection = 0;
					this.direction = 1;
				} else if(this.direction == 2){
					oldDirection = 2;
					this.direction = 3;
				}
				this.jumping = true;
				this.moving = true;
				break;
			case Input.KEY_ESCAPE:
				container.exit();
				break;
			default:
				this.moving = false;
				moveAfterJump = false;
				break;
		}}
    }
	
	@Override
	public void keyPressed(int key, char c) {
		if(!jumping){
			switch (key) {
		        case Input.KEY_LEFT: 
		        	this.direction = 0;
		        	this.moving = true;
		        	moveAfterJump = true;
		        	break;
		        case Input.KEY_RIGHT: 
		        	this.direction = 2;
			        this.moving = true;
			        moveAfterJump = true;
			        break;
		    }
		}
	}
	
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	this.container = container;
    	this.map = new TiledMap("res/map/CandyWorld.tmx"); // On charge la map
    	SpriteSheet mySpriteSheet = new SpriteSheet("res/character/Unicorn_SpriteSheet.png", 192, 144);
    	this.animations[0] = loadAnimation(mySpriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(mySpriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(mySpriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(mySpriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(mySpriteSheet, 1, 8, 0);
        this.animations[5] = loadAnimation(mySpriteSheet, 1, 8, 1);
        this.animations[6] = loadAnimation(mySpriteSheet, 1, 8, 2);
        this.animations[7] = loadAnimation(mySpriteSheet, 1, 8, 3);
    }
    
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        
        return animation;
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	if(xCamera > container.getWidth() / 3) {
    		if(xCamera < ((this.map.getWidth() - 13) * this.map.getTileWidth())){
    			oldxCamera = 0;
    			g.translate(container.getWidth() / 3 - (int) xCamera, 0);
    		} else {
    			if(oldxCamera == 0){
    				oldxCamera = container.getWidth() / 3 - (int) xCamera;
    			}
    			g.translate(oldxCamera, 0);
    		}
    	}
    	this.map.render(0, 0, 0); // On affiche la map
		this.map.render(0, 0, 1);
		this.map.render(0, 0, 2);
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	updateCharacter(delta);
		updateCamera(container);
    }
    
    private void updateCharacter(int delta) {
    	float futurX = getFuturX(delta);
		float futurY = getFuturY(delta);
		
    	if (this.moving) {
			boolean collision = isCollision(futurX, futurY);
			if (collision) {
				this.moving = false;
			} else {
				this.x = futurX;
				this.y = futurY;
			}
		}
    }
    
    private void updateCamera(GameContainer container) {
    	int w = container.getWidth() / 6;
    	if(this.x - w > 0){ // Permet de ne pas avoir de bande noir
	    	if (this.x > this.xCamera + w) {
				this.xCamera = this.x - w;
			} else if (this.x < this.xCamera - w) {
				this.xCamera = this.x + w;
			}
    	}
    	
		int h = container.getHeight() / 6;
		if(this.y - h > 0) { // Permet de ne pas avoir de bande noir
			if (this.y > this.yCamera + h) {
				this.yCamera = this.y - h;
			} else if (this.y < this.yCamera - h) {
				this.yCamera = this.y + h;
			}
		}
    }
    
    private boolean isCollision(float x, float y) {
        int tileW = this.map.getTileWidth();
        int tileH = this.map.getTileHeight();
        int logicLayer = this.map.getLayerIndex("solid");
        Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
        if (collision) {
            Color color = tile.getColor((int) x % tileW, (int) y % tileH);
            collision = color.getAlpha() > 0;
        }
        return collision;
    }

    private float getFuturY(int delta) {
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
        }
        return futurY;
    }

    private float getFuturX(int delta) {
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
			this.y += .2f * delta;
		}
		moving = false;
    }
}