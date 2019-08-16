package eg.edu.alexu.csd.oop.game.world;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class SnapShot {

	private LevelStrategy level;
	private int score;
	private long time;
	private List<GameObject> controlable = new ArrayList<GameObject>();
	private List<GameObject> movable = new ArrayList<GameObject>();
	private List<GameObject> constant = new ArrayList<GameObject>();
	private List<Shape> leftStack = new ArrayList<Shape>();
	private List<Shape> rightStack = new ArrayList<Shape>();
	private DynamicEnvironment load;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LevelStrategy getLevel() {
		return level;
	}

	public void setLevel(LevelStrategy level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public List<GameObject> getControlable() {
		return controlable;
	}

	public void setControlable(List<GameObject> controlable) {
		this.controlable = controlable;
	}

	public List<GameObject> getMovable() {
		return movable;
	}

	public void setMovable(List<GameObject> movable) {
		this.movable = movable;
	}

	public List<GameObject> getConstant() {
		return constant;
	}

	public void setConstant(List<GameObject> constant) {
		this.constant = constant;
	}

	public List<Shape> getLeftStack() {
		return leftStack;
	}

	public void setLeftStack(List<Shape> leftStack) {
		this.leftStack = leftStack;
	}

	public List<Shape> getRightStack() {
		return rightStack;
	}

	public void setRightStack(List<Shape> rightStack) {
		this.rightStack = rightStack;
	}

	public DynamicEnvironment getLoad() {
		return load;
	}

	public void setLoad(DynamicEnvironment load) {
		this.load = load;
	}

}
