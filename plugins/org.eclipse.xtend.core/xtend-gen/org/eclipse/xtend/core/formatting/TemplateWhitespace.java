package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.lib.Data;

@Data
@SuppressWarnings("all")
public class TemplateWhitespace extends Chunk {
  public String toString() {
    CharSequence _text = this.getText();
    int _length = _text.length();
    return ("T" + Integer.valueOf(_length));
  }
  
  public TemplateWhitespace(final CharSequence text) {
    super(text);
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
    TemplateWhitespace other = (TemplateWhitespace) obj;
    return true;
  }
}
