package testdata;

import testdata.AbstractClosableWithList;
import testdata.CloseException;

@SuppressWarnings("all")
public class ClosableWithListExceptionOnClose extends AbstractClosableWithList {
  @Override
  public void close() throws CloseException {
    this.getList().add("close");
    throw new CloseException();
  }
}
