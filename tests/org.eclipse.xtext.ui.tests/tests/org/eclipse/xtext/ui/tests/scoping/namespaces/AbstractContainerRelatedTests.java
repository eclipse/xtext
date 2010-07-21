/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit.util.URIBasedTestResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.XtextProjectHelper;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContainerRelatedTests extends TestCase implements IResourceDescriptions {

	protected IProject project1;
	protected IProject project2;
	protected Map<URI, IResourceDescription> uriToResourceDescription;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		cleanWorkspace();
		waitForAutoBuild();
		assertEquals(0, root().getProjects().length);
		project1 = createProject("someProject1");
		project2 = createProject("someProject2");
		addProjectNature(project1, XtextProjectHelper.NATURE_ID);
		addProjectNature(project2, XtextProjectHelper.NATURE_ID);
		uriToResourceDescription = Maps.newHashMap();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		cleanWorkspace();
		waitForAutoBuild();
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
	
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return uriToResourceDescription.values();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return uriToResourceDescription.get(uri);
	}

}
