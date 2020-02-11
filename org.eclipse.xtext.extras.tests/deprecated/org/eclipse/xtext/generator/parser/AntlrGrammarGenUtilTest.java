/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser;

import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Heiko Behrens - Initial contribution and API
 */
@Deprecated
public class AntlrGrammarGenUtilTest extends Assert {

	@Test public void testToAntlrString() throws Exception {
		assertEquals("a\\'b\\u00D6", AntlrGrammarGenUtil.toAntlrString("a'bÖ"));
	}

	@Test public void testToAntlrStringIgnoreCaseSimple() throws Exception {
		assertEquals("('A'|'a')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("a"));
		assertEquals("('A'|'a')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("A"));
		assertEquals("('A'|'a')('B'|'b')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("ab"));
		assertEquals("('A'|'a')('B'|'b')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("aB"));
		assertEquals("('A'|'a')('B'|'b')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("Ab"));
		assertEquals("('A'|'a')('B'|'b')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("AB"));
	}
	
	@Test public void testToAntlrStringIgnoreCaseUmlauts() throws Exception {
		assertEquals("\u00D6", "Ö");
		assertEquals("\u00F6", "ö");
		assertEquals("('\\u00D6'|'\\u00F6')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("ö"));
	}
	
	@Test public void testToAntlrStringIgnoreNoCases() throws Exception {
		assertEquals("\u00DF", "ß");
		//eszett will have a dedicated uppercase version in future. But for now...
		assertEquals(Character.toLowerCase('ß'), Character.toUpperCase('ß'));
		
		assertEquals("('A'|'a')'\\u00DF'('C'|'c')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("AßC"));
		assertEquals("('A'|'a')'\\u00DF''\\u00DF'('C'|'c')", AntlrGrammarGenUtil.toAntlrStringIgnoreCase("AßßC"));
	}
	
	
}
