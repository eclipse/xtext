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

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.internal.core.JarEntryFile;
import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.NonJavaResource;
import org.eclipse.xtext.junit4.Flaky;
import org.eclipse.xtext.junit4.logging.LoggingTester;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.TextFile;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.io.ByteStreams;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Storage2UriMapperJdtImplTest extends Assert {
	
	@Rule
	public Flaky.Rule flakyRule = new Flaky.Rule();
	
	@Before
	@After
	public void cleanWorkspace() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}
	
	@Flaky
	@Test public void testBug463258_01() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.notindexed", "//empty")), true, monitor());
		addJarToClasspath(project, file);
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		IPackageFragmentRoot root = project.getPackageFragmentRoot(file);
		IPackageFragment foo = root.getPackageFragment("foo");
		JarEntryFile fileInJar = new JarEntryFile("bar.notindexed");
		fileInJar.setParent(foo);
		
		URI uri = impl.getUri(fileInJar);
		assertEquals("archive:platform:/resource/foo/foo.jar!/foo/bar.notindexed", uri.toString());
		
		InputStream stream = new ResourceSetImpl().getURIConverter().createInputStream(uri);
		byte[] bytes = ByteStreams.toByteArray(stream);
		assertEquals("//empty", new String(bytes));
	}
	
	@Flaky
	@Test public void testBug463258_02() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("do/not", "care")), true, monitor());
		addJarToClasspath(project, file);
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		IPackageFragmentRoot root = project.getPackageFragmentRoot(file);
		IPackageFragment foo = root.getPackageFragment("unknown");
		JarEntryFile fileInJar = new JarEntryFile("doesNotExist.notindexed");
		fileInJar.setParent(foo);
		
		URI uri = impl.getUri(fileInJar);
		assertEquals("archive:platform:/resource/foo/foo.jar!/unknown/doesNotExist.notindexed", uri.toString());
	}
	
	@Flaky
	@Test public void testBug463258_03a() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.notindexed", "//empty")), true, monitor());
		addJarToClasspath(project, file);
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		IPackageFragmentRoot root = project.getPackageFragmentRoot(file);
		IPackageFragment foo = root.getPackageFragment("foo");
		JarEntryFile fileInJar = new JarEntryFile("bar.notindexed");
		fileInJar.setParent(foo);
		
		File jarFile = file.getRawLocation().toFile();
		assertTrue("exists", jarFile.exists());
		assertTrue("delete", jarFile.delete());
		
		URI uri = impl.getUri(fileInJar);
		assertEquals("archive:platform:/resource/foo/foo.jar!/foo/bar.notindexed", uri.toString());
	}
	
	@Test public void testBug463258_03b() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.notindexed", "//empty")), true, monitor());
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		
		IPackageFragmentRoot root = new JarPackageFragmentRoot(file, (JavaProject) project) {};
		IPackageFragment foo = root.getPackageFragment("foo");
		JarEntryFile fileInJar = new JarEntryFile("bar.notindexed");
		fileInJar.setParent(foo);
		
		File jarFile = file.getLocation().toFile();
		assertTrue("exists", jarFile.exists());
		assertTrue("delete", jarFile.delete());
		
		URI uri = impl.getUri(fileInJar);
		assertNull(uri);
	}
	
	@Test public void testBug463258_03c() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.notindexed", "//empty")), true, monitor());
		addJarToClasspath(project, file);
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		
		IPackageFragmentRoot root = new JarPackageFragmentRoot(file, (JavaProject) project) {};
		IPackageFragment foo = root.getPackageFragment("foo");
		JarEntryFile fileInJar = new JarEntryFile("bar.notindexed");
		fileInJar.setParent(foo);
		
		File jarFile = file.getLocation().toFile();
		assertTrue("exists", jarFile.exists());
		assertTrue("delete", jarFile.delete());
		// simulate an automated refresh
		file.refreshLocal(IResource.DEPTH_ONE, null);
		URI uri = impl.getUri(fileInJar);
		assertNull(uri);
	}
	
	@Flaky
	@Test public void testBug463258_04() throws Exception {
		IFolder externalFolder = createExternalFolder("externalFolder");
		IJavaProject project = createJavaProject("foo");
		
		addExternalFolderToClasspath(project, externalFolder);
		
		Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		IPackageFragmentRoot root = project.getPackageFragmentRoot(externalFolder);
		IPackageFragment foo = root.getPackageFragment("foo");
		NonJavaResource fileInFolder = new NonJavaResource(foo, externalFolder.getFile("foo/does.notexist"));
		
		externalFolder.delete(true, null);
		URI uri = impl.getUri(fileInFolder);
		assertNull(uri);
	}
	
	@Test public void testBug463258_05() throws Exception {
		IJavaProject project = createJavaProject("foo");
		final Storage2UriMapperJavaImpl impl = getStorage2UriMapper();
		IPackageFragmentRoot root = project.getPackageFragmentRoot("does/not/exist.jar");
		IPackageFragment foo = root.getPackageFragment("foo");
		final JarEntryFile fileInJar = new JarEntryFile("bar.notindexed");
		fileInJar.setParent(foo);
		LoggingTester.captureLogging(Level.ERROR, Storage2UriMapperJavaImpl.class, new Runnable() {
			@Override
			public void run() {
				URI uri = impl.getUri(fileInJar);
				assertNull(uri);
			}
		}).assertNoLogEntries();
	}
	
	@Flaky
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
	
	@Flaky
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
	
	@Flaky
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
		assertEquals(rootData.toString(), 1, rootData.size());
		assertEquals("platform:/resource/.org.eclipse.jdt.core.external.folders/externalFolder/a.indexed", rootData.keySet().iterator().next().toString());
		IFile file3 = externalFolder.getFile("c.indexed");
		file3.create(new StringInputStream("content"), true, monitor());
		rootData = impl.getAllEntries(root);
		assertEquals(rootData.toString(), 2, rootData.size());
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
