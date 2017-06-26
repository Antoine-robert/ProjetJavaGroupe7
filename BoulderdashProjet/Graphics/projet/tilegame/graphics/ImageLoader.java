package projet.tilegame.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	/**
	 * Load the map from a file 
	 * @param path
	 * @return
	 */
	public static BufferedImage LoadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(1);
		}
		
		return null;
		
	}
}
