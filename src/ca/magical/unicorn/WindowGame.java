package ca.magical.unicorn;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.camera.Camera;
import ca.magical.unicorn.characters.FatBunny;
import ca.magical.unicorn.characters.Unicorn;
import ca.magical.unicorn.hud.Hud;
import ca.magical.unicorn.maps.CandyWorld;
import ca.magical.unicorn.objects.Cookie;

public class WindowGame extends BasicGameState {
	public static final int ID = 1;
	private GameContainer container;
	private CandyWorld map;
	//private Unicorn character;
	private FatBunny character;
	private Camera cam;
	private Hud hud = new Hud();

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
    	this.map = new CandyWorld(); // On charge la map candyworld
    	this.character = new FatBunny(145,642); 
    	// this.character = new Unicorn(140,575); // debug position départ licorne
    	this.cam = new Camera(character.getX(), character.getY());
    	this.hud.init();
    	character.initCharacter();
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
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
		this.hud.render(g, character.getHealth(), character.getCookies());
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	updateCharacter(delta);
		cam.updateCamera(container, character.getX(), character.getY());
    }
    
    private void updateCharacter(int delta) {
    	float futurX = character.getFuturX(delta);
		float futurY = character.getFuturY(delta);
		
    	if (character.isMoving()) {
			boolean collision = isCollision(futurX,futurY);
			if (collision) {
				character.setMoving(false);;
			} else {
				character.setX(futurX);
				character.setY(futurY);
				character.getBox().setCoord(futurX, futurY);
			}
		}
    	
    	character.eatCookies(map, character);
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