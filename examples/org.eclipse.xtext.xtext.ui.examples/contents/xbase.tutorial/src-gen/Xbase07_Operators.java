import helper.Amount;

@SuppressWarnings("all")
public class Xbase07_Operators {
  public Amount myMethod() throws Throwable {
    Amount _xblockexpression = null;
    {
      final Amount a = new Amount("12.80");
      final Amount b = new Amount("0.20");
      Amount _multiply = b.operator_multiply(3);
      _xblockexpression = (a.operator_plus(_multiply));
    }
    return _xblockexpression;
  }
}
