package xtend.tutorial.basics;

import java.math.BigInteger;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
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
    int _operator_plus = IntegerExtensions.operator_plus(14, 0x0e);
    int _operator_plus_1 = IntegerExtensions.operator_plus(_operator_plus, 016);
    return _operator_plus_1;
  }
  
  public double doubleLiteral() {
    double _operator_plus = DoubleExtensions.operator_plus(14d, 0.14e2);
    double _operator_multiply = DoubleExtensions.operator_multiply(1.4, 10d);
    double _operator_plus_1 = DoubleExtensions.operator_plus(_operator_plus, _operator_multiply);
    return _operator_plus_1;
  }
  
  public BigInteger bigIntegerLiteral() {
    return new BigInteger("123456789123456789123456789", 10);
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
