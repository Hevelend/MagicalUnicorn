package ca.magical.unicorn.windows;

import org.newdawn.slick.GameContainer;
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
import ca.magical.unicorn.panda.PandaLevel2;

public class EnchantedForestLevel extends WindowGame {
	public static final int ID = 22;
	
	@Override
	public int getID() {
		return ID;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	this.container = container;
    	this.game = game;
    	this.map = new EnchantedForest(); // On charge la map candyworld
    	
    	this.character = new Unicorn(140,575); // debug position départ licorne
    	if(Game.isMulti) {
    		this.character2 = new FatBunny(145,642); 
    	}
    	
    	this.cam = new Camera(character.getX(), character.getY());
    	this.hud.init();
    	character.initCharacter();
    }
}
