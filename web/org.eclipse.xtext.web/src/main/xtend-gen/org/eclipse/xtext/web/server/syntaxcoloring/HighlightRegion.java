package org.eclipse.xtext.web.server.syntaxcoloring;

import java.util.Arrays;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@ToString(singleLine = true)
@SuppressWarnings("all")
public class HighlightRegion {
  private final int offset;
  
  private final int length;
  
  private final String[] styleClasses;
  
  public HighlightRegion(final int offset, final int length, final String[] styleClasses) {
    super();
    this.offset = offset;
    this.length = length;
    this.styleClasses = styleClasses;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.offset;
    result = prime * result + this.length;
    result = prime * result + ((this.styleClasses== null) ? 0 : Arrays.deepHashCode(this.styleClasses));
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
    HighlightRegion other = (HighlightRegion) obj;
    if (other.offset != this.offset)
      return false;
    if (other.length != this.length)
      return false;
    if (this.styleClasses == null) {
      if (other.styleClasses != null)
        return false;
    } else if (!Arrays.deepEquals(this.styleClasses, other.styleClasses))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.singleLine();
    b.add("offset", this.offset);
    b.add("length", this.length);
    b.add("styleClasses", this.styleClasses);
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
  public String[] getStyleClasses() {
    return this.styleClasses;
  }
}
