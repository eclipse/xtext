@SuppressWarnings("all")
public class Xbase06_If {
  public String myMethod() throws Throwable {
    String _xblockexpression = null;
    {
      int _length = "foo".length();
      boolean _greaterThan = (_length > 3);
      if (_greaterThan) {
        /* "never true!" */
      } else {
        /* "always true!" */
      }
      int _length_1 = "foo".length();
      boolean _greaterThan_1 = (_length_1 > 3);
      if (_greaterThan_1) {
        /* "never true!" */
      }
      String _xifexpression = null;
      boolean _xifexpression_1 = false;
      int _length_2 = "foo".length();
      boolean _greaterThan_2 = (_length_2 > 3);
      if (_greaterThan_2) {
        _xifexpression_1 = false;
      } else {
        _xifexpression_1 = true;
      }
      if (_xifexpression_1) {
        _xifexpression = "Xbase doesn\'t need the ternary operator";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
