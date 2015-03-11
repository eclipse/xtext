@SuppressWarnings("all")
public class Xbase03_VariableDeclarations {
  public String myMethod() throws Throwable {
    String _xblockexpression = null;
    {
      final String x = "A final value";
      /* x; */
      String y = "A non-final variable";
      /* y; */
      y = "can be modified";
      final String s = "my String";
      /* s; */
      String _xblockexpression_1 = null;
      {
        final String s1 = "foo";
        _xblockexpression_1 = (s + s1);
      }
      _xblockexpression = _xblockexpression_1;
    }
    return _xblockexpression;
  }
}
