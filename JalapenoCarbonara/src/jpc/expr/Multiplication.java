package jpc.expr;

public class Multiplication extends BinaryOperation {
	
	public Multiplication(Expression a, Expression b) {
		super("*", a, b);
	}

	@Override
	public Expression reduce() {
		Expression x = a.reduce();
		Expression y = b.reduce();
		if (x instanceof Number && y instanceof Number) {
			return new Number(((Number)x).getValue() * ((Number)y).getValue());
		}
		if (x instanceof Multiplication && y instanceof Multiplication) {
			Multiplication u = (Multiplication)x;
			Multiplication v = (Multiplication)y;
			// (a*b) * (c*d) = ((a*b)*c)*d
			return new Multiplication(new Multiplication(u, v.a), v.b).reduce();
		}
		if (x instanceof Multiplication) {
			Multiplication u = (Multiplication)x;
			if (!(u.b instanceof Number) && y instanceof Number) {
				return new Multiplication(new Multiplication(u.a, y), u.b).reduce();
			}
		}
		if (Number.ZERO.equals(x)) return Number.ZERO;
		if (Number.ZERO.equals(y)) return Number.ZERO;
		return new Multiplication(x, y);
	}
	
	@Override
	public int getPrecedence() {
		return -20;
	}

}
