package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage$Literals
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

class CheckExceptionValiationTest extends AbstractJvmModelTest {
	
	@Inject ValidationTestHelper helper
	
	@Test
	def void testSimple() {
		val expression = expression("throw new java.io.IOException()", false);
		helper.assertError(expression, XbasePackage$Literals::XTHROW_EXPRESSION, IssueCodes::UNHANDLED_EXCEPTION)
	}	
}