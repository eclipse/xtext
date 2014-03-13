/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.tests.Activator;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.ByteStreams;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EclipseResourceFileSystemAccess2Test extends Assert {

	@After
	public void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	@Test
	public void testWriteReadFiles() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("test");
		Injector injector = Activator.getInstance().getInjector(
				Activator.ORG_ECLIPSE_XTEXT_BUILDER_TESTS_BUILDERTESTLANGUAGE);
		EclipseResourceFileSystemAccess2 fsa = injector.getInstance(EclipseResourceFileSystemAccess2.class);
		fsa.setProject(project);
		fsa.setOutputPath("src-gen");
		fsa.getOutputConfigurations().get(IFileSystemAccess.DEFAULT_OUTPUT).setCreateOutputDirectory(true);
		fsa.setMonitor(new NullProgressMonitor());

		fsa.generateFile("tmp/X", "XX");
		IFolder dir = project.getFolder("src-gen/tmp");
		assertTrue(dir.exists());
		IFile file = dir.getFile("X");
		assertTrue(file.exists());
		assertEquals("XX", fsa.readTextFile("tmp/X"));

		fsa.generateFile("tmp/Y", "\1\2\3");
		InputStream stream = fsa.readBinaryFile("tmp/Y");
		try {
			assertEquals("\1\2\3", new String(ByteStreams.toByteArray(stream)));
		} finally {
			stream.close();
		}
	}
}
