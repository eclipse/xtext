package org.eclipse.xtend.core.formatting;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class NewLineConfiguration {
  private int _minNewLines = 1;
  
  public int getMinNewLines() {
    return this._minNewLines;
  }
  
  public void setMinNewLines(final int minNewLines) {
    this._minNewLines = minNewLines;
  }
  
  private int _maxNewLines = 1;
  
  public int getMaxNewLines() {
    return this._maxNewLines;
  }
  
  public void setMaxNewLines(final int maxNewLines) {
    this._maxNewLines = maxNewLines;
  }
  
  public NewLineConfiguration(final int min, final int max) {
    this._minNewLines = min;
    this._maxNewLines = max;
  }
  
  public NewLineConfiguration(final String data) {
    final String[] parsed = data.split(",");
    int _size = ((List<String>)Conversions.doWrapArray(parsed)).size();
    boolean _equals = (_size == 2);
    if (_equals) {
      String _get = ((List<String>)Conversions.doWrapArray(parsed)).get(0);
      String _trim = _get.trim();
      int _parseInt = Integer.parseInt(_trim);
      this._minNewLines = _parseInt;
      String _get_1 = ((List<String>)Conversions.doWrapArray(parsed)).get(0);
      String _trim_1 = _get_1.trim();
      int _parseInt_1 = Integer.parseInt(_trim_1);
      this._maxNewLines = _parseInt_1;
    }
  }
  
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this._minNewLines, "");
    _builder.append(", ");
    _builder.append(this._maxNewLines, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
