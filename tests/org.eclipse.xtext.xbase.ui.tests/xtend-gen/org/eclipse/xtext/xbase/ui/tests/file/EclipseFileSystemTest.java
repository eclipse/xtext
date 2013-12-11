/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.file;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.file.JavaIoFileSystemTest;
import org.eclipse.xtext.xbase.ui.file.EclipseFileSystemSupportImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseFileSystemTest extends JavaIoFileSystemTest {
  @Before
  public void setUp() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = _workspace.getRoot();
      final IProject project = root.getProject("foo");
      boolean _exists = project.exists();
      if (_exists) {
        project.delete(true, null);
      }
      project.create(null);
      project.open(null);
      EclipseFileSystemSupportImpl _eclipseFileSystemSupportImpl = new EclipseFileSystemSupportImpl();
      final Procedure1<EclipseFileSystemSupportImpl> _function = new Procedure1<EclipseFileSystemSupportImpl>() {
        public void apply(final EclipseFileSystemSupportImpl it) {
          it.setWorkspaceRoot(root);
          IEncodingProvider.Runtime _runtime = new IEncodingProvider.Runtime();
          it.setEncodingProvider(_runtime);
        }
      };
      EclipseFileSystemSupportImpl _doubleArrow = ObjectExtensions.<EclipseFileSystemSupportImpl>operator_doubleArrow(_eclipseFileSystemSupportImpl, _function);
      this.fs = _doubleArrow;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMakeandDeleteFile() {
    super.testMakeandDeleteFile();
  }
  
  @Test
  public void testGetURIForImportedProject() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = _workspace.getRoot();
      ProjectDescription _projectDescription = new ProjectDescription();
      final ProjectDescription description = _projectDescription;
      description.setName("bar");
      IPath _location = root.getLocation();
      IPath _append = _location.append("foo/bar");
      description.setLocation(_append);
      final IProject project = root.getProject("bar");
      project.create(description, null);
      project.open(null);
      Path _path = new Path("/bar/Foo.text");
      final Path file = _path;
      boolean _exists = this.fs.exists(file);
      Assert.assertFalse(_exists);
      URI _uRI = this.fs.toURI(file);
      Assert.assertNotNull(_uRI);
      this.fs.setContents(file, "Hello Foo");
      boolean _exists_1 = this.fs.exists(file);
      Assert.assertTrue(_exists_1);
      final URI uri = this.fs.toURI(file);
      Assert.assertNotNull(uri);
      String _string = uri.toString();
      boolean _endsWith = _string.endsWith("/foo/bar/Foo.text");
      Assert.assertTrue(("" + uri), _endsWith);
      File _file = new File(uri);
      final File javaIoFile = _file;
      boolean _exists_2 = javaIoFile.exists();
      Assert.assertTrue(_exists_2);
      long _length = javaIoFile.length();
      final byte[] data = new byte[((int) _length)];
      FileInputStream _fileInputStream = new FileInputStream(javaIoFile);
      final FileInputStream fis = _fileInputStream;
      fis.read(data);
      fis.close();
      String _string_1 = new String(data);
      Assert.assertEquals("Hello Foo", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
