import org.eclipse.xtext.xbase.lib.Exceptions;

public class Xbase09_Exceptions {
  public Object myMethod() throws Throwable {
    Object _specialblockexpression = null;
    {
      try {
        ((Object) null).toString();
      } catch (final Throwable _t) {
        if (_t instanceof NullPointerException) {
          final NullPointerException e = (NullPointerException)_t;
          RuntimeException _runtimeException = new RuntimeException(e);
          throw _runtimeException;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
      }
      _specialblockexpression = (null);
    }
    return _specialblockexpression;
  }
}
