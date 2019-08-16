package eg.edu.alexu.csd.oop.game.pools;


import java.util.ArrayList;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.PinkBallShape;

public class PinkBallPool extends ShapesPool{
	private static PinkBallPool instance;
	private PinkBallPool() {
	super();
	setFreeList(addReusableObjects(getSize()));
	}
	public static PinkBallPool getInstance() {
	if (instance == null)
	instance = new PinkBallPool();
	return instance;
	}
	private ArrayList<GameObject> addReusableObjects(int size) {
		// TODO Auto-generated method stub
		ArrayList<GameObject> freeList = new ArrayList<GameObject>();
		for (int i = 0; i < size; i++)
		freeList.add(new PinkBallShape());
		return freeList;
	}
}

