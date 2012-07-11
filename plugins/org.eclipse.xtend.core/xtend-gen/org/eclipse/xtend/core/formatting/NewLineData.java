package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.AnchoredData;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class NewLineData extends AnchoredData {
  private final int _newLines;
  
  public int getNewLines() {
    return this._newLines;
  }
  
  private final int _indentationChange;
  
  public int getIndentationChange() {
    return this._indentationChange;
  }
  
  public NewLineData(final int offset, final int length, final Object leftAnchor, final Object rightAnchor, final int newLines, final int indentationChange) {
    super(offset, length, leftAnchor, rightAnchor);
    this._newLines = newLines;
    this._indentationChange = indentationChange;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + _newLines;
    result = prime * result + _indentationChange;
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
    if (other._newLines != _newLines)
      return false;
    if (other._indentationChange != _indentationChange)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
