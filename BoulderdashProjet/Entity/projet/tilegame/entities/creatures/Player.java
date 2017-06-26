package projet.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import projet.tilegame.Handler;
import projet.tilegame.entities.Entity;
import projet.tilegame.graphics.Animation;
import projet.tilegame.graphics.Assets;

public class Player extends Creature {
	
	// Animation
	private Animation animDown, animUp, animLeft, animRight;
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 3;
		bounds.y = 2;
		bounds.width = 26;
		bounds.height = 29;
		
		/**
		 * Crate the Animations
		 */
		animDown = new Animation(500, Assets.player_down );
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
	}
/**
 * Actualize the Animation and move the player every tick
 */
	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		//Move
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
	}
	/**
	 * Method needed to dig the digs
	 */
	public void checkDigs() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle dr = new Rectangle();
		int drSize = 2;
		dr.width = drSize;
		dr.height = drSize;
		
		if(handler.getKeyManager().up) {
			dr.x = cb.x + cb.width / 2 - drSize / 2;
			dr.y = cb.y - drSize;
		} else if(handler.getKeyManager().down) {
			dr.x = cb.x + cb.width / 2 - drSize / 2;
			dr.y = cb.y + cb.height;
		} else if(handler.getKeyManager().left) {
			dr.x = cb.x - drSize;
			dr.y = cb.y + cb.height / 2 - drSize / 2;
		} else if(handler.getKeyManager().right) {
			dr.x = cb.x + cb.width;
			dr.y = cb.y + cb.height / 2 - drSize / 2;
		} else {
			return;	
		}
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(dr)) {
				e.hurt(1);
				return;
			}
		}
	}
	/**
	 * When we take in the input of the keyboard we move the player
	 */
	private void getInput(){
		xMove =0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
/**
 * Show the player on the map
 */
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x -handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		/*g.setColor(Color.RED);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				   (int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
				   bounds.width, bounds.height); */
	}
	/**
	 * When we move the player change the Animation
	 * @return
	 */
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove <0){
			return animLeft.getCurrentFrame();
		}else if (xMove > 0){
			return animRight.getCurrentFrame();
		}else if (yMove <0){
			return animUp.getCurrentFrame();
		}else{
			return animDown.getCurrentFrame();
		}
	}

}
