package org.eclipse.xtend.core.tests.javadoc

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider
import org.eclipse.xtext.resource.XtextResource
import org.junit.Test
import com.google.inject.Inject

class JavaDocTypeReferenceProviderTest extends AbstractXtendTestCase {
	
	@Inject IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider
	@Test
	def void testComputation() {
		val String input = '''
			package foo
			
			/**
			* {@link List}
			* {@link String}
			* {@link Integer
			* {@link ArrayList}
			*/
			class Foo{}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode)
		assertEquals(3,regions.size)
		assertEquals("List", regions.head.text);
		assertEquals(input.indexOf("List"), regions.head.offset)
		assertEquals("List".length, regions.head.length)
	}

}