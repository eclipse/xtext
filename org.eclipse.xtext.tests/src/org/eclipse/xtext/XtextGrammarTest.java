/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.xtextTest.Assignment;
import org.eclipse.xtext.xtextTest.Grammar;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class XtextGrammarTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextGrammarTestLanguageStandaloneSetup.class);
	}

	@Test public void testInstantiate() throws Exception {
		Grammar grammar = (Grammar) getModelAndExpect("grammar foo generate foo 'bar' Foo : name=ID;", 2);
		assertEquals("Foo", grammar.getRules().get(0).getName());
		assertEquals("name", ((Assignment) grammar.getRules().get(0).getAlternatives()).getFeature());
	}

}
