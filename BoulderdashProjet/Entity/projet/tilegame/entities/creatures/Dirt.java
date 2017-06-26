package projet.tilegame.entities.creatures;

import java.awt.Graphics;

import projet.tilegame.Handler;
import projet.tilegame.graphics.Assets;
import projet.tilegame.tile.Tile;


public class Dirt extends Creature{

	public Dirt(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 28;
		bounds.height = 28;
	
	}
	/**
	 * Show the dirt Assets on the map
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dirt,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
}
