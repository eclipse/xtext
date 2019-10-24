/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.tests.DomainmodelInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xtype.XtypePackage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class ValidationTests {
  @Inject
  @Extension
  private ParseHelper<DomainModel> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testImportUnused() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("entity X {}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this._parseHelper.parse(_builder), XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportUnused_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("entity X {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("sb: java.util.List<String>");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this._parseHelper.parse(_builder), XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportUnused_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("entity X {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("sb : List<String>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() : List<String> {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("sb");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportUnused_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.Map$Entry");
      _builder.newLine();
      _builder.append("entity X {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("sb: Entry<String, String>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() : Entry<String, String> {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("sb");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportUnused_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.Map");
      _builder.newLine();
      _builder.append("entity X { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("sb: Map$Entry<String, String> ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() : Map$Entry<String, String> {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("sb");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportUnused_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.Map$Entry");
      _builder.newLine();
      _builder.append("entity X {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("sb: Map$Entry<String, String>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo(): Map$Entry<String, String> {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("sb");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportUnused_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.awt.Label");
      _builder.newLine();
      _builder.append("/** {@link Label} */ ");
      _builder.newLine();
      _builder.append("entity X{}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportUnused_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.awt.Label");
      _builder.newLine();
      _builder.append("/** @see Label */");
      _builder.newLine();
      _builder.append("entity X{}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportDuplicate() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("entity X {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("sb: List<String>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() : List<String> {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("sb");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this._parseHelper.parse(_builder), XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportCollision() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("import java.awt.List");
      _builder.newLine();
      _builder.append("entity X {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("sb: List");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() : List {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("sb");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_COLLISION);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportWildcard() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.*");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("entity X {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("sb: List<String>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() : List<String> {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("sb");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this._parseHelper.parse(_builder), XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_WILDCARD_DEPRECATED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportConflictWithTypeInSameFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List ");
      _builder.newLine();
      _builder.append("entity List {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_CONFLICT);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportNoConflictWithTypeInSameFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("entity List2 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicatedProperty() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity E {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("p : String");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("p : String");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      DomainModel _parse = this._parseHelper.parse(model);
      final Procedure1<DomainModel> _function = (DomainModel it) -> {
        this.assertNumberOfIssues(it, 2);
        this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.PROPERTY, org.eclipse.xtext.example.domainmodel.validation.IssueCodes.DUPLICATE_PROPERTY, model.indexOf("p"), 1, "Duplicate property p");
        this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.PROPERTY, org.eclipse.xtext.example.domainmodel.validation.IssueCodes.DUPLICATE_PROPERTY, model.lastIndexOf("p"), 1, "Duplicate property p");
      };
      ObjectExtensions.<DomainModel>operator_doubleArrow(_parse, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicatedOperation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity E {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      DomainModel _parse = this._parseHelper.parse(model);
      final Procedure1<DomainModel> _function = (DomainModel it) -> {
        this.assertNumberOfIssues(it, 2);
        this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.OPERATION, org.eclipse.xtext.example.domainmodel.validation.IssueCodes.DUPLICATE_OPERATION, model.indexOf("foo"), 3, "Duplicate operation foo");
        this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.OPERATION, org.eclipse.xtext.example.domainmodel.validation.IssueCodes.DUPLICATE_OPERATION, model.lastIndexOf("foo"), 3, "Duplicate operation foo");
      };
      ObjectExtensions.<DomainModel>operator_doubleArrow(_parse, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicatedOperationWithDifferentSignatureIsAllowed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity E {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op m(int i) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFeatureAndOperationWithSameNameIsAllowed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity E {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("m : String");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExplicitGetterReplacesTheGeneratedOne() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity E {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("name : String");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op getName() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return name");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExplicitSetterReplacesTheGeneratedOne() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity E {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("name : String");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// even if it\'s not void");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op setName(String n) : String {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.name = n");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicatedOperationWithDifferentSignatureWithSameTypeErasure() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity E {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op m(java.util.List<String> l1) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op m(java.util.List<Integer> l2) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      DomainModel _parse = this._parseHelper.parse(model);
      final Procedure1<DomainModel> _function = (DomainModel it) -> {
        this.assertNumberOfIssues(it, 2);
        this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.OPERATION, org.eclipse.xtext.example.domainmodel.validation.IssueCodes.DUPLICATE_OPERATION, model.indexOf("m"), 1, "Duplicate operation m");
        this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.OPERATION, org.eclipse.xtext.example.domainmodel.validation.IssueCodes.DUPLICATE_OPERATION, model.lastIndexOf("m"), 1, "Duplicate operation m");
      };
      ObjectExtensions.<DomainModel>operator_doubleArrow(_parse, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertNumberOfIssues(final DomainModel domainModel, final int expectedNumberOfIssues) {
    Assert.assertEquals(expectedNumberOfIssues, this._validationTestHelper.validate(domainModel).size());
  }
}
