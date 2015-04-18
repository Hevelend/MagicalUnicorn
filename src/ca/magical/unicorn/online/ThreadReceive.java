package ca.magical.unicorn.online;

import java.io.IOException;
import java.io.ObjectInputStream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.windows.WindowGame;

public class ThreadReceive extends Thread {
	protected ObjectInputStream in;
	protected StateBasedGame game;
	protected GameContainer container;
	protected WindowGame wgame;
	
	public ThreadReceive(GameContainer _container, StateBasedGame _game, WindowGame _wgame, ObjectInputStream i){
		this.container = _container;
		this.game = _game;
		this.wgame = _wgame;
		this.in = i;
		start();
	}
	
	public void run(){
		while(true){
			try {
				wgame.getFirstPlayer().setX(Float.parseFloat((String)in.readObject()));
				wgame.getFirstPlayer().setY(Float.parseFloat((String)in.readObject()));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}