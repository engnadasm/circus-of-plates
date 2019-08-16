package eg.edu.alexu.csd.oop.game.world;


public class RightStackEmpty implements EmptyStacks{

	@Override
	public boolean accept(EmptyStackVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
