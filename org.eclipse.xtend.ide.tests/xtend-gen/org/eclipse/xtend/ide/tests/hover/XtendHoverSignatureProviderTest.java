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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.hover.XtendHoverSignatureProvider;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendHoverSignatureProviderTest extends AbstractXtendUITestCase {
  @Inject
  private ParseHelper<XtendFile> parseHelper;

  @Inject
  private WorkbenchTestHelper testHelper;

  @Inject
  private XtendHoverSignatureProvider signatureProvider;

  @Test
  public void testSignatureForXtendClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      final String signature = this.signatureProvider.getSignature(clazz);
      Assert.assertEquals("Foo", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForXtendFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a) throws NullPointerException { }");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(String a, int b) throws NullPointerException, RuntimeException {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      final XtendMember xtendFunction1 = clazz.getMembers().get(0);
      final XtendMember xtendFunction2 = clazz.getMembers().get(1);
      final String signature1 = this.signatureProvider.getSignature(xtendFunction1);
      final String signature2 = this.signatureProvider.getSignature(xtendFunction2);
      Assert.assertEquals("Object bar(String a) throws NullPointerException", signature1);
      Assert.assertEquals("void bar(String a, int b) throws NullPointerException, RuntimeException", signature2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForXtendParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a) throws NullPointerException");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      final XtendParameter xtendParameter = xtendFunction.getParameters().get(0);
      final String signature = this.signatureProvider.getSignature(xtendParameter);
      Assert.assertEquals("String a - bar(String)", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForXtendField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Inject");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Collections collections");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a) throws NullPointerException");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("Collections collections", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForXtendFieldWithoutTypeDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val collections = <String>newArrayList");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("ArrayList<String> collections", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForAnonymousClassLocalVarTypeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val r = new Runnable { override run() {} }");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("r");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction function = ((XtendFunction) _get);
      XExpression _expression = function.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head = IterableExtensions.<XExpression>head(body.getExpressions());
      final XVariableDeclaration variable = ((XVariableDeclaration) _head);
      final String signature = this.signatureProvider.getSignature(variable);
      Assert.assertEquals("new Runnable(){} r", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForAnonymousClassLocalVarTypeTest_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val r = new Runnable { override run() {} def void m() {} }");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("r");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction function = ((XtendFunction) _get);
      XExpression _expression = function.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head = IterableExtensions.<XExpression>head(body.getExpressions());
      final XVariableDeclaration variable = ((XVariableDeclaration) _head);
      final String signature = this.signatureProvider.getSignature(variable);
      Assert.assertEquals("new Runnable(){} r", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForAnonymousClassLocalVarTypeTest_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val r = newArrayList(new Runnable { override run() {} })");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("r");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction function = ((XtendFunction) _get);
      XExpression _expression = function.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head = IterableExtensions.<XExpression>head(body.getExpressions());
      final XVariableDeclaration variable = ((XVariableDeclaration) _head);
      final String signature = this.signatureProvider.getSignature(variable);
      Assert.assertEquals("ArrayList<new Runnable(){}> r", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForAnonymousClassFieldTypeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val r = new Runnable { override run() {} }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("Runnable r", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForExtensionFieldWithoutName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension String");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("String", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForXtendFieldWithoutNameOrType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val = \"\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForXtendConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(String a, int b){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      final XtendMember xtendConstructor = clazz.getMembers().get(0);
      final String signature = this.signatureProvider.getSignature(xtendConstructor);
      Assert.assertEquals("Foo(String a, int b)", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForXtendDefaultConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Foo()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      final String signature = this.signatureProvider.getSignature(constructorCall.getConstructor());
      Assert.assertEquals("Foo()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDeclarationOfClazzWithGenrics() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<T,Y> {}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      final String signature = this.signatureProvider.getSignature(clazz);
      Assert.assertEquals("Foo<T, Y>", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureXtendConstructorWithGenerics_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      final String signature = this.signatureProvider.getSignature(constructorCall.getConstructor());
      Assert.assertEquals("Foo<S extends CharSequence>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureConstructorCall_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      final String signature = this.signatureProvider.getSignature(constructorCall);
      Assert.assertEquals("Foo<CharSequence>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureConstructorCall_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(StringBuilder, StringBuffer)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new <X>(Class<X> c, Class<S> c2) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      final String signature = this.signatureProvider.getSignature(constructorCall);
      Assert.assertEquals("<StringBuilder> Foo<StringBuffer>(Class<StringBuilder> c, Class<StringBuffer> c2)", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureConstructorCall_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo<String>()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      final String signature = this.signatureProvider.getSignature(constructorCall);
      Assert.assertEquals("Foo<String>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Ignore
  @Test
  public void testSignatureDelegateConstructorCall_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(int i) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendConstructor xtendConstructor = ((XtendConstructor) _get);
      XExpression _expression = xtendConstructor.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final XFeatureCall featureCall = ((XFeatureCall) _get_1);
      final String signature = this.signatureProvider.getSignature(featureCall);
      Assert.assertEquals("Foo<S>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Ignore
  @Test
  public void testSignatureDelegateConstructorCall_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(int i) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this(StringBuilder)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new<X>(Class<X> c) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendConstructor xtendConstructor = ((XtendConstructor) _get);
      XExpression _expression = xtendConstructor.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final XFeatureCall featureCall = ((XFeatureCall) _get_1);
      final String signature = this.signatureProvider.getSignature(featureCall);
      Assert.assertEquals("Foo<S>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForForLoopVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def bar(List<String> list){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("for(foo : list){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final JvmFormalParameter param = ((XForLoopExpression) _get_1).getDeclaredParam();
      final String signature = this.signatureProvider.getSignature(param);
      Assert.assertEquals("String foo", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForForXClosureVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t");
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def zonk(){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("bar(s | s + \"42\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def bar((String)=>String fun){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      XExpression _get_2 = ((XFeatureCall) _get_1).getFeatureCallArguments().get(0);
      final XClosure closure = ((XClosure) _get_2);
      final JvmFormalParameter param = closure.getDeclaredFormalParameters().get(0);
      final String signature = this.signatureProvider.getSignature(param);
      Assert.assertEquals("String s", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSignatureForXVariableDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(List<String> list){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val a = \"42\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      XtendMember _get = clazz.getMembers().get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      XExpression _get_1 = ((XBlockExpression) _expression).getExpressions().get(0);
      final XVariableDeclaration variable = ((XVariableDeclaration) _get_1);
      final String signature = this.signatureProvider.getSignature(variable);
      Assert.assertEquals("String a", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBug378082() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("@Data");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int id");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch void a(int i){}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch void a(int i){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      final XtendMember field = IterableExtensions.<XtendMember>head(clazz.getMembers());
      final XtendMember function = clazz.getMembers().get(1);
      final String fieldSignature = this.signatureProvider.getSignature(field);
      Assert.assertEquals("int id", fieldSignature);
      final String functionSignature = this.signatureProvider.getSignature(function);
      Assert.assertEquals("void a(int i)", functionSignature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBug379019() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def error() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val start = System::currentTimeMillis()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var time = System::currentTimeMillis() - start");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("time");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      final XtendMember function = IterableExtensions.<XtendMember>head(clazz.getMembers());
      final String signature = this.signatureProvider.getSignature(function);
      EcoreUtil.resolveAll(xtendFile);
      Assert.assertEquals("long error()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("enum Foo { BAR, BAZ }");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration en = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      Assert.assertEquals("Foo", this.signatureProvider.getSignature(en));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Foo f){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("enum Foo { BAR, BAZ }");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes()).getMembers());
      final JvmType en = IterableExtensions.<XtendParameter>head(((XtendFunction) _head).getParameters()).getParameterType().getType();
      Assert.assertEquals("Foo", this.signatureProvider.getSignature(en));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInterfaceDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("interface Foo { }");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration in = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      Assert.assertEquals("Foo", this.signatureProvider.getSignature(in));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInterfaceReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Bar implements Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface Foo { }");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final JvmType in = IterableExtensions.<JvmTypeReference>head(((XtendClass) _head).getImplements()).getType();
      Assert.assertEquals("Foo", this.signatureProvider.getSignature(in));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnnotationDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("annotation Foo { }");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration in = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      Assert.assertEquals("Foo", this.signatureProvider.getSignature(in));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnnotationReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("@Foo");
      _builder.newLine();
      _builder.append("class Bar {}");
      _builder.newLine();
      _builder.append("annotation Foo { }");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final JvmType in = IterableExtensions.<XAnnotation>head(((XtendClass) _head).getAnnotations()).getAnnotationType();
      Assert.assertEquals("Foo", this.signatureProvider.getSignature(in));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test381185() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Bar b");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(){ ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("b.foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo f");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("f.bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendClass clazz = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class));
      final XtendClass clazz2 = IterableExtensions.<XtendClass>head(IterableExtensions.<XtendClass>drop(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class), 1));
      XtendMember _get = clazz.getMembers().get(1);
      final XtendFunction function1 = ((XtendFunction) _get);
      XtendMember _get_1 = clazz2.getMembers().get(1);
      final XtendFunction function2 = ((XtendFunction) _get_1);
      XExpression _expression = function1.getExpression();
      final XBlockExpression expression1 = ((XBlockExpression) _expression);
      XExpression _expression_1 = function2.getExpression();
      final XBlockExpression expression2 = ((XBlockExpression) _expression_1);
      XExpression _get_2 = expression1.getExpressions().get(0);
      final XMemberFeatureCall call1 = ((XMemberFeatureCall) _get_2);
      XExpression _get_3 = expression2.getExpressions().get(0);
      final XMemberFeatureCall call2 = ((XMemberFeatureCall) _get_3);
      Assert.assertEquals("Object Bar.foo()", this.signatureProvider.getSignature(call1.getFeature()));
      Assert.assertEquals("Object Foo.bar()", this.signatureProvider.getSignature(call2.getFeature()));
      XExpression _memberCallTarget = call1.getMemberCallTarget();
      Assert.assertEquals("Bar Foo.b", this.signatureProvider.getSignature(((XFeatureCall) _memberCallTarget).getFeature()));
      XExpression _memberCallTarget_1 = call2.getMemberCallTarget();
      Assert.assertEquals("Foo Bar.f", this.signatureProvider.getSignature(((XFeatureCall) _memberCallTarget_1).getFeature()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAutcastExpressions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val CharSequence c = \"\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (c instanceof String) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("c.substring(1, 1)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch(c){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String : c.length");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(((XtendClass) _head).getMembers());
      final XtendFunction func = ((XtendFunction) _head_1);
      XExpression _expression = func.getExpression();
      final XBlockExpression block = ((XBlockExpression) _expression);
      final XExpression dec = IterableExtensions.<XExpression>head(block.getExpressions());
      Assert.assertEquals("CharSequence c", this.signatureProvider.getSignature(dec));
      XExpression _get = block.getExpressions().get(1);
      final XIfExpression ifexpr = ((XIfExpression) _get);
      final XExpression then = ifexpr.getThen();
      XExpression _head_2 = IterableExtensions.<XExpression>head(((XBlockExpression) then).getExpressions());
      final XExpression target = ((XMemberFeatureCall) _head_2).getMemberCallTarget();
      Assert.assertEquals("String c", this.signatureProvider.getSignature(target));
      XExpression _get_1 = block.getExpressions().get(2);
      final XSwitchExpression switchExpr = ((XSwitchExpression) _get_1);
      XExpression _then = IterableExtensions.<XCasePart>head(switchExpr.getCases()).getThen();
      final XExpression expr = ((XMemberFeatureCall) _then).getMemberCallTarget();
      Assert.assertEquals("String c", this.signatureProvider.getSignature(expr));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAutcastExpressions_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("CharSequence c = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (c instanceof String) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("c.substring(1, 1)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch(c){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String : c.length");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      Assert.assertEquals("CharSequence c", this.signatureProvider.getSignature(IterableExtensions.<XtendMember>head(((XtendClass) _head).getMembers())));
      XtendTypeDeclaration _head_1 = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _get = ((XtendClass) _head_1).getMembers().get(1);
      final XtendFunction func = ((XtendFunction) _get);
      XExpression _expression = func.getExpression();
      final XBlockExpression block = ((XBlockExpression) _expression);
      XExpression _head_2 = IterableExtensions.<XExpression>head(block.getExpressions());
      final XIfExpression ifexpr = ((XIfExpression) _head_2);
      final XExpression then = ifexpr.getThen();
      XExpression _head_3 = IterableExtensions.<XExpression>head(((XBlockExpression) then).getExpressions());
      final XExpression target = ((XMemberFeatureCall) _head_3).getMemberCallTarget();
      Assert.assertEquals("String Foo.c", this.signatureProvider.getSignature(target));
      XExpression _get_1 = block.getExpressions().get(1);
      final XSwitchExpression switchExpr = ((XSwitchExpression) _get_1);
      XExpression _then = IterableExtensions.<XCasePart>head(switchExpr.getCases()).getThen();
      final XExpression expr = ((XMemberFeatureCall) _then).getMemberCallTarget();
      Assert.assertEquals("String Foo.c", this.signatureProvider.getSignature(expr));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAutcastExpressions_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(CharSequence c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (c instanceof String) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("c.substring(1, 1)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch(c){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String : c.length");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(((XtendClass) _head).getMembers());
      final XtendFunction func = ((XtendFunction) _head_1);
      Assert.assertEquals("CharSequence c - foo(CharSequence)", this.signatureProvider.getSignature(IterableExtensions.<XtendParameter>head(func.getParameters())));
      XExpression _expression = func.getExpression();
      final XBlockExpression block = ((XBlockExpression) _expression);
      XExpression _head_2 = IterableExtensions.<XExpression>head(block.getExpressions());
      final XIfExpression ifexpr = ((XIfExpression) _head_2);
      final XExpression then = ifexpr.getThen();
      XExpression _head_3 = IterableExtensions.<XExpression>head(((XBlockExpression) then).getExpressions());
      final XExpression target = ((XMemberFeatureCall) _head_3).getMemberCallTarget();
      Assert.assertEquals("String c", this.signatureProvider.getSignature(target));
      XExpression _get = block.getExpressions().get(1);
      final XSwitchExpression switchExpr = ((XSwitchExpression) _get);
      XExpression _then = IterableExtensions.<XCasePart>head(switchExpr.getCases()).getThen();
      final XExpression expr = ((XMemberFeatureCall) _then).getMemberCallTarget();
      Assert.assertEquals("String c", this.signatureProvider.getSignature(expr));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public ResourceSet getResourceSet() {
    return this.getInjector().<IResourceSetProvider>getInstance(IResourceSetProvider.class).get(this.testHelper.getProject());
  }

  @After
  public void cleanup() {
    try {
      this.testHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
