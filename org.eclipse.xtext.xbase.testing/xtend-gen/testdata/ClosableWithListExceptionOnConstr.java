package testdata;

import testdata.ClosableWithList;

@SuppressWarnings("all")
public class ClosableWithListExceptionOnConstr extends ClosableWithList {
  public ClosableWithListExceptionOnConstr() throws InstantiationException {
    this.getList().add("new");
    throw new InstantiationException();
  }
}
