package org.eclipse.xtend.core.tests.smoke;

import com.google.common.base.Objects;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;

@SuppressWarnings("all")
public class Case_0 {
  public String foo(final String a, final String b) {
    String _xblockexpression = null;
    {
      ArrayList<Object> list = CollectionLiterals.<Object>newArrayList();
      int _size = list.size();
      int _minus = (_size - 1);
      Iterable<Integer> _upTo = IntegerExtensions.upTo(0, _minus);
      for (final Integer i : _upTo) {
        String _string = i.toString();
        String _plus = (_string + " ");
        Object _get = list.get((i).intValue());
        String _plus_1 = (_plus + _get);
        InputOutput.<String>println(_plus_1);
      }
      String _xifexpression = null;
      boolean _isUpper = this.isUpper(a);
      if (_isUpper) {
        String _plus_2 = (b + "holla");
        String _another = this.another(a, _plus_2);
        _xifexpression = _another;
      } else {
        String _xblockexpression_1 = null;
        {
          String x = a;
          char[] _charArray = b.toCharArray();
          for (final char y : _charArray) {
            String _plus_3 = (x + Character.valueOf(y));
            x = _plus_3;
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
    boolean _equals = Objects.equal(_upperCase, s);
    return _equals;
  }
  
  public String another(final String x, final String y) {
    String _plus = (y + x);
    return _plus;
  }
}
