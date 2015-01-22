package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.BooleanKey;

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.WhitespaceKey}
 */
@Deprecated
@SuppressWarnings("all")
public class WhitespaceKey extends BooleanKey {
  public WhitespaceKey(final String name, final Boolean defaultValue) {
    super(name, (defaultValue).booleanValue());
  }
}
