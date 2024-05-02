/**
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class DomainmodelParsingTest {
  @Inject
  @Extension
  private ParseHelper<DomainModel> _parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;

  @Test
  public void testParsing() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package example {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entity MyEntity {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("property : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this._parseHelper.parse(_builder);
    AbstractElement _head = IterableExtensions.<AbstractElement>head(model.getElements());
    final PackageDeclaration pack = ((PackageDeclaration) _head);
    Assert.assertEquals("example", pack.getName());
    AbstractElement _head_1 = IterableExtensions.<AbstractElement>head(pack.getElements());
    final Entity entity = ((Entity) _head_1);
    Assert.assertEquals("MyEntity", entity.getName());
    Feature _head_2 = IterableExtensions.<Feature>head(entity.getFeatures());
    final Property property = ((Property) _head_2);
    Assert.assertEquals("property", property.getName());
    Assert.assertEquals("java.lang.String", property.getType().getIdentifier());
  }

  @Test
  public void testJvmTypeReferencesValidator() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("package example {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entity MyEntity {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("p : List<int>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._validationTestHelper.assertError(this._parseHelper.parse(_builder), 
      TypesPackage.Literals.JVM_TYPE_REFERENCE, 
      IssueCodes.INVALID_USE_OF_TYPE, 
      "The primitive \'int\' cannot be a type argument");
  }

  @Test
  public void testParsingAndLinking() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package example {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entity MyEntity {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("property : String");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("op foo(String s) : String {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("this.property = s");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return s.toUpperCase");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }

  @Test
  public void testParsingAndLinkingWithImports() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("package example {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entity MyEntity {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("p : List<String>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }

  @Test
  public void testReturnTypeInference() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package example {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("entity MyEntity {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("property : String");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("op foo(String s) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return property.toUpperCase + s");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this._parseHelper.parse(_builder);
    AbstractElement _head = IterableExtensions.<AbstractElement>head(model.getElements());
    final PackageDeclaration pack = ((PackageDeclaration) _head);
    AbstractElement _head_1 = IterableExtensions.<AbstractElement>head(pack.getElements());
    final Entity entity = ((Entity) _head_1);
    Feature _lastOrNull = IterableExtensions.<Feature>lastOrNull(entity.getFeatures());
    final Operation op = ((Operation) _lastOrNull);
    EObject _head_2 = IterableExtensions.<EObject>head(this._iJvmModelAssociations.getJvmElements(op));
    final JvmOperation method = ((JvmOperation) _head_2);
    Assert.assertEquals("String", method.getReturnType().getSimpleName());
  }
}
