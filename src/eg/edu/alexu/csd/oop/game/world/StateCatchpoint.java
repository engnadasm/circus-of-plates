package eg.edu.alexu.csd.oop.game.world;

import java.util.List;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class StateCatchpoint implements State {

	private GameInfo gameinfo = GameInfo.getInstance();
	private List<GameObject> temp;
	private DynamicEnvironment d;

	@Override
	public void doaction(Shape shape, List<Shape> stack,Logger logger) {
		// TODO Auto-generated method stub
	//	stack.add(shape);
		temp = gameinfo.getMovable();
		temp.remove(shape);
		gameinfo.setMovable(temp);
		d = gameinfo.getEnvironment();
		shape.setY(0);
		shape.setMovable(true);
		d.release(shape, logger);
		gameinfo.setEnvironment(d);
		new ObserverView(gameinfo , stack, logger);
		new ObserverPoints(gameinfo, logger);
		new ObserverLevel(gameinfo, logger);
		new ObserverTime(gameinfo, logger);
		gameinfo.notifyAllObservers();
		shape.setState(this);
	}

}
