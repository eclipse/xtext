/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.Map;

import org.eclipse.xtext.junit.AbstractXtextTests;

import com.google.common.collect.ImmutableBiMap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractBug301935Test extends AbstractXtextTests {

	public void testParseValidInput() throws Exception {
		String input = "a b\nc ";
		assertNotNull(getModel(input));
	}
	
	public void testGetTokenDefMap_01() {
		ITokenDefProvider tokenDefProvider = get(ITokenDefProvider.class);
		Map<Integer, String> map = tokenDefProvider.getTokenDefMap();
		assertNotNull(map);
		assertEquals(5, map.size());
	}
	
	public void testGetTokenDefMap_02() {
		ITokenDefProvider tokenDefProvider = get(ITokenDefProvider.class);
		ImmutableBiMap<Integer, String> tokens = ImmutableBiMap.copyOf(tokenDefProvider.getTokenDefMap());
		ImmutableBiMap<String,Integer> inverseTokens = tokens.inverse();
		assertTrue(inverseTokens.containsKey("'\n'"));
		assertTrue(inverseTokens.containsKey("'\r'"));
		assertTrue(inverseTokens.containsKey("RULE_ID"));
		assertTrue(inverseTokens.containsKey("RULE_ANY_OTHER"));
		assertTrue(inverseTokens.containsKey("RULE_WS"));
	}
	
}
