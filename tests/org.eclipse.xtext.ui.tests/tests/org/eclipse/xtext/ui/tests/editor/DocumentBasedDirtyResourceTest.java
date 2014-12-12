/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

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
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		uri = URI.createURI("scheme:/foobar.xtext");
		documentContent = "grammar foo with org.eclipse.xtext.common.Terminals\n"
				+ "generate test 'http://test'\n"
				+ "Model: name=ID;";
		resource = getResource(documentContent, uri.toString());
		DefaultResourceServiceProvider provider = new DefaultResourceServiceProvider() {
			@Override
			public org.eclipse.xtext.resource.IResourceDescription.Manager getResourceDescriptionManager() {
				return DocumentBasedDirtyResourceTest.this;
			}
		};
		resource.setResourceServiceProvider(provider);
		dirtyResource = new DocumentBasedDirtyResource();
		description = this;
	}
	
	@Test public void testConnect_01() {
		try {
			dirtyResource.connect(null);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}
	
	@Test public void testConnect_02() {
		dirtyResource.connect(this);
		try {
			dirtyResource.connect(getDummyDocument());
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testConnect_03() {
		dirtyResource.connect(this);
		dirtyResource.connect(this); // no exception
	}
	
	@Test public void testDisconnect_01() {
		try {
			dirtyResource.connect(null);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}
	
	@Test public void testDisconnect_02() {
		try {
			dirtyResource.disconnect(this);
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testDisconnect_03() {
		dirtyResource.connect(this);
		dirtyResource.disconnect(this);
		try {
			dirtyResource.disconnect(this);
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testGetContents_01() {
		try {
			dirtyResource.getContents();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testGetContents_02() {
		dirtyResource.connect(this);
		assertSame(documentContent, dirtyResource.getContents());
	}
	
	@Test public void testGetContents_03() {
		dirtyResource.connect(this);
		String expectedContent = documentContent;
		documentContent = null;
		assertSame(expectedContent, dirtyResource.getContents());
	}
	
	@Test public void testGetURI_01() {
		try {
			dirtyResource.getURI();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testGetURI_02() {
		dirtyResource.connect(this);
		assertEquals(uri, dirtyResource.getURI());
	}
	
	@Test public void testGetDescription_01() {
		try {
			dirtyResource.getDescription();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testGetDescription_02() {
		dirtyResource.connect(this);
		assertNotSame(this, dirtyResource.getDescription());
		assertSame(this.getURI(), dirtyResource.getDescription().getURI());
	}
	
	@Test public void testGetDescription_03() {
		dirtyResource.connect(this);
		description = null;
		assertNull(getResourceDescription(resource));
		assertNotSame(this, dirtyResource.getDescription());
		assertSame(this.getURI(), dirtyResource.getDescription().getURI());
	}
	
	@Test public void testCopyState() {
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
	
	@Override
	public <T> T priorityReadOnly(IUnitOfWork<T, XtextResource> work) {
		return readOnly(work);
	}

	@Override
	public IResourceDescription getResourceDescription(Resource resource) {
		assertSame(this.resource, resource);
		return description;
	}
	
	@Override
	public Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(oldDescription, newDescription);
	}

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		fail("Unexpected invocation");
		return false;
	}
	
	@Override
	public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate,
			IResourceDescriptions descriptions) throws IllegalArgumentException {
		fail("Unexpected invocation");
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return Collections.emptyList();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return Collections.emptyList();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return Collections.emptyList();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return Collections.emptyList();
	}
	
	@Override
	public Iterable<QualifiedName> getImportedNames() {
		fail("Unexpected invocation");
		return null;
	}
	
	public org.eclipse.xtext.resource.IContainer.Manager getContainerManager() {
		fail("Unexpected invocation");
		return null;
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Collections.emptyList();
	}

	public List<ILexerTokenRegion> getTokens() {
		return Collections.emptyList();
	}

	protected IXtextDocument getDummyDocument() {
		return (IXtextDocument) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{IXtextDocument.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return null;
			}
		});
	}
	
}
