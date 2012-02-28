package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.IResourceDescription$Manager

import static org.junit.Assert.*
import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*
import org.junit.Test

class JvmModelTest extends AbstractJvmModelTest {
	
	@Inject ValidationTestHelper helper
	@Inject IResourceDescription$Manager manager
	
	@Test
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		assertEquals(expression.eResource.contents.toString, 2, expression.eResource.contents.size)
		helper.assertNoErrors(expression)
	}
	
	@Test
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
	
	@Test
	def void testReturnTypeConformance() {
		val expression = expression("return")
		helper.assertError(expression, XRETURN_EXPRESSION, INVALID_RETURN);		
	}
	
}