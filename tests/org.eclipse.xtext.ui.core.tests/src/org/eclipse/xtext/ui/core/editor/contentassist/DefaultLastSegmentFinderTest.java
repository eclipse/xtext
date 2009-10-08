/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.contentassist;

import org.eclipse.xtext.ui.core.editor.contentassist.FQNPrefixMatcher.DefaultLastSegmentFinder;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultLastSegmentFinderTest extends TestCase {

	private DefaultLastSegmentFinder finder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		finder = new FQNPrefixMatcher.DefaultLastSegmentFinder();
	}
	
	public void testGetLastSegment_01() {
		assertEquals(null, finder.getLastSegment(null, '.'));
		assertEquals(null, finder.getLastSegment("", '.'));
	}
	
	public void testGetLastSegment_02() {
		assertEquals(null, finder.getLastSegment("a", '.'));
		assertEquals("A", finder.getLastSegment("A", '.'));
	}
	
	public void testGetLastSegment_03() {
		assertEquals(null, finder.getLastSegment("aA", '.'));
		assertEquals("AA", finder.getLastSegment("AA", '.'));
		assertEquals("Aa", finder.getLastSegment("Aa", '.'));
	}
	
	public void testGetLastSegment_04() {
		assertEquals(null, finder.getLastSegment("prefix.aA", '.'));
		assertEquals("A", finder.getLastSegment("preFix.A", '.'));
		assertEquals("AA", finder.getLastSegment("prefix.AA", '.'));
		assertEquals("Aa", finder.getLastSegment("prefix.Aa", '.'));
	}
	
	public void testGetLastSegment_05() {
		assertEquals("A.a", finder.getLastSegment("prefix.A.a", '.'));
		assertEquals("A.A", finder.getLastSegment("preFix.A.A", '.'));
		assertEquals("AA.A", finder.getLastSegment("prefix.AA.A", '.'));
		assertEquals("Aa.A", finder.getLastSegment("prefix.Aa.A", '.'));
	}
}
