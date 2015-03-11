package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.PreferenceKey;

/**
 * @deprecated use {@link org.eclipse.xtext.preferences.StringKey}
 */
@Deprecated
@SuppressWarnings("all")
public class StringKey extends PreferenceKey {
  public StringKey(final String id, final String defaultValue) {
    super(id, defaultValue);
  }
}
