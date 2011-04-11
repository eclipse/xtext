package xtext.tutorial.basics;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import xtext.tutorial.util.Circle;
import xtext.tutorial.util.Rectangle;
import xtext.tutorial.util.Shape;

@SuppressWarnings("all")
public class Xtend04_ControlStructures {
  
  public int ifExpression(final String param) {
    int _xifexpression = (int)-1;
    final String typeConverted_param = (String)param;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(typeConverted_param, null);
    if (_operator_notEquals) {
      int _length = param.length();
      _xifexpression = _length;
    } else {
      _xifexpression = 0;
    }
    return _xifexpression;
  }
  
  public int ifExpression_01(final String param) {
    String _xifexpression = null;
    final String typeConverted_param = (String)param;
    boolean _operator_equals = ObjectExtensions.operator_equals(typeConverted_param, "foo");
    if (_operator_equals) {
      _xifexpression = "bar";
    } else {
      _xifexpression = "baz";
    }
    int _ifExpression = this.ifExpression(_xifexpression);
    return _ifExpression;
  }
  
  public int ifExpression_02(final String param) {
    String _xifexpression = null;
    final String typeConverted_param = (String)param;
    boolean _operator_equals = ObjectExtensions.operator_equals(typeConverted_param, "bar");
    if (_operator_equals) {
      _xifexpression = "foo";
    }
    int _ifExpression_01 = this.ifExpression_01(_xifexpression);
    return _ifExpression_01;
  }
  
  public String switchExpression_01(final Shape shape) {
    String _switchResult = null;
    final Shape shape_1 = shape;
    boolean matched = false;
    if (!matched) {
      if (shape_1 instanceof Circle) {
        final Circle shape_2 = (Circle) shape_1;
        matched=true;
        String _operator_plus = StringExtensions.operator_plus("a circle : diameter=", ((Object)shape_2.diameter));
        _switchResult = _operator_plus;
      }
    }
    if (!matched) {
      if (shape_1 instanceof Rectangle) {
        final Rectangle shape_3 = (Rectangle) shape_1;
        boolean _operator_equals = ObjectExtensions.operator_equals(((Object)shape_3.height), ((Object)shape_3.width));
        if (_operator_equals) {
          matched=true;
          String _operator_plus_1 = StringExtensions.operator_plus("a square : size=", ((Object)shape_3.width));
          _switchResult = _operator_plus_1;
        }
      }
    }
    if (!matched) {
      if (shape_1 instanceof Rectangle) {
        final Rectangle shape_4 = (Rectangle) shape_1;
        matched=true;
        String _operator_plus_2 = StringExtensions.operator_plus("a rectangle : width=", ((Object)shape_4.width));
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ", height=");
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, ((Object)shape_4.height));
        _switchResult = _operator_plus_4;
      }
    }
    return _switchResult;
  }
  
  public String switchExpression_02(final String value) {
    String _switchResult = null;
    final String value_1 = value;
    boolean matched = false;
    if (!matched) {
      if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(value_1,"foo")) {
        matched=true;
        _switchResult = "it\'s foo";
      }
    }
    if (!matched) {
      if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(value_1,"bar")) {
        matched=true;
        _switchResult = "a bar";
      }
    }
    if (!matched) {
      _switchResult = "don\'t know";
    }
    return _switchResult;
  }
}