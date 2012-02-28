import helper.Circle;
import helper.Rectangle;
import helper.Shape;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class Xbase10_Switch {
  public static void main(final String[] args) {
    try {
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
        final ArrayList<String> list = _newArrayList;
        String _head = IterableExtensions.<String>head(list);
        final String __valOfSwitchOver = _head;
        boolean matched = false;
        if (!matched) {
          if (ObjectExtensions.operator_equals(__valOfSwitchOver,"foo")) {
            matched=true;
            /* "it\'s foo" */
          }
        }
        if (!matched) {
          if (ObjectExtensions.operator_equals(__valOfSwitchOver,"bar")) {
            matched=true;
            /* "a bar" */
          }
        }
        if (!matched) {
          /* "don\'t know" */
        }
        Rectangle _rectangle = new Rectangle(5, 5);
        Circle _circle = new Circle(4);
        Rectangle _rectangle_1 = new Rectangle(6, 8);
        ArrayList<Shape> _newArrayList_1 = CollectionLiterals.<Shape>newArrayList(_rectangle, _circle, _rectangle_1);
        final ArrayList<Shape> list2 = _newArrayList_1;
        final Function1<Shape,String> _function = new Function1<Shape,String>() {
            public String apply(final Shape shape) {
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
          };
        ListExtensions.<Shape, String>map(list2, _function);
    } catch (Throwable t) {}
  }
}
