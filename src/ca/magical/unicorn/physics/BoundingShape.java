package ca.magical.unicorn.physics;

import java.util.ArrayList;

import ca.magical.unicorn.tile.Tile;

public abstract class BoundingShape {
	/**
	 * Cette m�thode est utilis� pour voir quel genre de forme que nous traitons 
	 * et appeler la bonne m�thode pour faire face � la collision 
	 */
    public boolean checkCollision(BoundingShape bv){
        if(bv instanceof AABoundingRect)
            return checkCollision((AABoundingRect) bv);
        return false;
    }
 /**
  * utilis�e pour v�rifier la collision entre ne importe quelle forme que nous avons mis en place un
  * un AABoundingRect , il y aura une telle m�thode pour chaque forme nous ajoutons 
  * @param box
  * @return
  */
    public abstract boolean checkCollision(AABoundingRect box);
 /**
  * it updates the position of the shape to the new x and y
  *  (for a rectangle this is the top left corner and for a circle this might be the center). 
  * @param newX
  * @param newY
  */
    public abstract void updatePosition(float newX, float newY);
 /**
  * movePosition in turn only moves it,
  *  so if we say movePosition(5,0) the x of the shape will be moved by 5, 
  *  this will be really useful for checking close collisions 
  * @param x
  * @param y
  */
    public abstract void movePosition(float x, float y);
 /**
  * R�cup�res les tuiles qui sont occup�es par le personnage et autour
  * @param tiles
  * @return
  */
    public abstract ArrayList<Tile> getTilesOccupying(Tile[][] tiles);
 /**
  * r�cup�res les tuiles au sol en dessous du personnage
  * @param tiles
  * @return
  */
    public abstract ArrayList<Tile> getGroundTiles(Tile[][] tiles);
 
}