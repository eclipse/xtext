/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.List;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.antlr.bug299237Test.Model;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.SyntaxError;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug299237Test extends AbstractXtextTests implements ISyntaxErrorMessageProvider {
	
	private SyntaxErrorMessageProvider syntaxErrorProvider;

	private String expectedMessage;
	
	@Override
	protected void setUp() throws Exception {
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
	
	public void testValidModel_01() throws Exception {
		Model model = (Model) getModel("model a;");
		assertEquals("a", model.getName());
	}
	
	public void testValidModel_02() throws Exception {
		Model model = (Model) getModel("MODEL a;");
		assertEquals("a", model.getName());
	}
	
	public void testSyntaxError_01() throws Exception {
		Model model = (Model) getModelAndExpect("model a", 1);
		assertEquals("a", model.getName());
	}
	
	public void testSyntaxError_02() throws Exception {
		Model model = (Model) getModelAndExpect("MODEL a", 1);
		assertEquals("a", model.getName());
	}
	
	public void testSyntaxError_03() throws Exception {
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
	
	public void testCustomizedSyntaxError() throws Exception {
		expectedMessage = "expected message";
		Model model = (Model) getModelAndExpect("model a", 1);
		CompositeNode node = NodeUtil.getNodeAdapter(model).getParserNode();
		List<SyntaxError> syntaxErrors = node.allSyntaxErrors();
		assertEquals(1, syntaxErrors.size());
		SyntaxError error = syntaxErrors.get(0);
		assertEquals(expectedMessage, error.getMessage());
	}

	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
		for(String tokenName: context.getTokenNames()) {
			assertFalse(tokenName.startsWith("KEYWORD"));
		}
		if (expectedMessage != null)
			return new SyntaxErrorMessage(expectedMessage, null);
		return syntaxErrorProvider.getSyntaxErrorMessage(context);
	}

	public SyntaxErrorMessage getSyntaxErrorMessage(IValueConverterErrorContext context) {
		fail("Unexpected Invocation");
		return null;
	}

}
