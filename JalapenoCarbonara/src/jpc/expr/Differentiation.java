package jpc.expr;

public class Differentiation extends Expression {

	private Expression expression;
	private Variable variable;

	public Differentiation(Expression expression, Variable variable) {
		this.expression = expression;
		this.variable = variable;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "d(" + expression + ")/d" + variable;
	}

}
