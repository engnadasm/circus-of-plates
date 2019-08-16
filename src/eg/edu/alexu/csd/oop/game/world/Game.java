package eg.edu.alexu.csd.oop.game.world;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.objects.BackGroundPic;
import eg.edu.alexu.csd.oop.game.objects.Clown;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class Game implements World {

	private GameObject clown;
	private GameObject object;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int create = 0;
	private GameInfo info;
	// private int gameCount;
	private static Logger logger;
	private SnapShot snapShot;
	// ScoreMementoList scores = ScoreMementoList.getInstance();
	private int countTime = 0;

	public Game(LevelStrategy level) {
		logger = Logger.getLogger(Game.class.getSimpleName());
		PropertyConfigurator.configure("log4j.properties");
		logger.info("you start new game");
		info = GameInfo.getInstance();
		info.setScore(0);
		info.setLevel(level);
		info.setTime(level.getMaxTime());
		info.setEnvironment(new DynamicEnvironment(logger));
		info.setRightStack(new LinkedList<Shape>());
		info.setLeftStack(new LinkedList<Shape>());
		info.setControlable(new LinkedList<GameObject>());
		info.setMovable(new LinkedList<GameObject>());
		info.setConstant(new LinkedList<GameObject>());
		info.setStartTime(System.currentTimeMillis());
		info.getEnvironment().run();
		// startTime = System.currentTimeMillis();
		clown = Clown.getInstance(logger);
		info.getControlable().add(clown);
		info.getConstant().add(new BackGroundPic(logger));
		// gameCount = 3;
	}

	@Override
	public List<GameObject> getConstantObjects() {
		// TODO Auto-generated method stub
		return new LinkedList<GameObject>();
		// return info.getConstant();
	}

	@Override
	public List<GameObject> getMovableObjects() {
		// TODO Auto-generated method stub
		return info.getMovable();
	}

	@Override
	public List<GameObject> getControlableObjects() {
		// TODO Auto-generated method stub
		return info.getControlable();
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return screenSize.width - 100;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize.height - 100;
	}

	@Override
	public boolean refresh() {
		// TODO Auto-generated method stub
		if(create % 10 == 0) {
		countTime++;
		}
		info.setCount(countTime);
		boolean timeOut;
		if ((Math.max(0, info.getTime() - countTime * 60) / 1000) == 0) {
			timeOut = true;
		} else {
			timeOut = false;
		}
		if (!timeOut) {
			create++;
			if (create % info.getLevel().frequency() == 0) {
				object = info.getEnvironment().creat(logger);
				info.getMovable().add(object);
			}
			for (int i = 0; i < info.getMovable().size(); i++) {
				Shape x = (Shape) info.getMovable().get(i);
				x.setY(x.getY() + 1);
				if (x.getY() == screenSize.height - 200) {
					State miss = new StateMiss();
					miss.doaction(x, null, logger);
					i--;
				}
			}
			for (int i = 0; i < info.getMovable().size(); i++) {
				Shape x = (Shape) info.getMovable().get(i);
				// x.setY(x.getY() + 1);
				if (x.getY() + x.getHeight() == clown.getY() + 25 || !info.getLeftStack().isEmpty()
						&& x.getY() + x.getHeight() == info.getLeftStack().get(info.getLeftStack().size() - 1).getY()
						|| !info.getRightStack().isEmpty() && x.getY() + x.getHeight() == info.getRightStack()
								.get(info.getRightStack().size() - 1).getY()) {
					// System.out.println(true);
					EmptyStackVisitor visitor = new CatchingObjects(x, logger);
					if (info.getLeftStack().isEmpty() && info.getRightStack().isEmpty()) {
						EmptyStacks two = new TwoEmptyStacks();
						if (two.accept(visitor)) {
							i--;
						}
					} else if (info.getLeftStack().isEmpty()) {
						EmptyStacks left = new LeftStackEmpty();
						if (left.accept(visitor)) {
							i--;
						}
					} else if (info.getRightStack().isEmpty()) {
						EmptyStacks right = new RightStackEmpty();
						if (right.accept(visitor)) {
							i--;
						}
					} else {
						EmptyStacks noEmpty = new NoEmptyStacks();
						if (noEmpty.accept(visitor)) {
							i--;
						}
					}
				}
			}
			return true;
		}
		// gameCount--;
		// scores.addScore(info.saveScoreToMemento());
		// g.changeWorld(new eg.edu.alexu.csd.oop.game.world.Game(new Easy()));
		return false;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		/*
		 * if (gameCount == 1 && info.getTime() == 1000) { return "Scores: First Game:"
		 * + info.getScoreFromMemento(scores.get(0)) + "    Second Game:" +
		 * info.getScoreFromMemento(scores.get(1)) + "    Third Game:" +
		 * info.getScoreFromMemento(scores.get(2)); }
		 */
		return "Score = " + info.getScore() + "     Time = " + Math.max(0, info.getTime() - countTime * 60) / 1000
				+ "     Level: " + info.getLevel().level();
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return 10;
	}

	public void SaveSnapShot() {
		snapShot = new SnapShot();
		LinkedList<GameObject> temp = new LinkedList<GameObject>();
		LinkedList<Shape> temp1;
		Clown c = Clown.getInstance(logger);
		c.setSavedX(c.getX());
		c.setSavedY(c.getY());
		temp.add(c);
		for (int i = 1; i < info.getControlable().size(); i++) {
			Shape x = (Shape) info.getControlable().get(i);
			Shape y = (Shape) x.clone();
			temp.add(y);
		}
		snapShot.setControlable(temp);
		temp = new LinkedList<GameObject>();
		for (int i = 0; i < info.getMovable().size(); i++) {
			Shape x = (Shape) info.getMovable().get(i);
			Shape y = (Shape) x.clone();
			temp.add(y);
		}
		snapShot.setMovable(temp);
		/*
		 * temp = new LinkedList<GameObject>(); for (int i = 0; i <
		 * info.getConstant().size(); i++) { Shape x = (Shape)
		 * info.getConstant().get(i); Shape y = (Shape) x.clone(); temp.add(y); }
		 * snapShot.setConstant(temp);
		 */
		temp1 = new LinkedList<Shape>();
		for (int i = 0; i < info.getLeftStack().size(); i++) {
			Shape x = info.getLeftStack().get(i);
			temp1.add(x);
		}
		snapShot.setLeftStack(temp1);
		temp1 = new LinkedList<Shape>();
		for (int i = 0; i < info.getRightStack().size(); i++) {
			Shape x = info.getRightStack().get(i);
			temp1.add(x);
		}
		snapShot.setRightStack(temp1);
		if (info.getLevel() instanceof Easy) {
			snapShot.setLevel(new Easy());
		} else if (info.getLevel() instanceof Medium) {
			snapShot.setLevel(new Medium());
		} else if (info.getLevel() instanceof Hard) {
			snapShot.setLevel(new Hard());
		}
		info.getEnvironment().save();
		snapShot.setLoad((DynamicEnvironment) info.getEnvironment().clone());
		snapShot.setScore(info.getScore());
		snapShot.setTime(info.getTime());
		snapShot.setCount(info.getCount());
	}

	public void loadSnapShot() {
		if (snapShot != null) {
			LinkedList<GameObject> temp = new LinkedList<GameObject>();
			LinkedList<Shape> temp1;
			Clown c = Clown.getInstance(logger);
			c.setX(c.getSavedX());
			c.setY(c.getSavedY());
			temp.add(c);
			for (int i = 1; i < snapShot.getControlable().size(); i++) {
				Shape x = (Shape) snapShot.getControlable().get(i);
				Shape y = (Shape) x.clone();
				temp.add(y);
			}
			info.setControlable(temp);
			temp = new LinkedList<GameObject>();
			for (int i = 0; i < snapShot.getMovable().size(); i++) {
				Shape x = (Shape) snapShot.getMovable().get(i);
				Shape y = (Shape) x.clone();
				temp.add(y);
			}
			info.setMovable(temp);
			/*
			 * temp = new LinkedList<GameObject>(); for (int i = 0; i <
			 * snapShot.getConstant().size(); i++) { Shape x = (Shape)
			 * snapShot.getConstant().get(i); Shape y = (Shape) x.clone(); temp.add(y); }
			 * info.setConstant(temp);
			 */
			temp1 = new LinkedList<Shape>();
			for (int i = 0; i < snapShot.getLeftStack().size(); i++) {
				Shape x = snapShot.getLeftStack().get(i);
				temp1.add(x);
			}
			info.setLeftStack(temp1);
			temp1 = new LinkedList<Shape>();
			for (int i = 0; i < snapShot.getRightStack().size(); i++) {
				Shape x = snapShot.getRightStack().get(i);
				temp1.add(x);
			}
			info.setRightStack(temp1);
			info.setLevel(snapShot.getLevel());
			info.setEnvironment((DynamicEnvironment) snapShot.getLoad().clone());
			info.getEnvironment().load();
			info.setScore(snapShot.getScore());
			info.setStartTime(System.currentTimeMillis());
			info.setTime(snapShot.getTime());
			info.setCount(snapShot.getCount());
		}
	}
}
