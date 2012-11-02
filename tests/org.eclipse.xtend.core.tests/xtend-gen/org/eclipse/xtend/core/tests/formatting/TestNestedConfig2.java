package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.formatting.AbstractConfiguration;
import org.eclipse.xtend.core.formatting.StringEntry;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class TestNestedConfig2 extends AbstractConfiguration {
  private final StringEntry _strval = new Function0<StringEntry>() {
    public StringEntry apply() {
      StringEntry _stringEntry = new StringEntry("nested2", "foo");
      return _stringEntry;
    }
  }.apply();
  
  public StringEntry getStrval() {
    return this._strval;
  }
  
  public TestNestedConfig2(final String key) {
    super(key);
  }
}
