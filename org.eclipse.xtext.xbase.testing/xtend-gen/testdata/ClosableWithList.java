package testdata;

import testdata.AbstractClosableWithList;

@SuppressWarnings("all")
public class ClosableWithList extends AbstractClosableWithList {
  @Override
  public void close() {
    this.getList().add("close");
  }
}
