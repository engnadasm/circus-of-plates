package eg.edu.alexu.csd.oop.game.objects;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;

public class BackGroundPic implements GameObject{
	private BufferedImage[] allImage = new BufferedImage[1];
	private Logger logger;

	public BackGroundPic(Logger logger) {
		 this.logger = logger;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		try {
			allImage[0] = ImageIO.read(getClass().getResourceAsStream("/back.png"));
		} catch (IOException e) {
			logger.error("can't set Image of background");
		}
		return allImage;
	}

}
