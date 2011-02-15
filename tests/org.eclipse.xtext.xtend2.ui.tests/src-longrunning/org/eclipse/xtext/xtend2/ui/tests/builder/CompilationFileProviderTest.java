/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.builder;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;
import org.eclipse.xtext.xtend2.ui.builder.CompilationFileProvider;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CompilationFileProviderTest extends AbstractXtend2UITestCase {

	@Inject
	protected CompilationFileProvider compilationFileProvider;

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		IResourcesSetupUtil.cleanWorkspace();
	}
	
	public void testTargetFolderName() {
		assertEquals("xtend2-gen", compilationFileProvider.getTargetFolderName());
	}
	
	public void testGetTargetFolder() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("test");
		try {
			compilationFileProvider.getTargetFolder(project, null);
			fail("Non-Java project not detected");
		} catch (IllegalStateException e) {
			assertTrue(e.getMessage().contains("Java project"));
		}
		IJavaProject javaProject = makeJavaProject(project);
		IFolder targetFolder = compilationFileProvider.getTargetFolder(project, null);
		assertTrue(targetFolder.exists());
		assertEquals(compilationFileProvider.getTargetFolderName(), targetFolder.getName());
		IPackageFragmentRoot packageFragmentRoot = javaProject.getPackageFragmentRoot(targetFolder);
		assertNotNull(packageFragmentRoot);
		assertEquals(targetFolder.getFullPath(), packageFragmentRoot.getPath());
	}

	public void testGetSourceAndTargetFile() throws CoreException, InvocationTargetException, InterruptedException {
		IJavaProject javaProject = createJavaProject("test");
		IProject project = javaProject.getProject();
		String sourceFileName = "Test";
		String sourceFilePath = "/" + project.getName() + "/src/" + sourceFileName + "." + getFileExtension();
		URI sourceURI = URI.createPlatformResourceURI(sourceFilePath, true);
		IFile sourceFile = compilationFileProvider.getFile(sourceURI, project);
		assertEquals(sourceFilePath, sourceFile.getFullPath().toString());

		IFile targetFile = compilationFileProvider.getTargetFile(sourceURI, project, null);
		assertEquals("/" + project.getName() + "/" + compilationFileProvider.getTargetFolderName() + "/"
				+ sourceFileName + ".java", targetFile.getFullPath().toString());
	}
}
