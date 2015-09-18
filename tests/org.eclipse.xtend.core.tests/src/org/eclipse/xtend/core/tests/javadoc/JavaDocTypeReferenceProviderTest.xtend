package org.eclipse.xtend.core.tests.javadoc

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider
import org.eclipse.xtext.resource.XtextResource
import org.junit.Test

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

	@Test
	def void testComputation_2() {
		val String input = '''
			package foo

			/**
			* {@link java.util.ArrayList @see Integer}
			*/
			class Foo{}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode)
		assertEquals(1,regions.size)
		assertEquals("java.util.ArrayList", regions.head.text);
		assertEquals(input.indexOf("java.util.ArrayList"), regions.head.offset)
		assertEquals("java.util.ArrayList".length, regions.head.length)
	}

	@Test
	def void testComputation_3() {
		val String input = '''
			package foo

			/**
			* {@link java.util.ArrayList
			*/
			class Foo{}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode)
		assertEquals(0,regions.size)
	}

	@Test
	def void testComputation_4() {
		val String input = '''
			package foo

			/**
			* {@link java.util.ArrayList
			 */
			class Foo{}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode)
		assertEquals(0,regions.size)
	}

	@Test
	def void testComputation_5() {
		val String input = '''
			package foo

			class Foo{
				/**
				* @param string - a fancy string
				* @param anotherString-even more fancy
				* @param zonk
				*/
				def bar(String string, String anotherString, Integer zonk){}
			}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeParameterTypeRefRegions(rootNode)
		assertEquals(3,regions.size)
		assertEquals("string", regions.head.text);
		assertEquals(input.indexOf("string"), regions.head.offset)
		assertEquals("string".length, regions.head.length)
		
		assertEquals("anotherString", regions.get(1).text);
		assertEquals(input.indexOf("anotherString"), regions.get(1).offset)
		assertEquals("anotherString".length, regions.get(1).length)
		
		assertEquals("zonk", regions.get(2).text);
		assertEquals(input.indexOf("zonk"), regions.get(2).offset)
		assertEquals("zonk".length, regions.get(2).length)
	}

	@Test
	def void testComputation_6() {
		val String input = '''
			package foo

			/**
			* {@link }
			* @see
			* @see
			* {@link}
			*/
			class Foo{}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode)
		assertEquals(0,regions.size)
	}

	@Test
	def void testComputation_7() {
		val String input = '''
			package foo

			/**
			* {@link    String}
			*/
			class Foo{}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode)
		assertEquals(1,regions.size)
	}
	
	@Test
	def void testComputation_8() {
		val String input = '''
			package foo

			/**
			* @see    String
			*/
			class Foo{}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode)
		assertEquals(1,regions.size)
	}
	
	@Test
	def void testComputation_9() {
		val String input = '''
			package foo

			/**
			* {@link    String #length()  }
			*/
			class Foo{}
		'''
		val resource = clazz(input).eResource as XtextResource
		val rootNode = resource.parseResult.rootNode
		val regions = javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode)
		assertEquals(1,regions.size)
		assertEquals("String",regions.head.text)
	}

}