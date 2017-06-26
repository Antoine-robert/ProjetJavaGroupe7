package projet.tilegame.state;

import java.awt.Graphics;

import projet.tilegame.Handler;
import projet.tilegame.worlds.World;

public  class GameState extends State {


	private World world;

	/**
	 * Find and set the world that we want
	 * @param handler
	 */
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

	}
	/**
	 * Actualize the world
	 */
	 @Override
	public void tick() {
		 world.tick();
	

	}
/**
 * show the world
 */
	 @Override
	public void render(Graphics g) {
		//g.drawImage(Assets.dirt, 0, 0, null);
		 world.render(g);

		//Tile.tiles[0].render(g,0, 0);
	}

	
	
}
