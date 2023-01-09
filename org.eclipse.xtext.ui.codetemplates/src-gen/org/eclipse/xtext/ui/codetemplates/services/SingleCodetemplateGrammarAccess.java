/*******************************************************************************
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class SingleCodetemplateGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class CodetemplatesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.SingleCodetemplate.Codetemplates");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTemplatesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cForKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cLanguageAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cLanguageGrammarCrossReference_2_0 = (CrossReference)cLanguageAssignment_2.eContents().get(0);
		private final RuleCall cLanguageGrammarFQNParserRuleCall_2_0_1 = (RuleCall)cLanguageGrammarCrossReference_2_0.eContents().get(1);
		private final Assignment cTemplatesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTemplatesCodetemplateParserRuleCall_3_0 = (RuleCall)cTemplatesAssignment_3.eContents().get(0);
		
		//@Override
		//Codetemplates:
		//  'templates' 'for' language=[xtext::Grammar|FQN]
		//  templates+=Codetemplate;
		@Override public ParserRule getRule() { return rule; }
		
		//'templates' 'for' language=[xtext::Grammar|FQN]
		//templates+=Codetemplate
		public Group getGroup() { return cGroup; }
		
		//'templates'
		public Keyword getTemplatesKeyword_0() { return cTemplatesKeyword_0; }
		
		//'for'
		public Keyword getForKeyword_1() { return cForKeyword_1; }
		
		//language=[xtext::Grammar|FQN]
		public Assignment getLanguageAssignment_2() { return cLanguageAssignment_2; }
		
		//[xtext::Grammar|FQN]
		public CrossReference getLanguageGrammarCrossReference_2_0() { return cLanguageGrammarCrossReference_2_0; }
		
		//FQN
		public RuleCall getLanguageGrammarFQNParserRuleCall_2_0_1() { return cLanguageGrammarFQNParserRuleCall_2_0_1; }
		
		//templates+=Codetemplate
		public Assignment getTemplatesAssignment_3() { return cTemplatesAssignment_3; }
		
		//Codetemplate
		public RuleCall getTemplatesCodetemplateParserRuleCall_3_0() { return cTemplatesCodetemplateParserRuleCall_3_0; }
	}
	public class CodetemplateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.SingleCodetemplate.Codetemplate");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameSTRINGTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cForKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cContextAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final CrossReference cContextAbstractRuleCrossReference_2_0_0 = (CrossReference)cContextAssignment_2_0.eContents().get(0);
		private final RuleCall cContextAbstractRuleValidIDParserRuleCall_2_0_0_1 = (RuleCall)cContextAbstractRuleCrossReference_2_0_0.eContents().get(1);
		private final Assignment cKeywordContextAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cKeywordContextSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cKeywordContextAssignment_2_1.eContents().get(0);
		private final Assignment cBodyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cBodyTemplateBodyWithQuotesParserRuleCall_3_0 = (RuleCall)cBodyAssignment_3.eContents().get(0);
		
		//@Override
		//Codetemplate:
		//  name=STRING 'for' (context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)
		//  body = TemplateBodyWithQuotes
		//  ;
		@Override public ParserRule getRule() { return rule; }
		
		//name=STRING 'for' (context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)
		//body = TemplateBodyWithQuotes
		public Group getGroup() { return cGroup; }
		
		//name=STRING
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_0_0() { return cNameSTRINGTerminalRuleCall_0_0; }
		
		//'for'
		public Keyword getForKeyword_1() { return cForKeyword_1; }
		
		//(context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//context=[xtext::AbstractRule|ValidID]
		public Assignment getContextAssignment_2_0() { return cContextAssignment_2_0; }
		
		//[xtext::AbstractRule|ValidID]
		public CrossReference getContextAbstractRuleCrossReference_2_0_0() { return cContextAbstractRuleCrossReference_2_0_0; }
		
		//ValidID
		public RuleCall getContextAbstractRuleValidIDParserRuleCall_2_0_0_1() { return cContextAbstractRuleValidIDParserRuleCall_2_0_0_1; }
		
		//keywordContext=STRING
		public Assignment getKeywordContextAssignment_2_1() { return cKeywordContextAssignment_2_1; }
		
		//STRING
		public RuleCall getKeywordContextSTRINGTerminalRuleCall_2_1_0() { return cKeywordContextSTRINGTerminalRuleCall_2_1_0; }
		
		//body = TemplateBodyWithQuotes
		public Assignment getBodyAssignment_3() { return cBodyAssignment_3; }
		
		//TemplateBodyWithQuotes
		public RuleCall getBodyTemplateBodyWithQuotesParserRuleCall_3_0() { return cBodyTemplateBodyWithQuotesParserRuleCall_3_0; }
	}
	public class TemplateBodyWithQuotesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.SingleCodetemplate.TemplateBodyWithQuotes");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cGreaterThanSignGreaterThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cTemplateBodyParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//@Override
		//TemplateBodyWithQuotes returns TemplateBody hidden():
		//  '>>' // EOL
		//  TemplateBody
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'>>' // EOL
		//TemplateBody
		public Group getGroup() { return cGroup; }
		
		//'>>'
		public Keyword getGreaterThanSignGreaterThanSignKeyword_0() { return cGreaterThanSignGreaterThanSignKeyword_0; }
		
		//// EOL
		// TemplateBody
		public RuleCall getTemplateBodyParserRuleCall_1() { return cTemplateBodyParserRuleCall_1; }
	}
	public class LiteralValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.SingleCodetemplate.LiteralValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cANY_OTHERTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//@Override
		//LiteralValue hidden():
		//  (WS | ANY_OTHER | ID)+
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(WS | ANY_OTHER | ID)+
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//WS
		public RuleCall getWSTerminalRuleCall_0() { return cWSTerminalRuleCall_0; }
		
		//ANY_OTHER
		public RuleCall getANY_OTHERTerminalRuleCall_1() { return cANY_OTHERTerminalRuleCall_1; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_2() { return cIDTerminalRuleCall_2; }
	}
	
	
	private final CodetemplatesElements pCodetemplates;
	private final CodetemplateElements pCodetemplate;
	private final TemplateBodyWithQuotesElements pTemplateBodyWithQuotes;
	private final LiteralValueElements pLiteralValue;
	
	private final Grammar grammar;
	
	private final CodetemplatesGrammarAccess gaCodetemplates;

	@Inject
	public SingleCodetemplateGrammarAccess(GrammarProvider grammarProvider,
			CodetemplatesGrammarAccess gaCodetemplates) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaCodetemplates = gaCodetemplates;
		this.pCodetemplates = new CodetemplatesElements();
		this.pCodetemplate = new CodetemplateElements();
		this.pTemplateBodyWithQuotes = new TemplateBodyWithQuotesElements();
		this.pLiteralValue = new LiteralValueElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.ui.codetemplates.SingleCodetemplate".equals(grammar.getName())) {
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
	
	
	public CodetemplatesGrammarAccess getCodetemplatesGrammarAccess() {
		return gaCodetemplates;
	}

	
	//@Override
	//Codetemplates:
	//  'templates' 'for' language=[xtext::Grammar|FQN]
	//  templates+=Codetemplate;
	public CodetemplatesElements getCodetemplatesAccess() {
		return pCodetemplates;
	}
	
	public ParserRule getCodetemplatesRule() {
		return getCodetemplatesAccess().getRule();
	}
	
	//@Override
	//Codetemplate:
	//  name=STRING 'for' (context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)
	//  body = TemplateBodyWithQuotes
	//  ;
	public CodetemplateElements getCodetemplateAccess() {
		return pCodetemplate;
	}
	
	public ParserRule getCodetemplateRule() {
		return getCodetemplateAccess().getRule();
	}
	
	//@Override
	//TemplateBodyWithQuotes returns TemplateBody hidden():
	//  '>>' // EOL
	//  TemplateBody
	//;
	public TemplateBodyWithQuotesElements getTemplateBodyWithQuotesAccess() {
		return pTemplateBodyWithQuotes;
	}
	
	public ParserRule getTemplateBodyWithQuotesRule() {
		return getTemplateBodyWithQuotesAccess().getRule();
	}
	
	//@Override
	//LiteralValue hidden():
	//  (WS | ANY_OTHER | ID)+
	//;
	public LiteralValueElements getLiteralValueAccess() {
		return pLiteralValue;
	}
	
	public ParserRule getLiteralValueRule() {
		return getLiteralValueAccess().getRule();
	}
	
	//TemplateBody hidden(): {TemplateBody}
	//     parts+=Literal?
	//    (parts+=VariableOrDollar parts+=Literal?)*
	//;
	public CodetemplatesGrammarAccess.TemplateBodyElements getTemplateBodyAccess() {
		return gaCodetemplates.getTemplateBodyAccess();
	}
	
	public ParserRule getTemplateBodyRule() {
		return getTemplateBodyAccess().getRule();
	}
	
	//TemplatePart:
	//  Literal | VariableOrDollar
	//;
	public CodetemplatesGrammarAccess.TemplatePartElements getTemplatePartAccess() {
		return gaCodetemplates.getTemplatePartAccess();
	}
	
	public ParserRule getTemplatePartRule() {
		return getTemplatePartAccess().getRule();
	}
	
	//VariableOrDollar returns TemplatePart hidden():
	//  Variable | Dollar;
	public CodetemplatesGrammarAccess.VariableOrDollarElements getVariableOrDollarAccess() {
		return gaCodetemplates.getVariableOrDollarAccess();
	}
	
	public ParserRule getVariableOrDollarRule() {
		return getVariableOrDollarAccess().getRule();
	}
	
	//Variable hidden():
	//    '${' WS*
	//    (
	//         name=ValidID
	//       | (name=ValidID WS*)? ':' WS* type = ValidID (WS* expectingParameters?='(' WS* (parameters+=(STRING|FQN) ( WS* ',' WS* parameters+=(STRING|FQN))* WS*)? ')')?
	//    )
	//    WS* '}'
	//;
	public CodetemplatesGrammarAccess.VariableElements getVariableAccess() {
		return gaCodetemplates.getVariableAccess();
	}
	
	public ParserRule getVariableRule() {
		return getVariableAccess().getRule();
	}
	
	//ValidID hidden():
	//  ID | 'for' | 'templates'
	//;
	public CodetemplatesGrammarAccess.ValidIDElements getValidIDAccess() {
		return gaCodetemplates.getValidIDAccess();
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//FQN hidden(): ValidID ('.' ValidID)*;
	public CodetemplatesGrammarAccess.FQNElements getFQNAccess() {
		return gaCodetemplates.getFQNAccess();
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}
	
	//Literal hidden():
	//  value = LiteralValue
	//;
	public CodetemplatesGrammarAccess.LiteralElements getLiteralAccess() {
		return gaCodetemplates.getLiteralAccess();
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}
	
	//Dollar hidden():
	//  {Dollar} (escaped?='$$' | '$')
	//;
	public CodetemplatesGrammarAccess.DollarElements getDollarAccess() {
		return gaCodetemplates.getDollarAccess();
	}
	
	public ParserRule getDollarRule() {
		return getDollarAccess().getRule();
	}
	
	//terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaCodetemplates.getIDRule();
	}
	
	//terminal STRING    :
	//            "'" ( '\\' ('b'|'t'|'n'|'f'|'r'|'"'|"'"|'\\') | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return gaCodetemplates.getSTRINGRule();
	}
	
	//terminal WS			: (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaCodetemplates.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaCodetemplates.getANY_OTHERRule();
	}
}
