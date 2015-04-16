package ca.magical.unicorn.windows;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.camera.Camera;
import ca.magical.unicorn.characters.FatBunny;
import ca.magical.unicorn.characters.Unicorn;
import ca.magical.unicorn.enemies.FlyingDrop;
import ca.magical.unicorn.enemies.Yeti;
import ca.magical.unicorn.hud.Hud;
import ca.magical.unicorn.maps.CandyWorld;
import ca.magical.unicorn.maps.Map;
import ca.magical.unicorn.menus.Toune;
import ca.magical.unicorn.menus.WisePanda;
import ca.magical.unicorn.panda.PandaEnigma;
import ca.magical.unicorn.panda.PandaLevel2;

public class WindowGame extends BasicGameState {
	public static final int ID = 2;
	protected StateBasedGame game;
	protected GameContainer container;
	protected Map map;
	//protected Unicorn character;
	protected FatBunny character;
	protected Yeti enemy;
	protected PandaLevel2 panda;
	protected FlyingDrop enemy1;
	protected Camera cam;
	protected Hud hud = new Hud();
	protected boolean first_play = true;

	@Override
	public int getID() {
		return ID;
	}
	
	@Override
    public void keyReleased(int key, char c) {
		if(!character.isJumping()){
		switch (key) {
			case Input.KEY_SPACE: 
	        	if(character.getDirection() == 0) {
	        		character.setOldDirection(0);
					character.setDirection(1);
				} else if(character.getDirection() == 2){
					character.setOldDirection(2);
					character.setDirection(3);
				}
				character.setJumping(true);
				character.setMoving(true);
				break;
			case Input.KEY_ESCAPE:
				container.exit();
				break;
			case Input.KEY_E:
				if(character.getCookies() == 40) {
					game.enterState(WisePanda.ID);
				}
			default:
				character.setMoving(false);
				character.setMoveAfterJump(false);
				break;
		}}
    }
	
	@Override
	public void keyPressed(int key, char c) {
		if(!character.isJumping()){
			switch (key) {
		        case Input.KEY_LEFT: 
		        	character.setDirection(0);
		        	character.setMoving(true);
		        	character.setMoveAfterJump(true);
		        	break;
		        case Input.KEY_RIGHT: 
		        	character.setDirection(2);
		        	character.setMoving(true);
		        	character.setMoveAfterJump(true);
			        break;
		    }
		}
	}
	
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	this.container = container;
    	this.game = game;
    	this.map = new CandyWorld(); // On charge la map candyworld
    	this.character = new FatBunny(145,642); 
    	this.enemy = new Yeti(330,645);
    	this.enemy1 = new FlyingDrop(450,245);
    	//this.panda = new PandaLevel1(1130,602); // debug position depart pandalevel1
    	this.panda = new PandaLevel2(1100,622); //debug position depart panda level2
    	// this.character = new Unicorn(140,575); // debug position départ licorne
    	this.cam = new Camera(character.getX(), character.getY());
    	this.hud.init();
    	character.initCharacter();
    	enemy.start();
    	enemy1.start();
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	if(first_play) {
    		Music background = new Music("res/toune/space_unicorn.ogg");
       	 	background.loop();
       	 first_play = false;
    	}
    	
    	if(cam.getxCamera() > container.getWidth() / 3) {
    		if(cam.getxCamera() < ((map.getMapWidth() - 13) * this.map.getMapTiledWidth())){
    			cam.setOldxCamera(0);
    			g.translate(container.getWidth() / 3 - (int) cam.getxCamera(), 0);
    		} else {
    			if(cam.getOldxCamera() == 0){
    				cam.setOldxCamera(container.getWidth() / 3 - (int) cam.getxCamera());
    			}
    			g.translate(cam.getOldxCamera(), 0);
    		}
    	}
    	map.candyWorldRender(g);
		g.drawAnimation(character.getAnimations()[character.getDirection() + (character.isMoving() ? 4 : 0)], character.getX(), character.getY());
		g.drawAnimation(enemy.getAnimations()[enemy.getDirection() + (enemy.isMoving() ? 4 : 0)], enemy.getX(), enemy.getY());
		g.drawAnimation(enemy1.getAnimations()[enemy1.getDirection() + (enemy1.isMoving() ? 4 : 0)], enemy1.getX(), enemy1.getY());
		g.drawAnimation(panda.getAnimations()[panda.getDirection() + (panda.isMoving() ? 4 : 0)], panda.getX(), panda.getY());
		this.hud.render(g, character.getHealth(), character.getCookies());
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	updateCharacter(delta);
    	enemy.updateEnemy(delta);
    	enemy1.updateEnemy(delta);
		cam.updateCamera(container, character.getX(), character.getY());
    }
    
    private void updateCharacter(int delta) {
    	float futurX = character.getFuturX(delta);
		float futurY = character.getFuturY(delta);
		
    	if (character.isMoving()) {
			boolean collision = isCollision(futurX,futurY);
			if (collision) {
				if(character.isJumping()) {
					character.setX(character.getX());
					character.setY(character.getY());
					character.setJumping(false);;
					character.setMoving(false);
				} else {
					character.setMoving(false);
				}
			} else {
				character.setX(futurX);
				character.setY(futurY);
				character.getBox().setCoord(futurX, futurY);
			}
		}
    	
    	character.applyEffects(map, character);
    }
    
    private boolean isCollision(float x, float y) {
        int tileW = map.getMapTiledWidth();
        int tileH = map.getMapTiledHeight();
        int logicLayer = map.getMapLayerIndex();
        float temp_x = x;
        float temp_y = y;
        
        Image tile = this.map.getMapTileImage((int) temp_x / tileW, (int) temp_y / tileH, logicLayer);
        boolean collision = tile != null;
        if (collision) {
            Color color = tile.getColor((int) temp_x % tileW, (int) temp_y % tileH);
            if(color.getBlue() > 0 && color.getRed() > 0 && color.getGreen() > 0) {
            	collision = true;
            }
        } else {
        	temp_x = temp_x + this.character.getWidth();
        	tile = this.map.getMapTileImage((int) temp_x / tileW, (int) temp_y / tileH, logicLayer);
            collision = tile != null;
            if (collision) {
                Color color = tile.getColor((int) temp_x % tileW, (int) temp_y % tileH);
                if(color.getBlue() > 0 && color.getRed() > 0 && color.getGreen() > 0) {
                	collision = true;
                }
            }
        }
        
        return collision;
    }
}