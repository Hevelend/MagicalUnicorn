package ca.magical.unicorn;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame { 
	private WindowGame jeu; // le premier état du jeu (voir GameState.java) 
	private WisePanda testWise;
	private AppGameContainer container; // le conteneur du jeu 
 
	public Game() {
		super("Magical Unicorn");
	} // le constructeur de la classe 
  
	@Override
	public void initStatesList(GameContainer container) throws SlickException 
	{ 
		if (container instanceof AppGameContainer) { 
		     this.container = (AppGameContainer) container; // on stocke le conteneur du jeu !
		} 
		testWise = new WisePanda(); 
		jeu = new WindowGame(); //le jeu en lui-même !
		container.setShowFPS(false); //on ne veut pas voir le FPS ?? mettre alors "false" !
		
		addState(jeu); //on ajoute le GameState au conteneur ! 
		addState(testWise);
	} 
	 
	public static void main(String Arg[]){ 
		try
		{ 
			AppGameContainer myContainer = new AppGameContainer(new Game()); 
			myContainer.setDisplayMode(1280, 768, false); // fenêtre de 1280*768 fullscreen =false !! 
			myContainer.setTargetFrameRate(60); // on règle le FrameRate 
			myContainer.start(); //on démarre le container 
		} catch (SlickException e) {
			e.printStackTrace();
		} // l'exception de base de slick !! 
	} 
} // fin de classe