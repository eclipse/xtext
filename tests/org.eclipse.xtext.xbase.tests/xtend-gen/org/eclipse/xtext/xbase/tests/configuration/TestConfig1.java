package org.eclipse.xtext.xbase.tests.configuration;

import org.eclipse.xtext.xbase.configuration.AbstractConfigurationKeys;
import org.eclipse.xtext.xbase.configuration.BooleanKey;
import org.eclipse.xtext.xbase.configuration.IntegerKey;
import org.eclipse.xtext.xbase.configuration.StringKey;
import org.eclipse.xtext.xbase.configuration.TransientKey;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.configuration.NewLineConfig;

@SuppressWarnings("all")
public class TestConfig1 extends AbstractConfigurationKeys {
  public final IntegerKey intval = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("intval", Integer.valueOf(42));
      return _integerKey;
    }
  }.apply();
  
  public final StringKey strval = new Function0<StringKey>() {
    public StringKey apply() {
      StringKey _stringKey = new StringKey("strval", "foo");
      return _stringKey;
    }
  }.apply();
  
  public final BooleanKey boolval = new Function0<BooleanKey>() {
    public BooleanKey apply() {
      BooleanKey _booleanKey = new BooleanKey("boolval", Boolean.valueOf(true));
      return _booleanKey;
    }
  }.apply();
  
  public final TransientKey<String> transientval = new Function0<TransientKey<String>>() {
    public TransientKey<String> apply() {
      TransientKey<String> _transientKey = new TransientKey<String>("transientval", "foo");
      return _transientKey;
    }
  }.apply();
  
  public final NewLineConfig child1 = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newLineConfig", 2, 3);
      return _newLineConfig;
    }
  }.apply();
}
