/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
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
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  @Test
  public void testOpenXtendFileFromBuildPath() {
    try {
      IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject("testProject");
      final IProject project = _createJavaProject.getProject();
      boolean _hasNature = XtextProjectHelper.hasNature(project);
      Assert.assertFalse(_hasNature);
      IFile _createFile = IResourcesSetupUtil.createFile("testProject/src/Foo.xtend", "class Foo {}");
      this.workbenchTestHelper.openEditor(_createFile);
      boolean _hasNature_1 = XtextProjectHelper.hasNature(project);
      Assert.assertTrue(_hasNature_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOpenXtendFileFromFilteredBuildPath() {
    try {
      IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject("testProject");
      final Procedure1<IJavaProject> _function = new Procedure1<IJavaProject>() {
        public void apply(final IJavaProject it) {
          try {
            JavaProjectSetupUtil.addSourceFolder(it, "filtered-src", null, new String[] { "**.xtend" });
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IJavaProject _doubleArrow = ObjectExtensions.<IJavaProject>operator_doubleArrow(_createJavaProject, _function);
      final IProject project = _doubleArrow.getProject();
      boolean _hasNature = XtextProjectHelper.hasNature(project);
      Assert.assertFalse(_hasNature);
      IFile _createFile = IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      this.workbenchTestHelper.openEditor(_createFile);
      boolean _hasNature_1 = XtextProjectHelper.hasNature(project);
      Assert.assertFalse(_hasNature_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOpenXtendFileFromOutOfBuildPath() {
    try {
      IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject("testProject");
      final IProject project = _createJavaProject.getProject();
      boolean _hasNature = XtextProjectHelper.hasNature(project);
      Assert.assertFalse(_hasNature);
      IFile _createFile = IResourcesSetupUtil.createFile("testProject/doc/Foo.xtend", "class Foo {}");
      this.workbenchTestHelper.openEditor(_createFile);
      boolean _hasNature_1 = XtextProjectHelper.hasNature(project);
      Assert.assertFalse(_hasNature_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
