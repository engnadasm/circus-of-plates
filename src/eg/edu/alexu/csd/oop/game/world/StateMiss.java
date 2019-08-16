package eg.edu.alexu.csd.oop.game.world;

import java.util.List;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class StateMiss implements State{

	GameInfo gameinfo = GameInfo.getInstance();
	private DynamicEnvironment d;
	private List<GameObject> temp;
	@Override
	public void doaction(Shape shape, List<Shape> stack, Logger logger) {
		// TODO Auto-generated method stub
		// Vanish object
//		shape.setVisable(false);
		temp = gameinfo.getMovable();
		temp.remove(shape);
		gameinfo.setMovable(temp);
		shape.setY(0);
		d = gameinfo.getEnvironment();
		d.release(shape, logger);
		gameinfo.setEnvironment(d);
		// shape go to unused
		//shape.setState(this);
	}

}
