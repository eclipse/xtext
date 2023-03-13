/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.macros;

import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JdtBasedProcessorProviderTest {
  @BeforeClass
  public static void createProjects() {
    try {
      TargetPlatformUtil.setTargetPlatform(JdtBasedProcessorProviderTest.class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @After
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }

  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=439925
   */
  @Test
  public void testClassLoaderSeesAllUpstreamProjects() {
    try {
      final IJavaProject macroProject = JavaCore.create(WorkbenchTestHelper.createPluginProject("macroProject"));
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
      _builder.append("val comment = getClass.getClassLoader.loadClass(\"mylib.Lib\").newInstance.toString");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("annotatedClass.docComment = comment");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(macroProject, "annotation/MyAA.xtend", _builder.toString());
      WorkbenchTestHelper.addExportedPackages(macroProject.getProject(), "annotation");
      final IJavaProject libProject = JavaCore.create(WorkbenchTestHelper.createPluginProject("libProject"));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mylib");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Lib {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override String toString() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("return \"HUNKELDUNKEL\"");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(libProject, "mylib/Lib.xtend", _builder_1.toString());
      WorkbenchTestHelper.addExportedPackages(libProject.getProject(), "mylib");
      IResourcesSetupUtil.waitForBuild();
      final IJavaProject userProject = JavaCore.create(
        WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
          "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject", "libProject"));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package client");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@annotation.MyAA");
      _builder_2.newLine();
      _builder_2.append("class SomeClass {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/A.xtend", _builder_2.toString());
      IResourcesSetupUtil.cleanBuild();
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      IResource _file = IResourcesSetupUtil.file("userProject/xtend-gen/client/SomeClass.java");
      final String javaCode = WorkbenchTestHelper.getContentsAsString(((IFile) _file));
      Assert.assertTrue(javaCode.contains("HUNKELDUNKEL"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClassLoaderSeesAllUpstreamProjects_01() {
    try {
      final IJavaProject libProject = JavaCore.create(WorkbenchTestHelper.createPluginProject("libProject"));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mylib");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Lib {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override String toString() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return \"HUNKELDUNKEL\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(libProject, "mylib/Lib.xtend", _builder.toString());
      WorkbenchTestHelper.addExportedPackages(libProject.getProject(), "mylib");
      final IJavaProject macroProject = JavaCore.create(WorkbenchTestHelper.createPluginProject("macroProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "libProject"));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package annotation");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.Active");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.TransformationContext");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@Active(MyAAProcessor)");
      _builder_1.newLine();
      _builder_1.append("annotation MyAA {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class MyAAProcessor extends AbstractClassProcessor {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("annotatedClass.docComment = new mylib.Lib().toString()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(macroProject, "annotation/MyAA.xtend", _builder_1.toString());
      WorkbenchTestHelper.addExportedPackages(macroProject.getProject(), "annotation");
      IResourcesSetupUtil.waitForBuild();
      final IJavaProject userProject = JavaCore.create(
        WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
          "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject"));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package client");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@annotation.MyAA");
      _builder_2.newLine();
      _builder_2.append("class SomeClass {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/A.xtend", _builder_2.toString());
      IResourcesSetupUtil.cleanBuild();
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      IResource _file = IResourcesSetupUtil.file("userProject/xtend-gen/client/SomeClass.java");
      final String javaCode = WorkbenchTestHelper.getContentsAsString(((IFile) _file));
      Assert.assertTrue(javaCode.contains("HUNKELDUNKEL"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private XtendLibClasspathAdder xtendLibs = new XtendLibClasspathAdder();

  private IJavaProject xtendProject(final String name, final IJavaProject... upstreamProjects) {
    try {
      final IJavaProject result = JavaProjectSetupUtil.createJavaProject(name);
      IResourcesSetupUtil.addNature(result.getProject(), XtextProjectHelper.NATURE_ID);
      this.xtendLibs.addLibsToClasspath(result, null);
      final Consumer<IJavaProject> _function = (IJavaProject it) -> {
        try {
          JavaProjectSetupUtil.addToClasspath(result, JavaCore.newProjectEntry(it.getPath(), true));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ((List<IJavaProject>)Conversions.doWrapArray(upstreamProjects)).forEach(_function);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClassLoaderSeesAllDepsFromReferencedProjects() {
    try {
      final IJavaProject libProject = this.xtendProject("libProject");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mylib");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Lib {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override String toString() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return \"HUNKELDUNKEL\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(libProject, "mylib/Lib.xtend", _builder.toString());
      final IJavaProject macroProject = this.xtendProject("macroProject", this.xtendProject("inbetween", libProject));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package annotation");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.Active");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.TransformationContext");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@Active(MyAAProcessor)");
      _builder_1.newLine();
      _builder_1.append("annotation MyAA {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class MyAAProcessor extends AbstractClassProcessor {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("annotatedClass.docComment = new mylib.Lib().toString()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(macroProject, "annotation/MyAA.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForBuild();
      final IJavaProject userProject = this.xtendProject("userProject", macroProject);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package client");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@annotation.MyAA");
      _builder_2.newLine();
      _builder_2.append("class SomeClass {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/A.xtend", _builder_2.toString());
      IResourcesSetupUtil.cleanBuild();
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      IResource _file = IResourcesSetupUtil.file("userProject/xtend-gen/client/SomeClass.java");
      final String javaCode = WorkbenchTestHelper.getContentsAsString(((IFile) _file));
      Assert.assertTrue(javaCode.contains("HUNKELDUNKEL"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClassLoaderDoesNotSeeLocalClasses() {
    try {
      final IJavaProject macroProject = this.xtendProject("macroProject");
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
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Class.forName(\"client.B\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} catch (ClassNotFoundException e) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("annotatedClass.docComment = \'classnotfound\'");
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
      IResourcesSetupUtil.waitForBuild();
      final IJavaProject userProject = this.xtendProject("userProject", macroProject);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package client;");
      _builder_1.newLine();
      _builder_1.append("public class B {}");
      _builder_1.newLine();
      this.newSource(userProject, "client/B.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package client");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@annotation.MyAA");
      _builder_2.newLine();
      _builder_2.append("class SomeClass {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/A.xtend", _builder_2.toString());
      IResourcesSetupUtil.cleanBuild();
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      IResource _file = IResourcesSetupUtil.file("userProject/xtend-gen/client/SomeClass.java");
      final String javaCode = WorkbenchTestHelper.getContentsAsString(((IFile) _file));
      Assert.assertTrue(javaCode.contains("classnotfound"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public IFile newSource(final IJavaProject it, final String fileName, final String contents) {
    try {
      final IFile result = it.getProject().getFile(("src/" + fileName));
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
}
