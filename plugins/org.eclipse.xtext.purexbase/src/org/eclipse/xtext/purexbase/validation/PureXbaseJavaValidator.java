package org.eclipse.xtext.purexbase.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
 

public class PureXbaseJavaValidator extends XbaseJavaValidator {

	@Override
	@Check
	public void checkInnerExpressions(XExpression expr) {
		// disabled since pure xbase is meant to be a playground
	}
}
