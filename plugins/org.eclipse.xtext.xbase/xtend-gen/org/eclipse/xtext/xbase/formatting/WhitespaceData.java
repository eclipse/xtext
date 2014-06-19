package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class WhitespaceData extends FormattingData {
  private final String _space;
  
  public boolean isEmpty() {
    String _space = this.getSpace();
    return Objects.equal(_space, null);
  }
  
  public WhitespaceData(final int offset, final int length, final int increaseIndentationChange, final int decreaseIndentationChange, final Throwable trace, final String space) {
    super(offset, length, increaseIndentationChange, decreaseIndentationChange, trace);
    this._space = space;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this._space== null) ? 0 : this._space.hashCode());
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
    if (this._space == null) {
      if (other._space != null)
        return false;
    } else if (!this._space.equals(other._space))
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
  public String getSpace() {
    return this._space;
  }
}
