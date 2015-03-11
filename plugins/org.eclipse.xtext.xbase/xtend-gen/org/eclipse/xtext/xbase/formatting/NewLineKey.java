package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.BooleanKey;

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.NewLineKey}
 */
@Deprecated
@SuppressWarnings("all")
public class NewLineKey extends BooleanKey {
  public NewLineKey(final String name, final Boolean defaultValue) {
    super(name, (defaultValue).booleanValue());
  }
}
