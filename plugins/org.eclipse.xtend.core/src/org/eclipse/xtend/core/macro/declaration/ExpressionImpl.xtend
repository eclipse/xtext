package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.expression.Expression
import org.eclipse.xtext.xbase.XExpression

class ExpressionImpl extends AbstractElementImpl<XExpression> implements Expression {
	
	override toString() {
		delegate.toString
	}
	
}