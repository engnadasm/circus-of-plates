package eg.edu.alexu.csd.oop.game.world;

import java.util.List;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class ObserverView extends Observer {

	private Shape s;
	private List<Shape> stack;
	private List<GameObject> temp;
	private DynamicEnvironment d;
	private Logger logger;

	public ObserverView(GameInfo gameinfo , List<Shape> stack, Logger logger) {
		 this.logger = logger;
		this.gameinfo = gameinfo;
		this.stack = stack;
		this.gameinfo.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	/*	s = stack.remove(stack.size()-1); // remove 3nd shape from Movable & add to unused 
		temp = gameinfo.getMovable();
		temp.remove(s);
		gameinfo.setMovable(temp); 
		d = gameinfo.getEnvironment();
		s.setY(0);
		d.release(s);
		gameinfo.setEnvironment(d); */
		s = stack.remove(stack.size()-1); // remove 2nd shape from controlable & add to unused
		temp = gameinfo.getControlable();
		temp.remove(s);
		gameinfo.setControlable(temp);
		//d = gameinfo.getEnvironment();
		//s.setY(0);
		//s.setMovable(true);
		//d.release(s, logger);
		//gameinfo.setEnvironment(d);
		s = stack.remove(stack.size()-1); // remove 1st shape from controlable & add to unused 
		temp = gameinfo.getControlable();
		temp.remove(s);
		gameinfo.setControlable(temp);
		//d = gameinfo.getEnvironment();
		//s.setY(0);
		//s.setMovable(true);
		//d.release(s, logger);
		//gameinfo.setEnvironment(d);
	}

}
