package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public abstract class AnchoredData extends FormattingData {
  private final Object _leftAnchor;
  
  public Object getLeftAnchor() {
    return this._leftAnchor;
  }
  
  private final Object _rightAnchor;
  
  public Object getRightAnchor() {
    return this._rightAnchor;
  }
  
  public AnchoredData(final int offset, final int length, final int indentationChange, final Object leftAnchor, final Object rightAnchor) {
    super(offset, length, indentationChange);
    this._leftAnchor = leftAnchor;
    this._rightAnchor = rightAnchor;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_leftAnchor== null) ? 0 : _leftAnchor.hashCode());
    result = prime * result + ((_rightAnchor== null) ? 0 : _rightAnchor.hashCode());
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
    AnchoredData other = (AnchoredData) obj;
    if (_leftAnchor == null) {
      if (other._leftAnchor != null)
        return false;
    } else if (!_leftAnchor.equals(other._leftAnchor))
      return false;
    if (_rightAnchor == null) {
      if (other._rightAnchor != null)
        return false;
    } else if (!_rightAnchor.equals(other._rightAnchor))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
