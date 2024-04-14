/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.validation;

import java.util.Map;
import java.util.Objects;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class UniqueClassNameValidatorUITest extends AbstractXtendUITestCase {
  private IProject first;

  private IProject second;

  @Test
  public void testTwoXtendFilesSameProject() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package acme");
      _builder.newLine();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile firstFile = IResourcesSetupUtil.createFile("first.p384008/src/acme/A.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package acme");
      _builder_1.newLine();
      _builder_1.append("class A {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile secondFile = IResourcesSetupUtil.createFile("first.p384008/src/acme/B.xtend", _builder_1.toString());
      final IWorkspaceRunnable _function = (IProgressMonitor it) -> {
        this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      };
      this.runInWorkspace(_function);
      final IMarker[] firstFileMarkers = firstFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      Assert.assertEquals(IResourcesSetupUtil.printMarker(firstFileMarkers), 1, firstFileMarkers.length);
      Assert.assertEquals("The type A is already defined in B.xtend.", IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(firstFileMarkers))).getAttribute(IMarker.MESSAGE));
      final Iterable<IMarker> secondFileMarkers = this.onlyErrors(((Iterable<IMarker>)Conversions.doWrapArray(secondFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE))));
      Assert.assertEquals(IResourcesSetupUtil.printMarker(((IMarker[])Conversions.unwrapArray(secondFileMarkers, IMarker.class))), 1, ((Object[])Conversions.unwrapArray(secondFileMarkers, Object.class)).length);
      Assert.assertEquals("The type A is already defined in A.xtend.", IterableExtensions.<IMarker>head(secondFileMarkers).getAttribute(IMarker.MESSAGE));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTwoXtendFilesDifferentProject() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package acme");
      _builder.newLine();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile firstFile = IResourcesSetupUtil.createFile("first.p384008/src/acme/A.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package acme");
      _builder_1.newLine();
      _builder_1.append("class A {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile secondFile = IResourcesSetupUtil.createFile("second.p384008/src/acme/B.xtend", _builder_1.toString());
      final IWorkspaceRunnable _function = (IProgressMonitor it) -> {
        this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      };
      this.runInWorkspace(_function);
      final IMarker[] firstFileMarkers = firstFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      Assert.assertEquals(IResourcesSetupUtil.printMarker(firstFileMarkers), 0, firstFileMarkers.length);
      final IMarker[] secondFileMarkers = secondFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      Assert.assertEquals(IResourcesSetupUtil.printMarker(secondFileMarkers), 0, secondFileMarkers.length);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendAndJavaSameProject() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package acme;");
      _builder.newLine();
      _builder.append("public class A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      IResourcesSetupUtil.createFile("first.p384008/src/acme/A.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package acme");
      _builder_1.newLine();
      _builder_1.append("class A {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile secondFile = IResourcesSetupUtil.createFile("first.p384008/src/acme/B.xtend", _builder_1.toString());
      final IWorkspaceRunnable _function = (IProgressMonitor it) -> {
        this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
        this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, JavaCore.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      };
      this.runInWorkspace(_function);
      final Iterable<IMarker> secondFileMarkers = this.onlyErrors(((Iterable<IMarker>)Conversions.doWrapArray(secondFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE))));
      Assert.assertEquals(IResourcesSetupUtil.printMarker(((IMarker[])Conversions.unwrapArray(secondFileMarkers, IMarker.class))), 1, ((Object[])Conversions.unwrapArray(secondFileMarkers, Object.class)).length);
      Assert.assertEquals("The type A is already defined in A.java.", IterableExtensions.<IMarker>head(secondFileMarkers).getAttribute(IMarker.MESSAGE));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendAndJavaDifferentProject() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package acme;");
      _builder.newLine();
      _builder.append("public class A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      IResourcesSetupUtil.createFile("first.p384008/src/acme/A.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package acme");
      _builder_1.newLine();
      _builder_1.append("class A {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile secondFile = IResourcesSetupUtil.createFile("second.p384008/src/acme/B.xtend", _builder_1.toString());
      final IWorkspaceRunnable _function = (IProgressMonitor it) -> {
        this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
        this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, JavaCore.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      };
      this.runInWorkspace(_function);
      final IMarker[] secondFileMarkers = secondFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      Assert.assertEquals(IResourcesSetupUtil.printMarker(secondFileMarkers), 0, secondFileMarkers.length);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Ignore("Since the name acme.A is considered to be derived, it is filtered from the Java delta")
  @Test
  public void testXtendAndJavaSameProjectXtendFirst() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package acme");
      _builder.newLine();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile firstFile = IResourcesSetupUtil.createFile("first.p384008/src/acme/B.xtend", _builder.toString());
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package acme;");
      _builder_1.newLine();
      _builder_1.append("class A2 {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile javaFile = IResourcesSetupUtil.createFile("first.p384008/src/acme/A.java", _builder_1.toString());
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, JavaCore.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      StringInputStream _stringInputStream = new StringInputStream("package acme; class A{}");
      javaFile.setContents(_stringInputStream, false, false, null);
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, JavaCore.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, UniqueClassNameValidatorUITest.emptyStringMap(), null);
      final IMarker[] markers = firstFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      Assert.assertEquals(IResourcesSetupUtil.printMarker(markers), 1, markers.length);
      Assert.assertEquals("The type A is already defined in A.java.", IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(markers))).getAttribute(IMarker.MESSAGE));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private static Map<String, String> emptyStringMap() {
    return CollectionLiterals.<String, String>emptyMap();
  }

  public Iterable<IMarker> onlyErrors(final Iterable<IMarker> markers) {
    final Function1<IMarker, Boolean> _function = (IMarker it) -> {
      try {
        Object _attribute = it.getAttribute(IMarker.SEVERITY);
        return Boolean.valueOf(Objects.equals(Integer.valueOf(IMarker.SEVERITY_ERROR), _attribute));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    return IterableExtensions.<IMarker>filter(markers, _function);
  }

  @Before
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.first = WorkbenchTestHelper.createPluginProject("first.p384008");
    this.second = WorkbenchTestHelper.createPluginProject("second.p384008");
    IResourcesSetupUtil.setReference(this.second, this.first);
  }

  @After
  @Override
  public void tearDown() throws Exception {
    WorkbenchTestHelper.deleteProject(this.first);
    WorkbenchTestHelper.deleteProject(this.second);
  }

  private void runInWorkspace(final IWorkspaceRunnable r) {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      _workspace.run(r, _nullProgressMonitor);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
