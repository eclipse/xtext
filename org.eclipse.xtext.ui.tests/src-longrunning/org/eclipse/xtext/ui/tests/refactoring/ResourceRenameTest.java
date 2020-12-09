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
import org.eclipse.core.resources.IResource;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceDescriptor;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testlanguages.fileAware.ui.tests.FileAwareTestLanguageUiInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author koehnlein - Initial contribution and API
 */
@InjectWith(FileAwareTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class ResourceRenameTest extends AbstractResourceRelocationTest {
	@Test
	public void testRenameDir() throws Exception {
		String model1 =
				"package foo.bar\n" +
				"element X {\n" +
				"\tref X\n" +
				"}\n";
		IFile x = file("foo/bar/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"\tref bar.X\n" +
				"}\n";
		file("foo/Y.fileawaretestlanguage", model2);
		performRename(x.getParent(), "baz");
		Assert.assertFalse(x.exists());
		String expectation1 =
				"package foo.baz\n" +
				"element X {\n" +
				"\tref X\n" +
				"}\n";
		assertFileContents("foo/baz/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package foo\n" +
				"element Y {\n" +
				"\tref baz.X\n" +
				"}\n";
		assertFileContents("foo/Y.fileawaretestlanguage", expectation2);
	}

	@Test
	public void testRenameDir_2() throws Exception {
		String model1 =
				"package foo\n" +
				"element X {\n" +
				"\tref X\n" +
				"}\n";
		file("foo/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo.bar\n" +
				"element Y {\n" +
				"\tref foo.X\n" +
				"}\n";
		IFile y = file("foo/bar/Y.fileawaretestlanguage", model2);
		performRename(y.getParent(), "baz");
		Assert.assertFalse(y.exists());
		String expectation1 =
				"package foo\n" +
				"element X {\n" +
				"\tref X\n" +
				"}\n";
		assertFileContents("foo/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package foo.baz\n" +
				"element Y {\n" +
				"\tref foo.X\n" +
				"}\n";
		assertFileContents("foo/baz/Y.fileawaretestlanguage", expectation2);
	}

	@Test
	public void testRenameCommonDir() throws Exception {
		String model1 =
				"package foo.bar\n" +
				"element X {\n" +
				"\tref X\n" +
				"}\n";
		IFile x = file("foo/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"\tref bar.X\n" +
				"}\n";
		IFile y = file("foo/Y.fileawaretestlanguage", model2);
		performRename(x.getParent(), "baz");
		Assert.assertFalse(x.exists());
		Assert.assertFalse(y.exists());
		String expectation1 =
				"package baz\n" +
				"element X {\n" +
				"\tref X\n" +
				"}\n";
		assertFileContents("baz/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package baz\n" +
				"element Y {\n" +
				"\tref X\n" +
				"}\n";
		assertFileContents("baz/Y.fileawaretestlanguage", expectation2);
	}

	@Test
	public void testRenameCommonDir_2() throws Exception {
		String model1 =
				"package foo.bar\n" +
				"element X {\n" +
				"\tref X\n" +
				"}\n";
		IFile x = file("foo/bar/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"\tref bar.X\n" +
				"}\n";
		IFile y = file("foo/Y.fileawaretestlanguage", model2);
		performRename(y.getParent(), "baz");
		Assert.assertFalse(x.exists());
		Assert.assertFalse(y.exists());
		String expectation1 =
				"package baz.bar\n" +
				"element X {\n" +
				"\tref X\n" +
				"}\n";
		assertFileContents("baz/bar/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package baz\n" +
				"element Y {\n" +
				"\tref bar.X\n" +
				"}\n";
		assertFileContents("baz/Y.fileawaretestlanguage", expectation2);
	}

	protected void performRename(IResource theResource, String theNewName) throws Exception {
		RenameResourceDescriptor renameResourceDescriptor = new RenameResourceDescriptor();
		renameResourceDescriptor.setResourcePath(theResource.getFullPath());
		renameResourceDescriptor.setNewName(theNewName);
		renameResourceDescriptor.setProject(project.getName());
		performRefactoring(renameResourceDescriptor);
	}
}
