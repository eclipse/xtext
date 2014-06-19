package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class TextReplacement {
  private final int _offset;
  
  private final int _length;
  
  private final String _text;
  
  public TextReplacement(final int offset, final int length, final String text) {
    super();
    this._offset = offset;
    this._length = length;
    this._text = text;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this._offset;
    result = prime * result + this._length;
    result = prime * result + ((this._text== null) ? 0 : this._text.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TextReplacement other = (TextReplacement) obj;
    if (other._offset != this._offset)
      return false;
    if (other._length != this._length)
      return false;
    if (this._text == null) {
      if (other._text != null)
        return false;
    } else if (!this._text.equals(other._text))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public int getOffset() {
    return this._offset;
  }
  
  @Pure
  public int getLength() {
    return this._length;
  }
  
  @Pure
  public String getText() {
    return this._text;
  }
}
