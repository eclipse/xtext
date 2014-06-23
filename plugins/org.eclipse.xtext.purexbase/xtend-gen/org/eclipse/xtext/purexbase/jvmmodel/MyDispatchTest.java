package org.eclipse.xtext.purexbase.jvmmodel;

import java.util.Arrays;
import org.eclipse.xtext.purexbase.jvmmodel.CharSequenceExtension;
import org.eclipse.xtext.xbase.lib.Synthetic;

@SuppressWarnings("all")
public class MyDispatchTest implements CharSequenceExtension {
  protected String _operator_plus(final CharSequence a, final CharSequence b) {
    return null;
  }
  
  protected String _operator_plus(final String a, final CharSequence b) {
    return null;
  }
  
  protected String _operator_plus(final StringBuilder a, final CharSequence b) {
    return null;
  }
  
  @Synthetic
  public String operator_plus(final CharSequence a, final CharSequence b) {
    if (a instanceof StringBuilder) {
      return _operator_plus((StringBuilder)a, b);
    } else if (a instanceof String) {
      return _operator_plus((String)a, b);
    } else if (a != null) {
      return _operator_plus(a, b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(a, b).toString());
    }
  }
}
