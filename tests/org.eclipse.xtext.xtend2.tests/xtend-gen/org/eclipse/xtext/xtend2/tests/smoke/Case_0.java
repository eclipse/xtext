package org.eclipse.xtext.xtend2.tests.smoke;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Case_0 {
  
  public String foo(final String a, final String b) {
    String _xifexpression = null;
    boolean _isUpper = this.isUpper(a);
    if (_isUpper) {
      String _operator_plus = StringExtensions.operator_plus(b, "holla");
      String _another = this.another(a, _operator_plus);
      _xifexpression = _another;
    } else {
      String _xblockexpression = null;
      {
        String x = a;
        char[] _charArray = b.toCharArray();
        for (final char y : _charArray) {
          String _operator_plus_1 = StringExtensions.operator_plus(x, ((Character)y));
          x = _operator_plus_1;
        }
        _xblockexpression = (x);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
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