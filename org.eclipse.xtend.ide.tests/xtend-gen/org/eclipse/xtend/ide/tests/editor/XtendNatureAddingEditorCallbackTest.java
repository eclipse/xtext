/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.ui.XtextProjectHelper;
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
public class XtendNatureAddingEditorCallbackTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;

  @After
  @Override
  public void tearDown() throws Exception {
    super.tearDown();
    IResourcesSetupUtil.cleanWorkspace();
  }

  @Test
  public void testOpenXtendFileFromBuildPath() {
    try {
      final IProject project = JavaProjectSetupUtil.createJavaProject("testProject").getProject();
      Assert.assertFalse(XtextProjectHelper.hasNature(project));
      this.workbenchTestHelper.openEditor(IResourcesSetupUtil.createFile("testProject/src/Foo.xtend", "class Foo {}"));
      Assert.assertTrue(XtextProjectHelper.hasNature(project));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenXtendFileFromFilteredBuildPath() {
    try {
      IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject("testProject");
      final Procedure1<IJavaProject> _function = (IJavaProject it) -> {
        try {
          JavaProjectSetupUtil.addSourceFolder(it, "filtered-src", null, new String[] { "**.xtend" });
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final IProject project = ObjectExtensions.<IJavaProject>operator_doubleArrow(_createJavaProject, _function).getProject();
      Assert.assertFalse(XtextProjectHelper.hasNature(project));
      this.workbenchTestHelper.openEditor(IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}"));
      Assert.assertFalse(XtextProjectHelper.hasNature(project));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenXtendFileFromOutOfBuildPath() {
    try {
      final IProject project = JavaProjectSetupUtil.createJavaProject("testProject").getProject();
      Assert.assertFalse(XtextProjectHelper.hasNature(project));
      this.workbenchTestHelper.openEditor(IResourcesSetupUtil.createFile("testProject/doc/Foo.xtend", "class Foo {}"));
      Assert.assertFalse(XtextProjectHelper.hasNature(project));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
