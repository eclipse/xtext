/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.dummy.DummyTestLanguageStandaloneSetup;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

public class HiddenTokensTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(DummyTestLanguageStandaloneSetup.class);
	}

	@Test public void testWhitespaceIsIncluded() throws Exception {
		String model = "element foo;\nelement bar;";
		INode node = getRootNode(model);
		assertEquals(model,node.getText());
	}
	
	@Test public void testWhitespaceIsIncluded2() throws Exception {
		String model = "element foo;\nelement bar;/* foo bar */ element foo;\nelement bar;";
		INode node = getRootNode(model);
		assertEquals(node.getText(), model);
	}
	
	@Test public void testTrailingWhitespaceIsIncluded() throws Exception {
		String model = "element foo;\nelement bar;  /* holla */ \n// stuff\n";
		INode node = getRootNode(model);
		assertEquals(model, node.getText());
	}
	
	@Test public void testPrecedingWhitespaceIsIncluded() throws Exception {
		String model = "//honolulu\n\t element foo;\nelement bar;";
		INode node = getRootNode(model);
		assertEquals(model, node.getText());
	}
	
}
