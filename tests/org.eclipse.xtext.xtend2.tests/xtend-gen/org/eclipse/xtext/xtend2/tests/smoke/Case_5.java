package org.eclipse.xtext.xtend2.tests.smoke;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class Case_5 {
  
  @Inject
  private ArrayList myList;
  
  @Inject
  private String s;
  
  public boolean something(final int i) {
    boolean _xblockexpression = false;
    {
      int _indexOf = this.s.indexOf(i);
      boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_indexOf), ((Integer)0));
      if (_operator_equals) {
        boolean _contains = this.myList.contains(((Integer)i));
        return _contains;
      }
      Arrays.<Integer>asList(((Integer)i));
      Collections.<Integer>singletonList(((Integer)i));
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
}