/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.builder.TestedWorkspaceWithJDT;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageInjectorProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.io.ByteStreams;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(BuilderTestLanguageInjectorProvider.class)
public class EclipseResourceFileSystemAccess2Test extends Assert {
	
	@Inject
	@Rule
	public TestedWorkspaceWithJDT workspace;
	
	@Inject
	private EclipseResourceFileSystemAccess2 fsa;
	
	private IProject project;

	@Before
	public void setUp () throws Exception {
		project = workspace.createProject();
		fsa.setProject(project);
		fsa.setOutputPath("src-gen");
		fsa.getOutputConfigurations().get(IFileSystemAccess.DEFAULT_OUTPUT).setCreateOutputDirectory(true);
		fsa.setMonitor(new NullProgressMonitor());
	}

	@Test
	public void testWriteReadFiles() throws Exception {
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

	@Test
	public void textIsFile() throws Exception {
		assertFalse(fsa.isFile("tmp/X", IFileSystemAccess.DEFAULT_OUTPUT));
		fsa.generateFile("tmp/X", "XX");
		assertTrue(fsa.isFile("tmp/X", IFileSystemAccess.DEFAULT_OUTPUT));
	}
	
	@Test
	public void testMarkNotSupported() throws Exception {
		fsa.generateFile("tmp/bar", new StringInputStream("you should never see this"));
		InputStream input = new StringInputStream("foo") {
			@Override
			public boolean markSupported() {
				return false;
			}
			@Override
			public synchronized void reset() {
				throw new RuntimeIOException("mark/reset not supported");
			}
		};
		fsa.generateFile("tmp/bar", input);
		IFolder dir = project.getFolder("src-gen/tmp");
		assertTrue(dir.exists());
		IFile file = dir.getFile("bar");
		assertTrue(file.exists());
		assertEquals("foo", fsa.readTextFile("tmp/bar"));
	}
	
}
