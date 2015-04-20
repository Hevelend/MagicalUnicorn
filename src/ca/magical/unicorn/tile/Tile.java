package ca.magical.unicorn.tile;

import ca.magical.unicorn.collision.Box;
import ca.magical.unicorn.physics.BoundingShape;

public class Tile {
	 
    protected int x;
    protected int y;
    protected BoundingShape boundingShape;
    protected Box box;
 
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.box = new Box(x * 70, y * 70, (x * 70) + 70 , (y * 70) + 70);
    }
 
    public int getX(){
        return x;
    }
 
    public int getY(){
        return y;
    }
 
    public Box getBox() {
    	return box;
    }
    
}
