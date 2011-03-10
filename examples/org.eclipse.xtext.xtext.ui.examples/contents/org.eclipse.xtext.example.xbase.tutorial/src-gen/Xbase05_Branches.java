import helper.SubType;
import helper.SubType2;
import helper.SuperType;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xbase05_Branches {
	public static void main(String[] args) {
		
		{
		  int _length = "foo".length();
		  boolean _operator_greaterThan = ComparableExtensions.operator_greaterThan(_length, 3);
		  if (((Boolean)_operator_greaterThan)) {/*"never true!"*/;
		  } else {/*"always true!"*/;
		  }
		  int _length_1 = "foo".length();
		  boolean _operator_greaterThan_1 = ComparableExtensions.operator_greaterThan(_length_1, 3);
		  if (((Boolean)_operator_greaterThan_1)) {/*"never true!"*/;
		  }
		  Boolean _xifexpression = null;
		  int _length_2 = "foo".length();
		  boolean _operator_greaterThan_2 = ComparableExtensions.operator_greaterThan(_length_2, 3);
		  if (((Boolean)_operator_greaterThan_2)) {
		    _xifexpression = false;
		  } else {
		    _xifexpression = true;
		  }
		  if (_xifexpression) {/*"nested if expressions are not posible in Java"*/;
		  }
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
		  ArrayList<SuperType> _newArrayList_1 = CollectionLiterals.newArrayList(new SuperType(), new SubType("foo"), new SubType2("bar"));
		  final ArrayList<SuperType> list2 = _newArrayList_1;
		  ArrayList<Object> _newArrayList_2 = CollectionLiterals.newArrayList();
		  final ArrayList<Object> result = _newArrayList_2;
		  for (SuperType ele : list2) {
		    String switchResult_1 = null;
		    final SuperType ele_1 = ele;
		    boolean matched_1 = false;
		    if (!matched_1) {
		      if (ele_1 instanceof SubType) {
		        final SubType ele_2 = (SubType) ele_1;
		        String _myProperty = ele_2.myProperty;
		        boolean _operator_equals = ObjectExtensions.operator_equals(_myProperty, "foo");
		        if (_operator_equals) {
		          matched_1=true;
		          String _myProperty_1 = ele_2.myProperty;
		          String _operator_plus = StringExtensions.operator_plus("a sub type : ", _myProperty_1);
		          switchResult_1 = _operator_plus;
		        }
		      }
		    }
		    if (!matched_1) {
		      if (ele_1 instanceof SubType2) {
		        final SubType2 ele_3 = (SubType2) ele_1;
		        matched_1=true;
		        String _mySubType2Property = ele_3.mySubType2Property;
		        String _operator_plus_1 = StringExtensions.operator_plus("a sub type2 : ", _mySubType2Property);
		        switchResult_1 = _operator_plus_1;
		      }
		    }
		    if (!matched_1) {
		      if (ele_1 instanceof SuperType) {
		        final SuperType ele_4 = (SuperType) ele_1;
		        matched_1=true;
		        switchResult_1 = "a super type";
		      }
		    }
		    CollectionExtensions.operator_add(result, switchResult_1);
		  }
		}
	}
}
