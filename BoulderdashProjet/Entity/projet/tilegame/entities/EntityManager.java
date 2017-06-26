package projet.tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import projet.tilegame.Handler;
import projet.tilegame.entities.creatures.Player;


public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;

	
	public EntityManager (Handler handler, Player player){
		this.player = player;
		this.handler = handler;
		entities = new ArrayList <Entity>();
		addEntity(player);
		
	}
	
	public void tick(){
		for (int i = 0; i <entities.size(); i++){
			Entity e = entities.get(i);
			e.tick();
			if (!e.isActive()){
				entities.remove(e);
			}
			
		}
	}
	/**
	 * show on the game the entity like stone or diamond
	 * @param g
	 */
	public void render (Graphics g){
		for (Entity e : entities){
			e.render(g);
		}
	}
	
	/**
	 * Getters and Setters
	 * @param e
	 */
	public void addEntity (Entity e){
		entities.add(e);
	}

	//GETTERS AND SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
