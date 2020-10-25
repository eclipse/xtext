/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.core.resource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl.PackageFragmentRootData;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.util.JavaProjectClasspathChangeAnalyzer;
import org.eclipse.xtext.ui.workspace.WorkspaceLockAccess;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class Storage2UriMapperJavaImplTest extends Assert {
	private Storage2UriMapperJavaImpl storage2UriMapperJava;

	@Before
	public void setUp() {
		storage2UriMapperJava = createFreshStorage2UriMapper();
		JavaCore.addElementChangedListener(storage2UriMapperJava);
	}

	@After
	public void tearDown() throws Exception {
		JavaCore.removeElementChangedListener(storage2UriMapperJava);
		IResourcesSetupUtil.cleanWorkspace();
	}

	private boolean isExpectedJRESize(int size) {
		switch (size) {
			case 1:
				/* java8 */ return true;
			case 63:
				/* java9 */ return true;
			case 49:
				/* java10 + java11 + java13 */ return true;
			case 51:
				/* java14 */ return true;
			default:
				return false;
		}
	}

	private boolean isExpectedJRESize(int size, int multiplier) {
		return isExpectedJRESize(size / multiplier) && size / multiplier * multiplier == size;
	}

	protected Storage2UriMapperJavaImpl createFreshStorage2UriMapper() {
		Storage2UriMapperJavaImpl mapper = new Storage2UriMapperJavaImpl();
		mapper.setUriValidator(new UriValidator() {
			@Override
			public boolean isPossiblyManaged(IStorage storage) {
				return "indexed".equals(storage.getFullPath().getFileExtension());
			}

			@Override
			public boolean isValid(URI uri, IStorage storage) {
				return "indexed".equals(storage.getFullPath().getFileExtension());
			}
		});
		mapper.setLocator(new JarEntryLocator());
		mapper.setWorkspace(ResourcesPlugin.getWorkspace());
		mapper.setWorkspaceLockAccess(new WorkspaceLockAccess());
		mapper.setJavaProjectClasspathChangeAnalyzer(new JavaProjectClasspathChangeAnalyzer());
		return mapper;
	}

	@Test
	public void testOnClasspathChange() throws Exception {
		Assert.assertEquals("" + getCachedPackageFragmentRootData(), 0, getCachedPackageFragmentRootData().size());
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
		int sizeBefore = getCachedPackageFragmentRootData().size();
		// it should contain all the jars from JDK now
		Assert.assertTrue(sizeBefore > 0);
		Assert.assertFalse(getCachedPackageFragmentRootData().keySet().stream().filter(it -> it.contains("foo.jar")).findFirst().isPresent());
		IFile file = createJar(project);
		JavaProjectSetupUtil.addJarToClasspath(project, file);
		Assert.assertEquals("" + getCachedPackageFragmentRootData(), sizeBefore + 1, getCachedPackageFragmentRootData().size());
		Assert.assertNotNull(getCachedPackageFragmentRootData().keySet().stream().filter(it -> it.contains("foo.jar")).findFirst().get());
		getCachedPackageFragmentRootData().entrySet().forEach((Map.Entry<String, PackageFragmentRootData> it) -> {
			Assert.assertTrue(it.getValue().associatedRoots.size() + " / " + it.getKey(),
					isExpectedJRESize(it.getValue().associatedRoots.size()));
			String head = Iterables.getFirst(it.getValue().associatedRoots.keySet(), null);
			Assert.assertTrue(head, head.startsWith("=testProject/"));
		});
		IJavaProject project2 = JavaProjectSetupUtil.createJavaProject("testProject2");
		JavaProjectSetupUtil.addJarToClasspath(project2, file);
		Assert.assertEquals("" + getCachedPackageFragmentRootData(), (sizeBefore + 1), getCachedPackageFragmentRootData().size());
		Assert.assertNotNull(getCachedPackageFragmentRootData().keySet().stream().filter(it -> it.contains("foo.jar")).findFirst().get());
		getCachedPackageFragmentRootData().entrySet().forEach((Map.Entry<String, PackageFragmentRootData> it) -> {
			Assert.assertTrue(it.getValue().associatedRoots.size() + " / " + it.getKey(),
					isExpectedJRESize(it.getValue().associatedRoots.size(), 2));
			String msg = Joiner.on("\n").join(it.getValue().associatedRoots.keySet());
			Assert.assertTrue(msg, Iterables.any(it.getValue().associatedRoots.keySet(), r -> r.startsWith("=testProject/")));
			Assert.assertTrue(msg, Iterables.any(it.getValue().associatedRoots.keySet(), r -> r.startsWith("=testProject2/")));
		});
		JavaProjectSetupUtil.removeJarFromClasspath(project, file);
		Assert.assertEquals("" + getCachedPackageFragmentRootData(), sizeBefore + 1, getCachedPackageFragmentRootData().size());
		Assert.assertNotNull(getCachedPackageFragmentRootData().keySet().stream().filter(it -> it.contains("foo.jar")).findFirst().get());
		getCachedPackageFragmentRootData().entrySet().forEach((Map.Entry<String, PackageFragmentRootData> it) -> {
			if (it.getKey().contains("foo.jar")) {
				Assert.assertEquals(it.getKey(), 1, it.getValue().associatedRoots.size());
				String head = Iterables.getFirst(it.getValue().associatedRoots.keySet(), null);
				Assert.assertTrue(head, head.startsWith("=testProject2/"));
			} else {
				Assert.assertTrue(it.getValue().associatedRoots.size() + "/" + it.getKey(),
						isExpectedJRESize(it.getValue().associatedRoots.size(), 2));
				String msg = Joiner.on("\n").join(it.getValue().associatedRoots.keySet());
				Assert.assertTrue(msg, Iterables.any(it.getValue().associatedRoots.keySet(), r -> r.startsWith("=testProject/")));
				Assert.assertTrue(msg, Iterables.any(it.getValue().associatedRoots.keySet(), r -> r.startsWith("=testProject2/")));
			}
		});
		JavaProjectSetupUtil.removeJarFromClasspath(project2, file);
		Assert.assertEquals("" + getCachedPackageFragmentRootData(), sizeBefore, getCachedPackageFragmentRootData().size());
		Assert.assertFalse(getCachedPackageFragmentRootData().keySet().stream().filter(it -> it.contains("foo.jar")).findFirst().isPresent());
		getCachedPackageFragmentRootData().entrySet().forEach((Map.Entry<String, PackageFragmentRootData> it) -> {
			Assert.assertTrue(it.getValue().associatedRoots.size() + "/" + it.getKey(),
					isExpectedJRESize(it.getValue().associatedRoots.size(), 2));
			String msg = Joiner.on("\n").join(it.getValue().associatedRoots.keySet());
			Assert.assertTrue(msg, Iterables.any(it.getValue().associatedRoots.keySet(), r -> r.startsWith("=testProject/")));
			Assert.assertTrue(msg, Iterables.any(it.getValue().associatedRoots.keySet(), r -> r.startsWith("=testProject2/")));
		});
	}

	@Test
	public void testOnCloseOpenRemoveProject() throws Exception {
		Assert.assertEquals(0, getCachedPackageFragmentRootData().size());
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
		IJavaProject project2 = JavaProjectSetupUtil.createJavaProject("testProject2");
		int sizeBefore = getCachedPackageFragmentRootData().size();
		IFile file = createJar(project);
		JavaProjectSetupUtil.addJarToClasspath(project, file);
		JavaProjectSetupUtil.addJarToClasspath(project2, file);
		assertBothProjects(sizeBefore);
		project2.getProject().close(IResourcesSetupUtil.monitor());
		assertFirstProject(sizeBefore);
		project.getProject().close(IResourcesSetupUtil.monitor());
		assertNonProjects();
		project.getProject().open(IResourcesSetupUtil.monitor());
		assertFirstProject(sizeBefore);
		project2.getProject().open(IResourcesSetupUtil.monitor());
		assertBothProjects(sizeBefore);
		project.getProject().delete(true, IResourcesSetupUtil.monitor());
		project2.getProject().delete(true, IResourcesSetupUtil.monitor());
		assertNonProjects();
	}

	@Test
	public void testOnRemoveTwoProjects() throws Exception {
		Assert.assertEquals(0, getCachedPackageFragmentRootData().size());
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
		IJavaProject project2 = JavaProjectSetupUtil.createJavaProject("testProject2");
		int sizeBefore = getCachedPackageFragmentRootData().size();
		IFile file = createJar(project);
		JavaProjectSetupUtil.addJarToClasspath(project, file);
		JavaProjectSetupUtil.addJarToClasspath(project2, file);
		assertBothProjects(sizeBefore);
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				project.getProject().delete(true, monitor);
				project2.getProject().delete(true, monitor);
			}
		};
		op.run(IResourcesSetupUtil.monitor());
		assertNonProjects();
	}

	public void assertNonProjects() throws Exception {
		Assert.assertEquals("" + getCachedPackageFragmentRootData(), 0, getCachedPackageFragmentRootData().size());
	}

	public void assertFirstProject(int sizeBefore) throws Exception {
		Assert.assertEquals("" + getCachedPackageFragmentRootData(), sizeBefore + 1, getCachedPackageFragmentRootData().size());
		Assert.assertNotNull(getCachedPackageFragmentRootData().keySet().stream().filter(it -> it.contains("foo.jar")).findFirst().get());
		getCachedPackageFragmentRootData().entrySet().forEach((Map.Entry<String, PackageFragmentRootData> it) -> {
			boolean java9OrNewer = Iterables.any(it.getValue().associatedRoots.values(),
					r -> "JrtPackageFragmentRoot".equals(r.getClass().getSimpleName()));
			if (java9OrNewer) {
				Assert.assertTrue(it.getValue().associatedRoots.size() + " / " + it.getKey(),
						Lists.newArrayList(44 /* java11 */, 49, 63 /* java9 */, 51 /* java14 */)
								.contains(Integer.valueOf(it.getValue().associatedRoots.size())));
			} else {
				Assert.assertEquals(it.getKey(), 1, it.getValue().associatedRoots.size());
			}
			String head = Iterables.getFirst(it.getValue().associatedRoots.keySet(), null);
			Assert.assertTrue(head, head.startsWith("=testProject/"));
		});
	}

	public void assertBothProjects(int sizeBefore) throws Exception {
		Assert.assertEquals("" + getCachedPackageFragmentRootData(), sizeBefore + 1, getCachedPackageFragmentRootData().size());
		Assert.assertNotNull(getCachedPackageFragmentRootData().keySet().stream().filter(it -> it.contains("foo.jar")).findFirst().get());
		getCachedPackageFragmentRootData().entrySet().forEach((Map.Entry<String, PackageFragmentRootData> it) -> {
			Assert.assertTrue(it.getValue().associatedRoots.size() + "/" + it.getKey(),
					isExpectedJRESize(it.getValue().associatedRoots.size(), 2));
			String msg = Joiner.on("\n").join(it.getValue().associatedRoots.keySet());
			Assert.assertTrue(msg, Iterables.any(it.getValue().associatedRoots.keySet(), r -> r.startsWith("=testProject/")));
			Assert.assertTrue(msg, Iterables.any(it.getValue().associatedRoots.keySet(), r -> r.startsWith("=testProject2/")));
		});
	}

	public IFile createJar(IJavaProject project) throws Exception {
		IFile file = project.getProject().getFile("foo.jar");
		file.create(JavaProjectSetupUtil.jarInputStream(new JavaProjectSetupUtil.TextFile("foo/bar.indexed", "//empty"),
				new JavaProjectSetupUtil.TextFile("META-INF/MANIFEST.MF", "Manifest-Version: 1.0\nBundle-SymbolicName: hubba.bubba\n")),
				true, IResourcesSetupUtil.monitor());
		return file;
	}

	public Map<String, PackageFragmentRootData> getCachedPackageFragmentRootData() throws Exception {
		for (Field field : storage2UriMapperJava.getClass().getDeclaredFields()) {
			if ("cachedPackageFragmentRootData".equals(field.getName())) {
				field.setAccessible(true);
				@SuppressWarnings("unchecked")
				Map<String, PackageFragmentRootData> result = (Map<String, PackageFragmentRootData>) field.get(storage2UriMapperJava);
				return result;
			}
		}
		return null;
	}
}
