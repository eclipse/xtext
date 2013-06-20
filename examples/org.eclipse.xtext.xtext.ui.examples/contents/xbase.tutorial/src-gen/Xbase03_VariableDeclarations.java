@SuppressWarnings("all")
public class Xbase03_VariableDeclarations {
  public String myMethod() throws Throwable {
    String _xblockexpression = null;
    {
      final String x = "A final value";
      String y = "A non-final variable";
      y = "can be modified";
      final String s = "my String";
      String _xblockexpression_1 = null;
      {
        final String s1 = "foo";
        String _plus = (s + s1);
        _xblockexpression_1 = (_plus);
      }
      _xblockexpression = (_xblockexpression_1);
    }
    return _xblockexpression;
  }
}
