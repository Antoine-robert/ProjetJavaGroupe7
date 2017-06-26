package projet.tilegame.entities.creatures;

import java.awt.Graphics;

import projet.tilegame.Handler;
import projet.tilegame.graphics.Assets;
import projet.tilegame.tile.Tile;


public abstract class Dirt2 extends Creature{

	public Dirt2(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 28;
		bounds.height = 28;
	
	}
	/**
	 * Show the Dirt2 Assets on the map
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dirt2,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
}
