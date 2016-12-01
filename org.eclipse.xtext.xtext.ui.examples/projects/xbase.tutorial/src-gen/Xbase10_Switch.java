import helper.Circle;
import helper.Rectangle;
import helper.Shape;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Xbase10_Switch {
  public List<String> myMethod() throws Throwable {
    List<String> _xblockexpression = null;
    {
      final ArrayList<String> list = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
      String _head = IterableExtensions.<String>head(list);
      if (_head != null) {
        switch (_head) {
          case "foo":
            /* "it\'s foo" */
            break;
          case "bar":
            /* "a bar" */
            break;
          default:
            /* "don\'t know" */
            break;
        }
      } else {
        /* "don\'t know" */
      }
      Rectangle _rectangle = new Rectangle(5, 5);
      Circle _circle = new Circle(4);
      Rectangle _rectangle_1 = new Rectangle(6, 8);
      final ArrayList<Shape> list2 = CollectionLiterals.<Shape>newArrayList(_rectangle, _circle, _rectangle_1);
      final Function1<Shape, String> _function = (Shape shape) -> {
        String _switchResult_1 = null;
        boolean _matched = false;
        if (shape instanceof Circle) {
          _matched=true;
          _switchResult_1 = ("a circle : diameter=" + Integer.valueOf(((Circle)shape).diameter));
        }
        if (!_matched) {
          if (shape instanceof Rectangle) {
            if ((((Rectangle)shape).height == ((Rectangle)shape).width)) {
              _matched=true;
              _switchResult_1 = ("a square : size=" + Integer.valueOf(((Rectangle)shape).width));
            }
          }
        }
        if (!_matched) {
          if (shape instanceof Rectangle) {
            _matched=true;
            _switchResult_1 = ((("a rectangle : width=" + Integer.valueOf(((Rectangle)shape).width)) + ", height=") + Integer.valueOf(((Rectangle)shape).height));
          }
        }
        return _switchResult_1;
      };
      _xblockexpression = ListExtensions.<Shape, String>map(list2, _function);
    }
    return _xblockexpression;
  }
}
