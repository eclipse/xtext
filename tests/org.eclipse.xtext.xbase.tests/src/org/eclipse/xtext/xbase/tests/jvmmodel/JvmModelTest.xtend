package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.junit.validation.ValidationTestHelper
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

import static junit.framework.Assert.*

class JvmModelTest extends AbstractJvmModelTest {
	
	@Inject extension JvmTypesBuilder builder
	@Inject TypeReferences references
	@Inject ValidationTestHelper helper
	@Inject IResourceDescription$Manager manager
	
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		assertEquals(2, expression.eResource.contents.size)
		val resource = expression.eResource();
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
}