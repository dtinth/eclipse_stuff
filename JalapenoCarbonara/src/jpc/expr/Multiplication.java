package jpc.expr;

public class Multiplication extends BinaryOperation {
	
	public Multiplication(Expression a, Expression b) {
		super("*", a, b);
	}

	@Override
	public Expression reduce() {
		Expression x = a.reduce();
		Expression y = b.reduce();
		if (Number.ZERO.equals(x)) return Number.ZERO;
		if (Number.ZERO.equals(y)) return Number.ZERO;
		return new Multiplication(x, y);
	}
	
	@Override
	public int getPrecedence() {
		return -20;
	}

}
