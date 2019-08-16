package eg.edu.alexu.csd.oop.game.world;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class GameInfo {

	private static GameInfo instance = null;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private LevelStrategy level;
	private int score;
	private long time;
	private long startTime;
	private List<GameObject> controlable = new ArrayList<GameObject>();
	private List<GameObject> movable = new ArrayList<GameObject>();
	private List<GameObject> constant = new ArrayList<GameObject>();
	private List<Shape> leftStack = new ArrayList<Shape>();
	private List<Shape> rightStack = new ArrayList<Shape>();
	private DynamicEnvironment load;
	private boolean gameOver = false;
	private int countTime = 0;

	private GameInfo() {
	}

	public static GameInfo getInstance() {
		if (instance == null) {
			instance = new GameInfo();
		}
		return instance;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setEnvironment(DynamicEnvironment load) {
		this.load = load;
	}

	public DynamicEnvironment getEnvironment() {
		return load;
	}

	public List<GameObject> getConstant() {
		return constant;
	}

	public void setConstant(List<GameObject> constant) {
		this.constant = constant;
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

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
		observers = new ArrayList<Observer>();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public LevelStrategy getLevel() {
		return level;
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

	public void setLevel(LevelStrategy level) {
		this.level = level;
	}

	public ScoreMemento saveScoreToMemento() {
		return new ScoreMemento(score);
	}

	public int getScoreFromMemento(ScoreMemento memento) {
		return memento.getScore();
	}
	
	public int getCount() {
		return countTime;
	}
	
	public void setCount(int count) {
		countTime = count;
	}
}
