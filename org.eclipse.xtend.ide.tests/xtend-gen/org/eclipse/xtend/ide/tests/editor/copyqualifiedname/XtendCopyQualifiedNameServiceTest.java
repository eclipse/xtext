/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor.copyqualifiedname;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.ICopyQualifiedNameService;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendCopyQualifiedNameServiceTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;

  @Inject
  @Extension
  private ParseHelper<XtendFile> parseHelper;

  @Inject
  private ICopyQualifiedNameService copyQualifiedNameService;

  @Test
  public void testJvmOperation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(java.util.List<String> list) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("list.clear");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("list.add(null)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "java.util.List.clear()");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "java.util.List.add(String)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmOperation_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(java.util.Map<? extends String, ? extends String> map) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("map.get(null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("map.put(null, null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(map)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <K, V> void bar(java.util.Map<K, V> map) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "java.util.Map.get(Object)");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "java.util.Map.put(? extends String, ? extends String)");
      this.assertCopyQualifiedName(expression.getExpressions().get(2), "Foo.bar(Map<? extends String, ? extends String>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmOperation_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo extends java.util.ArrayList<String> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("clear");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("add(null)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "java.util.ArrayList.clear()");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "java.util.ArrayList.add(String)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmOperation_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo extends java.util.ArrayList<String> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("clear");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("add(null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.clear");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.add(null)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override clear () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.clear");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override add(String value) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.add(value)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "Foo.clear()");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "Foo.add(String)");
      this.assertCopyQualifiedName(expression.getExpressions().get(2), "java.util.ArrayList.clear()");
      this.assertCopyQualifiedName(expression.getExpressions().get(3), "java.util.ArrayList.add(String)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmOperation_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val list = <String>newArrayList");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("list.clear");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("list.add(null)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "java.util.ArrayList.clear()");
      this.assertCopyQualifiedName(expression.getExpressions().get(2), "java.util.ArrayList.add(String)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmOperation_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo<T> extends java.util.ArrayList<T> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("clear");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("add(null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.clear");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.add(null)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override clear () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.clear");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override add(T value) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.add(value)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "Foo.clear()");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "Foo.add(T)");
      this.assertCopyQualifiedName(expression.getExpressions().get(2), "java.util.ArrayList.clear()");
      this.assertCopyQualifiedName(expression.getExpressions().get(3), "java.util.ArrayList.add(T)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmOperation_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Bar<String>.bar(null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Bar<String>.bar(<String>newArrayList)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar<T> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar (java.util.List<T> list) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "Bar.bar(List<String>)");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "Bar.bar(ArrayList<String>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmOperation_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo<T> extends java.util.ArrayList<java.lang.Iterable<T>> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("add(null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.add(null)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override add(java.lang.Iterable<T> value) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.add(value)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "Foo.add(Iterable<T>)");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "java.util.ArrayList.add(Iterable<T>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Bar");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Bar(null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Bar(<String>newArrayList)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new () {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (java.util.List<?> list) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "Bar()");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "Bar(List<?>)");
      this.assertCopyQualifiedName(expression.getExpressions().get(2), "Bar(ArrayList<String>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmConstructor_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Bar<String>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Bar<String>(null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Bar<String>(<String>newArrayList)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar<T> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new () {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (java.util.List<T> list) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "Bar()");
      this.assertCopyQualifiedName(expression.getExpressions().get(1), "Bar(List<String>)");
      this.assertCopyQualifiedName(expression.getExpressions().get(2), "Bar(ArrayList<String>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmConstructor_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo extends Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (java.util.List<?> list) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super(list)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super(<String>newArrayList)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (java.util.List<?> list) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendConstructor) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "Bar(List<?>)");
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendMember>tail(xtendType.getMembers()));
      XExpression _expression_1 = ((XtendConstructor) _head_1).getExpression();
      final XBlockExpression expression2 = ((XBlockExpression) _expression_1);
      this.assertCopyQualifiedName(expression2.getExpressions().get(0), "Bar(ArrayList<String>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmConstructor_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this(<String>newArrayList)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (java.util.List<?> list) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(xtendType.getMembers());
      XExpression _expression = ((XtendConstructor) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      this.assertCopyQualifiedName(expression.getExpressions().get(0), "Foo(ArrayList<String>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(java.util.List<String> list) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(xtendType.getMembers()), "Foo.foo(List<String>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendFunction_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(java.util.Map<? extends String, ? extends String> map) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <K, V> void bar(java.util.Map<K, V> map) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(xtendType.getMembers()), "Foo.foo(Map<? extends String, ? extends String>)");
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(IterableExtensions.<XtendMember>tail(xtendType.getMembers())), "Foo.bar(Map<K, V>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendFunction_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo extends java.util.ArrayList<String> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override clear () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.clear");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override add(String value) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.add(value)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(xtendType.getMembers()), "Foo.clear()");
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(IterableExtensions.<XtendMember>tail(xtendType.getMembers())), "Foo.add(String)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendFunction_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo<T> extends java.util.ArrayList<T> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override clear () {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.clear");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override add(T value) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.add(value)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(xtendType.getMembers()), "Foo.clear()");
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(IterableExtensions.<XtendMember>tail(xtendType.getMembers())), "Foo.add(T)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendFunction_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo<T> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo (java.util.List<T> list) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(xtendType.getMembers()), "Foo.foo(List<T>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new () {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (java.util.List<?> list) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(xtendType.getMembers()), "Foo()");
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(IterableExtensions.<XtendMember>tail(xtendType.getMembers())), "Foo(List<?>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendConstructor_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo<T> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (java.util.List<T> list) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(xtendType.getMembers()), "Foo(List<T>)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendConstructor_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo<X, Y> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (X x, Y y) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      this.assertCopyQualifiedName(IterableExtensions.<XtendMember>head(xtendType.getMembers()), "Foo(X, Y)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void _assertCopyQualifiedName(final XAbstractFeatureCall featureCall, final String expectedQualifiedName) {
    Assert.assertEquals(expectedQualifiedName, this.copyQualifiedNameService.getQualifiedName(featureCall.getFeature(), featureCall));
  }

  protected void _assertCopyQualifiedName(final XConstructorCall constructorCall, final String expectedQualifiedName) {
    Assert.assertEquals(expectedQualifiedName, 
      this.copyQualifiedNameService.getQualifiedName(constructorCall.getConstructor(), constructorCall));
  }

  protected void _assertCopyQualifiedName(final EObject object, final String expectedQualifiedName) {
    Assert.assertEquals(expectedQualifiedName, this.copyQualifiedNameService.getQualifiedName(object, null));
    Assert.assertEquals(expectedQualifiedName, this.copyQualifiedNameService.getQualifiedName(object, object.eContainer()));
  }

  public ResourceSet getResourceSet() {
    return this.getInjector().<IResourceSetProvider>getInstance(IResourceSetProvider.class).get(this.testHelper.getProject());
  }

  public void assertCopyQualifiedName(final EObject featureCall, final String expectedQualifiedName) {
    if (featureCall instanceof XAbstractFeatureCall) {
      _assertCopyQualifiedName((XAbstractFeatureCall)featureCall, expectedQualifiedName);
      return;
    } else if (featureCall instanceof XConstructorCall) {
      _assertCopyQualifiedName((XConstructorCall)featureCall, expectedQualifiedName);
      return;
    } else if (featureCall != null) {
      _assertCopyQualifiedName(featureCall, expectedQualifiedName);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(featureCall, expectedQualifiedName).toString());
    }
  }
}
