package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class IntegerKey extends PreferenceKey {
  public IntegerKey(final String name, final Integer defaultValue) {
    super(name, new Function0<String>() {
      public String apply() {
        String _string = defaultValue.toString();
        return _string;
      }
    }.apply());
  }
}
