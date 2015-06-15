package org.eclipse.xtext.java.tests

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.InMemoryURIHandler
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmAnnotationType

@RunWith(XtextRunner)
@InjectWith(JavaInjectorProvider)
class ResourceDescriptionProviderTest {
	
	@Test def void testStubGeneration_01() {
		'''
			public class MyTest {
				public String helloWorld() {
					return "Hello";
				}
			}
		'''.resultsIn [ JvmGenericType it |
			assertEquals("MyTest", qualifiedName)
			assertFalse(isInterface)
			assertEquals(0, members.size)
		]
	}
	
	@Test def void testStubGeneration_02() {
		'''
			public interface MyTest {
				public String helloWorld();
			}
		'''.resultsIn [ JvmGenericType it |
			assertEquals("MyTest", qualifiedName)
			assertTrue(isInterface)
			assertEquals(0, members.size)
		]
	}
	
	@Test def void testStubGeneration_03() {
		'''
			public enum MyTest {
				FOO, BAR
			}
		'''.resultsIn [
			assertEquals("MyTest", qualifiedName)
			assertTrue(it instanceof JvmEnumerationType)
			assertEquals(0, members.size)
		]
	}
	
	@Test def void testStubGeneration_04() {
		'''
			public @interface MyTest {
				String value();
			}
		'''.resultsIn [
			assertEquals("MyTest", qualifiedName)
			assertTrue(it instanceof JvmAnnotationType)
			assertEquals(0, members.size)
		]
	}
	
	@Test def void testStubGeneration_05() {
		'''
			package my.pack;
			
			public abstract class MyTest {
				abstract String value();
			}
		'''.resultsIn [
			assertEquals("my.pack.MyTest", qualifiedName)
			assertEquals(0, members.size)
		]
	}
	
	@Test def void testStubGenerationWithNestedTypes_01() {
		'''
			package my.pack;
			
			public class MyTest {
				class InnerClass {}
				interface InnerInterface {}
				enum InnerEnum {}
				@interface InnerAnnotation {}
			}
		'''.resultsIn [
			assertEquals("my.pack.MyTest", qualifiedName)
			assertEquals(4, members.size)
			members.get(0) => [
				assertEquals("my.pack.MyTest$InnerClass", qualifiedName)
				assertTrue(it instanceof JvmGenericType)
			]
			members.get(1) => [
				assertEquals("my.pack.MyTest$InnerInterface", qualifiedName)
				assertTrue(it instanceof JvmGenericType)
			]
			members.get(2) => [
				assertEquals("my.pack.MyTest$InnerEnum", qualifiedName)
				assertTrue(it instanceof JvmEnumerationType)
			]
			members.get(3) => [
				assertEquals("my.pack.MyTest$InnerAnnotation", qualifiedName)
				assertTrue(it instanceof JvmAnnotationType)
			]
		]
	}
	
	@Test def void testStubGenerationWithTypeParamers_01() {
		'''
			package my.pack;
			
			public class MyTest<T extends CharSequence> {
				interface InnerInterface<A,B> {
					static class DeepNested<X> {}
				}
			}
		'''.resultsIn [ JvmGenericType it |
			assertEquals("my.pack.MyTest", qualifiedName)
			assertEquals(1, typeParameters.size)
			assertEquals("T", typeParameters.head.name)
			members.head as JvmGenericType => [
				assertEquals("my.pack.MyTest$InnerInterface", qualifiedName)
				assertEquals(2, typeParameters.size)
				assertEquals("A", typeParameters.head.name)
				members.head as JvmGenericType => [
					assertEquals("my.pack.MyTest$InnerInterface$DeepNested", qualifiedName)
					assertEquals(1, typeParameters.size)
					assertEquals("X", typeParameters.head.name)
				]
			]
		]
	}
	
	
	protected def <T extends JvmDeclaredType> resultsIn(CharSequence javaCode, (T)=>void assertion) {
		val resourceSet = resourceSet('SomeJava.java' -> javaCode.toString)
		compilerPhases.setIndexing(resourceSet, true)
		val resource = resourceSet.resources.head
		val type = resource.contents.head as T
		assertion.apply(type)
	}
	
	@Inject CompilerPhases compilerPhases
	@Inject Provider<XtextResourceSet> resourceSetProvider
	
	def protected resourceSet(Pair<String,String> ... files) {
		val result = resourceSetProvider.get
		result.URIConverter.URIHandlers.clear
		val uriHandler = new InMemoryURIHandler
		val uris = files.map[
			val uri = URI.createURI(InMemoryURIHandler.SCHEME+":/"+key)
			val out = uriHandler.createOutputStream(uri, emptyMap)
			out.write(value.bytes)
			out.close
			return uri
		]
		result.URIConverter.URIHandlers.add(uriHandler)
		for (uri : uris) {
			result.getResource(uri, true)
		}
		return result
	}
}