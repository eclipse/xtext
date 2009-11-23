/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IExportedEObjectsProvider;
import org.eclipse.xtext.resource.IImportedNamesProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DocumentBasedDirtyResourceTest extends AbstractDocumentSimulatingTest implements  
	IExportedEObjectsProvider.Registry, IImportedNamesProvider.Registry, 
	IImportedNamesProvider, IExportedEObjectsProvider {

	private String documentContent;
	private XtextResource resource;
	private DocumentBasedDirtyResource dirtyResource;
	private Iterable<String> importedNames;
	private Iterable<IEObjectDescription> exportedDescriptions;
	private String uri;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		uri = "scheme://foobar";
		documentContent = "grammar foo with org.eclipse.xtext.common.Terminals\n"
				+ "generate test 'http://test'\n"
				+ "Model: name=ID;";
		resource = getResource(documentContent, uri);
		dirtyResource = new DocumentBasedDirtyResource();
		dirtyResource.setExportedEObjectProviderRegistry(this);
		dirtyResource.setImportedNamesProviderRegistry(this);
		importedNames = Lists.newArrayList();
		exportedDescriptions = Lists.newArrayList();
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
		assertEquals(uri, dirtyResource.getURI().toString());
	}
	
	public void testGetImportedNames_01() {
		try {
			dirtyResource.getImportedNames();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	public void testGetImportedNames_02() {
		dirtyResource.connect(this);
		assertSame(importedNames, dirtyResource.getImportedNames());
	}
	
	public void testGetExportedDescriptions_01() {
		try {
			dirtyResource.getExportedObjects();
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	public void testGetExportedDescriptions_02() {
		dirtyResource.connect(this);
		assertSame(exportedDescriptions, dirtyResource.getExportedObjects());
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

	public IExportedEObjectsProvider getExportedEObjectsProvider(Resource resource) {
		assertSame(this.resource, resource);
		return this;
	}

	public IImportedNamesProvider getImportedNamesProvider(Resource resource) {
		assertSame(this.resource, resource);
		return this;
	}

	public Iterable<String> getImportedNames(Resource resource) {
		assertSame(this.resource, resource);
		return importedNames;
	}

	public Iterable<IEObjectDescription> getExportedObjects(Resource resource) {
		assertSame(this.resource, resource);
		return exportedDescriptions;
	}
	
}
