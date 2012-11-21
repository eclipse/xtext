package org.eclipse.xtext.xbase.tests.configuration;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class NewLineConfigValue {
  private final int _minNewLines;
  
  public int getMinNewLines() {
    return this._minNewLines;
  }
  
  private final int _maxNewLines;
  
  public int getMaxNewLines() {
    return this._maxNewLines;
  }
  
  public NewLineConfigValue(final int minNewLines, final int maxNewLines) {
    super();
    this._minNewLines = minNewLines;
    this._maxNewLines = maxNewLines;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _minNewLines;
    result = prime * result + _maxNewLines;
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    NewLineConfigValue other = (NewLineConfigValue) obj;
    if (other._minNewLines != _minNewLines)
      return false;
    if (other._maxNewLines != _maxNewLines)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
