package xtend.tutorial.basics;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import xtend.tutorial.util.Amount;
import xtend.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend03_MethodInvocation {
  /**
   * Xtend supports the Java syntax for method calls.
   */
  public String simpleMethodCall_01(final Object myObject) {
    String _string = myObject.toString();
    return _string;
  }
  
  /**
   * If a method does not take arguments you can leave out the
   * parentheses.
   */
  public String simpleMethodCall_02(final Object myObject) {
    String _string = myObject.toString();
    return _string;
  }
  
  /**
   * Static property or method access is done via '::'.
   */
  public String staticProperties() {
    String _xblockexpression = null;
    {
      System.out.println("Hello World!");
      String _println = InputOutput.<String>println("Hello World!");
      _xblockexpression = (_println);
    }
    return _xblockexpression;
  }
  
  /**
   * Properties (i.e. getter and setter) can be accessed using the
   * more readable property-syntax.
   */
  public String propertAccess(final Person person) {
    person.setForename("Joe");
    person.setName("Developer");
    String _forename = person.getForename();
    String _plus = (_forename + " ");
    String _name = person.getName();
    return (_plus + _name);
  }
  
  /**
   * Xtend supports operator overloading.
   * An operator is just a mapping to a method with a special name
   * (starting with the prefix 'operator_') and the correct number of
   * arguments. A table of supported operators and their precedence
   * can be found in the Xbase language reference
   * (see Help->Help Contents).
   * 
   * (Tip: Hover or use F3 over an operator to go to its declaration)
   */
  public Amount operatorOverloading(final Amount a, final Amount b) {
    Amount _plus = a.operator_plus(b);
    return _plus.operator_multiply(2);
  }
  
  /**
   * Extension methods are a special Xtend feature.
   * They allow for adding functions to existing types withot modifying
   * them. Local functions within Xtend classes can be used using the
   * extension syntax by default.
   */
  public String[] extensionMethods(final String string) {
    String[] _splitOnUnderscore = this.splitOnUnderscore(string);
    return _splitOnUnderscore;
  }
  
  public String[] splitOnUnderscore(final String s) {
    return s.split("_");
  }
  
  /**
   * If you put the keyword 'extension' in a 'static' import, the
   * imported static functions can be accessed using the extension
   * syntax as well.
   */
  public List<String> staticExtensionMethods(final String string) {
    List<String> _singletonList = Collections.<String>singletonList("foo");
    return _singletonList;
  }
}
