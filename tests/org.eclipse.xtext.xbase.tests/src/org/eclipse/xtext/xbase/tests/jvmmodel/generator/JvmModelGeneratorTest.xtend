package org.eclipse.xtext.xbase.tests.jvmmodel.generator

import com.google.inject.Inject
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.junit.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.generator.XbaseGenerator
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase

class JvmModelGeneratorTest extends AbstractXbaseTestCase {
	
	@Inject extension JvmTypesBuilder builder
	@Inject TypeReferences references
	@Inject ValidationTestHelper helper
	@Inject XbaseGenerator generator
	
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		val resource = expression.eResource();
		resource.eSetDeliver(false)
		val clazz = expression.toClazz("my.test.Foo") [
			members += expression.toMethod("doStuff", references.getTypeForName(typeof(String), expression)) [
				parameters += expression.toParameter("s", references.getTypeForName(typeof(String), expression))
				expression.associate(it)
			]
			null
		]
		resource.contents += clazz
		resource.eSetDeliver(true)
		
		helper.assertNoErrors(expression)
		
		val fsa = new InMemoryFileSystemAccess()
		generator.doGenerate(resource, fsa)
		println(fsa.files.values.head)
	}
	
}