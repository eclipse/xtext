package org.eclipse.xtend.core.formatting2;

import org.eclipse.xtend.core.formatting2.Chunk;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;

@Data
@SuppressWarnings("all")
public class SemanticWhitespace extends Chunk {
  private final int column;
  
  public String toString() {
    CharSequence _text = this.getText();
    int _length = _text.length();
    return ("S" + Integer.valueOf(_length));
  }
  
  public SemanticWhitespace(final CharSequence text, final int column) {
    super(text);
    this.column = column;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + this.column;
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
    if (!super.equals(obj))
      return false;
    SemanticWhitespace other = (SemanticWhitespace) obj;
    if (other.column != this.column)
      return false;
    return true;
  }
  
  @Pure
  public int getColumn() {
    return this.column;
  }
}
