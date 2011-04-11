package xtext.tutorial.basics;

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

@SuppressWarnings("all")
public class Xtend07_Libraries extends TestCase {
  
  public void testCollectionLiterals() {
    {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
      InputOutput.<ArrayList<String>>println(_newArrayList);
      Pair<Integer,String> _operator_mappedTo = ObjectExtensions.<Integer, String>operator_mappedTo(2, "two");
      Pair<Integer,String> _operator_mappedTo_1 = ObjectExtensions.<Integer, String>operator_mappedTo(42, "fourty two");
      HashMap<Integer,String> _newHashMap = CollectionLiterals.<Integer, String>newHashMap(_operator_mappedTo, _operator_mappedTo_1);
      InputOutput.<HashMap<Integer,String>>println(_newHashMap);
      HashSet<Integer> _newHashSet = CollectionLiterals.<Integer>newHashSet(1, 2, 3, 3, 3);
      InputOutput.<HashSet<Integer>>println(_newHashSet);
    }
  }
  
  public void testStringUtilities() {
    String _firstUpper = StringExtensions.toFirstUpper("foo");
    InputOutput.<String>println(_firstUpper);
  }
  
  public Iterable<String> testHigherOrderFunctions(final Iterable<String> myStrings) {
    Iterable<String> _xblockexpression = null;
    {
      final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
          public Boolean apply(String e) {
            int _length = e.length();
            boolean _operator_equals = ObjectExtensions.operator_equals(((Object)_length), 3);
            return ((Boolean)_operator_equals);
          }
        };
      String _findFirst = IterableExtensions.<String>findFirst(myStrings, _function);
      InputOutput.<String>println(_findFirst);
      final Function1<String,String> _function_1 = new Function1<String,String>() {
          public String apply(String e_1) {
            String _upperCase = e_1.toUpperCase();
            return _upperCase;
          }
        };
      Iterable<String> _map = IterableExtensions.<String, String>map(myStrings, _function_1);
      InputOutput.<Iterable<String>>println(_map);
      final Function1<String,Boolean> _function_2 = new Function1<String,Boolean>() {
          public Boolean apply(String e_2) {
            int _length_1 = e_2.length();
            boolean _operator_lessEqualsThan = ComparableExtensions.<Integer>operator_lessEqualsThan(((Comparable<? super Integer>)_length_1), 3);
            return ((Boolean)_operator_lessEqualsThan);
          }
        };
      Iterable<String> _filter = IterableExtensions.<String>filter(myStrings, _function_2);
      Iterable<String> _println = InputOutput.<Iterable<String>>println(_filter);
      _xblockexpression = (_println);
    }
    return _xblockexpression;
  }
  
  public boolean operators() {
    boolean _xblockexpression = false;
    {
      String _operator_plus = StringExtensions.operator_plus("Hello", " ");
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "World!");
      InputOutput.<String>println(_operator_plus_1);
      int _operator_plus_2 = IntegerExtensions.operator_plus(46, 2);
      int _operator_divide = IntegerExtensions.operator_divide(8, ((Number)_operator_plus_2));
      int _operator_plus_3 = IntegerExtensions.operator_plus(42, ((Number)_operator_divide));
      InputOutput.<Integer>println(_operator_plus_3);
      boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(42, 13);
      boolean _operator_and = BooleanExtensions.operator_and(true, _operator_greaterThan);
      boolean _println = InputOutput.<Boolean>println(_operator_and);
      _xblockexpression = (_println);
    }
    return _xblockexpression;
  }
}