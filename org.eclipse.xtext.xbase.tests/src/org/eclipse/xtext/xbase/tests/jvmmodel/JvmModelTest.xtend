package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Test

import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*
import java.io.IOException
import org.eclipse.xtext.resource.XtextResourceSet
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.util.StringInputStream

class JvmModelTest extends AbstractJvmModelTest {
	
	@Inject ValidationTestHelper helper
	@Inject IResourceDescription$Manager manager
	@Inject extension ReflectExtensions
	@Inject Provider<XtextResourceSet> resourceSetProvider
	
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
	
	override protected newResource(CharSequence input) throws IOException {
		val resourceSet = resourceSetProvider.get
		val resource = resourceSet.createResource(URI::createURI("Test.___xbase"));
		resource.load(new StringInputStream(input.toString()), null);
		return resource;
	}
	
	@Test
	def void testReturnTypeConformance() {
		val expression = expression("return")
		helper.assertError(expression, XRETURN_EXPRESSION, INVALID_RETURN);		
	}
	
}

