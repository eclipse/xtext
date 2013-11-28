package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.PreferenceKey;

@SuppressWarnings("all")
public class IntegerKey extends PreferenceKey {
  public IntegerKey(final String name, final Integer defaultValue) {
    super(name, defaultValue.toString());
  }
}
