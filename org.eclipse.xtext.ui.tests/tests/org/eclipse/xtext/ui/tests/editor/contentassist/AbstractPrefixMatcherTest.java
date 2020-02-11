/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractPrefixMatcherTest<Matcher extends PrefixMatcher> extends Assert {

	protected Matcher matcher;

	@Before
	public void setUp() throws Exception {
		matcher = createMatcher();
	}

	protected abstract Matcher createMatcher();
	
	@After
	public void tearDown() throws Exception {
		matcher = null;
	}
	
	@Test public void testEmptyPrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("name", ""));
		assertTrue(matcher.isCandidateMatchingPrefix("", ""));
	}
	
	@Test public void testExactMatch() {
		assertTrue(matcher.isCandidateMatchingPrefix("", ""));
		assertTrue(matcher.isCandidateMatchingPrefix("Exact", "Exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("exact", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXact", "eXact"));
	}
	
	@Test public void testMisMatch() {
		assertFalse(matcher.isCandidateMatchingPrefix("Exact", "Mismatch"));
		assertFalse(matcher.isCandidateMatchingPrefix("Exact", "ExactMismatch"));
	}
	
	@Test public void testExactPrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("Match", ""));
		assertTrue(matcher.isCandidateMatchingPrefix("ExactMatch", "Exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("exactMatch", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXactMatch", "eXact"));
	}
	
	@Test public void testLowerCaseMatch() {
		assertTrue(matcher.isCandidateMatchingPrefix("Exact", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACT", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("exact", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXact", "exact"));
	}
	
	@Test public void testLowerCasePrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("ExactMatch", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACTMatch", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("exactMatch", "exact"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXactMatch", "exact"));
	}
	
	@Test public void testUpperCasePrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("ExactMatch", "EXACT"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACTMatch", "EXACT"));
		assertTrue(matcher.isCandidateMatchingPrefix("exactMatch", "EXACT"));
		assertTrue(matcher.isCandidateMatchingPrefix("eXactMatch", "EXACT"));
	}
	
}
