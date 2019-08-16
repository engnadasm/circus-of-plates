package eg.edu.alexu.csd.oop.game.world;

public class Medium implements LevelStrategy {

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 2;
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
		return 10;
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new LevelIterator(this);
	}

	@Override
	public int frequency() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public String level() {
		// TODO Auto-generated method stub
		return "Medium";
	}

}
