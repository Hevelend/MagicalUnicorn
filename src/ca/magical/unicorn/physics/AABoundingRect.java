package ca.magical.unicorn.physics;

import java.util.ArrayList;

import ca.magical.unicorn.tile.Tile;

public class AABoundingRect extends BoundingShape {
	 
    public float x;
    public float y;
    public float width; // on recupère la largeur du personnage
    public float height; // on recupère la hauteur du personnage
 
    public AABoundingRect(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
 
    public void updatePosition(float newX, float newY) {
        this.x = newX;
        this.y = newY;
    }
 
    public void movePosition(float x, float y) {
        this.x += x;
        this.y += y;
    }
    
    public boolean checkCollision(AABoundingRect rect) {
        return !(rect.x > this.x+width || rect.x+rect.width < this.x || rect.y > this.y+height || rect.y+rect.height < this.y);
    }

    /**
     * détection des tuiles occupées par le personnage
     */
	@Override
	public ArrayList<Tile> getTilesOccupying(Tile[][] tiles) {
        ArrayList<Tile> occupiedTiles = new ArrayList<Tile>();
 
        // on parcourt de la gauche du rectangle à droit pour s'assurer que nous arrondissons 
        //vers le haut à un multiple de 70 ou nous pourrions manquer quelques tuiles
        for(int i = (int) x; i <= x+width+(70-width%70); i+=70){
            for(int j = (int) y; j <= y+height+(70-height%70); j+=70){
                occupiedTiles.add(tiles[i/70][j/70]);
            }
        }
        return occupiedTiles;
    }

	/**
	 * Détection des tuiles en dessous du personnage
	 */
	@Override
	 public ArrayList<Tile> getGroundTiles(Tile[][] tiles) {
        ArrayList<Tile> tilesUnderneath = new ArrayList<Tile>();
        int j = (int) (y+height+1);
 
        for(int i = (int) x; i <= x+width+(70-width%70); i+=70){
            tilesUnderneath.add(tiles[i/70][j/70]);
        }
 
        return tilesUnderneath;
    }
}