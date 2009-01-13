/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.matching;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SetBasedKeywordMatcher implements ISequenceMatcher {

	private final Set<String> keywords;
	
	public SetBasedKeywordMatcher(Grammar grammar) {
		keywords = GrammarUtil.getAllKeywords(grammar);
	}
	
	public boolean matches(CharSequence input, int offset, int length) {
		return keywords.contains(input.subSequence(offset, offset + length).toString());
	}

}
