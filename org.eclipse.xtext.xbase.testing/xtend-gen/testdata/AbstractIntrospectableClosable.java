package testdata;

@SuppressWarnings("all")
abstract class AbstractIntrospectableClosable implements AutoCloseable {
  boolean isOpen;
  
  public AbstractIntrospectableClosable() {
    this.isOpen = true;
  }
  
  public boolean isOpen() {
    return this.isOpen;
  }
}
