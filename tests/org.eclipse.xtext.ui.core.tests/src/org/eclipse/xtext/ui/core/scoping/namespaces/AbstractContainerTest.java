/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit.util.URIBasedTestResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractContainerTest extends TestCase implements IResourceDescriptions{

	protected IProject project1;
	protected IProject project2;
	protected Map<URI, IResourceDescription> uriToResourceDescription;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertEquals(0, root().getProjects().length);
		project1 = createProject("someProject1");
		project2 = createProject("someProject2");
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
	
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return uriToResourceDescription.values();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return uriToResourceDescription.get(uri);
	}

	public void addListener(Listener listener) {
		// ignore
	}

	public void removeListener(Listener listener) {
		// ignore
	}
}
