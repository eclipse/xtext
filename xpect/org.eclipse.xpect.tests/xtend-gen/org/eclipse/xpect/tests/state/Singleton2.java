package org.eclipse.xpect.tests.state;

import org.eclipse.xpect.state.Creates;
import org.eclipse.xpect.tests.state.Annotation;
import org.eclipse.xpect.tests.state.MyAnnotaion1;

@SuppressWarnings("all")
public class Singleton2 {
  private final String param;
  
  public Singleton2(@MyAnnotaion1 final String param) {
    this.param = param;
  }
  
  @Creates(Annotation.class)
  public StringBuffer getBuffer() {
    return new StringBuffer(("buffer " + this.param));
  }
}
