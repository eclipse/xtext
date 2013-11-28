package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.PreferenceKey;

@SuppressWarnings("all")
public class BooleanKey extends PreferenceKey {
  public BooleanKey(final String name, final boolean defaultValue) {
    super(name, Boolean.valueOf(defaultValue).toString());
  }
}
