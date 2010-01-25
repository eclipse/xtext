/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.bracketmatching;

import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.ui.core.editor.bracketmatching.DefaultBracketMatcher;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextGrammarBracketMatcher extends DefaultBracketMatcher {

	@Inject
	private XtextGrammarAccess grammarAccess;
	
	@Override
	public void configure(IBracketPairAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(grammarAccess.getParserRuleAccess().getColonKeyword_3(), grammarAccess.getParserRuleAccess().getSemicolonKeyword_5());
		acceptor.accept(grammarAccess.getTerminalRuleAccess().getColonKeyword_3(), grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5());
		acceptor.accept(grammarAccess.getEnumRuleAccess().getColonKeyword_3(), grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5());
	}

}
