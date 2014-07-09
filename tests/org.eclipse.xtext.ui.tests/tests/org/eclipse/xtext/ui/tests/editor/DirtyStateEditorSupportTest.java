/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IContainer.Manager;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport.IDirtyStateEditorSupportClient;
import org.eclipse.xtext.ui.editor.DirtyStateManager;
import org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.notification.StateChangeEventBroker;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DirtyStateEditorSupportTest extends AbstractDocumentSimulatingTest 
	implements DirtyStateEditorSupport.IDirtyStateEditorSupportClient, DirtyStateEditorSupport.IConcurrentEditingCallback, IDirtyResource,
		IResourceDescription.Manager, IResourceDescriptions {

	private DirtyStateEditorSupport dirtyStateSupport;
	private VerifyListener verifyListener;
	private LinkedList<Boolean> ignoreConcurrentEditing;
	private URI resourceURI;
	private XtextResource resource;
	private ResourceSetImpl resourceSet;
	private DirtyStateManager dirtyStateManager;
	private StateChangeEventBroker stateChangeEventBroker;
	private IXtextModelListener modelListener;
	private DocumentBasedDirtyResource dirtyResource;
	private IXtextDocument document;
	private List<IEObjectDescription> exportedObjects;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		document = this;
		resourceSet = new ResourceSetImpl();
		resourceURI = URI.createURI("scheme://foo");
		resource = new XtextResource(resourceURI);
		final DefaultResourceServiceProvider resourceServiceProvider = new DefaultResourceServiceProvider() {
			@Override
			public org.eclipse.xtext.resource.IResourceDescription.Manager getResourceDescriptionManager() {
				return DirtyStateEditorSupportTest.this;
			}
		};
		ResourceServiceProviderRegistryImpl registry = new ResourceServiceProviderRegistryImpl() {
			@Override
			public IResourceServiceProvider getResourceServiceProvider(URI uri) {
				return resourceServiceProvider;
			}
		};
		resource.setResourceServiceProvider(resourceServiceProvider);
		resourceSet.getResources().add(resource);
		dirtyStateSupport = new DirtyStateEditorSupport();
		dirtyStateSupport.setConcurrentEditingWarningDialog(this);
		dirtyStateSupport.setResourceDescriptions(this);
		dirtyStateManager = new DirtyStateManager();
		stateChangeEventBroker = new StateChangeEventBroker();
		dirtyStateManager.addListener(stateChangeEventBroker);
		dirtyStateSupport.setDirtyStateManager(dirtyStateManager);
		dirtyStateSupport.setStateChangeEventBroker(stateChangeEventBroker);
		dirtyResource = new DocumentBasedDirtyResource();
		dirtyStateSupport.setDirtyResource(dirtyResource);
		dirtyStateSupport.setResourceServiceProviderRegistry(registry);
		ignoreConcurrentEditing = Lists.newLinkedList();
		exportedObjects = Collections.emptyList();
	}
	
	@Test public void testInitialize_01(){
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertNotNull(verifyListener);
		assertNotNull(modelListener);
		assertFalse(dirtyStateManager.hasContent(resourceURI));
		assertEquals(resourceURI, dirtyResource.getURI());
	}
	
	@Test public void testRemoveDirtyStateSupport_01(){
		dirtyStateSupport.initializeDirtyStateSupport(this);
		dirtyStateSupport.removeDirtyStateSupport(this);
		assertNull(verifyListener);
		assertNull(modelListener);
		assertFalse(dirtyStateManager.hasContent(resourceURI));
		try {
			dirtyResource.getURI();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expect
		}
	}
	
	@Test public void testRemoveDirtyStateSupport_02(){
		dirtyStateSupport.initializeDirtyStateSupport(this);
		document = null; // client.getDocument() returns null when editor is disposing
		dirtyStateSupport.removeDirtyStateSupport(this);
		assertNull(verifyListener);
		assertNull(modelListener);
		assertFalse(dirtyStateManager.hasContent(resourceURI));
		try {
			dirtyResource.getURI();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expect
		}
	}
	
	@Test public void testDoVerify_01() {
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertTrue(dirtyStateSupport.doVerify());
	}
	
	@Test public void testDoVerify_02() {
		ignoreConcurrentEditing.add(Boolean.FALSE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertFalse(dirtyStateSupport.doVerify());
		assertTrue(dirtyStateManager.hasContent(resourceURI));
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
	}
	
	@Test public void testDoVerify_03() {
		ignoreConcurrentEditing.add(Boolean.TRUE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertTrue(dirtyStateSupport.doVerify());
		assertTrue(dirtyStateManager.hasContent(resourceURI));
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
	}
	
	@Test public void testIsEditingPossible_01() {
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertTrue(dirtyStateSupport.isEditingPossible(this));
	}
	
	@Test public void testIsEditingPossible_02() {
		try {
			assertTrue(dirtyStateSupport.isEditingPossible(this));
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testIsEditingPossible_03() {
		try {
			assertTrue(dirtyStateSupport.isEditingPossible(null));
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}

	@Test public void testIsEditingPossible_04() {
		ignoreConcurrentEditing.add(Boolean.FALSE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertFalse(dirtyStateSupport.isEditingPossible(this));
		assertTrue(dirtyStateManager.hasContent(resourceURI));
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
	}
	
	@Test public void testIsEditingPossible_05() {
		ignoreConcurrentEditing.add(Boolean.TRUE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertTrue(dirtyStateSupport.isEditingPossible(this));
		assertTrue(dirtyStateManager.hasContent(resourceURI));
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
	}
	
	@Test public void testIsEditingPossible_06() {
		ignoreConcurrentEditing.add(Boolean.TRUE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertTrue(dirtyStateSupport.isEditingPossible(this));
		assertTrue(dirtyStateSupport.isEditingPossible(this));
	}
	
	@Test public void testIsEditingPossible_07() {
		ignoreConcurrentEditing.add(Boolean.FALSE);
		ignoreConcurrentEditing.add(Boolean.FALSE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertFalse(dirtyStateSupport.isEditingPossible(this));
		assertFalse(dirtyStateSupport.isEditingPossible(this));
	}
	
	@Test public void testMarkEditorClean_01() {
		try {
			dirtyStateSupport.markEditorClean(this);
			fail("Expected exception");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testMarkEditorClean_02() {
		try {
			dirtyStateSupport.markEditorClean(null);
			fail("Expected exception");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test public void testMarkEditorClean_03() {
		assertFalse(dirtyStateManager.hasContent(resourceURI));
		dirtyStateSupport.initializeDirtyStateSupport(this);
		dirtyStateSupport.isEditingPossible(this);
		assertTrue(dirtyStateManager.hasContent(resourceURI));
		dirtyStateSupport.markEditorClean(this);
		assertFalse(dirtyStateManager.hasContent(resourceURI));
		assertNotNull(modelListener);
		assertNotNull(verifyListener);
	}
	
	@Test public void testModelChanged_01() {
		dirtyStateSupport.initializeDirtyStateSupport(this);
		dirtyStateSupport.modelChanged(resource);
		assertTrue(dirtyStateManager.hasContent(resourceURI));
	}

	@Test public void testModelChanged_02() {
		ignoreConcurrentEditing.add(Boolean.TRUE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		dirtyStateSupport.isEditingPossible(this);
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
		exportedObjects = Lists.newArrayList(EObjectDescription.create(QualifiedName.create("foo"), EcoreFactory.eINSTANCE.createEClass()));
		dirtyStateSupport.modelChanged(resource);
		assertTrue(dirtyStateManager.hasContent(resourceURI));
		assertEquals(get(), dirtyStateManager.getContent(resourceURI));
	}
	
	@Test public void testModelChanged_03() {
		ignoreConcurrentEditing.add(Boolean.FALSE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
		dirtyStateSupport.modelChanged(resource);
		assertTrue(dirtyStateManager.hasContent(resourceURI));
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
	}
	
	@Test public void testModelChanged_04() {
		ignoreConcurrentEditing.add(Boolean.TRUE);
		dirtyStateManager.manageDirtyState(this);
		dirtyStateSupport.initializeDirtyStateSupport(this);
		dirtyStateSupport.isEditingPossible(this);
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
		dirtyStateSupport.modelChanged(resource);
		assertTrue(dirtyStateManager.hasContent(resourceURI));
		assertEquals(getContents(), dirtyStateManager.getContent(resourceURI));
	}
	
	@Test public void testModelChanged_05() {
		dirtyStateSupport.initializeDirtyStateSupport(this);
		resource.setTrackingModification(true);
		dirtyStateSupport.modelChanged(resource);
		assertFalse(dirtyStateManager.hasContent(resourceURI));
	}
	
	@Test public void testModelChanged_06() {
		dirtyStateSupport.initializeDirtyStateSupport(this);
		resource.setTrackingModification(true);
		resource.setModified(true);
		dirtyStateSupport.modelChanged(resource);
		assertTrue(dirtyStateManager.hasContent(resourceURI));
	}
	
	public void addVerifyListener(VerifyListener listener) {
		assertNull(this.verifyListener);
		this.verifyListener = listener;
	}
	
	@Override
	public void addModelListener(IXtextModelListener listener) {
		assertNull(this.modelListener);
		this.modelListener = listener;
	}
	
	@Override
	public void removeModelListener(IXtextModelListener listener) {
		assertSame(this.modelListener, listener);
		this.modelListener = null;
	}

	public IXtextDocument getDocument() {
		return document;
	}
	
	@Override
	public String get() {
		return "myContents";
	}
	
	@Override
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		try {
			return work.exec(resource);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Shell getShell() {
		fail("Unexpected call");
		return null;
	}

	public void removeVerifyListener(VerifyListener listener) {
		assertSame(this.verifyListener, listener);
		this.verifyListener = null;
	}

	public boolean isConcurrentEditingIgnored(IDirtyStateEditorSupportClient client) {
		assertFalse(ignoreConcurrentEditing.isEmpty());
		return ignoreConcurrentEditing.removeFirst();
	}

	public String getContents() {
		return "otherContents";
	}
	
	public String getActualContents() {
		fail("Unexpected call");
		return null;
	}

	public IResourceDescription getDescription() {
		fail("Unexpected call");
		return null;
	}

	public URI getURI() {
		return resourceURI;
	}

	public Manager getContainerManager() {
		fail("Unexpected call");
		return null;
	}

	public IResourceDescription getResourceDescription(Resource resource) {
		return new DefaultResourceDescription(resource, null) {
			@Override
			protected List<IEObjectDescription> computeExportedObjects() {
				return exportedObjects;
			}
		};
	}

	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		return false;
	}
	
	public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate,
			IResourceDescriptions descriptions) throws IllegalArgumentException {
		return false;
	}

	public boolean isDirty() {
		return true;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		throw new UnsupportedOperationException();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return null;
	}
	
	public boolean isEmpty() {
		return true;
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		throw new UnsupportedOperationException();
	}
	
	public Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(oldDescription, newDescription);
	}

	public List<ILexerTokenRegion> getTokens() {
		return Collections.emptyList();
	}

}
