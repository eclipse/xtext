package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.PreferenceKey;

/**
 * @deprecated use {@link org.eclipse.xtext.preferences.BooleanKey}
 */
@Deprecated
@SuppressWarnings("all")
public class BooleanKey extends PreferenceKey {
  public BooleanKey(final String name, final boolean defaultValue) {
    super(name, Boolean.valueOf(defaultValue).toString());
  }
}
