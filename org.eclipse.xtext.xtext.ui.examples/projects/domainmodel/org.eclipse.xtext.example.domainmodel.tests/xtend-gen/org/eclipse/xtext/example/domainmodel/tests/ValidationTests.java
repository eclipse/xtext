/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
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
  public void testImportUnused() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity X {}");
    _builder.newLine();
    this._validationTestHelper.assertWarning(this._parseHelper.parse(_builder), XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
  }

  @Test
  public void testImportUnused_1() throws Exception {
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
  }

  @Test
  public void testImportUnused_2() throws Exception {
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
  }

  @Test
  public void testImportUnused_3() throws Exception {
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
  }

  @Test
  public void testImportUnused_4() throws Exception {
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
  }

  @Test
  public void testImportUnused_5() throws Exception {
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
  }

  @Test
  public void testImportUnused_6() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.awt.Label");
    _builder.newLine();
    _builder.append("/** {@link Label} */ ");
    _builder.newLine();
    _builder.append("entity X{}");
    _builder.newLine();
    this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
  }

  @Test
  public void testImportUnused_7() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.awt.Label");
    _builder.newLine();
    _builder.append("/** @see Label */");
    _builder.newLine();
    _builder.append("entity X{}");
    _builder.newLine();
    this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
  }

  @Test
  public void testImportDuplicate() throws Exception {
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
  }

  @Test
  public void testImportCollision() throws Exception {
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
  }

  @Test
  public void testImportWildcard() throws Exception {
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
  }

  @Test
  public void testImportConflictWithTypeInSameFile() throws Exception {
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
  }

  @Test
  public void testImportNoConflictWithTypeInSameFile() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity List2 {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }

  @Test
  public void testDuplicatedProperty() throws Exception {
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
      this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.PROPERTY, IssueCodes.DUPLICATE_FIELD, model.indexOf("p"), 1, "Duplicate field p");
      this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.PROPERTY, IssueCodes.DUPLICATE_FIELD, model.lastIndexOf("p"), 1, "Duplicate field p");
    };
    ObjectExtensions.<DomainModel>operator_doubleArrow(_parse, _function);
  }

  @Test
  public void testDuplicatedOperation() throws Exception {
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
      this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.OPERATION, IssueCodes.DUPLICATE_METHOD, model.indexOf("foo"), 3, "Duplicate method foo");
      this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.OPERATION, IssueCodes.DUPLICATE_METHOD, model.lastIndexOf("foo"), 3, "Duplicate method foo");
    };
    ObjectExtensions.<DomainModel>operator_doubleArrow(_parse, _function);
  }

  @Test
  public void testDuplicatedOperationWithDifferentSignatureIsAllowed() throws Exception {
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
  }

  @Test
  public void testFeatureAndOperationWithSameNameIsAllowed() throws Exception {
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
  }

  @Test
  public void testExplicitGetterReplacesTheGeneratedOne() throws Exception {
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
  }

  @Test
  public void testExplicitSetterReplacesTheGeneratedOne() throws Exception {
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
  }

  @Test
  public void testDuplicatedOperationWithDifferentSignatureWithSameTypeErasure() throws Exception {
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
      this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.OPERATION, IssueCodes.DUPLICATE_METHOD, model.indexOf("m"), 1, "The method m(List<String>) has the same erasure");
      this._validationTestHelper.assertError(it, DomainmodelPackage.Literals.OPERATION, IssueCodes.DUPLICATE_METHOD, model.lastIndexOf("m"), 1, "The method m(List<Integer>) has the same erasure");
    };
    ObjectExtensions.<DomainModel>operator_doubleArrow(_parse, _function);
  }

  private void assertNumberOfIssues(final DomainModel domainModel, final int expectedNumberOfIssues) {
    Assert.assertEquals(expectedNumberOfIssues, this._validationTestHelper.validate(domainModel).size());
  }
}
