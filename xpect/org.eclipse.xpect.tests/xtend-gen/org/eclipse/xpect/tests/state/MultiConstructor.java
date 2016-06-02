package org.eclipse.xpect.tests.state;

import org.eclipse.xpect.state.Creates;

@SuppressWarnings("all")
public class MultiConstructor {
  private final String value;
  
  public MultiConstructor(final CharSequence i) {
    String _string = i.toString();
    this.value = _string;
  }
  
  public MultiConstructor() {
    this.value = "default";
  }
  
  public MultiConstructor(final String value) {
    this.value = value;
  }
  
  @Creates
  public Object get() {
    return this.value;
  }
}
