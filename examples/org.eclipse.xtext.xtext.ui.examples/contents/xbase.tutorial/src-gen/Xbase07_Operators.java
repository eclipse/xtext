import helper.Amount;

@SuppressWarnings("all")
public class Xbase07_Operators {
  public Amount myMethod() throws Throwable {
    Amount _xblockexpression = null;
    {
      Amount _amount = new Amount("12.80");
      final Amount a = _amount;
      Amount _amount_1 = new Amount("0.20");
      final Amount b = _amount_1;
      Amount _multiply = b.operator_multiply(3);
      Amount _plus = a.operator_plus(_multiply);
      _xblockexpression = (_plus);
    }
    return _xblockexpression;
  }
}
