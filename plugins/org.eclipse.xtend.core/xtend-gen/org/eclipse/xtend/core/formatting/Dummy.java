package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.lib.Data;

@Data
@SuppressWarnings("all")
public class Dummy extends Chunk {
  public String toString() {
    CharSequence _text = this.getText();
    String _string = _text==null?(String)null:_text.toString();
    String _plus = ("<<" + _string);
    String _plus_1 = (_plus + ">>");
    return _plus_1;
  }
  
  public Dummy(final int offset, final CharSequence text) {
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
    Dummy other = (Dummy) obj;
    return true;
  }
}
