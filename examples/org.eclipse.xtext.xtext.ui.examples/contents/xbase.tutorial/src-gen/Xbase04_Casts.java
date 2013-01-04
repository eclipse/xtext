public class Xbase04_Casts {
  public int myMethod() throws Throwable {
    int _specialblockexpression = (int) 0;
    {
      final CharSequence s = "foo";
      int _length = ((String) s).length();
      _specialblockexpression = (_length);
    }
    return _specialblockexpression;
  }
}
