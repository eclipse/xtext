package xtend.tutorial.basics;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xtend01_HelloWorld extends TestCase {
  
  public void testHelloWorld() {
    String _sayHelloTo = this.sayHelloTo("Joe");
    Assert.assertEquals("Hello Joe!", _sayHelloTo);
  }
  
  public String sayHelloTo(final String to) {
    String _operator_plus = StringExtensions.operator_plus("Hello ", to);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "!");
    return _operator_plus_1;
  }
  
  public String sayHelloTo2(final String to) {
    String _operator_plus = StringExtensions.operator_plus("Hello ", to);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "!");
    return _operator_plus_1;
  }
  
  public void sayHelloToSystemOut(final String to) {
    String _sayHelloTo = this.sayHelloTo(to);
    System.out.println(_sayHelloTo);
  }
  
  public void sayHelloToSystemOut2(final String to) {
    String _sayHelloTo = this.sayHelloTo(to);
    InputOutput.<String>println(_sayHelloTo);
  }
}