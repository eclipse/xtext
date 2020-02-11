/*******************************************************************************
 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.TestedWorkspaceWithJDT;
import org.eclipse.xtext.util.IAcceptor;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@RunWith(XtextRunner.class)
@InjectWith(BuilderTestLanguageInjectorProvider.class)
public class EclipseResourceFileSystemAccessTest extends Assert {

	@Inject
	@Rule
	public TestedWorkspaceWithJDT workspace;

	@Test public void testDirsAreCreated() throws Exception {
		IProject project = workspace.createProject("test");
		EclipseResourceFileSystemAccess fileSystemAccess = new EclipseResourceFileSystemAccess();
		fileSystemAccess.setRoot(IResourcesSetupUtil.root());
		fileSystemAccess.setOutputPath("test");
		final List<String> newFiles = newArrayList();
		fileSystemAccess.setNewFileAcceptor(new IAcceptor<String>() {
			@Override
			public void accept(String t) {
				newFiles.add(t);
			}
		});
		fileSystemAccess.generateFile("tmp/X", "XX");
		IFolder dir = project.getFolder("tmp");
		assertTrue(dir.exists());
		IFile file = dir.getFile("X");
		assertTrue(file.exists());
		assertEquals(1, newFiles.size());
		assertTrue(newFiles.contains("/test/tmp/X"));
	}
}
