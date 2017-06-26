package projet.tilegame.tile;

import projet.tilegame.graphics.Assets;

public class WallTile extends Tile{
/**
 * Tile of a wall
 * @param id
 */
	public WallTile( int id) {
		super(Assets.wall, id);
		
	}
	/**
	 * Set the wall has a solid block
	 */
	@Override
	public boolean isSolid(){
		return true;
	}

}
