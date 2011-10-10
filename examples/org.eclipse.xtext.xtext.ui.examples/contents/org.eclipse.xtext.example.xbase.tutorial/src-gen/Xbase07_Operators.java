import helper.Amount;

@SuppressWarnings("all")
public class Xbase07_Operators {
  public static void main(final String[] args) {
    try {
    	Amount _amount = new Amount("12.80");
    	final Amount a = _amount;
    	Amount _amount_1 = new Amount("0.20");
    	final Amount b = _amount_1;
    	Amount _operator_multiply = b.operator_multiply(3);
    	a.operator_plus(_operator_multiply);
    } catch (Throwable t) {}
  }
}
