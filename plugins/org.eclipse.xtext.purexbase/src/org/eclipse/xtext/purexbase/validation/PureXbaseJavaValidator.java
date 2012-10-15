package org.eclipse.xtext.purexbase.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator2;
 

@SuppressWarnings("restriction")
public class PureXbaseJavaValidator extends XbaseJavaValidator2 {

	@Override
	@Check
	public void checkInnerExpressions(XExpression expr) {
		// disabled since pure xbase is meant to be a playground
	}
}
