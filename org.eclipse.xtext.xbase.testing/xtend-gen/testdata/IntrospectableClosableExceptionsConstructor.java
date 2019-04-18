package testdata;

import testdata.AbstractIntrospectableClosable;

@SuppressWarnings("all")
public class IntrospectableClosableExceptionsConstructor extends AbstractIntrospectableClosable {
  public IntrospectableClosableExceptionsConstructor() throws InstantiationException {
    this.isOpen = true;
    throw new InstantiationException();
  }
  
  @Override
  public void close() {
    this.isOpen = false;
  }
}
