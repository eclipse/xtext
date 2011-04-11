package xtext.tutorial.basics;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import xtext.tutorial.util.Amount;
import xtext.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend03_MethodInvocation {
  
  public String simpleMethodCall_01(final Object myObject) {
    String _string = myObject.toString();
    return _string;
  }
  
  public String simpleMethodCall_02(final Object myObject) {
    String _string = myObject.toString();
    return _string;
  }
  
  public String staticProperties() {
    String _xblockexpression = null;
    {
      System.out.println("Hello World!");
      String _println = InputOutput.<String>println("Hello World!");
      _xblockexpression = (_println);
    }
    return _xblockexpression;
  }
  
  public String propertAccess(final Person person) {
    {
      person.setForename("Joe");
      person.setName("Developer");
      String _forename = person.getForename();
      String _operator_plus = StringExtensions.operator_plus(_forename, " ");
      String _name = person.getName();
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name);
      return _operator_plus_1;
    }
  }
  
  public Amount operatorOverloading(final Amount a, final Amount b) {
    Amount _operator_plus = a.operator_plus(b);
    Amount _operator_multiply = _operator_plus.operator_multiply(2);
    return _operator_multiply;
  }
  
  public String[] extensionMethods(final String string) {
    String[] _splitOnUnderscore = this.splitOnUnderscore(string);
    return _splitOnUnderscore;
  }
  
  public String[] splitOnUnderscore(final String s) {
    String[] _split = s.split("_");
    return _split;
  }
  
  public List<String> staticExtensionMethods(final String string) {
    List<String> _singletonList = Collections.<String>singletonList("foo");
    return _singletonList;
  }
}