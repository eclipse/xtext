package xtend.tutorial.basics;

import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import xtend.tutorial.util.Circle;
import xtend.tutorial.util.Rectangle;
import xtend.tutorial.util.Shape;

@SuppressWarnings("all")
public class Xtend04_ControlStructures {
  /**
   * If expressions look exactly like Java's if statements...
   */
  public int ifExpression(final String param) {
    int _xifexpression = (int) 0;
    boolean _notEquals = (!Objects.equal(param, null));
    if (_notEquals) {
      int _length = param.length();
      _xifexpression = _length;
    } else {
      _xifexpression = 0;
    }
    return _xifexpression;
  }
  
  /**
   * ... but note that they are expression so they are more like
   * Java's ternary operator...
   */
  public int ifExpression_01(final String param) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(param, "foo");
    if (_equals) {
      _xifexpression = "bar";
    } else {
      _xifexpression = "baz";
    }
    int _ifExpression = this.ifExpression(_xifexpression);
    return _ifExpression;
  }
  
  /**
   * ... but the else branch is optional and if not specified
   * defaults to 'else null'.
   */
  public int ifExpression_02(final String param) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(param, "bar");
    if (_equals) {
      _xifexpression = "foo";
    }
    int _ifExpression_01 = this.ifExpression_01(_xifexpression);
    return _ifExpression_01;
  }
  
  /**
   * The switch expression is very different to the one from Java.
   * It supports dispatching over types, it has no fall through, and
   * it uses a first match wins strategy.
   */
  public String switchExpression_01(final Shape shape) {
    String _switchResult = null;
    boolean matched = false;
    if (!matched) {
      if (shape instanceof Circle) {
        final Circle _circle = (Circle)shape;
        matched=true;
        String _plus = ("a circle : diameter=" + Integer.valueOf(_circle.diameter));
        _switchResult = _plus;
      }
    }
    if (!matched) {
      if (shape instanceof Rectangle) {
        final Rectangle _rectangle = (Rectangle)shape;
        boolean _equals = (_rectangle.height == _rectangle.width);
        if (_equals) {
          matched=true;
          String _plus = ("a square : size=" + Integer.valueOf(_rectangle.width));
          _switchResult = _plus;
        }
      }
    }
    if (!matched) {
      if (shape instanceof Rectangle) {
        final Rectangle _rectangle = (Rectangle)shape;
        matched=true;
        String _plus = ("a rectangle : width=" + Integer.valueOf(_rectangle.width));
        String _plus_1 = (_plus + ", height=");
        String _plus_2 = (_plus_1 + Integer.valueOf(_rectangle.height));
        _switchResult = _plus_2;
      }
    }
    return _switchResult;
  }
  
  /**
   * Switch can also be used more traditionally (without any type
   * guards).
   */
  public String switchExpression_02(final String value) {
    String _switchResult = null;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(value,"foo")) {
        matched=true;
        _switchResult = "it\'s foo";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(value,"bar")) {
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
