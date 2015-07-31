/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.validation.LinkingDiagnosticTypeAwareMessageProducer;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xtype.XtypePackage;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XImportSectionValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void checkUnnecessaryImportForEnumLiteral_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.annotation.RetentionPolicy.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(java.lang.annotation.RetentionPolicy p) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch(p) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case CLASS: true");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default: false");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "The import \'java.lang.annotation.RetentionPolicy\' is never used.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUnnecessaryImportForEnumLiteral_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.annotation.ElementType.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(java.lang.annotation.RetentionPolicy p) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch(p) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case TYPE: true");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default: false");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUnnecessaryImportForEnumLiteral_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.annotation.RetentionPolicy.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@java.lang.annotation.Retention(CLASS)");
      _builder.newLine();
      _builder.append("annotation A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "The import \'java.lang.annotation.RetentionPolicy\' is never used.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUnnecessaryImportForEnumLiteral_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.annotation.ElementType.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@java.lang.annotation.Target(TYPE, METHOD)");
      _builder.newLine();
      _builder.append("annotation A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "The import \'java.lang.annotation.ElementType\' is never used.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUnnecessaryImportForEnumLiteral_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.annotation.ElementType.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@java.lang.annotation.Retention(TYPE, METHOD)");
      _builder.newLine();
      _builder.append("annotation A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUnnecessaryImportForEnumLiteral_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.annotation.RetentionPolicy.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@java.lang.annotation.Retention(value=CLASS)");
      _builder.newLine();
      _builder.append("annotation A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "The import \'java.lang.annotation.RetentionPolicy\' is never used.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUnnecessaryImportForEnumLiteral_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.annotation.ElementType.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@java.lang.annotation.Target(value=#[TYPE, METHOD])");
      _builder.newLine();
      _builder.append("annotation A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "The import \'java.lang.annotation.ElementType\' is never used.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUnnecessaryImportForEnumLiteral_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.annotation.ElementType.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@java.lang.annotation.Retention(value=#[TYPE, METHOD])");
      _builder.newLine();
      _builder.append("annotation A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.Integer.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
      this._validationTestHelper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.AMBIGUOUS_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer.valueOf");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
      this._validationTestHelper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.AMBIGUOUS_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer.valueOf");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
      this._validationTestHelper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.AMBIGUOUS_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithStaticAccess_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
      this._validationTestHelper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.AMBIGUOUS_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.Integer.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer.valueOf");
      this.assertFeatureCallError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
      this.assertFeatureCallError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertFeatureCallError(final XtendFile file, final EClass objectType) {
    final Resource resource = file.eResource();
    final List<Issue> allIssues = this._validationTestHelper.validate(resource);
    final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
      @Override
      public Boolean apply(final Issue it) {
        ResourceSet _resourceSet = resource.getResourceSet();
        URI _uriToProblem = it.getUriToProblem();
        EObject object = _resourceSet.getEObject(_uriToProblem, true);
        String[] _data = it.getData();
        final boolean featureCall = ((List<String>)Conversions.doWrapArray(_data)).contains(LinkingDiagnosticTypeAwareMessageProducer.FEATURE_CALL);
        boolean _and = false;
        boolean _and_1 = false;
        boolean _and_2 = false;
        String _code = it.getCode();
        boolean _equals = Objects.equal(_code, Diagnostic.LINKING_DIAGNOSTIC);
        if (!_equals) {
          _and_2 = false;
        } else {
          Severity _severity = it.getSeverity();
          boolean _tripleEquals = (_severity == Severity.ERROR);
          _and_2 = _tripleEquals;
        }
        if (!_and_2) {
          _and_1 = false;
        } else {
          boolean _isInstance = objectType.isInstance(object);
          _and_1 = _isInstance;
        }
        if (!_and_1) {
          _and = false;
        } else {
          _and = featureCall;
        }
        return Boolean.valueOf(_and);
      }
    };
    final Iterable<Issue> match = IterableExtensions.<Issue>filter(allIssues, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(match);
    if (_isEmpty) {
      Assert.fail("No Diagnostic.LINKING_DIAGNOSTIC issue with user data FEATURE_CALL found");
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
      this.assertFeatureCallError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
      this.assertFeatureCallError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportWithExtensionAccess_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.Integer");
      this._validationTestHelper.assertError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.AMBIGUOUS_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void unresolvedImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.math.BigDecimal.someMethod;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendFile _file = this.file(_string);
      this._validationTestHelper.assertError(_file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNRESOLVED, "java.math.BigDecimal.someMethod");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void unresolvedImport_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.math.BigDecimal.print;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendFile _file = this.file(_string);
      this._validationTestHelper.assertError(_file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNRESOLVED, "java.math.BigDecimal.print");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void unresolvedImport_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.math.BigDecimal.valueOf;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendFile _file = this.file(_string);
      this._validationTestHelper.assertNoErrors(_file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNRESOLVED, "java.math.BigDecimal.valueOf");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("copyValueOf(null as char[])");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(2)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(2)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "\'java.lang.String\'");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "\'java.lang.String.valueOf\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithStaticAccess_11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithExtensionAccess_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this.assertFeatureCallError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithExtensionAccess_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this.assertFeatureCallError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithExtensionAccess_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String.valueOf");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithExtensionAccess_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.valueOf");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "\'java.lang.String.valueOf\'");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "\'java.lang.String\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithExtensionAccess_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
      this.assertFeatureCallError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithExtensionAccess_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.valueOf");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "\'java.lang.String\'");
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "\'java.lang.String.valueOf\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithExtensionAccess_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDuplicateImportWithExtensionAccess_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1.valueOf");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertWarning(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED, "java.lang.String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportsNotMarkedAsUsedWhenTypeUnresolved() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension java.lang.String.*");
      _builder.newLine();
      _builder.append("import static extension java.lang.Integer.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      final XtendFile file = this.file(_string);
      this._validationTestHelper.assertNoWarnings(file, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
