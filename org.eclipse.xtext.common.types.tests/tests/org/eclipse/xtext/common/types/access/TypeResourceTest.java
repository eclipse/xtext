/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeResourceTest extends Assert implements IMirror {

	private boolean initializeCalled;
	private EObject expectedObject;
	private String expectedFragment;
	private URI expectedURI;

	@Before
	public void setUp() throws Exception {
		initializeCalled = false;
	}
	
	@After
	public void tearDown() throws Exception {
		expectedFragment = null;
		expectedObject = null;
		expectedURI = null;
	}
	
	@Test public void testConstructor_01() {
		TypeResource resource = new TypeResource();
		assertNull("uri", resource.getURI());
		assertNull("mirror", resource.getMirror());
	}
	
	@Test public void testConstructor_02() {
		URI uri = URI.createURI("myURI");
		TypeResource resource = new TypeResource(uri);
		assertEquals(uri, resource.getURI());
		assertNull("mirror", resource.getMirror());
	}
	
	@Test public void testLoad_01() throws IOException {
		TypeResource resource = createResource();
		resource.load(null);
		assertTrue(initializeCalled);
	}
	
	@Test public void testLoad_02() throws IOException {
		TypeResource resource = createResource();
		resource.load(null, null);
		assertTrue(initializeCalled);
	}
	
	@Test public void testSave_01() throws IOException {
		TypeResource resource = createResource();
		resource.load(null, null);
		try {
			resource.save(null);
			fail("Expected unsupported operation exception.");
		} catch (UnsupportedOperationException ex) {
			// ok
		}
	}
	
	@Test public void testSave_02() throws IOException {
		TypeResource resource = createResource();
		resource.load(null, null);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			resource.save(stream, null);
			fail("Expected unsupported operation exception.");
		} catch (UnsupportedOperationException ex) {
			// ok
		} finally {
			stream.close();
		}
	}
	
	@Test public void testGetURIFragment_01() {
		TypeResource resource = createResource();
		expectedFragment = "Foobar";
		expectedObject = TypesFactory.eINSTANCE.createJvmVoid();
		assertEquals(expectedFragment, resource.getURIFragment(expectedObject));
	}
	
	@Test public void testGetEObject_01() {
		TypeResource resource = createResource();
		expectedFragment = "Foobar";
		expectedObject = TypesFactory.eINSTANCE.createJvmVoid();
		assertEquals(expectedObject, resource.getEObject(expectedFragment));
	}
	
	protected TypeResource createResource() {
		expectedURI = URI.createURI("myURI");
		TypeResource resource = new TypeResource(expectedURI);
		resource.setMirror(this);
		return resource;
	}
	
	@Override
	public void initialize(TypeResource typeResource) {
		initializeCalled = true;
		assertEquals(expectedURI, typeResource.getURI());
	}

	@Override
	public EObject getEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
		assertEquals(expectedURI, resource.getURI());
		assertEquals(expectedFragment, fragment);
		return expectedObject;
	}

	@Override
	public String getFragment(EObject obj, IFragmentProvider.Fallback fallback) {
		assertEquals(expectedObject, obj);
		return expectedFragment;
	}

}
