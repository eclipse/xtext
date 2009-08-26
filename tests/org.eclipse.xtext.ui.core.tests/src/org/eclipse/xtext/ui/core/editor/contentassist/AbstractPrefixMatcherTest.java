/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.contentassist;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractPrefixMatcherTest<Matcher extends PrefixMatcher> extends TestCase {

	protected Matcher matcher;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		matcher = createMatcher();
	}

	protected abstract Matcher createMatcher();
	
	@Override
	protected void tearDown() throws Exception {
		matcher = null;
		super.tearDown();
	}
	
	public void testEmptyPrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("name", ""));
		assertTrue(matcher.isCandidateMatchingPrefix("", ""));
	}
	
	public void testExactMatch() {
		assertTrue(matcher.isCandidateMatchingPrefix("", ""));
		assertTrue(matcher.isCandidateMatchingPrefix("Exact", "Exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("exact", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXact", "eXact"));
	}
	
	public void testMisMatch() {
		assertFalse(matcher.isCandidateMatchingPrefix("Exact", "Mismatch"));
		assertFalse(matcher.isCandidateMatchingPrefix("Exact", "ExactMismatch"));
	}
	
	public void testExactPrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("Match", ""));
		assertTrue(matcher.isCandidateMatchingPrefix("ExactMatch", "Exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("exactMatch", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXactMatch", "eXact"));
	}
	
	public void testLowerCaseMatch() {
		assertTrue(matcher.isCandidateMatchingPrefix("Exact", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACT", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("exact", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXact", "exact"));
	}
	
	public void testLowerCasePrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("ExactMatch", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACTMatch", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("exactMatch", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXactMatch", "exact"));
	}
	
	public void testUpperCasePrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("ExactMatch", "EXACT"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACTMatch", "EXACT"));
		assertTrue(matcher.isCandidateMatchingPrefix("exactMatch", "EXACT"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXactMatch", "EXACT"));
	}
	
}
