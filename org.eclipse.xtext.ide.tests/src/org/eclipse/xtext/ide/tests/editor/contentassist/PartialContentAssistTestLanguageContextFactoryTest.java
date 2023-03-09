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
import org.eclipse.xtext.ide.editor.contentassist.antlr.PartialContentAssistContextFactory;
import org.eclipse.xtext.ide.tests.testlanguage.PartialContentAssistTestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialContentAssistTestLanguageGrammarAccess;
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
@InjectWith(PartialContentAssistTestLanguageIdeInjectorProvider.class)
public class PartialContentAssistTestLanguageContextFactoryTest {
	@Inject
	private ContentAssistContextTestHelper contentAssistContextTestHelper;

	@Inject
	private ContentAssistContextFactory factory;

	@Inject
	private PartialContentAssistTestLanguageGrammarAccess grammar;

	@Test
	public void testConfig() {
		Assert.assertTrue(factory instanceof PartialContentAssistContextFactory);
	}

	@Test
	public void testSimple1() throws Exception {
		contentAssistContextTestHelper.setDocument("type Foo <|>{\n" +
				"	int bar\n" +
				"}\n");
		Assert.assertEquals("context0 {\n" +
				"	Keyword: TypeDeclaration:'extends'\n" +
				"	Keyword: TypeDeclaration:'{'\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}

	@Test
	public void testSimple2() throws Exception {
		contentAssistContextTestHelper.setDocument("type Foo {\n" +
				"	<|>int bar\n" +
				"}\n");
		Assert.assertEquals(
				"context0 {\n" +
				"	Assignment: TypeDeclaration:properties+= *\n" +
				"	RuleCall: TypeDeclaration:properties+=Property\n" +
				"	Assignment: Property:type= \n" +
				"	Keyword: Property:type='int'\n" +
				"	Keyword: Property:type='bool'\n" +
				"	Keyword: TypeDeclaration:'}'\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}

	@Test
	public void testBeginning() throws Exception {
		contentAssistContextTestHelper.setDocument("<|>type Foo {\n" +
				"	int bar\n" +
				"}\n");
		Assert.assertEquals(
				"context0 {\n" +
				"	Keyword: TypeDeclaration:'type'\n" +
				"	RuleCall: <AbstractElement not contained in AbstractRule!>:TypeDeclaration\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}

	@Test
	public void testCustomEntryPoint() throws Exception {
		contentAssistContextTestHelper.setEntryPoint(grammar.getPropertyRule());
		contentAssistContextTestHelper.setDocument("int <|>bar");
		Assert.assertEquals("context0 {\n" +
				"	Assignment: Property:name= \n" +
				"	RuleCall: Property:name=ID\n" +
				"}\n".toString(),
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}

	@Test
	public void testCustomEntryPointBeginning() throws Exception {
		contentAssistContextTestHelper.setEntryPoint(grammar.getPropertyRule());
		contentAssistContextTestHelper.setDocument("<|>int bar");
		Assert.assertEquals(
				"context0 {\n" +
				"	Assignment: Property:type= \n" +
				"	Keyword: Property:type='int'\n" +
				"	Keyword: Property:type='bool'\n" +
				"	RuleCall: <AbstractElement not contained in AbstractRule!>:Property\n" +
				"}\n",
				contentAssistContextTestHelper.firstSetGrammarElementsToString(factory));
	}
}
