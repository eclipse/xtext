/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.performance.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.performance.tests.PerformanceTestProjectSetup;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class PerformanceTest extends AbstractXtendUITestCase {
  @Rule
  public final StopwatchRule rule = new StopwatchRule(true);
  
  @BeforeClass
  public static void createTestProject() {
    try {
      PerformanceTestProjectSetup.setUp();
      IResourcesSetupUtil.waitForAutoBuild();
      PerformanceTest.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @AfterClass
  public static void deleteTestProject() {
    try {
      PerformanceTestProjectSetup.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCleanBuild() throws Exception {
    final IProject project = PerformanceTestProjectSetup.testProject.getProject();
    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
    Stopwatches.resetAll();
    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
  }
  
  @Test
  public void testIncrementalBuild() throws Exception {
    this.internalTestIncrementalBuild();
    this.internalTestIncrementalBuild();
    Stopwatches.resetAll();
    this.internalTestIncrementalBuild();
  }
  
  public void internalTestIncrementalBuild() throws Exception {
    final IProject project = PerformanceTestProjectSetup.testProject.getProject();
    final IFile file = project.getFile("src/org/eclipse/xtext/xbase/formatting/XbaseFormatter2.xtend");
    StringInputStream _stringInputStream = new StringInputStream("//foo\n");
    file.appendContents(_stringInputStream, true, true, null);
    PerformanceTestProjectSetup.waitForAutoBuild();
  }
  
  @Test
  public void testBuildOfDownstreamProject() throws Exception {
    final IJavaProject project = PerformanceTestProjectSetup.testProject;
    final IJavaProject downStreamProject = PerformanceTestProjectSetup.createJavaProject("performance.test.project.downstream", 
      new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature" });
    JavaProjectSetupUtil.addProjectReference(downStreamProject, project);
    ToggleXtextNatureAction _toggleXtextNatureAction = new ToggleXtextNatureAction();
    IProject _project = downStreamProject.getProject();
    _toggleXtextNatureAction.toggleNature(_project);
    final IFolder sourceFolder = JavaProjectSetupUtil.addSourceFolder(downStreamProject, "src");
    JavaProjectSetupUtil.addSourceFolder(downStreamProject, "xtend-gen");
    IFolder _folder = sourceFolder.getFolder("foo");
    _folder.create(true, true, null);
    final IFile sourceFile = sourceFolder.getFile("foo/MyFile.xtend");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.formatting.BasicFormatterPreferenceKeys");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.formatting.FormattableDocument");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.formatting.HiddenLeafAccess");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.formatting.NodeModelAccess");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.formatting.XbaseFormatter2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyFile extends XbaseFormatter2 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def a(BasicFormatterPreferenceKeys keys) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("BasicFormatterPreferenceKeys::indentation");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def b(FormattableDocument doc) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("doc.cfg.get(BasicFormatterPreferenceKeys::indentation)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def c(HiddenLeafAccess x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x.getHiddenLeafsAfter(null).newLines");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def d(NodeModelAccess x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x.nodeForEObject(null).asTreeIterable");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringInputStream _stringInputStream = new StringInputStream(_builder.toString());
    sourceFile.create(_stringInputStream, true, null);
    final IProject p = downStreamProject.getProject();
    p.build(IncrementalProjectBuilder.FULL_BUILD, null);
    p.build(IncrementalProjectBuilder.FULL_BUILD, null);
    Stopwatches.resetAll();
    p.build(IncrementalProjectBuilder.FULL_BUILD, null);
  }
  
  @Test
  public void testFullBuild() throws Exception {
    final IProject project = PerformanceTestProjectSetup.testProject.getProject();
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
    Stopwatches.resetAll();
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
  }
  
  @Test
  public void testCleanFullBuild() throws Exception {
    final IProject project = PerformanceTestProjectSetup.testProject.getProject();
    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
    Stopwatches.resetAll();
    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
  }
  
  protected static void assertNoErrorsInWorkspace() throws CoreException {
    IProject _project = PerformanceTestProjectSetup.testProject.getProject();
    final IMarker[] markers = _project.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
    for (final IMarker marker : markers) {
      String _message = MarkerUtilities.getMessage(marker);
      int _severity = MarkerUtilities.getSeverity(marker);
      boolean _equals = (_severity == IMarker.SEVERITY_ERROR);
      Assert.assertFalse(_message, _equals);
    }
  }
}
