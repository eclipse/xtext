package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.IntegerKey;
import org.eclipse.xtext.xbase.formatting.StringKey;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class BasicFormatterPreferenceKeys {
  public final static StringKey lineSeparator = new Function0<StringKey>() {
    public StringKey apply() {
      String _property = System.getProperty("line.separator");
      StringKey _stringKey = new StringKey("line.separator", _property);
      return _stringKey;
    }
  }.apply();
  
  public final static StringKey indentation = new Function0<StringKey>() {
    public StringKey apply() {
      StringKey _stringKey = new StringKey("indentation", "\t");
      return _stringKey;
    }
  }.apply();
  
  public final static IntegerKey indentationLength = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("indentation.length", Integer.valueOf(4));
      return _integerKey;
    }
  }.apply();
  
  public final static IntegerKey maxLineWidth = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("line.width.max", Integer.valueOf(120));
      return _integerKey;
    }
  }.apply();
}
