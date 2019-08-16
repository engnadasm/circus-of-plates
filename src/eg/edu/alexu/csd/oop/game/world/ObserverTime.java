package eg.edu.alexu.csd.oop.game.world;

import org.apache.log4j.Logger;

public class ObserverTime extends Observer{
	private Logger logger;

	public ObserverTime(GameInfo gameinfo, Logger logger) {
		 this.logger = logger;
		this.gameinfo = gameinfo;
		this.gameinfo.attach(this);
	}
	@Override
	public void update() {
		long newTime = gameinfo.getTime() + 15*1000;
		logger.info("the time becomes " + (newTime- (60 * gameinfo.getCount())));
		gameinfo.setStartTime(System.currentTimeMillis());
		gameinfo.setTime(newTime);
	}

}
