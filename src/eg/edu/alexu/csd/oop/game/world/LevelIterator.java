package eg.edu.alexu.csd.oop.game.world;

public class LevelIterator implements Iterator {

	private LevelStrategy current;

	public LevelIterator(LevelStrategy current) {
		this.current = current;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (current instanceof Hard) {
			return false;
		}
		return true;
	}

	@Override
	public Object getNext() {
		// TODO Auto-generated method stub
		if (this.hasNext()) {
			if (current instanceof Easy) {
				return new Medium();
			}
			return new Hard();
		}
		return null;
	}

}
