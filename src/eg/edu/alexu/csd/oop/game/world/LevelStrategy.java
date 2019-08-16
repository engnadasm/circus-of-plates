package eg.edu.alexu.csd.oop.game.world;

public interface LevelStrategy {

	int getSpeed();
	int getControlSpeed();
	int getMaxTime();
	int getMaxScore();
	int frequency();
	Iterator getIterator();
	String level();
}
