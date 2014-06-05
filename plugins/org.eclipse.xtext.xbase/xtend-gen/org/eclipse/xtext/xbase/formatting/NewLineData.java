package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class NewLineData extends FormattingData {
  private final Integer _newLines;
  
  public Integer getNewLines() {
    return this._newLines;
  }
  
  public boolean isEmpty() {
    Integer _newLines = this.getNewLines();
    return Objects.equal(_newLines, null);
  }
  
  public NewLineData(final int offset, final int length, final int increaseIndentationChange, final int decreaseIndentationChange, final Throwable trace, final Integer newLines) {
    super(offset, length, increaseIndentationChange, decreaseIndentationChange, trace);
    this._newLines = newLines;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this._newLines== null) ? 0 : this._newLines.hashCode());
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
    NewLineData other = (NewLineData) obj;
    if (this._newLines == null) {
      if (other._newLines != null)
        return false;
    } else if (!this._newLines.equals(other._newLines))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
