import helper.Circle;
import helper.Rectangle;
import helper.Shape;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xbase10_Switch {
	public static void main(String[] args) {
		
		{
		  ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
		  final ArrayList<String> list = _newArrayList;
		  final ArrayList<String> typeConverted_list = (ArrayList<String>)list;
		  String _head = IterableExtensions.<String>head(typeConverted_list);
		  final String __valOfSwitchOver = _head;
		  boolean matched = false;
		  if (!matched) {
		    if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,"foo")) {
		      matched=true;/*"it\'s foo"*/;
		    }
		  }
		  if (!matched) {
		    if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,"bar")) {
		      matched=true;/*"a bar"*/;
		    }
		  }
		  if (!matched) {/*"don\'t know"*/;
		  }
		  Rectangle _rectangle = new Rectangle(5, 5);
		  Circle _circle = new Circle(4);
		  Rectangle _rectangle_1 = new Rectangle(6, 8);
		  ArrayList<Shape> _newArrayList_1 = CollectionLiterals.<Shape>newArrayList(_rectangle, _circle, _rectangle_1);
		  final ArrayList<Shape> list2 = _newArrayList_1;
		  final ArrayList<Shape> typeConverted_list2 = (ArrayList<Shape>)list2;
		  final Function1<Shape,String> _function = new Function1<Shape,String>() {
		      public String apply(Shape shape) {
		        String _switchResult_1 = null;
		        final Shape shape_1 = shape;
		        boolean matched_1 = false;
		        if (!matched_1) {
		          if (shape_1 instanceof Circle) {
		            final Circle shape_2 = (Circle) shape_1;
		            matched_1=true;
		            String _operator_plus = StringExtensions.operator_plus("a circle : diameter=", ((Object)shape_2.diameter));
		            _switchResult_1 = _operator_plus;
		          }
		        }
		        if (!matched_1) {
		          if (shape_1 instanceof Rectangle) {
		            final Rectangle shape_3 = (Rectangle) shape_1;
		            boolean _operator_equals = ObjectExtensions.operator_equals(((Object)shape_3.height), ((Object)shape_3.width));
		            if (_operator_equals) {
		              matched_1=true;
		              String _operator_plus_1 = StringExtensions.operator_plus("a square : size=", ((Object)shape_3.width));
		              _switchResult_1 = _operator_plus_1;
		            }
		          }
		        }
		        if (!matched_1) {
		          if (shape_1 instanceof Rectangle) {
		            final Rectangle shape_4 = (Rectangle) shape_1;
		            matched_1=true;
		            String _operator_plus_2 = StringExtensions.operator_plus("a rectangle : width=", ((Object)shape_4.width));
		            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ", height=");
		            String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, ((Object)shape_4.height));
		            _switchResult_1 = _operator_plus_4;
		          }
		        }
		        return _switchResult_1;
		      }
		    };
		  ListExtensions.<Shape, String>map(typeConverted_list2, _function);
		}
	}
}
