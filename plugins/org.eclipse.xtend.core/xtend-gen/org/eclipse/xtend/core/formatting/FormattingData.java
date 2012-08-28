package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public abstract class FormattingData {
  private final int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  private final int _length;
  
  public int getLength() {
    return this._length;
  }
  
  private final int _indentationChange;
  
  public int getIndentationChange() {
    return this._indentationChange;
  }
  
  public abstract boolean isEmpty();
  
  public FormattingData(final int offset, final int length, final int indentationChange) {
    super();
    this._offset = offset;
    this._length = length;
    this._indentationChange = indentationChange;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _offset;
    result = prime * result + _length;
    result = prime * result + _indentationChange;
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
    FormattingData other = (FormattingData) obj;
    if (other._offset != _offset)
      return false;
    if (other._length != _length)
      return false;
    if (other._indentationChange != _indentationChange)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
