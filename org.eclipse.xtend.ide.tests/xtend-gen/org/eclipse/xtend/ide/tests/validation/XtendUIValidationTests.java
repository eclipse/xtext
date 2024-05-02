/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.validation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Objects;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XtypePackage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendUIValidationTests extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;

  @Inject
  private ValidationTestHelper helper;

  @Inject
  private IPreferenceStoreAccess prefStoreAccess;

  @Inject
  private OnChangeEvictingCache cache;

  @Override
  public void tearDown() throws Exception {
    this.testHelper.tearDown();
  }

  @Test
  public void testWrongPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package my.foo.pack");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertError(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.WRONG_PACKAGE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWrongFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertWarning(xtendFile, XtendPackage.Literals.XTEND_TYPE_DECLARATION, IssueCodes.WRONG_FILE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNoWrongFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertNoWarnings(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.WRONG_FILE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testForbiddenImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertError(xtendFile.getImportSection().getImportDeclarations().get(0), XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDiscouragedImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertWarning(xtendFile.getImportSection().getImportDeclarations().get(0), XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testForbiddenImportInnerClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertError(xtendFile.getImportSection().getImportDeclarations().get(0), XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDiscouragedImportInnerClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertWarning(xtendFile.getImportSection().getImportDeclarations().get(0), XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testValidImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(List<?> l){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Foo.xtend", _builder.toString());
      this.helper.assertNoIssues(xtendFile.getImportSection().getImportDeclarations().get(0));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testForbiddenConstructorCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("RestrictedClass x = new RestrictedClass");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertError(xtendFile.getImportSection().getImportDeclarations().get(0), XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendField field = ((XtendField) _head);
      this.helper.assertError(field.getType(), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      this.helper.assertError(field.getInitialValue(), XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDiscouragedConstructorCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("InternalClass x = new InternalClass");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertWarning(xtendFile.getImportSection().getImportDeclarations().get(0), XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendField field = ((XtendField) _head);
      this.helper.assertWarning(field.getType(), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      this.helper.assertWarning(field.getInitialValue(), XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDiscouragedConstructorCallInnernClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("InnerInternalClass x = new InnerInternalClass");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertWarning(xtendFile.getImportSection().getImportDeclarations().get(0), XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendField field = ((XtendField) _head);
      this.helper.assertWarning(field.getType(), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
      this.helper.assertWarning(field.getInitialValue(), XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testForbiddenConstructorCallInnerClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("InnerRestrictedClass x = new InnerRestrictedClass");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.assertError(xtendFile.getImportSection().getImportDeclarations().get(0), XtypePackage.Literals.XIMPORT_DECLARATION, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendField field = ((XtendField) _head);
      this.helper.assertError(field.getType(), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      this.helper.assertError(field.getInitialValue(), XbasePackage.Literals.XCONSTRUCTOR_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testForbiddenTypeUsageInnernClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendFunction function = ((XtendFunction) _head);
      this.helper.assertError(function.getParameters().get(0), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDiscouragedTypeUsageInnernClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass x){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendFunction function = ((XtendFunction) _head);
      this.helper.assertWarning(function.getParameters().get(0), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testForbiddenTypeUsage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendFunction function = ((XtendFunction) _head);
      this.helper.assertError(function.getParameters().get(0), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testForbiddenArrayTypeUsage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass[] x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendFunction function = ((XtendFunction) _head);
      this.helper.assertError(function.getParameters().get(0), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testParameterizedTypeReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass<org.eclipse.xtend.core.tests.internal.InternalClass> x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
      final XtendFunction function = ((XtendFunction) _head);
      final XtendParameter parameter = function.getParameters().get(0);
      JvmTypeReference _parameterType = parameter.getParameterType();
      final JvmParameterizedTypeReference type = ((JvmParameterizedTypeReference) _parameterType);
      final JvmTypeReference typeParameter = type.getArguments().get(0);
      this.helper.assertError(type, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      this.helper.assertWarning(typeParameter, TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.DISCOURAGED_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  @Ignore("Enable on demand")
  public void testPerformance_1() {
    this.testPerformance();
  }

  @Test
  @Ignore("Enable on demand")
  public void testPerformance_2() {
    this.testPerformance();
  }

  public void testPerformance() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.restricted.RestrictedClass");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.core.tests.internal.InternalClass");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      {
        IntegerRange _upTo = new IntegerRange(0, 200);
        for(final Integer i : _upTo) {
          _builder.append("RestrictedClass x");
          _builder.append(i);
          _builder.append(" = new RestrictedClass");
          _builder.newLineIfNotEmpty();
          _builder.append("InternalClass y");
          _builder.append(i);
          _builder.append(" = new InternalClass");
          _builder.newLineIfNotEmpty();
          _builder.append("def bar(InternalClass p1");
          _builder.append(i);
          _builder.append(", RestrictedClass p2");
          _builder.append(i);
          _builder.append("){}");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("Clazz.xtend", _builder.toString());
      this.helper.validate(xtendFile);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIssueCodeDelegation() {
    try {
      final IJavaProject javaProject = JavaCore.create(this.testHelper.getProject());
      final String javaSeverity = javaProject.getOption(JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE, true);
      try {
        boolean _notEquals = (!Objects.equals(javaSeverity, "error"));
        if (_notEquals) {
          Assert.fail((("Wrong expectation Java compiler option \'" + JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE) + "\' should be \'error\' by default"));
        }
        String otherSeverity = "warning";
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class ValidationClazz {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass x) {}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        final XtendFile xtendFile = this.testHelper.xtendFile("ValidationClazz.xtend", _builder.toString());
        XtendMember _head = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class)).getMembers());
        final XtendFunction function = ((XtendFunction) _head);
        this.helper.assertError(function.getParameters().get(0), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
        this.cache.clear(xtendFile.eResource());
        javaProject.setOption(JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE, otherSeverity);
        this.helper.assertWarning(function.getParameters().get(0), TypesPackage.Literals.JVM_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.FORBIDDEN_REFERENCE);
      } finally {
        javaProject.setOption(JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE, javaSeverity);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testConfigurableIssueCode() {
    try {
      final IPersistentPreferenceStore xtendPrefStore = this.getXtendPreferencesStore();
      try {
        xtendPrefStore.setValue(IssueCodes.UNUSED_PRIVATE_MEMBER, "warning");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class TestConfigurableIssueCode {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private String unusedField = \"unusedField\"");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        XtendFile _xtendFile = this.testHelper.xtendFile("TestConfigurableIssueCode.xtend", _builder.toString());
        final Procedure1<XtendFile> _function = (XtendFile it) -> {
          final XtendMember unusedField = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(it.getXtendTypes(), XtendClass.class)).getMembers());
          this.helper.assertWarning(unusedField, XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNUSED_PRIVATE_MEMBER);
        };
        ObjectExtensions.<XtendFile>operator_doubleArrow(_xtendFile, _function);
        xtendPrefStore.setValue(IssueCodes.UNUSED_PRIVATE_MEMBER, "error");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("class TestConfigurableIssueCode {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("private String unusedField = \"unusedField\"");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        XtendFile _xtendFile_1 = this.testHelper.xtendFile("TestConfigurableIssueCode.xtend", _builder_1.toString());
        final Procedure1<XtendFile> _function_1 = (XtendFile it) -> {
          final XtendMember unusedField = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(it.getXtendTypes(), XtendClass.class)).getMembers());
          this.helper.assertError(unusedField, XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNUSED_PRIVATE_MEMBER);
        };
        ObjectExtensions.<XtendFile>operator_doubleArrow(_xtendFile_1, _function_1);
      } finally {
        xtendPrefStore.setToDefault(IssueCodes.UNUSED_PRIVATE_MEMBER);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJavaDocRefs_Delegation() throws Exception {
    final IJavaProject javaProject = JavaCore.create(this.testHelper.getProject());
    final String javaSeverity = javaProject.getOption(JavaCore.COMPILER_PB_INVALID_JAVADOC, true);
    try {
      boolean _notEquals = (!Objects.equals(javaSeverity, "ignore"));
      if (_notEquals) {
        Assert.fail((("Wrong expectation Java compiler option \'" + JavaCore.COMPILER_PB_INVALID_JAVADOC) + "\' should be \'ignore\' by default"));
      }
      String otherSeverity = "warning";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class ValidationClazz {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link List}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def doStuff(){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.testHelper.xtendFile("ValidationClazz.xtend", _builder.toString());
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass clazz = ((XtendClass) _head);
      final XtendMember member = IterableExtensions.<XtendMember>head(clazz.getMembers());
      this.helper.assertNoIssues(member);
      this.cache.clear(xtendFile.eResource());
      javaProject.setOption(JavaCore.COMPILER_PB_INVALID_JAVADOC, otherSeverity);
      this.helper.assertWarning(member, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc", "List", "cannot be resolved to a type");
    } finally {
      javaProject.setOption(JavaCore.COMPILER_PB_INVALID_JAVADOC, javaSeverity);
    }
  }

  public IPersistentPreferenceStore getXtendPreferencesStore() {
    IPreferenceStore _writablePreferenceStore = this.prefStoreAccess.getWritablePreferenceStore(this.testHelper.getProject());
    return ((IPersistentPreferenceStore) _writablePreferenceStore);
  }
}
