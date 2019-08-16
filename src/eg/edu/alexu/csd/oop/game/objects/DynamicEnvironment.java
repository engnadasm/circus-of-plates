package eg.edu.alexu.csd.oop.game.objects;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.pools.ShapesPool;

public class DynamicEnvironment implements Cloneable{
	private AbstractDynamicProgram n = new ConcreteProgram();
	private Logger logger;

	public DynamicEnvironment(Logger logger) {
		 this.logger = logger;
	}

	 /**
	 * Run the named program
	 * @param programName the name of the program to run.
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void run() {
		File path = new File("lib"+ System.getProperty("file.separator") +"pool2.jar");
		JarFile jarFile = null;
		try {
			jarFile = new JarFile("lib"+ System.getProperty("file.separator") +"pool2.jar");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error("can't get jar of pool");
		}
		Enumeration<JarEntry> e = jarFile.entries();
		ClassLoader loader = null;
		try {
			loader = URLClassLoader.newInstance(new URL[] { path.toURL() }, getClass().getClassLoader());
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		while (e.hasMoreElements()) {
			JarEntry je = e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith(".class")) {
				continue;
			}
			String className = je.getName().substring(0, je.getName().length() - 6);
			className = className.replace('/', '.');
			Class<? extends ShapesPool> cl = null;
			ShapesPool s = null;
			if (!className.equals("eg.edu.alexu.csd.oop.game.pools.ShapesPool")) {
			try {
				cl = (Class<? extends ShapesPool>) loader.loadClass(className);
				Method method = cl.getMethod("getInstance");
				s = (ShapesPool) method.invoke(s);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException | SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					logger.error("the class of " + className.split("\\.")[7] + " can't found in jar");
				}
			className = className.split("\\.")[7];
			n.setEnvironment(s, className);
			n.start();
			}
		}
	}
	
	public GameObject creat(Logger logger) {
		return n.creat(logger);
	}
	public void release(GameObject o, Logger logger) {
		n.release(o, logger);
	}
	public Object clone() {
	      Object clone = null;
	      try {
	         clone = super.clone();
	      } catch (CloneNotSupportedException e) {
				logger.error("can't clone this class");
	      }
	      
	      return clone;
	   }
	public void save() {
		n.save();
	}
	public void load() {
		n.load();
	}
}
