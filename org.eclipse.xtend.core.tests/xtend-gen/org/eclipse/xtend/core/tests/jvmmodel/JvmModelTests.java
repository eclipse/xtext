/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmModelTests extends AbstractXtendTestCase {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;

  @Inject
  @Extension
  private IBatchTypeResolver typeResolver;

  @Test
  public void testClassImplicitSuperType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmGenericType inferred = this._iXtendJvmAssociations.getInferredType(this.clazz(_builder.toString()));
      Assert.assertEquals(1, inferred.getSuperTypes().size());
      Assert.assertEquals("java.lang.Object", IterableExtensions.<JvmTypeReference>head(inferred.getSuperTypes()).getIdentifier());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInterfaceImplicitSuperType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmGenericType inferred = this._iXtendJvmAssociations.getInferredType(this.interfaze(_builder.toString()));
      Assert.assertEquals(1, inferred.getSuperTypes().size());
      Assert.assertEquals("java.lang.Object", IterableExtensions.<JvmTypeReference>head(inferred.getSuperTypes()).getIdentifier());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInterfaceAbstract() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmGenericType inferred = this._iXtendJvmAssociations.getInferredType(this.interfaze(_builder.toString()));
      Assert.assertTrue(inferred.isAbstract());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnnotationImplicitSuperType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmAnnotationType inferred = this._iXtendJvmAssociations.getInferredAnnotationType(this.annotationType(_builder.toString()));
      Assert.assertEquals(1, inferred.getSuperTypes().size());
      Assert.assertEquals("java.lang.annotation.Annotation", IterableExtensions.<JvmTypeReference>head(inferred.getSuperTypes()).getIdentifier());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnnotationAbstract() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmAnnotationType inferred = this._iXtendJvmAssociations.getInferredAnnotationType(this.annotationType(_builder.toString()));
      Assert.assertTrue(inferred.isAbstract());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEmptyListAsAnnotationValueDefault() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String[] bar = #[]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      JvmMember _head = IterableExtensions.<JvmMember>head(this._iXtendJvmAssociations.getInferredAnnotationType(this.annotationType(_builder.toString())).getMembers());
      final JvmOperation inferred = ((JvmOperation) _head);
      Assert.assertEquals("java.lang.String[]", inferred.getReturnType().getIdentifier());
      JvmAnnotationValue _defaultValue = inferred.getDefaultValue();
      Assert.assertTrue((_defaultValue instanceof JvmCustomAnnotationValue));
      JvmAnnotationValue _defaultValue_1 = inferred.getDefaultValue();
      EObject _head_1 = IterableExtensions.<EObject>head(((JvmCustomAnnotationValue) _defaultValue_1).getValues());
      Assert.assertTrue((_head_1 instanceof XListLiteral));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnnotationDefaultAssociatedWithJvmOperation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val bar = \'\'");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      JvmMember _head = IterableExtensions.<JvmMember>head(this._iXtendJvmAssociations.getInferredAnnotationType(this.annotationType(_builder.toString())).getMembers());
      final JvmOperation inferred = ((JvmOperation) _head);
      final JvmAnnotationValue defaultValue = inferred.getDefaultValue();
      Assert.assertSame(inferred, defaultValue.getOperation());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumImplicitSuperType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmEnumerationType inferred = this._iXtendJvmAssociations.getInferredEnumerationType(this.enumeration(_builder.toString()));
      Assert.assertEquals(1, inferred.getSuperTypes().size());
      Assert.assertEquals("java.lang.Enum<Foo>", IterableExtensions.<JvmTypeReference>head(inferred.getSuperTypes()).getIdentifier());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumLiteralIsStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("BAR");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      JvmMember _head = IterableExtensions.<JvmMember>head(this._iXtendJvmAssociations.getInferredEnumerationType(this.enumeration(_builder.toString())).getMembers());
      final JvmEnumerationLiteral inferred = ((JvmEnumerationLiteral) _head);
      Assert.assertTrue(inferred.isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumIsFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("BAR");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmEnumerationType inferred = this._iXtendJvmAssociations.getInferredEnumerationType(this.enumeration(_builder.toString()));
      Assert.assertTrue(inferred.isFinal());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTopLevelEnumIsNotStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("BAR");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmEnumerationType inferred = this._iXtendJvmAssociations.getInferredEnumerationType(this.enumeration(_builder.toString()));
      Assert.assertFalse(inferred.isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClassInAnnotationIsStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("class C {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmAnnotationType inferred = this._iXtendJvmAssociations.getInferredAnnotationType(this.annotationType(_builder.toString()));
      JvmMember _head = IterableExtensions.<JvmMember>head(inferred.getMembers());
      final JvmGenericType c = ((JvmGenericType) _head);
      Assert.assertTrue(c.isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumInAnnotationIsStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("enum E { L0, L1 }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmAnnotationType inferred = this._iXtendJvmAssociations.getInferredAnnotationType(this.annotationType(_builder.toString()));
      JvmMember _head = IterableExtensions.<JvmMember>head(inferred.getMembers());
      final JvmEnumerationType e = ((JvmEnumerationType) _head);
      Assert.assertTrue(e.isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClassInInterfaceIsStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("class C {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmGenericType inferred = this._iXtendJvmAssociations.getInferredType(this.interfaze(_builder.toString()));
      JvmMember _head = IterableExtensions.<JvmMember>head(inferred.getMembers());
      final JvmGenericType c = ((JvmGenericType) _head);
      Assert.assertTrue(c.isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTopLevelInterfaceIsNotStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmGenericType inferred = this._iXtendJvmAssociations.getInferredType(this.interfaze(_builder.toString()));
      Assert.assertFalse(inferred.isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumArtificialMethods() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final EList<JvmMember> inferred = this._iXtendJvmAssociations.getInferredEnumerationType(this.enumeration(_builder.toString())).getMembers();
      Assert.assertEquals(2, inferred.size());
      JvmMember _get = inferred.get(0);
      final JvmOperation values = ((JvmOperation) _get);
      Assert.assertEquals("bar.Foo.values()", values.getIdentifier());
      Assert.assertTrue(values.isStatic());
      Assert.assertEquals(JvmVisibility.PUBLIC, values.getVisibility());
      JvmMember _get_1 = inferred.get(1);
      final JvmOperation valueOf = ((JvmOperation) _get_1);
      Assert.assertEquals("bar.Foo.valueOf(java.lang.String)", valueOf.getIdentifier());
      Assert.assertTrue(valueOf.isStatic());
      Assert.assertEquals(JvmVisibility.PUBLIC, valueOf.getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnonymousClass_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int field");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override run() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(this.function(_builder.toString()));
      this.typeResolver.resolveTypes(operation.eResource());
      Assert.assertEquals(1, operation.getLocalClasses().size());
      final JvmGenericType anonymous = IterableExtensions.<JvmGenericType>head(operation.getLocalClasses());
      Assert.assertTrue(anonymous.isFinal());
      Assert.assertFalse(anonymous.isStatic());
      Assert.assertTrue(anonymous.isLocal());
      Assert.assertTrue(anonymous.isAnonymous());
      Assert.assertEquals(JvmVisibility.DEFAULT, anonymous.getVisibility());
      Assert.assertEquals(2, anonymous.getSuperTypes().size());
      Assert.assertEquals("java.lang.Runnable", IterableExtensions.<JvmTypeReference>lastOrNull(anonymous.getSuperTypes()).getQualifiedName());
      Assert.assertEquals(3, anonymous.getMembers().size());
      final JvmMember constructor = IterableExtensions.<JvmMember>lastOrNull(anonymous.getMembers());
      Assert.assertTrue((constructor instanceof JvmConstructor));
      Assert.assertEquals(0, ((JvmConstructor) constructor).getParameters().size());
      JvmMember _head = IterableExtensions.<JvmMember>head(anonymous.getMembers());
      Assert.assertTrue((_head instanceof JvmField));
      final JvmMember overriding = anonymous.getMembers().get(1);
      Assert.assertTrue((overriding instanceof JvmOperation));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnonymousClass_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override run() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(this.function(_builder.toString()));
      this.typeResolver.resolveTypes(operation.eResource());
      Assert.assertEquals(1, operation.getLocalClasses().size());
      final JvmGenericType anonymous = IterableExtensions.<JvmGenericType>head(operation.getLocalClasses());
      Assert.assertTrue(anonymous.isFinal());
      Assert.assertFalse(anonymous.isStatic());
      Assert.assertTrue(anonymous.isLocal());
      Assert.assertTrue(anonymous.isAnonymous());
      Assert.assertEquals(JvmVisibility.DEFAULT, anonymous.getVisibility());
      Assert.assertEquals(2, anonymous.getSuperTypes().size());
      Assert.assertEquals("java.lang.Runnable", IterableExtensions.<JvmTypeReference>lastOrNull(anonymous.getSuperTypes()).getQualifiedName());
      Assert.assertEquals(2, anonymous.getMembers().size());
      final JvmMember constructor = IterableExtensions.<JvmMember>lastOrNull(anonymous.getMembers());
      Assert.assertTrue((constructor instanceof JvmConstructor));
      Assert.assertEquals(0, ((JvmConstructor) constructor).getParameters().size());
      final JvmMember overriding = IterableExtensions.<JvmMember>head(anonymous.getMembers());
      Assert.assertTrue((overriding instanceof JvmOperation));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnonymousClass_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def <T> foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Iterable<T>() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override iterator() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(this.function(_builder.toString()));
      this.typeResolver.resolveTypes(operation.eResource());
      Assert.assertEquals(1, operation.getLocalClasses().size());
      final JvmGenericType anonymous = IterableExtensions.<JvmGenericType>head(operation.getLocalClasses());
      Assert.assertTrue(anonymous.isFinal());
      Assert.assertFalse(anonymous.isStatic());
      Assert.assertTrue(anonymous.isLocal());
      Assert.assertTrue(anonymous.isAnonymous());
      Assert.assertEquals(0, anonymous.getTypeParameters().size());
      Assert.assertEquals(JvmVisibility.DEFAULT, anonymous.getVisibility());
      Assert.assertEquals(2, anonymous.getSuperTypes().size());
      Assert.assertEquals("java.lang.Iterable<T>", IterableExtensions.<JvmTypeReference>lastOrNull(anonymous.getSuperTypes()).getQualifiedName());
      Assert.assertEquals(2, anonymous.getMembers().size());
      final JvmMember constructor = IterableExtensions.<JvmMember>lastOrNull(anonymous.getMembers());
      Assert.assertTrue((constructor instanceof JvmConstructor));
      Assert.assertEquals(0, ((JvmConstructor) constructor).getTypeParameters().size());
      final JvmMember overriding = IterableExtensions.<JvmMember>head(anonymous.getMembers());
      Assert.assertTrue((overriding instanceof JvmOperation));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNestedClass_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class Nested0 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("interface Nested1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("annotation Nested2 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("enum Nested3 {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("X");
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
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(this.clazz(_builder.toString()));
      Assert.assertEquals(2, clazz.getMembers().size());
      JvmMember _head = IterableExtensions.<JvmMember>head(clazz.getMembers());
      Assert.assertTrue((_head instanceof JvmGenericType));
      JvmMember _head_1 = IterableExtensions.<JvmMember>head(clazz.getMembers());
      final JvmGenericType nested0 = ((JvmGenericType) _head_1);
      Assert.assertEquals("Nested0", nested0.getSimpleName());
      Assert.assertTrue(nested0.isStatic());
      Assert.assertEquals(2, nested0.getMembers().size());
      JvmMember _head_2 = IterableExtensions.<JvmMember>head(nested0.getMembers());
      Assert.assertTrue((_head_2 instanceof JvmGenericType));
      JvmMember _head_3 = IterableExtensions.<JvmMember>head(nested0.getMembers());
      final JvmGenericType nested1 = ((JvmGenericType) _head_3);
      Assert.assertEquals("Nested1", nested1.getSimpleName());
      Assert.assertTrue(nested1.isStatic());
      Assert.assertEquals(2, nested1.getMembers().size());
      JvmMember _head_4 = IterableExtensions.<JvmMember>head(nested1.getMembers());
      Assert.assertTrue((_head_4 instanceof JvmAnnotationType));
      JvmMember _head_5 = IterableExtensions.<JvmMember>head(nested1.getMembers());
      final JvmAnnotationType nested2 = ((JvmAnnotationType) _head_5);
      Assert.assertEquals("Nested2", nested2.getSimpleName());
      Assert.assertTrue(nested2.isStatic());
      Assert.assertEquals(2, nested1.getMembers().size());
      JvmMember _lastOrNull = IterableExtensions.<JvmMember>lastOrNull(nested1.getMembers());
      Assert.assertTrue((_lastOrNull instanceof JvmEnumerationType));
      JvmMember _lastOrNull_1 = IterableExtensions.<JvmMember>lastOrNull(nested1.getMembers());
      final JvmEnumerationType nested3 = ((JvmEnumerationType) _lastOrNull_1);
      Assert.assertEquals("Nested3", nested3.getSimpleName());
      Assert.assertTrue(nested3.isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmTypeParameter_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo< {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.file(_builder.toString(), false, false).getXtendTypes());
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
      EList<JvmTypeParameter> _typeParameters = clazz.getTypeParameters();
      String _plus = ("" + _typeParameters);
      Assert.assertTrue(_plus, clazz.getTypeParameters().isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmTypeParameter_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo<T> {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.file(_builder.toString(), false, false).getXtendTypes());
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
      EList<JvmTypeParameter> _typeParameters = clazz.getTypeParameters();
      String _plus = ("" + _typeParameters);
      Assert.assertEquals(_plus, 1, clazz.getTypeParameters().size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmTypeParameter_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new <() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.file(_builder.toString(), false, false).getXtendTypes());
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
      final JvmConstructor member = IterableExtensions.<JvmConstructor>head(Iterables.<JvmConstructor>filter(clazz.getMembers(), JvmConstructor.class));
      EList<JvmTypeParameter> _typeParameters = member.getTypeParameters();
      String _plus = ("" + _typeParameters);
      Assert.assertTrue(_plus, member.getTypeParameters().isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmTypeParameter_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new <T>() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.file(_builder.toString(), false, false).getXtendTypes());
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
      final JvmConstructor member = IterableExtensions.<JvmConstructor>head(Iterables.<JvmConstructor>filter(clazz.getMembers(), JvmConstructor.class));
      EList<JvmTypeParameter> _typeParameters = member.getTypeParameters();
      String _plus = ("" + _typeParameters);
      Assert.assertEquals(_plus, 1, member.getTypeParameters().size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmTypeParameter_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def < foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.file(_builder.toString(), false, false).getXtendTypes());
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
      final JvmOperation member = IterableExtensions.<JvmOperation>head(Iterables.<JvmOperation>filter(clazz.getMembers(), JvmOperation.class));
      Assert.assertNull(member);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmTypeParameter_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <> foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.file(_builder.toString(), false, false).getXtendTypes());
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
      final JvmOperation member = IterableExtensions.<JvmOperation>head(Iterables.<JvmOperation>filter(clazz.getMembers(), JvmOperation.class));
      EList<JvmTypeParameter> _typeParameters = member.getTypeParameters();
      String _plus = ("" + _typeParameters);
      Assert.assertTrue(_plus, member.getTypeParameters().isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJvmTypeParameter_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> String foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this.file(_builder.toString(), false, false).getXtendTypes());
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
      final JvmOperation member = IterableExtensions.<JvmOperation>head(Iterables.<JvmOperation>filter(clazz.getMembers(), JvmOperation.class));
      EList<JvmTypeParameter> _typeParameters = member.getTypeParameters();
      String _plus = ("" + _typeParameters);
      Assert.assertEquals(_plus, 1, member.getTypeParameters().size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
