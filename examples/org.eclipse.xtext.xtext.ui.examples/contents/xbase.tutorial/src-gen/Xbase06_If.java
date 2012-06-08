@SuppressWarnings("all")
public class Xbase06_If {
  public static void main(final String[] args) {
    try {
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
        boolean _xifexpression = false;
        int _length_2 = "foo".length();
        boolean _greaterThan_2 = (_length_2 > 3);
        if (_greaterThan_2) {
          _xifexpression = false;
        } else {
          _xifexpression = true;
        }
        if (_xifexpression) {
          /* "Xbase doesn\'t need the ternary operator" */
        }
    } catch (Throwable t) {}
  }
}
