package testdata;

import testdata.AbstractIntrospectableClosable;
import testdata.CloseException;

@SuppressWarnings("all")
public class IntrospectableClosableExceptionsClose extends AbstractIntrospectableClosable {
  @Override
  public void close() throws CloseException {
    this.isOpen = false;
    throw new CloseException();
  }
}
