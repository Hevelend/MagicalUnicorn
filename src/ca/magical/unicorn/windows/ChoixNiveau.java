package ca.magical.unicorn.windows;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics; 
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException; 
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState; 
import org.newdawn.slick.state.StateBasedGame;  

import ca.magical.unicorn.WindowGame;

public class ChoixNiveau extends BasicGameState implements ComponentListener {

	  public static final int ID = 5;
	  private Image background;
	  private StateBasedGame game;
	  private GameContainer container;
	  private MouseOverArea niveau1;
	  private MouseOverArea niveau2;

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background= new Image("res/choixniveau/niveau.png");
	    
	    //initialisation des 3 boutons
	    niveau1 = new MouseOverArea(container, new Image("res/choixniveau/niveau1.png"), 440, 700, this);
	    niveau1.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	    niveau2 = new MouseOverArea(container, new Image("res/choixniveau/niveau2.png"), 595, 700,this);
	    niveau2.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	  }

	  /**
	   * Contenons nous d'afficher l'image de fond. 
	   * Le text est placé approximativement au centre.
	   */
	  @Override
	  public void render(GameContainer container, StateBasedGame game, org.newdawn.slick.Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
	    niveau2.render(container, g);
        niveau1.render(container, g);
	  } 

	  /**
	  * Passer à l’écran de jeu à l'appui de n'importe quel touche.
	  */
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }
	  /**
	   * L'identifiant permet d'identifier les différentes boucles.
	   * Pour passer de l'une à l'autre.
	   */
	  @Override
	  public int getID() {
	    return ID;
	  }
	  /**
	   * Lorsque l'on clique sur un bouton on charge une nouvelle
	   * interface
	   */
	  @Override
	    public void componentActivated(AbstractComponent source) {
	        if (source == niveau1)
	        {
	            game.enterState(WindowGame.ID);
	        }
	       if (source == niveau2)
	        {
	        	game.enterState(GameOver.ID);
	        }
	         
	    }	
	  
	}