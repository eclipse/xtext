/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.util.URIBasedTestResourceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContainerRelatedTests extends Assert implements IResourceDescriptions {

	protected IProject project1;
	protected IProject project2;
	protected Map<URI, IResourceDescription> uriToResourceDescription;
	protected ISelectable selectableDelegate;
	
	@Before
	public void setUp() throws Exception {
		cleanWorkspace();
		waitForBuild();
		assertEquals(0, root().getProjects().length);
		project1 = createProject("someProject1");
		project2 = createProject("someProject2");
		IResourcesSetupUtil.addNature(project1, XtextProjectHelper.NATURE_ID);
		IResourcesSetupUtil.addNature(project2, XtextProjectHelper.NATURE_ID);
		uriToResourceDescription = Maps.newHashMap();
		selectableDelegate = new AbstractCompoundSelectable() {
			@Override
			protected Iterable<IResourceDescription> getSelectables() {
				return getAllResourceDescriptions();
			}
		};
	}
	
	@After
	public void tearDown() throws Exception {
		cleanWorkspace();
		waitForBuild();
		assertEquals(0, root().getProjects().length);
	}
	
	protected URI createFileAndRegisterResource(IProject project, String name) throws CoreException, InvocationTargetException, InterruptedException {
		IFile file = createFile(project.getFullPath().append(name + ".name"), name + "Content");
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		uriToResourceDescription.put(uri, new URIBasedTestResourceDescription(uri));
		return uri;
	}
	
	protected IFile getFile(IProject project, String name) {
		IPath path = project.getFullPath().append(name + ".name");
		IFile result = IResourcesSetupUtil.root().getFile(path);
		return result;
	}
	
	@Override
	public boolean isEmpty() {
		return uriToResourceDescription.isEmpty();
	}
	
	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return uriToResourceDescription.values();
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		return uriToResourceDescription.get(uri);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return selectableDelegate.getExportedObjects();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return selectableDelegate.getExportedObjects(type, name, ignoreCase);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return selectableDelegate.getExportedObjectsByObject(object);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return selectableDelegate.getExportedObjectsByType(type);
	}
	
}
