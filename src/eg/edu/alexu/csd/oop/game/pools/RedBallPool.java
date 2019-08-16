package eg.edu.alexu.csd.oop.game.pools;



import java.util.ArrayList;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.RedBallShape;

public class RedBallPool extends ShapesPool{
	private static RedBallPool instance;
	private RedBallPool() {
	super();
	setFreeList(addReusableObjects(getSize()));
	}
	public static RedBallPool getInstance() {
	if (instance == null)
	instance = new RedBallPool();
	return instance;
	}
	private ArrayList<GameObject> addReusableObjects(int size) {
		// TODO Auto-generated method stub
		ArrayList<GameObject> freeList = new ArrayList<GameObject>();
		for (int i = 0; i < size; i++)
		freeList.add(new RedBallShape());
		return freeList;
	}
}