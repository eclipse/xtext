package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage$Literals
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Ignore

class CheckExceptionValidationTest extends AbstractJvmModelTest {
	
	@Inject ValidationTestHelper helper
	
	@Test
	def void testSimple() {
		val expression = expression("throw new java.io.IOException()", false);
		helper.assertError(expression, XbasePackage$Literals::XTHROW_EXPRESSION, IssueCodes::UNHANDLED_EXCEPTION)
	}	
}

@Ignore("TODO implement exception validation")
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(AbstractJvmModelTest$SimpleJvmModelTestInjectorProvider2))
class CheckExceptionValidationTest2 extends CheckExceptionValidationTest {
}