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
public class NewLineData extends FormattingData {
  private final Integer newLines;
  
  @Override
  public boolean isEmpty() {
    return Objects.equal(this.newLines, null);
  }
  
  public NewLineData(final int offset, final int length, final int increaseIndentationChange, final int decreaseIndentationChange, final Throwable trace, final Integer newLines) {
    super(offset, length, increaseIndentationChange, decreaseIndentationChange, trace);
    this.newLines = newLines;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.newLines== null) ? 0 : this.newLines.hashCode());
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
    NewLineData other = (NewLineData) obj;
    if (this.newLines == null) {
      if (other.newLines != null)
        return false;
    } else if (!this.newLines.equals(other.newLines))
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
  public Integer getNewLines() {
    return this.newLines;
  }
}
