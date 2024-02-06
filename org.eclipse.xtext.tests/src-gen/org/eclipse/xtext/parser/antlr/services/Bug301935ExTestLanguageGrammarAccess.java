/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class Bug301935ExTestLanguageGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class DelegateModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.parser.antlr.Bug301935ExTestLanguage.DelegateModel");
		private final RuleCall cModelParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//DelegateModel returns Model:
		//    Model
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Model
		public RuleCall getModelParserRuleCall() { return cModelParserRuleCall; }
	}
	
	
	private final DelegateModelElements pDelegateModel;
	
	private final Grammar grammar;
	
	private final Bug301935TestLanguageGrammarAccess gaBug301935TestLanguage;

	@Inject
	public Bug301935ExTestLanguageGrammarAccess(GrammarProvider grammarProvider,
			Bug301935TestLanguageGrammarAccess gaBug301935TestLanguage) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaBug301935TestLanguage = gaBug301935TestLanguage;
		this.pDelegateModel = new DelegateModelElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.parser.antlr.Bug301935ExTestLanguage".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public Bug301935TestLanguageGrammarAccess getBug301935TestLanguageGrammarAccess() {
		return gaBug301935TestLanguage;
	}

	
	//DelegateModel returns Model:
	//    Model
	//;
	public DelegateModelElements getDelegateModelAccess() {
		return pDelegateModel;
	}
	
	public ParserRule getDelegateModelRule() {
		return getDelegateModelAccess().getRule();
	}
	
	//Model:
	//    name=ID WS value=ID NL
	//    value2=ID WS
	//;
	public Bug301935TestLanguageGrammarAccess.ModelElements getModelAccess() {
		return gaBug301935TestLanguage.getModelAccess();
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}
	
	//NL:
	//    WS* ('\r'? '\n') WS*;
	public Bug301935TestLanguageGrammarAccess.NLElements getNLAccess() {
		return gaBug301935TestLanguage.getNLAccess();
	}
	
	public ParserRule getNLRule() {
		return getNLAccess().getRule();
	}
	
	//terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaBug301935TestLanguage.getIDRule();
	}
	
	//terminal WS			: (' '|'\t')+;
	public TerminalRule getWSRule() {
		return gaBug301935TestLanguage.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaBug301935TestLanguage.getANY_OTHERRule();
	}
}
