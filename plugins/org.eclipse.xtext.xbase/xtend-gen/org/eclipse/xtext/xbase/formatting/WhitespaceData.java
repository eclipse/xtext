package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @deprecated use {@link IHiddenRegionFormatter}
 */
@Deprecated
@Data
@SuppressWarnings("all")
public class WhitespaceData extends FormattingData {
  private final String space;
  
  @Override
  public boolean isEmpty() {
    return Objects.equal(this.space, null);
  }
  
  public WhitespaceData(final int offset, final int length, final int increaseIndentationChange, final int decreaseIndentationChange, final Throwable trace, final String space) {
    super(offset, length, increaseIndentationChange, decreaseIndentationChange, trace);
    this.space = space;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.space== null) ? 0 : this.space.hashCode());
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
    WhitespaceData other = (WhitespaceData) obj;
    if (this.space == null) {
      if (other.space != null)
        return false;
    } else if (!this.space.equals(other.space))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
    return result;
  }
  
  @Pure
  public String getSpace() {
    return this.space;
  }
}
