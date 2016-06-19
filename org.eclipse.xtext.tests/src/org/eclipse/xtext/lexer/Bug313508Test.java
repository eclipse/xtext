/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.lexer;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug313508Test extends AbstractXtextTests {

	private Map<Integer, String> map;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(BacktrackingLexerTestLanguageStandaloneSetup.class);
		ITokenDefProvider tokenDefProvider = get(ITokenDefProvider.class);
		map = tokenDefProvider.getTokenDefMap();
	}
	
	@Override
	public void tearDown() throws Exception {
		map = null;
		super.tearDown();
	}
	
	@Test public void testSize() {
		assertEquals(8 /* terminal rules */ + 2 /* keywords */, map.size());
	}
	
	@Test public void testKeys() {
		Set<Integer> expected = Sets.newHashSet(
				Token.MIN_TOKEN_TYPE + 0,
				Token.MIN_TOKEN_TYPE + 1,
				Token.MIN_TOKEN_TYPE + 2,
				Token.MIN_TOKEN_TYPE + 3,
				Token.MIN_TOKEN_TYPE + 4,
				Token.MIN_TOKEN_TYPE + 5,
				Token.MIN_TOKEN_TYPE + 6,
				Token.MIN_TOKEN_TYPE + 7,
				Token.MIN_TOKEN_TYPE + 8,
				Token.MIN_TOKEN_TYPE + 9
		);
		assertEquals(expected, map.keySet());
	}
	
	@Test public void testValues() {
		Collection<String> tokens = map.values();
		assertTrue(tokens.contains("'Abc'"));
		assertTrue(tokens.contains("'Efg'"));
		assertTrue(tokens.contains("RULE_CHARA"));
		assertTrue(tokens.contains("RULE_CHARB"));
		assertTrue(tokens.contains("RULE_CHARX"));
		assertTrue(tokens.contains("RULE_CHARY"));
		assertTrue(tokens.contains("RULE_CHARC"));
		assertTrue(tokens.contains("RULE_YC"));
		assertTrue(tokens.contains("RULE_WS"));
		assertTrue(tokens.contains("RULE_SL_COMMENT"));
	}
	
}
