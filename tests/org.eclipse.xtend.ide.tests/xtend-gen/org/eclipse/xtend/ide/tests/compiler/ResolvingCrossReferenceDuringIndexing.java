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
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResolvingCrossReferenceDuringIndexing extends AbstractXtendUITestCase {
  @After
  public void tearDown() {
    try {
      IResourcesSetupUtil.cleanWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testResolvingJvmParameterizedTypeReference() {
    try {
      final IProject annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject", 
        "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.core");
      WorkbenchTestHelper.addExportedPackages(annoProject, "myannotation");
      Path _path = new Path("/annotation.project/src/myannotation/MyAnnotation.xtend");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package myannotation");
      _builder.newLine();
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
      _builder.append("import org.eclipse.xtext.xbase.lib.util.ReflectExtensions");
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
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension ReflectExtensions _reflectExtensions = new ReflectExtensions()");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val xtendClass = annotatedClass.invoke(\'getDelegate\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (!(xtendClass.invoke(\'getExtends\').invoke(\'basicGetType\').invoke(\'eIsProxy\') as Boolean)) {");
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
      _builder.append("if (!(xtendClass.invoke(\'getExtends\').invoke(\'basicGetType\').invoke(\'eIsProxy\') as Boolean)) {");
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
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtext.xbase.lib", "annotation.project");
      Path _path_1 = new Path("/client.project/src/mypackage/MyClient.xtend");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import myannotation.MyAnnotation");
      _builder_1.newLine();
      _builder_1.append("import java.util.ArrayList");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@MyAnnotation");
      _builder_1.newLine();
      _builder_1.append("class MyClient extends ArrayList<Object> {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      IResourcesSetupUtil.createFile(_path_1, _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testResolvingXtendAnnotationReference() {
    try {
      final IProject annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject", 
        "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.core", "org.junit");
      WorkbenchTestHelper.addExportedPackages(annoProject, "myannotation");
      Path _path = new Path("/annotation.project/src/myannotation/MyAnnotation.xtend");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package myannotation");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EObject");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.Active");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.xbase.lib.util.ReflectExtensions");
      _builder.newLine();
      _builder.append("import org.junit.Assert");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage.Literals.*");
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
      _builder.append("\t");
      _builder.append("extension ReflectExtensions _reflectExtensions = new ReflectExtensions()");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val annotation = annotatedClass.annotations.head");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val delegate = annotation.invoke(\'getDelegate\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("delegate.assertProxies(\"Before\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Assert.assertNotNull(annotation.annotationTypeDeclaration)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("delegate.assertProxies(\"After\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void assertProxies(Object it, String message) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val type = it.invoke(\'basicGetAnnotationType\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Assert.assertTrue(message + \": Type should be a proxy: \" + it.class.name + \".\", type == null || (type.invoke(\'eIsProxy\') as Boolean))");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      IResourcesSetupUtil.createFile(_path, _builder.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtext.xbase.lib", "annotation.project");
      Path _path_1 = new Path("/client.project/src/mypackage/MyClient.xtend");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import myannotation.MyAnnotation");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@MyAnnotation");
      _builder_1.newLine();
      _builder_1.append("@Deprecated");
      _builder_1.newLine();
      _builder_1.append("class MyClient {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      IResourcesSetupUtil.createFile(_path_1, _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testResolvingXFunctionTypeRef() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Assert.assertNotNull(type)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(1, type.actualTypeArguments.size)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(\"? extends java.util.ArrayList<java.lang.String>\", type.actualTypeArguments.head.name)");
    _builder.newLine();
    this.testResolvingXFunctionTypeRef("=>java.util.ArrayList<String>", _builder.toString());
  }
  
  @Test
  public void testResolvingXFunctionTypeRef_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Assert.assertNotNull(type)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(0, type.actualTypeArguments.size)");
    _builder.newLine();
    this.testResolvingXFunctionTypeRef("=>void", _builder.toString());
  }
  
  @Test
  public void testResolvingXFunctionTypeRef_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Assert.assertNotNull(type)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(1, type.actualTypeArguments.size)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(\"? super java.lang.Integer\", type.actualTypeArguments.head.name)");
    _builder.newLine();
    this.testResolvingXFunctionTypeRef("(int)=>void", _builder.toString());
  }
  
  @Test
  public void testResolvingXFunctionTypeRef_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Assert.assertNotNull(type)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(1, type.actualTypeArguments.size)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(\"? extends java.lang.Integer[]\", type.actualTypeArguments.head.name)");
    _builder.newLine();
    this.testResolvingXFunctionTypeRef("()=>Integer[]", _builder.toString());
  }
  
  @Test
  public void testResolvingXFunctionTypeRef_5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Assert.assertNotNull(type)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(1, type.actualTypeArguments.size)");
    _builder.newLine();
    _builder.append("Assert.assertEquals(\"? extends org.eclipse.xtext.xbase.lib.Functions$Function0<? extends java.util.Map<java.lang.String, java.lang.Boolean>>\", type.actualTypeArguments.head.name)");
    _builder.newLine();
    this.testResolvingXFunctionTypeRef("=>=>java.util.Map<String, Boolean>", _builder.toString());
  }
  
  public void testResolvingXFunctionTypeRef(final String functionType, final String expectations) {
    try {
      final IProject annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject", 
        "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.core", "org.junit");
      WorkbenchTestHelper.addExportedPackages(annoProject, "myannotation");
      Path _path = new Path("/annotation.project/src/myannotation/MyAnnotation.xtend");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package myannotation");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EObject");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.Active");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.common.types.JvmParameterizedTypeReference");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.common.types.JvmTypeReference");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.xtype.XFunctionTypeRef");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl");
      _builder.newLine();
      _builder.append("import org.junit.Assert");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.xbase.lib.util.ReflectExtensions");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.eclipse.xtext.common.types.TypesPackage.Literals.*");
      _builder.newLine();
      _builder.append("import static org.eclipse.xtext.xtype.XtypePackage.Literals.*");
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
      _builder.append("extension ReflectExtensions _reflectExtensions = new ReflectExtensions()");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val declaredField = annotatedClass.declaredFields.head");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val returnType = declaredField.invoke(\'getDelegate\').invoke(\'getType\').invoke(\'getReturnType\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("returnType.assertProxies(\"Before\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val type = declaredField.type");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(expectations, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("returnType.assertProxies(\"After\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void assertProxies(Object it, String message) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val receiver = if (it.getClass.simpleName.contains(\'JvmGenericArrayTypeReference\')) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("it.invoke(\'getComponentType\')");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("it");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val type = receiver.invoke(\'basicGetType\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Assert.assertTrue(message + \": Type should be a proxy: \" + it.class.name + \".\", type == null || (type.invoke(\'eIsProxy\') as Boolean))");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      IResourcesSetupUtil.createFile(_path, _builder.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtext.xbase.lib", "annotation.project");
      Path _path_1 = new Path("/client.project/src/mypackage/MyClient.xtend");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import myannotation.MyAnnotation");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@MyAnnotation");
      _builder_1.newLine();
      _builder_1.append("class MyClient {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("var ");
      _builder_1.append(functionType, "\t");
      _builder_1.append(" function");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      IResourcesSetupUtil.createFile(_path_1, _builder_1.toString());
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
