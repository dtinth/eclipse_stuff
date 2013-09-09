package jpc.expr;

public class Division extends BinaryOperation {

	public Division(Expression a, Expression b) {
		super("/", a, b);
	}

	@Override
	public Expression reduce() {
		Expression x = a.reduce();
		Expression y = b.reduce();
		if (x instanceof Number && y instanceof Number) {
			return new Number(((Number)x).getValue() / ((Number)y).getValue());
		}
		if (Number.ZERO.equals(x)) return Number.ZERO;
		return new Division(x, y);
	}
	
	@Override
	public int getPrecedence() {
		return -15;
	}

}
