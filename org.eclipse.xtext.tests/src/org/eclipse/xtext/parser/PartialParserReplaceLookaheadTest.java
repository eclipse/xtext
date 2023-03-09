/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.testlanguages.LookaheadTestLanguageStandaloneSetup;
import org.junit.Test;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public abstract class PartialParserReplaceLookaheadTest extends AbstractPartialParserReplaceTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(LookaheadTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testLookahead_10_1() throws Exception {
		String model = "foo bar b c";
		replaceAndReparse(model, 10, 1, "d", " d");
	}
	
	@Test public void testLookahead_8_1() throws Exception {
		String model = "foo bar b c";
		replaceAndReparse(model, 8, 1, "b", "foo bar b c");
	}
	
	@Test public void testLookahead_0_length() throws Exception {
		String model = "foo bar b c";
		replaceAndReparse(model, 0, model.length(), "", "");		
	}

}
