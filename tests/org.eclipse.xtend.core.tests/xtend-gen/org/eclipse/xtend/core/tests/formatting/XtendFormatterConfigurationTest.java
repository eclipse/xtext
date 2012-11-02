package org.eclipse.xtend.core.tests.formatting;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
import org.eclipse.xtend.core.tests.formatting.TestConfig1;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendFormatterConfigurationTest {
  @Test
  public void testEquals() {
    XtendFormatterConfig _xtendFormatterConfig = new XtendFormatterConfig();
    final XtendFormatterConfig cfg = _xtendFormatterConfig;
    final Map<String,String> map = cfg.asMap();
    XtendFormatterConfig _xtendFormatterConfig_1 = new XtendFormatterConfig(map);
    final XtendFormatterConfig cfg2 = _xtendFormatterConfig_1;
    Assert.assertEquals(cfg, cfg2);
  }
  
  @Test
  public void testAsMap() {
    TestConfig1 _testConfig1 = new TestConfig1();
    Map<String,String> _asMap = _testConfig1.asMap();
    Set<Entry<String,String>> _entrySet = _asMap.entrySet();
    final Function1<Entry<String,String>,CharSequence> _function = new Function1<Entry<String,String>,CharSequence>() {
        public CharSequence apply(final Entry<String,String> it) {
          StringConcatenation _builder = new StringConcatenation();
          String _key = it.getKey();
          _builder.append(_key, "");
          _builder.append(" = ");
          String _value = it.getValue();
          _builder.append(_value, "");
          return _builder;
        }
      };
    final String actual = IterableExtensions.<Entry<String,String>>join(_entrySet, "\n", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("intval = 42");
    _builder.newLine();
    _builder.append("strval = foo");
    _builder.newLine();
    _builder.append("child1.nested1 = foo");
    _builder.newLine();
    _builder.append("child1.child2.nested2 = foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    Assert.assertEquals(_trim, actual);
  }
  
  @Test
  public void testLoad() {
    TestConfig1 _testConfig1 = new TestConfig1();
    final TestConfig1 cfg = _testConfig1;
    final Map<String,String> map = cfg.asMap();
    TestConfig1 _testConfig1_1 = new TestConfig1(map);
    final TestConfig1 cfg2 = _testConfig1_1;
    Assert.assertEquals(cfg, cfg2);
  }
}
