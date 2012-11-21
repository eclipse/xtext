package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.configuration.AbstractConfigurationKeys;
import org.eclipse.xtext.xbase.configuration.IntegerKey;
import org.eclipse.xtext.xbase.configuration.TransientKey;
import org.eclipse.xtext.xbase.formatting.IFormatterConfigKeys;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public abstract class AbstractFormatterConfigurationKeys extends AbstractConfigurationKeys implements IFormatterConfigKeys {
  public final TransientKey<String> lineSeparator = new Function0<TransientKey<String>>() {
    public TransientKey<String> apply() {
      TransientKey<String> _transientKey = new TransientKey<String>("line.separator", "\n");
      return _transientKey;
    }
  }.apply();
  
  public final TransientKey<String> indentation = new Function0<TransientKey<String>>() {
    public TransientKey<String> apply() {
      TransientKey<String> _transientKey = new TransientKey<String>("indentation", "\t");
      return _transientKey;
    }
  }.apply();
  
  public final TransientKey<Integer> indentationLength = new Function0<TransientKey<Integer>>() {
    public TransientKey<Integer> apply() {
      TransientKey<Integer> _transientKey = new TransientKey<Integer>("indentation.length", Integer.valueOf(4));
      return _transientKey;
    }
  }.apply();
  
  public final IntegerKey maxLineWidth = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("line.width.max", Integer.valueOf(120));
      return _integerKey;
    }
  }.apply();
}
