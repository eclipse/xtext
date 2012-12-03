/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.resource;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.TextFile;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Storage2UriMapperJdtImplTest extends Assert {
	
	@Test public void testResourceInJar() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.indexed", "//empty"), new TextFile("foo/bar.notIndexed", "//empty")), true, monitor());
		addJarToClasspath(project, file);
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		
		IPackageFragmentRoot root = project.getPackageFragmentRoot(file);
		Map<URI, IStorage> rootData = impl.getAllEntries(root);
		assertEquals(1, rootData.size());
		assertEquals("archive:platform:/resource/foo/foo.jar!/foo/bar.indexed", rootData.keySet().iterator().next().toString());
		file.setContents(jarInputStream(new TextFile("foo/bar.notindexed", "//empty"), new TextFile("foo/bar.notIndexed", "//empty")), IResource.FORCE, monitor());
		rootData = impl.getAllEntries(root);
		assertTrue(rootData.isEmpty());
	}
	
	@Test public void testJaredBundle() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(
				new TextFile("foo/bar.indexed", "//empty"), 
				new TextFile("foo/bar.notIndexed", "//empty"),
				new TextFile("META-INF/MANIFEST.MF", "Manifest-Version: 1.0\nBundle-SymbolicName: hubba.bubba\n")
				), true, monitor());
		addJarToClasspath(project, file);
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		
		IPackageFragmentRoot root = project.getPackageFragmentRoot(file);
		Map<URI, IStorage> rootData = impl.getAllEntries(root);
		assertEquals(1, rootData.size());
		assertEquals("platform:/resource/hubba.bubba/foo/bar.indexed", rootData.keySet().iterator().next().toString());
		
		// let's change the bundle name
		file.setContents(jarInputStream(
				new TextFile("foo/bar.indexed", "//empty"), 
				new TextFile("foo/bar.notIndexed", "//empty"),
				new TextFile("META-INF/MANIFEST.MF", "Manifest-Version: 1.0\nBundle-SymbolicName: other.bundle.name;singleton:=true\n")
				), IResource.FORCE, monitor());
		rootData = impl.getAllEntries(root);
		assertEquals(1, rootData.size());
		assertEquals("platform:/resource/other.bundle.name/foo/bar.indexed", rootData.keySet().iterator().next().toString());
	}
	
	@Test public void testResourceInExternalFolder() throws Exception {
		IFolder externalFolder = createExternalFolder("externalFolder");
		IJavaProject project = createJavaProject("foo");
		
		IFile file = externalFolder.getFile("a.indexed");
		file.create(new StringInputStream("content"), true, monitor());
		IFile file2 = externalFolder.getFile("b.nonindexed");
		file2.create(new StringInputStream("content"), true, monitor());
		addExternalFolderToClasspath(project, externalFolder);
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		
		IPackageFragmentRoot root = project.getPackageFragmentRoot(externalFolder);
		Map<URI, IStorage> rootData = impl.getAllEntries(root);
		assertEquals(1, rootData.size());
		assertEquals("platform:/resource/.org.eclipse.jdt.core.external.folders/externalFolder/a.indexed", rootData.keySet().iterator().next().toString());
		IFile file3 = externalFolder.getFile("c.indexed");
		file3.create(new StringInputStream("content"), true, monitor());
		rootData = impl.getAllEntries(root);
		assertEquals(2, rootData.size());
	}
	
	protected Storage2UriMapperJavaImpl getStorage2UriMapper() {
		Storage2UriMapperJavaImpl impl = new Storage2UriMapperJavaImpl();
		impl.setUriValidator(new UriValidator() {
			@Override
			public boolean isPossiblyManaged(IStorage storage) {
				return "indexed".equals(storage.getFullPath().getFileExtension());
			}
			@Override
			public boolean isValid(URI uri, IStorage storage) {
				return "indexed".equals(storage.getFullPath().getFileExtension());
			}
		});
		impl.setLocator(new JarEntryLocator());
		return impl;
	}
}
