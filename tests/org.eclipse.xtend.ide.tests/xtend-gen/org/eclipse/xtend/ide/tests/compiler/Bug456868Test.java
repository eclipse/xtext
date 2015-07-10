/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.compiler;

import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge
 * 
 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=456868
 */
@SuppressWarnings("all")
public class Bug456868Test extends AbstractXtendUITestCase {
  @Inject
  private XtendLibClasspathAdder libAdder;
  
  @Inject
  private ToggleXtextNatureAction natureAdder;
  
  private IJavaProject project;
  
  @After
  @Override
  public void tearDown() throws Exception {
    super.tearDown();
    IProject _project = this.project.getProject();
    _project.delete(true, null);
  }
  
  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=452821
   */
  @Test
  public void testProjectWithWhitespaceInNameWorks() {
    try {
      IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject("my project");
      this.project = _createJavaProject;
      JavaProjectSetupUtil.makeJava5Compliant(this.project);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      this.libAdder.addLibsToClasspath(this.project, _nullProgressMonitor);
      IProject _project = this.project.getProject();
      this.natureAdder.toggleNature(_project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      IResourcesSetupUtil.createFile("my project/src/MyClass.xtend", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      final IResource generatedJava = IResourcesSetupUtil.file("my project/xtend-gen/MyClass.java");
      boolean _exists = generatedJava.exists();
      Assert.assertTrue(_exists);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
