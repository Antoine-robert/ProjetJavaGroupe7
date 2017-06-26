package projet.tilegame.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	/**
	 * Init all the Tile
	 */
	
	public static Tile[] tiles = new Tile [256];
	public static Tile stoneTile = new StoneTile(3);
	public static Tile dirtTile = new DirtTile(0);
	public static Tile dirt2Tile = new Dirt2Tile(4);
	public static Tile wallTile = new WallTile(2);
	public static Tile diamondTile = new DiamondTile(1);
	
	//CLASS
	public static final int TILEWIDTH = 32 , TILEHEIGHT = 32;
	protected BufferedImage texture;
	protected int id;
	/**
	 * Constructor of Tile
	 * @param texture
	 * @param id
	 */
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		
	}
	
	public void tick(){
		dirt2Tile.setId(4);
	}
	
	

	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
		
	}
	
	public boolean isSolid(){
		return false;
	}
	
	private void setId(int id) {
		this.id = id;
		
	}
	public int getId(){
		return id;
	}
	
}
