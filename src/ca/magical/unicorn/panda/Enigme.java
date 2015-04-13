package ca.magical.unicorn.panda;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enigme {
	
	private Image image;
	private int numCorrect;
	
	public Enigme(String urlImage, int numCorrect) {
		
		try {
			this.image 		= new Image(urlImage);
		} catch (SlickException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		this.numCorrect = numCorrect;
		
	}

	public int getNumCorrect() {
		return this.numCorrect;
	}
	
	public Image getImage() {
		return this.image;
	}
	
}
