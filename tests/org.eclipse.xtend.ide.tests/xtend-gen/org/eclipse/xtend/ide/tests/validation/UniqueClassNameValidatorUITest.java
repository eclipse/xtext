/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.validation;

import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
      Map<String, String> _emptyStringMap = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, _emptyStringMap, null);
      final IMarker[] firstFileMarkers = firstFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      String _printMarker = IResourcesSetupUtil.printMarker(firstFileMarkers);
      int _length = firstFileMarkers.length;
      Assert.assertEquals(_printMarker, 1, _length);
      IMarker _head = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(firstFileMarkers)));
      Object _attribute = _head.getAttribute(IMarker.MESSAGE);
      Assert.assertEquals("The type A is already defined in B.xtend.", _attribute);
      final IMarker[] secondFileMarkers = secondFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      String _printMarker_1 = IResourcesSetupUtil.printMarker(secondFileMarkers);
      int _length_1 = secondFileMarkers.length;
      Assert.assertEquals(_printMarker_1, 1, _length_1);
      IMarker _head_1 = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(secondFileMarkers)));
      Object _attribute_1 = _head_1.getAttribute(IMarker.MESSAGE);
      Assert.assertEquals("The type A is already defined in A.xtend.", _attribute_1);
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
      Map<String, String> _emptyStringMap = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, _emptyStringMap, null);
      final IMarker[] firstFileMarkers = firstFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      String _printMarker = IResourcesSetupUtil.printMarker(firstFileMarkers);
      int _length = firstFileMarkers.length;
      Assert.assertEquals(_printMarker, 0, _length);
      final IMarker[] secondFileMarkers = secondFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      String _printMarker_1 = IResourcesSetupUtil.printMarker(secondFileMarkers);
      int _length_1 = secondFileMarkers.length;
      Assert.assertEquals(_printMarker_1, 0, _length_1);
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
      Map<String, String> _emptyStringMap = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, _emptyStringMap, null);
      Map<String, String> _emptyStringMap_1 = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, JavaCore.BUILDER_ID, _emptyStringMap_1, null);
      final IMarker[] secondFileMarkers = secondFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      String _printMarker = IResourcesSetupUtil.printMarker(secondFileMarkers);
      int _length = secondFileMarkers.length;
      Assert.assertEquals(_printMarker, 1, _length);
      IMarker _head = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(secondFileMarkers)));
      Object _attribute = _head.getAttribute(IMarker.MESSAGE);
      Assert.assertEquals("The type A is already defined in A.java.", _attribute);
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
      Map<String, String> _emptyStringMap = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, _emptyStringMap, null);
      Map<String, String> _emptyStringMap_1 = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, JavaCore.BUILDER_ID, _emptyStringMap_1, null);
      final IMarker[] secondFileMarkers = secondFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      String _printMarker = IResourcesSetupUtil.printMarker(secondFileMarkers);
      int _length = secondFileMarkers.length;
      Assert.assertEquals(_printMarker, 0, _length);
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
      Map<String, String> _emptyStringMap = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, _emptyStringMap, null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package acme;");
      _builder_1.newLine();
      _builder_1.append("class A2 {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile javaFile = IResourcesSetupUtil.createFile("first.p384008/src/acme/A.java", _builder_1.toString());
      Map<String, String> _emptyStringMap_1 = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, JavaCore.BUILDER_ID, _emptyStringMap_1, null);
      Map<String, String> _emptyStringMap_2 = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, _emptyStringMap_2, null);
      StringInputStream _stringInputStream = new StringInputStream("package acme; class A{}");
      javaFile.setContents(_stringInputStream, false, false, null);
      Map<String, String> _emptyStringMap_3 = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, JavaCore.BUILDER_ID, _emptyStringMap_3, null);
      Map<String, String> _emptyStringMap_4 = UniqueClassNameValidatorUITest.emptyStringMap();
      this.first.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, XtextBuilder.BUILDER_ID, _emptyStringMap_4, null);
      final IMarker[] markers = firstFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      String _printMarker = IResourcesSetupUtil.printMarker(markers);
      int _length = markers.length;
      Assert.assertEquals(_printMarker, 1, _length);
      IMarker _head = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(markers)));
      Object _attribute = _head.getAttribute(IMarker.MESSAGE);
      Assert.assertEquals("The type A is already defined in A.java.", _attribute);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static Map<String, String> emptyStringMap() {
    return CollectionLiterals.<String, String>emptyMap();
  }
  
  @Before
  @Override
  public void setUp() throws Exception {
    super.setUp();
    IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("first.p384008");
    this.first = _createPluginProject;
    IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("second.p384008");
    this.second = _createPluginProject_1;
    IResourcesSetupUtil.setReference(this.second, this.first);
  }
  
  @After
  @Override
  public void tearDown() throws Exception {
    WorkbenchTestHelper.deleteProject(this.first);
    WorkbenchTestHelper.deleteProject(this.second);
  }
}
