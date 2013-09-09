package jpc.expr;


public class Constant extends Expression {

	private String name;

	public Constant(String name) {
		this.name = name;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
