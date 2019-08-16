package eg.edu.alexu.csd.oop.game.world;

public class Hard implements LevelStrategy {

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

	@Override
	public int getMaxTime() {
		// TODO Auto-generated method stub
		return 60 * 1000;
	}

	@Override
	public int getMaxScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new LevelIterator(this);
	}

	@Override
	public int frequency() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public String level() {
		// TODO Auto-generated method stub
		return "Hard";
	}

}
