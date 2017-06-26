package projet.tilegame.worlds;

import java.awt.Graphics;

import projet.tilegame.Handler;
import projet.tilegame.entities.EntityManager;
import projet.tilegame.entities.creatures.*;
import projet.tilegame.tile.Tile;
import projet.tilegame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;

	/**
	 * Create the player
	 * Load the world
	 * Browse the map and set entity that we need 
	 * @param handler
	 * @param path
	 */
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 50, 50));
		loadworld(path);
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				switch(tiles[i][j]){
				
				
				case 1:
					entityManager.addEntity(new Diamond(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
				case 3 : 
					entityManager.addEntity(new Stone(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
				case 0:
					entityManager.addEntity(new Dirt(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					}
		//entityManager.addEntity(new Diamond(handler, Tile.TILEWIDTH, Tile.TILEHEIGHT));
		//entityManager.addEntity(new Stone(handler, Tile.TILEWIDTH, Tile.TILEHEIGHT));
	
		
		
	}}	
	entityManager.getPlayer().setX(spawnX);
	entityManager.getPlayer().setY(spawnY);
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick(){
		entityManager.tick();
	}
	/**
	 * Set the camera on the player and where is the limit of the map
	 * @param g
	 */
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()+ handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset()+ handler.getHeight()) / Tile.TILEWIDTH +1);
		
		for (int y = yStart; y < yEnd; y++){
			for (int x = xStart; x< xEnd; x++){
				getTile(x, y).render(g, (int) (x* Tile.TILEWIDTH -handler.getGameCamera().getxOffset()), (int) (y* Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
				
		}
		entityManager.render(g);
	}
	
	/**
	 * return a Tile when we have nothing 
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile getTile(int x, int y){
		if( x< 0 || y< 0 || x>= width || y >= height )
			return Tile.dirt2Tile;
		
		Tile t =  Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirt2Tile;
		return t;
	}
	
	/**
	 * Load the world
	 * @param path
	 */
	private void loadworld(String path){
		String file = Utils.loadFilesAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height =Utils.parseInt(tokens[1]);
		spawnX =Utils.parseInt(tokens[2]);	
		spawnY =Utils.parseInt(tokens[3]);
		
		tiles = new int [width][height];
		for(int y=0; y< height; y++)
			for (int x = 0; x< width; x++)
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) +4]);
			}
		
	/**
	 * Getters and Setters
	 * @return
	 */
		public int getWidth(){
			return width;
		}
		
		public int getHeight(){
			return height;
		}
		
	}