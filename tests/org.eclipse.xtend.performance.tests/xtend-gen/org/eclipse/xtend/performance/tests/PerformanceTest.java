/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.performance.tests;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.performance.tests.PerformanceTestProjectSetup;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
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
  public final static StopwatchRule rule = new Function0<StopwatchRule>() {
    public StopwatchRule apply() {
      StopwatchRule _stopwatchRule = new StopwatchRule(true);
      return _stopwatchRule;
    }
  }.apply();
  
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
  }
  
  @Test
  public void testFullBuild() throws Exception {
    final IProject project = PerformanceTestProjectSetup.testProject.getProject();
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
  }
  
  @Test
  public void testFullBuildAgain() throws Exception {
    final IProject project = PerformanceTestProjectSetup.testProject.getProject();
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
  }
  
  @Test
  public void testCleanBuildTwice() throws Exception {
    final IProject project = PerformanceTestProjectSetup.testProject.getProject();
    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
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
