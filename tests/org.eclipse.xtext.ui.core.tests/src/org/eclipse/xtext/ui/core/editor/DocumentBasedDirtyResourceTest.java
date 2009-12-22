/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DocumentBasedDirtyResourceTest extends AbstractDocumentSimulatingTest implements  
	IResourceDescription.Manager, IResourceDescription {

	private String documentContent;
	private XtextResource resource;
	private DocumentBasedDirtyResource dirtyResource;
	private URI uri;
	private IResourceDescription description;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		uri = URI.createURI("scheme:/foobar.xtext");
		documentContent = "grammar foo with org.eclipse.xtext.common.Terminals\n"
				+ "generate test 'http://test'\n"
				+ "Model: name=ID;";
		resource = getResource(documentContent, uri.toString());
		DefaultResourceServiceProvider provider = new DefaultResourceServiceProvider();
		provider.setResourceDescriptionManager(this);
		resource.setResourceServiceProvider(provider);
		dirtyResource = new DocumentBasedDirtyResource();
		description = this;
	}
	
	public void testConnect_01() {
		try {
			dirtyResource.connect(null);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}
	
	public void testConnect_02() {
		dirtyResource.connect(this);
		try {
			dirtyResource.connect(new XtextDocument());
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	public void testConnect_03() {
		dirtyResource.connect(this);
		dirtyResource.connect(this); // no exception
	}
	
	public void testDisconnect_01() {
		try {
			dirtyResource.connect(null);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}
	
	public void testDisconnect_02() {
		try {
			dirtyResource.disconnect(this);
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	public void testDisconnect_03() {
		dirtyResource.connect(this);
		dirtyResource.disconnect(this);
		try {
			dirtyResource.disconnect(this);
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	public void testGetContents_01() {
		try {
			dirtyResource.getContents();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	public void testGetContents_02() {
		dirtyResource.connect(this);
		assertSame(documentContent, dirtyResource.getContents());
	}
	
	public void testGetContents_03() {
		dirtyResource.connect(this);
		String expectedContent = documentContent;
		documentContent = null;
		assertSame(expectedContent, dirtyResource.getContents());
	}
	
	public void testGetURI_01() {
		try {
			dirtyResource.getURI();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	public void testGetURI_02() {
		dirtyResource.connect(this);
		assertEquals(uri, dirtyResource.getURI());
	}
	
	public void testGetDescription_01() {
		try {
			dirtyResource.getDescription();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	public void testGetDescription_02() {
		dirtyResource.connect(this);
		assertNotSame(this, dirtyResource.getDescription());
		assertSame(this.getURI(), dirtyResource.getDescription().getURI());
	}
	
	public void testGetDescription_03() {
		dirtyResource.connect(this);
		description = null;
		assertNull(getResourceDescription(resource));
		assertNotSame(this, dirtyResource.getDescription());
		assertSame(this.getURI(), dirtyResource.getDescription().getURI());
	}
	
	public void testCopyState() {
		dirtyResource.connect(this);
		assertSame(documentContent, dirtyResource.getContents());
		documentContent = "modified";
		dirtyResource.copyState(resource.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(resource));
		assertSame(documentContent, dirtyResource.getContents());
	}
	
	@Override
	public String get() {
		return documentContent;
	}

	@Override
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		try {
			return work.exec(resource);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public IResourceDescription getResourceDescription(Resource resource) {
		assertSame(this.resource, resource);
		return description;
	}

	public URI getURI() {
		return uri;
	}

	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		fail("Unexpected call");
		return false;
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass clazz) {
		fail("Unexpected call");
		return null;
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(EClass clazz, String name) {
		fail("Unexpected call");
		return null;
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
		fail("Unexpected call");
		return null;
	}
	
	public Iterable<IEObjectDescription> getExportedObjects() {
		return Iterables.emptyIterable();
	}
	
	public Iterable<String> getImportedNames() {
		fail("Unexpected call");
		return null;
	}
	
	public org.eclipse.xtext.resource.IContainer.Manager getContainerManager() {
		fail("Unexpected call");
		return null;
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		fail("Unexpected call");
		return Iterables.emptyIterable();
	}
	
}
