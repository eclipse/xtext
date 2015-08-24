/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.eclipse.core.internal.localstore.FileSystemResourceManager;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.impl.AbstractBuilderParticipantTest;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractFSSynchronizationTest extends AbstractBuilderParticipantTest {
  private final static String PROJECT_NAME = "myProject";
  
  private IProject project;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject(AbstractFSSynchronizationTest.PROJECT_NAME);
    IProject _project = _createJavaProject.getProject();
    this.project = _project;
    IResourcesSetupUtil.addNature(this.project, XtextProjectHelper.NATURE_ID);
    IResourcesSetupUtil.reallyWaitForAutoBuild();
  }
  
  @Override
  public void tearDown() throws Exception {
    this.project = null;
    super.tearDown();
  }
  
  @Test
  public void testUpdateFileContent() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testUpdateFileContent(_folder);
  }
  
  @Test
  public void testUpdateFileContentWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testUpdateFileContent(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testUpdateFileContent(final IContainer output) {
    try {
      Path _path = new Path("Foo.txt");
      IFile _file = output.getFile(_path);
      IPath _location = _file.getLocation();
      this.createJavaIoFile(_location, "object Bar");
      IFile _file_1 = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file_1.getFullPath();
      IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      Path _path_1 = new Path("Foo.txt");
      IFile _file_2 = output.getFile(_path_1);
      String _fileToString = IResourcesSetupUtil.fileToString(_file_2);
      Assert.assertEquals("object Foo", _fileToString);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTouchFile() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testTouchFile(_folder);
  }
  
  @Test
  public void testTouchFileWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testTouchFile(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testTouchFile(final IContainer output) {
    try {
      Path _path = new Path("Foo.txt");
      IFile _file = output.getFile(_path);
      IPath _location = _file.getLocation();
      this.createJavaIoFile(_location, "object Foo");
      IFile _file_1 = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file_1.getFullPath();
      IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      Path _path_1 = new Path("Foo.txt");
      IFile _file_2 = output.getFile(_path_1);
      String _fileToString = IResourcesSetupUtil.fileToString(_file_2);
      Assert.assertEquals("object Foo", _fileToString);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCreateFile() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testCreateFile(_folder);
  }
  
  @Test
  public void testCreateFileWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testCreateFile(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testCreateFile(final IContainer output) {
    try {
      IFile _file = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file.getFullPath();
      final IFile file = IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      Path _path = new Path("Foo.txt");
      IFile _file_1 = output.getFile(_path);
      String _fileToString = IResourcesSetupUtil.fileToString(_file_1);
      Assert.assertEquals("object Foo", _fileToString);
      Path _path_1 = new Path("Foo.txt");
      IFile _file_2 = output.getFile(_path_1);
      IPath _location = _file_2.getLocation();
      final File javaIoFile = _location.toFile();
      javaIoFile.delete();
      File _parentFile = javaIoFile.getParentFile();
      _parentFile.delete();
      IProgressMonitor _monitor = IResourcesSetupUtil.monitor();
      file.touch(_monitor);
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      Path _path_2 = new Path("Foo.txt");
      IFile _file_3 = output.getFile(_path_2);
      String _fileToString_1 = IResourcesSetupUtil.fileToString(_file_3);
      Assert.assertEquals("object Foo", _fileToString_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeleteTraceFile() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testDeleteTraceFile(_folder);
  }
  
  @Test
  public void testDeleteTraceFileWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testDeleteTraceFile(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testDeleteTraceFile(final IContainer output) {
    try {
      Path _path = new Path(".Foo.txt._trace");
      IFile _file = output.getFile(_path);
      IPath _location = _file.getLocation();
      final File javaIoFile = this.createJavaIoFile(_location);
      IFile _file_1 = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file_1.getFullPath();
      IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      boolean _exists = javaIoFile.exists();
      Assert.assertFalse(_exists);
      Path _path_1 = new Path(".Foo.txt._trace");
      IFile _file_2 = output.getFile(_path_1);
      boolean _exists_1 = _file_2.exists();
      Assert.assertFalse(_exists_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCleanOutput_01() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setCanClearOutputDirectory(true);
        it.setCleanUpDerivedResources(false);
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        try {
          IFile _file = AbstractFSSynchronizationTest.this.project.getFile("src-gen/Lalala.txt");
          IPath _location = _file.getLocation();
          File _createJavaIoFile = AbstractFSSynchronizationTest.this.createJavaIoFile(_location);
          final File srcGenDirectory = _createJavaIoFile.getParentFile();
          File[] _listFiles = srcGenDirectory.listFiles();
          boolean _isEmpty = ((List<File>)Conversions.doWrapArray(_listFiles)).isEmpty();
          Assert.assertFalse(_isEmpty);
          IFile _file_1 = AbstractFSSynchronizationTest.this.project.getFile(("src/Foo" + AbstractFSSynchronizationTest.this.F_EXT));
          IPath _fullPath = _file_1.getFullPath();
          IResourcesSetupUtil.createFile(_fullPath, "object Foo");
          IResourcesSetupUtil.reallyWaitForAutoBuild();
          File[] _listFiles_1 = srcGenDirectory.listFiles();
          boolean _isEmpty_1 = ((List<File>)Conversions.doWrapArray(_listFiles_1)).isEmpty();
          Assert.assertFalse(_isEmpty_1);
          IResourcesSetupUtil.cleanBuild();
          File[] _listFiles_2 = srcGenDirectory.listFiles();
          boolean _isEmpty_2 = ((List<File>)Conversions.doWrapArray(_listFiles_2)).isEmpty();
          Assert.assertTrue(_isEmpty_2);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanOutput_02() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setCanClearOutputDirectory(true);
        it.setCleanUpDerivedResources(false);
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        try {
          IFolder _folder = AbstractFSSynchronizationTest.this.project.getFolder("src-gen");
          IPath _location = _folder.getLocation();
          final File srcGenDirectory = _location.toFile();
          boolean _exists = srcGenDirectory.exists();
          Assert.assertFalse(_exists);
          IFile _file = AbstractFSSynchronizationTest.this.project.getFile(("src/Foo" + AbstractFSSynchronizationTest.this.F_EXT));
          IPath _fullPath = _file.getFullPath();
          IResourcesSetupUtil.createFile(_fullPath, "object Foo");
          IResourcesSetupUtil.reallyWaitForAutoBuild();
          boolean _exists_1 = srcGenDirectory.exists();
          Assert.assertTrue(_exists_1);
          File[] _listFiles = srcGenDirectory.listFiles();
          boolean _isEmpty = ((List<File>)Conversions.doWrapArray(_listFiles)).isEmpty();
          Assert.assertFalse(_isEmpty);
          IFile _file_1 = AbstractFSSynchronizationTest.this.project.getFile("src-gen/Lalala.txt");
          IPath _location_1 = _file_1.getLocation();
          AbstractFSSynchronizationTest.this.createJavaIoFile(_location_1);
          IResourcesSetupUtil.cleanBuild();
          boolean _exists_2 = srcGenDirectory.exists();
          Assert.assertTrue(_exists_2);
          File[] _listFiles_1 = srcGenDirectory.listFiles();
          boolean _isEmpty_1 = ((List<File>)Conversions.doWrapArray(_listFiles_1)).isEmpty();
          Assert.assertTrue(_isEmpty_1);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
        it.setCanClearOutputDirectory(true);
        it.setCleanUpDerivedResources(false);
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        try {
          IPath _location = AbstractFSSynchronizationTest.this.project.getLocation();
          final File projectDirectory = _location.toFile();
          File[] _listFiles = projectDirectory.listFiles();
          final int initialSize = ((List<File>)Conversions.doWrapArray(_listFiles)).size();
          Assert.assertNotEquals(0, initialSize);
          IFile _file = AbstractFSSynchronizationTest.this.project.getFile(("src/Foo" + AbstractFSSynchronizationTest.this.F_EXT));
          IPath _fullPath = _file.getFullPath();
          IResourcesSetupUtil.createFile(_fullPath, "object Foo");
          IResourcesSetupUtil.reallyWaitForAutoBuild();
          File[] _listFiles_1 = projectDirectory.listFiles();
          final int expectedSize = ((List<File>)Conversions.doWrapArray(_listFiles_1)).size();
          Assert.assertNotEquals(initialSize, expectedSize);
          IResourcesSetupUtil.cleanBuild();
          File[] _listFiles_2 = projectDirectory.listFiles();
          int _size = ((List<File>)Conversions.doWrapArray(_listFiles_2)).size();
          Assert.assertEquals(expectedSize, _size);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanUpDerivedResourcesWithCreateBefore() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testCleanUpDerivedResourcesWithCreateBefore(_folder);
  }
  
  @Test
  public void testCleanUpDerivedResourcesWithCreateBetween() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testCleanUpDerivedResourcesWithCreateBetween(_folder);
  }
  
  @Test
  public void testCleanUpDerivedResourcesWithUpdateDerived() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testCleanUpDerivedResourcesWithUpdateDerived(_folder);
  }
  
  @Test
  public void testCleanUpDerivedResourcesWithDeleteDerived() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testCleanUpDerivedResourcesWithDeleteDerived(_folder);
  }
  
  @Test
  public void testCleanUpProjectDerivedResourcesWithCreateBefore() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testCleanUpDerivedResourcesWithCreateBefore(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanUpProjectDerivedResourcesWithCreateBetween() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testCleanUpDerivedResourcesWithCreateBetween(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanUpProjectDerivedResourcesWithUpdateDerived() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testCleanUpDerivedResourcesWithUpdateDerived(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanUpProjectDerivedResourcesWithDeleteDerived() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testCleanUpDerivedResourcesWithDeleteDerived(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testCleanUpDerivedResourcesWithCreateBefore(final IContainer output) {
    try {
      Path _path = new Path("Lalala.txt");
      IFile _file = output.getFile(_path);
      IPath _location = _file.getLocation();
      File _createJavaIoFile = this.createJavaIoFile(_location);
      final File ouputDirectory = _createJavaIoFile.getParentFile();
      String[] _list = ouputDirectory.list();
      final int expectedSize = ((List<String>)Conversions.doWrapArray(_list)).size();
      IFile _file_1 = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file_1.getFullPath();
      IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      String[] _list_1 = ouputDirectory.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list_1)).size();
      Assert.assertNotEquals(expectedSize, _size);
      IResourcesSetupUtil.cleanBuild();
      String[] _list_2 = ouputDirectory.list();
      int _size_1 = ((List<String>)Conversions.doWrapArray(_list_2)).size();
      Assert.assertEquals(expectedSize, _size_1);
      String[] _list_3 = ouputDirectory.list();
      boolean _contains = ((List<String>)Conversions.doWrapArray(_list_3)).contains("Lalala.txt");
      Assert.assertTrue(_contains);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testCleanUpDerivedResourcesWithCreateBetween(final IContainer output) {
    try {
      IPath _location = output.getLocation();
      final File outputDirectory = _location.toFile();
      int _xifexpression = (int) 0;
      boolean _exists = outputDirectory.exists();
      if (_exists) {
        String[] _list = outputDirectory.list();
        _xifexpression = ((List<String>)Conversions.doWrapArray(_list)).size();
      } else {
        _xifexpression = 0;
      }
      final int initialSize = _xifexpression;
      IFile _file = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file.getFullPath();
      IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      String[] _list_1 = outputDirectory.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list_1)).size();
      Assert.assertNotEquals(initialSize, _size);
      Path _path = new Path("Lalala.txt");
      IFile _file_1 = output.getFile(_path);
      IPath _location_1 = _file_1.getLocation();
      this.createJavaIoFile(_location_1);
      final int expectedSize = (initialSize + 1);
      IResourcesSetupUtil.cleanBuild();
      String[] _list_2 = outputDirectory.list();
      int _size_1 = ((List<String>)Conversions.doWrapArray(_list_2)).size();
      Assert.assertEquals(expectedSize, _size_1);
      String[] _list_3 = outputDirectory.list();
      boolean _contains = ((List<String>)Conversions.doWrapArray(_list_3)).contains("Lalala.txt");
      Assert.assertTrue(_contains);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testCleanUpDerivedResourcesWithUpdateDerived(final IContainer output) {
    try {
      IPath _location = output.getLocation();
      final File outputDirectory = _location.toFile();
      int _xifexpression = (int) 0;
      boolean _exists = outputDirectory.exists();
      if (_exists) {
        String[] _list = outputDirectory.list();
        _xifexpression = ((List<String>)Conversions.doWrapArray(_list)).size();
      } else {
        _xifexpression = 0;
      }
      final int expectedSize = _xifexpression;
      IFile _file = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file.getFullPath();
      IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      String[] _list_1 = outputDirectory.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list_1)).size();
      Assert.assertNotEquals(expectedSize, _size);
      Thread.sleep(1000);
      Path _path = new Path("Foo.txt");
      final IFile file = output.getFile(_path);
      IPath _location_1 = file.getLocation();
      File _file_1 = _location_1.toFile();
      this.setContent(_file_1, "Lalala");
      boolean _isSynchronized = this.isSynchronized(file);
      Assert.assertFalse(_isSynchronized);
      IResourcesSetupUtil.cleanBuild();
      String[] _list_2 = outputDirectory.list();
      int _size_1 = ((List<String>)Conversions.doWrapArray(_list_2)).size();
      Assert.assertEquals(expectedSize, _size_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testCleanUpDerivedResourcesWithDeleteDerived(final IContainer output) {
    try {
      IPath _location = output.getLocation();
      final File outputDirectory = _location.toFile();
      int _xifexpression = (int) 0;
      boolean _exists = outputDirectory.exists();
      if (_exists) {
        String[] _list = outputDirectory.list();
        _xifexpression = ((List<String>)Conversions.doWrapArray(_list)).size();
      } else {
        _xifexpression = 0;
      }
      final int expectedSize = _xifexpression;
      IFile _file = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file.getFullPath();
      IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      String[] _list_1 = outputDirectory.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list_1)).size();
      Assert.assertNotEquals(expectedSize, _size);
      Thread.sleep(1000);
      Path _path = new Path("Foo.txt");
      final IFile file = output.getFile(_path);
      IPath _location_1 = file.getLocation();
      File _file_1 = _location_1.toFile();
      boolean _delete = _file_1.delete();
      Assert.assertTrue(_delete);
      boolean _isSynchronized = this.isSynchronized(file);
      Assert.assertFalse(_isSynchronized);
      IResourcesSetupUtil.cleanBuild();
      String[] _list_2 = outputDirectory.list();
      int _size_1 = ((List<String>)Conversions.doWrapArray(_list_2)).size();
      Assert.assertEquals(expectedSize, _size_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeleteUpdatedDerivedResource() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testDeleteUpdatedDerivedResource(_folder);
  }
  
  @Test
  public void testDeleteUpdatedDerivedResourceWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testDeleteUpdatedDerivedResource(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testDeleteUpdatedDerivedResource(final IContainer output) {
    try {
      IPath _location = output.getLocation();
      final File outputDirectory = _location.toFile();
      int _xifexpression = (int) 0;
      boolean _exists = outputDirectory.exists();
      if (_exists) {
        String[] _list = outputDirectory.list();
        _xifexpression = ((List<String>)Conversions.doWrapArray(_list)).size();
      } else {
        _xifexpression = 0;
      }
      final int expectedSize = _xifexpression;
      IFile _file = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file.getFullPath();
      final IFile sourceFile = IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      String[] _list_1 = outputDirectory.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list_1)).size();
      Assert.assertNotEquals(expectedSize, _size);
      Thread.sleep(1000);
      Path _path = new Path("Foo.txt");
      final IFile file = output.getFile(_path);
      IPath _location_1 = file.getLocation();
      File _file_1 = _location_1.toFile();
      this.setContent(_file_1, "Lalala");
      boolean _isSynchronized = this.isSynchronized(file);
      Assert.assertFalse(_isSynchronized);
      IProgressMonitor _monitor = IResourcesSetupUtil.monitor();
      sourceFile.delete(false, _monitor);
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      String[] _list_2 = outputDirectory.list();
      int _size_1 = ((List<String>)Conversions.doWrapArray(_list_2)).size();
      Assert.assertEquals(expectedSize, _size_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeleteDeletedDerivedResource() {
    IFolder _folder = this.project.getFolder("src-gen");
    this.testDeleteDeletedDerivedResource(_folder);
  }
  
  @Test
  public void testDeleteDeletedDerivedResourceWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      @Override
      public void apply(final OutputConfiguration it) {
        it.setOutputDirectory("./");
      }
    };
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        AbstractFSSynchronizationTest.this.testDeleteDeletedDerivedResource(AbstractFSSynchronizationTest.this.project);
      }
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testDeleteDeletedDerivedResource(final IContainer output) {
    try {
      IPath _location = output.getLocation();
      final File outputDirectory = _location.toFile();
      int _xifexpression = (int) 0;
      boolean _exists = outputDirectory.exists();
      if (_exists) {
        String[] _list = outputDirectory.list();
        _xifexpression = ((List<String>)Conversions.doWrapArray(_list)).size();
      } else {
        _xifexpression = 0;
      }
      final int expectedSize = _xifexpression;
      IFile _file = this.project.getFile(("src/Foo" + this.F_EXT));
      IPath _fullPath = _file.getFullPath();
      final IFile sourceFile = IResourcesSetupUtil.createFile(_fullPath, "object Foo");
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      String[] _list_1 = outputDirectory.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list_1)).size();
      Assert.assertNotEquals(expectedSize, _size);
      Thread.sleep(1000);
      Path _path = new Path("Foo.txt");
      final IFile file = output.getFile(_path);
      IPath _location_1 = file.getLocation();
      File _file_1 = _location_1.toFile();
      boolean _delete = _file_1.delete();
      Assert.assertTrue(_delete);
      boolean _isSynchronized = this.isSynchronized(file);
      Assert.assertFalse(_isSynchronized);
      IProgressMonitor _monitor = IResourcesSetupUtil.monitor();
      sourceFile.delete(false, _monitor);
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      String[] _list_2 = outputDirectory.list();
      int _size_1 = ((List<String>)Conversions.doWrapArray(_list_2)).size();
      Assert.assertEquals(expectedSize, _size_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected File createJavaIoFile(final IPath location, final String content) {
    final File javaIoFile = this.createJavaIoFile(location);
    this.setContent(javaIoFile, content);
    return javaIoFile;
  }
  
  protected File createJavaIoFile(final IPath location) {
    try {
      final File javaIoFile = location.toFile();
      File _parentFile = javaIoFile.getParentFile();
      _parentFile.mkdirs();
      boolean _createNewFile = javaIoFile.createNewFile();
      Assert.assertTrue(_createNewFile);
      return javaIoFile;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void setContent(final File javaIoFile, final String content) {
    try {
      final FileOutputStream fos = new FileOutputStream(javaIoFile);
      byte[] _bytes = content.getBytes();
      fos.write(_bytes);
      fos.flush();
      fos.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean isSynchronized(final IFile file) {
    boolean _xblockexpression = false;
    {
      final org.eclipse.core.internal.resources.File target = ((org.eclipse.core.internal.resources.File) file);
      FileSystemResourceManager _localManager = target.getLocalManager();
      _xblockexpression = _localManager.fastIsSynchronized(target);
    }
    return _xblockexpression;
  }
}
