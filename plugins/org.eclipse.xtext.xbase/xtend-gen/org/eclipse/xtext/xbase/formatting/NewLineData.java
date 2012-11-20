package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class NewLineData extends FormattingData {
  private final int _newLines;
  
  public int getNewLines() {
    return this._newLines;
  }
  
  public boolean isEmpty() {
    int _newLines = this.getNewLines();
    boolean _equals = (_newLines == 0);
    return _equals;
  }
  
  public NewLineData(final int offset, final int length, final int indentationChange, final Throwable trace, final int newLines) {
    super(offset, length, indentationChange, trace);
    this._newLines = newLines;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + _newLines;
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
    if (!super.equals(obj))
      return false;
    NewLineData other = (NewLineData) obj;
    if (other._newLines != _newLines)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
