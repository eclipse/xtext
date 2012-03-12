package xtend.tutorial.basics;

import java.math.BigInteger;
import java.util.ArrayList;

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
    boolean _or = false;
    if (true) {
      _or = true;
    } else {
      _or = (true || false);
    }
    return _or;
  }
  
  public int intLiteral() {
    int _plus = (14 + 0x0e);
    int _plus_1 = (_plus + 016);
    return _plus_1;
  }
  
  public double doubleLiteral() {
    double _plus = (14d + 0.14e2);
    double _multiply = (1.4 * 10d);
    double _plus_1 = (_plus + _multiply);
    return _plus_1;
  }
  
  public BigInteger bigIntegerLiteral() {
    return new BigInteger("123456789123456789123456789");
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
    return String.class;
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
        final String myOther = myString.toLowerCase();
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
