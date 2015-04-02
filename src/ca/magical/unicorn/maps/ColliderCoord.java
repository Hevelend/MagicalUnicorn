package ca.magical.unicorn.maps;

public class ColliderCoord {
	private int x;
	private int y;
	private boolean ifCollide;
	
	public ColliderCoord(int _x, int _y, boolean _ifCollide){
		x = _x;
		y = _y;
		ifCollide = _ifCollide;
	}

	public ColliderCoord(){
		x = 0;
		y = 0;
		ifCollide = false;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isCollider() {
		return ifCollide;
	}

	public void setIfCollider(boolean ifCollide) {
		this.ifCollide = ifCollide;
	}
}
