package eg.edu.alexu.csd.oop.game.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class RedBallShape extends Shape{
	public RedBallShape() {
		super();
		setType("RedBallPool");
		setColor("red");
		setWidth(30);
		setHeight(30);
		try {
			setImage(ImageIO.read(getClass().getResourceAsStream("/redball5.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
