package xtend.tutorial.basics;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Xtend01_HelloWorld extends TestCase {
  public void testHelloWorld() {
    String _sayHelloTo = this.sayHelloTo("Joe");
    Assert.assertEquals("Hello Joe!", _sayHelloTo);
  }
  
  /**
   * Hello World with explicit return type and explicit return
   * expression.
   */
  public String sayHelloTo(final String to) {
    String _plus = ("Hello " + to);
    return (_plus + "!");
  }
  
  /**
   * Hello World with implicit return type and implicit return
   * expression.
   */
  public String sayHelloTo2(final String to) {
    String _plus = ("Hello " + to);
    String _plus_1 = (_plus + "!");
    return _plus_1;
  }
  
  /**
   * Prints hello world to System.out.
   */
  public void sayHelloToSystemOut(final String to) {
    String _sayHelloTo = this.sayHelloTo(to);
    System.out.println(_sayHelloTo);
  }
  
  /**
   * Uses the shorter extension method.
   */
  public void sayHelloToSystemOut2(final String to) {
    String _sayHelloTo = this.sayHelloTo(to);
    InputOutput.<String>println(_sayHelloTo);
  }
}
