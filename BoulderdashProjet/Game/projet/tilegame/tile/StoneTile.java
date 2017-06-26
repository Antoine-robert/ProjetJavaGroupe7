package projet.tilegame.tile;

import projet.tilegame.graphics.Assets;

public class StoneTile extends Tile {
/**
 * Tile of a Stone
 * @param id
 */
	public StoneTile( int id) {
		super(Assets.dirt2, id);
		
	}
	/**
	 * set the stone has solid block
	 */
	@Override
	public boolean isSolid(){
		return false;
	}

}
