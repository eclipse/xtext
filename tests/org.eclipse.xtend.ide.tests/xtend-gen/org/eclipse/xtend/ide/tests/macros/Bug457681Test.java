/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.macros;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug457681Test {
  @Rule
  public StopwatchRule stopwatch = new StopwatchRule(true);
  
  @After
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  @Test
  public void testDaBug_1() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("macroProject");
      final IJavaProject macroProject = JavaCore.create(_createPluginProject);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package annotation");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.Active");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(MyAAProcessor)");
      _builder.newLine();
      _builder.append("annotation MyAA {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class MyAAProcessor extends AbstractClassProcessor {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if(annotatedClass.extendedClass.declaredSuperTypes.empty) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("annotatedClass.addError(\"Supertype must declare a supertype\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(macroProject, "annotation/MyAA.xtend", _builder.toString());
      this.addExportedPackage(macroProject, "annotation");
      IResourcesSetupUtil.waitForAutoBuild();
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject");
      final IJavaProject userProject = JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package client");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import client.sub.B");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("class A implements Cloneable {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public B sub");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(userProject, "client/A.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package client.sub");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import annotation.MyAA");
      _builder_2.newLine();
      _builder_2.append("import client.A");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@MyAA");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class B extends A {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/sub/B.xtend", _builder_2.toString());
      IResourcesSetupUtil.cleanBuild();
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      IResourcesSetupUtil.waitForBuild(_nullProgressMonitor);
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDaBug_NoAnnotationOnA() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("macroProject");
      final IJavaProject macroProject = JavaCore.create(_createPluginProject);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package annotation");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.Active");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(MyAAProcessor)");
      _builder.newLine();
      _builder.append("annotation MyAA {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class MyAAProcessor extends AbstractClassProcessor {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if(annotatedClass.extendedClass.declaredSuperTypes.empty) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("annotatedClass.addError(\"Supertype must declare a supertype\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(macroProject, "annotation/MyAA.xtend", _builder.toString());
      this.addExportedPackage(macroProject, "annotation");
      IResourcesSetupUtil.waitForAutoBuild();
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject");
      final IJavaProject userProject = JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package client");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import client.sub.B");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class A implements Cloneable {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public B sub");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(userProject, "client/A.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package client.sub");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import annotation.MyAA");
      _builder_2.newLine();
      _builder_2.append("import client.A");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@MyAA");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class B extends A {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/sub/B.xtend", _builder_2.toString());
      IResourcesSetupUtil.cleanBuild();
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      IResourcesSetupUtil.waitForBuild(_nullProgressMonitor);
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IFile newSource(final IJavaProject it, final String fileName, final String contents) {
    try {
      IProject _project = it.getProject();
      final IFile result = _project.getFile(("src/" + fileName));
      IContainer parent = result.getParent();
      while ((!parent.exists())) {
        ((IFolder) parent).create(true, false, null);
      }
      StringInputStream _stringInputStream = new StringInputStream(contents);
      result.create(_stringInputStream, true, null);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void addExportedPackage(final IJavaProject pluginProject, final String... exportedPackages) {
    try {
      IProject _project = pluginProject.getProject();
      final IFile manifestFile = _project.getFile("META-INF/MANIFEST.MF");
      final InputStream manifestContent = manifestFile.getContents();
      Manifest _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = new Manifest(manifestContent);
      } finally {
        manifestContent.close();
      }
      final Manifest manifest = _xtrycatchfinallyexpression;
      final Attributes attrs = manifest.getMainAttributes();
      boolean _containsKey = attrs.containsKey("Export-Package");
      if (_containsKey) {
        Object _get = attrs.get("Export-Package");
        String _plus = (_get + ",");
        String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(exportedPackages)), ",");
        String _plus_1 = (_plus + _join);
        attrs.putValue("Export-Package", _plus_1);
      } else {
        String _join_1 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(exportedPackages)), ",");
        attrs.putValue("Export-Package", _join_1);
      }
      final ByteArrayOutputStream out = new ByteArrayOutputStream();
      manifest.write(out);
      byte[] _byteArray = out.toByteArray();
      final ByteArrayInputStream in = new ByteArrayInputStream(_byteArray);
      BufferedInputStream _bufferedInputStream = new BufferedInputStream(in);
      manifestFile.setContents(_bufferedInputStream, true, true, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
