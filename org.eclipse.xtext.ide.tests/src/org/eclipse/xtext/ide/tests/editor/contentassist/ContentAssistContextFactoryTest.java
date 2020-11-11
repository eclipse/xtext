/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.editor.contentassist;

import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class ContentAssistContextFactoryTest {
	@Inject
	private ContentAssistContextTestHelper contentAssistContextTestHelper;

	@Inject
	private ContentAssistContextFactory factory;

	@Inject
	private TestLanguageGrammarAccess grammar;

	@Test
	public void testSimple1() throws Exception {
		contentAssistContextTestHelper.setDocument(
				"type Foo <|>{\n" +
				"	int bar\n" +
				"}\n");
		Assert.assertEquals(
				"context0 {\n" +
				"	Keyword: TypeDeclaration:'extends'\n" +
				"	Keyword: TypeDeclaration:'{'\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}

	@Test
	public void testSimple2() throws Exception {
		contentAssistContextTestHelper.setDocument(
				"type Foo {\n" +
				"	<|>int bar\n" +
				"}\n");
		Assert.assertEquals(
				"context0 {\n" +
				"	Assignment: TypeDeclaration:members+= *\n" +
				"	RuleCall: TypeDeclaration:members+=Member\n" +
				"	RuleCall: Member:Property\n" +
				"	Assignment: Property:type= \n" +
				"	RuleCall: Property:type=Type\n" +
				"	RuleCall: Type:TypeReference\n" +
				"	Assignment: TypeReference:typeRef= \n" +
				"	RuleCall: Type:PrimitiveType\n" +
				"	Assignment: PrimitiveType:name= \n" +
				"	Keyword: PrimitiveType:name='string'\n" +
				"	Keyword: PrimitiveType:name='int'\n" +
				"	Keyword: PrimitiveType:name='boolean'\n" +
				"	Keyword: PrimitiveType:name='void'\n" +
				"	RuleCall: Member:Operation\n" +
				"	Keyword: Operation:'op'\n" +
				"	Keyword: TypeDeclaration:'}'\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}

	@Test
	public void testBeginning() throws Exception {
		contentAssistContextTestHelper.setDocument(
				"<|>type Foo {\n" +
				"	int bar\n" +
				"}\n");
		Assert.assertEquals(
				"context0 {\n" +
				"	Assignment: Model:elements+= *\n" +
				"	RuleCall: Model:elements+=AbstractElement\n" +
				"	RuleCall: AbstractElement:PackageDeclaration\n" +
				"	Keyword: PackageDeclaration:'package'\n" +
				"	RuleCall: AbstractElement:TypeDeclaration\n" +
				"	Keyword: TypeDeclaration:'type'\n" +
				"	RuleCall: <AbstractElement not contained in AbstractRule!>:Model\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}

	@Test
	public void testCustomEntryPoint() throws Exception {
		contentAssistContextTestHelper.setEntryPoint(grammar.getPropertyRule());
		contentAssistContextTestHelper.setDocument("int <|>bar");
		Assert.assertEquals(
				"context0 {\n" +
				"	Assignment: Type:arrayDiemensions+= \n" +
				"	Keyword: Type:arrayDiemensions+='['\n" +
				"	Assignment: Property:name= \n" +
				"	RuleCall: Property:name=ID\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}

	@Test
	public void testCustomEntryPointBeginning() throws Exception {
		contentAssistContextTestHelper.setEntryPoint(grammar.getPropertyRule());
		contentAssistContextTestHelper.setDocument("<|>int bar");
		Assert.assertEquals(
				"context0 {\n" +
				"	Assignment: Property:type= \n" +
				"	RuleCall: Property:type=Type\n" +
				"	RuleCall: Type:TypeReference\n" +
				"	Assignment: TypeReference:typeRef= \n" +
				"	RuleCall: Type:PrimitiveType\n" +
				"	Assignment: PrimitiveType:name= \n" +
				"	Keyword: PrimitiveType:name='string'\n" +
				"	Keyword: PrimitiveType:name='int'\n" +
				"	Keyword: PrimitiveType:name='boolean'\n" +
				"	Keyword: PrimitiveType:name='void'\n" +
				"	RuleCall: <AbstractElement not contained in AbstractRule!>:Type\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}
}
