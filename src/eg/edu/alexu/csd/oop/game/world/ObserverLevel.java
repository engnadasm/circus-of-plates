package eg.edu.alexu.csd.oop.game.world;

import org.apache.log4j.Logger;

public class ObserverLevel extends Observer {
	private Logger logger;
	private Iterator t;

	public ObserverLevel(GameInfo gameinfo,Logger logger) {
		 this.logger = logger;
		this.gameinfo = gameinfo;
		t = this.gameinfo.getLevel().getIterator();
		this.gameinfo.attach(this);
	}
	// change levels

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (gameinfo.getScore() >= gameinfo.getLevel().getMaxScore()) {
			if (t.hasNext()) {
				logger.info("you up to next level.");
				gameinfo.setLevel((LevelStrategy) t.getNext());
				long newTime = gameinfo.getTime() + gameinfo.getLevel().getMaxTime();
				logger.info("the time becomes " + (newTime - (60 * gameinfo.getCount())));
				gameinfo.setStartTime(System.currentTimeMillis());
				gameinfo.setTime(newTime);
			}
		}
	}
}
