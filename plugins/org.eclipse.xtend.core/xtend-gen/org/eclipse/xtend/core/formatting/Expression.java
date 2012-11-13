package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.XExpression;

@Data
@SuppressWarnings("all")
public class Expression extends Chunk {
  private final XExpression _expr;
  
  public XExpression getExpr() {
    return this._expr;
  }
  
  public String toString() {
    CharSequence _text = this.getText();
    String _string = _text==null?(String)null:_text.toString();
    String _plus = ("<<" + _string);
    String _plus_1 = (_plus + ">>");
    return _plus_1;
  }
  
  public Expression(final int offset, final CharSequence text, final XExpression expr) {
    super(offset, text);
    this._expr = expr;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_expr== null) ? 0 : _expr.hashCode());
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
    Expression other = (Expression) obj;
    if (_expr == null) {
      if (other._expr != null)
        return false;
    } else if (!_expr.equals(other._expr))
      return false;
    return true;
  }
}
