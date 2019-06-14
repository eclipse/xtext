package testdata;

import testdata.AbstractClosableWithList;
import testdata.CloseException;

@SuppressWarnings("all")
public class ClosableWithListExceptionOnClose extends AbstractClosableWithList {
  @Override
  public void close() throws CloseException {
    this.list.add("close");
    throw new CloseException();
  }
}
