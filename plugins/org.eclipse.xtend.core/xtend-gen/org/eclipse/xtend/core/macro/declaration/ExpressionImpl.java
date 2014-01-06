package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public class ExpressionImpl extends AbstractElementImpl<XExpression> implements Expression {
  public String toString() {
    XExpression _delegate = this.getDelegate();
    ICompositeNode _node = NodeModelUtils.getNode(_delegate);
    String _text = _node.getText();
    return _text.trim();
  }
}
