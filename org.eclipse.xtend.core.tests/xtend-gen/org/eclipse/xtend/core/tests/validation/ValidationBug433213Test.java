/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug433213Test extends AbstractXtendTestCase {
  @Inject
  private ValidationTestHelper helper;

  @Inject
  private ParseHelper<XtendFile> parser;

  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("def <T> T m2() {}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      final XtendTypeDeclaration c = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(c.getMembers());
      final XtendFunction m = ((XtendFunction) _head);
      XExpression _expression = m.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head_1 = IterableExtensions.<XExpression>head(body.getExpressions());
      final AnonymousClass anon = ((AnonymousClass) _head_1);
      XtendMember _head_2 = IterableExtensions.<XtendMember>head(anon.getMembers());
      final XtendFunction m2 = ((XtendFunction) _head_2);
      final JvmTypeReference returnType = m2.getReturnType();
      final JvmType t = returnType.getType();
      Assert.assertNotNull("notNull", t);
      Assert.assertFalse("t.eIsProxy", t.eIsProxy());
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("def T m2() {}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      final XtendTypeDeclaration c = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(c.getMembers());
      final XtendFunction m = ((XtendFunction) _head);
      XExpression _expression = m.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head_1 = IterableExtensions.<XExpression>head(body.getExpressions());
      final AnonymousClass anon = ((AnonymousClass) _head_1);
      XtendMember _head_2 = IterableExtensions.<XtendMember>head(anon.getMembers());
      final XtendFunction m2 = ((XtendFunction) _head_2);
      final JvmTypeReference returnType = m2.getReturnType();
      final JvmType t = returnType.getType();
      Assert.assertNotNull("notNull", t);
      Assert.assertFalse("t.eIsProxy", t.eIsProxy());
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("def m2() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("def <T> T m3() {}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      final XtendTypeDeclaration c = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(c.getMembers());
      final XtendFunction m = ((XtendFunction) _head);
      XExpression _expression = m.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head_1 = IterableExtensions.<XExpression>head(body.getExpressions());
      final AnonymousClass anon = ((AnonymousClass) _head_1);
      XtendMember _head_2 = IterableExtensions.<XtendMember>head(anon.getMembers());
      final XtendFunction m2 = ((XtendFunction) _head_2);
      XExpression _expression_1 = m2.getExpression();
      final XBlockExpression body2 = ((XBlockExpression) _expression_1);
      XExpression _head_3 = IterableExtensions.<XExpression>head(body2.getExpressions());
      final AnonymousClass anon2 = ((AnonymousClass) _head_3);
      XtendMember _head_4 = IterableExtensions.<XtendMember>head(anon2.getMembers());
      final XtendFunction m3 = ((XtendFunction) _head_4);
      final JvmTypeReference returnType = m3.getReturnType();
      final JvmType t = returnType.getType();
      Assert.assertNotNull("notNull", t);
      Assert.assertFalse("t.eIsProxy", t.eIsProxy());
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("def <T> m2() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("def T m3() {}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      final XtendTypeDeclaration c = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(c.getMembers());
      final XtendFunction m = ((XtendFunction) _head);
      XExpression _expression = m.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head_1 = IterableExtensions.<XExpression>head(body.getExpressions());
      final AnonymousClass anon = ((AnonymousClass) _head_1);
      XtendMember _head_2 = IterableExtensions.<XtendMember>head(anon.getMembers());
      final XtendFunction m2 = ((XtendFunction) _head_2);
      XExpression _expression_1 = m2.getExpression();
      final XBlockExpression body2 = ((XBlockExpression) _expression_1);
      XExpression _head_3 = IterableExtensions.<XExpression>head(body2.getExpressions());
      final AnonymousClass anon2 = ((AnonymousClass) _head_3);
      XtendMember _head_4 = IterableExtensions.<XtendMember>head(anon2.getMembers());
      final XtendFunction m3 = ((XtendFunction) _head_4);
      final JvmTypeReference returnType = m3.getReturnType();
      final JvmType t = returnType.getType();
      Assert.assertNotNull("notNull", t);
      Assert.assertFalse("t.eIsProxy", t.eIsProxy());
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("def m2() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("def T m3() {}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      final XtendTypeDeclaration c = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(c.getMembers());
      final XtendFunction m = ((XtendFunction) _head);
      XExpression _expression = m.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head_1 = IterableExtensions.<XExpression>head(body.getExpressions());
      final AnonymousClass anon = ((AnonymousClass) _head_1);
      XtendMember _head_2 = IterableExtensions.<XtendMember>head(anon.getMembers());
      final XtendFunction m2 = ((XtendFunction) _head_2);
      XExpression _expression_1 = m2.getExpression();
      final XBlockExpression body2 = ((XBlockExpression) _expression_1);
      XExpression _head_3 = IterableExtensions.<XExpression>head(body2.getExpressions());
      final AnonymousClass anon2 = ((AnonymousClass) _head_3);
      XtendMember _head_4 = IterableExtensions.<XtendMember>head(anon2.getMembers());
      final XtendFunction m3 = ((XtendFunction) _head_4);
      final JvmTypeReference returnType = m3.getReturnType();
      final JvmType t = returnType.getType();
      Assert.assertNotNull("notNull", t);
      Assert.assertFalse("t.eIsProxy", t.eIsProxy());
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <K> m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("def <V> m2() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("new java.util.AbstractMap<K, V> {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("def Entry<K, V> m() {}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("override entrySet() {}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      final XtendTypeDeclaration c = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
      XtendMember _head = IterableExtensions.<XtendMember>head(c.getMembers());
      final XtendFunction m = ((XtendFunction) _head);
      XExpression _expression = m.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _head_1 = IterableExtensions.<XExpression>head(body.getExpressions());
      final AnonymousClass anon = ((AnonymousClass) _head_1);
      XtendMember _head_2 = IterableExtensions.<XtendMember>head(anon.getMembers());
      final XtendFunction m2 = ((XtendFunction) _head_2);
      XExpression _expression_1 = m2.getExpression();
      final XBlockExpression body2 = ((XBlockExpression) _expression_1);
      XExpression _head_3 = IterableExtensions.<XExpression>head(body2.getExpressions());
      final AnonymousClass anon2 = ((AnonymousClass) _head_3);
      XtendMember _head_4 = IterableExtensions.<XtendMember>head(anon2.getMembers());
      final XtendFunction m3 = ((XtendFunction) _head_4);
      final JvmTypeReference returnType = m3.getReturnType();
      final JvmType t = returnType.getType();
      Assert.assertNotNull("notNull", t);
      Assert.assertFalse("t.eIsProxy", t.eIsProxy());
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
