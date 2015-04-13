package ca.magical.unicorn;

import java.awt.Graphics;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class WisePanda extends BasicGameState {

	  public static final int ID = 1;
	  private Image background;
	  private StateBasedGame game;

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background = new Image("res/map/wisepanda.png");
	  }

	  /**
	   * Contenons nous d'afficher l'image de fond. 
	   * Le text est placé approximativement au centre.
	   */
	  @Override
	  public void render(GameContainer container, StateBasedGame game, org.newdawn.slick.Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
	    g.drawString("Appuyez sur la touche correspondant à votre réponse", 700, 700);
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
	    case Input.KEY_NUMPAD1:
	    	break;
	    case Input.KEY_NUMPAD2:
	    	break;
	    case Input.KEY_NUMPAD3:
	    	game.enterState(WindowGame.ID);
	    	break;
	    	default:
	    	//game.enterState(WindowGame.ID);
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

	
	}