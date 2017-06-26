package projet.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public  class KeyManager implements KeyListener{

	protected boolean[] keys;
	public boolean up, down, left , right;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	/**
	 * Get the input of the keyboard
	 */
	public void tick(){
		up = keys[KeyEvent.VK_Z];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_Q];
		right = keys[KeyEvent.VK_D];
	}
	
	
/**
 * Get what key we have pressed
 */
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("pressed");
		
	}
/**
 * Get what key we have released
 */
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}
/**
 * Not use this method but needed for the KeyEvent
 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
