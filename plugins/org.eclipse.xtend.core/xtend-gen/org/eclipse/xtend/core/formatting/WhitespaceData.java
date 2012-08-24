package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.AnchoredData;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class WhitespaceData extends AnchoredData {
  private final String _space;
  
  public String getSpace() {
    return this._space;
  }
  
  private final boolean _canWrap;
  
  public boolean isCanWrap() {
    return this._canWrap;
  }
  
  public WhitespaceData(final int offset, final int length, final int indentationChange, final Object leftAnchor, final Object rightAnchor, final String space, final boolean canWrap) {
    super(offset, length, indentationChange, leftAnchor, rightAnchor);
    this._space = space;
    this._canWrap = canWrap;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_space== null) ? 0 : _space.hashCode());
    result = prime * result + (_canWrap ? 1231 : 1237);
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
    WhitespaceData other = (WhitespaceData) obj;
    if (_space == null) {
      if (other._space != null)
        return false;
    } else if (!_space.equals(other._space))
      return false;
    if (other._canWrap != _canWrap)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
