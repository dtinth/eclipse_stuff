package jpc.expr;

public class Exponential extends BinaryOperation {

	public Exponential(Expression a, Expression b) {
		super("^", a, b);
	}

	@Override
	public Expression reduce() {
		return new Exponential(a.reduce(), b.reduce());
	}

	@Override
	public int getPrecedence() {
		return -10;
	}

}
