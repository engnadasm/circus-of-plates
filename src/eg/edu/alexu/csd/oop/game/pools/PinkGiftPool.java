package eg.edu.alexu.csd.oop.game.pools;


import java.util.ArrayList;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.PinkGiftShape;

public class PinkGiftPool extends ShapesPool{

		private static PinkGiftPool instance;
		private PinkGiftPool() {
		super();
		setFreeList(addReusableObjects(getSize()));
		}
		public static PinkGiftPool getInstance() {
		if (instance == null)
		instance = new PinkGiftPool();
		return instance;
		}
		private ArrayList<GameObject> addReusableObjects(int size) {
			// TODO Auto-generated method stub
			ArrayList<GameObject> freeList = new ArrayList<GameObject>();
			for (int i = 0; i < size; i++)
			freeList.add(new PinkGiftShape());
			return freeList;
		}
}