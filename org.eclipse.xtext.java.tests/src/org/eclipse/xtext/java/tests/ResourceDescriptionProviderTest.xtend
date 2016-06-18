package org.eclipse.xtext.java.tests

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

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
		'''.resultsIn [
			assertEquals("MyTest", exportedObjects.head.qualifiedName.toString)
			assertFalse((exportedObjects.head.EObjectOrProxy as JvmGenericType).isInterface)
			assertEquals(1, exportedObjects.size)
		]
	}
	
	@Test def void testStubGeneration_02() {
		'''
			public interface MyTest {
				public String helloWorld();
			}
		'''.resultsIn [
			assertEquals("MyTest", exportedObjects.head.qualifiedName.toString)
			assertTrue((exportedObjects.head.EObjectOrProxy as JvmGenericType).isInterface)
			assertEquals(1, exportedObjects.size)
		]
	}
	
	@Test def void testStubGeneration_03() {
		'''
			public enum MyTest {
				FOO, BAR
			}
		'''.resultsIn [
			assertEquals("MyTest", exportedObjects.head.qualifiedName.toString)
			assertTrue(exportedObjects.head.EObjectOrProxy instanceof JvmEnumerationType)
			assertEquals(1, exportedObjects.size)
		]
	}
	
	@Test def void testStubGeneration_04() {
		'''
			public @interface MyTest {
				String value();
			}
		'''.resultsIn [
			assertEquals("MyTest", exportedObjects.head.qualifiedName.toString)
			assertTrue(exportedObjects.head.EObjectOrProxy instanceof JvmAnnotationType)
			assertEquals(1, exportedObjects.size)
		]
	}
	
	@Test def void testStubGeneration_05() {
		'''
			package my.pack;
			
			public abstract class MyTest {
				abstract String value();
			}
		'''.resultsIn [
			assertEquals("my.pack.MyTest", exportedObjects.head.qualifiedName.toString)
			assertEquals(1, exportedObjects.size)
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
			assertEquals("my.pack.MyTest", exportedObjects.head.qualifiedName.toString)
			assertEquals(5, exportedObjects.size)
			exportedObjects.get(1) => [
				assertEquals("my.pack.MyTest.InnerClass", qualifiedName.toString)
				assertTrue(EObjectOrProxy instanceof JvmGenericType)
			]
			exportedObjects.get(2) => [
				assertEquals("my.pack.MyTest.InnerInterface", qualifiedName.toString)
				assertTrue(EObjectOrProxy instanceof JvmGenericType)
			]
			exportedObjects.get(3) => [
				assertEquals("my.pack.MyTest.InnerEnum", qualifiedName.toString)
				assertTrue(EObjectOrProxy instanceof JvmEnumerationType)
			]
			exportedObjects.get(4) => [
				assertEquals("my.pack.MyTest.InnerAnnotation", qualifiedName.toString)
				assertTrue(EObjectOrProxy instanceof JvmAnnotationType)
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
		'''.resultsIn [
			val mytest = exportedObjects.head
			assertEquals("my.pack.MyTest", mytest.qualifiedName.toString)
			assertEquals("<T>", mytest.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS))
			
			val innerinterface = exportedObjects.get(1)
			assertEquals("my.pack.MyTest.InnerInterface", innerinterface.qualifiedName.toString)
			assertEquals("<A,B>", innerinterface.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS))
			assertEquals(Boolean.TRUE.toString(),innerinterface.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE))
			
			val deepNested = exportedObjects.get(2)
			assertEquals("my.pack.MyTest.InnerInterface.DeepNested", deepNested.qualifiedName.toString)
			assertEquals("<X>", deepNested.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS))
		]
	}
	
	@Test def void testEmptyFile() {
		'''
			//package my.pack;
		'''.resultsIn [
			assertTrue(exportedObjects.isEmpty)
		]
	}
	
	
	protected def void resultsIn(CharSequence javaCode, (IResourceDescription)=>void assertion) {
		val resourceSet = resourceSet('SomeJava.java' -> javaCode.toString)
		compilerPhases.setIndexing(resourceSet, true)
		val resource = resourceSet.resources.head
		val description = resourceDesriptionManager.getResourceDescription(resource)
		assertion.apply(description)
	}
	
	@Inject CompilerPhases compilerPhases
	@Inject Provider<XtextResourceSet> resourceSetProvider
	@Inject IResourceDescription.Manager resourceDesriptionManager
	
	def protected resourceSet(Pair<String,String> ... files) {
		val result = resourceSetProvider.get
//		new ChunkedResourceDescriptions().attachToEmfObject(result)
//		result.classpathURIContext = class.classLoader
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