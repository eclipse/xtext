package org.eclipse.xtext.xtend2.tests.smoke;

import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Case_0 {
  public String foo(final String a, final String b) {
    String _xblockexpression = null;
    {
      ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
      ArrayList<Object> list = _newArrayList;
      int _size = list.size();
      int _operator_minus = IntegerExtensions.operator_minus(_size, 1);
      Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(0, _operator_minus);
      for (final Integer i : _operator_upTo) {
        String _string = i.toString();
        String _operator_plus = StringExtensions.operator_plus(_string, " ");
        Object _get = list.get((i).intValue());
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _get);
        InputOutput.<String>println(_operator_plus_1);
      }
      String _xifexpression = null;
      boolean _isUpper = this.isUpper(a);
      if (_isUpper) {
        String _operator_plus_2 = StringExtensions.operator_plus(b, "holla");
        String _another = this.another(a, _operator_plus_2);
        _xifexpression = _another;
      } else {
        String _xblockexpression_1 = null;
        {
          String x = a;
          char[] _charArray = b.toCharArray();
          for (final char y : _charArray) {
            String _operator_plus_3 = StringExtensions.operator_plus(x, Character.valueOf(y));
            x = _operator_plus_3;
          }
          _xblockexpression_1 = (x);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public boolean isUpper(final String s) {
    String _upperCase = s.toUpperCase();
    boolean _operator_equals = ObjectExtensions.operator_equals(_upperCase, s);
    return _operator_equals;
  }
  
  public String another(final String x, final String y) {
    String _operator_plus = StringExtensions.operator_plus(y, x);
    return _operator_plus;
  }
}
