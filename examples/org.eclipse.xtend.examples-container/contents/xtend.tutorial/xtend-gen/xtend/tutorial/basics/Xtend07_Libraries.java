package xtend.tutorial.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    Pair<Integer,String> _mappedTo = Pair.<Integer, String>of(Integer.valueOf(2), "two");
    Pair<Integer,String> _mappedTo_1 = Pair.<Integer, String>of(Integer.valueOf(42), "fourty two");
    HashMap<Integer,String> _newHashMap = CollectionLiterals.<Integer, String>newHashMap(_mappedTo, _mappedTo_1);
    InputOutput.<HashMap<Integer,String>>println(_newHashMap);
    HashSet<Integer> _newHashSet = CollectionLiterals.<Integer>newHashSet(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(3), Integer.valueOf(3));
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
            boolean _equals = (_length == 3);
            return Boolean.valueOf(_equals);
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
            boolean _lessEqualsThan = (_length <= 3);
            return Boolean.valueOf(_lessEqualsThan);
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
      String _plus = ("Hello" + " ");
      String _plus_1 = (_plus + "World!");
      InputOutput.<String>println(_plus_1);
      int _plus_2 = (46 + 2);
      int _divide = (8 / _plus_2);
      int _plus_3 = (42 + _divide);
      InputOutput.<Integer>println(Integer.valueOf(_plus_3));
      boolean _and = false;
      if (!true) {
        _and = false;
      } else {
        boolean _greaterThan = (42 > 13);
        _and = (true && _greaterThan);
      }
      Boolean _println = InputOutput.<Boolean>println(Boolean.valueOf(_and));
      _xblockexpression = (_println);
    }
    return _xblockexpression;
  }
}
