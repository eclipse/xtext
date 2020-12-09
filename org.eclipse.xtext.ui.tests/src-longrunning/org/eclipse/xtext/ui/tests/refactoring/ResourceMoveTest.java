/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.refactoring;

import java.util.Arrays;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ltk.core.refactoring.resource.MoveResourcesDescriptor;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testlanguages.fileAware.ui.tests.FileAwareTestLanguageUiInjectorProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;

/**
 * @author koehnlein - Initial contribution and API
 */
@InjectWith(FileAwareTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class ResourceMoveTest extends AbstractResourceRelocationTest {
	@Test
	public void testMoveFile() throws Exception {
		String model1 =
				"package foo.bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		IFile x = file("foo/bar/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref bar.X\n" +
				"}\n";
		file("foo/Y.fileawaretestlanguage", model2);
		performMove(folder("foo/baz"), x);
		Assert.assertFalse(x.exists());
		String expectation1 =
				"package foo.baz\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		assertFileContents("foo/baz/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref baz.X\n" +
				"}\n";
		assertFileContents("foo/Y.fileawaretestlanguage", expectation2);
	}

	@Test
	public void testMoveFile_2() throws Exception {
		String model1 =
				"package foo.bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		file("foo/bar/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref bar.X\n" +
				"}\n";
		IFile y = file("foo/Y.fileawaretestlanguage", model2);
		performMove(folder("foo/baz"), y);
		Assert.assertFalse(y.exists());
		String expectation1 =
				"package foo.bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		assertFileContents("foo/bar/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package foo.baz\n" +
				"element Y {\n" +
				"	ref foo.bar.X\n" +
				"}\n";
		assertFileContents("foo/baz/Y.fileawaretestlanguage", expectation2);
	}

	@Test
	public void testMoveFiles() throws Exception {
		String model1 =
				"package foo.bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		IFile x = file("foo/bar/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref bar.X\n" +
				"}\n";
		IFile y = file("foo/Y.fileawaretestlanguage", model2);
		performMove(folder("foo/baz"), x, y);
		Assert.assertFalse(y.exists());
		String expectation1 =
				"package foo.baz\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		assertFileContents("foo/baz/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package foo.baz\n" +
				"element Y {\n" +
				"	ref X\n" +
				"}\n";
		assertFileContents("foo/baz/Y.fileawaretestlanguage", expectation2);
	}

	@Test
	public void testMoveDirectory() throws Exception {
		String model1 =
				"package foo.bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		IFile x = file("foo/bar/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref bar.X\n" +
				"}\n";
		file("foo/Y.fileawaretestlanguage", model2);
		performMove(folder("foo/baz"), x.getParent());
		Assert.assertFalse(x.exists());
		String expectation1 =
				"package foo.baz.bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		assertFileContents("foo/baz/bar/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref baz.bar.X\n" +
				"}\n";
		assertFileContents("foo/Y.fileawaretestlanguage", expectation2);
	}

	@Test
	@Ignore
	public void testMoveDirectoryToRoot() throws Exception {
		String model1 =
				"package foo.bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		IFile x = file("foo/bar/X.fileawaretestlanguage", model1);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref bar.X\n" +
				"}\n";
		file("foo/Y.fileawaretestlanguage", model2);
		performMove(project, x.getParent());
		Assert.assertFalse(x.exists());
		String expectation1 =
				"package bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		assertFileContents("bar/X.fileawaretestlanguage", expectation1);
		String expectation2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref bar.X\n" +
				"}\n";
		assertFileContents("foo/Y.fileawaretestlanguage", expectation2);
	}

	protected void performMove(IContainer theDestination, IResource... theResources) throws Exception {
		MoveResourcesDescriptor moveResourcesDescriptor = new MoveResourcesDescriptor();
		moveResourcesDescriptor
				.setResourcePathsToMove(Lists.transform(Arrays.asList(theResources), IResource::getFullPath).toArray(new IPath[0]));
		moveResourcesDescriptor.setDestinationPath(theDestination.getFullPath());
		performRefactoring(moveResourcesDescriptor);
	}
}
