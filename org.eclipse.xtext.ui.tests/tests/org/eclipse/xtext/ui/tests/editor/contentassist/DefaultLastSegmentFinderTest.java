/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.DefaultLastSegmentFinder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultLastSegmentFinderTest extends Assert {

	private DefaultLastSegmentFinder finder;

	@Before
	public void setUp() throws Exception {
		finder = new FQNPrefixMatcher.DefaultLastSegmentFinder();
	}
	
	@Test public void testGetLastSegment_01() {
		assertEquals(null, finder.getLastSegment(null, '.'));
		assertEquals(null, finder.getLastSegment("", '.'));
	}
	
	@Test public void testGetLastSegment_02() {
		assertEquals(null, finder.getLastSegment("a", '.'));
		assertEquals("A", finder.getLastSegment("A", '.'));
	}
	
	@Test public void testGetLastSegment_03() {
		assertEquals(null, finder.getLastSegment("aA", '.'));
		assertEquals("AA", finder.getLastSegment("AA", '.'));
		assertEquals("Aa", finder.getLastSegment("Aa", '.'));
	}
	
	@Test public void testGetLastSegment_04() {
		assertEquals("aA", finder.getLastSegment("prefix.aA", '.'));
		assertEquals("aa", finder.getLastSegment("prefix.aA.aa", '.'));
		assertEquals("A", finder.getLastSegment("preFix.A", '.'));
		assertEquals("AA", finder.getLastSegment("prefix.AA", '.'));
		assertEquals("Aa", finder.getLastSegment("prefix.Aa", '.'));
	}
	
	@Test public void testGetLastSegment_05() {
		assertEquals("A.a", finder.getLastSegment("prefix.A.a", '.'));
		assertEquals("A.A", finder.getLastSegment("preFix.A.A", '.'));
		assertEquals("AA.A", finder.getLastSegment("prefix.AA.A", '.'));
		assertEquals("Aa.A", finder.getLastSegment("prefix.Aa.A", '.'));
	}
}
