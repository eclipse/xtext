/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleUnorderedGroupsTestLanguageGrammarAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ErrorMessagesTest extends AbstractXtextTests implements ISyntaxErrorMessageProvider {

	private ISyntaxErrorMessageProvider delegate;
	
	private SimpleUnorderedGroupsTestLanguageGrammarAccess grammarAccess;
	
	private List<AbstractElement> expectation;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new SimpleUnorderedGroupsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new SimpleUnorderedGroupsTestLanguageRuntimeModule() {
					@SuppressWarnings("unused")
					public ISyntaxErrorMessageProvider bindSyntaxErrorMessageProvider() {
						return ErrorMessagesTest.this;
					}
				});
			}
		});
		delegate = get(SyntaxErrorMessageProvider.class);
		grammarAccess = get(SimpleUnorderedGroupsTestLanguageGrammarAccess.class);
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
		if (expectation != null) {
			assertTrue(context instanceof IUnorderedGroupErrorContext);
			IUnorderedGroupErrorContext casted = (IUnorderedGroupErrorContext) context;
			List<AbstractElement> mandatoryElements = casted.getMissingMandatoryElements();
			assertEquals(expectation, mandatoryElements);
		}
		return delegate.getSyntaxErrorMessage(context);
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IValueConverterErrorContext context) {
		return delegate.getSyntaxErrorMessage(context);
	}
	
	@Test public void testParse_1_A() throws Exception {
		expectation = Collections.<AbstractElement>singletonList(grammarAccess.getModelAccess().getSecondAssignment_1_0_1_1());
		getModelAndExpect("1 a", 1);
	}
	
	@Test public void testParse_1_B() throws Exception {
		expectation = Collections.<AbstractElement>singletonList(grammarAccess.getModelAccess().getFirstAssignment_1_0_1_0());
		getModelAndExpect("1 b", 1);
	}
	
}
