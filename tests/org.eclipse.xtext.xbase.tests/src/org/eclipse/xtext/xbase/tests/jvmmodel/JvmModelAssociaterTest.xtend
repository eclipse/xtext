package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.XbaseStandaloneSetup
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.xbase.jvmmodel.JvmModelInferrerRegistry

class JvmModelAssociaterTest extends AbstractJvmModelTest {
	
	@Inject extension JvmTypesBuilder
	@Inject JvmModelAssociator assoc
	@Inject XtextResourceSet resourceSet
	@Inject DerivedStateAwareResource resource
	
	override getInjector() {
		new XbaseStandaloneSetup().createInjector
	}
	
	@Test
	def void testInference() {
		assoc.inferrer = [obj, acceptor, preIndexing|
			val firstType = obj.toClass('foo.Bar')
			val secondType = obj.toClass('foo.Baz') 
			assertNull(secondType.eResource)
			acceptor.accept(firstType).initializeLater[
				^abstract = true
				assertNotNull(firstType.eResource)
				assertNotNull(secondType.eResource)
			]
			acceptor.accept(secondType).initializeLater[
				^abstract = true
				assertNotNull(firstType.eResource)
			]
		]
		resource.setDerivedStateComputer(null)
		resource.URI = URI::createURI('foo.txt')
		resourceSet.classpathURIContext = getClass()
		resourceSet.resources += resource
		resource.contents += EcoreFactory::eINSTANCE.createEClass
		assoc.installDerivedState(resource,true)
		assertFalse((resource.contents.get(1) as JvmDeclaredType).^abstract)
		
		resource.contents.clear
		resource.contents += EcoreFactory::eINSTANCE.createEClass
		assoc.installDerivedState(resource,false)
		val type = (resource.contents.get(1) as JvmGenericType)
		assertTrue(type.^abstract)
		
		// test extends object and default constructor
		assertEquals(1, type.members.filter(typeof(JvmConstructor)).size)
		assertEquals("java.lang.Object", type.superTypes.head?.qualifiedName)
	}
	
	@Test
	def void testInference_2() {
		assoc.inferrer = [obj, acceptor, preIndexing|
			val firstType = obj.toClass('foo.Bar')
			val secondType = obj.toClass('foo.Baz') 
			assertNull(secondType.eResource)
			acceptor.accept(firstType).initializeLater[
				^abstract = true
				assertNotNull(firstType.eResource)
				assertNotNull(secondType.eResource)
			]
			acceptor.accept(secondType).initializeLater[
				^abstract = true
				assertNotNull(firstType.eResource)
			]
		]
		JvmModelInferrerRegistry::INSTANCE.register('txt') [obj, acceptor, preIndexing|
			assertEquals(3, obj.eResource.contents.size)
			val anotherType = obj.toClass('foo.AnotherOne')
			acceptor.accept(anotherType).initializeLater [
				^abstract = true
				eResource.contents.filter(typeof(JvmGenericType)).findFirst[ identifier == 'foo.Bar'] => [ bar |
					bar.superTypes += newTypeRef(it)
				]
			]
			assertEquals(4, obj.eResource.contents.size)
		]
		resource.setDerivedStateComputer(null)
		resource.URI = URI::createURI('foo.txt')
		resourceSet.classpathURIContext = getClass()
		resourceSet.resources += resource
		resource.contents += EcoreFactory::eINSTANCE.createEClass
		assoc.installDerivedState(resource,true)
		assertFalse((resource.contents.get(1) as JvmDeclaredType).^abstract)
		assertFalse((resource.contents.get(3) as JvmDeclaredType).^abstract)
		
		resource.contents.clear
		resource.contents += EcoreFactory::eINSTANCE.createEClass
		assoc.installDerivedState(resource,false)
		val type = (resource.contents.get(1) as JvmGenericType)
		val anotherType = (resource.contents.get(3) as JvmGenericType)
		assertTrue(type.^abstract)
		assertTrue(anotherType.^abstract)
		assertEquals('foo.AnotherOne', anotherType.identifier)
		
		// test extends object and default constructor
		assertEquals(1, type.members.filter(typeof(JvmConstructor)).size)
		assertEquals(1, type.superTypes.size)
		assertSame(type.superTypes.head.type, anotherType)
	}
	
	
}