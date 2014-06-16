package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;

@Data
@SuppressWarnings("all")
public class SemanitcText extends Chunk {
  public String toString() {
    CharSequence _text = this.getText();
    return _text.toString();
  }
  
  public SemanitcText(final CharSequence text) {
    super(text);
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
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
    SemanitcText other = (SemanitcText) obj;
    return true;
  }
}
