/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor.quickfix;

import com.google.inject.Injector;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.InternalBuilderTest;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.editor.quickfix.WorkbenchMarkerResolutionAdapter;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.editor.quickfix.AbstractQuickfixTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class MultiQuickFixTest extends AbstractQuickfixTest {
  private final static String PROJECT_NAME = "quickfixtest";
  
  private final static String MODEL_FILE = "test.quickfixcrossreftestlanguage";
  
  private final static String MODEL_WITH_WARNINGS = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"no doc\"");
      _builder.newLine();
      _builder.append("Foo { ref Bor }");
      _builder.newLine();
      _builder.append("\"no doc\" Bor { }");
      return _builder.toString();
    }
  }.apply();
  
  private final static String MODEL_WITH_WARNINGS_2 = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"bad doc\"");
      _builder.newLine();
      _builder.append("Foo { ref Bor }");
      _builder.newLine();
      _builder.append("\"bad doc\"");
      _builder.newLine();
      _builder.append("Bor { }");
      return _builder.toString();
    }
  }.apply();
  
  @Test
  public void testMultiIssueResolution() throws Exception {
    final int expectedIssues = 4;
    Injector injector = this.getInjector();
    MarkerResolutionGenerator resolutionGenerator = injector.<MarkerResolutionGenerator>getInstance(MarkerResolutionGenerator.class);
    final XtextEditor xtextEditor = this.newXtextEditor(MultiQuickFixTest.PROJECT_NAME, MultiQuickFixTest.MODEL_FILE, MultiQuickFixTest.MODEL_WITH_WARNINGS_2);
    final IResource resource = xtextEditor.getResource();
    this.closeXtextEditor(xtextEditor);
    IResourcesSetupUtil.addBuilder(resource.getProject(), XtextProjectHelper.BUILDER_ID);
    IResourcesSetupUtil.addNature(resource.getProject(), XtextProjectHelper.NATURE_ID);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("other_");
    _builder.append(MultiQuickFixTest.MODEL_FILE);
    this.createFile(_builder.toString(), MultiQuickFixTest.MODEL_WITH_WARNINGS_2, resource.getProject());
    IMarker[] problems = this.collectMarkers(resource);
    Assert.assertEquals(expectedIssues, problems.length);
    final IMarkerResolution[] resolutions = resolutionGenerator.getResolutions(problems[0]);
    Assert.assertEquals(1, resolutions.length);
    Object _get = resolutions[0];
    Assert.assertTrue((_get instanceof WorkbenchMarkerResolutionAdapter));
    IMarkerResolution _get_1 = resolutions[0];
    final IMarker[] allMarkers = ((WorkbenchMarkerResolutionAdapter) _get_1).findOtherMarkers(problems);
    Assert.assertEquals(expectedIssues, allMarkers.length);
    IMarkerResolution _get_2 = resolutions[0];
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    ((WorkbenchMarkerResolutionAdapter) _get_2).run(allMarkers, _nullProgressMonitor);
    final IMarker[] findMarkers = this.collectMarkers(resource);
    Assert.assertEquals(0, findMarkers.length);
  }
  
  public void closeXtextEditor(final XtextEditor editor) {
    try {
      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, true);
      while ((PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() != null)) {
        {
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(true);
          InputOutput.<String>println("wait for close");
          Thread.sleep(100);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IMarker[] collectMarkers(final IResource resource) {
    try {
      InternalBuilderTest.setAutoBuild(true);
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      final IMarker[] markers = resource.getProject().findMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_INFINITE);
      InternalBuilderTest.setAutoBuild(false);
      return markers;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPreInitializedIssueResolution() throws Exception {
    Injector injector = this.getInjector();
    MarkerResolutionGenerator resolutionGenerator = injector.<MarkerResolutionGenerator>getInstance(MarkerResolutionGenerator.class);
    final XtextEditor xtextEditor = this.newXtextEditor(MultiQuickFixTest.PROJECT_NAME, MultiQuickFixTest.MODEL_FILE, MultiQuickFixTest.MODEL_WITH_WARNINGS);
    final IResource resource = xtextEditor.getResource();
    this.closeXtextEditor(xtextEditor);
    IResourcesSetupUtil.addNature(resource.getProject(), XtextProjectHelper.NATURE_ID);
    IResourcesSetupUtil.addBuilder(resource.getProject(), XtextProjectHelper.BUILDER_ID);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("other_");
    _builder.append(MultiQuickFixTest.MODEL_FILE);
    this.createFile(_builder.toString(), MultiQuickFixTest.MODEL_WITH_WARNINGS, resource.getProject());
    IMarker[] problems = this.collectMarkers(resource);
    Assert.assertEquals(4, problems.length);
    final IMarkerResolution[] resolutions = resolutionGenerator.getResolutions(problems[0]);
    Assert.assertEquals(1, resolutions.length);
    Object _get = resolutions[0];
    Assert.assertTrue((_get instanceof WorkbenchMarkerResolutionAdapter));
    IMarkerResolution _get_1 = resolutions[0];
    final IMarker[] allMarkers = ((WorkbenchMarkerResolutionAdapter) _get_1).findOtherMarkers(problems);
    Assert.assertEquals(4, allMarkers.length);
    IMarkerResolution _get_2 = resolutions[0];
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    ((WorkbenchMarkerResolutionAdapter) _get_2).run(allMarkers, _nullProgressMonitor);
    final IMarker[] findMarkers = this.collectMarkers(resource);
    Assert.assertEquals(0, findMarkers.length);
  }
}
