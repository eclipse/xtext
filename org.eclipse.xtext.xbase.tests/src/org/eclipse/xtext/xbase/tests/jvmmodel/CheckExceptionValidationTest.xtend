package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.preferences.IPreferenceValuesProvider$SingletonPreferenceValuesProvider
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.eclipse.xtext.xbase.XbasePackage

class CheckExceptionValidationTest extends AbstractJvmModelTest {
	
	@Inject ValidationTestHelper helper
	
	private MapBasedPreferenceValues preferences;
	
	@Inject
	def void setPreferences(SingletonPreferenceValuesProvider prefProvider) {
		preferences = prefProvider.getPreferenceValues(null);
	}
	
	@Before
	def void setSeverity() {
		preferences.put(IssueCodes::UNHANDLED_EXCEPTION, "error");
	}
	
	@After
	def void clearPreferences() {
		preferences.clear();
	}
	
	@Test
	def void testSimple() {
		val expression = expression("throw new java.io.IOException()", false);
		helper.assertError(expression, XbasePackage$Literals::XTHROW_EXPRESSION, IssueCodes::UNHANDLED_EXCEPTION)
	}	
}

