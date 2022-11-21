/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageInjectorProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.util.TestedWorkspaceWithJDT;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Strings;
import com.google.inject.Inject;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(BuilderTestLanguageInjectorProvider.class)
public class EclipseResourceFileSystemAccess2PerformanceTest extends Assert {
	
	@Inject
	@Rule
	public TestedWorkspaceWithJDT workspace;
	
	@Inject
	private EclipseResourceFileSystemAccess2ForTest fsa;
	
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
	public void testHasContentsChanged() throws Exception {
		String content = Strings.repeat("X", 40000);
		fsa.generateFile("tmp/X", content);
		IFolder dir = project.getFolder("src-gen/tmp");
		assertTrue(dir.exists());
		IFile file = dir.getFile("X");
		assertTrue(file.exists());
		assertEquals(content, fsa.readTextFile("tmp/X"));
		for (int i = 0; i < 20000; i++) {
			StringInputStream stream = new StringInputStream(content);
			assertFalse(fsa.hasContentsChanged(file, stream));
		}
	}

}
