/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.contentassist;

import org.eclipse.ui.dialogs.SearchPattern;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(PrefixMatcher.Simple.class)
public abstract class PrefixMatcher {

	public abstract boolean isCandidateMatchingPrefix(String name, String prefix);

	public static class Simple extends PrefixMatcher {
		@Override
		public boolean isCandidateMatchingPrefix(String name, String prefix) {
			return name.regionMatches(true, 0, prefix, 0, prefix.length());
		}
	}

	public static class CamelCase extends PrefixMatcher {
		@Override
		public boolean isCandidateMatchingPrefix(String name, String prefix) {
			SearchPattern pattern = new SearchPattern(
					SearchPattern.RULE_BLANK_MATCH | SearchPattern.RULE_CAMELCASE_MATCH | SearchPattern.RULE_PREFIX_MATCH);
			pattern.setPattern(prefix);
			boolean result = pattern.matches(name);
			return result;
		}
	}

}
