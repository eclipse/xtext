package org.eclipse.xtext.xbase.tests.jvmmodel

import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import com.google.inject.Inject
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.someXbaseContainingModel.SomeXbaseContainingModelFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.junit.validation.ValidationTestHelper
import org.eclipse.xtext.resource.LateInitializingLazyLinkingResource
import org.eclipse.xtext.xbase.resource.JvmModelInferringInitializer

import static junit.framework.Assert.*
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator

class JvmModelTest extends AbstractJvmModelTest {
	
	@Inject extension JvmTypesBuilder builder
	@Inject TypeReferences references
	@Inject ValidationTestHelper helper
	
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		val resource = expression.eResource();
		helper.assertNoErrors(expression)
	}
	
}