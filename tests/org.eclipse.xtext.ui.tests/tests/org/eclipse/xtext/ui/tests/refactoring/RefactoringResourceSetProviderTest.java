/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit4.util.URIBasedTestResourceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringResourceSetProviderTest extends Assert {

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private IWorkspace workspace;

	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

	private ResourceSet resourceSet;

	@Before
	public void setUp() throws Exception {
		Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage")
				.injectMembers(this);
		IProject project = createProject("test");
		addNature(project, XtextProjectHelper.NATURE_ID);
		resourceSet = resourceSetProvider.get(workspace.getRoot().getProject("test"));
	}

	@After
	public void tearDown() throws Exception {
		cleanWorkspace();
	}

	@Test public void testDirtyStateAware() throws IOException {
		final URI dirtyResourceURI = URI.createPlatformResourceURI("test/test.refactoringtestlanguage", true);
		final String testModel = "A { B }";
		IDirtyResource mockDirtyResource = new IDirtyResource() {

			public String getContents() {
				return testModel;
			}

			public String getActualContents() {
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

	@Test public void testLiveScope() throws Exception {
		assertNotNull(resourceSet.getLoadOptions().get(ResourceDescriptionsProvider.LIVE_SCOPE));
		final URI resourceURI = URI.createPlatformResourceURI("test/test.refactoringtestlanguage", true);
		Resource resource = resourceSet.createResource(resourceURI);
		resource.load(new StringInputStream("A { B }"), null);
		Element elementA = (Element) resource.getContents().get(0).eContents().get(0);
		assertExportedObject(resource, "A");
		elementA.setName("C");
		assertExportedObject(resource, "C");
	}

	@Test public void testLiveScope2() throws Exception {
		String pathName = "test/test.refactoringtestlanguage";
		String pathName2 = "test/test2.refactoringtestlanguage";
		String model = "A { ref B }";
		createFile(pathName, model);
		createFile(pathName2, "B {}");
		waitForAutoBuild();

		assertNotNull(resourceSet.getLoadOptions().get(ResourceDescriptionsProvider.LIVE_SCOPE));
		final URI resourceURI = URI.createPlatformResourceURI(pathName, true);
		Resource resource = resourceSet.getResource(resourceURI, true);
		Element elementA = (Element) resource.getContents().get(0).eContents().get(0);
		Element elementB = elementA.getReferenced().get(0);
		assertFalse(elementB.eIsProxy());

		assertExportedObject(resource, "A");
		elementA.setName("C");
		assertExportedObject(resource, "C");
	}

	protected void assertExportedObject(Resource resource, String name) {
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(resource);
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(resource.getURI());
		assertNotNull(resourceDescription);
		assertFalse(isEmpty(resourceDescription.getExportedObjects(EcorePackage.Literals.EOBJECT,
				QualifiedName.create(name), false)));
	}
}
