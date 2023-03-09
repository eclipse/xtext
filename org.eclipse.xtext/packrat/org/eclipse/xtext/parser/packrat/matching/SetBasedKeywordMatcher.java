/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.matching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SetBasedKeywordMatcher implements ISequenceMatcher {

	private final Set<String> keywords;
	
	public SetBasedKeywordMatcher(String... keywords) {
		this.keywords = new HashSet<String>(Arrays.asList(keywords));
	}
	
	@Override
	public boolean matches(CharSequence input, int offset, int length) {
		return keywords.contains(input.subSequence(offset, offset + length).toString());
	}
	
	@Override
	public String toString() {
		return "KeywordMatcher for: " + keywords;
	}

}
