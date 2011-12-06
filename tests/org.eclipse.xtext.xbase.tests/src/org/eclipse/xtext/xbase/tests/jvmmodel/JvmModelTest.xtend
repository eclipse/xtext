package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.junit.validation.ValidationTestHelper
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.IResourceDescription

import static junit.framework.Assert.*
import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

class JvmModelTest extends AbstractJvmModelTest {
	
	@Inject ValidationTestHelper helper
	@Inject IResourceDescription$Manager manager
	
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		assertEquals(2, expression.eResource.contents.size)
		helper.assertNoErrors(expression)
	}
	
	def void testResourceDescriptionsAreCorrect() {
		val resource = newResource("return s.toUpperCase")
		val field = typeof(DerivedStateAwareResource).getDeclaredField("fullyInitialized")
		field.accessible = true
		assertFalse(field.get(resource) as Boolean)
		val desc = manager.getResourceDescription(resource)
		val list = newArrayList(desc.exportedObjects)
		assertEquals(1, list.size)
		assertFalse(field.get(resource) as Boolean)
	}
	
	def void testReturnTypeConformance() {
		val expression = expression("return")
		helper.assertError(expression, XRETURN_EXPRESSION, INVALID_RETURN);		
	}
	
}