/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.internal.core.JarEntryFile;
import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.NonJavaResource;
import org.eclipse.xtext.junit4.ui.AbstractWorkbenchTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.TextFile;
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.tests.Activator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaClassPathResourceForIEditorInputFactoryTest extends AbstractWorkbenchTest {

	private IResourceForEditorInputFactory factory;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		factory = getInjector().getInstance(IResourceForEditorInputFactory.class);
	}
	
	protected Injector getInjector() {
		return Activator.getInstance().getInjector(Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_TESTLANGUAGE);
	}
	
	@Before
	@After
	public void cleanWorkspace() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}
	
	@Test public void testBug463258_01() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/A.testlanguage", "//empty")), true, monitor());
		addJarToClasspath(project, file);
		
		IPackageFragmentRoot root = project.getPackageFragmentRoot(file);
		IPackageFragment foo = root.getPackageFragment("foo");
		JarEntryFile fileInJar = new JarEntryFile("A.testlanguage");
		fileInJar.setParent(foo);
		
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(fileInJar);
		Resource resource = factory.createResource(editorInput);
		assertNotNull(resource);
		resource.load(null);
	}
	
	@Test public void testBug463258_02() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("do/not", "care")), true, monitor());
		addJarToClasspath(project, file);
		
		IPackageFragmentRoot root = project.getPackageFragmentRoot(file);
		IPackageFragment foo = root.getPackageFragment("unknown");
		JarEntryFile fileInJar = new JarEntryFile("doesNotExist.testlanguage");
		fileInJar.setParent(foo);
		
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(fileInJar);
		Resource resource = factory.createResource(editorInput);
		assertNotNull(resource);
		try {
			resource.load(null);
		} catch(IOException e) {
			// expected
		}
	}
	
	@Test public void testBug463258_03a() throws Exception {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.testlanguage", "//empty")), true, monitor());
		addJarToClasspath(project, file);
		
		IPackageFragmentRoot root = project.getPackageFragmentRoot(file);
		IPackageFragment foo = root.getPackageFragment("foo");
		JarEntryFile fileInJar = new JarEntryFile("bar.testlanguage");
		fileInJar.setParent(foo);
		
		File jarFile = file.getRawLocation().toFile();
		assertTrue("exists", jarFile.exists());
		assertTrue("delete", jarFile.delete());
		
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(fileInJar);
		Resource resource = factory.createResource(editorInput);
		assertNotNull(resource);
		try {
			resource.load(null);
		} catch(IOException e) {
			// expected
		}
	}
	
	@Test(expected=CoreException.class) public void testBug463258_03b() throws Throwable {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.testlanguage", "//empty")), true, monitor());
		
		IPackageFragmentRoot root = new JarPackageFragmentRoot(file, (JavaProject) project) {};
		IPackageFragment foo = root.getPackageFragment("foo");
		JarEntryFile fileInJar = new JarEntryFile("bar.testlanguage");
		fileInJar.setParent(foo);
		
		File jarFile = file.getLocation().toFile();
		assertTrue("exists", jarFile.exists());
		assertTrue("delete", jarFile.delete());
		
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(fileInJar);
		try {
			factory.createResource(editorInput);
		} catch(WrappedException e) {
			throw e.getCause();
		}
	}
	
	@Test(expected=CoreException.class) public void testBug463258_03c() throws Throwable {
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/bar.testlanguage", "//empty")), true, monitor());
		addJarToClasspath(project, file);
		
		IPackageFragmentRoot root = new JarPackageFragmentRoot(file, (JavaProject) project) {};
		IPackageFragment foo = root.getPackageFragment("foo");
		JarEntryFile fileInJar = new JarEntryFile("bar.testlanguage");
		fileInJar.setParent(foo);
		
		File jarFile = file.getLocation().toFile();
		assertTrue("exists", jarFile.exists());
		assertTrue("delete", jarFile.delete());
		// simulate an automated refresh
		file.refreshLocal(IResource.DEPTH_ONE, null);
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(fileInJar);
		try {
			factory.createResource(editorInput);
		} catch(WrappedException e) {
			throw e.getCause();
		}
	}
	
	@Test(expected=CoreException.class) public void testBug463258_04() throws Throwable {
		IFolder externalFolder = createExternalFolder("externalFolder");
		IJavaProject project = createJavaProject("foo");
		
		addExternalFolderToClasspath(project, externalFolder);
		
		IPackageFragmentRoot root = project.getPackageFragmentRoot(externalFolder);
		IPackageFragment foo = root.getPackageFragment("foo");
		NonJavaResource fileInFolder = new NonJavaResource(foo, externalFolder.getFile("foo/doesNotExist.testlanguage"));
		
		externalFolder.delete(true, null);
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(fileInFolder);
		try {
			factory.createResource(editorInput);
		} catch(WrappedException e) {
			throw e.getCause();
		}
	}
	
	@Test(expected=CoreException.class) public void testBug463258_05() throws Throwable {
		IJavaProject project = createJavaProject("foo");
		IPackageFragmentRoot root = project.getPackageFragmentRoot("does/not/exist.jar");
		IPackageFragment foo = root.getPackageFragment("foo");
		final JarEntryFile fileInJar = new JarEntryFile("bar.testlanguage");
		fileInJar.setParent(foo);
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(fileInJar);
		try {
			factory.createResource(editorInput);
		} catch(WrappedException e) {
			throw e.getCause();
		}
	}

}
