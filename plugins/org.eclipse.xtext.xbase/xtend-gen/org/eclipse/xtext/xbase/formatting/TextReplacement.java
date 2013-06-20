package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class TextReplacement {
  private final int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  private final int _length;
  
  public int getLength() {
    return this._length;
  }
  
  private final String _text;
  
  public String getText() {
    return this._text;
  }
  
  public TextReplacement(final int offset, final int length, final String text) {
    super();
    this._offset = offset;
    this._length = length;
    this._text = text;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _offset;
    result = prime * result + _length;
    result = prime * result + ((_text== null) ? 0 : _text.hashCode());
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
    TextReplacement other = (TextReplacement) obj;
    if (other._offset != _offset)
      return false;
    if (other._length != _length)
      return false;
    if (_text == null) {
      if (other._text != null)
        return false;
    } else if (!_text.equals(other._text))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
