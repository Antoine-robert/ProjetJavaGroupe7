package projet.tilegame.graphics;

import projet.tilegame.Handler;
import projet.tilegame.entities.Entity;
import projet.tilegame.tile.Tile;

public class GameCamera {

	private float xOffset, yOffset;
	private Handler handler;
	
	public GameCamera(Handler handler, float xOffset, float yOffset ){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
	}
	/**
	 * The camera can see the edge of the map but not behind the the map
	 */
	public void checkBlankSpace(){
		if (xOffset < 0){
			xOffset = 0;
		}else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		if (yOffset <0){
			yOffset = 0;
		}else if (yOffset > handler.getWorld().getHeight() *Tile.TILEHEIGHT - handler.getHeight()){
			yOffset = handler.getWorld().getHeight() *Tile.TILEHEIGHT - handler.getHeight();
	}
	}
	
	/**
	 * Center the camera on the player
	 * @param e
	 */
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth() /2 + e.getWidth() /2;
		yOffset = e.getY() - handler.getHeight() /2 + e.getHeight() /2;
		checkBlankSpace();
	}
	/**
	 * Move the camera
	 * @param xAmt
	 * @param yAmt
	 */
	public void move( float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	/**
	 * Getters and Setters
	 * @return
	 */
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
