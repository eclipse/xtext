/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.core.resource;

import com.google.common.base.Objects;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.function.Consumer;
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
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.util.JavaProjectClasspathChangeAnalyzer;
import org.eclipse.xtext.ui.workspace.WorkspaceLockAccess;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class Storage2UriMapperJavaImplTest extends Assert {
  private Storage2UriMapperJavaImpl storage2UriMapperJava;
  
  @Before
  public void setUp() {
    this.storage2UriMapperJava = this.createFreshStorage2UriMapper();
    JavaCore.addElementChangedListener(this.storage2UriMapperJava);
  }
  
  @After
  public void tearDown() {
    try {
      JavaCore.removeElementChangedListener(this.storage2UriMapperJava);
      IResourcesSetupUtil.cleanWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Storage2UriMapperJavaImpl createFreshStorage2UriMapper() {
    Storage2UriMapperJavaImpl _storage2UriMapperJavaImpl = new Storage2UriMapperJavaImpl();
    final Procedure1<Storage2UriMapperJavaImpl> _function = (Storage2UriMapperJavaImpl it) -> {
      it.setUriValidator(new UriValidator() {
        @Override
        public boolean isPossiblyManaged(final IStorage storage) {
          return "indexed".equals(storage.getFullPath().getFileExtension());
        }
        
        @Override
        public boolean isValid(final URI uri, final IStorage storage) {
          return "indexed".equals(storage.getFullPath().getFileExtension());
        }
      });
      JarEntryLocator _jarEntryLocator = new JarEntryLocator();
      it.setLocator(_jarEntryLocator);
      it.setWorkspace(ResourcesPlugin.getWorkspace());
      WorkspaceLockAccess _workspaceLockAccess = new WorkspaceLockAccess();
      it.setWorkspaceLockAccess(_workspaceLockAccess);
      JavaProjectClasspathChangeAnalyzer _javaProjectClasspathChangeAnalyzer = new JavaProjectClasspathChangeAnalyzer();
      it.setJavaProjectClasspathChangeAnalyzer(_javaProjectClasspathChangeAnalyzer);
    };
    return ObjectExtensions.<Storage2UriMapperJavaImpl>operator_doubleArrow(_storage2UriMapperJavaImpl, _function);
  }
  
  @Test
  public void testOnClasspathChange() {
    try {
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
      String _plus = ("" + _cachedPackageFragmentRootData);
      Assert.assertEquals(_plus, 0, this.getCachedPackageFragmentRootData().size());
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
      final int sizeBefore = this.getCachedPackageFragmentRootData().size();
      Assert.assertTrue((sizeBefore > 0));
      final Function1<String, Boolean> _function = (String it) -> {
        return Boolean.valueOf(it.contains("foo.jar"));
      };
      Assert.assertNull(IterableExtensions.<String>findFirst(this.getCachedPackageFragmentRootData().keySet(), _function));
      final IFile file = this.createJar(project);
      JavaProjectSetupUtil.addJarToClasspath(project, file);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_1 = this.getCachedPackageFragmentRootData();
      String _plus_1 = ("" + _cachedPackageFragmentRootData_1);
      Assert.assertEquals(_plus_1, (sizeBefore + 1), this.getCachedPackageFragmentRootData().size());
      final Function1<String, Boolean> _function_1 = (String it) -> {
        return Boolean.valueOf(it.contains("foo.jar"));
      };
      Assert.assertNotNull(IterableExtensions.<String>findFirst(this.getCachedPackageFragmentRootData().keySet(), _function_1));
      final Consumer<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _function_2 = (Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it) -> {
        Assert.assertEquals(it.getKey(), 1, it.getValue().associatedRoots.size());
        final String head = IterableExtensions.<String>head(it.getValue().associatedRoots.keySet());
        Assert.assertTrue(head, head.startsWith("=testProject/"));
      };
      this.getCachedPackageFragmentRootData().entrySet().forEach(_function_2);
      final IJavaProject project2 = JavaProjectSetupUtil.createJavaProject("testProject2");
      JavaProjectSetupUtil.addJarToClasspath(project2, file);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_2 = this.getCachedPackageFragmentRootData();
      String _plus_2 = ("" + _cachedPackageFragmentRootData_2);
      Assert.assertEquals(_plus_2, (sizeBefore + 1), this.getCachedPackageFragmentRootData().size());
      final Function1<String, Boolean> _function_3 = (String it) -> {
        return Boolean.valueOf(it.contains("foo.jar"));
      };
      Assert.assertNotNull(IterableExtensions.<String>findFirst(this.getCachedPackageFragmentRootData().keySet(), _function_3));
      final Consumer<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _function_4 = (Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it) -> {
        Assert.assertEquals(it.getKey(), 2, it.getValue().associatedRoots.size());
        final String head = IterableExtensions.<String>head(it.getValue().associatedRoots.keySet());
        Assert.assertTrue(head, (head.startsWith("=testProject/") || head.startsWith("=testProject2/")));
        final String head2 = IterableExtensions.<String>head(IterableExtensions.<String>tail(it.getValue().associatedRoots.keySet()));
        Assert.assertTrue(head2, (head.startsWith("=testProject/") || head.startsWith("=testProject2/")));
      };
      this.getCachedPackageFragmentRootData().entrySet().forEach(_function_4);
      JavaProjectSetupUtil.removeJarFromClasspath(project, file);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_3 = this.getCachedPackageFragmentRootData();
      String _plus_3 = ("" + _cachedPackageFragmentRootData_3);
      Assert.assertEquals(_plus_3, (sizeBefore + 1), this.getCachedPackageFragmentRootData().size());
      final Function1<String, Boolean> _function_5 = (String it) -> {
        return Boolean.valueOf(it.contains("foo.jar"));
      };
      Assert.assertNotNull(IterableExtensions.<String>findFirst(this.getCachedPackageFragmentRootData().keySet(), _function_5));
      final Consumer<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _function_6 = (Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it) -> {
        boolean _contains = it.getKey().contains("foo.jar");
        if (_contains) {
          Assert.assertEquals(it.getKey(), 1, it.getValue().associatedRoots.size());
          final String head = IterableExtensions.<String>head(it.getValue().associatedRoots.keySet());
          Assert.assertTrue(head, head.startsWith("=testProject2/"));
        } else {
          Assert.assertEquals(it.getKey(), 2, it.getValue().associatedRoots.size());
          final String head_1 = IterableExtensions.<String>head(it.getValue().associatedRoots.keySet());
          Assert.assertTrue(head_1, (head_1.startsWith("=testProject/") || head_1.startsWith("=testProject2/")));
          final String head2 = IterableExtensions.<String>head(IterableExtensions.<String>tail(it.getValue().associatedRoots.keySet()));
          Assert.assertTrue(head2, (head_1.startsWith("=testProject/") || head_1.startsWith("=testProject2/")));
        }
      };
      this.getCachedPackageFragmentRootData().entrySet().forEach(_function_6);
      JavaProjectSetupUtil.removeJarFromClasspath(project2, file);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_4 = this.getCachedPackageFragmentRootData();
      String _plus_4 = ("" + _cachedPackageFragmentRootData_4);
      Assert.assertEquals(_plus_4, sizeBefore, this.getCachedPackageFragmentRootData().size());
      final Function1<String, Boolean> _function_7 = (String it) -> {
        return Boolean.valueOf(it.contains("foo.jar"));
      };
      Assert.assertNull(IterableExtensions.<String>findFirst(this.getCachedPackageFragmentRootData().keySet(), _function_7));
      final Consumer<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _function_8 = (Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it) -> {
        Assert.assertEquals(it.getKey(), 2, it.getValue().associatedRoots.size());
        final String head = IterableExtensions.<String>head(it.getValue().associatedRoots.keySet());
        Assert.assertTrue(head, (head.startsWith("=testProject/") || head.startsWith("=testProject2/")));
        final String head2 = IterableExtensions.<String>head(IterableExtensions.<String>tail(it.getValue().associatedRoots.keySet()));
        Assert.assertTrue(head2, (head.startsWith("=testProject/") || head.startsWith("=testProject2/")));
      };
      this.getCachedPackageFragmentRootData().entrySet().forEach(_function_8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOnCloseOpenRemoveProject() {
    try {
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
      final IJavaProject project2 = JavaProjectSetupUtil.createJavaProject("testProject2");
      final int sizeBefore = this.getCachedPackageFragmentRootData().size();
      final IFile file = this.createJar(project);
      JavaProjectSetupUtil.addJarToClasspath(project, file);
      JavaProjectSetupUtil.addJarToClasspath(project2, file);
      this.assertBothProjects(sizeBefore);
      project2.getProject().close(IResourcesSetupUtil.monitor());
      this.assertFirstProject(sizeBefore);
      project.getProject().close(IResourcesSetupUtil.monitor());
      this.assertNonProjects();
      project.getProject().open(IResourcesSetupUtil.monitor());
      this.assertFirstProject(sizeBefore);
      project2.getProject().open(IResourcesSetupUtil.monitor());
      this.assertBothProjects(sizeBefore);
      project.getProject().delete(true, IResourcesSetupUtil.monitor());
      project2.getProject().delete(true, IResourcesSetupUtil.monitor());
      this.assertNonProjects();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOnRemoveTwoProjects() {
    try {
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
      final IJavaProject project2 = JavaProjectSetupUtil.createJavaProject("testProject2");
      final int sizeBefore = this.getCachedPackageFragmentRootData().size();
      final IFile file = this.createJar(project);
      JavaProjectSetupUtil.addJarToClasspath(project, file);
      JavaProjectSetupUtil.addJarToClasspath(project2, file);
      this.assertBothProjects(sizeBefore);
      final WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
          project.getProject().delete(true, monitor);
          project2.getProject().delete(true, monitor);
        }
      };
      op.run(IResourcesSetupUtil.monitor());
      this.assertNonProjects();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertNonProjects() {
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
    String _plus = ("" + _cachedPackageFragmentRootData);
    Assert.assertEquals(_plus, 0, this.getCachedPackageFragmentRootData().size());
  }
  
  public void assertFirstProject(final int sizeBefore) {
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
    String _plus = ("" + _cachedPackageFragmentRootData);
    Assert.assertEquals(_plus, (sizeBefore + 1), this.getCachedPackageFragmentRootData().size());
    final Function1<String, Boolean> _function = (String it) -> {
      return Boolean.valueOf(it.contains("foo.jar"));
    };
    Assert.assertNotNull(IterableExtensions.<String>findFirst(this.getCachedPackageFragmentRootData().keySet(), _function));
    final Consumer<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _function_1 = (Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it) -> {
      Assert.assertEquals(it.getKey(), 1, it.getValue().associatedRoots.size());
      final String head = IterableExtensions.<String>head(it.getValue().associatedRoots.keySet());
      Assert.assertTrue(head, head.startsWith("=testProject/"));
    };
    this.getCachedPackageFragmentRootData().entrySet().forEach(_function_1);
  }
  
  public void assertBothProjects(final int sizeBefore) {
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
    String _plus = ("" + _cachedPackageFragmentRootData);
    Assert.assertEquals(_plus, (sizeBefore + 1), this.getCachedPackageFragmentRootData().size());
    final Function1<String, Boolean> _function = (String it) -> {
      return Boolean.valueOf(it.contains("foo.jar"));
    };
    Assert.assertNotNull(IterableExtensions.<String>findFirst(this.getCachedPackageFragmentRootData().keySet(), _function));
    final Consumer<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _function_1 = (Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it) -> {
      Assert.assertEquals(it.getKey(), 2, it.getValue().associatedRoots.size());
      final String head = IterableExtensions.<String>head(it.getValue().associatedRoots.keySet());
      Assert.assertTrue(head, (head.startsWith("=testProject/") || head.startsWith("=testProject2/")));
      final String head2 = IterableExtensions.<String>last(it.getValue().associatedRoots.keySet());
      Assert.assertTrue(head2, (head.startsWith("=testProject/") || head.startsWith("=testProject2/")));
    };
    this.getCachedPackageFragmentRootData().entrySet().forEach(_function_1);
  }
  
  public IFile createJar(final IJavaProject project) {
    IFile _file = project.getProject().getFile("foo.jar");
    final Procedure1<IFile> _function = (IFile it) -> {
      try {
        JavaProjectSetupUtil.TextFile _textFile = new JavaProjectSetupUtil.TextFile("foo/bar.indexed", "//empty");
        JavaProjectSetupUtil.TextFile _textFile_1 = new JavaProjectSetupUtil.TextFile("META-INF/MANIFEST.MF", "Manifest-Version: 1.0\nBundle-SymbolicName: hubba.bubba\n");
        it.create(
          JavaProjectSetupUtil.jarInputStream(_textFile, _textFile_1), true, IResourcesSetupUtil.monitor());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    return ObjectExtensions.<IFile>operator_doubleArrow(_file, _function);
  }
  
  public Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> getCachedPackageFragmentRootData() {
    try {
      final Function1<Field, Boolean> _function = (Field it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "cachedPackageFragmentRootData"));
      };
      Field _findFirst = IterableExtensions.<Field>findFirst(((Iterable<Field>)Conversions.doWrapArray(this.storage2UriMapperJava.getClass().getDeclaredFields())), _function);
      final Procedure1<Field> _function_1 = (Field it) -> {
        it.setAccessible(true);
      };
      Object _get = ObjectExtensions.<Field>operator_doubleArrow(_findFirst, _function_1).get(this.storage2UriMapperJava);
      return ((Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>) _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
