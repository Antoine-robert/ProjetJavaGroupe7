package projet.tilegame.entities.creatures;

import java.awt.Graphics;

import projet.tilegame.Handler;
import projet.tilegame.graphics.Animation;
import projet.tilegame.graphics.Assets;
import projet.tilegame.tile.Tile;

public class Stone extends Creature{
	private Animation aniStone;

	public Stone(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 28;
		bounds.height = 28;
	
		aniStone = new Animation (250, Assets.stones);
	}
/**
 * Acualize the Animation of the (Rolling)Stone
 */
	@Override
	public void tick() {
		
		aniStone.tick();
		
	}
	
/**
 * Show the Assets Stone on the map 
 */
	@Override
	public void render(Graphics g) {
		g.drawImage(aniStone.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	

}
