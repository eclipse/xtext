/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.contentassist;

import org.eclipse.xtext.ui.core.editor.contentassist.PrefixMatcher.IgnoreCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCasePrefixMatcherTest extends AbstractPrefixMatcherTest<PrefixMatcher.IgnoreCase> {

	@Override
	protected IgnoreCase createMatcher() {
		return new PrefixMatcher.IgnoreCase();
	}
	
	public void testCamelCaseMismatch() {
		assertFalse(matcher.isCandidateMatchingPrefix("ExactMatch", "ExMa"));
		assertFalse(matcher.isCandidateMatchingPrefix("exactMatch", "exM"));
		assertFalse(matcher.isCandidateMatchingPrefix("eXactMatch", "eXM"));
	}
}
