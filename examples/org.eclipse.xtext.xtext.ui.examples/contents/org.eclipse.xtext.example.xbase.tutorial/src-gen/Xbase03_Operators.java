import helper.Amount;

@SuppressWarnings("all")
public class Xbase03_Operators {
	public static void main(String[] args) {
		
		{
		  final Amount a = new Amount("12.80");
		  final Amount b = new Amount("0.20");
		  Amount _operator_multiply = b.operator_multiply(3);
		  a.operator_plus(_operator_multiply);
		}
	}
}
