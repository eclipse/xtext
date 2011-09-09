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

class JvmModelTest extends AbstractJvmModelTest {
	
	@Inject extension JvmTypesBuilder builder
	@Inject TypeReferences references
	@Inject ValidationTestHelper helper
	
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		val resource = expression.eResource();
		helper.assertNoErrors(expression)
	}
	
	def void testStateIsUpdatedOnChange() {
		val resource = newResource("return s.toUpperCase");
		val expression2 = expression("return 'foo'", false) as XReturnExpression;
		val initializer = get(typeof(JvmModelInferringInitializer))
		initializer.setInferrer(get(typeof(SimpleJvmModelInferrer)))		
		(resource as LateInitializingLazyLinkingResource).setLateInitialization(initializer)
		assertEquals(2, resource.contents.size)
		val type = resource.contents.get(1)
		// modify the model
		(resource.contents.get(0) as XReturnExpression).setExpression( expression2.expression)
		// expect an updated inferred model
		assertEquals(2, resource.contents.size)
		assertNotSame(type, resource.contents.get(1))
	}
	
}