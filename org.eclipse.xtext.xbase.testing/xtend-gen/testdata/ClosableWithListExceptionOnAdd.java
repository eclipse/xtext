package testdata;

import testdata.ClosableWithList;
import testdata.TryBodyException;

@SuppressWarnings("all")
public class ClosableWithListExceptionOnAdd extends ClosableWithList {
  public void addExc() throws TryBodyException {
    this.getList().add("exception");
    throw new TryBodyException();
  }
}
