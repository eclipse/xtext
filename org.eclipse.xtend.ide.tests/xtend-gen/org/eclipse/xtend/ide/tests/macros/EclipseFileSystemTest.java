/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.macros;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.ide.macro.EclipseFileSystemSupportImpl;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
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
    IProject[] _projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    for (final IProject p : _projects) {
      this.knownProjects.add(p.getName());
    }
    final IProject project = this.createProject("foo");
    final EclipseFileSystemSupportImpl fileSystemSupport = this.fileSystemSupportProvider.get();
    fileSystemSupport.setContext(this.resourceSetProvider.get(project));
    this.fs = fileSystemSupport;
  }

  @Override
  public IProject createProject(final String name) {
    try {
      IProject _xblockexpression = null;
      {
        final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
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
      final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      IProject[] _projects = root.getProjects();
      for (final IProject p : _projects) {
        boolean _remove = this.knownProjects.remove(p.getName());
        boolean _not = (!_remove);
        if (_not) {
          p.delete(true, null);
        }
      }
      Assert.assertTrue(this.knownProjects.isEmpty());
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
      final IWorkspace ws = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = ws.getRoot();
      final IProjectDescription description = ws.newProjectDescription("bar");
      description.setLocation(root.getLocation().append("foo/bar"));
      final IProject project = root.getProject("bar");
      project.create(description, null);
      project.open(null);
      final Path file = new Path("/bar/Foo.text");
      Assert.assertFalse(this.fs.exists(file));
      Assert.assertNull(this.fs.toURI(file));
      try {
        this.fs.setContents(file, "Hello Foo");
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Assert.assertFalse(this.fs.exists(file));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIssue383() {
    if ((this.fs instanceof AbstractFileSystemSupport)) {
      final AbstractFileSystemSupport afs = ((AbstractFileSystemSupport)this.fs);
      final IProject px = this.createProject("px");
      this.createProject("py");
      final ResourceSet rs = this.resourceSetProvider.get(px);
      final Resource rx = rs.createResource(URI.createPlatformResourceURI("px/foo/xxxx", true));
      final Resource rxb = rs.createResource(URI.createPlatformResourceURI("px/bar/yyyy", true));
      final Resource ry = rs.createResource(URI.createPlatformResourceURI("py/bar/xxxx", true));
      Path pathx = afs.getPath(rx);
      Assert.assertEquals("/px/foo/xxxx", pathx.toString());
      Path pathxb = afs.getPath(rxb);
      Assert.assertEquals("/px/bar/yyyy", pathxb.toString());
      Path pathy = afs.getPath(ry);
      Assert.assertEquals("/py/bar/xxxx", pathy.toString());
    } else {
      Assert.fail("fs is no AbstractFileSystemSupport");
    }
  }
}
