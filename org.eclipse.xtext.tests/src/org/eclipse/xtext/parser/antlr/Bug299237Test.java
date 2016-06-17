/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.List;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.antlr.bug299237Test.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug299237Test extends AbstractXtextTests implements ISyntaxErrorMessageProvider {
	
	private SyntaxErrorMessageProvider syntaxErrorProvider;

	private String expectedMessage;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new Bug299237TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new Bug299237TestLanguageRuntimeModule(){
					@SuppressWarnings("unused")
					public ISyntaxErrorMessageProvider bindSyntaxErrorProvider() {
						return Bug299237Test.this;
					}
				});
			}
		});
		syntaxErrorProvider = new SyntaxErrorMessageProvider();
	}
	
	@Test public void testValidModel_01() throws Exception {
		Model model = (Model) getModel("model a;");
		assertEquals("a", model.getName());
	}
	
	@Test public void testValidModel_02() throws Exception {
		Model model = (Model) getModel("MODEL a;");
		assertEquals("a", model.getName());
	}
	
	@Test public void testSyntaxError_01() throws Exception {
		Model model = (Model) getModelAndExpect("model a", 1);
		assertEquals("a", model.getName());
	}
	
	@Test public void testSyntaxError_02() throws Exception {
		Model model = (Model) getModelAndExpect("MODEL a", 1);
		assertEquals("a", model.getName());
	}
	
	@Test public void testSyntaxError_03() throws Exception {
		syntaxErrorProvider = new SyntaxErrorMessageProvider() {
			@Override
			public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
				SyntaxErrorMessage result = super.getSyntaxErrorMessage(context);
				assertEquals("mismatched input '<EOF>' expecting 'model'", result.getMessage());
				return result;
			}
		};
		getModelAndExpect("", 1);
	}
	
	@Test public void testCustomizedSyntaxError() throws Exception {
		expectedMessage = "expected message";
		Model model = (Model) getModelAndExpect("model a", 1);
		ICompositeNode node = NodeModelUtils.getNode(model);
		List<INode> syntaxErrors = Lists.newArrayList(Iterators.filter(node.getAsTreeIterable().iterator(), new Predicate<INode>() {
			@Override
			public boolean apply(INode input) {
				return input.getSyntaxErrorMessage() != null;
			}
		}));
		assertEquals(1, syntaxErrors.size());
		INode error = syntaxErrors.get(0);
		assertEquals(expectedMessage, error.getSyntaxErrorMessage().getMessage());
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
		for(String tokenName: context.getTokenNames()) {
			assertFalse(tokenName.startsWith("KEYWORD"));
		}
		if (expectedMessage != null)
			return new SyntaxErrorMessage(expectedMessage, null);
		return syntaxErrorProvider.getSyntaxErrorMessage(context);
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IValueConverterErrorContext context) {
		fail("Unexpected Invocation");
		return null;
	}

}
