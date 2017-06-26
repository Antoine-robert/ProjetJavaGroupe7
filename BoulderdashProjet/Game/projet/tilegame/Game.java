package projet.tilegame;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import projet.tilegame.display.Display;
import projet.tilegame.graphics.Assets;
import projet.tilegame.graphics.GameCamera;
import projet.tilegame.input.KeyManager;
import projet.tilegame.state.GameState;
import projet.tilegame.state.MenuState;
import projet.tilegame.state.State;

public class Game  implements Runnable{
	
	/**
	 * Attribute
	 */
	private Display display;
	private int width, height;
	private String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	
	/**
	 * Constructor 
	 * Set a title, a width and a height when we launch the game
	 * @param title
	 * @param width
	 * @param height
	 */
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
		
	}
/**
 * initialize the view, the keyListener, Assets and the State
 */
	private void init(){
		display = new Display (title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler (this);
		gameCamera = new GameCamera(handler, 0,0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
		
		
		
	}
	
/**
 * refresh Events and State
 */
	private void tick(){
		keyManager.tick();
		
		if (State.getState()!= null)
			State.getState().tick();
		
	}
	/**
	 * display the canvas in the view
	 */
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if (State.getState()!= null)
			State.getState().render(g);
		 
		bs.show();
		g.dispose();
	}
	
	/**
	 * Needed for actualize the game and set the speed of the game and also the player
	 */
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/ fps; // change values and the player gonna run faster
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		
		while (running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >=1){
				
			tick();
			render();
			ticks++;
			delta--;
		}
			if (timer >=1000000000){
				System.out.println("Ticks and Frame " + ticks);
				ticks =0;
				timer = 0;
			}
	}
		
		stop();
		}
	/**
	 * few Getters and Setters
	 * @return
	 */
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCAmera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	/**
	 * Start the knew Thread
	 */
	public synchronized void start(){
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Stop the Thread
	 */
	public synchronized void stop(){
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
