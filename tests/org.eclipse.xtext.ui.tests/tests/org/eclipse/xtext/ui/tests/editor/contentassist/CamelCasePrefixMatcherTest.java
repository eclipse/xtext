/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher.CamelCase;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CamelCasePrefixMatcherTest extends AbstractPrefixMatcherTest<PrefixMatcher.CamelCase>{

	@Override
	protected CamelCase createMatcher() {
		return new PrefixMatcher.CamelCase();
	}

	@Test public void testCamelCasePrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("ExactMatch", "ExMa"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACTMatch", "EXACT"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXactMatch", "EXM"));
		assertTrue(matcher.isCandidateMatchingPrefix("exactMatch", "exM"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXactMatch", "EXACTm"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACTMatch", "EXaCT"));
		assertTrue(matcher.isCandidateMatchingPrefix("exactMatch", "exMa"));
	}
	
	@Test public void testCamelCaseMisMatch() {
		assertFalse(matcher.isCandidateMatchingPrefix("ExactMatch", "EXMa"));
	}
	
}
