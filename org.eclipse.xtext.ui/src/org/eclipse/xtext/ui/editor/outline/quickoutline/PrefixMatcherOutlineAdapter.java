/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import java.util.List;

import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.1
 */
public class PrefixMatcherOutlineAdapter extends StringMatcher {

	private final PrefixMatcher strategy;
	private final List<String> prefixParts;
	private final List<StringMatcher> stringMatchers;
	private final String prefix;
	private final StringMatcher prefixStringMatcher;

	public PrefixMatcherOutlineAdapter(String prefix, PrefixMatcher strategy) {
		super("", true);
		this.prefix = prefix;
		this.prefixParts = splitIntoParts(prefix);
		this.strategy = strategy;
		this.prefixStringMatcher = new StringMatcher(prefix, true);
		stringMatchers = Lists.newArrayList();
		for(String part: prefixParts) {
			stringMatchers.add(new StringMatcher(part, true));
		}
	}

	protected List<String> splitIntoParts(String prefix) {
		List<String> result = Lists.newArrayList();
		int nextStart = 0;
		for(int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (isStructuralDelimiter(c) || c == '.' || c == ' ' || c == '\t') {
				if (nextStart != i)
					result.add(prefix.substring(nextStart, i).trim());
				if (c != ' ' && c != '\t')
					result.add(Character.toString(c));
				nextStart = i + 1;
			}
		}
		if (nextStart != prefix.length()) {
			result.add(prefix.substring(nextStart).trim());
		}
		return result;
	}

	protected boolean isStructuralDelimiter(char c) {
		return c == '(' || c == ')' ||
							c == '{' || c == '}' ||
							c == '[' || c == ']' ||
							c == ':' || c == ',';
	}
	
	@Override
	protected String translatePattern(String pattern) {
		return pattern;
	}
	
	@Override
	public boolean match(String label) {
		if (prefixParts.isEmpty())
			return true;
		if (strategy.isCandidateMatchingPrefix(label, prefix)) {
			return true;
		}
		if (prefixStringMatcher.match(label)) {
			return true;
		}
		List<String> labelParts = splitIntoParts(label);
		if (labelParts.size() < prefixParts.size()) {
			return false;
		}
		if (prefixParts.size() == 1 && labelParts.size() == 1)
			return false;
		int labelIdx = 0;
		int prefixIdx = 0;
		boolean ignoreStructuralDelimiterGuard = false;
		while(prefixIdx < prefixParts.size()) {
			String prefixPart = prefixParts.get(prefixIdx);
			StringMatcher partMatcher = stringMatchers.get(prefixIdx);
			boolean didMatch = false;
			while(labelIdx < labelParts.size()) {
				String labelPart = labelParts.get(labelIdx).trim();
				labelIdx++;
				if (strategy.isCandidateMatchingPrefix(labelPart, prefixPart)) {
					didMatch = true;
					ignoreStructuralDelimiterGuard = prefixPart.endsWith("*");
					break;
				}
				if (partMatcher.match(labelPart)) {
					ignoreStructuralDelimiterGuard = prefixPart.endsWith("*");
					didMatch = true;
					break;
				}
				if (!ignoreStructuralDelimiterGuard && labelPart.length() == 1 && isStructuralDelimiter(labelPart.charAt(0))) {
					return false;
				}
			}
			if (!didMatch)
				return false;
			prefixIdx++;
			if (prefixIdx >= prefixParts.size())
				return true;
		}
		return false;
	}
	
}
