package testdata;

import testdata.AbstractIntrospectableClosable;

@SuppressWarnings("all")
public class IntrospectableClosable extends AbstractIntrospectableClosable {
  @Override
  public void close() {
    this.isOpen = false;
  }
}
