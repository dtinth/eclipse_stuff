package jpc.expr;


public class Variable extends Expression {

	private String name;

	public Variable(String name) {
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
