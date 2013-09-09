package jpc.expr;

public class Number extends Constant {

	private double value;

	public Number(double value) {
		super(value + "");
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value + "";
	}

}
