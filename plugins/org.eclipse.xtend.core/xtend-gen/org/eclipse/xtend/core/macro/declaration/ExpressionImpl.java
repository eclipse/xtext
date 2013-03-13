package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public class ExpressionImpl extends AbstractElementImpl<XExpression> implements Expression {
  public String toString() {
    XExpression _delegate = this.getDelegate();
    String _string = _delegate.toString();
    return _string;
  }
}
