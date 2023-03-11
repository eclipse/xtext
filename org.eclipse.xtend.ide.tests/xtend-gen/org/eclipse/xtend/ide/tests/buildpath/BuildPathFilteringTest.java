/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.buildpath;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuildPathFilteringTest extends AbstractXtendUITestCase {
  @After
  @Override
  public void tearDown() throws Exception {
    super.tearDown();
    IResourcesSetupUtil.cleanWorkspace();
  }

  @Test
  public void testExcludeNoneAndIncludeAll() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
      final Procedure1<IProject> _function = (IProject it) -> {
        try {
          JavaProjectSetupUtil.addSourceFolder(JavaCore.create(it), "filtered-src", null, null);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<IProject>operator_doubleArrow(_createPluginProject, _function);
      IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.waitForBuild();
      Assert.assertNotNull(IResourcesSetupUtil.file("testProject/xtend-gen/Foo.java"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExcludeAllXtendFiles() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
      final Procedure1<IProject> _function = (IProject it) -> {
        try {
          JavaProjectSetupUtil.addSourceFolder(JavaCore.create(it), "filtered-src", null, new String[] { "**.xtend" });
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<IProject>operator_doubleArrow(_createPluginProject, _function);
      IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.waitForBuild();
      Assert.assertNull(IResourcesSetupUtil.file("testProject/xtend-gen/Foo.java"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * <p>
   * We ignore inclusion pattern for now.
   * </p>
   */
  @Test
  public void testIncludeOnlyFooXtendFile() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
      final Procedure1<IProject> _function = (IProject it) -> {
        try {
          JavaProjectSetupUtil.addSourceFolder(JavaCore.create(it), "filtered-src", new String[] { "Foo.xtend" }, null);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<IProject>operator_doubleArrow(_createPluginProject, _function);
      IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.createFile("testProject/filtered-src/Bar.xtend", "class Bar {}");
      IResourcesSetupUtil.createFile("testProject/filtered-src/foo/Foo.xtend", "package foo class Foo {}");
      IResourcesSetupUtil.waitForBuild();
      Assert.assertNotNull(IResourcesSetupUtil.file("testProject/xtend-gen/Foo.java"));
      Assert.assertNotNull(IResourcesSetupUtil.file("testProject/xtend-gen/Bar.java"));
      Assert.assertNotNull(IResourcesSetupUtil.file("testProject/xtend-gen/foo/Foo.java"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExcludeAllFooXtendFiles() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
      final Procedure1<IProject> _function = (IProject it) -> {
        try {
          JavaProjectSetupUtil.addSourceFolder(JavaCore.create(it), "filtered-src", null, new String[] { "**/Foo.xtend" });
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<IProject>operator_doubleArrow(_createPluginProject, _function);
      IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.createFile("testProject/filtered-src/Bar.xtend", "class Bar {}");
      IResourcesSetupUtil.createFile("testProject/filtered-src/foo/Foo.xtend", "package foo class Foo {}");
      IResourcesSetupUtil.waitForBuild();
      Assert.assertNull(IResourcesSetupUtil.file("testProject/xtend-gen/Foo.java"));
      Assert.assertNotNull(IResourcesSetupUtil.file("testProject/xtend-gen/Bar.java"));
      Assert.assertNull(IResourcesSetupUtil.file("testProject/xtend-gen/foo/Foo.java"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
