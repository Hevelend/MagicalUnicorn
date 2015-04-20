package ca.magical.unicorn.tile;

import ca.magical.unicorn.physics.AABoundingRect;
import ca.magical.unicorn.physics.BoundingShape;

public class SolidTile extends Tile {
	
    protected BoundingShape boundingShape = new AABoundingRect(x*70,y*70,70,70);
	
    public SolidTile(int x, int y) {
        super(x, y);
    } 
}
