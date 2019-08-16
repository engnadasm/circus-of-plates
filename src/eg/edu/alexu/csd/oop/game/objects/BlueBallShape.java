package eg.edu.alexu.csd.oop.game.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BlueBallShape extends Shape{
	public BlueBallShape() {
		super();
		setType("BlueBallPool");
		setColor("blue");
		setWidth(30);
		setHeight(30);
		try {
			setImage(ImageIO.read(getClass().getResourceAsStream("/blueball5.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
