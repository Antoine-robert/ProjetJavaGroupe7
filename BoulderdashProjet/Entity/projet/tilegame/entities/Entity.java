package projet.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import projet.tilegame.Handler;

public abstract class Entity {
	

	protected int health;
	protected Handler handler;
	protected float x, y;
	protected static int width;
	protected static int height;
	protected Rectangle bounds;
	protected boolean active = true;

	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	/**
	 * We check if a entity had a collision with a entity
	 * @param xOffset
	 * @param yOffset
	 * @return
	 */
	public boolean checkEntityCollisions (float xOffset, float yOffset){
		for (Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds (xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	/**
	 * Method to take off the health of a creature or player 
	 * @param amt
	 */
	public void hurt(int amt){
		health -= amt;
		if (health <= 0) {
			active = false; 
		}
	}
	
	/**
	 * boolean that return if a entity is still in the game 
	 * @return
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Getter that get the collision with a hit box call bounds 
	 * @param xOffset
	 * @param yOffset
	 * @return
	 */
	public Rectangle getCollisionBounds (float xOffset, float yOffset){
		return new Rectangle ((int) (x + bounds.x+ xOffset), (int) (y+bounds.y + yOffset), bounds.width, bounds.height);
		
	}
	

/**
 * Getters and Setters	
 * @return
 */
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}



	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}	
	public void setWidth(int width) {
		this.width = width;
	}
}
