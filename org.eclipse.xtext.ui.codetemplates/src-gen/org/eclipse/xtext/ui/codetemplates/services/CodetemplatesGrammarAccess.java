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
import org.eclipse.xtext.Action;
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
public class CodetemplatesGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class CodetemplatesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.Codetemplates");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTemplatesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cForKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cLanguageAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cLanguageGrammarCrossReference_2_0 = (CrossReference)cLanguageAssignment_2.eContents().get(0);
		private final RuleCall cLanguageGrammarFQNParserRuleCall_2_0_1 = (RuleCall)cLanguageGrammarCrossReference_2_0.eContents().get(1);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cTemplatesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTemplatesCodetemplateParserRuleCall_4_0 = (RuleCall)cTemplatesAssignment_4.eContents().get(0);
		
		//Codetemplates:
		//  'templates' 'for' language=[xtext::Grammar|FQN] ':'
		//  templates+=Codetemplate*;
		@Override public ParserRule getRule() { return rule; }
		
		//'templates' 'for' language=[xtext::Grammar|FQN] ':'
		//templates+=Codetemplate*
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
		
		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }
		
		//templates+=Codetemplate*
		public Assignment getTemplatesAssignment_4() { return cTemplatesAssignment_4; }
		
		//Codetemplate
		public RuleCall getTemplatesCodetemplateParserRuleCall_4_0() { return cTemplatesCodetemplateParserRuleCall_4_0; }
	}
	public class CodetemplateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.Codetemplate");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameValidIDParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIdAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cIdIDTerminalRuleCall_2_0 = (RuleCall)cIdAssignment_2.eContents().get(0);
		private final Keyword cCommaKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cDescriptionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cDescriptionSTRINGTerminalRuleCall_4_0 = (RuleCall)cDescriptionAssignment_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cForKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Assignment cContextAssignment_7_0 = (Assignment)cAlternatives_7.eContents().get(0);
		private final CrossReference cContextAbstractRuleCrossReference_7_0_0 = (CrossReference)cContextAssignment_7_0.eContents().get(0);
		private final RuleCall cContextAbstractRuleValidIDParserRuleCall_7_0_0_1 = (RuleCall)cContextAbstractRuleCrossReference_7_0_0.eContents().get(1);
		private final Assignment cKeywordContextAssignment_7_1 = (Assignment)cAlternatives_7.eContents().get(1);
		private final RuleCall cKeywordContextSTRINGTerminalRuleCall_7_1_0 = (RuleCall)cKeywordContextAssignment_7_1.eContents().get(0);
		private final Assignment cBodyAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cBodyTemplateBodyWithQuotesParserRuleCall_8_0 = (RuleCall)cBodyAssignment_8.eContents().get(0);
		
		//Codetemplate:
		//  name=ValidID '(' id=ID ',' description = STRING ')' 'for'
		//          (context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)
		//    body = TemplateBodyWithQuotes
		//  ;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ValidID '(' id=ID ',' description = STRING ')' 'for'
		//        (context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)
		//  body = TemplateBodyWithQuotes
		public Group getGroup() { return cGroup; }
		
		//name=ValidID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_0_0() { return cNameValidIDParserRuleCall_0_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//id=ID
		public Assignment getIdAssignment_2() { return cIdAssignment_2; }
		
		//ID
		public RuleCall getIdIDTerminalRuleCall_2_0() { return cIdIDTerminalRuleCall_2_0; }
		
		//','
		public Keyword getCommaKeyword_3() { return cCommaKeyword_3; }
		
		//description = STRING
		public Assignment getDescriptionAssignment_4() { return cDescriptionAssignment_4; }
		
		//STRING
		public RuleCall getDescriptionSTRINGTerminalRuleCall_4_0() { return cDescriptionSTRINGTerminalRuleCall_4_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
		
		//'for'
		public Keyword getForKeyword_6() { return cForKeyword_6; }
		
		//(context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)
		public Alternatives getAlternatives_7() { return cAlternatives_7; }
		
		//context=[xtext::AbstractRule|ValidID]
		public Assignment getContextAssignment_7_0() { return cContextAssignment_7_0; }
		
		//[xtext::AbstractRule|ValidID]
		public CrossReference getContextAbstractRuleCrossReference_7_0_0() { return cContextAbstractRuleCrossReference_7_0_0; }
		
		//ValidID
		public RuleCall getContextAbstractRuleValidIDParserRuleCall_7_0_0_1() { return cContextAbstractRuleValidIDParserRuleCall_7_0_0_1; }
		
		//keywordContext=STRING
		public Assignment getKeywordContextAssignment_7_1() { return cKeywordContextAssignment_7_1; }
		
		//STRING
		public RuleCall getKeywordContextSTRINGTerminalRuleCall_7_1_0() { return cKeywordContextSTRINGTerminalRuleCall_7_1_0; }
		
		//body = TemplateBodyWithQuotes
		public Assignment getBodyAssignment_8() { return cBodyAssignment_8; }
		
		//TemplateBodyWithQuotes
		public RuleCall getBodyTemplateBodyWithQuotesParserRuleCall_8_0() { return cBodyTemplateBodyWithQuotesParserRuleCall_8_0; }
	}
	public class TemplateBodyWithQuotesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.TemplateBodyWithQuotes");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cGreaterThanSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cTemplateBodyParserRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Keyword cLessThanSignLessThanSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//TemplateBodyWithQuotes returns TemplateBody hidden():
		//    WS? '>>' // EOL
		//    TemplateBody
		//    '<<' // BOL
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//WS? '>>' // EOL
		//TemplateBody
		//'<<'
		public Group getGroup() { return cGroup; }
		
		//WS?
		public RuleCall getWSTerminalRuleCall_0() { return cWSTerminalRuleCall_0; }
		
		//'>>'
		public Keyword getGreaterThanSignGreaterThanSignKeyword_1() { return cGreaterThanSignGreaterThanSignKeyword_1; }
		
		//// EOL
		//   TemplateBody
		public RuleCall getTemplateBodyParserRuleCall_2() { return cTemplateBodyParserRuleCall_2; }
		
		//'<<'
		public Keyword getLessThanSignLessThanSignKeyword_3() { return cLessThanSignLessThanSignKeyword_3; }
	}
	public class TemplateBodyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.TemplateBody");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTemplateBodyAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cPartsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cPartsLiteralParserRuleCall_1_0 = (RuleCall)cPartsAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cPartsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cPartsVariableOrDollarParserRuleCall_2_0_0 = (RuleCall)cPartsAssignment_2_0.eContents().get(0);
		private final Assignment cPartsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cPartsLiteralParserRuleCall_2_1_0 = (RuleCall)cPartsAssignment_2_1.eContents().get(0);
		
		//TemplateBody hidden(): {TemplateBody}
		//     parts+=Literal?
		//    (parts+=VariableOrDollar parts+=Literal?)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{TemplateBody}
		//    parts+=Literal?
		//   (parts+=VariableOrDollar parts+=Literal?)*
		public Group getGroup() { return cGroup; }
		
		//{TemplateBody}
		public Action getTemplateBodyAction_0() { return cTemplateBodyAction_0; }
		
		//parts+=Literal?
		public Assignment getPartsAssignment_1() { return cPartsAssignment_1; }
		
		//Literal
		public RuleCall getPartsLiteralParserRuleCall_1_0() { return cPartsLiteralParserRuleCall_1_0; }
		
		//(parts+=VariableOrDollar parts+=Literal?)*
		public Group getGroup_2() { return cGroup_2; }
		
		//parts+=VariableOrDollar
		public Assignment getPartsAssignment_2_0() { return cPartsAssignment_2_0; }
		
		//VariableOrDollar
		public RuleCall getPartsVariableOrDollarParserRuleCall_2_0_0() { return cPartsVariableOrDollarParserRuleCall_2_0_0; }
		
		//parts+=Literal?
		public Assignment getPartsAssignment_2_1() { return cPartsAssignment_2_1; }
		
		//Literal
		public RuleCall getPartsLiteralParserRuleCall_2_1_0() { return cPartsLiteralParserRuleCall_2_1_0; }
	}
	public class TemplatePartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.TemplatePart");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cVariableOrDollarParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//TemplatePart:
		//  Literal | VariableOrDollar
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Literal | VariableOrDollar
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Literal
		public RuleCall getLiteralParserRuleCall_0() { return cLiteralParserRuleCall_0; }
		
		//VariableOrDollar
		public RuleCall getVariableOrDollarParserRuleCall_1() { return cVariableOrDollarParserRuleCall_1; }
	}
	public class VariableOrDollarElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.VariableOrDollar");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cVariableParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDollarParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//VariableOrDollar returns TemplatePart hidden():
		//  Variable | Dollar;
		@Override public ParserRule getRule() { return rule; }
		
		//Variable | Dollar
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Variable
		public RuleCall getVariableParserRuleCall_0() { return cVariableParserRuleCall_0; }
		
		//Dollar
		public RuleCall getDollarParserRuleCall_1() { return cDollarParserRuleCall_1; }
	}
	public class VariableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.Variable");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDollarSignLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cNameValidIDParserRuleCall_2_0_0 = (RuleCall)cNameAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Group cGroup_2_1_0 = (Group)cGroup_2_1.eContents().get(0);
		private final Assignment cNameAssignment_2_1_0_0 = (Assignment)cGroup_2_1_0.eContents().get(0);
		private final RuleCall cNameValidIDParserRuleCall_2_1_0_0_0 = (RuleCall)cNameAssignment_2_1_0_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_2_1_0_1 = (RuleCall)cGroup_2_1_0.eContents().get(1);
		private final Keyword cColonKeyword_2_1_1 = (Keyword)cGroup_2_1.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2_1_2 = (RuleCall)cGroup_2_1.eContents().get(2);
		private final Assignment cTypeAssignment_2_1_3 = (Assignment)cGroup_2_1.eContents().get(3);
		private final RuleCall cTypeValidIDParserRuleCall_2_1_3_0 = (RuleCall)cTypeAssignment_2_1_3.eContents().get(0);
		private final Group cGroup_2_1_4 = (Group)cGroup_2_1.eContents().get(4);
		private final RuleCall cWSTerminalRuleCall_2_1_4_0 = (RuleCall)cGroup_2_1_4.eContents().get(0);
		private final Assignment cExpectingParametersAssignment_2_1_4_1 = (Assignment)cGroup_2_1_4.eContents().get(1);
		private final Keyword cExpectingParametersLeftParenthesisKeyword_2_1_4_1_0 = (Keyword)cExpectingParametersAssignment_2_1_4_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_2_1_4_2 = (RuleCall)cGroup_2_1_4.eContents().get(2);
		private final Group cGroup_2_1_4_3 = (Group)cGroup_2_1_4.eContents().get(3);
		private final Assignment cParametersAssignment_2_1_4_3_0 = (Assignment)cGroup_2_1_4_3.eContents().get(0);
		private final Alternatives cParametersAlternatives_2_1_4_3_0_0 = (Alternatives)cParametersAssignment_2_1_4_3_0.eContents().get(0);
		private final RuleCall cParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0 = (RuleCall)cParametersAlternatives_2_1_4_3_0_0.eContents().get(0);
		private final RuleCall cParametersFQNParserRuleCall_2_1_4_3_0_0_1 = (RuleCall)cParametersAlternatives_2_1_4_3_0_0.eContents().get(1);
		private final Group cGroup_2_1_4_3_1 = (Group)cGroup_2_1_4_3.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2_1_4_3_1_0 = (RuleCall)cGroup_2_1_4_3_1.eContents().get(0);
		private final Keyword cCommaKeyword_2_1_4_3_1_1 = (Keyword)cGroup_2_1_4_3_1.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2_1_4_3_1_2 = (RuleCall)cGroup_2_1_4_3_1.eContents().get(2);
		private final Assignment cParametersAssignment_2_1_4_3_1_3 = (Assignment)cGroup_2_1_4_3_1.eContents().get(3);
		private final Alternatives cParametersAlternatives_2_1_4_3_1_3_0 = (Alternatives)cParametersAssignment_2_1_4_3_1_3.eContents().get(0);
		private final RuleCall cParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0 = (RuleCall)cParametersAlternatives_2_1_4_3_1_3_0.eContents().get(0);
		private final RuleCall cParametersFQNParserRuleCall_2_1_4_3_1_3_0_1 = (RuleCall)cParametersAlternatives_2_1_4_3_1_3_0.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2_1_4_3_2 = (RuleCall)cGroup_2_1_4_3.eContents().get(2);
		private final Keyword cRightParenthesisKeyword_2_1_4_4 = (Keyword)cGroup_2_1_4.eContents().get(4);
		private final RuleCall cWSTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Variable hidden():
		//    '${' WS*
		//    (
		//         name=ValidID
		//       | (name=ValidID WS*)? ':' WS* type = ValidID (WS* expectingParameters?='(' WS* (parameters+=(STRING|FQN) ( WS* ',' WS* parameters+=(STRING|FQN))* WS*)? ')')?
		//    )
		//    WS* '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'${' WS*
		//(
		//     name=ValidID
		//   | (name=ValidID WS*)? ':' WS* type = ValidID (WS* expectingParameters?='(' WS* (parameters+=(STRING|FQN) ( WS* ',' WS* parameters+=(STRING|FQN))* WS*)? ')')?
		//)
		//WS* '}'
		public Group getGroup() { return cGroup; }
		
		//'${'
		public Keyword getDollarSignLeftCurlyBracketKeyword_0() { return cDollarSignLeftCurlyBracketKeyword_0; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }
		
		//(
		//     name=ValidID
		//   | (name=ValidID WS*)? ':' WS* type = ValidID (WS* expectingParameters?='(' WS* (parameters+=(STRING|FQN) ( WS* ',' WS* parameters+=(STRING|FQN))* WS*)? ')')?
		//)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_0() { return cNameAssignment_2_0; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_0() { return cNameValidIDParserRuleCall_2_0_0; }
		
		//(name=ValidID WS*)? ':' WS* type = ValidID (WS* expectingParameters?='(' WS* (parameters+=(STRING|FQN) ( WS* ',' WS* parameters+=(STRING|FQN))* WS*)? ')')?
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//(name=ValidID WS*)?
		public Group getGroup_2_1_0() { return cGroup_2_1_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_1_0_0() { return cNameAssignment_2_1_0_0; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_1_0_0_0() { return cNameValidIDParserRuleCall_2_1_0_0_0; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_0_1() { return cWSTerminalRuleCall_2_1_0_1; }
		
		//':'
		public Keyword getColonKeyword_2_1_1() { return cColonKeyword_2_1_1; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_2() { return cWSTerminalRuleCall_2_1_2; }
		
		//type = ValidID
		public Assignment getTypeAssignment_2_1_3() { return cTypeAssignment_2_1_3; }
		
		//ValidID
		public RuleCall getTypeValidIDParserRuleCall_2_1_3_0() { return cTypeValidIDParserRuleCall_2_1_3_0; }
		
		//(WS* expectingParameters?='(' WS* (parameters+=(STRING|FQN) ( WS* ',' WS* parameters+=(STRING|FQN))* WS*)? ')')?
		public Group getGroup_2_1_4() { return cGroup_2_1_4; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_4_0() { return cWSTerminalRuleCall_2_1_4_0; }
		
		//expectingParameters?='('
		public Assignment getExpectingParametersAssignment_2_1_4_1() { return cExpectingParametersAssignment_2_1_4_1; }
		
		//'('
		public Keyword getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0() { return cExpectingParametersLeftParenthesisKeyword_2_1_4_1_0; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_4_2() { return cWSTerminalRuleCall_2_1_4_2; }
		
		//(parameters+=(STRING|FQN) ( WS* ',' WS* parameters+=(STRING|FQN))* WS*)?
		public Group getGroup_2_1_4_3() { return cGroup_2_1_4_3; }
		
		//parameters+=(STRING|FQN)
		public Assignment getParametersAssignment_2_1_4_3_0() { return cParametersAssignment_2_1_4_3_0; }
		
		//(STRING|FQN)
		public Alternatives getParametersAlternatives_2_1_4_3_0_0() { return cParametersAlternatives_2_1_4_3_0_0; }
		
		//STRING
		public RuleCall getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0() { return cParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0; }
		
		//FQN
		public RuleCall getParametersFQNParserRuleCall_2_1_4_3_0_0_1() { return cParametersFQNParserRuleCall_2_1_4_3_0_0_1; }
		
		//( WS* ',' WS* parameters+=(STRING|FQN))*
		public Group getGroup_2_1_4_3_1() { return cGroup_2_1_4_3_1; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_4_3_1_0() { return cWSTerminalRuleCall_2_1_4_3_1_0; }
		
		//','
		public Keyword getCommaKeyword_2_1_4_3_1_1() { return cCommaKeyword_2_1_4_3_1_1; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_4_3_1_2() { return cWSTerminalRuleCall_2_1_4_3_1_2; }
		
		//parameters+=(STRING|FQN)
		public Assignment getParametersAssignment_2_1_4_3_1_3() { return cParametersAssignment_2_1_4_3_1_3; }
		
		//(STRING|FQN)
		public Alternatives getParametersAlternatives_2_1_4_3_1_3_0() { return cParametersAlternatives_2_1_4_3_1_3_0; }
		
		//STRING
		public RuleCall getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0() { return cParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0; }
		
		//FQN
		public RuleCall getParametersFQNParserRuleCall_2_1_4_3_1_3_0_1() { return cParametersFQNParserRuleCall_2_1_4_3_1_3_0_1; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_4_3_2() { return cWSTerminalRuleCall_2_1_4_3_2; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_1_4_4() { return cRightParenthesisKeyword_2_1_4_4; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_3() { return cWSTerminalRuleCall_3; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class ValidIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cForKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cTemplatesKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		
		//ValidID hidden():
		//  ID | 'for' | 'templates'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ID | 'for' | 'templates'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//'for'
		public Keyword getForKeyword_1() { return cForKeyword_1; }
		
		//'templates'
		public Keyword getTemplatesKeyword_2() { return cTemplatesKeyword_2; }
	}
	public class FQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.FQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cValidIDParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//FQN hidden(): ValidID ('.' ValidID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ValidID ('.' ValidID)*
		public Group getGroup() { return cGroup; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//('.' ValidID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_1_1() { return cValidIDParserRuleCall_1_1; }
	}
	public class LiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.Literal");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueLiteralValueParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//Literal hidden():
		//  value = LiteralValue
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value = LiteralValue
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//LiteralValue
		public RuleCall getValueLiteralValueParserRuleCall_0() { return cValueLiteralValueParserRuleCall_0; }
	}
	public class LiteralValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.LiteralValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cANY_OTHERTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final Keyword cReverseSolidusLessThanSignLessThanSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//LiteralValue hidden():
		//  (WS | ANY_OTHER | ID | '\\<<')+ // needs to be escaped at BOL
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(WS | ANY_OTHER | ID | '\\<<')+
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//WS
		public RuleCall getWSTerminalRuleCall_0() { return cWSTerminalRuleCall_0; }
		
		//ANY_OTHER
		public RuleCall getANY_OTHERTerminalRuleCall_1() { return cANY_OTHERTerminalRuleCall_1; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_2() { return cIDTerminalRuleCall_2; }
		
		//'\\<<'
		public Keyword getReverseSolidusLessThanSignLessThanSignKeyword_3() { return cReverseSolidusLessThanSignLessThanSignKeyword_3; }
	}
	public class DollarElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.Dollar");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDollarAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cEscapedAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cEscapedDollarSignDollarSignKeyword_1_0_0 = (Keyword)cEscapedAssignment_1_0.eContents().get(0);
		private final Keyword cDollarSignKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		
		//Dollar hidden():
		//  {Dollar} (escaped?='$$' | '$')
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{Dollar} (escaped?='$$' | '$')
		public Group getGroup() { return cGroup; }
		
		//{Dollar}
		public Action getDollarAction_0() { return cDollarAction_0; }
		
		//(escaped?='$$' | '$')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//escaped?='$$'
		public Assignment getEscapedAssignment_1_0() { return cEscapedAssignment_1_0; }
		
		//'$$'
		public Keyword getEscapedDollarSignDollarSignKeyword_1_0_0() { return cEscapedDollarSignDollarSignKeyword_1_0_0; }
		
		//'$'
		public Keyword getDollarSignKeyword_1_1() { return cDollarSignKeyword_1_1; }
	}
	
	
	private final CodetemplatesElements pCodetemplates;
	private final CodetemplateElements pCodetemplate;
	private final TemplateBodyWithQuotesElements pTemplateBodyWithQuotes;
	private final TemplateBodyElements pTemplateBody;
	private final TemplatePartElements pTemplatePart;
	private final VariableOrDollarElements pVariableOrDollar;
	private final VariableElements pVariable;
	private final ValidIDElements pValidID;
	private final FQNElements pFQN;
	private final LiteralElements pLiteral;
	private final LiteralValueElements pLiteralValue;
	private final DollarElements pDollar;
	private final TerminalRule tID;
	private final TerminalRule tSTRING;
	private final TerminalRule tWS;
	private final TerminalRule tANY_OTHER;
	
	private final Grammar grammar;

	@Inject
	public CodetemplatesGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pCodetemplates = new CodetemplatesElements();
		this.pCodetemplate = new CodetemplateElements();
		this.pTemplateBodyWithQuotes = new TemplateBodyWithQuotesElements();
		this.pTemplateBody = new TemplateBodyElements();
		this.pTemplatePart = new TemplatePartElements();
		this.pVariableOrDollar = new VariableOrDollarElements();
		this.pVariable = new VariableElements();
		this.pValidID = new ValidIDElements();
		this.pFQN = new FQNElements();
		this.pLiteral = new LiteralElements();
		this.pLiteralValue = new LiteralValueElements();
		this.pDollar = new DollarElements();
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.ID");
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.WS");
		this.tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.codetemplates.Codetemplates.ANY_OTHER");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.ui.codetemplates.Codetemplates".equals(grammar.getName())) {
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
	

	
	//Codetemplates:
	//  'templates' 'for' language=[xtext::Grammar|FQN] ':'
	//  templates+=Codetemplate*;
	public CodetemplatesElements getCodetemplatesAccess() {
		return pCodetemplates;
	}
	
	public ParserRule getCodetemplatesRule() {
		return getCodetemplatesAccess().getRule();
	}
	
	//Codetemplate:
	//  name=ValidID '(' id=ID ',' description = STRING ')' 'for'
	//          (context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)
	//    body = TemplateBodyWithQuotes
	//  ;
	public CodetemplateElements getCodetemplateAccess() {
		return pCodetemplate;
	}
	
	public ParserRule getCodetemplateRule() {
		return getCodetemplateAccess().getRule();
	}
	
	//TemplateBodyWithQuotes returns TemplateBody hidden():
	//    WS? '>>' // EOL
	//    TemplateBody
	//    '<<' // BOL
	//;
	public TemplateBodyWithQuotesElements getTemplateBodyWithQuotesAccess() {
		return pTemplateBodyWithQuotes;
	}
	
	public ParserRule getTemplateBodyWithQuotesRule() {
		return getTemplateBodyWithQuotesAccess().getRule();
	}
	
	//TemplateBody hidden(): {TemplateBody}
	//     parts+=Literal?
	//    (parts+=VariableOrDollar parts+=Literal?)*
	//;
	public TemplateBodyElements getTemplateBodyAccess() {
		return pTemplateBody;
	}
	
	public ParserRule getTemplateBodyRule() {
		return getTemplateBodyAccess().getRule();
	}
	
	//TemplatePart:
	//  Literal | VariableOrDollar
	//;
	public TemplatePartElements getTemplatePartAccess() {
		return pTemplatePart;
	}
	
	public ParserRule getTemplatePartRule() {
		return getTemplatePartAccess().getRule();
	}
	
	//VariableOrDollar returns TemplatePart hidden():
	//  Variable | Dollar;
	public VariableOrDollarElements getVariableOrDollarAccess() {
		return pVariableOrDollar;
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
	public VariableElements getVariableAccess() {
		return pVariable;
	}
	
	public ParserRule getVariableRule() {
		return getVariableAccess().getRule();
	}
	
	//ValidID hidden():
	//  ID | 'for' | 'templates'
	//;
	public ValidIDElements getValidIDAccess() {
		return pValidID;
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//FQN hidden(): ValidID ('.' ValidID)*;
	public FQNElements getFQNAccess() {
		return pFQN;
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}
	
	//Literal hidden():
	//  value = LiteralValue
	//;
	public LiteralElements getLiteralAccess() {
		return pLiteral;
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}
	
	//LiteralValue hidden():
	//  (WS | ANY_OTHER | ID | '\\<<')+ // needs to be escaped at BOL
	//;
	public LiteralValueElements getLiteralValueAccess() {
		return pLiteralValue;
	}
	
	public ParserRule getLiteralValueRule() {
		return getLiteralValueAccess().getRule();
	}
	
	//Dollar hidden():
	//  {Dollar} (escaped?='$$' | '$')
	//;
	public DollarElements getDollarAccess() {
		return pDollar;
	}
	
	public ParserRule getDollarRule() {
		return getDollarAccess().getRule();
	}
	
	//terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return tID;
	}
	
	//terminal STRING    :
	//            "'" ( '\\' ('b'|'t'|'n'|'f'|'r'|'"'|"'"|'\\') | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	}
	
	//terminal WS			: (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return tWS;
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return tANY_OTHER;
	}
}
