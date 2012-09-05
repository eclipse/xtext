package org.eclipse.xtext.xbase.tests.resources

import com.google.inject.Inject
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test

import static org.junit.Assert.*

class XbaseResourceDescriptionStrategyTest extends AbstractXbaseTestCase {
	
	@Inject XbaseResourceDescriptionStrategy descriptionStrategy
	
	@Test def void testInterfaceDescription_01() {
		val interfaceType = TypesFactory::eINSTANCE.createJvmGenericType
		interfaceType.setInterface(true)
		interfaceType.setPackageName("foo")
		interfaceType.setSimpleName('MyType')
		val list = <IEObjectDescription>newArrayList()
		descriptionStrategy.createEObjectDescriptions(interfaceType, [ list += it ])
		assertTrue(list.exists[ "true" == getUserData(XbaseResourceDescriptionStrategy::IS_INTERFACE) ])
	}
	
	@Test def void testInterfaceDescription_02() {
		val interfaceType = TypesFactory::eINSTANCE.createJvmGenericType
		interfaceType.setInterface(false)
		interfaceType.setPackageName("foo")
		interfaceType.setSimpleName('MyType')
		val list = <IEObjectDescription>newArrayList()
		descriptionStrategy.createEObjectDescriptions(interfaceType, [ list += it ])
		assertFalse(list.exists[ "true" == getUserData(XbaseResourceDescriptionStrategy::IS_INTERFACE) ])
	}
}