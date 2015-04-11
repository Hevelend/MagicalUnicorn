package ca.magical.unicorn.collision;

import org.newdawn.slick.Image;

public class Box {
	private float x1, y1, x2, y2;
	private float width, height;
	
	public Box(float x1 , float y1 , Image img) {
		this.x1 = x1;
		this.x2 = x1 + img.getWidth();
		this.y1 = y1;
		this.y2 = y1 + img.getHeight();
		width = this.x2 - x1;
		height = this.y2 - y1;
	}
	
	public Box(float x1 , float y1, float x2, float y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		width = x2 - x1;
		height = y2 - y1;
	}
	
	public boolean collide(Box box) {
		if(y2 < box.getY1()) return false;
		if(x2 < box.getX1()) return false;
		if(y1 > box.getY2()) return false;
		if(x1 > box.getX2()) return false;
		return true;
	}
	
	public float getX1() { 
		return x1;
	}
	
	public float getX2() { 
		return x2;
	}
	
	public float getY1() { 
		return y1;
	}
	
	public float getY2() {
		return y2;
	}
	
	public void setCoord(float x , float y)
	{
		x1 = x;
		y1 = y;
		x2 = x + width;
		y2 = y + height;
	}
}
