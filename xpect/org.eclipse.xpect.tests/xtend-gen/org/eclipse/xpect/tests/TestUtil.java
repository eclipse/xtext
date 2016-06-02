package org.eclipse.xpect.tests;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

@SuppressWarnings("all")
public class TestUtil {
  public static void assertEquals(final Object expected, final Object actual) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (expected instanceof Iterable) {
        _matched=true;
        _switchResult = IterableExtensions.join(((Iterable<?>)expected), "\n");
      }
    }
    if (!_matched) {
      String _elvis = null;
      String _string = null;
      if (expected!=null) {
        _string=expected.toString();
      }
      String _trim = null;
      if (_string!=null) {
        _trim=_string.trim();
      }
      if (_trim != null) {
        _elvis = _trim;
      } else {
        _elvis = "null";
      }
      _switchResult = _elvis;
    }
    final String e = _switchResult;
    String _elvis_1 = null;
    String _string_1 = null;
    if (actual!=null) {
      _string_1=actual.toString();
    }
    String _trim_1 = null;
    if (_string_1!=null) {
      _trim_1=_string_1.trim();
    }
    if (_trim_1 != null) {
      _elvis_1 = _trim_1;
    } else {
      _elvis_1 = "null";
    }
    final String a = _elvis_1;
    Assert.assertEquals(e, a);
  }
}
