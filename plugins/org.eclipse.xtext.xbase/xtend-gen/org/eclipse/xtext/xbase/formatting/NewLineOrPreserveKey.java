package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.BooleanKey;

@SuppressWarnings("all")
public class NewLineOrPreserveKey extends BooleanKey {
  public NewLineOrPreserveKey(final String name, final Boolean defaultValue) {
    super(name, (defaultValue).booleanValue());
  }
}
