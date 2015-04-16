package ca.magical.unicorn;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState; 
import org.newdawn.slick.state.StateBasedGame;  

import ca.magical.unicorn.windows.Toune;

public class MenuJeu extends BasicGameState implements ComponentListener {

	  public static final int ID = 1;
	  private Image background;
	  private Image titleGame;
	  private StateBasedGame game;
	  private GameContainer container;
	  private MouseOverArea solo;
	  private MouseOverArea multi;
	  private MouseOverArea quit;
	  private int counter = 1; // compteur pour l'animation de fond
	  private int counter_timer = 0; // timer pour la vitesse de l'animation
	  private int max_timer = 2; // Réglage de la vitesse de l'animation
	  private Toune welcome_song;

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background= new Image("res/menu/menu_animation/1.png");
	    this.titleGame = new Image("res/menu/logo.png");
	    
	    // Démarrer la musique d'acceuil
	    this.welcome_song = new Toune("res/toune/unicorn_song.mp3", true);
	    welcome_song.start();
	    
	    //initialisation des 3 boutons
	    solo = new MouseOverArea(container, new Image("res/menu/solo.png"), 440, 700, this);
	    solo.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	    multi = new MouseOverArea(container, new Image("res/menu/multi.png"), 595, 700,this);
	    multi.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	    quit = new MouseOverArea(container, new Image("res/menu/quit.png"), 760, 700,this);
        quit.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	  }

	  /**
	   * Contenons nous d'afficher l'image de fond. 
	   * Le text est placé approximativement au centre.
	   */
	  @Override
	  public void render(GameContainer container, StateBasedGame game, org.newdawn.slick.Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
		titleGame.draw(500,50);
	    quit.render(container, g);
	    multi.render(container, g);
        solo.render(container, g);
        
	  } 

	  /**
	  * Passer à l’écran de jeu à l'appui de n'importe quel touche.
	  */
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		  String image_char = "res/menu/menu_animation/" + counter + ".png";
		  this.background = new Image(image_char);
		  counter_timer ++;
		  if(counter_timer >= max_timer) {
			  if(counter >= 157) {
				  counter = 1;
			  } else {
				  counter ++;
			  }
			  
			  counter_timer = 0;
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
	  /**
	   * Lorsque l'on clique sur un bouton on charge une nouvelle
	   * interface
	   */
	  @Override
	    public void componentActivated(AbstractComponent source) {
	        if (source == quit)
	        {
	            this.container.exit();
	        }
	       if (source == solo)
	        {
	        	game.enterState(ChoixNiveau.ID);
	        }
	       if (source== multi){
	    	   game.enterState(WindowGame.ID);
	       }
	         
	    }
	  
	}