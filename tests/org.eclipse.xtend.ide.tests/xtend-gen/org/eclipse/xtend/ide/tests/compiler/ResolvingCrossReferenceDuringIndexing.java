/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.compiler;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResolvingCrossReferenceDuringIndexing extends AbstractXtendUITestCase {
  @Test
  public void testResolvingCrossReference() {
    try {
      final IProject annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject", 
        "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.core");
      WorkbenchTestHelper.addExportedPackages(annoProject, "myannotation");
      WorkbenchTestHelper.addExportedPackages(annoProject, "mypackage");
      Path _path = new Path("/annotation.project/src/myannotation/MyAnnotation.xtend");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package myannotation");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.core.macro.declaration.XtendClassDeclarationImpl");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.Active");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.common.types.impl.JvmParameterizedTypeReferenceImpl");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(MyAnnotationProcessor)");
      _builder.newLine();
      _builder.append("annotation MyAnnotation {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class MyAnnotationProcessor extends AbstractClassProcessor {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val xtendClass = (annotatedClass as XtendClassDeclarationImpl).delegate");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (!(xtendClass.extends as JvmParameterizedTypeReferenceImpl).basicGetType.eIsProxy) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("throw new IllegalStateException(\"Before: Type should be a proxy.\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("annotatedClass.extendedClass");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (!(xtendClass.extends as JvmParameterizedTypeReferenceImpl).basicGetType.eIsProxy) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("throw new IllegalStateException(\"After: Type should be a proxy.\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      IResourcesSetupUtil.createFile(_path, _builder.toString());
      Path _path_1 = new Path("/annotation.project/src/mypackage/SuperClass.java");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class SuperClass {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      IResourcesSetupUtil.createFile(_path_1, _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtext.xbase.lib", "annotation.project");
      Path _path_2 = new Path("/client.project/src/mypackage/SuperClass.java");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package mypackage;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("public class SuperClass {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      IResourcesSetupUtil.createFile(_path_2, _builder_2.toString());
      Path _path_3 = new Path("/client.project/src/mypackage/MyClient.xtend");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package mypackage");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import myannotation.MyAnnotation");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("@MyAnnotation");
      _builder_3.newLine();
      _builder_3.append("class MyClient extends SuperClass {");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      IResourcesSetupUtil.createFile(_path_3, _builder_3.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
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
}
