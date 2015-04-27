package ca.magical.unicorn.windows;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.Game;
import ca.magical.unicorn.camera.Camera;
import ca.magical.unicorn.characters.FatBunny;
import ca.magical.unicorn.characters.Unicorn;
import ca.magical.unicorn.enums.Gravity;
import ca.magical.unicorn.hud.Hud;
import ca.magical.unicorn.maps.CandyWorld;
import ca.magical.unicorn.maps.Map;
import ca.magical.unicorn.menus.GameOver;
import ca.magical.unicorn.menus.WisePanda;
import ca.magical.unicorn.online.OnlineMode;
import ca.magical.unicorn.tile.AirTile;
import ca.magical.unicorn.tile.SolidTile;
import ca.magical.unicorn.tile.Tile;

public class WindowGame extends BasicGameState {
	public static final int 	ID = 2;
	protected StateBasedGame	game;
	protected GameContainer 	container;
	protected Map 				map;
	protected Unicorn 			character = null;
	protected FatBunny 			character2;
	protected Camera 			cam;
	protected Hud 				hud = new Hud();
	protected boolean 			first_play = true;
	private float 				background_volume = 0.2F;
	protected Music 			background;
	private Tile[][] 			tiles;
	
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
						if (character.getDirection() == -1){
							if(character.getOldDirection() == 2 || character.getOldDirection() == 3) {
								character.setOldDirection(2);
								character.setDirection(3);
							} else {
								character.setOldDirection(0);
								character.setDirection(1);
							}
						} else if(character.getDirection() == 0) {
			        		character.setOldDirection(0);
							character.setDirection(1);
						} else if(character.getDirection() == 1){
							character.setOldDirection(1);
							character.setDirection(1);
						} else if(character.getDirection() == 2){
							character.setOldDirection(2);
							character.setDirection(3);
						} else if(character.getDirection() == 3){
							character.setOldDirection(3);
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
					
					if(Keyboard.getEventKey() == Keyboard.KEY_LEFT || Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
						if(character.getDirection() != -1) {
							character.setOldDirection(character.getDirection());
						}
						character.setMoving(false);
						character.setDirection(-1);
					}
				}
			}
		} else {
			if (!Keyboard.getEventKeyState()) {
				// Mouvement joueur 1
				if(!character.isJumping()) {
					if (Keyboard.getEventKey() == Keyboard.KEY_SPACE) {
						if (character.getDirection() == -1){
							if(character.getOldDirection() == 2 || character.getOldDirection() == 3) {
								character.setOldDirection(2);
								character.setDirection(3);
							} else {
								character.setOldDirection(0);
								character.setDirection(1);
							}
						} else if(character.getDirection() == 0) {
			        		character.setOldDirection(0);
							character.setDirection(1);
						} else if(character.getDirection() == 1){
							character.setOldDirection(1);
							character.setDirection(1);
						} else if(character.getDirection() == 2){
							character.setOldDirection(2);
							character.setDirection(3);
						} else if(character.getDirection() == 3){
							character.setOldDirection(3);
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
						if(character.getDirection() != -1) {
							character.setOldDirection(character.getDirection());
						}
						character.setMoving(false);
						character.setDirection(-1);
					}
				}
				
				//Mouvement Joueur 2
				if(!character2.isJumping()) {
					if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
						if (character2.getDirection() == -1){
							if(character2.getOldDirection() == 2 || character2.getOldDirection() == 3) {
								character2.setOldDirection(2);
								character2.setDirection(3);
							} else {
								character2.setOldDirection(0);
								character2.setDirection(1);
							}
						} else if(character2.getDirection() == 0) {
							character2.setOldDirection(0);
							character2.setDirection(1);
						} else if(character2.getDirection() == 1){
							character2.setOldDirection(1);
							character2.setDirection(1);
						} else if(character2.getDirection() == 2){
							character2.setOldDirection(2);
							character2.setDirection(3);
						} else if(character2.getDirection() == 3){
							character2.setOldDirection(3);
							character2.setDirection(3);
						}
						character2.setJumping(true);
						character2.setMoving(true);
					}
					
					if(Keyboard.getEventKey() == Keyboard.KEY_RCONTROL) {
						if(character.getCookies() == 40) {
							game.enterState(WisePanda.ID);
						}
					}
					
					if(Keyboard.getEventKey() == Keyboard.KEY_LEFT || Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
						if(character2.getDirection() != -1) {
							character2.setOldDirection(character2.getDirection());
						}
						character2.setMoving(false);
						character2.setDirection(-1);
					}
				}
			}
		}
    }
	
	@Override
	public void keyPressed(int key, char c) {
		if(!Game.isMulti) {
			if (Keyboard.getEventKeyState()) {
				if(!character.isJumping() && !character.isFalling()) {
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
				if(!character.isJumping() && !character.isFalling()) {
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
				if(!character2.isJumping() && !character.isFalling()) {
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
    	this.character = new Unicorn(140,568); // debug position départ licorne
    	if(Game.isMulti) {
    		this.character2 = new FatBunny(145,642); 
    	}
    	
    	if(Game.onlineMulti) {
    		OnlineMode onlineM = new OnlineMode(false,container,game,this);
    	}
    	
    	this.cam = new Camera(character.getX(), character.getY());
    	this.hud.init();
    	
    	character.initCharacter();
    	if(Game.isMulti) {
    		character2.initCharacter();
    	}
    	map.startThread();
    	background = new Music("res/toune/fluffy_unicorn.ogg");
    	loadTileMap(); // on crée un tableau avec tout les types de tuiles
    }

    protected void loadTileMap() {
		// on cree un tableau contenant toute les tuiles de la carte
    	tiles = new Tile[map.getMapWidth()][map.getMapHeight()];
    	
    	int layerIndex = map.getMapLayerIndex(); // on recupere le calque solid de la map
    	
    	//on affiche une erreur si le calque n'existe pas
    	 if(layerIndex == -1){
             System.err.println("Map does not have the layer \"solid\"");
             System.exit(0);
         }
  
         //on parcourt toute la carte
         for(int x = 0; x < map.getMapWidth(); x++){
             for(int y = 0; y < map.getMapHeight(); y++){
  
                 //on récupère la tuile
                 int tileID = map.getTileID(x, y, layerIndex);
                 
                 Tile tile = null;
                 if(tileID > 0) {
                	 tile = new SolidTile(x,y);
                 } else {
                	 tile = new AirTile(x,y);
                 }
                 tiles[x][y] = tile;
             }
         }
		
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
    	
    	if(character.getDirection() == -1) {
    		g.drawAnimation(character.getAnimations()[character.getOldDirection()], character.getX(), character.getY());
    	} else {
    		g.drawAnimation(character.getAnimations()[character.getDirection() + (character.isMoving() ? 4 : 0)], character.getX(), character.getY());
    	}
    	
//		character.getBox().setGraph(g);
//		character.getBox().boxRender();
    	
		if(Game.isMulti) {
			if(character2.getDirection() == -1) {
	    		g.drawAnimation(character2.getAnimations()[character2.getOldDirection()], character2.getX(), character2.getY());
	    	} else {
	    		g.drawAnimation(character2.getAnimations()[character2.getDirection() + (character2.isMoving() ? 4 : 0)], character2.getX(), character2.getY());
	    	}
		}
		if(Game.isMulti) {
			this.hud.render(g, character.getHealth(), character2.getHealth() ,character.getCookies());
		} else {
			this.hud.render(g, character.getHealth(), 0F, character.getCookies());
		}
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	updateCharacter(delta);
    	map.enemiesUpdate(delta);
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
    
    private void updateCharacter(ca.magical.unicorn.characters.Character charac, int delta) {
    	float futurX = charac.getFuturX(delta);
		float futurY = charac.getFuturY(delta);
		float acceptedX = charac.getX();
		float acceptedY = charac.getY();
		
		List<Gravity> collisions = isCollision(charac, futurX, futurY);
		
		//System.out.println("Direction récupérée: "+ charac.getDirection());
		//System.out.println("Ancienne direction: "+ charac.getOldDirection());
		
		if(collisions.contains(Gravity.LEFT) && collisions.contains(Gravity.DOWN) && charac.getDirection() == -1) {
			collisions = isCollision(charac, futurX + 5, futurY);
		} else if(collisions.contains(Gravity.RIGHT) && collisions.contains(Gravity.DOWN) && charac.getDirection() == -1) {
			collisions = isCollision(charac, futurX - 5, futurY);
		}
		
		if(!charac.isFalling()) {
			charac.setFalling(!collisions.contains(Gravity.DOWN));
		}
		
		if(!charac.isFalling()){
			switch (charac.getDirection()) {
				case -1:
					if(charac.getOldDirection() == 3){
						if (!collisions.contains(Gravity.RIGHT))
							acceptedX = futurX;
					} else if(charac.getOldDirection() == 1){
						if (!collisions.contains(Gravity.LEFT))
							acceptedX = futurX;
						if ((futurY <= acceptedY && !collisions.contains(Gravity.UP)) || (futurY > acceptedY && !collisions.contains(Gravity.DOWN)))
							acceptedY = futurY;
					} else if(charac.getOldDirection() == 0){
						if (!collisions.contains(Gravity.LEFT))
							acceptedX = futurX;
					} else if(charac.getOldDirection() == 2){
						if (!collisions.contains(Gravity.RIGHT))
							acceptedX = futurX;
					}
				break;
				case 0: // Gauche
					if (!collisions.contains(Gravity.LEFT))
						acceptedX = futurX;
					break;
				case 1: // Saut Gauche
					if (!collisions.contains(Gravity.LEFT))
						acceptedX = futurX;
					if ((futurY <= acceptedY && !collisions.contains(Gravity.UP)) || (futurY > acceptedY && !collisions.contains(Gravity.DOWN)))
						acceptedY = futurY;
					break;
				case 2: // Droite
					if (!collisions.contains(Gravity.RIGHT))
						acceptedX = futurX;
					break;
				case 3: // Saut Droite
					if (!collisions.contains(Gravity.RIGHT))
						acceptedX = futurX;
					if ((futurY <= acceptedY && !collisions.contains(Gravity.UP)) || (futurY > acceptedY && !collisions.contains(Gravity.DOWN)))
						acceptedY = futurY;
					break;
			}
		} else {
			if(!collisions.contains(Gravity.DOWN)) {
				acceptedX = futurX;
				acceptedY = futurY;
			} else {
				if(collisions.contains(Gravity.DOWN) && charac.isFalling()) {
					acceptedX = futurX;
					acceptedY = futurY;
					charac.setFalling(false);
					charac.setMoving(false);
				}
			}
		}
		charac.setX(acceptedX);
		charac.setY(acceptedY);
		
		if (futurX == acceptedX || futurY == acceptedY) {
			charac.setMoving(true);
			String tempstring = charac.toString();
	    	tempstring = tempstring.substring(tempstring.length() - 16, tempstring.length() - 9);
	    	if(tempstring.equalsIgnoreCase("Unicorn")) {
	    		charac.getBox().setCoord(futurX, futurY + 10);
	    	} else {
	    		charac.getBox().setCoord(futurX, futurY);
	    	}
		} else {
			charac.setMoving(false);
		}
		
		charac.applyEffects(map, charac);
    }
    
    private void updateCharacter(int delta) {
    	updateCharacter(character, delta);
    	
    	if(Game.isMulti) {
    		updateCharacter(character2, delta);
    		character.setCookies(character.getCookies() + character2.getCookies());
    		character2.setCookies(0);
    	}
    }
    
    private List<Gravity> isCollision(ca.magical.unicorn.characters.Character charac, float x, float y) {    	
    	int minX = (int)(x / 70);
    	int minY = (int)(y / 70);
    	int maxX = (int)((x + charac.getWidth()) / 70);
    	int maxY = (int)((y + charac.getHeight()) / 70);
    	String tempstring = charac.toString();
    	tempstring = tempstring.substring(tempstring.length() - 16, tempstring.length() - 9);
    	if(tempstring.equalsIgnoreCase("Unicorn")) {
        	maxX = (int)((x + charac.getWidth() - 20) / 70);
        	maxY = (int)((y + charac.getHeight() - 25) / 70);
    	}
    	
    	List<Gravity> collisions = new ArrayList<>(4);
    	
    	if (collide(minX, minY, maxX, minY)) {
    		collisions.add(Gravity.UP);
    	}
    	if (collide(minX, minY, minX, maxY-1)) {
    		collisions.add(Gravity.LEFT);
    	}
    	if (collide(maxX, minY, maxX, maxY-1)) {
    		collisions.add(Gravity.RIGHT);
    	}
    	if (collide(minX, maxY, maxX, maxY)) {
    		collisions.add(Gravity.DOWN);
    	}
    	
    	return collisions;
    }
    
    private boolean collide(int minX, int minY, int maxX, int maxY) {
    	for (int x = minX; x <= maxX; x++) {
    		for (int y = minY; y <= maxY; y++) {
    			if (tileCollide(x,y)) return true;
    		}
    	}
    	return false;
    }
    
    private boolean tileCollide(int x, int y) {
    	String tempstring = tiles[x][y].getClass().toString();
        tempstring = tempstring.substring(tempstring.length() - 9, tempstring.length());
        return tempstring.equalsIgnoreCase("SolidTile");
    }
    
    private void gravityEffect() {
    	float bottomY = character.getY() + character.getHeight();
    	float rightX = character.getX() + character.getWidth();
    	
    	String tempstring = tiles[(int) character.getX() / 70][((int) bottomY / 70) + 1].getClass().toString();
        tempstring = tempstring.substring(tempstring.length() - 9, tempstring.length());
        
    	if(!tempstring.equalsIgnoreCase("SolidTile")) {
    		character.setMoving(true);
    		character.setFalling(true);
    	} else {
    		tempstring = tiles[(int) rightX / 70][((int) bottomY / 70) +1].getClass().toString();
            tempstring = tempstring.substring(tempstring.length() - 9, tempstring.length());
            
            if(!tempstring.equalsIgnoreCase("SolidTile")) {
        		character.setMoving(true);
        		character.setFalling(true);
            }
    	}
    }
    
    public Unicorn getFirstPlayer() {
    	return character;
    }
    
    public FatBunny getSecondPlayer() {
    	return character2;
    }
}