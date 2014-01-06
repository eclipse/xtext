package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.lib.Data;

@Data
@SuppressWarnings("all")
public class SemanticWhitespace extends Chunk {
  private final int _column;
  
  public int getColumn() {
    return this._column;
  }
  
  public String toString() {
    CharSequence _text = this.getText();
    int _length = _text.length();
    return ("S" + Integer.valueOf(_length));
  }
  
  public SemanticWhitespace(final CharSequence text, final int column) {
    super(text);
    this._column = column;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + _column;
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
    SemanticWhitespace other = (SemanticWhitespace) obj;
    if (other._column != _column)
      return false;
    return true;
  }
}
