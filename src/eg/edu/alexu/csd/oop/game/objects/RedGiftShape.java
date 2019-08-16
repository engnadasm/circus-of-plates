package eg.edu.alexu.csd.oop.game.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class RedGiftShape extends Shape{
	public RedGiftShape() {
		super();
		setType("RedGiftPool");
		setColor("red");
		setWidth(30);
		setHeight(30);
		try {
			setImage(ImageIO.read(getClass().getResourceAsStream("/rr.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
