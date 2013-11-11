/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.buildpath;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuildPathFilteringTest extends AbstractXtendUITestCase {
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  @Test
  public void testExcludeNoneAndIncludeAll() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
      final Procedure1<IProject> _function = new Procedure1<IProject>() {
        public void apply(final IProject it) {
          try {
            IJavaProject _create = JavaCore.create(it);
            JavaProjectSetupUtil.addSourceFolder(_create, "filtered-src", null, null);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<IProject>operator_doubleArrow(_createPluginProject, _function);
      IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.waitForAutoBuild();
      IResource _file = IResourcesSetupUtil.file("testProject/xtend-gen/Foo.java");
      Assert.assertNotNull(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExcludeAllXtendFiles() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
      final Procedure1<IProject> _function = new Procedure1<IProject>() {
        public void apply(final IProject it) {
          try {
            IJavaProject _create = JavaCore.create(it);
            JavaProjectSetupUtil.addSourceFolder(_create, "filtered-src", null, new String[] { "**.xtend" });
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<IProject>operator_doubleArrow(_createPluginProject, _function);
      IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.waitForAutoBuild();
      IResource _file = IResourcesSetupUtil.file("testProject/xtend-gen/Foo.java");
      Assert.assertNull(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeOnlyFooXtendFile() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
      final Procedure1<IProject> _function = new Procedure1<IProject>() {
        public void apply(final IProject it) {
          try {
            IJavaProject _create = JavaCore.create(it);
            JavaProjectSetupUtil.addSourceFolder(_create, "filtered-src", new String[] { "Foo.xtend" }, null);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<IProject>operator_doubleArrow(_createPluginProject, _function);
      IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.createFile("testProject/filtered-src/Bar.xtend", "class Bar {}");
      IResourcesSetupUtil.createFile("testProject/filtered-src/foo/Foo.xtend", "package foo class Foo {}");
      IResourcesSetupUtil.waitForAutoBuild();
      IResource _file = IResourcesSetupUtil.file("testProject/xtend-gen/Foo.java");
      Assert.assertNotNull(_file);
      IResource _file_1 = IResourcesSetupUtil.file("testProject/xtend-gen/Bar.java");
      Assert.assertNull(_file_1);
      IResource _file_2 = IResourcesSetupUtil.file("testProject/xtend-gen/foo/Foo.java");
      Assert.assertNull(_file_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExcludeAllFooXtendFiles() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
      final Procedure1<IProject> _function = new Procedure1<IProject>() {
        public void apply(final IProject it) {
          try {
            IJavaProject _create = JavaCore.create(it);
            JavaProjectSetupUtil.addSourceFolder(_create, "filtered-src", null, new String[] { "**/Foo.xtend" });
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<IProject>operator_doubleArrow(_createPluginProject, _function);
      IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.createFile("testProject/filtered-src/Bar.xtend", "class Bar {}");
      IResourcesSetupUtil.createFile("testProject/filtered-src/foo/Foo.xtend", "package foo class Foo {}");
      IResourcesSetupUtil.waitForAutoBuild();
      IResource _file = IResourcesSetupUtil.file("testProject/xtend-gen/Foo.java");
      Assert.assertNull(_file);
      IResource _file_1 = IResourcesSetupUtil.file("testProject/xtend-gen/Bar.java");
      Assert.assertNotNull(_file_1);
      IResource _file_2 = IResourcesSetupUtil.file("testProject/xtend-gen/foo/Foo.java");
      Assert.assertNull(_file_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
