package org.eclipse.xtext.purexbase.validation;

import org.eclipse.xtext.purexbase.pureXbase.SpecialBlockExpression;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
 

public class PureXbaseJavaValidator extends XbaseJavaValidator {

	@Check
	public void checkInnerExpressions(XBlockExpression block) {
		if (!(block instanceof SpecialBlockExpression)) {
			super.checkInnerExpressions(block);
		}
	}
	
	@Check
	@Override
	public void checkNoSideffectFreeExpressionsInBlockExpression(XBlockExpression blockExpression) {
	}
}
