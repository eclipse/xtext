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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class OpenTargetWithMultipleSourcesTestCase extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;
  
  private IProject testProject;
  
  @Test
  public void testOpenTargetSourceTwice() {
    try {
      IResource _file = IResourcesSetupUtil.file("testProject/xtend-gen/mypackage/B.java");
      final IFile childFile = ((IFile) _file);
      XtextEditor _openEditor = this._workbenchTestHelper.openEditor(childFile);
      XtextEditor _openEditor_1 = this._workbenchTestHelper.openEditor(childFile);
      Assert.assertEquals(_openEditor, _openEditor_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOpenTargetSourceWithOpenedParentSource() {
    try {
      IResource _file = IResourcesSetupUtil.file("testProject/xtend-gen/mypackage/A.java");
      final IFile parenFile = ((IFile) _file);
      IResource _file_1 = IResourcesSetupUtil.file("testProject/xtend-gen/mypackage/B.java");
      final IFile childFile = ((IFile) _file_1);
      XtextEditor _openEditor = this._workbenchTestHelper.openEditor(parenFile);
      XtextEditor _openEditor_1 = this._workbenchTestHelper.openEditor(childFile);
      Assert.assertNotSame(_openEditor, _openEditor_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Before
  @Override
  public void setUp() throws Exception {
    super.setUp();
    IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("testProject");
    this.testProject = _createPluginProject;
    Path _path = new Path("testProject/src/mypackage/A.xtend");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage; ");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch foo(Object it) {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch foo(Void it) {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    IResourcesSetupUtil.createFile(_path, _builder.toString());
    Path _path_1 = new Path("testProject/src/mypackage/B.xtend");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage; ");
    _builder_1.newLine();
    _builder_1.append("class B extends A {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def dispatch foo(String it) {}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    IResourcesSetupUtil.createFile(_path_1, _builder_1.toString());
    IResourcesSetupUtil.waitForBuild();
  }
  
  @After
  @Override
  public void tearDown() throws Exception {
    WorkbenchTestHelper.deleteProject(this.testProject);
    this.testProject = null;
  }
}
