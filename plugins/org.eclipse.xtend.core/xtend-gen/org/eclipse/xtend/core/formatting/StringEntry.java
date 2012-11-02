package org.eclipse.xtend.core.formatting;

import java.util.Map;
import org.eclipse.xtend.core.formatting.AbstractEntry;

@SuppressWarnings("all")
public class StringEntry extends AbstractEntry {
  private String _value;
  
  public String getValue() {
    return this._value;
  }
  
  public void setValue(final String value) {
    this._value = value;
  }
  
  public StringEntry(final String key) {
    super(key);
  }
  
  public StringEntry(final String key, final String value) {
    super(key);
    this._value = value;
  }
  
  public void load(final String prefix, final Map<String,String> values) {
    String _fullPrefix = this.fullPrefix(prefix);
    String _get = values.get(_fullPrefix);
    this._value = _get;
  }
  
  public void store(final String prefix, final Map<String,String> values) {
    String _fullPrefix = this.fullPrefix(prefix);
    values.put(_fullPrefix, this._value);
  }
}
