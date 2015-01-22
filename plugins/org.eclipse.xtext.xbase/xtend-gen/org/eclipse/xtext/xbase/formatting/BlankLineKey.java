package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.IntegerKey;

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.BlankLineKey}
 */
@Deprecated
@SuppressWarnings("all")
public class BlankLineKey extends IntegerKey {
  public BlankLineKey(final String name, final Integer defaultValue) {
    super(name, defaultValue);
  }
}
