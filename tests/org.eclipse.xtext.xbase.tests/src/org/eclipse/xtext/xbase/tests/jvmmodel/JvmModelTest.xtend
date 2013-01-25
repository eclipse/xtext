package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

class JvmModelTest extends AbstractJvmModelTest {
	
	@Inject ValidationTestHelper helper
	@Inject IResourceDescription$Manager manager
	@Inject extension ReflectExtensions
	
	@Test
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		assertEquals(expression.eResource.contents.toString, 2, expression.eResource.contents.size)
		helper.assertNoErrors(expression)
	}
	
	@Test
	def void testResourceDescriptionsAreCorrect() {
		val resource = newResource("return s.toUpperCase")
		val boolean initialized = resource.get("fullyInitialized")
		assertFalse(initialized)
		val desc = manager.getResourceDescription(resource)
		val list = newArrayList(desc.exportedObjects)
		assertEquals(1, list.size)
		assertFalse(resource.get("fullyInitialized"))
	}
	
	@Test
	def void testReturnTypeConformance() {
		val expression = expression("return")
		helper.assertError(expression, XRETURN_EXPRESSION, INVALID_RETURN);		
	}
	
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(AbstractJvmModelTest$SimpleJvmModelTestInjectorProvider2))
class JvmModelTest2 extends JvmModelTest {
	
}