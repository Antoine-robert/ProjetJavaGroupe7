package projet.tilegame;


/**
 * Main method 
 * @author aymeric
 *
 */
public class launcher {
	public static void main (String[] args){
		
		Game game =new Game("title", 500, 500);
		game.start();
	}

}
