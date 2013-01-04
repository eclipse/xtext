public class Xbase03_VariableDeclarations {
  public String myMethod() throws Throwable {
    String _specialblockexpression = null;
    {
      final String x = "A final value";
      String y = "A non-final variable";
      y = "can be modified";
      final String s = "my String";
      String _xblockexpression = null;
      {
        final String s1 = "foo";
        String _plus = (s + s1);
        _xblockexpression = (_plus);
      }
      _specialblockexpression = (_xblockexpression);
    }
    return _specialblockexpression;
  }
}
