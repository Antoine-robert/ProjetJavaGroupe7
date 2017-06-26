package projet.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import projet.tilegame.Handler;
import projet.tilegame.entities.Entity;
import projet.tilegame.graphics.Animation;
import projet.tilegame.graphics.Assets;
import projet.tilegame.tile.Tile;

public class Diamond extends Creature{
	private Animation aniDiamonds;

	public Diamond(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 28;
		bounds.height = 28;
	
		aniDiamonds = new Animation (250, Assets.diamonds);
	}
/**
 * Actualize the Animation and if it need to move down 
 */
	@Override
	public void tick() {
		checkDigs();
		move();
		aniDiamonds.tick();
		
	}
	
	/**
	 * Method use to move down the Diamond if nothing is under the diamond
	 */
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
 * show the animation of the Diamond
 */
	@Override
	public void render(Graphics g) {
		g.drawImage(aniDiamonds.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	

}
