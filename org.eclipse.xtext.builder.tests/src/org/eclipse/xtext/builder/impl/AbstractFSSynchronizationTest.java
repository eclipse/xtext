/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
public abstract class AbstractFSSynchronizationTest extends AbstractBuilderParticipantTest {
	private static String PROJECT_NAME = "myProject";

	private IProject project;

	@Before
	public void createJavaProject() throws Exception {
		project = createJavaProject(AbstractFSSynchronizationTest.PROJECT_NAME).getProject();
		addNature(project, XtextProjectHelper.NATURE_ID);
	}

	@After
	public void forgetProject() throws Exception {
		project = null;
	}

	@Test
	public void testUpdateFileContent() {
		testUpdateFileContent(project.getFolder("src-gen"));
	}

	@Test
	public void testUpdateFileContentWithProjectAsOutput() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testUpdateFileContent(project));
	}

	protected void testUpdateFileContent(IContainer output) {
		createJavaIoFile(output.getFile(new Path("Foo.txt")).getLocation(), "object Bar");
		createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
		build();
		Assert.assertEquals("object Foo", readFile(output.getFile(new Path("Foo.txt"))));
	}

	@Test
	public void testTouchFile() {
		testTouchFile(project.getFolder("src-gen"));
	}

	@Test
	public void testTouchFileWithProjectAsOutput() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testTouchFile(project));
	}

	protected void testTouchFile(IContainer output) {
		createJavaIoFile(output.getFile(new Path("Foo.txt")).getLocation(), "object Foo");
		createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
		build();
		Assert.assertEquals("object Foo", readFile(output.getFile(new Path("Foo.txt"))));
	}

	@Test
	public void testCreateFile() {
		testCreateFile(project.getFolder("src-gen"));
	}

	@Test
	public void testCreateFileWithProjectAsOutput() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testCreateFile(project));
	}

	protected void testCreateFile(IContainer output) {
		try {
			IFile file = createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
			build();
			Assert.assertEquals("object Foo", readFile(output.getFile(new Path("Foo.txt"))));
			File javaIoFile = output.getFile(new Path("Foo.txt")).getLocation().toFile();
			javaIoFile.delete();
			javaIoFile.getParentFile().delete();
			file.touch(monitor());
			build();
			Assert.assertEquals("object Foo", readFile(output.getFile(new Path("Foo.txt"))));
		} catch (CoreException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Test
	public void testDeleteTraceFile() {
		testDeleteTraceFile(project.getFolder("src-gen"));
	}

	@Test
	public void testDeleteTraceFileWithProjectAsOutput() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testDeleteTraceFile(project));
	}

	protected void testDeleteTraceFile(IContainer output) {
		File javaIoFile = createJavaIoFile(output.getFile(new Path(".Foo.txt._trace")).getLocation());
		createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
		build();
		Assert.assertFalse(javaIoFile.exists());
		Assert.assertFalse(output.getFile(new Path(".Foo.txt._trace")).exists());
	}

	@Test
	public void testCleanOutput_01() {
		withOutputConfiguration(it -> {
			it.setCanClearOutputDirectory(true);
			it.setCleanUpDerivedResources(false);
		}, () -> {
			File srcGenDirectory = createJavaIoFile(project.getFile("src-gen/Lalala.txt").getLocation()).getParentFile();
			Assert.assertFalse(srcGenDirectory.listFiles().length == 0);
			createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
			build();
			Assert.assertFalse(srcGenDirectory.listFiles().length == 0);
			cleanBuild();
			Assert.assertTrue(srcGenDirectory.listFiles().length == 0);
		});
	}

	@Test
	public void testCleanOutput_02() {
		withOutputConfiguration(it -> {
			it.setCanClearOutputDirectory(true);
			it.setCleanUpDerivedResources(false);
		}, () -> {
			File srcGenDirectory = project.getFolder("src-gen").getLocation().toFile();
			Assert.assertFalse(srcGenDirectory.exists());
			createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
			build();
			Assert.assertTrue(srcGenDirectory.exists());
			Assert.assertFalse(srcGenDirectory.listFiles().length == 0);
			createJavaIoFile(project.getFile("src-gen/Lalala.txt").getLocation());
			cleanBuild();
			Assert.assertTrue(srcGenDirectory.exists());
			Assert.assertTrue(srcGenDirectory.listFiles().length == 0);
		});
	}

	@Test
	public void testCleanProjectAsOutput() {
		withOutputConfiguration((OutputConfiguration it) -> {
			it.setOutputDirectory("./");
			it.setCanClearOutputDirectory(true);
			it.setCleanUpDerivedResources(false);
		}, () -> {
			File projectDirectory = project.getLocation().toFile();
			int initialSize = projectDirectory.listFiles().length;
			Assert.assertNotEquals(0, initialSize);
			createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
			build();
			int expectedSize = projectDirectory.listFiles().length;
			Assert.assertNotEquals(initialSize, expectedSize);
			cleanBuild();
			Assert.assertEquals(expectedSize, projectDirectory.listFiles().length);
		});
	}

	@Test
	public void testCleanUpDerivedResourcesWithCreateBefore() {
		testCleanUpDerivedResourcesWithCreateBefore(project.getFolder("src-gen"));
	}

	@Test
	public void testCleanUpDerivedResourcesWithCreateBetween() {
		testCleanUpDerivedResourcesWithCreateBetween(project.getFolder("src-gen"));
	}

	@Test
	public void testCleanUpDerivedResourcesWithUpdateDerived() {
		testCleanUpDerivedResourcesWithUpdateDerived(project.getFolder("src-gen"));
	}

	@Test
	public void testCleanUpDerivedResourcesWithDeleteDerived() {
		testCleanUpDerivedResourcesWithDeleteDerived(project.getFolder("src-gen"));
	}

	@Test
	public void testCleanUpProjectDerivedResourcesWithCreateBefore() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testCleanUpDerivedResourcesWithCreateBefore(project));
	}

	@Test
	public void testCleanUpProjectDerivedResourcesWithCreateBetween() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testCleanUpDerivedResourcesWithCreateBetween(project));
	}

	@Test
	public void testCleanUpProjectDerivedResourcesWithUpdateDerived() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testCleanUpDerivedResourcesWithUpdateDerived(project));
	}

	@Test
	public void testCleanUpProjectDerivedResourcesWithDeleteDerived() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testCleanUpDerivedResourcesWithDeleteDerived(project));
	}

	protected void testCleanUpDerivedResourcesWithCreateBefore(IContainer output) {
		File ouputDirectory = createJavaIoFile(output.getFile(new Path("Lalala.txt")).getLocation()).getParentFile();
		int expectedSize = ouputDirectory.list().length;
		createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
		build();
		Assert.assertNotEquals(expectedSize, ouputDirectory.list().length);
		disableAutobuild(() -> {
			cleanBuild();
			Assert.assertEquals(expectedSize, ouputDirectory.list().length);
			Assert.assertTrue(ArrayExtensions.contains(ouputDirectory.list(), "Lalala.txt"));
		});
	}

	protected void testCleanUpDerivedResourcesWithCreateBetween(IContainer output) {
		File outputDirectory = output.getLocation().toFile();
		final int initialSize;
		if (outputDirectory.exists()) {
			initialSize = outputDirectory.list().length;
		} else {
			initialSize = 0;
		}
		createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
		build();
		Assert.assertTrue(outputDirectory.exists());
		Assert.assertNotEquals(initialSize, outputDirectory.list().length);
		disableAutobuild(() -> {
			createJavaIoFile(output.getFile(new Path("Lalala.txt")).getLocation());
			int expectedSize = (initialSize + 1);
			cleanBuild();
			Assert.assertEquals(expectedSize, outputDirectory.list().length);
			Assert.assertTrue(ArrayExtensions.contains(outputDirectory.list(), "Lalala.txt"));
		});
	}

	protected void testCleanUpDerivedResourcesWithUpdateDerived(IContainer output) {
		File outputDirectory = output.getLocation().toFile();
		final int expectedSize;
		if (outputDirectory.exists()) {
			expectedSize = outputDirectory.list().length;
		} else {
			expectedSize = 0;
		}
		createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
		build();
		Assert.assertNotEquals(expectedSize, outputDirectory.list().length);
		disableAutobuild(() -> {
			try {
				IFile file = output.getFile(new Path("Foo.txt"));
				file.setLocalTimeStamp(1L);
				new WorkspaceJob("file.setContent") {
					@Override
					public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
						setContent(file.getLocation().toFile(), "Lalala");
						Assert.assertFalse(isSynchronized(file));
						return Status.OK_STATUS;
					}
				}.run(monitor());
				cleanBuild();
				Assert.assertEquals(expectedSize, outputDirectory.list().length);
			} catch (CoreException e) {
				throw Exceptions.sneakyThrow(e);
			}
		});
	}

	protected void testCleanUpDerivedResourcesWithDeleteDerived(IContainer output) {
		File outputDirectory = output.getLocation().toFile();
		final int expectedSize;
		if (outputDirectory.exists()) {
			expectedSize = outputDirectory.list().length;
		} else {
			expectedSize = 0;
		}
		createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
		build();
		Assert.assertNotEquals(expectedSize, outputDirectory.list().length);
		disableAutobuild(() -> {
			IFile file = output.getFile(new Path("Foo.txt"));
			new WorkspaceJob("file.delete") {
				@Override
				public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
					Assert.assertTrue(file.getLocation().toFile().delete());
					Assert.assertFalse(isSynchronized(file));
					return Status.OK_STATUS;
				}
			}.run(monitor());
			cleanBuild();
			Assert.assertEquals(expectedSize, outputDirectory.list().length);
		});
	}

	@Test
	public void testDeleteUpdatedDerivedResource() {
		testDeleteUpdatedDerivedResource(project.getFolder("src-gen"));
	}

	@Test
	public void testDeleteUpdatedDerivedResourceWithProjectAsOutput() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testDeleteUpdatedDerivedResource(project));
	}

	protected void testDeleteUpdatedDerivedResource(IContainer output) {
		try {
			File outputDirectory = output.getLocation().toFile();
			final int expectedSize;
			if (outputDirectory.exists()) {
				expectedSize = outputDirectory.list().length;
			} else {
				expectedSize = 0;
			}
			IFile sourceFile = createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
			build();
			Assert.assertNotEquals(expectedSize, outputDirectory.list().length);
			IFile file = output.getFile(new Path("Foo.txt"));
			file.setLocalTimeStamp(1L);
			new WorkspaceJob("file.setContent") {
				@Override
				public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
					setContent(file.getLocation().toFile(), "Lalala");
					Assert.assertFalse(isSynchronized(file));
					return Status.OK_STATUS;
				}
			}.run(monitor());
			sourceFile.delete(false, monitor());
			build();
			Assert.assertEquals(expectedSize, outputDirectory.list().length);
		} catch (CoreException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Test
	public void testDeleteDeletedDerivedResource() {
		testDeleteDeletedDerivedResource(project.getFolder("src-gen"));
	}

	@Test
	public void testDeleteDeletedDerivedResourceWithProjectAsOutput() {
		withOutputConfiguration(it -> it.setOutputDirectory("./"), () -> testDeleteDeletedDerivedResource(project));
	}

	protected void testDeleteDeletedDerivedResource(IContainer output) {
		try {
			File outputDirectory = output.getLocation().toFile();
			int expectedSize = 0;
			if (outputDirectory.exists()) {
				expectedSize = outputDirectory.list().length;
			}
			IFile sourceFile = createFile(project.getFile(("src/Foo" + F_EXT)).getFullPath(), "object Foo");
			build();
			Assert.assertNotEquals(expectedSize, outputDirectory.list().length);
			IFile file = output.getFile(new Path("Foo.txt"));
			file.refreshLocal(0, null);
			Assert.assertTrue(isSynchronized(file));
			new WorkspaceJob("file.delete") {
				@Override
				public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
					Assert.assertTrue(file.getLocation().toFile().delete());
					Assert.assertFalse(isSynchronized(file));
					return Status.OK_STATUS;
				}
			}.run(monitor());
			sourceFile.delete(false, monitor());
			build();
			Assert.assertEquals(expectedSize, outputDirectory.list().length);
		} catch (CoreException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected File createJavaIoFile(IPath location, String content) {
		File javaIoFile = createJavaIoFile(location);
		setContent(javaIoFile, content);
		return javaIoFile;
	}

	protected File createJavaIoFile(IPath location) {
		try {
			File javaIoFile = location.toFile();
			javaIoFile.getParentFile().mkdirs();
			Assert.assertTrue(javaIoFile.createNewFile());
			return javaIoFile;
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected void setContent(File javaIoFile, String content) {
		try (FileOutputStream fos = new FileOutputStream(javaIoFile)) {
			fos.write(content.getBytes());
			fos.flush();
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected boolean isSynchronized(IFile file) {
		org.eclipse.core.internal.resources.File target = ((org.eclipse.core.internal.resources.File) file);
		return target.getLocalManager().fastIsSynchronized(target);
	}
}
