package ca.magical.unicorn.camera;

import org.newdawn.slick.GameContainer;

public class Camera {
	private float xCamera = 0, yCamera = 0, oldxCamera = 0;

	public Camera(float x, float y) {
		super();
		this.xCamera = x;
		this.yCamera = y;
	}

	public float getxCamera() {
		return xCamera;
	}

	public void setxCamera(float xCamera) {
		this.xCamera = xCamera;
	}

	public float getyCamera() {
		return yCamera;
	}

	public void setyCamera(float yCamera) {
		this.yCamera = yCamera;
	}

	public float getOldxCamera() {
		return oldxCamera;
	}

	public void setOldxCamera(float oldxCamera) {
		this.oldxCamera = oldxCamera;
	}
	
	public void updateCamera(GameContainer container, float x, float y) {
    	int w = container.getWidth() / 6;
    	if(x - w > 0){ // Permet de ne pas avoir de bande noir
	    	if (x > this.xCamera + w) {
				this.xCamera = x - w;
			} else if (x < this.xCamera - w) {
				this.xCamera = x + w;
			}
    	}
    	
		int h = container.getHeight() / 6;
		if(y - h > 0) { // Permet de ne pas avoir de bande noir
			if (y > this.yCamera + h) {
				this.yCamera = y - h;
			} else if (y < this.yCamera - h) {
				this.yCamera = y + h;
			}
		}
    }
}
