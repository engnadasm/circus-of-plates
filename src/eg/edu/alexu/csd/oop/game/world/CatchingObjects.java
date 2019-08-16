package eg.edu.alexu.csd.oop.game.world;

import java.util.List;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.Clown;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class CatchingObjects implements EmptyStackVisitor {

	private List<Shape> leftStack;
	private List<Shape> rightStack;
	private Shape object;
	private GameObject clown;
	private GameInfo info;
	private Logger logger;

	public CatchingObjects(Shape object, Logger logger) {
		 this.logger = logger;
		this.object = object;
		clown = Clown.getInstance(logger);
		info = GameInfo.getInstance();
		leftStack = info.getLeftStack();
		rightStack = info.getRightStack();
	}

	@Override
	public boolean visit(NoEmptyStacks noEmpty) {
		// TODO Auto-generated method stub
		Shape lastLeft = leftStack.get(leftStack.size() - 1);
		Shape lastRight = rightStack.get(rightStack.size() - 1);
		if (object.getY() + object.getHeight() == lastLeft.getY()) {
			return full(leftStack);
		} else if (object.getY() + object.getHeight() == lastRight.getY()) {
			return full(rightStack);
		}
		return false;
	}

	@Override
	public boolean visit(LeftStackEmpty leftEmpty) {
		// TODO Auto-generated method stub
		Shape lastRight = rightStack.get(rightStack.size() - 1);
		if (object.getY() + object.getHeight() == clown.getY() + 25 && object.isVisible()) {
			return empty('l');
		} else if (object.getY() + object.getHeight() == lastRight.getY()) {
			return full(rightStack);
		}
		return false;
	}

	@Override
	public boolean visit(RightStackEmpty rightEmpty) {
		// TODO Auto-generated method stub
		Shape lastLeft = leftStack.get(leftStack.size() - 1);
		if (object.getY() + object.getHeight() == clown.getY() + 25 && object.isVisible()) {
			return empty('r');
		} else if (object.getY() + object.getHeight() == lastLeft.getY()) {
			return full(leftStack);
		}
		return false;

	}

	@Override
	public boolean visit(TwoEmptyStacks twoEmpty) {
		// TODO Auto-generated method stub
		if (object.getY() + object.getHeight() == clown.getY() + 25 && object.isVisible()) {
			return empty('r')|| empty('l');
		}
		return false;
	}

	private boolean full(List<Shape> stack) {

		Shape last = stack.get(stack.size() - 1);
		if (Math.abs(last.getX() - object.getX()) <= 20) {
			object.setY(last.getY() - object.getHeight());
			if (stack.size() < 2) {
				State catchnoPoint = new StateCatchnopoint();
				logger.info("the clown catch " + object.getColor() +
						object.getType().substring(0, object.getType().length() - 4)
						+ "Shape");
				catchnoPoint.doaction(object, stack, logger);
			} else {
				Shape prePrev = (Shape) stack.get(stack.size() - 2);
				if (last.getColor().equals(object.getColor()) && prePrev.getColor().equals(object.getColor())) {
					State point = new StateCatchpoint();
					logger.info("the clown catch " + object.getColor() +
							object.getType().substring(0, object.getType().length() - 4) +
							"Shape and scoring a point");
					point.doaction(object, stack, logger);
				} else {
					State noPoint = new StateCatchnopoint();
					logger.info("the clown catch " + object.getColor() +
							object.getType().substring(0, object.getType().length() - 4)
							+ "Shape");
					noPoint.doaction(object, stack, logger);
				}
			}
			return true;
		}
		return false;
	}
	
	private boolean empty(char c) {
		boolean flag = false;
		if (c == 'r') {
			if (Math.abs(clown.getX() + clown.getWidth() - 50 - object.getX()) <= 20) {
				object.setY(clown.getY() + 20);
				State catchnoPoint = new StateCatchnopoint();
				catchnoPoint.doaction(object, rightStack, logger);
				flag = true;
			}
		}
		if (c == 'l') {
			if (Math.abs(clown.getX() - object.getX()) <= 20) {
				object.setY(clown.getY() + 20);
				State catchnoPoint = new StateCatchnopoint();
				catchnoPoint.doaction(object, leftStack, logger);
				flag = true;
			}
		}
		return flag;
	}
}
