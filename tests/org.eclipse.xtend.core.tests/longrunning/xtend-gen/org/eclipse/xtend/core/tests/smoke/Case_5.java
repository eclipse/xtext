package org.eclipse.xtend.core.tests.smoke;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Case_5 {
  @Inject
  private ArrayList myList;
  
  @Inject
  @Extension
  private String s;
  
  public boolean something(final int i) {
    boolean _xblockexpression = false;
    {
      int _indexOf = this.s.indexOf(i);
      boolean _equals = (_indexOf == 0);
      if (_equals) {
        return this.myList.contains(Integer.valueOf(i));
      }
      Arrays.<Integer>asList(Integer.valueOf(i));
      Collections.<Integer>singletonList(Integer.valueOf(i));
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
}
