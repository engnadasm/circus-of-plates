package eg.edu.alexu.csd.oop.game.world;

import java.util.List;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.objects.Shape;

public interface State {

	public void doaction(Shape shape , List<Shape> stack,Logger logger);
}
