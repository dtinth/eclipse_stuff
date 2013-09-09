package jpc.expr;

public class Division extends BinaryOperation {

	public Division(Expression a, Expression b) {
		super("/", a, b);
	}

	@Override
	public int getPrecedence() {
		return -15;
	}

}
