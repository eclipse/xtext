/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup
import org.eclipse.xtext.linking.langATestLanguage.Main
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.tests.AbstractXtextTests

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class PortableURIsTest extends AbstractXtextTests {
	
	override setUp() throws Exception {
		super.setUp();
		with(new LangATestLanguageStandaloneSetup());
	}
	
	@Test def void testPortableUris() {
		val resourceSet = get(XtextResourceSet)
		val resourceA = resourceSet.createResource(URI.createURI("hubba:/bubba.langatestlanguage")) as StorageAwareResource
		val resourceB = resourceSet.createResource(URI.createURI("hubba:/bubba2.langatestlanguage")) as StorageAwareResource
		resourceB.load(getAsStream('''
			type B
		'''), null)
		resourceA.load(getAsStream('''
			import 'hubba:/bubba2.langatestlanguage'
			
			type A extends B
		'''), null)
		val extended = resourceA.contents.filter(Main).head.types.head.extends
		val uri = EcoreUtil.getURI(extended)
		val portableURI = resourceA.portableURIs.toPortableURI(resourceA, uri)
		assertEquals(resourceA.URI, portableURI.trimFragment)
		assertTrue(resourceA.portableURIs.isPortableURIFragment(portableURI.fragment))
		assertSame(extended, resourceA.getEObject(portableURI.fragment))
	}
	
	@Test def void testPortableReferenceDescriptions() {
		val resourceSet = get(XtextResourceSet)
		val resourceA = resourceSet.createResource(URI.createURI("hubba:/bubba.langatestlanguage")) as StorageAwareResource
		val resourceB = resourceSet.createResource(URI.createURI("hubba:/bubba2.langatestlanguage")) as StorageAwareResource
		resourceB.load(getAsStream('''
			type B
		'''), null)
		resourceA.load(getAsStream('''
			import 'hubba:/bubba2.langatestlanguage'
			
			type A extends B
		'''), null)
		val bout = new ByteArrayOutputStream
		val writable = resourceA.resourceStorageFacade.createResourceStorageWritable(bout)
		writable.writeResource(resourceA)
		
		val loadable = resourceA.resourceStorageFacade.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray))
		
		val resourceC = resourceSet.createResource(URI.createURI("hubba:/bubba3.langatestlanguage")) as StorageAwareResource
		resourceC.loadFromStorage(loadable)
		
		val refDesc = resourceC.resourceDescription.referenceDescriptions.head
		assertSame((resourceB.contents.head as Main).types.head, resourceSet.getEObject(refDesc.targetEObjectUri, false))
		assertSame((resourceC.contents.head as Main).types.head, resourceSet.getEObject(refDesc.sourceEObjectUri, false))
	}
	
	
	@Test def void testEObjectRelativeFragments() {
		checkFragmentBothDirections(EcorePackage.eINSTANCE, EcorePackage.eINSTANCE.EAnnotation_Details)
		checkFragmentBothDirections(EcorePackage.eINSTANCE.EAttribute_EAttributeType, EcorePackage.eINSTANCE.EAttribute_EAttributeType)
		try {
			checkFragmentBothDirections(EcorePackage.eINSTANCE.EAnnotation_EModelElement, EcorePackage.eINSTANCE.EAttribute_EAttributeType)
			Assert.fail();
		} catch (IllegalStateException e) {
			// expected
		}
	}
	
	def checkFragmentBothDirections(EObject container, EObject child) {
		val portableURIs = new PortableURIs()
		val fragment = portableURIs.getFragment(container, child)
		Assert.assertSame(child, portableURIs.getEObject(container, fragment))
	}
}