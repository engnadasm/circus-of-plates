package eg.edu.alexu.csd.oop.game.objects;

import java.util.HashMap;

import eg.edu.alexu.csd.oop.game.GameObject;

public class ShapeFactory {
	private static final HashMap<String, GameObject> shapMap = new HashMap<String, GameObject>();

	public static GameObject Set(String type, GameObject shapesPool) {
		shapesPool.setX((int) (Math.random() * 1250));
		shapesPool.setY(0);
		shapMap.put(type, shapesPool);
		return shapesPool;
	}
}
