package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class BooleanKey extends PreferenceKey {
  public BooleanKey(final String name, final boolean defaultValue) {
    super(name, new Function0<String>() {
      public String apply() {
        String _string = Boolean.valueOf(defaultValue).toString();
        return _string;
      }
    }.apply());
  }
}
