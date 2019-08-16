package eg.edu.alexu.csd.oop.game.world;

import org.apache.log4j.Logger;

public class ObserverPoints extends Observer {
	private Logger logger;

	public ObserverPoints(GameInfo gameinfo,Logger logger) {
		this.logger = logger;
		this.gameinfo = gameinfo;
		this.gameinfo.attach(this);
	}

	@Override
	public void update() {
		int newScore = gameinfo.getScore() + 1;
		logger.info("your score is " + newScore);
		logger.info("the time becomes " + gameinfo.getTime() + " ms");
		gameinfo.setScore(newScore);
	}

}
