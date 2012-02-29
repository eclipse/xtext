package org.eclipse.xtend.core.tests.compiler;

@SuppressWarnings("all")
public class TestClass1 {
  public int testFunction1() {
    return 42;
  }
  
  public int testFunction2() {
    return 42;
  }
  
  public Integer testFunction3() {
    int _plus = (40 + 2);
    return Integer.valueOf(_plus);
  }
  
  public Integer testFunction4() {
    return Integer.valueOf((6 * 7));
  }
}
