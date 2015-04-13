package ca.magical.unicorn;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.panda.Enigme;

public class WisePanda extends BasicGameState {

	  public static final int ID = 1;
	  private Image background;
	  private StateBasedGame game;
	  private ArrayList<Enigme> alEnigmes;
	  private int enigmeAleatoire;

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    
	    
	    Enigme enigme1 = new Enigme("res/Enigmes/EnigmePanda1.png",3);
	    Enigme enigme2 = new Enigme("res/Enigmes/EnigmePanda2.png",1);
	    // Enigme enigme2 = new Enigme("",1);
	    
	    this.alEnigmes = new ArrayList<Enigme>();
	    this.alEnigmes.add(enigme1);
	    this.alEnigmes.add(enigme2);
	    
	    Random rand = new Random();
	    this.enigmeAleatoire = rand.nextInt(this.alEnigmes.size());
	    
	    this.background = this.alEnigmes.get(enigmeAleatoire).getImage();
	    
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
	    	if(this.alEnigmes.get(this.enigmeAleatoire).getNumCorrect() == 1){
	    		this.alEnigmes.remove(this.enigmeAleatoire);
	    		game.enterState(WindowGame.ID);
	    	}
	    	else{
	    		game.enterState(GameOver.ID);
				System.out.println("Mauvaise réponse");
	    	}
	    	break;
	    case Input.KEY_NUMPAD2:
	    	if(this.alEnigmes.get(this.enigmeAleatoire).getNumCorrect() == 2){
	    		this.alEnigmes.remove(this.enigmeAleatoire);
	    		game.enterState(WindowGame.ID);
	    	}
	    	else{
	    		game.enterState(GameOver.ID);
				System.out.println("Mauvaise réponse");
	    	}
	    	break;
	    case Input.KEY_NUMPAD3:
	    	if(this.alEnigmes.get(this.enigmeAleatoire).getNumCorrect() == 3){
	    		this.alEnigmes.remove(this.enigmeAleatoire);
	    		game.enterState(WindowGame.ID);
	    	}
	    	else{
	    		game.enterState(GameOver.ID);
				System.out.println("Mauvaise réponse");
	    	}
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