package jpc.expr;

public class Subtraction extends BinaryOperation {

	public Subtraction(Expression a, Expression b) {
		super("-", a, b);
	}
	
	@Override
	public Expression reduce() {
		Expression x = a.reduce();
		Expression y = b.reduce();
		if (x instanceof Number && y instanceof Number) {
			return new Number(((Number)x).getValue() - ((Number)y).getValue());
		}
		if (Number.ZERO.equals(x)) return y;
		if (Number.ZERO.equals(y)) return x;
		return new Subtraction(x, y);
	}

	@Override
	public int getPrecedence() {
		return -25;
	}

}
