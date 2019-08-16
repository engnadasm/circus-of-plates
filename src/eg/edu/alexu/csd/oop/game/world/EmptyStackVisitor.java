package eg.edu.alexu.csd.oop.game.world;


public interface EmptyStackVisitor {

	boolean visit(NoEmptyStacks noEmpty);
	boolean visit(LeftStackEmpty leftEmpty);
	boolean visit(RightStackEmpty rightEmpty);
	boolean visit(TwoEmptyStacks twoEmpty);
}
