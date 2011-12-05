package org.eclipse.xtext.xtend2.tests.compiler;

import org.eclipse.xtext.xbase.lib.IntegerExtensions;

@SuppressWarnings("all")
public class TestClass1 {
  public int testFunction1() {
    return 42;
  }
  
  public int testFunction2() {
    return 42;
  }
  
  public Integer testFunction3() {
    int _operator_plus = IntegerExtensions.operator_plus(40, 2);
    return Integer.valueOf(_operator_plus);
  }
  
  public Integer testFunction4() {
    int _operator_multiply = IntegerExtensions.operator_multiply(6, 7);
    return Integer.valueOf(_operator_multiply);
  }
}
