package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.expression.Expression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

class ExpressionImpl extends AbstractElementImpl<XExpression> implements Expression {
	
	override toString() {
		NodeModelUtils.getNode(delegate).text.trim
	}
	
}