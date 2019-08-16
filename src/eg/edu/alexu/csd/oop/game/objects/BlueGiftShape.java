package eg.edu.alexu.csd.oop.game.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BlueGiftShape extends Shape{

	public BlueGiftShape() {
		super();
		setType("BlueGiftPool");
		setColor("blue");
		setWidth(30);
		setHeight(30);
		try {
			setImage(ImageIO.read(getClass().getResourceAsStream("/rb.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
