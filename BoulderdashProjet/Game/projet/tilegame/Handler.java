package projet.tilegame;

import projet.tilegame.graphics.GameCamera;
import projet.tilegame.input.KeyManager;
import projet.tilegame.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
		
	}
/**
 * few Getters and Setters
 * @return
 */
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCAmera();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
