/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor.copyqualifiedname;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Arrays;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.ui.editor.copyqualifiedname.CopyQualifiedNameService;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Synthetic;
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
  private CopyQualifiedNameService copyQualifiedNameService;
  
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "java.util.List.clear()");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "java.util.List.add(String)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "java.util.Map.get(Object)");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "java.util.Map.put(? extends String, ? extends String)");
      EList<XExpression> _expressions_2 = expression.getExpressions();
      XExpression _get_2 = _expressions_2.get(2);
      this.assertCopyQualifiedName(_get_2, "Foo.bar(Map<? extends String, ? extends String>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "java.util.ArrayList.clear()");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "java.util.ArrayList.add(String)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "Foo.clear()");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "Foo.add(String)");
      EList<XExpression> _expressions_2 = expression.getExpressions();
      XExpression _get_2 = _expressions_2.get(2);
      this.assertCopyQualifiedName(_get_2, "java.util.ArrayList.clear()");
      EList<XExpression> _expressions_3 = expression.getExpressions();
      XExpression _get_3 = _expressions_3.get(3);
      this.assertCopyQualifiedName(_get_3, "java.util.ArrayList.add(String)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(1);
      this.assertCopyQualifiedName(_get, "java.util.ArrayList.clear()");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(2);
      this.assertCopyQualifiedName(_get_1, "java.util.ArrayList.add(String)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "Foo.clear()");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "Foo.add(T)");
      EList<XExpression> _expressions_2 = expression.getExpressions();
      XExpression _get_2 = _expressions_2.get(2);
      this.assertCopyQualifiedName(_get_2, "java.util.ArrayList.clear()");
      EList<XExpression> _expressions_3 = expression.getExpressions();
      XExpression _get_3 = _expressions_3.get(3);
      this.assertCopyQualifiedName(_get_3, "java.util.ArrayList.add(T)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "Bar.bar(List<String>)");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "Bar.bar(ArrayList<String>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "Foo.add(Iterable<T>)");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "java.util.ArrayList.add(Iterable<T>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "Bar()");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "Bar(List<?>)");
      EList<XExpression> _expressions_2 = expression.getExpressions();
      XExpression _get_2 = _expressions_2.get(2);
      this.assertCopyQualifiedName(_get_2, "Bar(ArrayList<String>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendFunction) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "Bar()");
      EList<XExpression> _expressions_1 = expression.getExpressions();
      XExpression _get_1 = _expressions_1.get(1);
      this.assertCopyQualifiedName(_get_1, "Bar(List<String>)");
      EList<XExpression> _expressions_2 = expression.getExpressions();
      XExpression _get_2 = _expressions_2.get(2);
      this.assertCopyQualifiedName(_get_2, "Bar(ArrayList<String>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendConstructor) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "Bar(List<?>)");
      EList<XtendMember> _members_1 = xtendType.getMembers();
      Iterable<XtendMember> _tail = IterableExtensions.<XtendMember>tail(_members_1);
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_tail);
      XExpression _expression_1 = ((XtendConstructor) _head_1).getExpression();
      final XBlockExpression expression2 = ((XBlockExpression) _expression_1);
      EList<XExpression> _expressions_1 = expression2.getExpressions();
      XExpression _get_1 = _expressions_1.get(0);
      this.assertCopyQualifiedName(_get_1, "Bar(ArrayList<String>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      XExpression _expression = ((XtendConstructor) _head).getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get = _expressions.get(0);
      this.assertCopyQualifiedName(_get, "Foo(ArrayList<String>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this.assertCopyQualifiedName(_head, "Foo.foo(List<String>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this.assertCopyQualifiedName(_head, "Foo.foo(Map<? extends String, ? extends String>)");
      EList<XtendMember> _members_1 = xtendType.getMembers();
      Iterable<XtendMember> _tail = IterableExtensions.<XtendMember>tail(_members_1);
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_tail);
      this.assertCopyQualifiedName(_head_1, "Foo.bar(Map<K, V>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this.assertCopyQualifiedName(_head, "Foo.clear()");
      EList<XtendMember> _members_1 = xtendType.getMembers();
      Iterable<XtendMember> _tail = IterableExtensions.<XtendMember>tail(_members_1);
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_tail);
      this.assertCopyQualifiedName(_head_1, "Foo.add(String)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this.assertCopyQualifiedName(_head, "Foo.clear()");
      EList<XtendMember> _members_1 = xtendType.getMembers();
      Iterable<XtendMember> _tail = IterableExtensions.<XtendMember>tail(_members_1);
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_tail);
      this.assertCopyQualifiedName(_head_1, "Foo.add(T)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this.assertCopyQualifiedName(_head, "Foo.foo(List<T>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this.assertCopyQualifiedName(_head, "Foo()");
      EList<XtendMember> _members_1 = xtendType.getMembers();
      Iterable<XtendMember> _tail = IterableExtensions.<XtendMember>tail(_members_1);
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_tail);
      this.assertCopyQualifiedName(_head_1, "Foo(List<?>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this.assertCopyQualifiedName(_head, "Foo(List<T>)");
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
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration xtendType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = xtendType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this.assertCopyQualifiedName(_head, "Foo(X, Y)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _assertCopyQualifiedName(final XAbstractFeatureCall featureCall, final String expectedQualifiedName) {
    JvmIdentifiableElement _feature = featureCall.getFeature();
    String _qualifiedName = this.copyQualifiedNameService.getQualifiedName(_feature, featureCall);
    Assert.assertEquals(expectedQualifiedName, _qualifiedName);
  }
  
  protected void _assertCopyQualifiedName(final XConstructorCall constructorCall, final String expectedQualifiedName) {
    JvmConstructor _constructor = constructorCall.getConstructor();
    String _qualifiedName = this.copyQualifiedNameService.getQualifiedName(_constructor, constructorCall);
    Assert.assertEquals(expectedQualifiedName, _qualifiedName);
  }
  
  protected void _assertCopyQualifiedName(final EObject object, final String expectedQualifiedName) {
    String _qualifiedName = this.copyQualifiedNameService.getQualifiedName(object, null);
    Assert.assertEquals(expectedQualifiedName, _qualifiedName);
    EObject _eContainer = object.eContainer();
    String _qualifiedName_1 = this.copyQualifiedNameService.getQualifiedName(object, _eContainer);
    Assert.assertEquals(expectedQualifiedName, _qualifiedName_1);
  }
  
  public ResourceSet getResourceSet() {
    Injector _injector = this.getInjector();
    IResourceSetProvider _instance = _injector.<IResourceSetProvider>getInstance(IResourceSetProvider.class);
    IProject _project = this.testHelper.getProject();
    return _instance.get(_project);
  }
  
  @Synthetic
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
