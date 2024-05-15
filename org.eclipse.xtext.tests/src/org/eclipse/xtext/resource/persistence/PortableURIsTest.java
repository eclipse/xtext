/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PortableURIsTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new LangATestLanguageStandaloneSetup());
	}

	@Test
	public void testPortableUris() throws Exception {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		StorageAwareResource resourceA = (StorageAwareResource) resourceSet
				.createResource(URI.createURI("hubba:/bubba.langatestlanguage"));
		StorageAwareResource resourceB = (StorageAwareResource) resourceSet
				.createResource(URI.createURI("hubba:/bubba2.langatestlanguage"));
		resourceB.load(getAsStream("type B"), null);
		resourceA.load(getAsStream("import 'hubba:/bubba2.langatestlanguage' type A extends B"), null);
		Type extended = Iterables
				.getFirst(Iterables.getFirst(Iterables.filter(resourceA.getContents(), Main.class), null).getTypes(),
						null)
				.getExtends();
		URI uri = EcoreUtil.getURI(extended);
		URI portableURI = resourceA.getPortableURIs().toPortableURI(resourceA, uri);
		Assert.assertEquals(resourceA.getURI(), portableURI.trimFragment());
		Assert.assertTrue(resourceA.getPortableURIs().isPortableURIFragment(portableURI.fragment()));
		Assert.assertSame(extended, resourceA.getEObject(portableURI.fragment()));
	}

	@Test
	public void testPortableReferenceDescriptions() throws Exception {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		StorageAwareResource resourceA = (StorageAwareResource) resourceSet
				.createResource(URI.createURI("hubba:/bubba.langatestlanguage"));
		StorageAwareResource resourceB = (StorageAwareResource) resourceSet
				.createResource(URI.createURI("hubba:/bubba2.langatestlanguage"));
		resourceB.load(getAsStream("type B"), null);
		resourceA.load(getAsStream("import 'hubba:/bubba2.langatestlanguage' type A extends B"), null);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ResourceStorageWritable writable = resourceA.getResourceStorageFacade().createResourceStorageWritable(bout);
		writable.writeResource(resourceA);
		IResourceStorageFacade _resourceStorageFacade = resourceA.getResourceStorageFacade();
		ResourceStorageLoadable loadable = _resourceStorageFacade
				.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray()));
		StorageAwareResource resourceC = (StorageAwareResource) resourceSet
				.createResource(URI.createURI("hubba:/bubba3.langatestlanguage"));
		resourceC.loadFromStorage(loadable);
		IReferenceDescription refDesc = Iterables
				.getFirst(resourceC.getResourceDescription().getReferenceDescriptions(), null);
		Assert.assertSame(
				Iterables.getFirst(((Main) Iterables.getFirst(resourceB.getContents(), null)).getTypes(), null),
				resourceSet.getEObject(refDesc.getTargetEObjectUri(), false));
		Assert.assertSame(
				Iterables.getFirst(((Main) Iterables.getFirst(resourceC.getContents(), null)).getTypes(), null),
				resourceSet.getEObject(refDesc.getSourceEObjectUri(), false));
	}

	@Test
	public void testEObjectRelativeFragments() throws Exception {
		checkFragmentBothDirections(EcorePackage.eINSTANCE, EcorePackage.eINSTANCE.getEAnnotation_Details());
		checkFragmentBothDirections(EcorePackage.eINSTANCE.getEAttribute_EAttributeType(),
				EcorePackage.eINSTANCE.getEAttribute_EAttributeType());
		try {
			checkFragmentBothDirections(EcorePackage.eINSTANCE.getEAnnotation_EModelElement(),
					EcorePackage.eINSTANCE.getEAttribute_EAttributeType());
			Assert.fail();
		} catch (IllegalArgumentException _t) {
			// expected
		}
	}

	public void checkFragmentBothDirections(EObject container, EObject child) {
		PortableURIs portableURIs = new PortableURIs();
		String fragment = portableURIs.getFragment(container, child);
		Assert.assertSame(child, portableURIs.getEObject(container, fragment));
	}
}
