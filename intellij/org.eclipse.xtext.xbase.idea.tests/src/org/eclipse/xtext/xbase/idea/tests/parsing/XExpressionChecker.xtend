package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtext.xbase.XExpression

interface XExpressionChecker {
	
	def XExpression testExpression(String code, boolean resolve)
	
}