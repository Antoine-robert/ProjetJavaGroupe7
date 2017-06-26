package projet.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import projet.tilegame.Handler;
import projet.tilegame.entities.Entity;
import projet.tilegame.graphics.Animation;
import projet.tilegame.graphics.Assets;
import projet.tilegame.tile.Tile;

public class Stone extends Creature{
	private Animation aniStone;
// COnstructor to build Stone
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
		checkDigs();
		aniStone.tick();
		
	}//Function allows rock to fall
	public void checkDigs() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle dr = new Rectangle();
		int drSize = 2;
		dr.width = drSize;
		dr.height = drSize;
		
		dr.x = cb.x + cb.width / 2 - drSize / 2;
		dr.y = cb.y + cb.height/ 2 - drSize / 2;

		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(dr)) {
				 e.hurt(1);
				return;
			}
			if (!e.getCollisionBounds(0, 0).intersects(dr)) {
			
				yMove = 1;
				return;
			}
		}
	}
	
/**
 * Show the Assets Stone on the map 
 */
	@Override
	public void render(Graphics g) {
		g.drawImage(aniStone.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	

}
