package ca.magical.unicorn.windows;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.Game;
import ca.magical.unicorn.camera.Camera;
import ca.magical.unicorn.characters.FatBunny;
import ca.magical.unicorn.characters.Unicorn;
import ca.magical.unicorn.enemies.FlyingDrop;
import ca.magical.unicorn.enemies.Yeti;
import ca.magical.unicorn.hud.Hud;
import ca.magical.unicorn.maps.CandyWorld;
import ca.magical.unicorn.maps.Map;
import ca.magical.unicorn.menus.GameOver;
import ca.magical.unicorn.menus.Toune;
import ca.magical.unicorn.menus.WisePanda;
import ca.magical.unicorn.panda.PandaEnigma;
import ca.magical.unicorn.panda.PandaLevel2;

public class WindowGame extends BasicGameState {
	public static final int ID = 2;
	protected StateBasedGame game;
	protected GameContainer container;
	protected Map map;
	protected Unicorn character = null;
	protected FatBunny character2;
	protected Yeti enemy;
	protected PandaLevel2 panda;
	protected FlyingDrop enemy1;
	protected Camera cam;
	protected Hud hud = new Hud();
	protected boolean first_play = true;
	private float background_volume = 0.2F;
	private Music background;
	private boolean check_character2 = false;

	@Override
	public int getID() {
		return ID;
	}
	
	@Override
    public void keyReleased(int key, char c) {
		if(!Game.isMulti) {
			if (!Keyboard.getEventKeyState()) {
				if(!character.isJumping()) {
					if (Keyboard.getEventKey() == Keyboard.KEY_SPACE) {
						if(character.getDirection() == 0) {
			        		character.setOldDirection(0);
							character.setDirection(1);
						} else if(character.getDirection() == 2){
							character.setOldDirection(2);
							character.setDirection(3);
						}
						character.setJumping(true);
						character.setMoving(true);
					} else if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
						container.exit();
					}
					
					if(Keyboard.getEventKey() == Keyboard.KEY_E) {
						game.enterState(WisePanda.ID);
					}
					
					if(Keyboard.getEventKey() == Keyboard.KEY_A || Keyboard.getEventKey() == Keyboard.KEY_D) {
						character.setMoving(false);
					}
				}
			}
		} else {
			if (!Keyboard.getEventKeyState()) {
				// Mouvement joueur 1
				if(!character.isJumping()) {
					if (Keyboard.getEventKey() == Keyboard.KEY_SPACE) {
						if(character.getDirection() == 0) {
			        		character.setOldDirection(0);
							character.setDirection(1);
						} else if(character.getDirection() == 2){
							character.setOldDirection(2);
							character.setDirection(3);
						}
						character.setJumping(true);
						character.setMoving(true);
					} else if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
						container.exit();
					}
					
					if(Keyboard.getEventKey() == Keyboard.KEY_E) {
						if(character.getCookies() >= 40) {
							game.enterState(WisePanda.ID);
						}
					}
					
					if(Keyboard.getEventKey() == Keyboard.KEY_A || Keyboard.getEventKey() == Keyboard.KEY_D) {
						character.setMoving(false);
					}
				}
				
				//Mouvement Joueur 2
				if(!character2.isJumping()) {
					if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
						if(character2.getDirection() == 0) {
							character2.setOldDirection(0);
							character2.setDirection(1);
						} else if(character2.getDirection() == 2){
							character2.setOldDirection(2);
							character2.setDirection(3);
						}
						character2.setJumping(true);
						character2.setMoving(true);
					}
					
					if(Keyboard.getEventKey() == Keyboard.KEY_RCONTROL) {
						if(character.getCookies() >= 40) {
							game.enterState(WisePanda.ID);
						}
					}
					
					if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT || Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
						character2.setMoving(false);
					}
				}
			}
		}
    }
	
	@Override
	public void keyPressed(int key, char c) {
		if(!Game.isMulti) {
			if (Keyboard.getEventKeyState()) {
				if(!character.isJumping()) {
					if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
						character.setDirection(0);
			        	character.setMoving(true);
			        	character.setMoveAfterJump(false);
					} else if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
						character.setDirection(2);
			        	character.setMoving(true);
			        	character.setMoveAfterJump(false);
					}
				}
			}
		} else {
			if (Keyboard.getEventKeyState()) {
				// Mouvement Joueur 1
				if(!character.isJumping()) {
					if (Keyboard.getEventKey() == Keyboard.KEY_A) {
						character.setDirection(0);
			        	character.setMoving(true);
			        	character.setMoveAfterJump(false);
					} else if(Keyboard.getEventKey() == Keyboard.KEY_D) {
						character.setDirection(2);
			        	character.setMoving(true);
			        	character.setMoveAfterJump(false);
					}
				}
				
				// Mouvement Joueur 2
				if(!character2.isJumping()) {
					if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
						character2.setDirection(0);
						character2.setMoving(true);
						character2.setMoveAfterJump(false);
					} else if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
						character2.setDirection(2);
						character2.setMoving(true);
						character2.setMoveAfterJump(false);
					}
				}
			}
		}
	}
	
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	this.container = container;
    	this.game = game;
    	this.map = new CandyWorld(); // On charge la map candyworld
    	
    	this.character = new Unicorn(140,575); // debug position départ licorne
    	if(Game.isMulti) {
    		this.character2 = new FatBunny(145,642); 
    	}
    	
    	this.enemy = new Yeti(330,645);
    	this.enemy1 = new FlyingDrop(450,245);
    	//this.panda = new PandaLevel1(1130,602); // debug position depart pandalevel1
    	this.panda = new PandaLevel2(1100,622); //debug position depart panda level2
    	
    	this.cam = new Camera(character.getX(), character.getY());
    	this.hud.init();
    	
    	character.initCharacter();
    	if(Game.isMulti) {
    		character2.initCharacter();
    	}
    	
    	enemy.start();
    	enemy1.start();
    	background = new Music("res/toune/fluffy_unicorn.ogg");
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	if(first_play) {
       	 	background.loop();
       	 	background.setVolume(background_volume);
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
		if(Game.isMulti) {
			g.drawAnimation(character2.getAnimations()[character2.getDirection() + (character2.isMoving() ? 4 : 0)], character2.getX(), character2.getY());
    	}
		g.drawAnimation(enemy.getAnimations()[enemy.getDirection() + (enemy.isMoving() ? 4 : 0)], enemy.getX(), enemy.getY());
		g.drawAnimation(enemy1.getAnimations()[enemy1.getDirection() + (enemy1.isMoving() ? 4 : 0)], enemy1.getX(), enemy1.getY());
		g.drawAnimation(panda.getAnimations()[panda.getDirection() + (panda.isMoving() ? 4 : 0)], panda.getX(), panda.getY());
		if(Game.isMulti) {
			this.hud.render(g, character.getHealth(), character2.getHealth() ,character.getCookies());
		} else {
			this.hud.render(g, character.getHealth(), 0F, character.getCookies());
		}
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	updateCharacter(delta);
    	enemy.updateEnemy(delta);
    	enemy1.updateEnemy(delta);
		cam.updateCamera(container, character.getX(), character.getY());
		if(Game.isMulti){
			if(character.getHealth() <= 0F || character2.getHealth() <= 0F){
				background.stop();
				game.enterState(GameOver.ID);
			}
		} else {
			if(character.getHealth() <= 0F){
				background.stop();
				game.enterState(GameOver.ID);
			}
		}
    }
    
    private void updateCharacter(int delta) {
    	float futurX = character.getFuturX(delta);
		float futurY = character.getFuturY(delta);
		
    	if (character.isMoving()) {
			boolean collision = isCollision(futurX, futurY);
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
    	
    	if(Game.isMulti) {
    		float futurX_P2 = character2.getFuturX(delta);
			float futurY_P2 = character2.getFuturY(delta);
			
    		if (character2.isMoving()) {
    			check_character2 = true;
    			boolean collision = isCollision(futurX_P2,futurY_P2);
    			if (collision) {
    				if(character2.isJumping()) {
    					character2.setX(character2.getX());
    					character2.setY(character2.getY());
    					character2.setJumping(false);;
    					character2.setMoving(false);
    				} else {
    					character2.setMoving(false);
    				}
    			} else {
    				character2.setX(futurX_P2);
    				character2.setY(futurY_P2);
    				character2.getBox().setCoord(futurX_P2, futurY_P2);
    			}
    			check_character2 = false;
    		}
    	}
    	
    	character.applyEffects(map, character);
    	if(Game.isMulti) {
    		character2.applyEffects(map, character2);
    		character.setCookies(character.getCookies() + character2.getCookies());
    		character2.setCookies(0);
    	}
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
        	if(check_character2) {
        		temp_x = temp_x + this.character2.getWidth();
        	} else {
        		temp_x = temp_x + this.character.getWidth();
        	}
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