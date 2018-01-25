package calculator.operator;

public class OperatorFactory {
	
	public OperatorFactory() {
		
	}
	
	public Operator createOperator(String op) {
		if(op.equals("+")) {
			return new PlusOperator();
		}
		else if(op.equals("*")) {
			return new MultiplicationOperator();
		}
		else if(op.equals("-")) {
			return new SubtractionOperator();
		}
		else {
			return new DivisionOperator();
		}
	}
}
