package ca.magical.unicorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOver extends BasicGameState {

	  public static final int ID = 3;
	  private Image background;
	  private StateBasedGame game;
		private GameContainer container;

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background= new Image("res/map/gameOver.jpg");
	    
	  }

	  /**
	   * Contenons nous d'afficher l'image de fond. 
	   * Le text est plac� approximativement au centre.
	   */
	  @Override
	  public void render(GameContainer container, StateBasedGame game, org.newdawn.slick.Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
	    g.drawString("D�sol�, vous avez perdu \n Retour � la case d�part BITCH.", 700, 700);
	  } 

	  /**
	  * Passer � l��cran de jeu � l'appui de n'importe quel touche.
	  */
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	  @Override
	  public void keyReleased(int key, char c) {
	    switch(key){
	    case Input.KEY_ESCAPE:
			container.exit();
			break;
	    }
	  }

	  /**
	   * L'identifiant permet d'identifier les diff�rentes boucles.
	   * Pour passer de l'une � l'autre.
	   */
	  @Override
	  public int getID() {
	    return ID;
	  }

	
	}