package projet.tilegame.entities.creatures;

import projet.tilegame.Handler;
import projet.tilegame.entities.Entity;
import projet.tilegame.tile.Tile;

public abstract class Creature extends Entity{
	
/**
 * default values for the speed, width and height
 */
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH =32,
							DEFAULT_CREATURE_HEIGHT = 32;
	
	protected float speed;
	protected int health;
	protected float xMove, yMove;

	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler, x, y, width, height);

		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
	}
/**
 * move the creature if it doesn't check a collision with an other Entity
 */
	public void move(){
		if(!checkEntityCollisions(xMove,0f))
		moveX();
		if(!checkEntityCollisions(0f,yMove))
		moveY();
	}
	
	/**
	 * Method that will move right or left.
	 * The method check where is the collision with a Tile
	 */
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx *Tile.TILEWIDTH - bounds.x - bounds.width -1;
			}
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else {
				x =tx* Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	/**
	 * Method that will move up or down.
	 *  The method check where is the collision with a Tile.
	 */
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else {
				y = ty *Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height -1;
			}
		}
	}
	
	/**
	 * Check if we have a collision with a Tile and if it is solid or not 
	 * @param x
	 * @param y
	 * @return
	 */
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	/**
	 * Getters & Setters
	 */
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}