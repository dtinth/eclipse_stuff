package jpc;

import jpc.expr.Constant;
import jpc.expr.Division;
import jpc.expr.Exponential;
import jpc.expr.Expression;
import jpc.expr.Multiplication;
import jpc.expr.Number;
import jpc.expr.Variable;

public class Main {
	
	public static void main(String[] args) {
		
		Expression expr = new Multiplication(new Multiplication(
				new Division(new Number(4), new Number(3)),
				new Constant("PI")),
				new Exponential(new Variable("r"), new Number(3)));
		
		System.out.println(expr);
		
	}

}
