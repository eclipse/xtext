@SuppressWarnings("all")
public class Xbase04_Casts {
  public int myMethod() throws Throwable {
    int _xblockexpression = (int) 0;
    {
      final CharSequence s = "foo";
      _xblockexpression = ((String) s).length();
    }
    return _xblockexpression;
  }
}
