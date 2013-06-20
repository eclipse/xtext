package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.BooleanKey;

@SuppressWarnings("all")
public class NewLineKey extends BooleanKey {
  public NewLineKey(final String name, final Boolean defaultValue) {
    super(name, (defaultValue).booleanValue());
  }
}
