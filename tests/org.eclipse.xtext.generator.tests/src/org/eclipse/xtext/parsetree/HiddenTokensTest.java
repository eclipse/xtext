/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.dummy.DummyLanguageLanguageFacade;
import org.eclipse.xtext.dummy.DummyLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class HiddenTokensTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		DummyLanguageStandaloneSetup.doSetup();
		with(DummyLanguageLanguageFacade.LANGUAGE_ID);
	}

	public void testWhitespaceIsIncluded() throws Exception {
		String model = "element foo;\nelement bar;";
		AbstractNode node = getRootNode(model);
		assertEquals(node.serialize(),model);
	}

	
	public void testWhitespaceIsIncluded2() throws Exception {
		String model = "element foo;\nelement bar;/* foo bar */ element foo;\nelement bar;";
		AbstractNode node = getRootNode(model);
		assertEquals(node.serialize(),model);
	}
	
	public void testTrailingWhitespaceIsIncluded() throws Exception {
		String model = "element foo;\nelement bar;  /* holla */ \n// stuff\n";
		AbstractNode node = getRootNode(model);
		assertEquals(node.serialize(),model);
	}
	
	public void testPrecedingWhitespaceIsIncluded() throws Exception {
		String model = "//honolulu\n\t element foo;\nelement bar;";
		AbstractNode node = getRootNode(model);
		assertEquals(node.serialize(),model);
	}
	
}
