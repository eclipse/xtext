/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class InheritanceGrammarAccessTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new ConcreteTestLanguageStandaloneSetup());
	}

	@Test public void testSuperGrammarAccessUsesItsOwnGrammar() throws Exception {
		AbstractTestLanguageGrammarAccess access = get(AbstractTestLanguageGrammarAccess.class);
		assertNotNull(access.getExtendableParserRuleAccess().getElementKeyword_0());
	}
}
