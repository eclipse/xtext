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

import junit.framework.TestCase;

import org.eclipse.xtext.ui.editor.syntaxcoloring.LightweightPosition;
import org.eclipse.xtext.ui.editor.syntaxcoloring.MergingHighlightedPositionAcceptor;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MergingHighlightedPositionAcceptorTest extends TestCase {

	private MergingHighlightedPositionAcceptor acceptor;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		acceptor = new MergingHighlightedPositionAcceptor(null);
	}
	
	@Override
	protected void tearDown() throws Exception {
		acceptor = null;
		super.tearDown();
	}
	
	public void testAddPosition_01() {
		acceptor.addPosition(0, 1, "1");
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(0), -1, -1, -1, "1");
	}
	
	public void testAddPosition_02() {
		acceptor.addPosition(2, 4, "1", "2");
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 2, 4, 0, "1", "2");
	}
	
	public void testAddPosition_03() {
		acceptor.addPosition(2, 4, "1", "2");
		acceptor.addPosition(0, 1, "3", "4");
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(2, positions.size());
		checkPosition(positions.get(0), 2, 4, 0, "1", "2");
		checkPosition(positions.get(1), 0, 1, 1, "3", "4");
	}
	
	public void testMergePositions_01() {
		acceptor.addPosition(0, 1, "1");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
	}
	
	public void testMergePositions_02() {
		acceptor.addPosition(2, 4, "1", "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 2, 4, 0, "1", "2");
	}
	
	public void testMergePositions_03() {
		acceptor.addPosition(2, 4, "1", "2");
		acceptor.addPosition(0, 1, "3", "4");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(2, positions.size());
		checkPosition(positions.get(0), 0, 1, 1, "3", "4");
		checkPosition(positions.get(1), 2, 4, 0, "1", "2");
	}
	
	public void testMergePositions_04() {
		acceptor.addPosition(0, 1, "1");
		acceptor.addPosition(0, 1, "1");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 0, 1, 1, "1");
	}
	
	public void testMergePositions_05() {
		acceptor.addPosition(0, 1, "1");
		acceptor.addPosition(0, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 0, 1, 1, "1", "2");
	}
	
	public void testMergePositions_06() {
		acceptor.addPosition(0, 2, "1");
		acceptor.addPosition(0, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 2, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1", "2");
		checkPosition(positions.get(1), 1, 1, 0, "1");
	}
	
	public void testMergePositions_07() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2");
		checkPosition(positions.get(2), 2, 1, 0, "1");
	}
	
	public void testMergePositions_08() {
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
	
	public void testMergePositions_09() {
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
	
	public void testMergePositions_10() {
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
	
	public void testMergePositions_11() {
		acceptor.addPosition(0, 3, "1");
		acceptor.addPosition(1, 2, "2");
		acceptor.addPosition(1, 2, "3");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 2, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 2, 2, "1", "2", "3");
	}
	
	public void testMergePositions_12() {
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
	
	public void testMergePositions_13() {
		acceptor.addPosition(0, 2, "1");
		acceptor.addPosition(1, 2, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "1", "2");
		checkPosition(positions.get(2), 2, 1, 1, "2");
	}
	
	public void testMergePositions_14() {
		acceptor.addPosition(1, 2, "2");
		acceptor.addPosition(0, 2, "1");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 3, positions.size());
		checkPosition(positions.get(0), 0, 1, 1, "1");
		checkPosition(positions.get(1), 1, 1, 0, "2", "1");
		checkPosition(positions.get(2), 2, 1, 0, "2");
	}
	
	public void testMergePositions_15() {
		acceptor.addPosition(0, 1, "1");
		acceptor.addPosition(1, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 2, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 1, 1, 1, "2");
	}
	
	public void testMergePositions_16() {
		acceptor.addPosition(0, 1, "1");
		acceptor.addPosition(2, 1, "2");
		acceptor.mergePositions();
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals("positions.size", 2, positions.size());
		checkPosition(positions.get(0), 0, 1, 0, "1");
		checkPosition(positions.get(1), 2, 1, 1, "2");
	}
	
	public void testMergePositions_17() {
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
	
	public void testMergePositions_18() {
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
	
	public void testMergePositions_19() {
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
	
	public void testMergePositions_20() {
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
	
	public void testMergePositions_Bug318704() {
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
	
	private void checkPosition(LightweightPosition position, int offset, int length, int timestamp, String... ids) {
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
