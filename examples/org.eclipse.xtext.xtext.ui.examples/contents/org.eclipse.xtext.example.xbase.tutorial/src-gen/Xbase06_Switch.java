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
public class Xbase06_Switch {
	public static void main(String[] args) {
		
		{
		  ArrayList<String> _newArrayList = CollectionLiterals.newArrayList("foo", "bar", "baz");
		  final ArrayList<String> list = _newArrayList;
		  final ArrayList<String> typeConverted_list = (ArrayList<String>)list;
		  String _head = IterableExtensions.head(typeConverted_list);
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
		  ArrayList<Shape> _newArrayList_1 = CollectionLiterals.newArrayList(new Rectangle(5, 5), new Circle(4), new Rectangle(6, 8));
		  final ArrayList<Shape> list2 = _newArrayList_1;
		  final ArrayList<Shape> typeConverted_list2 = (ArrayList<Shape>)list2;
		  final Function1<Shape,String> function = new Function1<Shape,String>() {
		      public String apply(Shape shape) {
		        String switchResult_1 = null;
		        final Shape shape_1 = shape;
		        boolean matched_1 = false;
		        if (!matched_1) {
		          if (shape_1 instanceof Circle) {
		            final Circle shape_2 = (Circle) shape_1;
		            matched_1=true;
		            int _diameter = shape_2.diameter;
		            String _operator_plus = StringExtensions.operator_plus("a circle : diameter=", ((Object)_diameter));
		            switchResult_1 = _operator_plus;
		          }
		        }
		        if (!matched_1) {
		          if (shape_1 instanceof Rectangle) {
		            final Rectangle shape_3 = (Rectangle) shape_1;
		            int _height = shape_3.height;
		            int _width = shape_3.width;
		            boolean _operator_equals = ObjectExtensions.operator_equals(_height, ((Object)_width));
		            if (_operator_equals) {
		              matched_1=true;
		              int _width_1 = shape_3.width;
		              String _operator_plus_1 = StringExtensions.operator_plus("a square : size=", ((Object)_width_1));
		              switchResult_1 = _operator_plus_1;
		            }
		          }
		        }
		        if (!matched_1) {
		          if (shape_1 instanceof Rectangle) {
		            final Rectangle shape_4 = (Rectangle) shape_1;
		            matched_1=true;
		            int _width_2 = shape_4.width;
		            String _operator_plus_2 = StringExtensions.operator_plus("a rectangle : width=", ((Object)_width_2));
		            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ", height=");
		            int _height_1 = shape_4.height;
		            String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, ((Object)_height_1));
		            switchResult_1 = _operator_plus_4;
		          }
		        }
		        return switchResult_1;
		      }
		    };
		  ListExtensions.map(typeConverted_list2, function);
		}
	}
}
