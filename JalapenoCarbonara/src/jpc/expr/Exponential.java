package jpc.expr;

public class Exponential extends BinaryOperation {

	public Exponential(Expression a, Expression b) {
		super("^", a, b);
	}

	@Override
	public int getPrecedence() {
		return -10;
	}

}
