/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.hover;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.hover.XtendHoverSerializer;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendUnsugaredHoverTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;

  @Inject
  private XtendHoverSerializer serializer;

  private static String FILEEXTENSION = ".xtend";

  private static String FILEPATH = ("testpackage/Foo" + XtendUnsugaredHoverTest.FILEEXTENSION);

  @Before
  public void createExtensionClass() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Extension {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String fieldInExtension");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar(Integer p1, Integer p2)");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def barCharSequence(Integer p1, CharSequence c)");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar(List<String list, Integer a)");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static String setZonk(String s, String s2) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s + s2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    this.testHelper.createFile(("testpackage/Extension" + XtendUnsugaredHoverTest.FILEEXTENSION), _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package testpackage;");
    _builder_1.newLine();
    _builder_1.append("public class ExtensionJava {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void bar(Integer p1, Integer p2){");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    this.testHelper.createFile("testpackage/ExtensionJava.java", _builder_1.toString());
    IResourcesSetupUtil.waitForBuild();
  }

  @After
  public void cleanup() {
    try {
      this.testHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar(42)\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this._extension.bar(it, 42)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar(it, 42)\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this._extension.bar(it, 42)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_3() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val a = 42");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar(it, 42 + a)\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(1);
    Assert.assertEquals("this._extension.bar(it, 42 + a)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_4() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar(it, 40 + 2)\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this._extension.bar(it, 40 + 2)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_5() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ArrayList<String>().bar(42)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this._extension.bar(new ArrayList<String>(), 42)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_6() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar(new ArrayList<String>(), 42)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this._extension.bar(new ArrayList<String>(), 42)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_7() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("barCharSequence(42, ");
    _builder.append("\'\'\'", "\t\t");
    _builder.append("   Test   Test");
    _builder.newLineIfNotEmpty();
    _builder.append("Test");
    _builder.append("\'\'\'");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("this._extension.barCharSequence(42, ");
    _builder_1.append("\'\'\'");
    _builder_1.append("   Test   Test");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("Test");
    _builder_1.append("\'\'\'");
    _builder_1.append(")");
    Assert.assertEquals(_builder_1.toString(), this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_8() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("it.bar(42)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this._extension.bar(it, 42)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_9() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("substring(0)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("it.substring(0)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_10() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val it = \"42\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("substring(0)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(1);
    Assert.assertEquals("it.substring(0)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_11() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ArrayList<String>().head");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("IterableExtensions.head(new ArrayList<String>())", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForXtendFunction_12() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def fooBarBaz(String it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fooBarBaz");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this.fooBarBaz(it)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testUnsuagaredVersionForJava() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension ExtensionJava");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(Integer it){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar(it, 40 + 2)\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this._extensionJava.bar(it, 40 + 2)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testExtensionParameter() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(CharSequence chars) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def bar(extension B a) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"\".foo() ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("a.foo(\"\")", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testBug373054() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import static extension testpackage.Extension.*");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar(){}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String it, String s){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("zonk = s + s + s");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("Extension.setZonk(it, s + s + s)", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testBug414204() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def stuff(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Bar.doStaticStuff()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void doStaticStuff(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(0);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testBug414204_1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import static testpackage.Bar.*");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def stuff(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("doStaticStuff()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void doStaticStuff(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(0);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testBug380361() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import static extension testpackage.Extension.*");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() { 42 }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def client() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo //hover shows \'foo()\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(1);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    Assert.assertEquals("this.foo()", this.serializer.computeUnsugaredExpression(call));
  }

  @Test
  public void testBug380361_1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import static java.lang.Integer.*");
    _builder.newLine();
    _builder.append("import static extension java.lang.String.*");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void foo(String it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("valueOf()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("valueOf(it)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    IResourcesSetupUtil.waitForBuild();
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(0);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    final XExpression call2 = block.getExpressions().get(1);
    Assert.assertEquals("String.valueOf(it)", this.serializer.computeUnsugaredExpression(call));
    Assert.assertEquals("", this.serializer.computeUnsugaredExpression(call2));
  }

  @Test
  public void testBug380361_2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package testpackage");
    _builder.newLine();
    _builder.append("import static extension testpackage.Baz.*");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String fieldInFoo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void foo(Bar it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fieldInBar");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fieldInExtension");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fieldInFoo");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("staticFieldInBaz");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String fieldInBar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Baz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static String staticFieldInBaz");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.testHelper.xtendFile(XtendUnsugaredHoverTest.FILEPATH, _builder.toString());
    XtendMember _get = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers().get(2);
    final XtendFunction function = ((XtendFunction) _get);
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final XExpression call = block.getExpressions().get(0);
    final XExpression call2 = block.getExpressions().get(1);
    final XExpression call3 = block.getExpressions().get(2);
    final XExpression call4 = block.getExpressions().get(3);
    final XtendTypeDeclaration foo = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
    XtendMember _get_1 = foo.getMembers().get(1);
    final XtendField extensionField = ((XtendField) _get_1);
    final JvmTypeReference extensionFieldType = extensionField.getType();
    Assert.assertEquals("testpackage.Extension", extensionFieldType.getIdentifier());
    Assert.assertEquals("it.fieldInBar", this.serializer.computeUnsugaredExpression(call));
    Assert.assertEquals("this._extension.fieldInExtension", this.serializer.computeUnsugaredExpression(call2));
    Assert.assertEquals("this.fieldInFoo", this.serializer.computeUnsugaredExpression(call3));
    Assert.assertEquals("", this.serializer.computeUnsugaredExpression(call4));
  }
}
