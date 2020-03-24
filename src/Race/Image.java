package Race;
//SHAMIM BABUL
//PROJECT 2

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
//Loads the two images of the characters
public class Image {
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(Image.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
