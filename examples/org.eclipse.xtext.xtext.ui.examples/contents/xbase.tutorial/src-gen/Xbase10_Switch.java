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
  public static void main(final String[] args) {
    try {
    	ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
    	final ArrayList<String> list = _newArrayList;
    	String _head = IterableExtensions.<String>head(list);
    	final String __valOfSwitchOver = _head;
    	boolean matched = false;
    	if (!matched) {
    		if (ObjectExtensions.operator_equals(__valOfSwitchOver,"foo")) {
    			matched=true;/*"it\'s foo"*/;
    		}
    	}
    	if (!matched) {
    		if (ObjectExtensions.operator_equals(__valOfSwitchOver,"bar")) {
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
    	final Function1<Shape,String> _function = new Function1<Shape,String>() {
    			public String apply(final Shape shape) {
    				String _switchResult = null;
    				final Shape shape_1 = shape;
    				boolean matched = false;
    				if (!matched) {
    					if (shape_1 instanceof Circle) {
    						final Circle shape_2 = (Circle) shape_1;
    						matched=true;
    						String _operator_plus = StringExtensions.operator_plus("a circle : diameter=", ((Integer)shape_2.diameter));
    						_switchResult = _operator_plus;
    					}
    				}
    				if (!matched) {
    					if (shape_1 instanceof Rectangle) {
    						final Rectangle shape_3 = (Rectangle) shape_1;
    						boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)shape_3.height), ((Integer)shape_3.width));
    						if (_operator_equals) {
    							matched=true;
    							String _operator_plus_1 = StringExtensions.operator_plus("a square : size=", ((Integer)shape_3.width));
    							_switchResult = _operator_plus_1;
    						}
    					}
    				}
    				if (!matched) {
    					if (shape_1 instanceof Rectangle) {
    						final Rectangle shape_4 = (Rectangle) shape_1;
    						matched=true;
    						String _operator_plus_2 = StringExtensions.operator_plus("a rectangle : width=", ((Integer)shape_4.width));
    						String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ", height=");
    						String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, ((Integer)shape_4.height));
    						_switchResult = _operator_plus_4;
    					}
    				}
    				return _switchResult;
    			}
    		};
    	ListExtensions.<Shape, String>map(list2, _function);
    } catch (Throwable t) {}
  }
}
