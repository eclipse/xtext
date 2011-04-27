package xtend.tutorial.basics;

import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;

@SuppressWarnings("all")
public class Xtend02_SimpleExpressions {
  
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
  
  public Class<String> clazzLiteral() {
    return java.lang.String.class;
  }
  
  public String casts() {
    String _string = ((String) null).toString();
    return _string;
  }
  
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