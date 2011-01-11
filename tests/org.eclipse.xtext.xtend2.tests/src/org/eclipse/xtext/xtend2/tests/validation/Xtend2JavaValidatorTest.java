package org.eclipse.xtext.xtend2.tests.validation;

import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

public class Xtend2JavaValidatorTest extends AbstractXtend2TestCase {
	
	@Inject
	protected ValidationTestHelper helper;
	
	public void testAssignmentToFunctionParameter() throws Exception {
		XtendFunction function = function("void foo(int bar) bar=7");
		helper.assertError(function, XbasePackage.Literals.XASSIGNMENT, XbaseJavaValidator.ASSIGNMENT_TO_FINAL, "Assignment", "final", "parameter");
	}
	
}
