package eg.edu.alexu.csd.oop.game.objects;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Clown implements GameObject {
	
	private int x;
	private int y;
	private int savedX;
	private int SavedY;
	private BufferedImage[] allImage = new BufferedImage[1];
	private static Clown instance;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Logger logger;

	private Clown(Logger logger) {
		 this.logger = logger;
		try {
			allImage[0] = ImageIO.read(getClass().getResourceAsStream("/clown1.png"));
		} catch (IOException e) {
			logger.error("can't set Image of clown");
		}
		x = (screenSize.width - getWidth()) / 2;
		y = screenSize.height - getHeight() - 150;
	}

	public static Clown getInstance(Logger logger) {
		if (instance == null)
			instance = new Clown(logger);
		return instance;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		// this.y = y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return allImage[0].getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return allImage[0].getHeight();
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
			allImage[0] = ImageIO.read(getClass().getResourceAsStream("/clown1.png"));
		} catch (IOException e) {
			logger.error("can't set Image of clown");
		}
		return allImage;
	}

	public int getSavedX() {
		return savedX;
	}

	public void setSavedX(int savedX) {
		this.savedX = savedX;
	}

	public int getSavedY() {
		return SavedY;
	}

	public void setSavedY(int savedY) {
		SavedY = savedY;
	}

}
