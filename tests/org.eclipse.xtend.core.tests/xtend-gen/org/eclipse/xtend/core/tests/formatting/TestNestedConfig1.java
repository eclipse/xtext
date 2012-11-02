package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.formatting.AbstractConfiguration;
import org.eclipse.xtend.core.formatting.StringEntry;
import org.eclipse.xtend.core.tests.formatting.TestNestedConfig2;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class TestNestedConfig1 extends AbstractConfiguration {
  private final StringEntry _strval = new Function0<StringEntry>() {
    public StringEntry apply() {
      StringEntry _stringEntry = new StringEntry("nested1", "foo");
      return _stringEntry;
    }
  }.apply();
  
  public StringEntry getStrval() {
    return this._strval;
  }
  
  private final TestNestedConfig2 _child2 = new Function0<TestNestedConfig2>() {
    public TestNestedConfig2 apply() {
      TestNestedConfig2 _testNestedConfig2 = new TestNestedConfig2("child2");
      return _testNestedConfig2;
    }
  }.apply();
  
  public TestNestedConfig2 getChild2() {
    return this._child2;
  }
  
  public TestNestedConfig1(final String key) {
    super(key);
  }
}
