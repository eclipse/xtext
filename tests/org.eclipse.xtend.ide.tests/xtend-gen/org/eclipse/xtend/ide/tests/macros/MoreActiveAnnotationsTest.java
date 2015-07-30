/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.macros;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class MoreActiveAnnotationsTest {
  @Rule
  public StopwatchRule stopwatch = new StopwatchRule(true);
  
  @After
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  @Test
  public void testBug461761() {
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
      _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
      _builder.newLine();
      _builder.append("import static extension com.google.common.io.Files.append");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(DItemMiniProcessor)");
      _builder.newLine();
      _builder.append("annotation DItemMini {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class DItemMiniProcessor extends AbstractClassProcessor {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("registerClass(annotatedClass.qualifiedName + \"Item\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(macroProject, "annotation/DItemMini.xtend", _builder.toString());
      IProject _project = macroProject.getProject();
      WorkbenchTestHelper.addExportedPackages(_project, "annotation");
      IResourcesSetupUtil.waitForBuild();
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject");
      final IJavaProject userProject = JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package client");
      _builder_1.newLine();
      _builder_1.append("@annotation.DItemMini");
      _builder_1.newLine();
      _builder_1.append("class UserCode{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("UserCodeItem item");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(userProject, "client/UserCode.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug461761_01() {
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
      _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(DItemMiniProcessor)");
      _builder.newLine();
      _builder.append("annotation DItemMini {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String value");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class DItemMiniProcessor extends AbstractClassProcessor {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val suffix = annotatedClass.annotations.head.getValue(\"value\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("registerClass(annotatedClass.qualifiedName + suffix)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(macroProject, "annotation/DItemMini.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package annotation");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class StaticFeatures {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public final static String BAR = \"Bar\"");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public final static String FOOBAR = \"Foo\" + BAR ");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(macroProject, "annotation/StaticFeatures.xtend", _builder_1.toString());
      IProject _project = macroProject.getProject();
      WorkbenchTestHelper.addExportedPackages(_project, "annotation");
      IResourcesSetupUtil.waitForBuild();
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject");
      final IJavaProject userProject = JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package client");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static annotation.StaticFeatures.FOOBAR");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@annotation.DItemMini(FOOBAR)");
      _builder_2.newLine();
      _builder_2.append("class UserCode{");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("UserCodeFooBar item");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/UserCode.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug461761_02() {
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
      _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(DItemMiniProcessor)");
      _builder.newLine();
      _builder.append("annotation DItemMini {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("MyEnum[] enumVals = #[MyEnum.VAL1]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Class<?> someType = MyEnum");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class DItemMiniProcessor extends AbstractClassProcessor {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val suffix = annotatedClass.annotations.head.getValue(\"someType\") as TypeReference");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val enums = annotatedClass.annotations.head.getValue(\"enumVals\") as EnumerationValueDeclaration[]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("registerClass(annotatedClass.qualifiedName + suffix.simpleName + enums.map[simpleName].join)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(macroProject, "annotation/DItemMini.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package annotation");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("enum MyEnum {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("VAL1, VAL2");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(macroProject, "annotation/StaticFeatures.xtend", _builder_1.toString());
      IProject _project = macroProject.getProject();
      WorkbenchTestHelper.addExportedPackages(_project, "annotation");
      IResourcesSetupUtil.waitForBuild();
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject");
      final IJavaProject userProject = JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package client");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import annotation.*");
      _builder_2.newLine();
      _builder_2.append("import static annotation.MyEnum.VAL2");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@DItemMini");
      _builder_2.newLine();
      _builder_2.append("class Defaults {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("DefaultsMyEnumVAL1 field");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@DItemMini(enumVals=#[VAL2, MyEnum.VAL1], someType=typeof(Defaults))");
      _builder_2.newLine();
      _builder_2.append("class Explicit {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("ExplicitDefaultsVAL2VAL1 field");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@DItemMini(someType=Object)");
      _builder_2.newLine();
      _builder_2.append("class Mixed {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("MixedObjectVAL1 field");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/UserCode.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore("It fails because JDT doesn\'t provide annotation values of annotation.MyClass. For some unknown reason the binding is set to null which makes JDT filtering them out.")
  @Test
  public void testBug461761_03() {
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
      _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(DItemMiniProcessor)");
      _builder.newLine();
      _builder.append("annotation DItemMini {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("MyEnum[] enumVals = #[MyEnum.VAL1]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Class<?> someType = MyEnum");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class DItemMiniProcessor extends AbstractClassProcessor {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val annotationRef = (findUpstreamType(\"annotation.MyClass\") as ClassDeclaration).annotations.head");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val suffix = annotationRef.getValue(\"someType\") as TypeReference");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val enums = annotationRef.getValue(\"enumVals\") as EnumerationValueDeclaration[]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("registerClass(annotatedClass.qualifiedName + suffix.simpleName + enums.map[simpleName].join)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(macroProject, "annotation/DItemMini.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package annotation");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("enum MyEnum {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("VAL1, VAL2");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(macroProject, "annotation/StaticFeatures.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package annotation;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static annotation.MyEnum.*;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@DItemMini(enumVals={VAL2, VAL2}, someType=String.class) ");
      _builder_2.newLine();
      _builder_2.append("public class MyClass {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(macroProject, "annotation/MyClass.java", _builder_2.toString());
      IProject _project = macroProject.getProject();
      WorkbenchTestHelper.addExportedPackages(_project, "annotation");
      IResourcesSetupUtil.waitForBuild();
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject");
      final IJavaProject userProject = JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package client");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import annotation.*");
      _builder_3.newLine();
      _builder_3.append("import static annotation.MyEnum.VAL2");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("@DItemMini");
      _builder_3.newLine();
      _builder_3.append("class Processed {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("ProcessedStringVAL2VAL1 field");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.newSource(userProject, "client/UserCode.xtend", _builder_3.toString());
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticInitializers() {
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
      _builder.append("import org.eclipse.xtend.lib.macro.declaration.Visibility");
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
      _builder.append("annotatedClass.addField(\'CONSTANT_INT\') [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("type = primitiveInt");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("visibility = Visibility.PUBLIC");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("constantValueAsInt = 42");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("annotatedClass.addField(\'CONSTANT_LONG\') [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("type = primitiveLong");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("visibility = Visibility.PUBLIC");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("constantValueAsLong = 42");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("annotatedClass.addField(\'CONSTANT_FLOAT\') [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("type = primitiveFloat");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("visibility = Visibility.PUBLIC");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("constantValueAsFloat = 42.34f");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("annotatedClass.addField(\'CONSTANT_DOUBLE\') [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("type = primitiveDouble");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("visibility = Visibility.PUBLIC");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("constantValueAsDouble = 42.11d");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("annotatedClass.addField(\'CONSTANT_CHAR\') [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("type = primitiveChar");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("visibility = Visibility.PUBLIC");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("constantValueAsChar = \'\\n\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("annotatedClass.addField(\'CONSTANT_STRING\') [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("type = string");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("visibility = Visibility.PUBLIC");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("constantValueAsString = \"\\n\\t\\\\all\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.newSource(macroProject, "annotation/MyAA.xtend", _builder.toString());
      IProject _project = macroProject.getProject();
      WorkbenchTestHelper.addExportedPackages(_project, "annotation");
      IResourcesSetupUtil.waitForBuild();
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject");
      final IJavaProject userProject = JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package client");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(client.sub.B.CONSTANT_STRING)");
      _builder_1.newLine();
      _builder_1.append("class A {");
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
      _builder_2.newLine();
      _builder_2.append("@MyAA");
      _builder_2.newLine();
      _builder_2.append("class B {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.newSource(userProject, "client/sub/B.xtend", _builder_2.toString());
      IResourcesSetupUtil.cleanBuild();
      IResourcesSetupUtil.waitForBuild();
      IProject _project_1 = userProject.getProject();
      IResource _findMember = _project_1.findMember("xtend-gen/client/sub/B.java");
      final IFile file = ((IFile) _findMember);
      final String contents = WorkbenchTestHelper.getContentsAsString(file);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package client.sub;");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import annotation.MyAA;");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("@MyAA");
      _builder_3.newLine();
      _builder_3.append("@SuppressWarnings(\"all\")");
      _builder_3.newLine();
      _builder_3.append("public class B {");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("public final static int CONSTANT_INT = 42;");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("public final static long CONSTANT_LONG = 42L;");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("public final static float CONSTANT_FLOAT = 42.34f;");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("public final static double CONSTANT_DOUBLE = 42.11d;");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("public final static char CONSTANT_CHAR = \'\\n\';");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("public final static String CONSTANT_STRING = \"\\n\\t\\\\all\";");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      String _string = _builder_3.toString();
      Assert.assertEquals(_string, contents);
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug473689() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("unrelatedProject");
      final IJavaProject someUnrelatedProject = JavaCore.create(_createPluginProject);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.lib.annotations");
      _builder.newLine();
      _builder.newLine();
      _builder.append("annotation Accessors {}");
      _builder.newLine();
      this.newSource(someUnrelatedProject, "org/eclipse/xtend/lib/annotations/Accessors.xtend", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("macroProject");
      final IJavaProject macroProject = JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mysource");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("@Accessors String name");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void someMethod(Foo foo) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("foo.setName(foo.getName)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.newSource(macroProject, "mysource/Foo.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private IFile newSource(final IJavaProject it, final String fileName, final String contents) {
    try {
      IProject _project = it.getProject();
      final IFile result = _project.getFile(("src/" + fileName));
      IContainer _parent = result.getParent();
      this.createFolder(_parent);
      StringInputStream _stringInputStream = new StringInputStream(contents);
      result.create(_stringInputStream, true, null);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void createFolder(final IContainer container) {
    try {
      boolean _exists = container.exists();
      boolean _not = (!_exists);
      if (_not) {
        IContainer _parent = container.getParent();
        this.createFolder(_parent);
        ((IFolder) container).create(true, false, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
