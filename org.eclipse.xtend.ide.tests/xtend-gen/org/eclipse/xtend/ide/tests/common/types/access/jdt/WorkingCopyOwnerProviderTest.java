/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.common.types.access.jdt;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.access.jdt.WorkingCopyOwnerProvider;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkingCopyOwnerProviderTest extends AbstractXtendUITestCase {
  @Inject
  private WorkingCopyOwnerProvider workingCopyOwnerProvider;
  
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;
  
  private IProject unrelatedProject;
  
  @After
  public void cleanUp() {
    try {
      this.unrelatedProject.delete(true, true, null);
      this.workbenchTestHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Before
  @Override
  public void setUp() {
    try {
      super.setUp();
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("unrelated");
      this.unrelatedProject = _createPluginProject;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWorkingCopyOwner_01() {
    try {
      final IFile file = this.unrelatedProject.getFile("src/foo/MyClass.xtend");
      IPath _fullPath = file.getFullPath();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      IResourcesSetupUtil.createFile(_fullPath, _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      WorkingCopyOwner _newWorkingCopyOwner = this.newWorkingCopyOwner();
      String _findSource = _newWorkingCopyOwner.findSource("MyClass", "foo");
      Assert.assertNull("no source expected as, xtend file is in unrelated project", _findSource);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWorkingCopyOwner_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("foo/MyClass.xtend", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo;");
      _builder_1.newLine();
      _builder_1.append("public class MyClass{");
      _builder_1.newLine();
      _builder_1.append("}");
      String _string = _builder_1.toString();
      WorkingCopyOwner _newWorkingCopyOwner = this.newWorkingCopyOwner();
      String _findSource = _newWorkingCopyOwner.findSource("MyClass", "foo");
      Assert.assertEquals(_string, _findSource);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected WorkingCopyOwner newWorkingCopyOwner() {
    IProject _project = this.workbenchTestHelper.getProject();
    IJavaProject _create = JavaCore.create(_project);
    ResourceSet _resourceSet = this.workbenchTestHelper.getResourceSet();
    return this.workingCopyOwnerProvider.getWorkingCopyOwner(_create, _resourceSet);
  }
}
