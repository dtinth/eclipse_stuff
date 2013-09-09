package jpc.expr;

public abstract class Expression {
	
	public abstract int getPrecedence();
	
	protected String format(Expression another) {
		if (another.getPrecedence() <= getPrecedence()) {
			return "(" + another + ")";
		} else {
			return "" + another;
		}
	}
	
	public Expression reduce() {
		return this;
	}
	
}
