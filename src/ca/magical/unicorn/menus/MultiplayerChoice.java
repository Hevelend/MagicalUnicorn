package ca.magical.unicorn.menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException; 
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState; 
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.Game;

public class MultiplayerChoice extends BasicGameState implements ComponentListener {
	  public static final int ID = 6;
	  private Image background;
	  private StateBasedGame game;
	  private MouseOverArea choice1;
	  private MouseOverArea choice2;
	  private MouseOverArea choice3;
	  private GameContainer container;
	  
	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.container = container;
	    this.background= new Image("res/menu/multiplayer.png");
	    	    
	    //initialisation des 3 boutons
	    choice1 = new MouseOverArea(container, new Image("res/menu/local.png"), 440, 700, this);
	    choice1.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	    choice2 = new MouseOverArea(container, new Image("res/menu/online.png"), 595, 700,this);
	    choice2.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	    choice3 = new MouseOverArea(container, new Image("res/menu/return.png"), 774, 700,this);
	    choice3.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	  }

	  /**
	   * Contenons nous d'afficher l'image de fond. 
	   * Le text est placé approximativement au centre.
	   */
	  @Override
	  public void render(GameContainer container, StateBasedGame game, org.newdawn.slick.Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
	    choice1.render(container, g);
	    choice2.render(container, g);
	    choice3.render(container, g);
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
			if (source == choice1 || source == choice2) {
				Game.isMulti = true;
				
				if(source == choice2){
					Game.onlineMulti = true;
				}
				
				try {
					game.init(container);
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				game.enterState(ChoixNiveau.ID);
		    }  else if (source == choice3) {
		    	game.enterState(MenuJeu.ID);
		    }
	    }	
	  
	}