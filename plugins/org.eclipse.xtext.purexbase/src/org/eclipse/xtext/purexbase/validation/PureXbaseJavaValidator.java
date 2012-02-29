package org.eclipse.xtext.purexbase.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
 

public class PureXbaseJavaValidator extends XbaseJavaValidator {

	@Check
	public void checkInnerExpressions(XBlockExpression block) {
	}
	
	@Check
	public void checkForExpression(XForLoopExpression loop) {
	}
	
	@Check
	public void checkWhileExpression(XAbstractWhileExpression loop) {
	}
}
