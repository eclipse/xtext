/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class InsertionOffsetTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> parseHelper;

  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;

  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;

  @Test
  public void testField_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkFieldInsertionOffset(_builder);
  }

  @Test
  public void testField_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkFieldInsertionOffset(_builder);
  }

  @Test
  public void testField_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkFieldInsertionOffset(_builder);
  }

  @Test
  public void testField_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkFieldInsertionOffset(_builder);
  }

  @Test
  public void testMethod_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkMethodInsertionOffset(_builder);
  }

  @Test
  public void testMethod_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkMethodInsertionOffset(_builder);
  }

  @Test
  public void testMethod_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkMethodInsertionOffset(_builder);
  }

  @Test
  public void testConstructor_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkConstructorInsertionOffset(_builder);
  }

  @Test
  public void testConstructor_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkConstructorInsertionOffset(_builder);
  }

  @Test
  public void testConstructor_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("double y$");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkConstructorInsertionOffset(_builder);
  }

  @Test
  public void testConstructor_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkConstructorInsertionOffset(_builder);
  }

  @Test
  public void testClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}$");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkTypeInsertionOffset(_builder);
  }

  protected void checkFieldInsertionOffset(final CharSequence model) {
    try {
      final String modelAsString = model.toString();
      final int caretOffset = modelAsString.replace("$", "").indexOf("|");
      final int expectedOffset = modelAsString.replace("|", "").indexOf("$");
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.parseHelper.parse(modelAsString.replace("|", "").replace("$", "")).getXtendTypes());
      final XtendClass xtendClass = ((XtendClass) _head);
      Resource _eResource = xtendClass.eResource();
      final XtextResource xtextResource = ((XtextResource) _eResource);
      final EObject caretElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, caretOffset);
      Assert.assertEquals(expectedOffset, this._insertionOffsets.getNewFieldInsertOffset(caretElement, xtendClass));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void checkMethodInsertionOffset(final CharSequence model) {
    try {
      final String modelAsString = model.toString();
      final int caretOffset = modelAsString.replace("$", "").indexOf("|");
      final int expectedOffset = modelAsString.replace("|", "").indexOf("$");
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.parseHelper.parse(modelAsString.replace("|", "").replace("$", "")).getXtendTypes());
      final XtendClass xtendClass = ((XtendClass) _head);
      Resource _eResource = xtendClass.eResource();
      final XtextResource xtextResource = ((XtextResource) _eResource);
      final EObject caretElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, caretOffset);
      Assert.assertEquals(expectedOffset, this._insertionOffsets.getNewMethodInsertOffset(caretElement, xtendClass));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void checkConstructorInsertionOffset(final CharSequence model) {
    try {
      final String modelAsString = model.toString();
      final int caretOffset = modelAsString.replace("$", "").indexOf("|");
      final int expectedOffset = modelAsString.replace("|", "").indexOf("$");
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.parseHelper.parse(modelAsString.replace("|", "").replace("$", "")).getXtendTypes());
      final XtendClass xtendClass = ((XtendClass) _head);
      Resource _eResource = xtendClass.eResource();
      final XtextResource xtextResource = ((XtextResource) _eResource);
      final EObject caretElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, caretOffset);
      Assert.assertEquals(expectedOffset, this._insertionOffsets.getNewConstructorInsertOffset(caretElement, xtendClass));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void checkTypeInsertionOffset(final CharSequence model) {
    try {
      final String modelAsString = model.toString();
      final int caretOffset = modelAsString.replace("$", "").indexOf("|");
      final int expectedOffset = modelAsString.replace("|", "").indexOf("$");
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.parseHelper.parse(modelAsString.replace("|", "").replace("$", "")).getXtendTypes());
      final XtendClass xtendClass = ((XtendClass) _head);
      Resource _eResource = xtendClass.eResource();
      final XtextResource xtextResource = ((XtextResource) _eResource);
      final EObject caretElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, caretOffset);
      Assert.assertEquals(expectedOffset, this._insertionOffsets.getNewTypeInsertOffset(caretElement, xtendClass));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
