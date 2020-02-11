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
import org.eclipse.xtext.ide.tests.editor.contentassist.ContentAssistContextTestHelper;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;
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
@InjectWith(TestLanguageIdeInjectorProvider.class)
@SuppressWarnings("all")
public class ContentAssistContextFactoryTest {
  @Inject
  @Extension
  private ContentAssistContextTestHelper _contentAssistContextTestHelper;
  
  @Inject
  private ContentAssistContextFactory factory;
  
  @Inject
  private TestLanguageGrammarAccess grammar;
  
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
    _builder_1.append("Assignment: TypeDeclaration:members+= *");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: TypeDeclaration:members+=Member");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Member:Property");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: Property:type= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Property:type=Type");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Type:TypeReference");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: TypeReference:typeRef= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Type:PrimitiveType");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: PrimitiveType:name= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PrimitiveType:name=\'string\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PrimitiveType:name=\'int\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PrimitiveType:name=\'boolean\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PrimitiveType:name=\'void\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Member:Operation");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: Operation:\'op\'");
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
    _builder_1.append("Assignment: Model:elements+= *");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Model:elements+=AbstractElement");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: AbstractElement:PackageDeclaration");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PackageDeclaration:\'package\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: AbstractElement:TypeDeclaration");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: TypeDeclaration:\'type\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: <AbstractElement not contained in AbstractRule!>:Model");
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
    _builder_1.append("Assignment: Type:arrayDiemensions+= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: Type:arrayDiemensions+=\'[\'");
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
    _builder_1.append("RuleCall: Property:type=Type");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Type:TypeReference");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: TypeReference:typeRef= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: Type:PrimitiveType");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Assignment: PrimitiveType:name= ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PrimitiveType:name=\'string\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PrimitiveType:name=\'int\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PrimitiveType:name=\'boolean\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Keyword: PrimitiveType:name=\'void\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("RuleCall: <AbstractElement not contained in AbstractRule!>:Type");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this._contentAssistContextTestHelper.firstSetGrammarElementsToString(this.factory));
  }
}
