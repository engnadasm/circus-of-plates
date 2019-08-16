package eg.edu.alexu.csd.oop.game.world;

import java.util.List;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class StateCatchnopoint implements State {

	private Shape shape;
	private int maxstack = 500;
	private List<GameObject> movable;
	private List<GameObject> controlable;
	GameInfo gameinfo = GameInfo.getInstance();
	private DynamicEnvironment d;
	@Override
	public void doaction(Shape shape , List<Shape> stack, Logger logger) {
		// TODO Auto-generated method stub
		d = gameinfo.getEnvironment();
		this.shape = shape;
		gameinfo.getMovable().remove(shape);
		Shape s = (Shape) shape.clone();
		s.setMovable(false);
		shape.setY(0);
		d.release(shape, logger);
		gameinfo.setEnvironment(d);
		stack.add(s);
		gameinfo.getControlable().add(s);
		if (checkfullstack()) {
			logger.info("GameOver");
			gameinfo.setGameOver(true);
		}
		shape.setState(this); 
	}

	private boolean checkfullstack() {
		if (shape.getY() > maxstack) {
			return true;
		} else {
			return false;
		}
	}
}
