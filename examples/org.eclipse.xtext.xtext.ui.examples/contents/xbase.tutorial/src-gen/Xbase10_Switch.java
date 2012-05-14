import com.google.common.base.Objects;
import helper.Circle;
import helper.Rectangle;
import helper.Shape;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Xbase10_Switch {
  public static void main(final String[] args) {
    try {
        final ArrayList<String> list = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
        String _head = IterableExtensions.<String>head(list);
        final String _switchValue = _head;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_switchValue,"foo")) {
            _matched=true;
            /* "it\'s foo" */
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"bar")) {
            _matched=true;
            /* "a bar" */
          }
        }
        if (!_matched) {
          /* "don\'t know" */
        }
        Rectangle _rectangle = new Rectangle(5, 5);
        Circle _circle = new Circle(4);
        Rectangle _rectangle_1 = new Rectangle(6, 8);
        final ArrayList<Shape> list2 = CollectionLiterals.<Shape>newArrayList(_rectangle, _circle, _rectangle_1);
        final Function1<Shape,String> _function = new Function1<Shape,String>() {
            public String apply(final Shape shape) {
              String _switchResult = null;
              boolean _matched = false;
              if (!_matched) {
                if (shape instanceof Circle) {
                  final Circle _circle = (Circle)shape;
                  _matched=true;
                  String _plus = ("a circle : diameter=" + Integer.valueOf(_circle.diameter));
                  _switchResult = _plus;
                }
              }
              if (!_matched) {
                if (shape instanceof Rectangle) {
                  final Rectangle _rectangle = (Rectangle)shape;
                  boolean _equals = (_rectangle.height == _rectangle.width);
                  if (_equals) {
                    _matched=true;
                    String _plus = ("a square : size=" + Integer.valueOf(_rectangle.width));
                    _switchResult = _plus;
                  }
                }
              }
              if (!_matched) {
                if (shape instanceof Rectangle) {
                  final Rectangle _rectangle = (Rectangle)shape;
                  _matched=true;
                  String _plus = ("a rectangle : width=" + Integer.valueOf(_rectangle.width));
                  String _plus_1 = (_plus + ", height=");
                  String _plus_2 = (_plus_1 + Integer.valueOf(_rectangle.height));
                  _switchResult = _plus_2;
                }
              }
              return _switchResult;
            }
          };
        /*ListExtensions.<Shape, String>map(list2, _function);*/
    } catch (Throwable t) {}
  }
}
