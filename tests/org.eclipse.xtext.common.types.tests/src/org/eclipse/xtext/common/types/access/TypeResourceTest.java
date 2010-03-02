/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.TypesFactory;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeResourceTest extends TestCase implements IMirror {

	private boolean initializeCalled;
	private EObject expectedObject;
	private String expectedFragment;
	private URI expectedURI;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		initializeCalled = false;
	}
	
	@Override
	protected void tearDown() throws Exception {
		expectedFragment = null;
		expectedObject = null;
		expectedURI = null;
		super.tearDown();
	}
	
	public void testConstructor_01() {
		TypeResource resource = new TypeResource();
		assertNull("uri", resource.getURI());
		assertNull("mirror", resource.getMirror());
	}
	
	public void testConstructor_02() {
		URI uri = URI.createURI("myURI");
		TypeResource resource = new TypeResource(uri);
		assertEquals(uri, resource.getURI());
		assertNull("mirror", resource.getMirror());
	}
	
	public void testLoad_01() throws IOException {
		TypeResource resource = createResource();
		resource.load(null);
		assertTrue(initializeCalled);
	}
	
	public void testLoad_02() throws IOException {
		TypeResource resource = createResource();
		resource.load(null, null);
		assertTrue(initializeCalled);
	}
	
	public void testSave_01() throws IOException {
		TypeResource resource = createResource();
		resource.load(null, null);
		try {
			resource.save(null);
			fail("Expected unsupported operation exception.");
		} catch (UnsupportedOperationException ex) {
			// ok
		}
	}
	
	public void testSave_02() throws IOException {
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
	
	public void testGetURIFragment_01() {
		TypeResource resource = createResource();
		expectedFragment = "Foobar";
		expectedObject = TypesFactory.eINSTANCE.createJvmVoid();
		assertEquals(expectedFragment, resource.getURIFragment(expectedObject));
	}
	
	public void testGetEObject_01() {
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
	
	public void initialize(TypeResource typeResource) {
		initializeCalled = true;
		assertEquals(expectedURI, typeResource.getURI());
	}

	public EObject getEObject(Resource resource, String fragment) {
		assertEquals(expectedURI, resource.getURI());
		assertEquals(expectedFragment, fragment);
		return expectedObject;
	}

	public String getFragment(EObject obj) {
		assertEquals(expectedObject, obj);
		return expectedFragment;
	}

}
