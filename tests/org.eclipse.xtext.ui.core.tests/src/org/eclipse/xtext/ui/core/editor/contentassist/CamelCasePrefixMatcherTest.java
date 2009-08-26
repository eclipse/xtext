/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.contentassist;

import org.eclipse.xtext.ui.core.editor.contentassist.PrefixMatcher.CamelCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CamelCasePrefixMatcherTest extends AbstractPrefixMatcherTest<PrefixMatcher.CamelCase>{

	@Override
	protected CamelCase createMatcher() {
		return new PrefixMatcher.CamelCase();
	}

	public void testCamelCasePrefix() {
		assertTrue(matcher.isCandidateMatchingPrefix("ExactMatch", "ExMa"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXACTMatch", "EXACT"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXactMatch", "EXM"));
	}
	
	public void testCamelCaseMisMatch() {
		assertFalse(matcher.isCandidateMatchingPrefix("ExactMatch", "EXMa"));
	}
	
	// Fix the implementation to assert the following test cases when inverted
	public void testFixMe() {
		assertTrue(matcher.isCandidateMatchingPrefix("EXACTMatch", "EXaCT"));
		assertFalse(matcher.isCandidateMatchingPrefix("exactMatch", "exM"));
		assertTrue(matcher.isCandidateMatchingPrefix("EXactMatch", "EXACTm"));
	}
}
