package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.junit.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage$Literals
import org.eclipse.xtext.xbase.validation.IssueCodes

class CheckExceptionValiationTest extends AbstractJvmModelTest {
	
	@Inject ValidationTestHelper helper
	
	def void testSimple() {
		val expression = expression("throw new java.io.IOException()", false);
		helper.assertError(expression, XbasePackage$Literals::XTHROW_EXPRESSION, IssueCodes::UNHANDLED_EXCEPTION)
	}	
}