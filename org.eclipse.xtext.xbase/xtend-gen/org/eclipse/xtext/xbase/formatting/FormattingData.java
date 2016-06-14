package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @deprecated use {@link IHiddenRegionFormatter}
 */
@Deprecated
@Data
@SuppressWarnings("all")
public abstract class FormattingData {
  private final int offset;
  
  private final int length;
  
  private final int increaseIndentationChange;
  
  private final int decreaseIndentationChange;
  
  private final Throwable trace;
  
  public abstract boolean isEmpty();
  
  public int getIndentationChange() {
    return (this.increaseIndentationChange + this.decreaseIndentationChange);
  }
  
  public FormattingData(final int offset, final int length, final int increaseIndentationChange, final int decreaseIndentationChange, final Throwable trace) {
    super();
    this.offset = offset;
    this.length = length;
    this.increaseIndentationChange = increaseIndentationChange;
    this.decreaseIndentationChange = decreaseIndentationChange;
    this.trace = trace;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.offset;
    result = prime * result + this.length;
    result = prime * result + this.increaseIndentationChange;
    result = prime * result + this.decreaseIndentationChange;
    result = prime * result + ((this.trace== null) ? 0 : this.trace.hashCode());
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
    FormattingData other = (FormattingData) obj;
    if (other.offset != this.offset)
      return false;
    if (other.length != this.length)
      return false;
    if (other.increaseIndentationChange != this.increaseIndentationChange)
      return false;
    if (other.decreaseIndentationChange != this.decreaseIndentationChange)
      return false;
    if (this.trace == null) {
      if (other.trace != null)
        return false;
    } else if (!this.trace.equals(other.trace))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("offset", this.offset);
    b.add("length", this.length);
    b.add("increaseIndentationChange", this.increaseIndentationChange);
    b.add("decreaseIndentationChange", this.decreaseIndentationChange);
    b.add("trace", this.trace);
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
  public int getIncreaseIndentationChange() {
    return this.increaseIndentationChange;
  }
  
  @Pure
  public int getDecreaseIndentationChange() {
    return this.decreaseIndentationChange;
  }
  
  @Pure
  public Throwable getTrace() {
    return this.trace;
  }
}
