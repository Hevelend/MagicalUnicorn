package ca.magical.unicorn;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.menus.ChoixNiveau;
import ca.magical.unicorn.menus.GameOver;
import ca.magical.unicorn.menus.MenuJeu;
import ca.magical.unicorn.menus.MultiplayerChoice;
import ca.magical.unicorn.menus.WisePanda;
import ca.magical.unicorn.windows.CandyWorldLevel;
import ca.magical.unicorn.windows.EnchantedForestLevel;
import ca.magical.unicorn.windows.RubyWorldLevel;
import ca.magical.unicorn.windows.SpaceWorldLevel;
import ca.magical.unicorn.windows.WindowGame;

public class Game extends StateBasedGame { 
	private WindowGame jeu; // le premier état du jeu (voir GameState.java) 
	private WisePanda testWise;
	private GameOver gameOver;
	private MenuJeu menuJeu;
	private ChoixNiveau choixniveau;
	private MultiplayerChoice multi;
	private CandyWorldLevel candylevel;
	private EnchantedForestLevel forestlevel;
	private RubyWorldLevel rubylevel;
	private SpaceWorldLevel spacelevel;
	private AppGameContainer container; // le conteneur du jeu
	public static int previous_level = 0;
	public static boolean isMulti = false;
	public static boolean playMenuSong = true;
	public static boolean onlineMulti = false;
 
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
		menuJeu = new MenuJeu();
		jeu = new WindowGame(); //le jeu en lui-même !
		gameOver = new GameOver();
		choixniveau = new ChoixNiveau();
		candylevel = new CandyWorldLevel();
		forestlevel = new EnchantedForestLevel();
		rubylevel = new RubyWorldLevel();
		spacelevel = new SpaceWorldLevel();
		multi = new MultiplayerChoice();
		container.setShowFPS(false); //on ne veut pas voir le FPS ?? mettre alors "false" !
		
		addState(menuJeu);
		addState(choixniveau);
		addState(jeu); //on ajoute le GameState au conteneur ! 
		addState(testWise);
		addState(gameOver);
		addState(candylevel);
		addState(forestlevel);
		addState(rubylevel);
		addState(spacelevel);
		addState(multi);
	}
	 
	public static void main(String Arg[]) {
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