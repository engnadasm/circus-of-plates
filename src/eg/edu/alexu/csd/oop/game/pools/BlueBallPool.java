package eg.edu.alexu.csd.oop.game.pools;


import java.util.ArrayList;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.BlueBallShape;

public class BlueBallPool extends ShapesPool{
	private static BlueBallPool instance;
	private BlueBallPool() {
	super();
	setFreeList(addReusableObjects(getSize()));
	}
	public static BlueBallPool getInstance() {
	if (instance == null)
	instance = new BlueBallPool();
	return instance;
	}
	private ArrayList<GameObject> addReusableObjects(int size) {
		// TODO Auto-generated method stub
		ArrayList<GameObject> freeList = new ArrayList<GameObject>();
		for (int i = 0; i < size; i++)
		freeList.add(new BlueBallShape());
		return freeList;
	}
}