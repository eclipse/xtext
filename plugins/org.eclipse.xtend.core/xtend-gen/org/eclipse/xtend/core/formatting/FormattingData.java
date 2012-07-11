package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.Format;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class FormattingData extends Format {
  private final int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  private final int _length;
  
  public int getLength() {
    return this._length;
  }
  
  public FormattingData(final int offset, final int length) {
    super();
    this._offset = offset;
    this._length = length;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + _offset;
    result = prime * result + _length;
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
    FormattingData other = (FormattingData) obj;
    if (other._offset != _offset)
      return false;
    if (other._length != _length)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
