package projet.tilegame.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int width = 16, height = 16;
	//public static final BufferedImage diamond = null;
	public static BufferedImage wall, dirt, dirt2, stone, diamond;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] diamonds;
	public static BufferedImage[] stones;

	
	
	/**
	 * Croop the Sprite sheet 
	 */
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Boulder copie.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/player.png"));
		
		wall = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width*3, 2, width, height);
		dirt2 = sheet.crop(width*2, 0, width, height);
		diamond = sheet.crop(width*4, 0, width, height);
		
		/**
		 * Animation for the payer 
		 */
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[1];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		player_down[0] = sheet2.crop(0, 0, width, height);
		player_down[1] = sheet2.crop(width, 0, width, height);
		player_up[0] = sheet2.crop(width*2, height*5 , width, height);
		player_left[0] = sheet2.crop(0, height, width, height);
		player_left[1] = sheet2.crop(width, height, width, height);
		player_right[0] = sheet2.crop(0, height*3 , width, height);
		player_right[1] = sheet2.crop(width, height*3, width, height);
		/**
		 * Animation for the Diamond
		 */
		diamonds = new BufferedImage[4];
		
		diamonds[0] = sheet.crop(width*4, 0, width, height);
		diamonds[1] = sheet.crop(width*4, height, width, height);
		diamonds[2] = sheet.crop(width*4, height*2, width, height);
		diamonds[3] = sheet.crop(width*4, height*3, width, height);
		
		/**
		 * Animation for the Stone
		 */
		stones = new BufferedImage[2];
		stones[0] = sheet.crop(width*3, 0, width, height);
		stones[1] = sheet.crop(width*3, height, width, height);
				
		
		

		
	}

}
