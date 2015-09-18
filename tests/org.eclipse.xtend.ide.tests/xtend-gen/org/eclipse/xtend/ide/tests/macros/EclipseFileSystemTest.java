/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.macros;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.Set;
import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.macro.JavaIoFileSystemTest;
import org.eclipse.xtend.ide.macro.EclipseFileSystemSupportImpl;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class EclipseFileSystemTest extends JavaIoFileSystemTest {
  private Set<String> knownProjects = CollectionLiterals.<String>newHashSet();
  
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Inject
  private Provider<EclipseFileSystemSupportImpl> fileSystemSupportProvider;
  
  @Before
  @Override
  public void setUp() {
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot _root = _workspace.getRoot();
    IProject[] _projects = _root.getProjects();
    for (final IProject p : _projects) {
      String _name = p.getName();
      this.knownProjects.add(_name);
    }
    final IProject project = this.createProject("foo");
    final EclipseFileSystemSupportImpl fileSystemSupport = this.fileSystemSupportProvider.get();
    ResourceSet _get = this.resourceSetProvider.get(project);
    fileSystemSupport.setContext(_get);
    this.fs = fileSystemSupport;
  }
  
  @Override
  public IProject createProject(final String name) {
    try {
      IProject _xblockexpression = null;
      {
        IWorkspace _workspace = ResourcesPlugin.getWorkspace();
        final IWorkspaceRoot root = _workspace.getRoot();
        final IProject project = root.getProject(name);
        boolean _exists = project.exists();
        if (_exists) {
          Assert.fail("Project \'foo\' should not exist yet");
        }
        project.create(null);
        project.open(null);
        _xblockexpression = project;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void tearDown() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = _workspace.getRoot();
      IProject[] _projects = root.getProjects();
      for (final IProject p : _projects) {
        String _name = p.getName();
        boolean _remove = this.knownProjects.remove(_name);
        boolean _not = (!_remove);
        if (_not) {
          p.delete(true, null);
        }
      }
      boolean _isEmpty = this.knownProjects.isEmpty();
      Assert.assertTrue(_isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Ignore("PlatformResourceURIHandlerImpl does not allow to delete folders")
  @Override
  public void testMakeAndDeleteFolder() {
    super.testMakeAndDeleteFolder();
  }
  
  @Test
  @Override
  public void testMakeAndDeleteFile() {
    super.testMakeAndDeleteFile();
  }
  
  @Test
  public void testGetURIForImportedProject() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = _workspace.getRoot();
      final ProjectDescription description = new ProjectDescription();
      description.setName("bar");
      IPath _location = root.getLocation();
      IPath _append = _location.append("foo/bar");
      description.setLocation(_append);
      final IProject project = root.getProject("bar");
      project.create(description, null);
      project.open(null);
      final Path file = new Path("/bar/Foo.text");
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
      final File javaIoFile = new File(uri);
      boolean _exists_2 = javaIoFile.exists();
      Assert.assertTrue(_exists_2);
      long _length = javaIoFile.length();
      final byte[] data = new byte[((int) _length)];
      final FileInputStream fis = new FileInputStream(javaIoFile);
      fis.read(data);
      fis.close();
      String _string_1 = new String(data);
      Assert.assertEquals("Hello Foo", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
