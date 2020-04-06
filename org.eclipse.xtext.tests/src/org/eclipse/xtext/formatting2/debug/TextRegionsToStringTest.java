/*******************************************************************************
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Florian Stolte - Initial contribution and API
 */
public class TextRegionsToStringTest {
	TextRegionsToString textRegionsToString;
	
	@Before
	public void init() {
		textRegionsToString = new TextRegionsToString();
		textRegionsToString.setIgnoreCarriageReturnInQuotes(true);
	}
	
	@Test
	public void testQuote() {

		// insert quotes
		assertEquals("\"import some.thing\"", textRegionsToString.quote("import some.thing", 30));
		assertEquals("\"import some.thing\"", textRegionsToString.quote("import some.thing", 17));
		
		// shorten result
		assertEquals("\"import ...\"", textRegionsToString.quote("import some.thing", 10));
		assertEquals("\"import some.t...\"", textRegionsToString.quote("import some.thing", 16));
		
		// remove windows line endings
		assertEquals("\"\\nimport some.thing\\n\"", textRegionsToString.quote("\r\nimport some.thing\r\n", 30));
		assertEquals("\"\\nimport some.thing\\n\"", textRegionsToString.quote("\r\nimport some.thing\r\n", 19));
		
		// remove windows line endings and shorten
		assertEquals("\"\\nimport...\"", textRegionsToString.quote("\r\nimport some.thing\r\n", 10));
		assertEquals("\"\\nimport some.th...\"", textRegionsToString.quote("\r\nimport some.thing\r\n", 18));
		
		// keep windows line endings
		textRegionsToString.setIgnoreCarriageReturnInQuotes(false);
		assertEquals("\"\\r\\nimport some.thing\\r\\n\"", textRegionsToString.quote("\r\nimport some.thing\r\n", 30));
	}
}
