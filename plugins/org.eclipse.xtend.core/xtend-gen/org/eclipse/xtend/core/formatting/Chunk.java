package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public abstract class Chunk {
  private final CharSequence _text;
  
  public int getLength() {
    CharSequence _text = this.getText();
    return _text.length();
  }
  
  public Chunk(final CharSequence text) {
    super();
    this._text = text;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    Chunk other = (Chunk) obj;
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
  public CharSequence getText() {
    return this._text;
  }
}
