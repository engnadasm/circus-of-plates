package eg.edu.alexu.csd.oop.game.objects;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.pools.ShapesPool;

public class ConcreteProgram extends AbstractDynamicProgram {
	private ArrayList<ShapesPool> classesList = new ArrayList<ShapesPool>();
	private ArrayList<String> namesList = new ArrayList<String>();
	/**
	 * A call to this method tells a program to start
	 * doing whatever it is supposed to be doing.
	 */
	public void start() {
		 classesList.add(getEnvironment());
		 namesList.add(getName());
		 //System.out.println(getName());
	 }
	 
	 public GameObject creat(Logger logger) {
		 int index = (int)(Math.random() * (classesList.size()));
		 //System.out.println(index);
		 ShapesPool create = classesList.get(index);
		 String name = namesList.get(index);
		 GameObject shape = create.acquire(logger);
		 shape = ShapeFactory.Set(name, shape);
		 return shape;
	 }

	@Override
	public void release(GameObject o, Logger logger) {
		// TODO Auto-generated method stub
			int index = namesList.indexOf((String)((Shape) o).getType());
			classesList.get(index).release(o, logger);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		for (int i = 0; i < classesList.size(); i++) {
			classesList.get(i).saveLists();
		}
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		for (int i = 0; i < classesList.size(); i++) {
			classesList.get(i).setFreeList(classesList.get(i).getSavedFreeList());
			classesList.get(i).setUsedList(classesList.get(i).getSavedUsedList());
		}
	}
	 
}