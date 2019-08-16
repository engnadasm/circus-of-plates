package eg.edu.alexu.csd.oop.game.objects;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.pools.ShapesPool;

public abstract class AbstractDynamicProgram {
	 private ShapesPool environment;
	 private String name;

	 public void setEnvironment(ShapesPool object, String name) {
	 this.environment = object;
	 this.name = name;
	 } 
	 /**
	 * Allow subclasses to fetch the reference to the environement.
	 */
	 protected ShapesPool getEnvironment() {
	 return environment;
	 }
	 /**
	  * Return the name of this food processing program object.
	  */
	 protected String getName() {
		return name;
	  }
	 /**
	 * A call to this method tells a Dynamic program to start
	 * doing whatever it is supposed to be doing.
	 */
	public abstract void start();
	public abstract GameObject creat(Logger logger);
	public abstract void release(GameObject o, Logger logger);
	public abstract void save();
	public abstract void load();
}
