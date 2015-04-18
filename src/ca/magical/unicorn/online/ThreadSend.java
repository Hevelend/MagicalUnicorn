package ca.magical.unicorn.online;

import java.io.IOException;
import java.io.ObjectOutputStream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.windows.WindowGame;

public class ThreadSend extends Thread {
	protected ObjectOutputStream out;
	protected StateBasedGame game;
	protected GameContainer container;
	protected WindowGame wgame;
	
	public ThreadSend(GameContainer _container, StateBasedGame _game, WindowGame _wgame, ObjectOutputStream o){
		this.container = _container;
		this.game = _game;
		this.wgame = _wgame;
		this.out = o;
		start();
	}
	
	public void run(){
		while(true){
			try {
				out.writeObject("" + wgame.getFirstPlayer().getX());
				out.writeObject("" + wgame.getFirstPlayer().getY());
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
