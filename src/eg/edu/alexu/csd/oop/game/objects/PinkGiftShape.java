package eg.edu.alexu.csd.oop.game.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class PinkGiftShape extends Shape{
	public PinkGiftShape() {
		super();
		setType("PinkGiftPool");
		setColor("pink");
		setWidth(30);
		setHeight(30);
		try {
			setImage(ImageIO.read(getClass().getResourceAsStream("/rp.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
