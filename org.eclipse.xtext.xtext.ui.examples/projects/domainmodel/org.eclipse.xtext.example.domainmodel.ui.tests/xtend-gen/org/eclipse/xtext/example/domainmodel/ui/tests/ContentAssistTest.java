/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.ui.tests.DomainmodelUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jan Koehnlein - copied and adapted from Xtend
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class ContentAssistTest extends AbstractContentAssistTest {
  private final String c = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<|>");
      return _builder.toString();
    }
  }.apply();
  
  @Test
  public void testImportCompletion() {
    try {
      this.newBuilder().append("import java.util.Da").assertText("java.util.Date");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportCompletion_1() {
    try {
      this.newBuilder().append("import LinkedHashSet").assertText("java.util.LinkedHashSet");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeCompletion() {
    try {
      this.newBuilder().append("entity Foo { bar: LinkedHashSet").assertText("java.util.LinkedHashSet");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEntityTemplateProposal() {
    try {
      ContentAssistProcessorTestBuilder _applyProposal = this.newBuilder().applyProposal("Entity - template for an Entity");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity name {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _applyProposal.expectContent(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPackageTemplateProposal() {
    try {
      ContentAssistProcessorTestBuilder _applyProposal = this.newBuilder().applyProposal("Package - template for a Package");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package name {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _applyProposal.expectContent(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPropertyTemplateProposal() {
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
    this.testContentAssistant(_builder, 
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Operation - template for an Operation", "Property - template for a Property", "op")), "Property - template for a Property", _builder_1.toString());
  }
  
  @Test
  public void testOperationTemplateProposal() {
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
    this.testContentAssistant(_builder, 
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Operation - template for an Operation", "Property - template for a Property", "op")), "Operation - template for an Operation", _builder_1.toString());
  }
  
  private void testContentAssistant(final CharSequence text, final List<String> expectedProposals, final String proposalToApply, final String expectedContent) {
    try {
      final int cursorPosition = text.toString().indexOf(this.c);
      final String content = text.toString().replace(this.c, "");
      this.newBuilder().append(content).assertTextAtCursorPosition(cursorPosition, ((String[])Conversions.unwrapArray(expectedProposals, String.class))).applyProposal(cursorPosition, proposalToApply).expectContent(expectedContent);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
