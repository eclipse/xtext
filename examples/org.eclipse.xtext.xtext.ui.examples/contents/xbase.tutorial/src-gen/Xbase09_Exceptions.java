import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Xbase09_Exceptions {
  public Object myMethod() throws Throwable {
    Object _xblockexpression = null;
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
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
}
