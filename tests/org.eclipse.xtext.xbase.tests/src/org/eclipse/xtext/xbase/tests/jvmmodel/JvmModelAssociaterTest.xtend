package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.junit.Test

import static org.junit.Assert.*

class JvmModelAssociaterTest extends AbstractJvmModelTest {
	
	@Inject extension JvmTypesBuilder
	
	@Test
	def void testInference() {
		val assoc = new JvmModelAssociator();
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
		val resource = new DerivedStateAwareResource()
		resource.contents += EcoreFactory::eINSTANCE.createEClass
		assoc.installDerivedState(resource,true)
		assertFalse((resource.contents.get(1) as JvmDeclaredType).^abstract)
		
		resource.contents.clear
		resource.contents += EcoreFactory::eINSTANCE.createEClass
		assoc.installDerivedState(resource,false)
		assertTrue((resource.contents.get(1) as JvmDeclaredType).^abstract)
		
	}
}