package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.lib.Data;

@Data
@SuppressWarnings("all")
public class SemanitcWhitespace extends Chunk {
  public String toString() {
    CharSequence _text = this.getText();
    int _length = _text.length();
    String _plus = ("S" + Integer.valueOf(_length));
    return _plus;
  }
  
  public SemanitcWhitespace(final int offset, final CharSequence text) {
    super(offset, text);
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
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
    SemanitcWhitespace other = (SemanitcWhitespace) obj;
    return true;
  }
}
