@SuppressWarnings("all")
public class Xbase04_Casts {
  public int myMethod() throws Throwable {
    int _xblockexpression = (int) 0;
    {
      final CharSequence s = "foo";
      int _length = ((String) s).length();
      _xblockexpression = (_length);
    }
    return _xblockexpression;
  }
}
