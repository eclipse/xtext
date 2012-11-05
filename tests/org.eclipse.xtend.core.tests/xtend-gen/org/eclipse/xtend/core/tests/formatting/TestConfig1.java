package org.eclipse.xtend.core.tests.formatting;

import java.util.Map;
import org.eclipse.xtend.core.formatting.AbstractConfiguration;
import org.eclipse.xtend.core.formatting.IntegerEntry;
import org.eclipse.xtend.core.formatting.StringEntry;
import org.eclipse.xtend.core.tests.formatting.TestNestedConfig1;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class TestConfig1 extends AbstractConfiguration {
  private final IntegerEntry _intval = new Function0<IntegerEntry>() {
    public IntegerEntry apply() {
      IntegerEntry _integerEntry = new IntegerEntry("intval", Integer.valueOf(42));
      return _integerEntry;
    }
  }.apply();
  
  public IntegerEntry getIntval() {
    return this._intval;
  }
  
  private final StringEntry _strval = new Function0<StringEntry>() {
    public StringEntry apply() {
      StringEntry _stringEntry = new StringEntry("strval", "foo");
      return _stringEntry;
    }
  }.apply();
  
  public StringEntry getStrval() {
    return this._strval;
  }
  
  private final TestNestedConfig1 _child1 = new Function0<TestNestedConfig1>() {
    public TestNestedConfig1 apply() {
      TestNestedConfig1 _testNestedConfig1 = new TestNestedConfig1("child1");
      return _testNestedConfig1;
    }
  }.apply();
  
  public TestNestedConfig1 getChild1() {
    return this._child1;
  }
  
  public TestConfig1() {
    super(((String) null));
  }
  
  public TestConfig1(final Map<String,String> values) {
    this();
    this.load(null, values);
  }
}
