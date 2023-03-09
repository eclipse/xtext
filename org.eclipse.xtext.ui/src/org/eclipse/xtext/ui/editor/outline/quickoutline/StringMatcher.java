/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Matches a given {@link String} against a prefix pattern. The matching algorithm
 * will return <code>true</code> if the tested string starts with the given pattern.
 * The pattern supports wildcards such as <code>*</code> and <code>?</code>.
 * @author Peter Friese - Initial contribution and API
 * @author Sebastian Zarnekow - Javadoc, minor fixes to the matching algorithm
 */
public class StringMatcher {
	
	private final String expression;
	private final boolean ignoreCase;
	private Pattern pattern;

	public StringMatcher(String pattern, boolean ignoreCase) {
		this.expression = translatePattern(pattern);
		this.ignoreCase = ignoreCase;
	}
	
	/**
	 * @since 2.1
	 */
	protected String translatePattern(String pattern) {
		String expression = pattern.replaceAll("\\(", "\\\\(");
		expression = expression.replaceAll("\\)", "\\\\)");
		expression = expression.replaceAll("\\[", "\\\\[");
		expression = expression.replaceAll("\\]", "\\\\]");
		expression = expression.replaceAll("\\{", "\\\\{");
		expression = expression.replaceAll("\\}", "\\\\}");
		expression = expression.replaceAll("\\*", ".*");
		expression = expression.replaceAll("\\?", ".");
		if (!expression.startsWith("^"))
			expression = "^" + expression;
		return expression;
	}
	
	/**
	 * @since 2.1 protected
	 */
	protected Pattern getPattern() {
		if (pattern == null) {
			if (ignoreCase) {
				pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			}
			else {
				pattern = Pattern.compile(expression);
			}
		}
		return pattern;
	}
	
	public boolean match(String text) {
		try {
			return getPattern().matcher(text).find();
		} catch (PatternSyntaxException e) {
			return false;
		}
	}

}
