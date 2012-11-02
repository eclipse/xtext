package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.AbstractConfiguration;
import org.eclipse.xtend.core.formatting.IntegerEntry;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class NewLineConfig extends AbstractConfiguration {
  private final IntegerEntry _minNewLines = new Function0<IntegerEntry>() {
    public IntegerEntry apply() {
      IntegerEntry _integerEntry = new IntegerEntry("minNewLines");
      return _integerEntry;
    }
  }.apply();
  
  public IntegerEntry getMinNewLines() {
    return this._minNewLines;
  }
  
  private final IntegerEntry _maxNewLines = new Function0<IntegerEntry>() {
    public IntegerEntry apply() {
      IntegerEntry _integerEntry = new IntegerEntry("maxNewLines");
      return _integerEntry;
    }
  }.apply();
  
  public IntegerEntry getMaxNewLines() {
    return this._maxNewLines;
  }
  
  public NewLineConfig(final String key, final int minNewLines, final int maxNewLines) {
    super(key);
    this._minNewLines.setValue(minNewLines);
    this._maxNewLines.setValue(maxNewLines);
  }
}
