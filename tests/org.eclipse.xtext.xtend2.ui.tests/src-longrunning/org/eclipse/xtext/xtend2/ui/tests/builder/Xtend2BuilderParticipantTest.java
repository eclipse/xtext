/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.builder;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;
import static org.eclipse.xtext.util.Strings.*;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2BuilderParticipantTest extends AbstractXtend2UITestCase {

	@Inject
	private IWorkspace workspace;
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		IResourcesSetupUtil.cleanWorkspace();
	}
	
	public void testBuild() throws Exception {
		IJavaProject javaProject = createJavaProject("test");
		IProject project = javaProject.getProject();
		addNature(project, XtextProjectHelper.NATURE_ID);
		IFile sourceFile = createFile("/test/src/test/Test." + getFileExtension(), "package test\nclass Test {}");
		sourceFile.setCharset(getNonDefaultEncoding(), null);
		waitForAutoBuild();

		IFile targetFile = project.getFile("/xtend2-gen/test/Test.java");
		assertTrue(targetFile.exists());
		assertFalse(isEmpty(targetFile));
		assertEquals(getNonDefaultEncoding(), targetFile.getCharset());
		
		IFile classFile = project.getFile("/bin/test/Test.class");
		assertTrue(classFile.exists());
		assertFalse(isEmpty(classFile));
		
		sourceFile.delete(true, null);
		waitForAutoBuild();

		assertFalse(targetFile.exists());
		assertFalse(targetFile.getParent().exists());
		assertFalse(classFile.exists());
	}
	
	protected boolean isEmpty(IFile file) throws CoreException, IOException {
		InputStream contents = null;
		try {
			contents = file.getContents();
			return contents.read() == -1;
		} finally {
			if(contents != null)
				contents.close();
		}
	}

	protected String getNonDefaultEncoding() throws CoreException {
		String defaultCharset = workspace.getRoot().getDefaultCharset();
		if (equal(defaultCharset,"UTF-8"))
			return "ISO-8859-1";
		else
			return "UTF-8";
	}
}
