/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.core.resource;

import com.google.common.base.Objects;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.util.JavaProjectClasspathChangeAnalyzer;
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
    Storage2UriMapperJavaImpl _createFreshStorage2UriMapper = this.createFreshStorage2UriMapper();
    this.storage2UriMapperJava = _createFreshStorage2UriMapper;
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
    final Procedure1<Storage2UriMapperJavaImpl> _function = new Procedure1<Storage2UriMapperJavaImpl>() {
      @Override
      public void apply(final Storage2UriMapperJavaImpl it) {
        it.setUriValidator(new UriValidator() {
          @Override
          public boolean isPossiblyManaged(final IStorage storage) {
            IPath _fullPath = storage.getFullPath();
            String _fileExtension = _fullPath.getFileExtension();
            return "indexed".equals(_fileExtension);
          }
          
          @Override
          public boolean isValid(final URI uri, final IStorage storage) {
            IPath _fullPath = storage.getFullPath();
            String _fileExtension = _fullPath.getFileExtension();
            return "indexed".equals(_fileExtension);
          }
        });
        JarEntryLocator _jarEntryLocator = new JarEntryLocator();
        it.setLocator(_jarEntryLocator);
        IWorkspace _workspace = ResourcesPlugin.getWorkspace();
        it.setWorkspace(_workspace);
        JavaProjectClasspathChangeAnalyzer _javaProjectClasspathChangeAnalyzer = new JavaProjectClasspathChangeAnalyzer();
        it.setJavaProjectClasspathChangeAnalyzer(_javaProjectClasspathChangeAnalyzer);
      }
    };
    return ObjectExtensions.<Storage2UriMapperJavaImpl>operator_doubleArrow(_storage2UriMapperJavaImpl, _function);
  }
  
  @Test
  public void testOnClasspathChange() {
    try {
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
      String _plus = ("" + _cachedPackageFragmentRootData);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_1 = this.getCachedPackageFragmentRootData();
      int _size = _cachedPackageFragmentRootData_1.size();
      Assert.assertEquals(_plus, 0, _size);
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_2 = this.getCachedPackageFragmentRootData();
      final int sizeBefore = _cachedPackageFragmentRootData_2.size();
      Assert.assertTrue((sizeBefore > 0));
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_3 = this.getCachedPackageFragmentRootData();
      Set<String> _keySet = _cachedPackageFragmentRootData_3.keySet();
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.contains("foo.jar"));
        }
      };
      String _findFirst = IterableExtensions.<String>findFirst(_keySet, _function);
      Assert.assertNull(_findFirst);
      final IFile file = this.createJar(project);
      JavaProjectSetupUtil.addJarToClasspath(project, file);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_4 = this.getCachedPackageFragmentRootData();
      String _plus_1 = ("" + _cachedPackageFragmentRootData_4);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_5 = this.getCachedPackageFragmentRootData();
      int _size_1 = _cachedPackageFragmentRootData_5.size();
      Assert.assertEquals(_plus_1, (sizeBefore + 1), _size_1);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_6 = this.getCachedPackageFragmentRootData();
      Set<String> _keySet_1 = _cachedPackageFragmentRootData_6.keySet();
      final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.contains("foo.jar"));
        }
      };
      String _findFirst_1 = IterableExtensions.<String>findFirst(_keySet_1, _function_1);
      Assert.assertNotNull(_findFirst_1);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_7 = this.getCachedPackageFragmentRootData();
      Set<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _entrySet = _cachedPackageFragmentRootData_7.entrySet();
      for (final Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it : _entrySet) {
        {
          String _key = it.getKey();
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value = it.getValue();
          int _size_2 = _value.associatedRoots.size();
          Assert.assertEquals(_key, 1, _size_2);
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_1 = it.getValue();
          Set<String> _keySet_2 = _value_1.associatedRoots.keySet();
          final String head = IterableExtensions.<String>head(_keySet_2);
          boolean _startsWith = head.startsWith("=testProject/");
          Assert.assertTrue(head, _startsWith);
        }
      }
      final IJavaProject project2 = JavaProjectSetupUtil.createJavaProject("testProject2");
      JavaProjectSetupUtil.addJarToClasspath(project2, file);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_8 = this.getCachedPackageFragmentRootData();
      String _plus_2 = ("" + _cachedPackageFragmentRootData_8);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_9 = this.getCachedPackageFragmentRootData();
      int _size_2 = _cachedPackageFragmentRootData_9.size();
      Assert.assertEquals(_plus_2, (sizeBefore + 1), _size_2);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_10 = this.getCachedPackageFragmentRootData();
      Set<String> _keySet_2 = _cachedPackageFragmentRootData_10.keySet();
      final Function1<String, Boolean> _function_2 = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.contains("foo.jar"));
        }
      };
      String _findFirst_2 = IterableExtensions.<String>findFirst(_keySet_2, _function_2);
      Assert.assertNotNull(_findFirst_2);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_11 = this.getCachedPackageFragmentRootData();
      Set<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _entrySet_1 = _cachedPackageFragmentRootData_11.entrySet();
      for (final Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it_1 : _entrySet_1) {
        {
          String _key = it_1.getKey();
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value = it_1.getValue();
          int _size_3 = _value.associatedRoots.size();
          Assert.assertEquals(_key, 2, _size_3);
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_1 = it_1.getValue();
          Set<String> _keySet_3 = _value_1.associatedRoots.keySet();
          final String head = IterableExtensions.<String>head(_keySet_3);
          boolean _or = false;
          boolean _startsWith = head.startsWith("=testProject/");
          if (_startsWith) {
            _or = true;
          } else {
            boolean _startsWith_1 = head.startsWith("=testProject2/");
            _or = _startsWith_1;
          }
          Assert.assertTrue(head, _or);
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_2 = it_1.getValue();
          Set<String> _keySet_4 = _value_2.associatedRoots.keySet();
          Iterable<String> _tail = IterableExtensions.<String>tail(_keySet_4);
          final String head2 = IterableExtensions.<String>head(_tail);
          boolean _or_1 = false;
          boolean _startsWith_2 = head.startsWith("=testProject/");
          if (_startsWith_2) {
            _or_1 = true;
          } else {
            boolean _startsWith_3 = head.startsWith("=testProject2/");
            _or_1 = _startsWith_3;
          }
          Assert.assertTrue(head2, _or_1);
        }
      }
      JavaProjectSetupUtil.removeJarFromClasspath(project, file);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_12 = this.getCachedPackageFragmentRootData();
      String _plus_3 = ("" + _cachedPackageFragmentRootData_12);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_13 = this.getCachedPackageFragmentRootData();
      int _size_3 = _cachedPackageFragmentRootData_13.size();
      Assert.assertEquals(_plus_3, (sizeBefore + 1), _size_3);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_14 = this.getCachedPackageFragmentRootData();
      Set<String> _keySet_3 = _cachedPackageFragmentRootData_14.keySet();
      final Function1<String, Boolean> _function_3 = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.contains("foo.jar"));
        }
      };
      String _findFirst_3 = IterableExtensions.<String>findFirst(_keySet_3, _function_3);
      Assert.assertNotNull(_findFirst_3);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_15 = this.getCachedPackageFragmentRootData();
      Set<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _entrySet_2 = _cachedPackageFragmentRootData_15.entrySet();
      for (final Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it_2 : _entrySet_2) {
        String _key = it_2.getKey();
        boolean _contains = _key.contains("foo.jar");
        if (_contains) {
          String _key_1 = it_2.getKey();
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value = it_2.getValue();
          int _size_4 = _value.associatedRoots.size();
          Assert.assertEquals(_key_1, 1, _size_4);
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_1 = it_2.getValue();
          Set<String> _keySet_4 = _value_1.associatedRoots.keySet();
          final String head = IterableExtensions.<String>head(_keySet_4);
          boolean _startsWith = head.startsWith("=testProject2/");
          Assert.assertTrue(head, _startsWith);
        } else {
          String _key_2 = it_2.getKey();
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_2 = it_2.getValue();
          int _size_5 = _value_2.associatedRoots.size();
          Assert.assertEquals(_key_2, 2, _size_5);
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_3 = it_2.getValue();
          Set<String> _keySet_5 = _value_3.associatedRoots.keySet();
          final String head_1 = IterableExtensions.<String>head(_keySet_5);
          boolean _or = false;
          boolean _startsWith_1 = head_1.startsWith("=testProject/");
          if (_startsWith_1) {
            _or = true;
          } else {
            boolean _startsWith_2 = head_1.startsWith("=testProject2/");
            _or = _startsWith_2;
          }
          Assert.assertTrue(head_1, _or);
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_4 = it_2.getValue();
          Set<String> _keySet_6 = _value_4.associatedRoots.keySet();
          Iterable<String> _tail = IterableExtensions.<String>tail(_keySet_6);
          final String head2 = IterableExtensions.<String>head(_tail);
          boolean _or_1 = false;
          boolean _startsWith_3 = head_1.startsWith("=testProject/");
          if (_startsWith_3) {
            _or_1 = true;
          } else {
            boolean _startsWith_4 = head_1.startsWith("=testProject2/");
            _or_1 = _startsWith_4;
          }
          Assert.assertTrue(head2, _or_1);
        }
      }
      JavaProjectSetupUtil.removeJarFromClasspath(project2, file);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_16 = this.getCachedPackageFragmentRootData();
      String _plus_4 = ("" + _cachedPackageFragmentRootData_16);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_17 = this.getCachedPackageFragmentRootData();
      int _size_6 = _cachedPackageFragmentRootData_17.size();
      Assert.assertEquals(_plus_4, sizeBefore, _size_6);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_18 = this.getCachedPackageFragmentRootData();
      Set<String> _keySet_7 = _cachedPackageFragmentRootData_18.keySet();
      final Function1<String, Boolean> _function_4 = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.contains("foo.jar"));
        }
      };
      String _findFirst_4 = IterableExtensions.<String>findFirst(_keySet_7, _function_4);
      Assert.assertNull(_findFirst_4);
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_19 = this.getCachedPackageFragmentRootData();
      Set<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _entrySet_3 = _cachedPackageFragmentRootData_19.entrySet();
      for (final Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it_3 : _entrySet_3) {
        {
          String _key_3 = it_3.getKey();
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_5 = it_3.getValue();
          int _size_7 = _value_5.associatedRoots.size();
          Assert.assertEquals(_key_3, 2, _size_7);
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_6 = it_3.getValue();
          Set<String> _keySet_8 = _value_6.associatedRoots.keySet();
          final String head_2 = IterableExtensions.<String>head(_keySet_8);
          boolean _or_2 = false;
          boolean _startsWith_5 = head_2.startsWith("=testProject/");
          if (_startsWith_5) {
            _or_2 = true;
          } else {
            boolean _startsWith_6 = head_2.startsWith("=testProject2/");
            _or_2 = _startsWith_6;
          }
          Assert.assertTrue(head_2, _or_2);
          Storage2UriMapperJavaImpl.PackageFragmentRootData _value_7 = it_3.getValue();
          Set<String> _keySet_9 = _value_7.associatedRoots.keySet();
          Iterable<String> _tail_1 = IterableExtensions.<String>tail(_keySet_9);
          final String head2_1 = IterableExtensions.<String>head(_tail_1);
          boolean _or_3 = false;
          boolean _startsWith_7 = head_2.startsWith("=testProject/");
          if (_startsWith_7) {
            _or_3 = true;
          } else {
            boolean _startsWith_8 = head_2.startsWith("=testProject2/");
            _or_3 = _startsWith_8;
          }
          Assert.assertTrue(head2_1, _or_3);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOnCloseOpenRemoveProject() {
    try {
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
      final IJavaProject project2 = JavaProjectSetupUtil.createJavaProject("testProject2");
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
      final int sizeBefore = _cachedPackageFragmentRootData.size();
      final IFile file = this.createJar(project);
      JavaProjectSetupUtil.addJarToClasspath(project, file);
      JavaProjectSetupUtil.addJarToClasspath(project2, file);
      this.assertBothProjects(sizeBefore);
      IProject _project = project2.getProject();
      IProgressMonitor _monitor = IResourcesSetupUtil.monitor();
      _project.close(_monitor);
      this.assertFirstProject(sizeBefore);
      IProject _project_1 = project.getProject();
      IProgressMonitor _monitor_1 = IResourcesSetupUtil.monitor();
      _project_1.close(_monitor_1);
      this.assertNonProjects();
      IProject _project_2 = project.getProject();
      IProgressMonitor _monitor_2 = IResourcesSetupUtil.monitor();
      _project_2.open(_monitor_2);
      this.assertFirstProject(sizeBefore);
      IProject _project_3 = project2.getProject();
      IProgressMonitor _monitor_3 = IResourcesSetupUtil.monitor();
      _project_3.open(_monitor_3);
      this.assertBothProjects(sizeBefore);
      IProject _project_4 = project.getProject();
      IProgressMonitor _monitor_4 = IResourcesSetupUtil.monitor();
      _project_4.delete(true, _monitor_4);
      IProject _project_5 = project2.getProject();
      IProgressMonitor _monitor_5 = IResourcesSetupUtil.monitor();
      _project_5.delete(true, _monitor_5);
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
      Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
      final int sizeBefore = _cachedPackageFragmentRootData.size();
      final IFile file = this.createJar(project);
      JavaProjectSetupUtil.addJarToClasspath(project, file);
      JavaProjectSetupUtil.addJarToClasspath(project2, file);
      this.assertBothProjects(sizeBefore);
      final WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
          IProject _project = project.getProject();
          _project.delete(true, monitor);
          IProject _project_1 = project2.getProject();
          _project_1.delete(true, monitor);
        }
      };
      IProgressMonitor _monitor = IResourcesSetupUtil.monitor();
      op.run(_monitor);
      this.assertNonProjects();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertNonProjects() {
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
    String _plus = ("" + _cachedPackageFragmentRootData);
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_1 = this.getCachedPackageFragmentRootData();
    int _size = _cachedPackageFragmentRootData_1.size();
    Assert.assertEquals(_plus, 0, _size);
  }
  
  public void assertFirstProject(final int sizeBefore) {
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
    String _plus = ("" + _cachedPackageFragmentRootData);
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_1 = this.getCachedPackageFragmentRootData();
    int _size = _cachedPackageFragmentRootData_1.size();
    Assert.assertEquals(_plus, (sizeBefore + 1), _size);
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_2 = this.getCachedPackageFragmentRootData();
    Set<String> _keySet = _cachedPackageFragmentRootData_2.keySet();
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.contains("foo.jar"));
      }
    };
    String _findFirst = IterableExtensions.<String>findFirst(_keySet, _function);
    Assert.assertNotNull(_findFirst);
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_3 = this.getCachedPackageFragmentRootData();
    Set<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _entrySet = _cachedPackageFragmentRootData_3.entrySet();
    for (final Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it : _entrySet) {
      {
        String _key = it.getKey();
        Storage2UriMapperJavaImpl.PackageFragmentRootData _value = it.getValue();
        int _size_1 = _value.associatedRoots.size();
        Assert.assertEquals(_key, 1, _size_1);
        Storage2UriMapperJavaImpl.PackageFragmentRootData _value_1 = it.getValue();
        Set<String> _keySet_1 = _value_1.associatedRoots.keySet();
        final String head = IterableExtensions.<String>head(_keySet_1);
        boolean _startsWith = head.startsWith("=testProject/");
        Assert.assertTrue(head, _startsWith);
      }
    }
  }
  
  public void assertBothProjects(final int sizeBefore) {
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData = this.getCachedPackageFragmentRootData();
    String _plus = ("" + _cachedPackageFragmentRootData);
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_1 = this.getCachedPackageFragmentRootData();
    int _size = _cachedPackageFragmentRootData_1.size();
    Assert.assertEquals(_plus, (sizeBefore + 1), _size);
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_2 = this.getCachedPackageFragmentRootData();
    Set<String> _keySet = _cachedPackageFragmentRootData_2.keySet();
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.contains("foo.jar"));
      }
    };
    String _findFirst = IterableExtensions.<String>findFirst(_keySet, _function);
    Assert.assertNotNull(_findFirst);
    Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> _cachedPackageFragmentRootData_3 = this.getCachedPackageFragmentRootData();
    Set<Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>> _entrySet = _cachedPackageFragmentRootData_3.entrySet();
    for (final Map.Entry<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> it : _entrySet) {
      {
        String _key = it.getKey();
        Storage2UriMapperJavaImpl.PackageFragmentRootData _value = it.getValue();
        int _size_1 = _value.associatedRoots.size();
        Assert.assertEquals(_key, 2, _size_1);
        Storage2UriMapperJavaImpl.PackageFragmentRootData _value_1 = it.getValue();
        Set<String> _keySet_1 = _value_1.associatedRoots.keySet();
        final String head = IterableExtensions.<String>head(_keySet_1);
        boolean _or = false;
        boolean _startsWith = head.startsWith("=testProject/");
        if (_startsWith) {
          _or = true;
        } else {
          boolean _startsWith_1 = head.startsWith("=testProject2/");
          _or = _startsWith_1;
        }
        Assert.assertTrue(head, _or);
        Storage2UriMapperJavaImpl.PackageFragmentRootData _value_2 = it.getValue();
        Set<String> _keySet_2 = _value_2.associatedRoots.keySet();
        final String head2 = IterableExtensions.<String>last(_keySet_2);
        boolean _or_1 = false;
        boolean _startsWith_2 = head.startsWith("=testProject/");
        if (_startsWith_2) {
          _or_1 = true;
        } else {
          boolean _startsWith_3 = head.startsWith("=testProject2/");
          _or_1 = _startsWith_3;
        }
        Assert.assertTrue(head2, _or_1);
      }
    }
  }
  
  public IFile createJar(final IJavaProject project) {
    IProject _project = project.getProject();
    IFile _file = _project.getFile("foo.jar");
    final Procedure1<IFile> _function = new Procedure1<IFile>() {
      @Override
      public void apply(final IFile it) {
        try {
          JavaProjectSetupUtil.TextFile _textFile = new JavaProjectSetupUtil.TextFile("foo/bar.indexed", "//empty");
          JavaProjectSetupUtil.TextFile _textFile_1 = new JavaProjectSetupUtil.TextFile("META-INF/MANIFEST.MF", "Manifest-Version: 1.0\nBundle-SymbolicName: hubba.bubba\n");
          InputStream _jarInputStream = JavaProjectSetupUtil.jarInputStream(_textFile, _textFile_1);
          IProgressMonitor _monitor = IResourcesSetupUtil.monitor();
          it.create(_jarInputStream, true, _monitor);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return ObjectExtensions.<IFile>operator_doubleArrow(_file, _function);
  }
  
  public Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData> getCachedPackageFragmentRootData() {
    try {
      Class<? extends Storage2UriMapperJavaImpl> _class = this.storage2UriMapperJava.getClass();
      Field[] _declaredFields = _class.getDeclaredFields();
      final Function1<Field, Boolean> _function = new Function1<Field, Boolean>() {
        @Override
        public Boolean apply(final Field it) {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, "cachedPackageFragmentRootData"));
        }
      };
      Field _findFirst = IterableExtensions.<Field>findFirst(((Iterable<Field>)Conversions.doWrapArray(_declaredFields)), _function);
      final Procedure1<Field> _function_1 = new Procedure1<Field>() {
        @Override
        public void apply(final Field it) {
          it.setAccessible(true);
        }
      };
      Field _doubleArrow = ObjectExtensions.<Field>operator_doubleArrow(_findFirst, _function_1);
      Object _get = _doubleArrow.get(this.storage2UriMapperJava);
      return ((Map<String, Storage2UriMapperJavaImpl.PackageFragmentRootData>) _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
