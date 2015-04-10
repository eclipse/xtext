package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @deprecated use {@link ITextReplacement}
 */
@Deprecated
@Data
@SuppressWarnings("all")
public class TextReplacement {
  private final int offset;
  
  private final int length;
  
  private final String text;
  
  public TextReplacement(final int offset, final int length, final String text) {
    super();
    this.offset = offset;
    this.length = length;
    this.text = text;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.offset;
    result = prime * result + this.length;
    result = prime * result + ((this.text== null) ? 0 : this.text.hashCode());
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
    if (other.offset != this.offset)
      return false;
    if (other.length != this.length)
      return false;
    if (this.text == null) {
      if (other.text != null)
        return false;
    } else if (!this.text.equals(other.text))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("offset", this.offset);
    b.add("length", this.length);
    b.add("text", this.text);
    return b.toString();
  }
  
  @Pure
  public int getOffset() {
    return this.offset;
  }
  
  @Pure
  public int getLength() {
    return this.length;
  }
  
  @Pure
  public String getText() {
    return this.text;
  }
}
