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
	
	@Override
	public Expression reduce() {
		if (expression instanceof Multiplication) {
			Multiplication multiplication = (Multiplication) expression;
			Expression u = multiplication.a.reduce();
			Expression v = multiplication.b.reduce();
			return new Addition(
						new Multiplication(v, d(u)),
						new Multiplication(u, d(v))
					).reduce();
		} else if (expression instanceof Division) {
			Division division = (Division) expression;
			Expression u = division.a.reduce();
			Expression v = division.b.reduce();
			return new Division(
						new Subtraction(
								new Multiplication(v, d(u)),
								new Multiplication(u, d(v))
								),
						new Exponentiation(v, new Number(2))
					).reduce();
		} else if (expression instanceof Exponentiation) {
			Exponentiation exponentiation = (Exponentiation) expression;
			Expression u = exponentiation.a.reduce();
			Expression v = exponentiation.b.reduce();
			if (u.equals(variable) && v instanceof Number) {
				return new Multiplication(v,
						new Exponentiation(u, new Subtraction(v, new Number(1))));
			}
		} else if (expression instanceof Constant) {
			return new Number(0);
		}
		return this;
	}
	
	private Differentiation d(Expression u) {
		return new Differentiation(u, variable);
	}

}
