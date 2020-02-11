/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.editor.contentassist;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ide.editor.contentassist.antlr.PartialContentAssistContextFactory;
import org.eclipse.xtext.ide.tests.editor.contentassist.ContentAssistContextTestHelper;
import org.eclipse.xtext.ide.tests.testlanguage.PartialContentAssistTestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(PartialContentAssistTestLanguageIdeInjectorProvider.class)
@SuppressWarnings("all")
public class PartialContentAssistTestLanguageContextFactoryTest {
  @Inject
  @Extension
  private ContentAssistContextTestHelper _contentAssistContextTestHelper;
  
  @Inject
  private ContentAssistContextFactory factory;
  
  @Inject
  private PartialContentAssistTestLanguageGrammarAccess grammar;
  
  @Test
  public void testConfig() {
    Assert.assertTrue((this.factory instanceof PartialContentAssistContextFactory));
  }
  
  @Test
  public void testSimple1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Foo <|>{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._contentAssistContextTestHelper.setDocument(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("context0 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: TypeDeclaration:\'extends\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: TypeDeclaration:\'{\'");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this._contentAssistContextTestHelper.firstSetGrammarElementsToString(this.factory));
  }
  
  @Test
  public void testSimple2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>int bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._contentAssistContextTestHelper.setDocument(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("context0 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: TypeDeclaration:properties+= *");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: TypeDeclaration:properties+=Property");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: Property:type= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: Property:type=\'int\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: Property:type=\'bool\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: TypeDeclaration:\'}\'");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this._contentAssistContextTestHelper.firstSetGrammarElementsToString(this.factory));
  }
  
  @Test
  public void testBeginning() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<|>type Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._contentAssistContextTestHelper.setDocument(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("context0 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: TypeDeclaration:\'type\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: <AbstractElement not contained in AbstractRule!>:TypeDeclaration");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this._contentAssistContextTestHelper.firstSetGrammarElementsToString(this.factory));
  }
  
  @Test
  public void testCustomEntryPoint() {
    this._contentAssistContextTestHelper.setEntryPoint(this.grammar.getPropertyRule());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int <|>bar");
    _builder.newLine();
    this._contentAssistContextTestHelper.setDocument(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("context0 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: Property:name= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Property:name=ID");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this._contentAssistContextTestHelper.firstSetGrammarElementsToString(this.factory));
  }
  
  @Test
  public void testCustomEntryPointBeginning() {
    this._contentAssistContextTestHelper.setEntryPoint(this.grammar.getPropertyRule());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<|>int bar");
    _builder.newLine();
    this._contentAssistContextTestHelper.setDocument(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("context0 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: Property:type= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: Property:type=\'int\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: Property:type=\'bool\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: <AbstractElement not contained in AbstractRule!>:Property");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this._contentAssistContextTestHelper.firstSetGrammarElementsToString(this.factory));
  }
}
