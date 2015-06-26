/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition;
import org.eclipse.xtext.ide.editor.syntaxcoloring.MergingHighlightedPositionAcceptor;
import org.eclipse.xtext.util.Strings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MergingHighlightedPositionAcceptorTest extends Assert {

	protected MergingHighlightedPositionAcceptor acceptor;

	@Before
	public void setUp() throws Exception {
		acceptor = createAcceptor();
	}
	
	public MergingHighlightedPositionAcceptor getAcceptor() {
		return acceptor;
	}

	protected MergingHighlightedPositionAcceptor createAcceptor() {
		return new MergingHighlightedPositionAcceptor(null);
	}
	
	@After
	public void tearDown() throws Exception {
		acceptor = null;
	}
	
	@Test public void testAddPosition_01() {
		acceptor.addPosition(0, 1, "1");
		List<? extends LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(0), -1, -1, -1, "1");
	}
	
	@Test public void testAddPosition_02() {
		acceptor.addPosition(2, 4, "1", "2");
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 2, 4, 0, "1", "2");
	}
	
	@Test public void testAddPosition_03() {
		acceptor.addPosition(2, 4, "1", "2");
		acceptor.addPosition(0, 1, "3", "4");
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(2, positions.size());
		checkPosition(positions.get(0), 2, 4, 0, "1", "2");
		checkPosition(positions.get(1), 0, 1, 1, "3", "4");
	}
	
	@Test public void testMergePositions_01() {
		acceptor.addPosition(0, 1, "1");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
	}
	
	@Test public void testMergePositions_02() {
		acceptor.addPosition(2, 4, "1", "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 2, 4, 0, "1", "2");
	}
	
	@Test public void testMergePositions_03() {
		acceptor.addPosition(2, 4, "1", "2");
		acceptor.addPosition(0, 1, "3", "4");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(2, positions.size());
		checkPosition(positions.get(0), 0, 1, 1, "3", "4");
		checkPosition(positions.get(1), 2, 4, 0, "1", "2");
	}
	
	@Test public void testMergePositions_04() {
		acceptor.addPosition(0, 1, "1");
		acceptor.addPosition(0, 1, "1");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 0, 1, 1, "1");
	}
	
	@Test public void testMergePositions_05() {
		acceptor.addPosition(0, 1, "1");
		acceptor.addPosition(0, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 0, 1, 1, "1", "2");
	}
	
	@Test public void testMergePositions_06() {
		acceptor.addPosition(0, 2, "1");
		acceptor.addPosition(0, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 2, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1", "2");
		checkPosition(positions.get(1), 1, 1, 0, "1");
	}
	
	@Test public void testMergePositions_07() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2");
		checkPosition(positions.get(2), 2, 1, 0, "1");
	}
	
	@Test public void testMergePositions_08() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 1, "2");
		acceptor.addPosition(1, 1, "3");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 2, "1", "2", "3");
		checkPosition(positions.get(2), 2, 1, 0, "1");
	}
	
	@Test public void testMergePositions_09() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 1, "2");
		acceptor.addPosition(1, 2, "3");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 2, "1", "2", "3");
		checkPosition(positions.get(2), 2, 1, 2, "1", "3");
	}
	
	@Test public void testMergePositions_10() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 2, "2");
		acceptor.addPosition(1, 1, "3");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2", "3");
		checkPosition(positions.get(2), 2, 1, 1, "1", "2");
	}
	
	@Test public void testMergePositions_11() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 2, "2");
		acceptor.addPosition(1, 2, "3");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 2, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 2, 2, "1", "2", "3");
	}
	
	@Test public void testMergePositions_12() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 3, "2");
		acceptor.addPosition(1, 1, "3");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 4, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2", "3");
		checkPosition(positions.get(2), 2, 1, 1, "1", "2");
		checkPosition(positions.get(3), 3, 1, 1, "2");
	}
	
	@Test public void testMergePositions_13() {
		acceptor.addPosition(0, 2, "1");
		acceptor.addPosition(1, 2, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2");
		checkPosition(positions.get(2), 2, 1, 1, "2");
	}
	
	@Test public void testMergePositions_14() {
		acceptor.addPosition(1, 2, "2");
		acceptor.addPosition(0, 2, "1");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 1, "1");
		checkPosition(positions.get(1), 1, 1, 0, "2", "1");
		checkPosition(positions.get(2), 2, 1, 0, "2");
	}
	
	@Test public void testMergePositions_15() {
		acceptor.addPosition(0, 1, "1");
		acceptor.addPosition(1, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 2, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "2");
	}
	
	@Test public void testMergePositions_16() {
		acceptor.addPosition(0, 1, "1");
		acceptor.addPosition(2, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 2, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 2, 1, 1, "2");
	}
	
	@Test public void testMergePositions_17() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 3, "2");
		acceptor.addPosition(2, 3, "3");
		acceptor.addPosition(3, 3, "4");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 6, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2");
		checkPosition(positions.get(2), 2, 1, 2, "1", "2", "3");
		checkPosition(positions.get(3), 3, 1, 3, "2", "3", "4");
		checkPosition(positions.get(4), 4, 1, 3, "3", "4");
		checkPosition(positions.get(5), 5, 1, 3, "4");
	}
	
	@Test public void testMergePositions_18() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 3, "2");
		acceptor.addPosition(2, 2, "3");
		acceptor.addPosition(3, 3, "4");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 5, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2");
		checkPosition(positions.get(2), 2, 1, 2, "1", "2", "3");
		checkPosition(positions.get(3), 3, 1, 3, "2", "3", "4");
		checkPosition(positions.get(4), 4, 2, 3, "4");
	}
	
	@Test public void testMergePositions_19() {
		acceptor.addPosition(0, 4, "1");
		acceptor.addPosition(1, 3, "2");
		acceptor.addPosition(2, 2, "3");
		acceptor.addPosition(3, 3, "4");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 5, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2");
		checkPosition(positions.get(2), 2, 1, 2, "1", "2", "3");
		checkPosition(positions.get(3), 3, 1, 3, "1", "2", "3", "4");
		checkPosition(positions.get(4), 4, 2, 3, "4");
	}
	
	@Test public void testMergePositions_20() {
		acceptor.addPosition(0, 5, "1");
		acceptor.addPosition(1, 3, "2");
		acceptor.addPosition(2, 2, "3");
		acceptor.addPosition(3, 3, "4");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 6, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2");
		checkPosition(positions.get(2), 2, 1, 2, "1", "2", "3");
		checkPosition(positions.get(3), 3, 1, 3, "1", "2", "3", "4");
		checkPosition(positions.get(4), 4, 1, 3, "1", "4");
		checkPosition(positions.get(5), 5, 1, 3, "4");
	}
	
	@Test public void testMergePositions_Bug318704() {
		acceptor.addPosition(5, 1, "1");
		acceptor.addPosition(25, 1, "1");
		acceptor.addPosition(14, 0, "2");
		acceptor.addPosition(36, 1, "1");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 5, 1, 0, "1");
		checkPosition(positions.get(1), 25, 1, 1, "1");
		checkPosition(positions.get(2), 36, 1, 3, "1");
	}
	
	@Test public void testMergePositions_Bug344616_01() {
		acceptor.addPosition(120, 4 , "1");
		acceptor.addPosition(127, 1 , "1");
		acceptor.addPosition(130, 12, "1");
		acceptor.addPosition(130, 12, "2");
		acceptor.addPosition(143, 1 , "1");
		acceptor.addPosition(146, 12, "1");
		acceptor.addPosition(146, 12, "2");
		acceptor.addPosition(159, 1 , "1");
		acceptor.addPosition(162, 4 , "1");
		acceptor.addPosition(162, 4 , "2");
		acceptor.addPosition(167, 1 , "1");
		acceptor.addPosition(120, 4 , "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 8, positions.size());
		checkPosition(positions.get(0), 120, 4, 11, "1", "2");
		checkPosition(positions.get(1), 127, 1, 1, "1");
		checkPosition(positions.get(2), 130, 12, 3, "1", "2");
		checkPosition(positions.get(3), 143, 1, 4, "1");
		checkPosition(positions.get(4), 146, 12, 6, "1", "2");
		checkPosition(positions.get(5), 159, 1, 7, "1");
		checkPosition(positions.get(6), 162, 4, 9, "1", "2");
		checkPosition(positions.get(7), 167, 1, 10, "1");
	}
	
	@Test public void testMergePositions_Bug344616_02() {
		acceptor.addPosition(120, 4 , "1");
		acceptor.addPosition(127, 1 , "1");
		acceptor.addPosition(130, 12, "1");
		acceptor.addPosition(130, 12, "2");
		acceptor.addPosition(143, 1 , "1");
		acceptor.addPosition(146, 12, "1");
		acceptor.addPosition(146, 12, "2");
		acceptor.addPosition(159, 1 , "1");
		acceptor.addPosition(162, 4 , "1");
		acceptor.addPosition(162, 4 , "2");
		acceptor.addPosition(167, 1 , "1");
		acceptor.addPosition(120, 4 , "2");
		acceptor.addPosition(127, 41, "3");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size: "+ positions, 14, positions.size());
		checkPosition(positions.get(0), 120, 4, 11, "1", "2");
		checkPosition(positions.get(1), 127, 1, 12, "1", "3");
		checkPosition(positions.get(2), 128, 2, 12, "3");
		checkPosition(positions.get(3), 130, 12, 3, "1", "2", "3");
		checkPosition(positions.get(4), 142, 1, 12, "3");
		checkPosition(positions.get(5), 143, 1, 4, "1", "3");
		checkPosition(positions.get(6), 144, 2, 12, "3");
		checkPosition(positions.get(7), 146, 12, 6, "1", "2", "3");
		checkPosition(positions.get(8), 158, 1, 12, "3");
		checkPosition(positions.get(9), 159, 1, 7, "1", "3");
		checkPosition(positions.get(10), 160, 2, 12, "3");
		checkPosition(positions.get(11), 162, 4, 9, "1", "2", "3");
		checkPosition(positions.get(12), 166, 1, 12, "3");
		checkPosition(positions.get(13), 167, 1, 10, "1", "3");
	}
	
	@Test public void testMergePositions_Bug344616_03() {
		acceptor.addPosition(22, 4 , "1");
		acceptor.addPosition(27, 1 , "2");
		acceptor.addPosition( 7, 21, "3");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size: "+ positions, 4, positions.size());
		checkPosition(positions.get(0), 7, 15, 2, "3");
		checkPosition(positions.get(1), 22, 4, 0, "1", "3");
		checkPosition(positions.get(2), 26, 1, 2, "3");
		checkPosition(positions.get(3), 27, 1, 1, "2", "3");
	}
	
	@Test public void testMergePositions_Bug375272_01() {
		acceptor.addPosition(0, 34, "1");
		acceptor.addPosition(34, 4, "1");
		acceptor.addPosition(6, 54, "1");
		acceptor.addPosition(22, 52, "1");

		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size: "+ positions, 6, positions.size());
		checkPosition(positions.get(0), 0, 6, 0, "1");
		checkPosition(positions.get(1), 6, 16, 2, "1");
		checkPosition(positions.get(2), 22, 12, 3, "1");
		checkPosition(positions.get(3), 34, 4, 3, "1");
		checkPosition(positions.get(4), 38, 22, 3, "1");
		checkPosition(positions.get(5), 60, 14, 3, "1");
	}
	
	@Test public void testMergePositions_Bug375272_02() {
		acceptor.addPosition(58, 51, "1");
		acceptor.addPosition(110, 6, "1");
		acceptor.addPosition(77, 52, "1");
		acceptor.addPosition(93, 48, "1");
		
		acceptor.addPosition(105, 11, "2");
		acceptor.addPosition(105, 11, "3");
		
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size: "+ positions, 8, positions.size());
		checkPosition(positions.get(0), 58, 19, 0, "1");
		checkPosition(positions.get(1), 77, 16, 2, "1");
		checkPosition(positions.get(2), 93, 12, 3, "1");
		checkPosition(positions.get(3), 105, 4, 5, "1", "2", "3");
		checkPosition(positions.get(4), 109, 1, 5, "1", "2", "3");
		checkPosition(positions.get(5), 110, 6, 1, "1", "2", "3");
		checkPosition(positions.get(6), 116, 13, 3, "1");
		checkPosition(positions.get(7), 129, 12, 3, "1");
	}
	
	protected void checkPosition(LightweightPosition position, int offset, int length, int timestamp, String... ids) {
		assertNotNull(position);
		if (timestamp >= 0)
			assertEquals("timestamp", timestamp, position.getTimestamp());
		if (offset >= 0)
			assertEquals("offset", offset, position.getOffset());
		if (length >= 0)
			assertEquals("length", length, position.getLength());
		checkIds(ids, position.getIds());
	}
	
	private void checkIds(String[] expected, String[] actual) {
		assertEquals(Strings.concat(", ", Arrays.asList(actual)) + " vs. " + Strings.concat(", ", Arrays.asList(expected)),
				actual.length, expected.length);
		for(int i = 0; i < actual.length; i++) {
			assertEquals("at index: " + i, expected[i], actual[i]);
		}
	}
}
