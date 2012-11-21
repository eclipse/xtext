package org.eclipse.xtext.xbase.tests.configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.configuration.TestConfig1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ConfigurationTest {
  @Test
  public void testDefaultValues() {
    TestConfig1 _testConfig1 = new TestConfig1();
    MapBasedConfigurationValues _mapBasedConfigurationValues = new MapBasedConfigurationValues(_testConfig1);
    Map<String,String> _store = _mapBasedConfigurationValues.store();
    Set<Entry<String,String>> _entrySet = _store.entrySet();
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
    _builder.append("boolval = true");
    _builder.newLine();
    _builder.append("newLineConfig.minNewLines = 2");
    _builder.newLine();
    _builder.append("newLineConfig.maxNewLines = 3");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    Assert.assertEquals(_trim, actual);
  }
  
  @Test
  public void testLoad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("intval = 420");
    _builder.newLine();
    _builder.append("strval = baz");
    _builder.newLine();
    _builder.append("boolval = false");
    _builder.newLine();
    _builder.append("newLineConfig.minNewLines = 20");
    _builder.newLine();
    _builder.append("newLineConfig.maxNewLines = 30");
    _builder.newLine();
    String _string = _builder.toString();
    final String data = _string.trim();
    final LinkedHashMap<String,String> map = CollectionLiterals.<String, String>newLinkedHashMap();
    String[] _split = data.split("\\\n");
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          final String[] x = it.split("=");
          String _get = ((List<String>)Conversions.doWrapArray(x)).get(0);
          String _trim = _get.trim();
          String _get_1 = ((List<String>)Conversions.doWrapArray(x)).get(1);
          String _trim_1 = _get_1.trim();
          map.put(_trim, _trim_1);
        }
      };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(_split)), _function);
    TestConfig1 _testConfig1 = new TestConfig1();
    MapBasedConfigurationValues _mapBasedConfigurationValues = new MapBasedConfigurationValues(_testConfig1);
    final MapBasedConfigurationValues cfg = _mapBasedConfigurationValues;
    cfg.load(map);
    Map<String,String> _store = cfg.store();
    Set<Entry<String,String>> _entrySet = _store.entrySet();
    final Function1<Entry<String,String>,CharSequence> _function_1 = new Function1<Entry<String,String>,CharSequence>() {
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
    final String actual = IterableExtensions.<Entry<String,String>>join(_entrySet, "\n", _function_1);
    Assert.assertEquals(data, actual);
  }
}
