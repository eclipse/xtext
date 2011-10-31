package xtend.tutorial.basics;

import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;

@SuppressWarnings("all")
public class Xtend02_SimpleExpressions {
  /**
   * String literals can be multi-line and can be terminated by
   * either single quotes or double quotes.
   */
  public String stringLiteral() {
    return "Hello World";
  }
  
  public boolean booleanLiteral() {
    boolean _operator_or = false;
    if (true) {
      _operator_or = true;
    } else {
      _operator_or = BooleanExtensions.operator_or(true, false);
    }
    return _operator_or;
  }
  
  public int intLiteral() {
    int _operator_plus = IntegerExtensions.operator_plus(((Integer)42), ((Integer)21));
    return _operator_plus;
  }
  
  public Object nullLiteral() {
    return null;
  }
  
  public ArrayList<String> objectConstruction() {
    ArrayList<String> _arrayList = new ArrayList<String>();
    return _arrayList;
  }
  
  /**
   * The equivalent to Java's String.class is typeof(String).
   */
  public Class<String> clazzLiteral() {
    return java.lang.String.class;
  }
  
  /**
   * The equivalent to Java's ((String)null) is (null as String).
   */
  public String casts() {
    String _string = ((String) null).toString();
    return _string;
  }
  
  /**
   * Variable declaration can occur within a block expression, which
   * in turn can occur where an expression is allowed
   */
  public String variableDeclaration() {
    String _xblockexpression = null;
    {
      final String myString = "Hello World";
      String _xblockexpression_1 = null;
      {
        String _lowerCase = myString.toLowerCase();
        final String myOther = _lowerCase;
        _xblockexpression_1 = (myOther);
      }
      String modifiable = _xblockexpression_1;
      String _upperCase = myString.toUpperCase();
      String _modifiable = modifiable = _upperCase;
      _xblockexpression = (_modifiable);
    }
    return _xblockexpression;
  }
}
