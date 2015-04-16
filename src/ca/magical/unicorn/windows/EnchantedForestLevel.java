package ca.magical.unicorn.windows;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.camera.Camera;
import ca.magical.unicorn.characters.FatBunny;
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
    	this.character = new FatBunny(145,642); 
    	this.enemy = new Yeti(330,645);
    	this.enemy1 = new FlyingDrop(450,245);
    	//this.panda = new PandaLevel1(1130,602); // debug position depart pandalevel1
    	this.panda = new PandaLevel2(1100,622); //debug position depart panda level2
    	// this.character = new Unicorn(140,575); // debug position d�part licorne
    	this.cam = new Camera(character.getX(), character.getY());
    	this.hud.init();
    	character.initCharacter();
    	enemy.start();
    	enemy1.start();
    }
}
