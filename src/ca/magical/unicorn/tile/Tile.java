package ca.magical.unicorn.tile;

import ca.magical.unicorn.physics.BoundingShape;

public class Tile {
	 
    protected int x;
    protected int y;
    protected BoundingShape boundingShape;
 
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public int getX(){
        return x;
    }
 
    public int getY(){
        return y;
    }
 
}
