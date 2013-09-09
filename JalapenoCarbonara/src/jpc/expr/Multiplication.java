package jpc.expr;

public class Multiplication extends BinaryOperation {

	public Multiplication(Expression a, Expression b) {
		super("*", a, b);
	}

	@Override
	public int getPrecedence() {
		return -20;
	}

}
