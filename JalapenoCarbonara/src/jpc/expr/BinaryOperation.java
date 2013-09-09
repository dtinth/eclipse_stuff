package jpc.expr;

public abstract class BinaryOperation extends Expression {
	
	protected Expression a;
	protected Expression b;
	private String symbol;

	public BinaryOperation(String symbol, Expression a, Expression b) {
		this.symbol = symbol;
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return format(a) + " " + symbol + " " + format(b);
	}

}
