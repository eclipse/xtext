package org.eclipse.xtend.core.tests.smoke;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Case_1 {
  @Accessors
  private int id;
  
  public int testFunction1() {
    return 42;
  }
  
  public int testFunction2() {
    return 42;
  }
  
  public Integer testFunction3() {
    return Integer.valueOf(42);
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
}
