package org.eclipse.xtend.core.formatting;

import java.util.Map;
import org.eclipse.xtend.core.formatting.AbstractEntry;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class IntegerEntry extends AbstractEntry {
  private int _value;
  
  public int getValue() {
    return this._value;
  }
  
  public void setValue(final int value) {
    this._value = value;
  }
  
  public IntegerEntry(final String key) {
    super(key);
  }
  
  public IntegerEntry(final String key, final Integer value) {
    super(key);
    this._value = (value).intValue();
  }
  
  public void load(final String prefix, final Map<String,String> values) {
    try {
      String _fullPrefix = this.fullPrefix(prefix);
      String _get = values.get(_fullPrefix);
      int _parseInt = Integer.parseInt(_get);
      this._value = _parseInt;
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException e = (NumberFormatException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void store(final String prefix, final Map<String,String> values) {
    String _fullPrefix = this.fullPrefix(prefix);
    String _valueOf = String.valueOf(this._value);
    values.put(_fullPrefix, _valueOf);
  }
}
