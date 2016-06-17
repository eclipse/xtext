/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class PartialParserTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	@Test public void testEditGroupWithCardinality_01() throws Exception {
		performTest("'bar'");
	}
	
	@Test public void testEditGroupWithCardinality_02() throws Exception {
		performTest("{Test}");
	}
	
	@Test public void testEditGroupWithCardinality_03() throws Exception {
		performTest("'bar' ");
	}
	
	public void performTest(String toBeDeleted) throws Exception {
		String grammarAsText = 
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'myEcoreModel'\n" +
			"Root: value=Test;\n" +
			"Test: (" + toBeDeleted.trim() + " 'foo')*;";
		XtextResource resource = getResourceFromString(grammarAsText);
		Grammar g = (Grammar) resource.getContents().get(0);
		ParserRule rule = (ParserRule) g.getRules().get(1);
		assertEquals("*", rule.getAlternatives().getCardinality());
		resource.update(grammarAsText.indexOf(toBeDeleted), toBeDeleted.length(), "");
		// make sure we did a partial parse pass
		assertSame(rule, ((Grammar) resource.getContents().get(0)).getRules().get(1));
		assertEquals("*", rule.getAlternatives().getCardinality());
	}
	

}
