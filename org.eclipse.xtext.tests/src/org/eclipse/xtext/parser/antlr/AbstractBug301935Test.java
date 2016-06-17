/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.Map;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.ImmutableBiMap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractBug301935Test extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=346695
		return false;
	}

	@Test public void testParseValidInput() throws Exception {
		String input = "a b\nc ";
		assertNotNull(getModel(input));
	}
	
	@Test public void testGetTokenDefMap_01() {
		ITokenDefProvider tokenDefProvider = get(ITokenDefProvider.class);
		Map<Integer, String> map = tokenDefProvider.getTokenDefMap();
		assertNotNull(String.valueOf(map), map);
		assertEquals(String.valueOf(map), 5, map.size());
	}
	
	@Test public void testGetTokenDefMap_02() {
		ITokenDefProvider tokenDefProvider = get(ITokenDefProvider.class);
		ImmutableBiMap<Integer, String> tokens = ImmutableBiMap.copyOf(tokenDefProvider.getTokenDefMap());
		ImmutableBiMap<String,Integer> inverseTokens = tokens.inverse();
		assertTrue("'\n'", inverseTokens.containsKey("'\n'"));
		assertTrue("'\r'", inverseTokens.containsKey("'\r'"));
		assertTrue("RULE_ID", inverseTokens.containsKey("RULE_ID"));
		assertTrue("RULE_ANY_OTHER", inverseTokens.containsKey("RULE_ANY_OTHER"));
		assertTrue("RULE_WS", inverseTokens.containsKey("RULE_WS"));
	}
	
}
