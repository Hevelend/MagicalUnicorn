package ca.magical.unicorn.menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.Game;
import ca.magical.unicorn.windows.CandyWorldLevel;
import ca.magical.unicorn.windows.EnchantedForestLevel;

public class GameOver extends BasicGameState implements ComponentListener {

	  public static final int ID = 3;
	  private Image background;
	  private StateBasedGame game;
	  private GameContainer container;
	  private MouseOverArea retry_b;
	  private MouseOverArea quit;
	  protected boolean first_play = true;
	  private float background_volume = 1F;
	  private Music background_toune;

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.container = container;
	    this.background= new Image("res/menu/gameover.png");
	    
	    retry_b = new MouseOverArea(container, new Image("res/menu/retry.png"), 480, 700, this);
	    retry_b.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	    quit = new MouseOverArea(container, new Image("res/menu/quit.png"), 670, 700, this);
        quit.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
        background_toune = new Music("res/sound/gameover_sound.ogg");
	  }

	  /**
	   * Contenons nous d'afficher l'image de fond. 
	   * Le text est placé approximativement au centre.
	   */
	  @Override
	  public void render(GameContainer container, StateBasedGame game, org.newdawn.slick.Graphics g) throws SlickException {
		  if(first_play) {
			  background_toune.play();
			  background_toune.setVolume(background_volume);
			  first_play = false;
		  }
		  
		  background.draw(0, 0, container.getWidth(), container.getHeight());
		  retry_b.render(container, g);
		  quit.render(container, g);
	  } 

	  /**
	  * Passer à l’écran de jeu à l'appui de n'importe quel touche.
	  */
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	  @Override
	  public void keyReleased(int key, char c) {
	    switch(key){
	    case Input.KEY_ESCAPE:
	    	System.exit(0); // Quitter le jeu
			break;
	    }
	  }

	  /**
	   * L'identifiant permet d'identifier les différentes boucles.
	   * Pour passer de l'une à l'autre.
	   */
	  @Override
	  public int getID() {
	    return ID;
	  }	
	  
	  @Override
	  public void componentActivated(AbstractComponent source) {
			if (source == quit) {
				System.exit(0);
		    } else if(source == retry_b) {
		    	try {
					game.init(container);
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	game.enterState(Game.previous_level);
		    }
	  }	
	}