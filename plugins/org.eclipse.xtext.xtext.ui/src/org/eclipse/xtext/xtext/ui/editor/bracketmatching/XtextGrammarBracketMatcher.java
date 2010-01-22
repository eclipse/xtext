/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.bracketmatching;

import java.util.List;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.ui.core.editor.bracketmatching.AbstractBracketMatcher;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextGrammarBracketMatcher extends AbstractBracketMatcher {

	@Inject
	private XtextGrammarAccess grammarAccess;
	
	@Override
	public void configure(IBracketPairAcceptor acceptor) {
		List<Pair<Keyword,Keyword>> pairs2 = grammarAccess.findKeywordPairs("(", ")");
		for (Pair<Keyword, Keyword> pair : pairs2) {
			acceptor.accept(pair.getFirst(), pair.getSecond());
		}
		acceptor.accept(grammarAccess.getParserRuleAccess().getColonKeyword_3(), grammarAccess.getParserRuleAccess().getSemicolonKeyword_5());
	}

}
