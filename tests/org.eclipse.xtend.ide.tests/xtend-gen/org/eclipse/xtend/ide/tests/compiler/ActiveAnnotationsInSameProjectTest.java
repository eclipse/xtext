/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.compiler;

import com.google.inject.Inject;
import java.io.InputStream;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ActiveAnnotationsInSameProjectTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Rule
  public StopwatchRule rule = new StopwatchRule(true);
  
  @After
  public void tearDown() {
    try {
      IProject _project = this.workbenchTestHelper.getProject();
      _project.delete(true, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActiveAnnotationInSameProject() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import otherpack.Annotation");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Annotation class Client {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile type1 = this.workbenchTestHelper.createFile("mypack/Client.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package otherpack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import java.util.List");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.Active");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.CodeGenerationContext");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.TransformationContext");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@Active(Processor)");
      _builder_1.newLine();
      _builder_1.append("annotation Annotation {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Processor extends AbstractClassProcessor {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override doRegisterGlobals(List<? extends ClassDeclaration> annotatedClasses, extension RegisterGlobalsContext context) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("context.registerInterface(\"mypackage.ShouldNotExist\")");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, extension CodeGenerationContext context) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("throw new IllegalStateException(\"Same project, should not be called.\")");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override doTransform(List<? extends MutableClassDeclaration> annotatedClasses, extension TransformationContext context) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("throw new IllegalStateException(\"Same project, should not be called.\")");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile type2 = this.workbenchTestHelper.createFile("otherpack/Annotation.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertHasErrors(type1, "same project");
      IProject _project = type2.getProject();
      final IFile file = _project.getFile("xtend-gen/mypackage/ShouldNotExist.java");
      boolean _exists = file.exists();
      Assert.assertFalse(_exists);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package mypack");
      _builder_2.newLine();
      _builder_2.append("@otherpack.Annotation class Client {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public String foo = \"blabl\"");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_2.toString());
      type1.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      boolean _exists_1 = file.exists();
      Assert.assertFalse(_exists_1);
      this.assertHasErrors(type1, "same project");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActiveAnnotationInDifferentProject() {
    try {
      final IProject annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject", "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", 
        "org.eclipse.xtend.ide.tests.data", "org.junit");
      WorkbenchTestHelper.addExportedPackages(annoProject, "otherpack");
      WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", 
        "org.eclipse.xtend.ide.tests.data", "org.junit", "annotation.project");
      IProject _project = annoProject.getProject();
      _project.getFile("META-IND/MANIFEST.MF");
      Path _path = new Path("/annotation.project/src/otherpack/Annotation.xtend");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package otherpack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.Active");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.CodeGenerationContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(Processor)");
      _builder.newLine();
      _builder.append("annotation Annotation {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Processor extends AbstractClassProcessor {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(List<? extends ClassDeclaration> annotatedClasses, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("context.registerInterface(\"mypackage.ShouldExist\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, extension CodeGenerationContext context) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doTransform(List<? extends MutableClassDeclaration> annotatedClasses, extension TransformationContext context) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      IResourcesSetupUtil.createFile(_path, _builder.toString());
      Path _path_1 = new Path("/client.project/src/mypack/Client.xtend");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import otherpack.Annotation");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@Annotation class Client {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile type1 = IResourcesSetupUtil.createFile(_path_1, _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      IProject _project_1 = type1.getProject();
      final IFile file = _project_1.getFile("xtend-gen/mypackage/ShouldExist.java");
      boolean _exists = file.exists();
      Assert.assertTrue(_exists);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package mypack");
      _builder_2.newLine();
      _builder_2.append("@otherpack.Annotation class Client {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public String foo = \"blabl\"");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_2.toString());
      type1.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      boolean _exists_1 = file.exists();
      Assert.assertTrue(_exists_1);
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActiveAnnotationInSameProjectWithJava() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import otherpack.Annotation");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Annotation class Client {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile type1 = this.workbenchTestHelper.createFile("mypack/Client.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package otherpack;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.macro.Active;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@Active(Processor.class)");
      _builder_1.newLine();
      _builder_1.append("public @interface Annotation {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile type2 = this.workbenchTestHelper.createFile("otherpack/Annotation.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package otherpack;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import java.util.List;");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor;");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.CodeGenerationContext;");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.TransformationContext;");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("public class Processor extends AbstractClassProcessor {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public void doRegisterGlobals(List<? extends ClassDeclaration> annotatedClasses, RegisterGlobalsContext context) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("context.registerInterface(\"mypackage.ShouldNotExist\");");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public void doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, CodeGenerationContext context) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("throw new IllegalStateException(\"Same project, should not be called.\");");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public void doTransform(List<? extends MutableClassDeclaration> annotatedClasses, TransformationContext context) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("throw new IllegalStateException(\"Same project, should not be called.\");");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.workbenchTestHelper.createFile("otherpack/Processor.java", _builder_2.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertHasErrors(type1, "same project");
      IProject _project = type2.getProject();
      final IFile file = _project.getFile("xtend-gen/mypackage/ShouldNotExist.java");
      boolean _exists = file.exists();
      Assert.assertFalse(_exists);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package mypack");
      _builder_3.newLine();
      _builder_3.append("@otherpack.Annotation class Client {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("public String foo = \"blabl\"");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_3.toString());
      type1.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      boolean _exists_1 = file.exists();
      Assert.assertFalse(_exists_1);
      this.assertHasErrors(type1, "same project");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPropertyOfTypeInSameProject() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class TypeA {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("mypack/TypeA.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package otherpack;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import mypack.TypeA;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Client {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("@Property TypeA myTypeA");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void setMyTypeA(TypeA myType) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("_myTypeA = myType");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile type2 = this.workbenchTestHelper.createFile("otherpack/Client.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package otherpack;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import mypack.TypeA;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Client {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("@Property TypeA myTypeA");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def void setMyTypeA(TypeA myType) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("_myTypeA = myType");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_2.toString());
      type2.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActiveAnnotationInSameProjectInJar() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME, "com.google.inject", 
        "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib");
      final IJavaProject project = JavaCore.create(_createPluginProject);
      final IFile jarFile = this.copyFile(project, "Bug414992.jar", "Bug414992.jar");
      JavaProjectSetupUtil.addJarToClasspath(project, jarFile);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import myannotation.Bug414992");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Bug414992 class Client {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("mypack/Client.xtend", _builder.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IFile copyFile(final IJavaProject javaProject, final String srcFile, final String destFile) {
    try {
      IProject _project = javaProject.getProject();
      final IFile file = _project.getFile(destFile);
      final InputStream inputStream = ActiveAnnotationsInSameProjectTest.class.getResourceAsStream(srcFile);
      file.create(inputStream, IResource.FORCE, null);
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertNoErrorsInWorkspace() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      final IMarker[] findMarkers = _root.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      for (final IMarker iMarker : findMarkers) {
        String _message = MarkerUtilities.getMessage(iMarker);
        int _severity = MarkerUtilities.getSeverity(iMarker);
        boolean _equals = (_severity == IMarker.SEVERITY_ERROR);
        Assert.assertFalse(_message, _equals);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertHasErrors(final IFile file, final String msgPart) {
    try {
      final IMarker[] findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      for (final IMarker iMarker : findMarkers) {
        {
          final String message = MarkerUtilities.getMessage(iMarker);
          boolean _and = false;
          int _severity = MarkerUtilities.getSeverity(iMarker);
          boolean _equals = (_severity == IMarker.SEVERITY_ERROR);
          if (!_equals) {
            _and = false;
          } else {
            boolean _contains = message.contains(msgPart);
            _and = _contains;
          }
          if (_and) {
            return;
          }
        }
      }
      IPath _fullPath = file.getFullPath();
      String _plus = ((("Expected an error marker containing \'" + msgPart) + "\' on ") + _fullPath);
      String _plus_1 = (_plus + " but found ");
      final Function1<IMarker,String> _function = new Function1<IMarker,String>() {
        public String apply(final IMarker it) {
          return MarkerUtilities.getMessage(it);
        }
      };
      List<String> _map = ListExtensions.<IMarker, String>map(((List<IMarker>)Conversions.doWrapArray(findMarkers)), _function);
      String _join = IterableExtensions.join(_map, ",");
      String _plus_2 = (_plus_1 + _join);
      Assert.fail(_plus_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
