package org.eclipse.xtext.xtend2.tests.compiler;

import org.eclipse.xtext.xbase.lib.IntegerExtensions;

public class TestClass1 {
  private final TestClass1 _this = this;
  
  public Integer testFunction1() {
    return 42;
  }
  
  public Integer testFunction2() {
    return 42;
  }
  
  public Integer testFunction3() {
    int _operator_plus = IntegerExtensions.operator_plus(40, 2);
    return ((Integer)_operator_plus);
  }
  
  public Integer testFunction4() {
    int _operator_multiply = IntegerExtensions.operator_multiply(6, 7);
    return _operator_multiply;
  }
}