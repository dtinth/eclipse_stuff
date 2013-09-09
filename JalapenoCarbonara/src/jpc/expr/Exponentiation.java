package jpc.expr;

public class Exponentiation extends BinaryOperation {

	public Exponentiation(Expression a, Expression b) {
		super("^", a, b);
	}

	@Override
	public Expression reduce() {
		return new Exponentiation(a.reduce(), b.reduce());
	}

	@Override
	public int getPrecedence() {
		return -10;
	}

}
