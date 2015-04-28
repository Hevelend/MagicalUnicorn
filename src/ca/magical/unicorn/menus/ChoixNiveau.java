package ca.magical.unicorn.menus;

import java.util.Set;

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
import ca.magical.unicorn.windows.CandyWorldLevel;
import ca.magical.unicorn.windows.EnchantedForestLevel;
import ca.magical.unicorn.windows.RubyWorldLevel;

public class ChoixNiveau extends BasicGameState implements ComponentListener {
	  public static final int ID = 5;
	  private Image background;
	  private StateBasedGame game;
	  private GameContainer container;
	  private MouseOverArea niveau1;
	  private MouseOverArea niveau2;
	  private MouseOverArea niveau3;
	  private MouseOverArea niveau4;
	  private MouseOverArea niveau5;
	  private MouseOverArea return_button;
	  private Toune toune_thread;
	  
	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background= new Image("res/choixniveau/niveau.png");
	    
	    // Récu[érer le Thread de la musique du menu pour l'éteindre une fois le level sélectionné
	    Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
	    Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
	    String temp_var;
	    for (Thread t : threadArray) {
	    	temp_var = t.getClass().toString();
	        if(temp_var.indexOf("Toune") > -1) {
	        	toune_thread = (Toune) t;
	        }
	     }
	    
	    //initialisation des 3 boutons
	    niveau1 = new MouseOverArea(container, new Image("res/choixniveau/niveau0.png"), 260, 425, this);
	    niveau1.setMouseOverColor(new Color(0.7f,0.7f,0.7f,1f));
	    niveau2 = new MouseOverArea(container, new Image("res/choixniveau/niveau2bis.png"), 410,420,this);
	    niveau2.setMouseOverColor(new Color(0.7f,0.7f,0.7f,1f));
	    niveau3 = new MouseOverArea(container, new Image("res/choixniveau/niveau3.png"), 412,531,this);
	    niveau3.setMouseOverColor(new Color(0.7f,0.7f,0.7f,1f));
	    niveau4 = new MouseOverArea(container, new Image("res/choixniveau/niveau4.png"), 610,580,this);
	    niveau4.setMouseOverColor(new Color(0.7f,0.7f,0.7f,1f));
	    niveau5 = new MouseOverArea(container, new Image("res/choixniveau/niveau5.png"), 850,450,this);
	    niveau5.setMouseOverColor(new Color(0.7f,0.7f,0.7f,1f));
	    return_button = new MouseOverArea(container, new Image("res/menu/return.png"), 1150, 700,this);
	    return_button.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	  }

	  /**
	   * Contenons nous d'afficher l'image de fond. 
	   * Le text est placé approximativement au centre.
	   */
	  @Override
	  public void render(GameContainer container, StateBasedGame game, org.newdawn.slick.Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
	    niveau5.render(container, g);
	    niveau4.render(container, g);
	    niveau3.render(container, g);
	    niveau2.render(container, g);
        niveau1.render(container, g);
        return_button.render(container, g);
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
			if (source == niveau1) {
				Game.previous_level = CandyWorldLevel.ID;
			    game.enterState(Game.previous_level);
			    toune_thread.close();
		    } else if(source == niveau2) {
		    	Game.previous_level = EnchantedForestLevel.ID;
			    game.enterState(Game.previous_level);
			    toune_thread.close();
		    }else if(source == niveau3) {
		    	Game.previous_level = EnchantedForestLevel.ID;
			    game.enterState(Game.previous_level);
			    toune_thread.close();
		    } else if(source == niveau4) {
		    	Game.previous_level = RubyWorldLevel.ID;
			    game.enterState(Game.previous_level);
			    toune_thread.close();
		    } else if(source == return_button) {
		    	game.enterState(MenuJeu.ID);
		    }
	  }	
	  
}