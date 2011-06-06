package xtend.tutorial.basics;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import xtend.tutorial.util.Circle;
import xtend.tutorial.util.Rectangle;
import xtend.tutorial.util.Shape;

@SuppressWarnings("all")
public class Xtend09_DispatchMethods extends TestCase {
  
  protected StringConcatenation _toLabel(final Rectangle rectangle) {
    StringConcatenation _xifexpression = null;
    boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)rectangle.height), ((Integer)rectangle.width));
    if (_operator_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("It\'s a square (x : ");
      _builder.append(rectangle.height, "");
      _builder.append(")");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("It\'s a rectangle (x : ");
      _builder_1.append(rectangle.height, "");
      _builder_1.append(", y : ");
      _builder_1.append(rectangle.width, "");
      _builder_1.append(")");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  protected StringConcatenation _toLabel(final Circle circle) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("It\'s a circle (diameter : ");
    _builder.append(circle.diameter, "");
    _builder.append(")");
    return _builder;
  }
  
  public void testDispatchMethods() {
    {
      Rectangle _rectangle = new Rectangle(3, 4);
      Circle _circle = new Circle(3);
      Rectangle _rectangle_1 = new Rectangle(5, 5);
      ArrayList<Shape> _newArrayList = CollectionLiterals.<Shape>newArrayList(_rectangle, _circle, _rectangle_1);
      final ArrayList<Shape> list = _newArrayList;
      for (Shape shape : list) {
        StringConcatenation _label = this.toLabel(shape);
        InputOutput.<StringConcatenation>println(_label);
      }
    }
  }
  
  public StringConcatenation toLabel(final Shape circle) {
    if ((circle instanceof Circle)) {
      return _toLabel((Circle)circle);
    } else if ((circle instanceof Rectangle)) {
      return _toLabel((Rectangle)circle);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(circle).toString());
    }
  }
}