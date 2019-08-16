package eg.edu.alexu.csd.oop.game.pools;


import java.util.ArrayList;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.RedGiftShape;

public class RedGiftPool extends ShapesPool{

		private static RedGiftPool instance;
		private RedGiftPool() {
		super();
	setFreeList(addReusableObjects(getSize()));
		}
		public static RedGiftPool getInstance() {
		if (instance == null)
		instance = new RedGiftPool();
		return instance;
		}
		private ArrayList<GameObject> addReusableObjects(int size) {
			// TODO Auto-generated method stub
			ArrayList<GameObject> freeList = new ArrayList<GameObject>();
			for (int i = 0; i < size; i++)
			freeList.add(new RedGiftShape());
			return freeList;
		}
}
