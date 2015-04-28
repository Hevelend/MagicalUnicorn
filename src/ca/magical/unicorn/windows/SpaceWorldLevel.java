package ca.magical.unicorn.windows;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.Game;
import ca.magical.unicorn.camera.Camera;
import ca.magical.unicorn.characters.FatBunny;
import ca.magical.unicorn.characters.Unicorn;
import ca.magical.unicorn.enemies.FlyingDrop;
import ca.magical.unicorn.enemies.Yeti;
import ca.magical.unicorn.maps.CandyWorld;
import ca.magical.unicorn.maps.EnchantedForest;
import ca.magical.unicorn.maps.RubyWorld;
import ca.magical.unicorn.maps.SpaceWorld;
import ca.magical.unicorn.online.OnlineMode;
import ca.magical.unicorn.panda.PandaLevel2;

public class SpaceWorldLevel extends WindowGame {
	public static final int ID = 24;
	
	@Override
	public int getID() {
		return ID;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	this.container = container;
    	this.game = game;
    	this.map = new SpaceWorld(); // On charge la map 
    	
    	this.character = new Unicorn(140,455); // debug position d�part licorne
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
    	loadTileMap(); // on cr�e un tableau avec tout les types de tuiles
    }
}
