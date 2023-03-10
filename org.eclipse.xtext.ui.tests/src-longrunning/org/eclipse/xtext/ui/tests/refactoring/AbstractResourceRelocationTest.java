/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testlanguages.fileAware.ui.tests.FileAwareTestLanguageUiInjectorProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author koehnlein - Initial contribution and API
 */
@InjectWith(FileAwareTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public abstract class AbstractResourceRelocationTest {
	protected IProject project;

	@Before
	public void setup() throws Exception {
		IResourcesSetupUtil.setAutobuild(false);
		project = IResourcesSetupUtil.createProject("test");
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
		IResourcesSetupUtil.addBuilder(project, XtextProjectHelper.BUILDER_ID);
	}

	@After
	public void teardown() throws Exception {
		project.delete(true, true, new NullProgressMonitor());
		IResourcesSetupUtil.setAutobuild(true);
	}

	protected IFile file(String name, CharSequence content) throws Exception {
		return IResourcesSetupUtil.createFile(project.getName() + "/" + name, content.toString());
	}

	protected IFolder folder(String name) throws Exception {
		return IResourcesSetupUtil.createFolder(project.getName() + "/" + name);
	}

	protected void assertFileContents(String filePath, String expected) throws Exception {
		IFile file = (IFile) project.findMember(filePath);
		Assert.assertTrue(file.exists());
		String text = IResourcesSetupUtil.fileToString(file);
		Assert.assertEquals(expected, text);
	}

	protected void performRefactoring(RefactoringDescriptor descriptor) throws Exception {
		performRefactoring(descriptor, new NullProgressMonitor());
	}

	protected void performRefactoring(RefactoringDescriptor descriptor, IProgressMonitor monitor) throws Exception {
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		RefactoringStatus status = new RefactoringStatus();
		Refactoring refactoring = descriptor.createRefactoring(status);
		refactoring.checkAllConditions(monitor);
		Assert.assertTrue(status.isOK());
		Change change = refactoring.createChange(monitor);
		change.perform(monitor);
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
	}
}
