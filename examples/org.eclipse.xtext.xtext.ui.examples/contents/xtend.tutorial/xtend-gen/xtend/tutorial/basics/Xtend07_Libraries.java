package xtend.tutorial.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Xbase and Xtend come with libraies which are automatically on the
 * extension scope.
 */
@SuppressWarnings("all")
public class Xtend07_Libraries extends TestCase {
  public void testCollectionLiterals() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
      InputOutput.<ArrayList<String>>println(_newArrayList);
      Pair<Integer,String> _operator_mappedTo = ObjectExtensions.<Integer, String>operator_mappedTo(((Integer)2), "two");
      Pair<Integer,String> _operator_mappedTo_1 = ObjectExtensions.<Integer, String>operator_mappedTo(((Integer)42), "fourty two");
      HashMap<Integer,String> _newHashMap = CollectionLiterals.<Integer, String>newHashMap(_operator_mappedTo, _operator_mappedTo_1);
      InputOutput.<HashMap<Integer,String>>println(_newHashMap);
      HashSet<Integer> _newHashSet = CollectionLiterals.<Integer>newHashSet(((Integer)1), ((Integer)2), ((Integer)3), ((Integer)3), ((Integer)3));
      InputOutput.<HashSet<Integer>>println(_newHashSet);
  }
  
  public void testStringUtilities() {
    String _firstUpper = StringExtensions.toFirstUpper("foo");
    InputOutput.<String>println(_firstUpper);
  }
  
  public Iterable<String> testHigherOrderFunctions(final Iterable<String> myStrings) {
    Iterable<String> _xblockexpression = null;
    {
      final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
          public Boolean apply(final String e) {
            int _length = e.length();
            boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_length), ((Integer)3));
            return ((Boolean)_operator_equals);
          }
        };
      String _findFirst = IterableExtensions.<String>findFirst(myStrings, _function);
      InputOutput.<String>println(_findFirst);
      final Function1<String,String> _function_1 = new Function1<String,String>() {
          public String apply(final String e) {
            String _upperCase = e.toUpperCase();
            return _upperCase;
          }
        };
      Iterable<String> _map = IterableExtensions.<String, String>map(myStrings, _function_1);
      InputOutput.<Iterable<String>>println(_map);
      final Function1<String,Boolean> _function_2 = new Function1<String,Boolean>() {
          public Boolean apply(final String e) {
            int _length = e.length();
            boolean _operator_lessEqualsThan = ComparableExtensions.<Integer>operator_lessEqualsThan(((Integer)_length), ((Integer)3));
            return ((Boolean)_operator_lessEqualsThan);
          }
        };
      Iterable<String> _filter = IterableExtensions.<String>filter(myStrings, _function_2);
      Iterable<String> _println = InputOutput.<Iterable<String>>println(_filter);
      _xblockexpression = (_println);
    }
    return _xblockexpression;
  }
  
  /**
   * all operator are built via library
   */
  public Boolean operators() {
    Boolean _xblockexpression = null;
    {
      String _operator_plus = StringExtensions.operator_plus("Hello", " ");
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "World!");
      InputOutput.<String>println(_operator_plus_1);
      int _operator_plus_2 = IntegerExtensions.operator_plus(((Integer)46), ((Integer)2));
      int _operator_divide = IntegerExtensions.operator_divide(((Integer)8), ((Integer)_operator_plus_2));
      int _operator_plus_3 = IntegerExtensions.operator_plus(((Integer)42), ((Integer)_operator_divide));
      InputOutput.<Integer>println(((Integer)_operator_plus_3));
      boolean _operator_and = false;
      if (!true) {
        _operator_and = false;
      } else {
        boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)42), ((Integer)13));
        _operator_and = BooleanExtensions.operator_and(true, _operator_greaterThan);
      }
      Boolean _println = InputOutput.<Boolean>println(((Boolean)_operator_and));
      _xblockexpression = (_println);
    }
    return _xblockexpression;
  }
}
