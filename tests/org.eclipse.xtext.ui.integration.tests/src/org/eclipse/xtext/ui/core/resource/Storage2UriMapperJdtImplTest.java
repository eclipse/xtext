/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.resource;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.junit.util.JavaProjectSetupUtil.TextFile;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Storage2UriMapperJdtImplTest extends TestCase {
	
	public void testResourceInJar() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.txt", "...")), true, monitor());
		addJarToClasspath(project, file);
		
		Storage2UriMapperJavaImpl impl = new Storage2UriMapperJavaImpl() {
			@Override
			public boolean isValidUri(URI uri, IStorage storage) {
				return uri!=null;
			}
		};
		URI uri = URI.createURI("archive:platform:/resource/foo/foo.jar!/foo/bar.txt");
		Iterable<IStorage> storages = impl.getStorages(uri);
		Iterator<IStorage> iterator = storages.iterator();
		IStorage next = iterator.next();
		assertFalse(iterator.hasNext());
		assertEquals(uri, impl.getUri(next));
	}
	
	public void testResourceInExternalFolder() throws Exception {
		IFolder externalFolder = createExternalFolder("externalFolder");
		IJavaProject project = createJavaProject("foo");
		IFile file = externalFolder.getFile("someFile.ext");
		file.create(new StringInputStream("content"), true, monitor());
		addExternalFolderToClasspath(project, externalFolder);
		
		Storage2UriMapperJavaImpl impl = new Storage2UriMapperJavaImpl() {
			@Override
			public boolean isValidUri(URI uri, IStorage storage) {
				return uri!=null;
			}
		};
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Iterable<IStorage> storages = impl.getStorages(uri);
		Iterator<IStorage> iterator = storages.iterator();
		IStorage next = iterator.next();
		assertFalse(iterator.hasNext());
		assertEquals(uri, impl.getUri(next));
	}
}
