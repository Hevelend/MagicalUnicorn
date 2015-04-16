package ca.magical.unicorn.windows;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.WindowGame;
import ca.magical.unicorn.panda.Enigme;

public class WisePanda extends BasicGameState {

	  public static final int ID = 4;
	  private Image background;
	  private StateBasedGame game;
	  private ArrayList<Enigme> alEnigmes;
	  private int enigmeAleatoire;

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    int i = 1;
	    
	    Enigme enigme1 = new Enigme("res/Enigmes/EnigmePanda1.png",3);
	    Enigme enigme2 = new Enigme("res/Enigmes/EnigmePanda2.png",1);
	    Enigme enigme3 = new Enigme("res/Enigmes/EnigmePanda3.png",1);
	    Enigme enigme4 = new Enigme("res/Enigmes/EnigmePanda4.png",3);
	    Enigme enigme5 = new Enigme("res/Enigmes/EnigmePanda5.png",3);
	    Enigme enigme6 = new Enigme("res/Enigmes/EnigmePanda6.png",2);
	    Enigme enigme7 = new Enigme("res/Enigmes/EnigmePanda7.png",2);
	    Enigme enigme8 = new Enigme("res/Enigmes/EnigmePanda8.png",1);
	    Enigme enigme9 = new Enigme("res/Enigmes/EnigmePanda9.png",1);
	    Enigme enigme10 = new Enigme("res/Enigmes/EnigmePanda10.png",3);
	    
	    this.alEnigmes = new ArrayList<Enigme>(); // on fait un tableau d'énigmes
	    /*
	      for (i=1;i<11;i++){
	      String str = "enigme" + i;
	      this.alEnigmes.add(str);
	      }*/
	    this.alEnigmes.add(enigme1); // on ajoute les enigmes au tableau
	    this.alEnigmes.add(enigme2);
	    this.alEnigmes.add(enigme3);
	    this.alEnigmes.add(enigme4);
	    this.alEnigmes.add(enigme5);
	    this.alEnigmes.add(enigme6);
	    this.alEnigmes.add(enigme7);
	    this.alEnigmes.add(enigme8);
	    this.alEnigmes.add(enigme9);
	    this.alEnigmes.add(enigme10);
	    
	    Random rand = new Random();
	    this.enigmeAleatoire = rand.nextInt(this.alEnigmes.size()); // on selection aléatoirement une enigme en fonction
	    															// de la taille du tableau
	    
	    this.background = this.alEnigmes.get(enigmeAleatoire).getImage(); // on affiche l'image de l'enigme choisi
	    
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
	  
	  /**
	   * Fonction qui va permettre de déterminer qu'elle action effectuer selon
	   * la réponse donner à l'énigme
	   * @param good
	   */
	  public void isGood(int good){
		  if(this.alEnigmes.get(this.enigmeAleatoire).getNumCorrect() == good){
	    		this.alEnigmes.remove(this.enigmeAleatoire);
	    		game.enterState(WindowGame.ID);
	    	}
	    	else{
	    		game.enterState(GameOver.ID);
	    	}  
	  }
	  
	  @Override
	  public void keyReleased(int key, char c) {
		  
	    switch(key){
	    case Input.KEY_NUMPAD1:
	    	isGood(1);
	    	break;
	    case Input.KEY_NUMPAD2:
	    	isGood(2);
	    	break;
	    case Input.KEY_NUMPAD3:
	    	isGood(3);
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