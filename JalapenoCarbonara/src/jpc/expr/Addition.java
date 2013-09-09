package jpc.expr;

public class Addition extends BinaryOperation {

	public Addition(Expression a, Expression b) {
		super("+", a, b);
	}
	
	@Override
	public Expression reduce() {
		Expression x = a.reduce();
		Expression y = b.reduce();
		if (x instanceof Number && y instanceof Number) {
			return new Number(((Number)x).getValue() + ((Number)y).getValue());
		}
		if (Number.ZERO.equals(x)) return y;
		if (Number.ZERO.equals(y)) return x;
		return new Addition(x, y);
	}

	@Override
	public int getPrecedence() {
		return -30;
	}

}
