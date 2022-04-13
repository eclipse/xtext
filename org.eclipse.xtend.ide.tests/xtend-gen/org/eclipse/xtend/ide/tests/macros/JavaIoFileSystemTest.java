/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.macros;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.JavaIOFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
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
      final Procedure1<JavaIOFileSystemSupport> _function = (JavaIOFileSystemSupport it) -> {
        final IProjectConfigProvider _function_1 = (ResourceSet it_1) -> {
          File _file = new File(tempDir, "foo");
          FileProjectConfig _fileProjectConfig = new FileProjectConfig(_file);
          final Procedure1<FileProjectConfig> _function_2 = (FileProjectConfig it_2) -> {
            it_2.addSourceFolder("src");
          };
          return ObjectExtensions.<FileProjectConfig>operator_doubleArrow(_fileProjectConfig, _function_2);
        };
        it.setProjectConfigProvider(_function_1);
        IEncodingProvider.Runtime _runtime = new IEncodingProvider.Runtime();
        it.setEncodingProvider(_runtime);
        XtextResourceSet _xtextResourceSet = new XtextResourceSet();
        it.setContext(_xtextResourceSet);
      };
      JavaIOFileSystemSupport _doubleArrow = ObjectExtensions.<JavaIOFileSystemSupport>operator_doubleArrow(_javaIOFileSystemSupport, _function);
      this.fs = _doubleArrow;
      this.createProject("foo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected Object createProject(final String name) {
    URI _uRI = this.fs.toURI(new Path(name));
    final File file = new File(_uRI);
    file.mkdirs();
    return file;
  }

  @Test
  public void testMakeAndDeleteFolder() {
    final Path someFolder = new Path("/foo/bar");
    final Path someFile = someFolder.append("Foo.txt");
    Assert.assertFalse(this.fs.exists(someFolder));
    Assert.assertFalse(this.fs.isFile(someFolder));
    Assert.assertFalse(this.fs.isFolder(someFolder));
    this.fs.setContents(someFile, "Hello Foo");
    Assert.assertFalse(this.fs.isFile(someFolder));
    Assert.assertTrue(this.fs.isFolder(someFolder));
    Assert.assertTrue(this.fs.exists(someFolder));
    this.fs.delete(someFolder);
    Assert.assertTrue(this.fs.exists(someFolder));
    this.fs.delete(someFile);
    this.fs.delete(someFolder);
    Assert.assertFalse(this.fs.exists(someFolder));
  }

  @Test
  public void testMakeAndDeleteFile() {
    final Path path = new Path("/foo/src/my/pack/Foo.txt");
    Assert.assertFalse(this.fs.exists(path));
    this.fs.setContents(path, "Hello Foo");
    Assert.assertTrue(this.fs.exists(path));
    Assert.assertEquals("Hello Foo", this.fs.getContents(path));
    Assert.assertTrue(this.fs.isFile(path));
    Assert.assertFalse(this.fs.isFolder(path));
    this.fs.delete(path);
    Assert.assertFalse(this.fs.exists(path));
    Assert.assertFalse(this.fs.isFile(path));
    Assert.assertFalse(this.fs.isFolder(path));
  }

  @Test
  public void testModificationStamp_01() {
    try {
      final Path path = new Path("/foo/src/my/pack/Foo.txt");
      Assert.assertEquals(0L, this.fs.getLastModification(path));
      this.fs.setContents(path, "Hello Foo");
      final long mod = this.fs.getLastModification(path);
      Assert.assertEquals("Hello Foo", this.fs.getContents(path));
      Assert.assertEquals(mod, this.fs.getLastModification(path));
      Thread.sleep(1000);
      this.fs.setContents(path, "Hello Foo");
      Assert.assertEquals(mod, this.fs.getLastModification(path));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testModificationStamp_02() {
    try {
      final Path path = new Path("/foo/src/my/pack/Foo.txt");
      Assert.assertEquals(0L, this.fs.getLastModification(path));
      this.fs.setContents(path, "Hello Foo");
      final long mod = this.fs.getLastModification(path);
      Assert.assertEquals("Hello Foo", this.fs.getContents(path));
      Assert.assertEquals(mod, this.fs.getLastModification(path));
      Thread.sleep(1000);
      this.fs.setContents(path, "Hello Bar");
      long _lastModification = this.fs.getLastModification(path);
      boolean _lessThan = (mod < _lastModification);
      Assert.assertTrue(_lessThan);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testGetWorkspaceChildren() {
    final Function1<Path, CharSequence> _function = (Path it) -> {
      return IterableExtensions.join(it.getSegments(), ".");
    };
    Assert.assertEquals(IterableExtensions.join(this.fs.getChildren(Path.ROOT), "[", ", ", "]", _function), 1, IterableExtensions.size(this.fs.getChildren(Path.ROOT)));
  }

  @Test
  public void testGetProjectChildren() {
    final Path projectFolder = new Path("/foo");
    Assert.assertTrue(this.fs.exists(projectFolder));
    int _size = IterableExtensions.size(this.fs.getChildren(projectFolder));
    final int expectedChildrenSize = (_size + 1);
    Path _path = new Path("/foo/Foo.text");
    this.fs.setContents(_path, "Hello Foo");
    Iterable<? extends Path> _children = this.fs.getChildren(projectFolder);
    String _plus = ("" + _children);
    Assert.assertEquals(_plus, expectedChildrenSize, 
      IterableExtensions.size(this.fs.getChildren(projectFolder)));
  }

  @Test
  public void testGetFolderChildren() {
    final Path folder = new Path("/foo/bar");
    Assert.assertFalse(this.fs.exists(folder));
    Path _append = folder.append("Bar.txt");
    this.fs.setContents(_append, "Hello Bar");
    Assert.assertTrue(this.fs.exists(folder));
    Assert.assertEquals(1, IterableExtensions.size(this.fs.getChildren(folder)));
    Path _path = new Path("/foo/bar/Foo.text");
    this.fs.setContents(_path, "Hello Foo");
    Assert.assertEquals(2, IterableExtensions.size(this.fs.getChildren(folder)));
  }

  @Test
  public void testGetFileChildren() {
    final Path file = new Path("/foo/bar/Foo.text");
    Assert.assertFalse(this.fs.exists(file));
    Assert.assertEquals(0, IterableExtensions.size(this.fs.getChildren(file)));
    this.fs.setContents(file, "Hello Foo");
    Assert.assertTrue(this.fs.exists(file));
    Assert.assertEquals(0, IterableExtensions.size(this.fs.getChildren(file)));
  }

  @Test
  public void testGetFileURI() {
    final Path file = new Path("/foo/bar/Foo.text");
    Assert.assertFalse(this.fs.exists(file));
    Assert.assertNotNull(this.fs.toURI(file));
    this.fs.setContents(file, "Hello Foo");
    Assert.assertTrue(this.fs.exists(file));
    this.assertToURI(file, "Hello Foo");
  }

  @Test
  public void testGetFolderURI() {
    final Path path = new Path("/foo/bar");
    Assert.assertFalse(this.fs.exists(path));
    Assert.assertNotNull(this.fs.toURI(path));
    Path _append = path.append("Foo.txt");
    this.fs.setContents(_append, "Hello Foo");
    Assert.assertTrue(this.fs.exists(path));
    Assert.assertNotNull(this.fs.toURI(path));
  }

  @Test
  public void testGetProjectURI() {
    final Path path = new Path("/foo");
    Assert.assertTrue(this.fs.exists(path));
    Assert.assertNotNull(this.fs.toURI(path));
  }

  @Test
  public void testGetWorkspaceURI() {
    final Path path = Path.ROOT;
    Assert.assertTrue(this.fs.exists(path));
    Assert.assertNull(this.fs.toURI(path));
  }

  @Test
  public void testWorkspaceIsFolder() {
    Assert.assertTrue(this.fs.isFolder(Path.ROOT));
  }

  @Test
  public void testWorkspaceIsFile() {
    Assert.assertFalse(this.fs.isFile(Path.ROOT));
  }

  @Test
  public void testGetWorkspaceLastModification() {
    Assert.assertEquals(0L, this.fs.getLastModification(Path.ROOT));
  }

  @Test
  public void testGetWorkspaceCharset() {
    Assert.assertNotNull(this.fs.getCharset(Path.ROOT));
  }

  @Test
  public void testGetWorkspaceContent() {
    try {
      this.fs.getContents(Path.ROOT);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Test
  public void testGetWorkspaceContentAsSteam() {
    try {
      this.fs.getContentsAsStream(Path.ROOT);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Test
  public void testSetWorkspaceContents() {
    try {
      this.fs.setContents(Path.ROOT, "Hello World!");
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Test
  public void testSetWorkspaceContentsAsStream() {
    try {
      byte[] _bytes = "Hello World!".getBytes();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
      this.fs.setContentsAsStream(Path.ROOT, _byteArrayInputStream);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Test
  public void testDeleteWorkspace() {
    Assert.assertTrue(this.fs.exists(Path.ROOT));
    this.fs.delete(Path.ROOT);
    Assert.assertTrue(this.fs.exists(Path.ROOT));
  }

  protected void assertToURI(final Path file, final String expectedContent) {
    final URI uri = this.fs.toURI(file);
    Assert.assertNotNull(uri);
    try {
      final File javaIoFile = new File(uri);
      Assert.assertTrue(javaIoFile.exists());
      long _length = javaIoFile.length();
      final byte[] data = new byte[((int) _length)];
      final FileInputStream fis = new FileInputStream(javaIoFile);
      fis.read(data);
      fis.close();
      String _string = new String(data);
      Assert.assertEquals(expectedContent, _string);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("URI: ");
        _builder.append(uri);
        _builder.append("; ");
        String _message = e.getMessage();
        _builder.append(_message);
        Assert.fail(_builder.toString());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
