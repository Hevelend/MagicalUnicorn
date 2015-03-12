package ca.magical.unicorn;

import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics; 
import org.newdawn.slick.SlickException; 
import org.newdawn.slick.state.BasicGameState; 
import org.newdawn.slick.state.StateBasedGame;

public class WindowGame extends BasicGameState {
	public static final int ID = 1;

	@Override
	public int getID() {
		return ID;
	}
	
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	g.drawString("J'suis une licorne !", 100, 50); // méthode pour afficher un message à l’ecran
    	g.drawString("Blblblblblblbbl", 100, 65);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	
    }
}