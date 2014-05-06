/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.resource;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit4.util.URIBasedTestResourceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.foo.File;
import org.eclipse.xtext.ui.tests.foo.Stuff;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Before;

import com.google.common.base.Throwables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractScopeResourceDescriptionsTest {

	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private FileExtensionProvider fileExt;

	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

	private ResourceSet resourceSet;

	@Inject
	private IWorkspace workspace;

	protected void assertDirtyState(boolean enabled) throws IOException {
		String dirtyResourceName = "test/test." + fileExt.getPrimaryFileExtension();
		final URI dirtyResourceURI = URI.createPlatformResourceURI(dirtyResourceName, true);
		final String testModel = "stuff foo stuff bar refs foo";
		IDirtyResource mockDirtyResource = new IDirtyResource() {

			public String getActualContents() {
				return testModel;
			}

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
			assertTrue(enabled);
		} catch (Throwable t) {
			assertFalse(enabled);
			if (!(Throwables.getRootCause(t) instanceof org.eclipse.core.internal.resources.ResourceException))
				Throwables.propagate(t);
		} finally {
			dirtyStateManager.discardDirtyState(mockDirtyResource);
		}
	}

	protected void assertExportedObject(Resource resource, String name) {
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(resource);
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(resource.getURI());
		assertNotNull(resourceDescription);
		QualifiedName qname = QualifiedName.create(name);
		assertFalse(isEmpty(resourceDescription.getExportedObjects(EcorePackage.Literals.EOBJECT, qname, false)));
	}

	protected void assertLiveModelScopeExternalFile(boolean enabled) throws CoreException, InvocationTargetException,
			InterruptedException {
		String pathName = "test/test." + fileExt.getPrimaryFileExtension();
		String pathName2 = "test/test2." + fileExt.getPrimaryFileExtension();
		String model = "stuff A refs B";
		createFile(pathName, model);
		createFile(pathName2, "stuff B");
		waitForAutoBuild();

		final URI resourceURI = URI.createPlatformResourceURI(pathName, true);
		Resource resource = resourceSet.getResource(resourceURI, true);
		assertExportedObject(resource, "A");

		Stuff elementA = ((File) resource.getContents().get(0)).getStuff().get(0);
		Stuff elementB = elementA.getRefs();
		assertFalse(elementB.eIsProxy());

		elementA.setName("C");
		elementB.setName("D");

		if (enabled) {
			assertExportedObject(elementA.eResource(), "C");
			assertExportedObject(elementB.eResource(), "D");
		} else {
			assertExportedObject(elementA.eResource(), "A");
			assertExportedObject(elementB.eResource(), "B");
		}
	}

	protected void assertLiveModelScopeLocal(boolean enabled) throws IOException {
		final URI resourceURI = URI.createPlatformResourceURI("test/test." + fileExt.getPrimaryFileExtension(), true);
		Resource resource = resourceSet.createResource(resourceURI);
		resource.load(new StringInputStream("stuff foo"), null);
		Stuff stuffFoo = ((File) resource.getContents().get(0)).getStuff().get(0);
		if (enabled) {
			assertExportedObject(resource, "foo");
			stuffFoo.setName("bar");
			assertExportedObject(resource, "bar");
		} else {
			IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(resource);
			IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(resource.getURI());
			assertNull(resourceDescription);
		}
	}

	@Before
	public void setUp() throws Exception {
		Activator.getInstance().getInjector(Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_TESTLANGUAGE).injectMembers(this);
		IProject project = createProject("test");
		addNature(project, XtextProjectHelper.NATURE_ID);
		resourceSet = createResourceSet(workspace.getRoot().getProject("test"));
	}

	protected abstract ResourceSet createResourceSet(IProject project);

	@After
	public void tearDown() throws Exception {
		cleanWorkspace();
	}

}
