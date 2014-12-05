/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcorePackage
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.linking.langATestLanguage.Main
import org.eclipse.emf.ecore.util.EcoreUtil

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
		val portableURI = resourceA.portableURIs.toPortableURI(resourceA, uri.trimFragment, uri.fragment)
		assertEquals(resourceA.URI, portableURI.trimFragment)
		assertTrue(resourceA.portableURIs.isPortableURIFragment(portableURI.fragment))
		assertSame(extended, resourceA.getEObject(portableURI.fragment))
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
		val fragments = new PortableURIs()
		val fragment = fragments.getFragment(container, child)
		Assert.assertSame(child, fragments.getEObject(container, fragment))
	}
}