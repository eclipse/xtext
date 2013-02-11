package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.BooleanKey;

@SuppressWarnings("all")
public class WhitespaceKey extends BooleanKey {
  public WhitespaceKey(final String name, final Boolean defaultValue) {
    super(name, (defaultValue).booleanValue());
  }
}
