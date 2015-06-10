package org.eclipse.xtend.core.tests.smoke;

import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Case_2 {
  public String aOrB(final String a, final String b) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(a);
    if (_isNullOrEmpty) {
      _xifexpression = b;
    } else {
      _xifexpression = a;
    }
    return _xifexpression;
  }
  
  public String returnInIf(final char c) {
    boolean _notEquals = (!Objects.equal("x", Character.valueOf(c)));
    if (_notEquals) {
      return "xx";
    } else {
      return "yy";
    }
  }
}
