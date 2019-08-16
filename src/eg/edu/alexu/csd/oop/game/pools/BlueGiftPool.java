package eg.edu.alexu.csd.oop.game.pools;


import java.util.ArrayList;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.BlueGiftShape;

public class BlueGiftPool extends ShapesPool{
	private static BlueGiftPool instance;
	private BlueGiftPool() {
	super();
	setFreeList(addReusableObjects(getSize()));
	}
	public static BlueGiftPool getInstance() {
	if (instance == null)
	instance = new BlueGiftPool();
	return instance;
	}
	private ArrayList<GameObject> addReusableObjects(int size) {
		// TODO Auto-generated method stub
		ArrayList<GameObject> freeList = new ArrayList<GameObject>();
		for (int i = 0; i < size; i++)
		freeList.add(new BlueGiftShape());
		return freeList;
	}
}
