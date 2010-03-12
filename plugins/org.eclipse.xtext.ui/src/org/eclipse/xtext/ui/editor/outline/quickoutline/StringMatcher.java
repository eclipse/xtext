/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import java.util.regex.Pattern;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class StringMatcher {
	
	private final String expression;
	private final boolean ignoreCase;
	private Pattern pattern;

	public StringMatcher(String pattern, boolean ignoreCase) {
		this.expression = translatePattern(pattern);
		this.ignoreCase = ignoreCase;
	}
	
	private String translatePattern(String pattern) {
		String expression = pattern.replaceAll("\\*", ".*");
		expression = expression.replaceAll("\\?", ".");
		return expression;
	}
	
	private Pattern getPattern() {
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
		return getPattern().matcher(text).matches();
	}

}
