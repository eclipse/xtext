package org.eclipse.xtext.xbase.tests.jvmmodel

import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import com.google.inject.Inject
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.someXbaseContainingModel.SomeXbaseContainingModelFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.junit.validation.ValidationTestHelper

class JvmModelTest extends AbstractXbaseTestCase {
	
	@Inject extension JvmTypesBuilder builder
	@Inject TypeReferences references
	@Inject ValidationTestHelper helper
	
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		val resource = expression.eResource();
		resource.eSetDeliver(false)
		val clazz = expression.toClazz("Foo") [
			members += expression.toMethod("doStuff", references.getTypeForName(typeof(String), expression)) [
				parameters += expression.toParameter("s", references.getTypeForName(typeof(String), expression))
				expression.associate(it)
			]
			null
		]
		resource.contents += clazz
		resource.eSetDeliver(true)
		
		helper.assertNoErrors(expression)
	}
	
}