package org.eclipse.xtext.xtend2.tests.smoke;

import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class Case_3 {
  public void testReturnExpression_06() {
      final Function1<Integer,Integer> _function = new Function1<Integer,Integer>() {
          public Integer apply(final Integer i) {
            return i;
          }
        };
      final Function1<? super Integer,? extends Integer> closure = _function;
      Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(((Integer)1), ((Integer)100));
      for (final Integer x : _operator_upTo) {
        closure.apply(x);
      }
  }
  
  public Object testReturnExpression_07() {
    Object _xifexpression = null;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(org.eclipse.xtext.xtend2.tests.smoke.Case_3.class, null);
    if (_operator_notEquals) {
      {
        final Function1<Integer,Integer> _function = new Function1<Integer,Integer>() {
            public Integer apply(final Integer i) {
              return i;
            }
          };
        final Function1<? super Integer,? extends Integer> closure = _function;
        Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(((Integer)1), ((Integer)100));
        for (final Integer x : _operator_upTo) {
          closure.apply(x);
        }
      }
    }
    return _xifexpression;
  }
  
  public int testOverriddenLocalVariable() {
    int _xblockexpression = (int) 0;
    {
      final int x = 3;
      int y = 2;
      int _xblockexpression_1 = (int) 0;
      {
        int x2 = y;
        final int y2 = 1;
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)x2), ((Integer)y2));
        _xblockexpression_1 = (_operator_plus);
      }
      _xblockexpression = (_xblockexpression_1);
    }
    return _xblockexpression;
  }
  
  public List<Character> testFeatureCall_03() {
    List<Character> _xblockexpression = null;
    {
      char[] _charArray = "abc".toCharArray();
      List<Character> _list = IterableExtensions.<Character>toList(((Iterable<Character>) ((Iterable<Character>)Conversions.doWrapArray(_charArray))));
      List<Character> x = _list;
      _xblockexpression = (x);
    }
    return _xblockexpression;
  }
}
