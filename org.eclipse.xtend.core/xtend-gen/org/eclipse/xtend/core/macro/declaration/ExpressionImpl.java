package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public class ExpressionImpl extends AbstractElementImpl<XExpression> implements Expression {
  @Override
  public String toString() {
    return NodeModelUtils.getNode(this.getDelegate()).getText().trim();
  }
}
