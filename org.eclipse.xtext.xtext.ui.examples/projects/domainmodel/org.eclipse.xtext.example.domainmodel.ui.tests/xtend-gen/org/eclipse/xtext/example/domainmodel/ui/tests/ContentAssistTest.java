/**
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jan Koehnlein - copied and adapted from Xtend
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class ContentAssistTest extends AbstractContentAssistTest {
  @Test
  public void testImportCompletion() throws Exception {
    this.newBuilder().append("import java.util.Da").assertText("java.util.Date");
  }

  @Test
  public void testImportCompletion_1() throws Exception {
    this.newBuilder().append("import LinkedHashSet").assertText("java.util.LinkedHashSet");
  }

  @Test
  public void testTypeCompletion() throws Exception {
    this.newBuilder().append("entity Foo { bar: LinkedHashSet").assertText("java.util.LinkedHashSet");
  }

  @Test
  public void testEntityTemplateProposal() throws Exception {
    ContentAssistProcessorTestBuilder _applyProposal = this.newBuilder().applyProposal("Entity - template for an Entity");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity name {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _applyProposal.expectContent(_builder.toString());
  }

  @Test
  public void testPackageTemplateProposal() throws Exception {
    ContentAssistProcessorTestBuilder _applyProposal = this.newBuilder().applyProposal("Package - template for a Package");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package name {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _applyProposal.expectContent(_builder.toString());
  }

  @Test
  public void testPropertyTemplateProposal() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.c, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity E {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("propertyName : typeName");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertContentAssistant(_builder, 
      new String[] { "Operation - template for an Operation", "Property - template for a Property", "op" }, "Property - template for a Property", _builder_1.toString());
  }

  @Test
  public void testOperationTemplateProposal() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.c, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity E {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("op name (paramType1 paramName1) : returnType {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertContentAssistant(_builder, 
      new String[] { "Operation - template for an Operation", "Property - template for a Property", "op" }, "Operation - template for an Operation", _builder_1.toString());
  }
}
