package org.eclipse.xpect.tests.state;

import org.eclipse.xpect.state.Creates;

@SuppressWarnings("all")
public class Singleton1 {
  @Creates
  public StringBuffer getBuffer() {
    return new StringBuffer("buffer");
  }
}
