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
    int _operator_plus = IntegerExtensions.operator_plus(((Integer)40), ((Integer)2));
    return ((Integer)_operator_plus);
  }
  
  public Integer testFunction4() {
    int _operator_multiply = IntegerExtensions.operator_multiply(((Integer)6), ((Integer)7));
    return ((Integer)_operator_multiply);
  }
}