package eg.edu.alexu.csd.oop.game.world;

import java.util.LinkedList;
import java.util.List;

public class ScoreMementoList {

	private List<ScoreMemento> scores = new LinkedList<ScoreMemento>();
	private static ScoreMementoList list = null;

	private ScoreMementoList() {
		
	}

	public static ScoreMementoList getInstance() {
		if (list == null) {
			list = new ScoreMementoList();
		}
		return list;
	}
	public void addScore(ScoreMemento memento) {
		scores.add(memento);
	}

	public ScoreMemento get(int index){
	      return scores.get(index);
	   }
}
