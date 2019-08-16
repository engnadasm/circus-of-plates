package eg.edu.alexu.csd.oop.game.pools;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public abstract class ShapesPool {
	private ArrayList<GameObject> freeList;
	private ArrayList<GameObject> usedList;
	private ArrayList<GameObject> savedFreeList;
	private ArrayList<GameObject> savedUsedList;
	private static final int size = 20;
	public ShapesPool() {
	usedList = new ArrayList<GameObject>();
	} 

	public GameObject acquire(Logger logger) {
	if (!freeList.isEmpty())
	{
		GameObject object = freeList.remove(0);
		usedList.add(object);
		String name = ((Shape) object).getType();
		name = name.substring(0, name.length()-4);
		logger.info("the shape " + name + " is added in the view");
		return object;
	} else {
		logger.error("No available object to return so return null");
		return null; // No available object to return!
	}
	}
	public void release(GameObject object, Logger logger) {
	if (usedList.remove(object)) {
		freeList.add(object);
		String name = ((Shape) object).getType();
		name = name.substring(0, name.length()-4);
		logger.info("the shape " + name + " is released in the view");
	} else {
		logger.error("no such object in the pool");
	}

	}
	public void setFreeList(ArrayList<GameObject> freeList) {
		this.freeList = freeList;
	}
	public void setUsedList(ArrayList<GameObject> usedList) {
		this.usedList = usedList;
	}
	public int getSize() {
		return size;
	}
	public void saveLists() {
		savedFreeList = freeList;
		savedUsedList = usedList;
	}
	public ArrayList<GameObject> getSavedFreeList(){
		return savedFreeList;
	}
	public ArrayList<GameObject> getSavedUsedList(){
		return savedUsedList;
	}
}
