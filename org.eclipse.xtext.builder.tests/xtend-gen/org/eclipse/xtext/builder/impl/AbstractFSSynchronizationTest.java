/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
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
import org.eclipse.xtext.builder.impl.AbstractBuilderParticipantTest;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractFSSynchronizationTest extends AbstractBuilderParticipantTest {
  private static final String PROJECT_NAME = "myProject";
  
  private IProject project;
  
  @Before
  public void createJavaProject() throws Exception {
    this.project = this.createJavaProject(AbstractFSSynchronizationTest.PROJECT_NAME).getProject();
    this.addNature(this.project, XtextProjectHelper.NATURE_ID);
  }
  
  @After
  public void forgetProject() throws Exception {
    this.project = null;
  }
  
  @Test
  public void testUpdateFileContent() {
    this.testUpdateFileContent(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testUpdateFileContentWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testUpdateFileContent(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testUpdateFileContent(final IContainer output) {
    Path _path = new Path("Foo.txt");
    this.createJavaIoFile(output.getFile(_path).getLocation(), "object Bar");
    this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
    this.build();
    Path _path_1 = new Path("Foo.txt");
    Assert.assertEquals("object Foo", this.readFile(output.getFile(_path_1)));
  }
  
  @Test
  public void testTouchFile() {
    this.testTouchFile(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testTouchFileWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testTouchFile(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testTouchFile(final IContainer output) {
    Path _path = new Path("Foo.txt");
    this.createJavaIoFile(output.getFile(_path).getLocation(), "object Foo");
    this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
    this.build();
    Path _path_1 = new Path("Foo.txt");
    Assert.assertEquals("object Foo", this.readFile(output.getFile(_path_1)));
  }
  
  @Test
  public void testCreateFile() {
    this.testCreateFile(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testCreateFileWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testCreateFile(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testCreateFile(final IContainer output) {
    try {
      final IFile file = this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
      this.build();
      Path _path = new Path("Foo.txt");
      Assert.assertEquals("object Foo", this.readFile(output.getFile(_path)));
      Path _path_1 = new Path("Foo.txt");
      final File javaIoFile = output.getFile(_path_1).getLocation().toFile();
      javaIoFile.delete();
      javaIoFile.getParentFile().delete();
      file.touch(this.monitor());
      this.build();
      Path _path_2 = new Path("Foo.txt");
      Assert.assertEquals("object Foo", this.readFile(output.getFile(_path_2)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeleteTraceFile() {
    this.testDeleteTraceFile(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testDeleteTraceFileWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testDeleteTraceFile(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testDeleteTraceFile(final IContainer output) {
    Path _path = new Path(".Foo.txt._trace");
    final File javaIoFile = this.createJavaIoFile(output.getFile(_path).getLocation());
    this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
    this.build();
    Assert.assertFalse(javaIoFile.exists());
    Path _path_1 = new Path(".Foo.txt._trace");
    Assert.assertFalse(output.getFile(_path_1).exists());
  }
  
  @Test
  public void testCleanOutput_01() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setCanClearOutputDirectory(true);
      it.setCleanUpDerivedResources(false);
    };
    final Procedure0 _function_1 = () -> {
      final File srcGenDirectory = this.createJavaIoFile(this.project.getFile("src-gen/Lalala.txt").getLocation()).getParentFile();
      Assert.assertFalse(((List<File>)Conversions.doWrapArray(srcGenDirectory.listFiles())).isEmpty());
      this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
      this.build();
      Assert.assertFalse(((List<File>)Conversions.doWrapArray(srcGenDirectory.listFiles())).isEmpty());
      this.cleanBuild();
      Assert.assertTrue(((List<File>)Conversions.doWrapArray(srcGenDirectory.listFiles())).isEmpty());
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanOutput_02() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setCanClearOutputDirectory(true);
      it.setCleanUpDerivedResources(false);
    };
    final Procedure0 _function_1 = () -> {
      final File srcGenDirectory = this.project.getFolder("src-gen").getLocation().toFile();
      Assert.assertFalse(srcGenDirectory.exists());
      this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
      this.build();
      Assert.assertTrue(srcGenDirectory.exists());
      Assert.assertFalse(((List<File>)Conversions.doWrapArray(srcGenDirectory.listFiles())).isEmpty());
      this.createJavaIoFile(this.project.getFile("src-gen/Lalala.txt").getLocation());
      this.cleanBuild();
      Assert.assertTrue(srcGenDirectory.exists());
      Assert.assertTrue(((List<File>)Conversions.doWrapArray(srcGenDirectory.listFiles())).isEmpty());
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
      it.setCanClearOutputDirectory(true);
      it.setCleanUpDerivedResources(false);
    };
    final Procedure0 _function_1 = () -> {
      final File projectDirectory = this.project.getLocation().toFile();
      final int initialSize = ((List<File>)Conversions.doWrapArray(projectDirectory.listFiles())).size();
      Assert.assertNotEquals(0, initialSize);
      this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
      this.build();
      final int expectedSize = ((List<File>)Conversions.doWrapArray(projectDirectory.listFiles())).size();
      Assert.assertNotEquals(initialSize, expectedSize);
      this.cleanBuild();
      Assert.assertEquals(expectedSize, ((List<File>)Conversions.doWrapArray(projectDirectory.listFiles())).size());
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanUpDerivedResourcesWithCreateBefore() {
    this.testCleanUpDerivedResourcesWithCreateBefore(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testCleanUpDerivedResourcesWithCreateBetween() {
    this.testCleanUpDerivedResourcesWithCreateBetween(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testCleanUpDerivedResourcesWithUpdateDerived() {
    this.testCleanUpDerivedResourcesWithUpdateDerived(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testCleanUpDerivedResourcesWithDeleteDerived() {
    this.testCleanUpDerivedResourcesWithDeleteDerived(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testCleanUpProjectDerivedResourcesWithCreateBefore() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testCleanUpDerivedResourcesWithCreateBefore(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanUpProjectDerivedResourcesWithCreateBetween() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testCleanUpDerivedResourcesWithCreateBetween(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanUpProjectDerivedResourcesWithUpdateDerived() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testCleanUpDerivedResourcesWithUpdateDerived(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  @Test
  public void testCleanUpProjectDerivedResourcesWithDeleteDerived() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testCleanUpDerivedResourcesWithDeleteDerived(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testCleanUpDerivedResourcesWithCreateBefore(final IContainer output) {
    Path _path = new Path("Lalala.txt");
    final File ouputDirectory = this.createJavaIoFile(output.getFile(_path).getLocation()).getParentFile();
    final int expectedSize = ((List<String>)Conversions.doWrapArray(ouputDirectory.list())).size();
    this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
    this.build();
    Assert.assertNotEquals(expectedSize, ((List<String>)Conversions.doWrapArray(ouputDirectory.list())).size());
    final Runnable _function = () -> {
      this.cleanBuild();
      Assert.assertEquals(expectedSize, ((List<String>)Conversions.doWrapArray(ouputDirectory.list())).size());
      Assert.assertTrue(ArrayExtensions.contains(ouputDirectory.list(), "Lalala.txt"));
    };
    this.disableAutobuild(_function);
  }
  
  protected void testCleanUpDerivedResourcesWithCreateBetween(final IContainer output) {
    final File outputDirectory = output.getLocation().toFile();
    int _xifexpression = (int) 0;
    boolean _exists = outputDirectory.exists();
    if (_exists) {
      _xifexpression = ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size();
    } else {
      _xifexpression = 0;
    }
    final int initialSize = _xifexpression;
    this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
    this.build();
    Assert.assertTrue(outputDirectory.exists());
    Assert.assertNotEquals(initialSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
    final Runnable _function = () -> {
      Path _path = new Path("Lalala.txt");
      this.createJavaIoFile(output.getFile(_path).getLocation());
      final int expectedSize = (initialSize + 1);
      this.cleanBuild();
      Assert.assertEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
      Assert.assertTrue(ArrayExtensions.contains(outputDirectory.list(), "Lalala.txt"));
    };
    this.disableAutobuild(_function);
  }
  
  protected void testCleanUpDerivedResourcesWithUpdateDerived(final IContainer output) {
    final File outputDirectory = output.getLocation().toFile();
    int _xifexpression = (int) 0;
    boolean _exists = outputDirectory.exists();
    if (_exists) {
      _xifexpression = ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size();
    } else {
      _xifexpression = 0;
    }
    final int expectedSize = _xifexpression;
    this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
    this.build();
    Assert.assertNotEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
    final Runnable _function = () -> {
      try {
        Path _path = new Path("Foo.txt");
        final IFile file = output.getFile(_path);
        file.setLocalTimeStamp(1L);
        new WorkspaceJob("file.setContent") {
          @Override
          public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
            File _file = file.getLocation().toFile();
            AbstractFSSynchronizationTest.this.setContent(_file, "Lalala");
            Assert.assertFalse(AbstractFSSynchronizationTest.this.isSynchronized(file));
            return Status.OK_STATUS;
          }
        }.run(this.monitor());
        this.cleanBuild();
        Assert.assertEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this.disableAutobuild(_function);
  }
  
  protected void testCleanUpDerivedResourcesWithDeleteDerived(final IContainer output) {
    final File outputDirectory = output.getLocation().toFile();
    int _xifexpression = (int) 0;
    boolean _exists = outputDirectory.exists();
    if (_exists) {
      _xifexpression = ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size();
    } else {
      _xifexpression = 0;
    }
    final int expectedSize = _xifexpression;
    this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
    this.build();
    Assert.assertNotEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
    final Runnable _function = () -> {
      Path _path = new Path("Foo.txt");
      final IFile file = output.getFile(_path);
      new WorkspaceJob("file.delete") {
        @Override
        public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
          Assert.assertTrue(file.getLocation().toFile().delete());
          Assert.assertFalse(AbstractFSSynchronizationTest.this.isSynchronized(file));
          return Status.OK_STATUS;
        }
      }.run(this.monitor());
      this.cleanBuild();
      Assert.assertEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
    };
    this.disableAutobuild(_function);
  }
  
  @Test
  public void testDeleteUpdatedDerivedResource() {
    this.testDeleteUpdatedDerivedResource(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testDeleteUpdatedDerivedResourceWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testDeleteUpdatedDerivedResource(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testDeleteUpdatedDerivedResource(final IContainer output) {
    try {
      final File outputDirectory = output.getLocation().toFile();
      int _xifexpression = (int) 0;
      boolean _exists = outputDirectory.exists();
      if (_exists) {
        _xifexpression = ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size();
      } else {
        _xifexpression = 0;
      }
      final int expectedSize = _xifexpression;
      final IFile sourceFile = this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
      this.build();
      Assert.assertNotEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
      Path _path = new Path("Foo.txt");
      final IFile file = output.getFile(_path);
      file.setLocalTimeStamp(1L);
      new WorkspaceJob("file.setContent") {
        @Override
        public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
          File _file = file.getLocation().toFile();
          AbstractFSSynchronizationTest.this.setContent(_file, "Lalala");
          Assert.assertFalse(AbstractFSSynchronizationTest.this.isSynchronized(file));
          return Status.OK_STATUS;
        }
      }.run(this.monitor());
      sourceFile.delete(false, this.monitor());
      this.build();
      Assert.assertEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeleteDeletedDerivedResource() {
    this.testDeleteDeletedDerivedResource(this.project.getFolder("src-gen"));
  }
  
  @Test
  public void testDeleteDeletedDerivedResourceWithProjectAsOutput() {
    final Procedure1<OutputConfiguration> _function = (OutputConfiguration it) -> {
      it.setOutputDirectory("./");
    };
    final Procedure0 _function_1 = () -> {
      this.testDeleteDeletedDerivedResource(this.project);
    };
    this.withOutputConfiguration(_function, _function_1);
  }
  
  protected void testDeleteDeletedDerivedResource(final IContainer output) {
    try {
      final File outputDirectory = output.getLocation().toFile();
      int _xifexpression = (int) 0;
      boolean _exists = outputDirectory.exists();
      if (_exists) {
        _xifexpression = ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size();
      } else {
        _xifexpression = 0;
      }
      final int expectedSize = _xifexpression;
      final IFile sourceFile = this.createFile(this.project.getFile(("src/Foo" + this.F_EXT)).getFullPath(), "object Foo");
      this.build();
      Assert.assertNotEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
      Path _path = new Path("Foo.txt");
      final IFile file = output.getFile(_path);
      file.refreshLocal(0, null);
      Assert.assertTrue(this.isSynchronized(file));
      new WorkspaceJob("file.delete") {
        @Override
        public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
          Assert.assertTrue(file.getLocation().toFile().delete());
          Assert.assertFalse(AbstractFSSynchronizationTest.this.isSynchronized(file));
          return Status.OK_STATUS;
        }
      }.run(this.monitor());
      sourceFile.delete(false, this.monitor());
      this.build();
      Assert.assertEquals(expectedSize, ((List<String>)Conversions.doWrapArray(outputDirectory.list())).size());
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
      javaIoFile.getParentFile().mkdirs();
      Assert.assertTrue(javaIoFile.createNewFile());
      return javaIoFile;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void setContent(final File javaIoFile, final String content) {
    try {
      final FileOutputStream fos = new FileOutputStream(javaIoFile);
      fos.write(content.getBytes());
      fos.flush();
      fos.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean isSynchronized(final IFile file) {
    final org.eclipse.core.internal.resources.File target = ((org.eclipse.core.internal.resources.File) file);
    return target.getLocalManager().fastIsSynchronized(target);
  }
}
