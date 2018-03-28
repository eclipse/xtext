package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.junit.Test
import com.google.inject.MembersInjector
import org.junit.Before
import org.junit.After

class JvmModelAssociatorTest extends AbstractJvmModelTest {
	
	@Inject extension JvmTypesBuilder
	@Inject MembersInjector<JvmModelAssociator> associatorInjector
	JvmModelAssociator assoc
	@Inject XtextResourceSet resourceSet
	@Inject DerivedStateAwareResource resource
	
	@Before
	def void createAssociator() {
		assoc = new JvmModelAssociator
		associatorInjector.injectMembers(assoc)
	}
	
	@After
	def void discardAssociator() {
		assoc = null
	}
	
	@Test
	def void testInference() {
		assoc.inferrerProvider = [[obj, acceptor, preIndexing|
			val firstType = obj.toClass('foo.Bar')
			val secondType = obj.toClass('foo.Baz') 
			assertNull(secondType.eResource)
			acceptor.accept(firstType) [
				^abstract = true
				assertNotNull(firstType.eResource)
				assertNotNull(secondType.eResource)
			]
			acceptor.accept(secondType) [
				^abstract = true
				assertNotNull(firstType.eResource)
			]
		]]
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
	def void testRemoveAssociation() {
		assoc.inferrerProvider = [[obj, acceptor, preIndexing|
			val firstType = obj.toClass('foo.Bar')
			val secondType = obj.toClass('foo.Baz') 
			assertNull(secondType.eResource)
			acceptor.accept(firstType) [
				^abstract = true
				assertNotNull(firstType.eResource)
				assertNotNull(secondType.eResource)
			]
			acceptor.accept(secondType) [
				^abstract = true
				assertNotNull(firstType.eResource)
			]
		]]
		resource.setDerivedStateComputer(null)
		resource.URI = URI::createURI('foo.txt')
		resourceSet.classpathURIContext = getClass()
		resourceSet.resources += resource
		val root = EcoreFactory::eINSTANCE.createEClass
		resource.contents += root
		assoc.installDerivedState(resource,true)
		var jvmElements = assoc.getJvmElements(root)
		assertEquals(2, jvmElements.size)
		val jvmElement1 = jvmElements.get(0)
		val jvmElement2 = jvmElements.get(1)
		var sources1 = assoc.getSourceElements(jvmElement1)
		assertEquals(1, sources1.size)
		assertEquals(root, sources1.get(0))
		var sources2 = assoc.getSourceElements(jvmElement2)
		assertEquals(1, sources2.size)
		assertEquals(root, sources2.get(0))
		// test
		assoc.removeAssociation(root, jvmElement2)
		
		jvmElements = assoc.getJvmElements(root)
		assertEquals(1, jvmElements.size)
		sources1 = assoc.getSourceElements(jvmElement1)
		assertEquals(1, sources1.size)
		assertEquals(root, sources1.get(0))
		sources2 = assoc.getSourceElements(jvmElement2)
		assertEquals(0, sources2.size)
	}
}

