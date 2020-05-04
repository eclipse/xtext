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

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.testlanguages.LookaheadTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.lookaheadLang.Entry;
import org.eclipse.xtext.testlanguages.lookaheadLang.FewerLookAheadStrings;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAheadPredicate;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAheadStrings;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookBeyond;
import org.junit.Test;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParsingPointerLookaheadTest extends AbstractPartialParsingPointerTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(LookaheadTestLanguageStandaloneSetup.class);
	}

	@Test
	public void testLookahead_0_2() throws Exception {
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 0; i < 3; ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			checkParseRegionPointers(parsingPointers, model, "ParserRule", "Entry");
		}
	}

	@Test
	public void testLookahead_3_4() throws Exception {
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 3; i < 5; ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			checkParseRegionPointers(parsingPointers, "bar a", "RuleCall", "LookAhead0");
		}
	}

	@Test
	public void testLookahead_6_8() throws Exception {
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 6; i < 9; ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			checkParseRegionPointers(parsingPointers, model, "ParserRule", "Entry");
		}
	}

	@Test
	public void testLookahead_9_14() throws Exception {
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 9; i < 15; ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			// actual expecation would lead to yet more complexity in partial
			// parser
//			checkParseRegionPointers(parsingPointers, " foo bar c b d", "RuleCall", "Alts");
			checkParseRegionPointers(parsingPointers, model, "ParserRule", "Entry");
		}
	}

	@Test
	public void testLookahead_15_18() throws Exception {
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 15; i < 19; ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			checkParseRegionPointers(parsingPointers, " foo bar c b d", "RuleCall", "LookAhead1");
		}
	}

	@Test
	public void testLookahead_19_22() throws Exception {
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 19; i < 22; ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			checkParseRegionPointers(parsingPointers, model, "ParserRule", "Entry");
		}
	}

	@Test
	public void testLookahead_23_28() throws Exception {
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 23; i < 29; ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			checkParseRegionPointers(parsingPointers, model, "ParserRule", "Entry");
		}
	}

	@Test
	public void testLookahead_29() throws Exception {
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 29; i < model.length(); ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			checkParseRegionPointers(parsingPointers, " c", "RuleCall", "LookAhead4");
		}
	}

	@Test
	public void testPredicatedLookahead_01() throws Exception {
		Entry e = (Entry) getModel("zonk a b d");
		LookAheadPredicate lap = (LookAheadPredicate) e.getContents().get(0);
		ICompositeNode node = NodeModelUtils.getNode(lap);
		assertEquals(3, node.getLookAhead());
	}

	@Test
	public void testPredicatedLookahead_02() throws Exception {
		Entry e = (Entry) getModel("zonk /* */ a /* */ b d");
		LookAheadPredicate lap = (LookAheadPredicate) e.getContents().get(0);
		ICompositeNode node = NodeModelUtils.getNode(lap);
		assertEquals(3, node.getLookAhead());
	}

	@Test
	public void testLookBeyond_01() throws Exception {
		Entry e = (Entry) getModel("'' '' ID");
		LookBeyond lb = (LookBeyond) e.getContents().get(0);
		ICompositeNode node = NodeModelUtils.getNode(lb);
		assertEquals(1, node.getLookAhead());
		assertNull(lb.getLeft());
		FewerLookAheadStrings flas = lb.getRight();
		node = NodeModelUtils.getNode(flas);
		assertEquals(3, node.getLookAhead());
	}

	@Test
	public void testLookBeyond_02() throws Exception {
		Entry e = (Entry) getModel("'a' 'b' 'c' ID");
		LookBeyond lb = (LookBeyond) e.getContents().get(0);
		ICompositeNode node = NodeModelUtils.getNode(lb);
		assertEquals(1, node.getLookAhead());
		assertNotNull(lb.getLeft());
		LookAheadStrings las = lb.getLeft();
		node = NodeModelUtils.getNode(las);
		assertEquals(3, node.getLookAhead());
		FewerLookAheadStrings flas = lb.getRight();
		node = NodeModelUtils.getNode(flas);
		assertEquals(3, node.getLookAhead());
	}

	@Test
	public void testLookBeyond_03() throws Exception {
		Entry e = (Entry) getModel("'1' '1' '1' '1' 'a' 'a' ID");
		LookBeyond lb = (LookBeyond) e.getContents().get(0);
		ICompositeNode node = NodeModelUtils.getNode(lb);
		assertEquals(1, node.getLookAhead());
		assertNotNull(lb.getLeft());
		LookAheadStrings las = lb.getLeft();
		node = NodeModelUtils.getNode(las);
		assertEquals(3, node.getLookAhead());
		FewerLookAheadStrings flas = lb.getRight();
		node = NodeModelUtils.getNode(flas);
		assertEquals(3, node.getLookAhead());
	}

	@Test
	public void testLookBeyond_04() throws Exception {
		String model = "'1' '1' '1' '2' '1' 'a' 'a' ID";
		PartialParsingPointers ppp = calculatePartialParsingPointers(model, model.indexOf("'2'"), 3);
		/*
		 * TODO this is an invalid expectation since changes to the number of
		 * strings would have an impact on the resulting model
		 */
		checkParseRegionPointers(ppp, "'1' '1' '1' '2' '1'", "RuleCall", "LookAheadStrings");
	}

}
