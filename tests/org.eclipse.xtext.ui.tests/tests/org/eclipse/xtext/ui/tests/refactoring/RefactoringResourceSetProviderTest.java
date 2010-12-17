/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static com.google.common.collect.Iterables.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit.util.URIBasedTestResourceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RefactoringResourceSetProviderTest extends TestCase {

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private IWorkspace workspace;

	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	
	private ResourceSet resourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage")
				.injectMembers(this);
		resourceSet = resourceSetProvider.get(workspace.getRoot().getProject("test"));
	}

	public void testDirtyStateAware() throws IOException {
		final URI dirtyResourceURI = URI.createPlatformResourceURI("test/test.refactoringtestlanguage", true);
		final String testModel = "A { B }";
		IDirtyResource mockDirtyResource = new IDirtyResource() {

			public String getContents() {
				return testModel;
			}

			public IResourceDescription getDescription() {
				return new URIBasedTestResourceDescription(dirtyResourceURI);
			}

			public URI getURI() {
				return dirtyResourceURI;
			}
		};
		try {
			assertTrue(dirtyStateManager.manageDirtyState(mockDirtyResource));
			Resource dirtyResource = resourceSet.getResource(dirtyResourceURI, true);
			assertTrue(dirtyResource instanceof XtextResource);
			assertTrue(dirtyResource.isLoaded());
			assertFalse(dirtyResource.getContents().isEmpty());
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			dirtyResource.save(byteArrayOutputStream, null);
			assertEquals(testModel, new String(byteArrayOutputStream.toByteArray()));
		} finally {
			dirtyStateManager.discardDirtyState(mockDirtyResource);
		}
	}

	public void testLiveScope() throws Exception {
		assertNotNull(resourceSet.getLoadOptions().get(ResourceDescriptionsProvider.LIVE_SCOPE));
		final URI resourceURI = URI.createPlatformResourceURI("test/test.refactoringtestlanguage", true);
		Resource resource = resourceSet.createResource(resourceURI);
		resource.load(new StringInputStream("A { B }"), null);
		Element elementA = (Element) resource.getContents().get(0).eContents().get(0);
		assertExportedObject(resource, "A");
		elementA.setName("C");
		assertExportedObject(resource, "C");
	}

	protected void assertExportedObject(Resource resource, String name) {
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(resource);
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(resource.getURI());
		assertNotNull(resourceDescription);
		assertFalse(isEmpty(resourceDescription.getExportedObjects(new ISelector.SelectByName(QualifiedName.create(name)))));
	}
}
