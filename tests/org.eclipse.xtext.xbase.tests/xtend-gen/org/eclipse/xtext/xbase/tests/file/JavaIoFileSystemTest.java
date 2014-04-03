/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.file;

import com.google.inject.Provider;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.Map;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.junit4.internal.TemporaryFolder;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.file.JavaIOFileSystemSupport;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaIoFileSystemTest {
  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();
  
  @Extension
  protected MutableFileSystemSupport fs;
  
  @Before
  public void setUp() {
    try {
      final File tempDir = this.temporaryFolder.newFolder();
      JavaIOFileSystemSupport _javaIOFileSystemSupport = new JavaIOFileSystemSupport();
      final Procedure1<JavaIOFileSystemSupport> _function = new Procedure1<JavaIOFileSystemSupport>() {
        public void apply(final JavaIOFileSystemSupport it) {
          final Provider<WorkspaceConfig> _function = new Provider<WorkspaceConfig>() {
            public WorkspaceConfig get() {
              String _absolutePath = tempDir.getAbsolutePath();
              WorkspaceConfig _workspaceConfig = new WorkspaceConfig(_absolutePath);
              final Procedure1<WorkspaceConfig> _function = new Procedure1<WorkspaceConfig>() {
                public void apply(final WorkspaceConfig it) {
                  ProjectConfig _projectConfig = new ProjectConfig("/foo");
                  final Procedure1<ProjectConfig> _function = new Procedure1<ProjectConfig>() {
                    public void apply(final ProjectConfig it) {
                      Map<Path, Path> _sourceFolderMappings = it.getSourceFolderMappings();
                      Path _path = new Path("/foo/src");
                      Path _path_1 = new Path("/foo/xtend-gen");
                      _sourceFolderMappings.put(_path, _path_1);
                    }
                  };
                  ProjectConfig _doubleArrow = ObjectExtensions.<ProjectConfig>operator_doubleArrow(_projectConfig, _function);
                  it.addProjectConfig(_doubleArrow);
                }
              };
              return ObjectExtensions.<WorkspaceConfig>operator_doubleArrow(_workspaceConfig, _function);
            }
          };
          it.setProjectInformationProvider(_function);
          IEncodingProvider.Runtime _runtime = new IEncodingProvider.Runtime();
          it.setEncodingProvider(_runtime);
        }
      };
      JavaIOFileSystemSupport _doubleArrow = ObjectExtensions.<JavaIOFileSystemSupport>operator_doubleArrow(_javaIOFileSystemSupport, _function);
      this.fs = _doubleArrow;
      Path _path = new Path("/foo");
      this.fs.mkdir(_path);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMakeandDeleteFolder() {
    final Path someFolder = new Path("/foo/bar");
    boolean _exists = this.fs.exists(someFolder);
    Assert.assertFalse(_exists);
    boolean _isFile = this.fs.isFile(someFolder);
    Assert.assertFalse(_isFile);
    boolean _isFolder = this.fs.isFolder(someFolder);
    Assert.assertFalse(_isFolder);
    this.fs.mkdir(someFolder);
    boolean _isFile_1 = this.fs.isFile(someFolder);
    Assert.assertFalse(_isFile_1);
    boolean _isFolder_1 = this.fs.isFolder(someFolder);
    Assert.assertTrue(_isFolder_1);
    boolean _exists_1 = this.fs.exists(someFolder);
    Assert.assertTrue(_exists_1);
    this.fs.delete(someFolder);
    boolean _exists_2 = this.fs.exists(someFolder);
    Assert.assertFalse(_exists_2);
  }
  
  @Test
  public void testMakeandDeleteFile() {
    final Path path = new Path("/foo/src/my/pack/Foo.txt");
    boolean _exists = this.fs.exists(path);
    Assert.assertFalse(_exists);
    this.fs.setContents(path, "Hello Foo");
    boolean _exists_1 = this.fs.exists(path);
    Assert.assertTrue(_exists_1);
    CharSequence _contents = this.fs.getContents(path);
    Assert.assertEquals("Hello Foo", _contents);
    boolean _isFile = this.fs.isFile(path);
    Assert.assertTrue(_isFile);
    boolean _isFolder = this.fs.isFolder(path);
    Assert.assertFalse(_isFolder);
    this.fs.delete(path);
    boolean _exists_2 = this.fs.exists(path);
    Assert.assertFalse(_exists_2);
    boolean _isFile_1 = this.fs.isFile(path);
    Assert.assertFalse(_isFile_1);
    boolean _isFolder_1 = this.fs.isFolder(path);
    Assert.assertFalse(_isFolder_1);
  }
  
  @Test
  public void testModificationStamp() {
    try {
      final Path path = new Path("/foo/src/my/pack/Foo.txt");
      long _lastModification = this.fs.getLastModification(path);
      Assert.assertEquals(0L, _lastModification);
      this.fs.setContents(path, "Hello Foo");
      final long mod = this.fs.getLastModification(path);
      CharSequence _contents = this.fs.getContents(path);
      Assert.assertEquals("Hello Foo", _contents);
      long _lastModification_1 = this.fs.getLastModification(path);
      Assert.assertEquals(mod, _lastModification_1);
      Thread.sleep(1000);
      this.fs.setContents(path, "Hello Foo");
      long _lastModification_2 = this.fs.getLastModification(path);
      boolean _lessThan = (mod < _lastModification_2);
      Assert.assertTrue(_lessThan);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGetWorkspaceChildren() {
    Iterable<? extends Path> _children = this.fs.getChildren(Path.ROOT);
    int _size = IterableExtensions.size(_children);
    Assert.assertEquals(1, _size);
    Path _path = new Path("/bar");
    boolean _mkdir = this.fs.mkdir(_path);
    Assert.assertTrue(_mkdir);
    Iterable<? extends Path> _children_1 = this.fs.getChildren(Path.ROOT);
    int _size_1 = IterableExtensions.size(_children_1);
    Assert.assertEquals(2, _size_1);
  }
  
  @Test
  public void testGetProjectChildren() {
    final Path projectFolder = new Path("/foo");
    boolean _exists = this.fs.exists(projectFolder);
    Assert.assertTrue(_exists);
    Iterable<? extends Path> _children = this.fs.getChildren(projectFolder);
    int _size = IterableExtensions.size(_children);
    final int expectedChildrenSize = (_size + 1);
    Path _path = new Path("/foo/Foo.text");
    this.fs.setContents(_path, "Hello Foo");
    Iterable<? extends Path> _children_1 = this.fs.getChildren(projectFolder);
    int _size_1 = IterableExtensions.size(_children_1);
    Assert.assertEquals(expectedChildrenSize, _size_1);
  }
  
  @Test
  public void testGetFolderChildren() {
    final Path folder = new Path("/foo/bar");
    boolean _exists = this.fs.exists(folder);
    Assert.assertFalse(_exists);
    this.fs.mkdir(folder);
    boolean _exists_1 = this.fs.exists(folder);
    Assert.assertTrue(_exists_1);
    Iterable<? extends Path> _children = this.fs.getChildren(folder);
    int _size = IterableExtensions.size(_children);
    Assert.assertEquals(0, _size);
    Path _path = new Path("/foo/bar/Foo.text");
    this.fs.setContents(_path, "Hello Foo");
    Iterable<? extends Path> _children_1 = this.fs.getChildren(folder);
    int _size_1 = IterableExtensions.size(_children_1);
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testGetFileChildren() {
    final Path file = new Path("/foo/bar/Foo.text");
    boolean _exists = this.fs.exists(file);
    Assert.assertFalse(_exists);
    Iterable<? extends Path> _children = this.fs.getChildren(file);
    int _size = IterableExtensions.size(_children);
    Assert.assertEquals(0, _size);
    this.fs.setContents(file, "Hello Foo");
    boolean _exists_1 = this.fs.exists(file);
    Assert.assertTrue(_exists_1);
    Iterable<? extends Path> _children_1 = this.fs.getChildren(file);
    int _size_1 = IterableExtensions.size(_children_1);
    Assert.assertEquals(0, _size_1);
  }
  
  @Test
  public void testGetURI() {
    try {
      final Path file = new Path("/foo/bar/Foo.text");
      boolean _exists = this.fs.exists(file);
      Assert.assertFalse(_exists);
      URI _uRI = this.fs.toURI(file);
      Assert.assertNotNull(_uRI);
      this.fs.setContents(file, "Hello Foo");
      boolean _exists_1 = this.fs.exists(file);
      Assert.assertTrue(_exists_1);
      URI _uRI_1 = this.fs.toURI(file);
      Assert.assertNotNull(_uRI_1);
      URI _uRI_2 = this.fs.toURI(file);
      final File javaIoFile = new File(_uRI_2);
      boolean _exists_2 = javaIoFile.exists();
      Assert.assertTrue(_exists_2);
      long _length = javaIoFile.length();
      final byte[] data = new byte[((int) _length)];
      final FileInputStream fis = new FileInputStream(javaIoFile);
      fis.read(data);
      fis.close();
      String _string = new String(data);
      Assert.assertEquals("Hello Foo", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
