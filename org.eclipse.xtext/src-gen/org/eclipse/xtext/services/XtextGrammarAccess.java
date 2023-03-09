/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.services;

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
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class XtextGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class GrammarElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Grammar");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cGrammarKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameGrammarIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cWithKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cUsedGrammarsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cUsedGrammarsGrammarCrossReference_2_1_0 = (CrossReference)cUsedGrammarsAssignment_2_1.eContents().get(0);
		private final RuleCall cUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1 = (RuleCall)cUsedGrammarsGrammarCrossReference_2_1_0.eContents().get(1);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cUsedGrammarsAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final CrossReference cUsedGrammarsGrammarCrossReference_2_2_1_0 = (CrossReference)cUsedGrammarsAssignment_2_2_1.eContents().get(0);
		private final RuleCall cUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1 = (RuleCall)cUsedGrammarsGrammarCrossReference_2_2_1_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cDefinesHiddenTokensAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final Keyword cDefinesHiddenTokensHiddenKeyword_3_0_0 = (Keyword)cDefinesHiddenTokensAssignment_3_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Assignment cHiddenTokensAssignment_3_2_0 = (Assignment)cGroup_3_2.eContents().get(0);
		private final CrossReference cHiddenTokensAbstractRuleCrossReference_3_2_0_0 = (CrossReference)cHiddenTokensAssignment_3_2_0.eContents().get(0);
		private final RuleCall cHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1 = (RuleCall)cHiddenTokensAbstractRuleCrossReference_3_2_0_0.eContents().get(1);
		private final Group cGroup_3_2_1 = (Group)cGroup_3_2.eContents().get(1);
		private final Keyword cCommaKeyword_3_2_1_0 = (Keyword)cGroup_3_2_1.eContents().get(0);
		private final Assignment cHiddenTokensAssignment_3_2_1_1 = (Assignment)cGroup_3_2_1.eContents().get(1);
		private final CrossReference cHiddenTokensAbstractRuleCrossReference_3_2_1_1_0 = (CrossReference)cHiddenTokensAssignment_3_2_1_1.eContents().get(0);
		private final RuleCall cHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1 = (RuleCall)cHiddenTokensAbstractRuleCrossReference_3_2_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Assignment cMetamodelDeclarationsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0 = (RuleCall)cMetamodelDeclarationsAssignment_4.eContents().get(0);
		private final Assignment cRulesAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cRulesAbstractRuleParserRuleCall_5_0 = (RuleCall)cRulesAssignment_5.eContents().get(0);
		
		//Grammar:
		//    'grammar' name=GrammarID ('with' usedGrammars+=[Grammar|GrammarID] (',' usedGrammars+=[Grammar|GrammarID])*)?
		//    (definesHiddenTokens?='hidden' '(' (hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)? ')')?
		//    metamodelDeclarations+=AbstractMetamodelDeclaration*
		//    (rules+=AbstractRule)+
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'grammar' name=GrammarID ('with' usedGrammars+=[Grammar|GrammarID] (',' usedGrammars+=[Grammar|GrammarID])*)?
		//(definesHiddenTokens?='hidden' '(' (hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)? ')')?
		//metamodelDeclarations+=AbstractMetamodelDeclaration*
		//(rules+=AbstractRule)+
		public Group getGroup() { return cGroup; }
		
		//'grammar'
		public Keyword getGrammarKeyword_0() { return cGrammarKeyword_0; }
		
		//name=GrammarID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//GrammarID
		public RuleCall getNameGrammarIDParserRuleCall_1_0() { return cNameGrammarIDParserRuleCall_1_0; }
		
		//('with' usedGrammars+=[Grammar|GrammarID] (',' usedGrammars+=[Grammar|GrammarID])*)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'with'
		public Keyword getWithKeyword_2_0() { return cWithKeyword_2_0; }
		
		//usedGrammars+=[Grammar|GrammarID]
		public Assignment getUsedGrammarsAssignment_2_1() { return cUsedGrammarsAssignment_2_1; }
		
		//[Grammar|GrammarID]
		public CrossReference getUsedGrammarsGrammarCrossReference_2_1_0() { return cUsedGrammarsGrammarCrossReference_2_1_0; }
		
		//GrammarID
		public RuleCall getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1() { return cUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1; }
		
		//(',' usedGrammars+=[Grammar|GrammarID])*
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//','
		public Keyword getCommaKeyword_2_2_0() { return cCommaKeyword_2_2_0; }
		
		//usedGrammars+=[Grammar|GrammarID]
		public Assignment getUsedGrammarsAssignment_2_2_1() { return cUsedGrammarsAssignment_2_2_1; }
		
		//[Grammar|GrammarID]
		public CrossReference getUsedGrammarsGrammarCrossReference_2_2_1_0() { return cUsedGrammarsGrammarCrossReference_2_2_1_0; }
		
		//GrammarID
		public RuleCall getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1() { return cUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1; }
		
		//(definesHiddenTokens?='hidden' '(' (hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)? ')')?
		public Group getGroup_3() { return cGroup_3; }
		
		//definesHiddenTokens?='hidden'
		public Assignment getDefinesHiddenTokensAssignment_3_0() { return cDefinesHiddenTokensAssignment_3_0; }
		
		//'hidden'
		public Keyword getDefinesHiddenTokensHiddenKeyword_3_0_0() { return cDefinesHiddenTokensHiddenKeyword_3_0_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3_1() { return cLeftParenthesisKeyword_3_1; }
		
		//(hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)?
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//hiddenTokens+=[AbstractRule|RuleID]
		public Assignment getHiddenTokensAssignment_3_2_0() { return cHiddenTokensAssignment_3_2_0; }
		
		//[AbstractRule|RuleID]
		public CrossReference getHiddenTokensAbstractRuleCrossReference_3_2_0_0() { return cHiddenTokensAbstractRuleCrossReference_3_2_0_0; }
		
		//RuleID
		public RuleCall getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1() { return cHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1; }
		
		//(',' hiddenTokens+=[AbstractRule|RuleID])*
		public Group getGroup_3_2_1() { return cGroup_3_2_1; }
		
		//','
		public Keyword getCommaKeyword_3_2_1_0() { return cCommaKeyword_3_2_1_0; }
		
		//hiddenTokens+=[AbstractRule|RuleID]
		public Assignment getHiddenTokensAssignment_3_2_1_1() { return cHiddenTokensAssignment_3_2_1_1; }
		
		//[AbstractRule|RuleID]
		public CrossReference getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0() { return cHiddenTokensAbstractRuleCrossReference_3_2_1_1_0; }
		
		//RuleID
		public RuleCall getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1() { return cHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3_3() { return cRightParenthesisKeyword_3_3; }
		
		//metamodelDeclarations+=AbstractMetamodelDeclaration*
		public Assignment getMetamodelDeclarationsAssignment_4() { return cMetamodelDeclarationsAssignment_4; }
		
		//AbstractMetamodelDeclaration
		public RuleCall getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0() { return cMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0; }
		
		//(rules+=AbstractRule)+
		public Assignment getRulesAssignment_5() { return cRulesAssignment_5; }
		
		//AbstractRule
		public RuleCall getRulesAbstractRuleParserRuleCall_5_0() { return cRulesAbstractRuleParserRuleCall_5_0; }
	}
	public class GrammarIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.GrammarID");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cValidIDParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//GrammarID returns ecore::EString:
		//    ValidID ('.' ValidID)*;
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
	public class AbstractRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.AbstractRule");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cParserRuleParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTerminalRuleParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cEnumRuleParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//AbstractRule : ParserRule | TerminalRule | EnumRule;
		@Override public ParserRule getRule() { return rule; }
		
		//ParserRule | TerminalRule | EnumRule
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ParserRule
		public RuleCall getParserRuleParserRuleCall_0() { return cParserRuleParserRuleCall_0; }
		
		//TerminalRule
		public RuleCall getTerminalRuleParserRuleCall_1() { return cTerminalRuleParserRuleCall_1; }
		
		//EnumRule
		public RuleCall getEnumRuleParserRuleCall_2() { return cEnumRuleParserRuleCall_2; }
	}
	public class AbstractMetamodelDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.AbstractMetamodelDeclaration");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cGeneratedMetamodelParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReferencedMetamodelParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AbstractMetamodelDeclaration :
		//    GeneratedMetamodel | ReferencedMetamodel;
		@Override public ParserRule getRule() { return rule; }
		
		//GeneratedMetamodel | ReferencedMetamodel
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//GeneratedMetamodel
		public RuleCall getGeneratedMetamodelParserRuleCall_0() { return cGeneratedMetamodelParserRuleCall_0; }
		
		//ReferencedMetamodel
		public RuleCall getReferencedMetamodelParserRuleCall_1() { return cReferencedMetamodelParserRuleCall_1; }
	}
	public class GeneratedMetamodelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.GeneratedMetamodel");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cGenerateKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cEPackageAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cEPackageEPackageCrossReference_2_0 = (CrossReference)cEPackageAssignment_2.eContents().get(0);
		private final RuleCall cEPackageEPackageSTRINGTerminalRuleCall_2_0_1 = (RuleCall)cEPackageEPackageCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cAsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cAliasAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cAliasValidIDParserRuleCall_3_1_0 = (RuleCall)cAliasAssignment_3_1.eContents().get(0);
		
		//// constraint: typeSelect(GeneratedMetamodel).size() == typeSelect(GeneratedMetamodel).alias.size()
		//// generated metamodels have to have different aliases
		//GeneratedMetamodel :
		//    'generate' name=ValidID ePackage=[ecore::EPackage|STRING] ('as' alias=ValidID)?;
		@Override public ParserRule getRule() { return rule; }
		
		//'generate' name=ValidID ePackage=[ecore::EPackage|STRING] ('as' alias=ValidID)?
		public Group getGroup() { return cGroup; }
		
		//'generate'
		public Keyword getGenerateKeyword_0() { return cGenerateKeyword_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
		
		//ePackage=[ecore::EPackage|STRING]
		public Assignment getEPackageAssignment_2() { return cEPackageAssignment_2; }
		
		//[ecore::EPackage|STRING]
		public CrossReference getEPackageEPackageCrossReference_2_0() { return cEPackageEPackageCrossReference_2_0; }
		
		//STRING
		public RuleCall getEPackageEPackageSTRINGTerminalRuleCall_2_0_1() { return cEPackageEPackageSTRINGTerminalRuleCall_2_0_1; }
		
		//('as' alias=ValidID)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'as'
		public Keyword getAsKeyword_3_0() { return cAsKeyword_3_0; }
		
		//alias=ValidID
		public Assignment getAliasAssignment_3_1() { return cAliasAssignment_3_1; }
		
		//ValidID
		public RuleCall getAliasValidIDParserRuleCall_3_1_0() { return cAliasValidIDParserRuleCall_3_1_0; }
	}
	public class ReferencedMetamodelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ReferencedMetamodel");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cEPackageAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cEPackageEPackageCrossReference_1_0 = (CrossReference)cEPackageAssignment_1.eContents().get(0);
		private final RuleCall cEPackageEPackageSTRINGTerminalRuleCall_1_0_1 = (RuleCall)cEPackageEPackageCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cAsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cAliasAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cAliasValidIDParserRuleCall_2_1_0 = (RuleCall)cAliasAssignment_2_1.eContents().get(0);
		
		//// referenced metamodels may share aliases with other referenced metamodels
		//// and with generated metamodels
		//ReferencedMetamodel :
		//    'import' ePackage=[ecore::EPackage|STRING] ('as' alias=ValidID)?;
		@Override public ParserRule getRule() { return rule; }
		
		//'import' ePackage=[ecore::EPackage|STRING] ('as' alias=ValidID)?
		public Group getGroup() { return cGroup; }
		
		//'import'
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }
		
		//ePackage=[ecore::EPackage|STRING]
		public Assignment getEPackageAssignment_1() { return cEPackageAssignment_1; }
		
		//[ecore::EPackage|STRING]
		public CrossReference getEPackageEPackageCrossReference_1_0() { return cEPackageEPackageCrossReference_1_0; }
		
		//STRING
		public RuleCall getEPackageEPackageSTRINGTerminalRuleCall_1_0_1() { return cEPackageEPackageSTRINGTerminalRuleCall_1_0_1; }
		
		//('as' alias=ValidID)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'as'
		public Keyword getAsKeyword_2_0() { return cAsKeyword_2_0; }
		
		//alias=ValidID
		public Assignment getAliasAssignment_2_1() { return cAliasAssignment_2_1; }
		
		//ValidID
		public RuleCall getAliasValidIDParserRuleCall_2_1_0() { return cAliasValidIDParserRuleCall_2_1_0; }
	}
	public class AnnotationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Annotation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCommercialAtKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		////fragment Alias returns AbstractMetamodelDeclaration:
		////    'as' alias=ValidID
		////;
		//Annotation returns Annotation:
		//    '@' name = ID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'@' name = ID
		public Group getGroup() { return cGroup; }
		
		//'@'
		public Keyword getCommercialAtKeyword_0() { return cCommercialAtKeyword_0; }
		
		//name = ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}
	public class ParserRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ParserRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cFragmentAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final Keyword cFragmentFragmentKeyword_1_0_0_0 = (Keyword)cFragmentAssignment_1_0_0.eContents().get(0);
		private final RuleCall cRuleNameAndParamsParserRuleCall_1_0_1 = (RuleCall)cGroup_1_0.eContents().get(1);
		private final Alternatives cAlternatives_1_0_2 = (Alternatives)cGroup_1_0.eContents().get(2);
		private final Assignment cWildcardAssignment_1_0_2_0 = (Assignment)cAlternatives_1_0_2.eContents().get(0);
		private final Keyword cWildcardAsteriskKeyword_1_0_2_0_0 = (Keyword)cWildcardAssignment_1_0_2_0.eContents().get(0);
		private final Group cGroup_1_0_2_1 = (Group)cAlternatives_1_0_2.eContents().get(1);
		private final Keyword cReturnsKeyword_1_0_2_1_0 = (Keyword)cGroup_1_0_2_1.eContents().get(0);
		private final Assignment cTypeAssignment_1_0_2_1_1 = (Assignment)cGroup_1_0_2_1.eContents().get(1);
		private final RuleCall cTypeTypeRefParserRuleCall_1_0_2_1_1_0 = (RuleCall)cTypeAssignment_1_0_2_1_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final RuleCall cRuleNameAndParamsParserRuleCall_1_1_0 = (RuleCall)cGroup_1_1.eContents().get(0);
		private final Group cGroup_1_1_1 = (Group)cGroup_1_1.eContents().get(1);
		private final Keyword cReturnsKeyword_1_1_1_0 = (Keyword)cGroup_1_1_1.eContents().get(0);
		private final Assignment cTypeAssignment_1_1_1_1 = (Assignment)cGroup_1_1_1.eContents().get(1);
		private final RuleCall cTypeTypeRefParserRuleCall_1_1_1_1_0 = (RuleCall)cTypeAssignment_1_1_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cDefinesHiddenTokensAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final Keyword cDefinesHiddenTokensHiddenKeyword_2_0_0 = (Keyword)cDefinesHiddenTokensAssignment_2_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Assignment cHiddenTokensAssignment_2_2_0 = (Assignment)cGroup_2_2.eContents().get(0);
		private final CrossReference cHiddenTokensAbstractRuleCrossReference_2_2_0_0 = (CrossReference)cHiddenTokensAssignment_2_2_0.eContents().get(0);
		private final RuleCall cHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1 = (RuleCall)cHiddenTokensAbstractRuleCrossReference_2_2_0_0.eContents().get(1);
		private final Group cGroup_2_2_1 = (Group)cGroup_2_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_2_1_0 = (Keyword)cGroup_2_2_1.eContents().get(0);
		private final Assignment cHiddenTokensAssignment_2_2_1_1 = (Assignment)cGroup_2_2_1.eContents().get(1);
		private final CrossReference cHiddenTokensAbstractRuleCrossReference_2_2_1_1_0 = (CrossReference)cHiddenTokensAssignment_2_2_1_1.eContents().get(0);
		private final RuleCall cHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1 = (RuleCall)cHiddenTokensAbstractRuleCrossReference_2_2_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cAlternativesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cAlternativesAlternativesParserRuleCall_4_0 = (RuleCall)cAlternativesAssignment_4.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ParserRule :
		//    (annotations += Annotation)*
		//    (
		//      ^fragment?='fragment' RuleNameAndParams (wildcard?='*' | ('returns' type=TypeRef)?)
		//    | RuleNameAndParams ('returns' type=TypeRef)?
		//    )
		//    (definesHiddenTokens?='hidden' '(' (hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)? ')')? ':'
		//        alternatives=Alternatives
		//    ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(annotations += Annotation)*
		//(
		//  ^fragment?='fragment' RuleNameAndParams (wildcard?='*' | ('returns' type=TypeRef)?)
		//| RuleNameAndParams ('returns' type=TypeRef)?
		//)
		//(definesHiddenTokens?='hidden' '(' (hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)? ')')? ':'
		//    alternatives=Alternatives
		//';'
		public Group getGroup() { return cGroup; }
		
		//(annotations += Annotation)*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_0_0() { return cAnnotationsAnnotationParserRuleCall_0_0; }
		
		//(
		//  ^fragment?='fragment' RuleNameAndParams (wildcard?='*' | ('returns' type=TypeRef)?)
		//| RuleNameAndParams ('returns' type=TypeRef)?
		//)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//^fragment?='fragment' RuleNameAndParams (wildcard?='*' | ('returns' type=TypeRef)?)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//^fragment?='fragment'
		public Assignment getFragmentAssignment_1_0_0() { return cFragmentAssignment_1_0_0; }
		
		//'fragment'
		public Keyword getFragmentFragmentKeyword_1_0_0_0() { return cFragmentFragmentKeyword_1_0_0_0; }
		
		//RuleNameAndParams
		public RuleCall getRuleNameAndParamsParserRuleCall_1_0_1() { return cRuleNameAndParamsParserRuleCall_1_0_1; }
		
		//(wildcard?='*' | ('returns' type=TypeRef)?)
		public Alternatives getAlternatives_1_0_2() { return cAlternatives_1_0_2; }
		
		//wildcard?='*'
		public Assignment getWildcardAssignment_1_0_2_0() { return cWildcardAssignment_1_0_2_0; }
		
		//'*'
		public Keyword getWildcardAsteriskKeyword_1_0_2_0_0() { return cWildcardAsteriskKeyword_1_0_2_0_0; }
		
		//('returns' type=TypeRef)?
		public Group getGroup_1_0_2_1() { return cGroup_1_0_2_1; }
		
		//'returns'
		public Keyword getReturnsKeyword_1_0_2_1_0() { return cReturnsKeyword_1_0_2_1_0; }
		
		//type=TypeRef
		public Assignment getTypeAssignment_1_0_2_1_1() { return cTypeAssignment_1_0_2_1_1; }
		
		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_1_0_2_1_1_0() { return cTypeTypeRefParserRuleCall_1_0_2_1_1_0; }
		
		//RuleNameAndParams ('returns' type=TypeRef)?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//RuleNameAndParams
		public RuleCall getRuleNameAndParamsParserRuleCall_1_1_0() { return cRuleNameAndParamsParserRuleCall_1_1_0; }
		
		//('returns' type=TypeRef)?
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }
		
		//'returns'
		public Keyword getReturnsKeyword_1_1_1_0() { return cReturnsKeyword_1_1_1_0; }
		
		//type=TypeRef
		public Assignment getTypeAssignment_1_1_1_1() { return cTypeAssignment_1_1_1_1; }
		
		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_1_1_1_1_0() { return cTypeTypeRefParserRuleCall_1_1_1_1_0; }
		
		//(definesHiddenTokens?='hidden' '(' (hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)? ')')?
		public Group getGroup_2() { return cGroup_2; }
		
		//definesHiddenTokens?='hidden'
		public Assignment getDefinesHiddenTokensAssignment_2_0() { return cDefinesHiddenTokensAssignment_2_0; }
		
		//'hidden'
		public Keyword getDefinesHiddenTokensHiddenKeyword_2_0_0() { return cDefinesHiddenTokensHiddenKeyword_2_0_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_1() { return cLeftParenthesisKeyword_2_1; }
		
		//(hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)?
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//hiddenTokens+=[AbstractRule|RuleID]
		public Assignment getHiddenTokensAssignment_2_2_0() { return cHiddenTokensAssignment_2_2_0; }
		
		//[AbstractRule|RuleID]
		public CrossReference getHiddenTokensAbstractRuleCrossReference_2_2_0_0() { return cHiddenTokensAbstractRuleCrossReference_2_2_0_0; }
		
		//RuleID
		public RuleCall getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1() { return cHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1; }
		
		//(',' hiddenTokens+=[AbstractRule|RuleID])*
		public Group getGroup_2_2_1() { return cGroup_2_2_1; }
		
		//','
		public Keyword getCommaKeyword_2_2_1_0() { return cCommaKeyword_2_2_1_0; }
		
		//hiddenTokens+=[AbstractRule|RuleID]
		public Assignment getHiddenTokensAssignment_2_2_1_1() { return cHiddenTokensAssignment_2_2_1_1; }
		
		//[AbstractRule|RuleID]
		public CrossReference getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0() { return cHiddenTokensAbstractRuleCrossReference_2_2_1_1_0; }
		
		//RuleID
		public RuleCall getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1() { return cHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_3() { return cRightParenthesisKeyword_2_3; }
		
		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }
		
		//alternatives=Alternatives
		public Assignment getAlternativesAssignment_4() { return cAlternativesAssignment_4; }
		
		//Alternatives
		public RuleCall getAlternativesAlternativesParserRuleCall_4_0() { return cAlternativesAlternativesParserRuleCall_4_0; }
		
		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}
	public class RuleNameAndParamsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.RuleNameAndParams");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameValidIDParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Assignment cParametersAssignment_1_1_0 = (Assignment)cGroup_1_1.eContents().get(0);
		private final RuleCall cParametersParameterParserRuleCall_1_1_0_0 = (RuleCall)cParametersAssignment_1_1_0.eContents().get(0);
		private final Group cGroup_1_1_1 = (Group)cGroup_1_1.eContents().get(1);
		private final Keyword cCommaKeyword_1_1_1_0 = (Keyword)cGroup_1_1_1.eContents().get(0);
		private final Assignment cParametersAssignment_1_1_1_1 = (Assignment)cGroup_1_1_1.eContents().get(1);
		private final RuleCall cParametersParameterParserRuleCall_1_1_1_1_0 = (RuleCall)cParametersAssignment_1_1_1_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		
		//fragment RuleNameAndParams returns ParserRule:
		//    name=ValidID ('<' (parameters+=Parameter (',' parameters+=Parameter)*)? '>')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ValidID ('<' (parameters+=Parameter (',' parameters+=Parameter)*)? '>')?
		public Group getGroup() { return cGroup; }
		
		//name=ValidID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_0_0() { return cNameValidIDParserRuleCall_0_0; }
		
		//('<' (parameters+=Parameter (',' parameters+=Parameter)*)? '>')?
		public Group getGroup_1() { return cGroup_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }
		
		//(parameters+=Parameter (',' parameters+=Parameter)*)?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//parameters+=Parameter
		public Assignment getParametersAssignment_1_1_0() { return cParametersAssignment_1_1_0; }
		
		//Parameter
		public RuleCall getParametersParameterParserRuleCall_1_1_0_0() { return cParametersParameterParserRuleCall_1_1_0_0; }
		
		//(',' parameters+=Parameter)*
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }
		
		//','
		public Keyword getCommaKeyword_1_1_1_0() { return cCommaKeyword_1_1_1_0; }
		
		//parameters+=Parameter
		public Assignment getParametersAssignment_1_1_1_1() { return cParametersAssignment_1_1_1_1; }
		
		//Parameter
		public RuleCall getParametersParameterParserRuleCall_1_1_1_1_0() { return cParametersParameterParserRuleCall_1_1_1_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_2() { return cGreaterThanSignKeyword_1_2; }
	}
	public class ParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Parameter");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//Parameter:
		//    name=ID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class TypeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.TypeRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cMetamodelAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final CrossReference cMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0 = (CrossReference)cMetamodelAssignment_0_0.eContents().get(0);
		private final RuleCall cMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1 = (RuleCall)cMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0.eContents().get(1);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cClassifierAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cClassifierEClassifierCrossReference_1_0 = (CrossReference)cClassifierAssignment_1.eContents().get(0);
		private final RuleCall cClassifierEClassifierIDTerminalRuleCall_1_0_1 = (RuleCall)cClassifierEClassifierCrossReference_1_0.eContents().get(1);
		
		//TypeRef :
		//    (metamodel=[AbstractMetamodelDeclaration] '::')? classifier=[ecore::EClassifier]
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(metamodel=[AbstractMetamodelDeclaration] '::')? classifier=[ecore::EClassifier]
		public Group getGroup() { return cGroup; }
		
		//(metamodel=[AbstractMetamodelDeclaration] '::')?
		public Group getGroup_0() { return cGroup_0; }
		
		//metamodel=[AbstractMetamodelDeclaration]
		public Assignment getMetamodelAssignment_0_0() { return cMetamodelAssignment_0_0; }
		
		//[AbstractMetamodelDeclaration]
		public CrossReference getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0() { return cMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0; }
		
		//ID
		public RuleCall getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1() { return cMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1; }
		
		//'::'
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }
		
		//classifier=[ecore::EClassifier]
		public Assignment getClassifierAssignment_1() { return cClassifierAssignment_1; }
		
		//[ecore::EClassifier]
		public CrossReference getClassifierEClassifierCrossReference_1_0() { return cClassifierEClassifierCrossReference_1_0; }
		
		//ID
		public RuleCall getClassifierEClassifierIDTerminalRuleCall_1_0_1() { return cClassifierEClassifierIDTerminalRuleCall_1_0_1; }
	}
	public class AlternativesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Alternatives");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cConditionalBranchParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAlternativesElementsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cVerticalLineKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cElementsConditionalBranchParserRuleCall_1_1_1_0 = (RuleCall)cElementsAssignment_1_1_1.eContents().get(0);
		
		//Alternatives returns AbstractElement:
		//    ConditionalBranch ({Alternatives.elements+=current} ('|' elements+=ConditionalBranch)+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ConditionalBranch ({Alternatives.elements+=current} ('|' elements+=ConditionalBranch)+)?
		public Group getGroup() { return cGroup; }
		
		//ConditionalBranch
		public RuleCall getConditionalBranchParserRuleCall_0() { return cConditionalBranchParserRuleCall_0; }
		
		//({Alternatives.elements+=current} ('|' elements+=ConditionalBranch)+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{Alternatives.elements+=current}
		public Action getAlternativesElementsAction_1_0() { return cAlternativesElementsAction_1_0; }
		
		//('|' elements+=ConditionalBranch)+
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'|'
		public Keyword getVerticalLineKeyword_1_1_0() { return cVerticalLineKeyword_1_1_0; }
		
		//elements+=ConditionalBranch
		public Assignment getElementsAssignment_1_1_1() { return cElementsAssignment_1_1_1; }
		
		//ConditionalBranch
		public RuleCall getElementsConditionalBranchParserRuleCall_1_1_1_0() { return cElementsConditionalBranchParserRuleCall_1_1_1_0; }
	}
	public class ConditionalBranchElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ConditionalBranch");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cUnorderedGroupParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cGroupAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cLessThanSignKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cGuardConditionAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cGuardConditionDisjunctionParserRuleCall_1_2_0 = (RuleCall)cGuardConditionAssignment_1_2.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Assignment cElementsAssignment_1_4 = (Assignment)cGroup_1.eContents().get(4);
		private final RuleCall cElementsAbstractTokenParserRuleCall_1_4_0 = (RuleCall)cElementsAssignment_1_4.eContents().get(0);
		
		//ConditionalBranch returns AbstractElement:
		//      UnorderedGroup
		//    | {Group} '<' guardCondition=Disjunction '>' (elements+=AbstractToken)+
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//  UnorderedGroup
		//| {Group} '<' guardCondition=Disjunction '>' (elements+=AbstractToken)+
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//UnorderedGroup
		public RuleCall getUnorderedGroupParserRuleCall_0() { return cUnorderedGroupParserRuleCall_0; }
		
		//{Group} '<' guardCondition=Disjunction '>' (elements+=AbstractToken)+
		public Group getGroup_1() { return cGroup_1; }
		
		//{Group}
		public Action getGroupAction_1_0() { return cGroupAction_1_0; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1_1() { return cLessThanSignKeyword_1_1; }
		
		//guardCondition=Disjunction
		public Assignment getGuardConditionAssignment_1_2() { return cGuardConditionAssignment_1_2; }
		
		//Disjunction
		public RuleCall getGuardConditionDisjunctionParserRuleCall_1_2_0() { return cGuardConditionDisjunctionParserRuleCall_1_2_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_3() { return cGreaterThanSignKeyword_1_3; }
		
		//(elements+=AbstractToken)+
		public Assignment getElementsAssignment_1_4() { return cElementsAssignment_1_4; }
		
		//AbstractToken
		public RuleCall getElementsAbstractTokenParserRuleCall_1_4_0() { return cElementsAbstractTokenParserRuleCall_1_4_0; }
	}
	public class UnorderedGroupElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.UnorderedGroup");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cGroupParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cUnorderedGroupElementsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cAmpersandKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cElementsGroupParserRuleCall_1_1_1_0 = (RuleCall)cElementsAssignment_1_1_1.eContents().get(0);
		
		//UnorderedGroup returns AbstractElement:
		//    Group ({UnorderedGroup.elements+=current} ('&' elements+=Group)+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Group ({UnorderedGroup.elements+=current} ('&' elements+=Group)+)?
		public Group getGroup() { return cGroup; }
		
		//Group
		public RuleCall getGroupParserRuleCall_0() { return cGroupParserRuleCall_0; }
		
		//({UnorderedGroup.elements+=current} ('&' elements+=Group)+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{UnorderedGroup.elements+=current}
		public Action getUnorderedGroupElementsAction_1_0() { return cUnorderedGroupElementsAction_1_0; }
		
		//('&' elements+=Group)+
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'&'
		public Keyword getAmpersandKeyword_1_1_0() { return cAmpersandKeyword_1_1_0; }
		
		//elements+=Group
		public Assignment getElementsAssignment_1_1_1() { return cElementsAssignment_1_1_1; }
		
		//Group
		public RuleCall getElementsGroupParserRuleCall_1_1_1_0() { return cElementsGroupParserRuleCall_1_1_1_0; }
	}
	public class GroupElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Group");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAbstractTokenParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cGroupElementsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cElementsAbstractTokenParserRuleCall_1_1_0 = (RuleCall)cElementsAssignment_1_1.eContents().get(0);
		
		//Group returns AbstractElement:
		//    AbstractToken ({Group.elements+=current} (elements+=AbstractToken)+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//AbstractToken ({Group.elements+=current} (elements+=AbstractToken)+)?
		public Group getGroup() { return cGroup; }
		
		//AbstractToken
		public RuleCall getAbstractTokenParserRuleCall_0() { return cAbstractTokenParserRuleCall_0; }
		
		//({Group.elements+=current} (elements+=AbstractToken)+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{Group.elements+=current}
		public Action getGroupElementsAction_1_0() { return cGroupElementsAction_1_0; }
		
		//(elements+=AbstractToken)+
		public Assignment getElementsAssignment_1_1() { return cElementsAssignment_1_1; }
		
		//AbstractToken
		public RuleCall getElementsAbstractTokenParserRuleCall_1_1_0() { return cElementsAbstractTokenParserRuleCall_1_1_0; }
	}
	public class AbstractTokenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.AbstractToken");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAbstractTokenWithCardinalityParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cActionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AbstractToken returns AbstractElement:
		//    AbstractTokenWithCardinality |
		//    Action
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//AbstractTokenWithCardinality |
		//Action
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//AbstractTokenWithCardinality
		public RuleCall getAbstractTokenWithCardinalityParserRuleCall_0() { return cAbstractTokenWithCardinalityParserRuleCall_0; }
		
		//Action
		public RuleCall getActionParserRuleCall_1() { return cActionParserRuleCall_1; }
	}
	public class AbstractTokenWithCardinalityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.AbstractTokenWithCardinality");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cAssignmentParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cAbstractTerminalParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Assignment cCardinalityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cCardinalityAlternatives_1_0 = (Alternatives)cCardinalityAssignment_1.eContents().get(0);
		private final Keyword cCardinalityQuestionMarkKeyword_1_0_0 = (Keyword)cCardinalityAlternatives_1_0.eContents().get(0);
		private final Keyword cCardinalityAsteriskKeyword_1_0_1 = (Keyword)cCardinalityAlternatives_1_0.eContents().get(1);
		private final Keyword cCardinalityPlusSignKeyword_1_0_2 = (Keyword)cCardinalityAlternatives_1_0.eContents().get(2);
		
		///* SuppressWarnings[potentialOverride]: Handled in CardinalityAwareEcoreFactory */
		//AbstractTokenWithCardinality returns AbstractElement:
		//    (Assignment | AbstractTerminal) cardinality=('?'|'*'|'+')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(Assignment | AbstractTerminal) cardinality=('?'|'*'|'+')?
		public Group getGroup() { return cGroup; }
		
		//(Assignment | AbstractTerminal)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//Assignment
		public RuleCall getAssignmentParserRuleCall_0_0() { return cAssignmentParserRuleCall_0_0; }
		
		//AbstractTerminal
		public RuleCall getAbstractTerminalParserRuleCall_0_1() { return cAbstractTerminalParserRuleCall_0_1; }
		
		//cardinality=('?'|'*'|'+')?
		public Assignment getCardinalityAssignment_1() { return cCardinalityAssignment_1; }
		
		//('?'|'*'|'+')
		public Alternatives getCardinalityAlternatives_1_0() { return cCardinalityAlternatives_1_0; }
		
		//'?'
		public Keyword getCardinalityQuestionMarkKeyword_1_0_0() { return cCardinalityQuestionMarkKeyword_1_0_0; }
		
		//'*'
		public Keyword getCardinalityAsteriskKeyword_1_0_1() { return cCardinalityAsteriskKeyword_1_0_1; }
		
		//'+'
		public Keyword getCardinalityPlusSignKeyword_1_0_2() { return cCardinalityPlusSignKeyword_1_0_2; }
	}
	public class ActionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Action");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeTypeRefParserRuleCall_1_0 = (RuleCall)cTypeAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cFeatureAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cFeatureValidIDParserRuleCall_2_1_0 = (RuleCall)cFeatureAssignment_2_1.eContents().get(0);
		private final Assignment cOperatorAssignment_2_2 = (Assignment)cGroup_2.eContents().get(2);
		private final Alternatives cOperatorAlternatives_2_2_0 = (Alternatives)cOperatorAssignment_2_2.eContents().get(0);
		private final Keyword cOperatorEqualsSignKeyword_2_2_0_0 = (Keyword)cOperatorAlternatives_2_2_0.eContents().get(0);
		private final Keyword cOperatorPlusSignEqualsSignKeyword_2_2_0_1 = (Keyword)cOperatorAlternatives_2_2_0.eContents().get(1);
		private final Keyword cCurrentKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Action returns Action:
		//    '{' type=TypeRef ('.' feature=ValidID operator=('='|'+=') 'current')? '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'{' type=TypeRef ('.' feature=ValidID operator=('='|'+=') 'current')? '}'
		public Group getGroup() { return cGroup; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }
		
		//type=TypeRef
		public Assignment getTypeAssignment_1() { return cTypeAssignment_1; }
		
		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_1_0() { return cTypeTypeRefParserRuleCall_1_0; }
		
		//('.' feature=ValidID operator=('='|'+=') 'current')?
		public Group getGroup_2() { return cGroup_2; }
		
		//'.'
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }
		
		//feature=ValidID
		public Assignment getFeatureAssignment_2_1() { return cFeatureAssignment_2_1; }
		
		//ValidID
		public RuleCall getFeatureValidIDParserRuleCall_2_1_0() { return cFeatureValidIDParserRuleCall_2_1_0; }
		
		//operator=('='|'+=')
		public Assignment getOperatorAssignment_2_2() { return cOperatorAssignment_2_2; }
		
		//('='|'+=')
		public Alternatives getOperatorAlternatives_2_2_0() { return cOperatorAlternatives_2_2_0; }
		
		//'='
		public Keyword getOperatorEqualsSignKeyword_2_2_0_0() { return cOperatorEqualsSignKeyword_2_2_0_0; }
		
		//'+='
		public Keyword getOperatorPlusSignEqualsSignKeyword_2_2_0_1() { return cOperatorPlusSignEqualsSignKeyword_2_2_0_1; }
		
		//'current'
		public Keyword getCurrentKeyword_2_3() { return cCurrentKeyword_2_3; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}
	public class AbstractTerminalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.AbstractTerminal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cKeywordParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRuleCallParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cParenthesizedElementParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPredicatedKeywordParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cPredicatedRuleCallParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cPredicatedGroupParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//AbstractTerminal returns AbstractElement:
		//    Keyword |
		//    RuleCall |
		//    ParenthesizedElement |
		//    // Keyword and RuleCall are used inside of Assignable terminal
		//    // As we do not want to be able to write name==>ID
		//    // the rules for Keyword and RuleCall have been copied
		//    PredicatedKeyword |
		//    PredicatedRuleCall |
		//    // We have to make this one explicit since the ParenthesizedElement does not
		//    // create an object but we have to set the predicated flag
		//    PredicatedGroup
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Keyword |
		//RuleCall |
		//ParenthesizedElement |
		//// Keyword and RuleCall are used inside of Assignable terminal
		//// As we do not want to be able to write name==>ID
		//// the rules for Keyword and RuleCall have been copied
		//PredicatedKeyword |
		//PredicatedRuleCall |
		//// We have to make this one explicit since the ParenthesizedElement does not
		//// create an object but we have to set the predicated flag
		//PredicatedGroup
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Keyword
		public RuleCall getKeywordParserRuleCall_0() { return cKeywordParserRuleCall_0; }
		
		//RuleCall
		public RuleCall getRuleCallParserRuleCall_1() { return cRuleCallParserRuleCall_1; }
		
		//ParenthesizedElement
		public RuleCall getParenthesizedElementParserRuleCall_2() { return cParenthesizedElementParserRuleCall_2; }
		
		//// Keyword and RuleCall are used inside of Assignable terminal
		//// As we do not want to be able to write name==>ID
		//// the rules for Keyword and RuleCall have been copied
		//PredicatedKeyword
		public RuleCall getPredicatedKeywordParserRuleCall_3() { return cPredicatedKeywordParserRuleCall_3; }
		
		//PredicatedRuleCall
		public RuleCall getPredicatedRuleCallParserRuleCall_4() { return cPredicatedRuleCallParserRuleCall_4; }
		
		//// We have to make this one explicit since the ParenthesizedElement does not
		//// create an object but we have to set the predicated flag
		//PredicatedGroup
		public RuleCall getPredicatedGroupParserRuleCall_5() { return cPredicatedGroupParserRuleCall_5; }
	}
	public class KeywordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Keyword");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//Keyword :
		//    value=STRING
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=STRING
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_0() { return cValueSTRINGTerminalRuleCall_0; }
	}
	public class RuleCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.RuleCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cRuleAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cRuleAbstractRuleCrossReference_0_0 = (CrossReference)cRuleAssignment_0.eContents().get(0);
		private final RuleCall cRuleAbstractRuleRuleIDParserRuleCall_0_0_1 = (RuleCall)cRuleAbstractRuleCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cArgumentsNamedArgumentParserRuleCall_1_1_0 = (RuleCall)cArgumentsAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cArgumentsNamedArgumentParserRuleCall_1_2_1_0 = (RuleCall)cArgumentsAssignment_1_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		
		//RuleCall :
		//    rule=[AbstractRule|RuleID] ('<' arguments+=NamedArgument (',' arguments+=NamedArgument)* '>')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//rule=[AbstractRule|RuleID] ('<' arguments+=NamedArgument (',' arguments+=NamedArgument)* '>')?
		public Group getGroup() { return cGroup; }
		
		//rule=[AbstractRule|RuleID]
		public Assignment getRuleAssignment_0() { return cRuleAssignment_0; }
		
		//[AbstractRule|RuleID]
		public CrossReference getRuleAbstractRuleCrossReference_0_0() { return cRuleAbstractRuleCrossReference_0_0; }
		
		//RuleID
		public RuleCall getRuleAbstractRuleRuleIDParserRuleCall_0_0_1() { return cRuleAbstractRuleRuleIDParserRuleCall_0_0_1; }
		
		//('<' arguments+=NamedArgument (',' arguments+=NamedArgument)* '>')?
		public Group getGroup_1() { return cGroup_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }
		
		//arguments+=NamedArgument
		public Assignment getArgumentsAssignment_1_1() { return cArgumentsAssignment_1_1; }
		
		//NamedArgument
		public RuleCall getArgumentsNamedArgumentParserRuleCall_1_1_0() { return cArgumentsNamedArgumentParserRuleCall_1_1_0; }
		
		//(',' arguments+=NamedArgument)*
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//','
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }
		
		//arguments+=NamedArgument
		public Assignment getArgumentsAssignment_1_2_1() { return cArgumentsAssignment_1_2_1; }
		
		//NamedArgument
		public RuleCall getArgumentsNamedArgumentParserRuleCall_1_2_1_0() { return cArgumentsNamedArgumentParserRuleCall_1_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_3() { return cGreaterThanSignKeyword_1_3; }
	}
	public class NamedArgumentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.NamedArgument");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cParameterAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final CrossReference cParameterParameterCrossReference_0_0_0 = (CrossReference)cParameterAssignment_0_0.eContents().get(0);
		private final RuleCall cParameterParameterIDTerminalRuleCall_0_0_0_1 = (RuleCall)cParameterParameterCrossReference_0_0_0.eContents().get(1);
		private final Assignment cCalledByNameAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final Keyword cCalledByNameEqualsSignKeyword_0_1_0 = (Keyword)cCalledByNameAssignment_0_1.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueDisjunctionParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//NamedArgument:
		//    ( parameter=[Parameter|ID] calledByName?= '=')?
		//    ( value=Disjunction )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//( parameter=[Parameter|ID] calledByName?= '=')?
		//( value=Disjunction )
		public Group getGroup() { return cGroup; }
		
		//( parameter=[Parameter|ID] calledByName?= '=')?
		public Group getGroup_0() { return cGroup_0; }
		
		//parameter=[Parameter|ID]
		public Assignment getParameterAssignment_0_0() { return cParameterAssignment_0_0; }
		
		//[Parameter|ID]
		public CrossReference getParameterParameterCrossReference_0_0_0() { return cParameterParameterCrossReference_0_0_0; }
		
		//ID
		public RuleCall getParameterParameterIDTerminalRuleCall_0_0_0_1() { return cParameterParameterIDTerminalRuleCall_0_0_0_1; }
		
		//calledByName?= '='
		public Assignment getCalledByNameAssignment_0_1() { return cCalledByNameAssignment_0_1; }
		
		//'='
		public Keyword getCalledByNameEqualsSignKeyword_0_1_0() { return cCalledByNameEqualsSignKeyword_0_1_0; }
		
		//( value=Disjunction )
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//Disjunction
		public RuleCall getValueDisjunctionParserRuleCall_1_0() { return cValueDisjunctionParserRuleCall_1_0; }
	}
	public class LiteralConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.LiteralCondition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralConditionAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cTrueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cTrueTrueKeyword_1_0_0 = (Keyword)cTrueAssignment_1_0.eContents().get(0);
		private final Keyword cFalseKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		
		//LiteralCondition:
		//    {LiteralCondition} (true?='true' | 'false')
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralCondition} (true?='true' | 'false')
		public Group getGroup() { return cGroup; }
		
		//{LiteralCondition}
		public Action getLiteralConditionAction_0() { return cLiteralConditionAction_0; }
		
		//(true?='true' | 'false')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//true?='true'
		public Assignment getTrueAssignment_1_0() { return cTrueAssignment_1_0; }
		
		//'true'
		public Keyword getTrueTrueKeyword_1_0_0() { return cTrueTrueKeyword_1_0_0; }
		
		//'false'
		public Keyword getFalseKeyword_1_1() { return cFalseKeyword_1_1; }
	}
	public class DisjunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Disjunction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cConjunctionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cDisjunctionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cVerticalLineKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightConjunctionParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Disjunction returns Condition:
		//    Conjunction ({Disjunction.left=current} '|' right=Conjunction)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Conjunction ({Disjunction.left=current} '|' right=Conjunction)*
		public Group getGroup() { return cGroup; }
		
		//Conjunction
		public RuleCall getConjunctionParserRuleCall_0() { return cConjunctionParserRuleCall_0; }
		
		//({Disjunction.left=current} '|' right=Conjunction)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{Disjunction.left=current}
		public Action getDisjunctionLeftAction_1_0() { return cDisjunctionLeftAction_1_0; }
		
		//'|'
		public Keyword getVerticalLineKeyword_1_1() { return cVerticalLineKeyword_1_1; }
		
		//right=Conjunction
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//Conjunction
		public RuleCall getRightConjunctionParserRuleCall_1_2_0() { return cRightConjunctionParserRuleCall_1_2_0; }
	}
	public class ConjunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Conjunction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cNegationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cConjunctionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cAmpersandKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightNegationParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Conjunction returns Condition:
		//    Negation ({Conjunction.left=current} '&' right=Negation)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Negation ({Conjunction.left=current} '&' right=Negation)*
		public Group getGroup() { return cGroup; }
		
		//Negation
		public RuleCall getNegationParserRuleCall_0() { return cNegationParserRuleCall_0; }
		
		//({Conjunction.left=current} '&' right=Negation)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{Conjunction.left=current}
		public Action getConjunctionLeftAction_1_0() { return cConjunctionLeftAction_1_0; }
		
		//'&'
		public Keyword getAmpersandKeyword_1_1() { return cAmpersandKeyword_1_1; }
		
		//right=Negation
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//Negation
		public RuleCall getRightNegationParserRuleCall_1_2_0() { return cRightNegationParserRuleCall_1_2_0; }
	}
	public class NegationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Negation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAtomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cNegationAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cExclamationMarkKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cValueAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cValueNegationParserRuleCall_1_2_0 = (RuleCall)cValueAssignment_1_2.eContents().get(0);
		
		//Negation returns Condition:
		//    Atom | {Negation} '!' value=Negation
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Atom | {Negation} '!' value=Negation
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Atom
		public RuleCall getAtomParserRuleCall_0() { return cAtomParserRuleCall_0; }
		
		//{Negation} '!' value=Negation
		public Group getGroup_1() { return cGroup_1; }
		
		//{Negation}
		public Action getNegationAction_1_0() { return cNegationAction_1_0; }
		
		//'!'
		public Keyword getExclamationMarkKeyword_1_1() { return cExclamationMarkKeyword_1_1; }
		
		//value=Negation
		public Assignment getValueAssignment_1_2() { return cValueAssignment_1_2; }
		
		//Negation
		public RuleCall getValueNegationParserRuleCall_1_2_0() { return cValueNegationParserRuleCall_1_2_0; }
	}
	public class AtomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Atom");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cParameterReferenceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cParenthesizedConditionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLiteralConditionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Atom returns Condition:
		//    ParameterReference | ParenthesizedCondition | LiteralCondition
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ParameterReference | ParenthesizedCondition | LiteralCondition
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ParameterReference
		public RuleCall getParameterReferenceParserRuleCall_0() { return cParameterReferenceParserRuleCall_0; }
		
		//ParenthesizedCondition
		public RuleCall getParenthesizedConditionParserRuleCall_1() { return cParenthesizedConditionParserRuleCall_1; }
		
		//LiteralCondition
		public RuleCall getLiteralConditionParserRuleCall_2() { return cLiteralConditionParserRuleCall_2; }
	}
	public class ParenthesizedConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ParenthesizedCondition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cDisjunctionParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//ParenthesizedCondition returns Condition:
		//    '(' Disjunction ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'(' Disjunction ')'
		public Group getGroup() { return cGroup; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }
		
		//Disjunction
		public RuleCall getDisjunctionParserRuleCall_1() { return cDisjunctionParserRuleCall_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}
	public class ParameterReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ParameterReference");
		private final Assignment cParameterAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cParameterParameterCrossReference_0 = (CrossReference)cParameterAssignment.eContents().get(0);
		private final RuleCall cParameterParameterIDTerminalRuleCall_0_1 = (RuleCall)cParameterParameterCrossReference_0.eContents().get(1);
		
		//ParameterReference:
		//    parameter=[Parameter|ID]
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//parameter=[Parameter|ID]
		public Assignment getParameterAssignment() { return cParameterAssignment; }
		
		//[Parameter|ID]
		public CrossReference getParameterParameterCrossReference_0() { return cParameterParameterCrossReference_0; }
		
		//ID
		public RuleCall getParameterParameterIDTerminalRuleCall_0_1() { return cParameterParameterIDTerminalRuleCall_0_1; }
	}
	public class TerminalRuleCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.TerminalRuleCall");
		private final Assignment cRuleAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cRuleAbstractRuleCrossReference_0 = (CrossReference)cRuleAssignment.eContents().get(0);
		private final RuleCall cRuleAbstractRuleRuleIDParserRuleCall_0_1 = (RuleCall)cRuleAbstractRuleCrossReference_0.eContents().get(1);
		
		//TerminalRuleCall returns RuleCall:
		//    rule=[AbstractRule|RuleID]
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//rule=[AbstractRule|RuleID]
		public Assignment getRuleAssignment() { return cRuleAssignment; }
		
		//[AbstractRule|RuleID]
		public CrossReference getRuleAbstractRuleCrossReference_0() { return cRuleAbstractRuleCrossReference_0; }
		
		//RuleID
		public RuleCall getRuleAbstractRuleRuleIDParserRuleCall_0_1() { return cRuleAbstractRuleRuleIDParserRuleCall_0_1; }
	}
	public class RuleIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.RuleID");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cValidIDParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//RuleID returns ecore::EString:
		//    ValidID ('::' ValidID)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ValidID ('::' ValidID)*
		public Group getGroup() { return cGroup; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//('::' ValidID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_1_1() { return cValidIDParserRuleCall_1_1; }
	}
	public class ValidIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ValidID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cTrueKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cFalseKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		
		//ValidID returns ecore::EString:
		//    ID | 'true' | 'false'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ID | 'true' | 'false'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//'true'
		public Keyword getTrueKeyword_1() { return cTrueKeyword_1; }
		
		//'false'
		public Keyword getFalseKeyword_2() { return cFalseKeyword_2; }
	}
	public class PredicatedKeywordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.PredicatedKeyword");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cPredicatedAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cPredicatedEqualsSignGreaterThanSignKeyword_0_0_0 = (Keyword)cPredicatedAssignment_0_0.eContents().get(0);
		private final Assignment cFirstSetPredicatedAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0 = (Keyword)cFirstSetPredicatedAssignment_0_1.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//PredicatedKeyword returns Keyword:
		//    (predicated?='=>' | firstSetPredicated?='->') value=STRING
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(predicated?='=>' | firstSetPredicated?='->') value=STRING
		public Group getGroup() { return cGroup; }
		
		//(predicated?='=>' | firstSetPredicated?='->')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//predicated?='=>'
		public Assignment getPredicatedAssignment_0_0() { return cPredicatedAssignment_0_0; }
		
		//'=>'
		public Keyword getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0() { return cPredicatedEqualsSignGreaterThanSignKeyword_0_0_0; }
		
		//firstSetPredicated?='->'
		public Assignment getFirstSetPredicatedAssignment_0_1() { return cFirstSetPredicatedAssignment_0_1; }
		
		//'->'
		public Keyword getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0() { return cFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0; }
		
		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}
	public class PredicatedRuleCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.PredicatedRuleCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cPredicatedAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cPredicatedEqualsSignGreaterThanSignKeyword_0_0_0 = (Keyword)cPredicatedAssignment_0_0.eContents().get(0);
		private final Assignment cFirstSetPredicatedAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0 = (Keyword)cFirstSetPredicatedAssignment_0_1.eContents().get(0);
		private final Assignment cRuleAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRuleAbstractRuleCrossReference_1_0 = (CrossReference)cRuleAssignment_1.eContents().get(0);
		private final RuleCall cRuleAbstractRuleRuleIDParserRuleCall_1_0_1 = (RuleCall)cRuleAbstractRuleCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLessThanSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cArgumentsNamedArgumentParserRuleCall_2_1_0 = (RuleCall)cArgumentsAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cArgumentsNamedArgumentParserRuleCall_2_2_1_0 = (RuleCall)cArgumentsAssignment_2_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		
		//PredicatedRuleCall returns RuleCall:
		//    (predicated?='=>' | firstSetPredicated?='->') rule=[AbstractRule|RuleID] ('<' arguments+=NamedArgument (',' arguments+=NamedArgument)* '>')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(predicated?='=>' | firstSetPredicated?='->') rule=[AbstractRule|RuleID] ('<' arguments+=NamedArgument (',' arguments+=NamedArgument)* '>')?
		public Group getGroup() { return cGroup; }
		
		//(predicated?='=>' | firstSetPredicated?='->')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//predicated?='=>'
		public Assignment getPredicatedAssignment_0_0() { return cPredicatedAssignment_0_0; }
		
		//'=>'
		public Keyword getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0() { return cPredicatedEqualsSignGreaterThanSignKeyword_0_0_0; }
		
		//firstSetPredicated?='->'
		public Assignment getFirstSetPredicatedAssignment_0_1() { return cFirstSetPredicatedAssignment_0_1; }
		
		//'->'
		public Keyword getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0() { return cFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0; }
		
		//rule=[AbstractRule|RuleID]
		public Assignment getRuleAssignment_1() { return cRuleAssignment_1; }
		
		//[AbstractRule|RuleID]
		public CrossReference getRuleAbstractRuleCrossReference_1_0() { return cRuleAbstractRuleCrossReference_1_0; }
		
		//RuleID
		public RuleCall getRuleAbstractRuleRuleIDParserRuleCall_1_0_1() { return cRuleAbstractRuleRuleIDParserRuleCall_1_0_1; }
		
		//('<' arguments+=NamedArgument (',' arguments+=NamedArgument)* '>')?
		public Group getGroup_2() { return cGroup_2; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_0() { return cLessThanSignKeyword_2_0; }
		
		//arguments+=NamedArgument
		public Assignment getArgumentsAssignment_2_1() { return cArgumentsAssignment_2_1; }
		
		//NamedArgument
		public RuleCall getArgumentsNamedArgumentParserRuleCall_2_1_0() { return cArgumentsNamedArgumentParserRuleCall_2_1_0; }
		
		//(',' arguments+=NamedArgument)*
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//','
		public Keyword getCommaKeyword_2_2_0() { return cCommaKeyword_2_2_0; }
		
		//arguments+=NamedArgument
		public Assignment getArgumentsAssignment_2_2_1() { return cArgumentsAssignment_2_2_1; }
		
		//NamedArgument
		public RuleCall getArgumentsNamedArgumentParserRuleCall_2_2_1_0() { return cArgumentsNamedArgumentParserRuleCall_2_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_3() { return cGreaterThanSignKeyword_2_3; }
	}
	public class AssignmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Assignment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cPredicatedAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cPredicatedEqualsSignGreaterThanSignKeyword_0_0_0 = (Keyword)cPredicatedAssignment_0_0.eContents().get(0);
		private final Assignment cFirstSetPredicatedAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0 = (Keyword)cFirstSetPredicatedAssignment_0_1.eContents().get(0);
		private final Assignment cFeatureAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFeatureValidIDParserRuleCall_1_0 = (RuleCall)cFeatureAssignment_1.eContents().get(0);
		private final Assignment cOperatorAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cOperatorAlternatives_2_0 = (Alternatives)cOperatorAssignment_2.eContents().get(0);
		private final Keyword cOperatorPlusSignEqualsSignKeyword_2_0_0 = (Keyword)cOperatorAlternatives_2_0.eContents().get(0);
		private final Keyword cOperatorEqualsSignKeyword_2_0_1 = (Keyword)cOperatorAlternatives_2_0.eContents().get(1);
		private final Keyword cOperatorQuestionMarkEqualsSignKeyword_2_0_2 = (Keyword)cOperatorAlternatives_2_0.eContents().get(2);
		private final Assignment cTerminalAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTerminalAssignableTerminalParserRuleCall_3_0 = (RuleCall)cTerminalAssignment_3.eContents().get(0);
		
		//Assignment returns Assignment:
		//    (predicated?='=>' | firstSetPredicated?='->')? feature=ValidID operator=('+='|'='|'?=') ^terminal=AssignableTerminal
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(predicated?='=>' | firstSetPredicated?='->')? feature=ValidID operator=('+='|'='|'?=') ^terminal=AssignableTerminal
		public Group getGroup() { return cGroup; }
		
		//(predicated?='=>' | firstSetPredicated?='->')?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//predicated?='=>'
		public Assignment getPredicatedAssignment_0_0() { return cPredicatedAssignment_0_0; }
		
		//'=>'
		public Keyword getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0() { return cPredicatedEqualsSignGreaterThanSignKeyword_0_0_0; }
		
		//firstSetPredicated?='->'
		public Assignment getFirstSetPredicatedAssignment_0_1() { return cFirstSetPredicatedAssignment_0_1; }
		
		//'->'
		public Keyword getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0() { return cFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0; }
		
		//feature=ValidID
		public Assignment getFeatureAssignment_1() { return cFeatureAssignment_1; }
		
		//ValidID
		public RuleCall getFeatureValidIDParserRuleCall_1_0() { return cFeatureValidIDParserRuleCall_1_0; }
		
		//operator=('+='|'='|'?=')
		public Assignment getOperatorAssignment_2() { return cOperatorAssignment_2; }
		
		//('+='|'='|'?=')
		public Alternatives getOperatorAlternatives_2_0() { return cOperatorAlternatives_2_0; }
		
		//'+='
		public Keyword getOperatorPlusSignEqualsSignKeyword_2_0_0() { return cOperatorPlusSignEqualsSignKeyword_2_0_0; }
		
		//'='
		public Keyword getOperatorEqualsSignKeyword_2_0_1() { return cOperatorEqualsSignKeyword_2_0_1; }
		
		//'?='
		public Keyword getOperatorQuestionMarkEqualsSignKeyword_2_0_2() { return cOperatorQuestionMarkEqualsSignKeyword_2_0_2; }
		
		//^terminal=AssignableTerminal
		public Assignment getTerminalAssignment_3() { return cTerminalAssignment_3; }
		
		//AssignableTerminal
		public RuleCall getTerminalAssignableTerminalParserRuleCall_3_0() { return cTerminalAssignableTerminalParserRuleCall_3_0; }
	}
	public class AssignableTerminalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.AssignableTerminal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cKeywordParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRuleCallParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cParenthesizedAssignableElementParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cCrossReferenceParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//AssignableTerminal returns AbstractElement:
		//    Keyword | RuleCall | ParenthesizedAssignableElement | CrossReference
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Keyword | RuleCall | ParenthesizedAssignableElement | CrossReference
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Keyword
		public RuleCall getKeywordParserRuleCall_0() { return cKeywordParserRuleCall_0; }
		
		//RuleCall
		public RuleCall getRuleCallParserRuleCall_1() { return cRuleCallParserRuleCall_1; }
		
		//ParenthesizedAssignableElement
		public RuleCall getParenthesizedAssignableElementParserRuleCall_2() { return cParenthesizedAssignableElementParserRuleCall_2; }
		
		//CrossReference
		public RuleCall getCrossReferenceParserRuleCall_3() { return cCrossReferenceParserRuleCall_3; }
	}
	public class ParenthesizedAssignableElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ParenthesizedAssignableElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cAssignableAlternativesParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//ParenthesizedAssignableElement returns AbstractElement:
		//    '(' AssignableAlternatives ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'(' AssignableAlternatives ')'
		public Group getGroup() { return cGroup; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }
		
		//AssignableAlternatives
		public RuleCall getAssignableAlternativesParserRuleCall_1() { return cAssignableAlternativesParserRuleCall_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}
	public class AssignableAlternativesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.AssignableAlternatives");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAssignableTerminalParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAlternativesElementsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cVerticalLineKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cElementsAssignableTerminalParserRuleCall_1_1_1_0 = (RuleCall)cElementsAssignment_1_1_1.eContents().get(0);
		
		//AssignableAlternatives returns AbstractElement:
		//    AssignableTerminal ({Alternatives.elements+=current} ('|' elements+=AssignableTerminal)+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//AssignableTerminal ({Alternatives.elements+=current} ('|' elements+=AssignableTerminal)+)?
		public Group getGroup() { return cGroup; }
		
		//AssignableTerminal
		public RuleCall getAssignableTerminalParserRuleCall_0() { return cAssignableTerminalParserRuleCall_0; }
		
		//({Alternatives.elements+=current} ('|' elements+=AssignableTerminal)+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{Alternatives.elements+=current}
		public Action getAlternativesElementsAction_1_0() { return cAlternativesElementsAction_1_0; }
		
		//('|' elements+=AssignableTerminal)+
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'|'
		public Keyword getVerticalLineKeyword_1_1_0() { return cVerticalLineKeyword_1_1_0; }
		
		//elements+=AssignableTerminal
		public Assignment getElementsAssignment_1_1_1() { return cElementsAssignment_1_1_1; }
		
		//AssignableTerminal
		public RuleCall getElementsAssignableTerminalParserRuleCall_1_1_1_0() { return cElementsAssignableTerminalParserRuleCall_1_1_1_0; }
	}
	public class CrossReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.CrossReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeTypeRefParserRuleCall_1_0 = (RuleCall)cTypeAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cVerticalLineKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTerminalAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTerminalCrossReferenceableTerminalParserRuleCall_2_1_0 = (RuleCall)cTerminalAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//CrossReference :
		//    '[' type=TypeRef ('|' ^terminal=CrossReferenceableTerminal )? ']'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'[' type=TypeRef ('|' ^terminal=CrossReferenceableTerminal )? ']'
		public Group getGroup() { return cGroup; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }
		
		//type=TypeRef
		public Assignment getTypeAssignment_1() { return cTypeAssignment_1; }
		
		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_1_0() { return cTypeTypeRefParserRuleCall_1_0; }
		
		//('|' ^terminal=CrossReferenceableTerminal )?
		public Group getGroup_2() { return cGroup_2; }
		
		//'|'
		public Keyword getVerticalLineKeyword_2_0() { return cVerticalLineKeyword_2_0; }
		
		//^terminal=CrossReferenceableTerminal
		public Assignment getTerminalAssignment_2_1() { return cTerminalAssignment_2_1; }
		
		//CrossReferenceableTerminal
		public RuleCall getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0() { return cTerminalCrossReferenceableTerminalParserRuleCall_2_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}
	public class CrossReferenceableTerminalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.CrossReferenceableTerminal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cKeywordParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRuleCallParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//CrossReferenceableTerminal returns AbstractElement:
		//    Keyword | RuleCall
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Keyword | RuleCall
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Keyword
		public RuleCall getKeywordParserRuleCall_0() { return cKeywordParserRuleCall_0; }
		
		//RuleCall
		public RuleCall getRuleCallParserRuleCall_1() { return cRuleCallParserRuleCall_1; }
	}
	public class ParenthesizedElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ParenthesizedElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cAlternativesParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//ParenthesizedElement returns AbstractElement:
		//    '(' Alternatives ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'(' Alternatives ')'
		public Group getGroup() { return cGroup; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }
		
		//Alternatives
		public RuleCall getAlternativesParserRuleCall_1() { return cAlternativesParserRuleCall_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}
	public class PredicatedGroupElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.PredicatedGroup");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cPredicatedAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cPredicatedEqualsSignGreaterThanSignKeyword_0_0_0 = (Keyword)cPredicatedAssignment_0_0.eContents().get(0);
		private final Assignment cFirstSetPredicatedAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0 = (Keyword)cFirstSetPredicatedAssignment_0_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cElementsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cElementsAlternativesParserRuleCall_2_0 = (RuleCall)cElementsAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//PredicatedGroup returns Group:
		//    (predicated?='=>' | firstSetPredicated?='->') '(' elements+=Alternatives ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(predicated?='=>' | firstSetPredicated?='->') '(' elements+=Alternatives ')'
		public Group getGroup() { return cGroup; }
		
		//(predicated?='=>' | firstSetPredicated?='->')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//predicated?='=>'
		public Assignment getPredicatedAssignment_0_0() { return cPredicatedAssignment_0_0; }
		
		//'=>'
		public Keyword getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0() { return cPredicatedEqualsSignGreaterThanSignKeyword_0_0_0; }
		
		//firstSetPredicated?='->'
		public Assignment getFirstSetPredicatedAssignment_0_1() { return cFirstSetPredicatedAssignment_0_1; }
		
		//'->'
		public Keyword getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0() { return cFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//elements+=Alternatives
		public Assignment getElementsAssignment_2() { return cElementsAssignment_2; }
		
		//Alternatives
		public RuleCall getElementsAlternativesParserRuleCall_2_0() { return cElementsAlternativesParserRuleCall_2_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}
	public class TerminalRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.TerminalRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cTerminalKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Assignment cFragmentAssignment_2_0_0 = (Assignment)cGroup_2_0.eContents().get(0);
		private final Keyword cFragmentFragmentKeyword_2_0_0_0 = (Keyword)cFragmentAssignment_2_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_2_0_1_0 = (RuleCall)cNameAssignment_2_0_1.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Assignment cNameAssignment_2_1_0 = (Assignment)cGroup_2_1.eContents().get(0);
		private final RuleCall cNameValidIDParserRuleCall_2_1_0_0 = (RuleCall)cNameAssignment_2_1_0.eContents().get(0);
		private final Group cGroup_2_1_1 = (Group)cGroup_2_1.eContents().get(1);
		private final Keyword cReturnsKeyword_2_1_1_0 = (Keyword)cGroup_2_1_1.eContents().get(0);
		private final Assignment cTypeAssignment_2_1_1_1 = (Assignment)cGroup_2_1_1.eContents().get(1);
		private final RuleCall cTypeTypeRefParserRuleCall_2_1_1_1_0 = (RuleCall)cTypeAssignment_2_1_1_1.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cAlternativesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cAlternativesTerminalAlternativesParserRuleCall_4_0 = (RuleCall)cAlternativesAssignment_4.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//TerminalRule :
		//    (annotations += Annotation)*
		//    'terminal' (^fragment?='fragment' name=ValidID | name=ValidID ('returns' type=TypeRef)?) ':'
		//        alternatives=TerminalAlternatives
		//    ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(annotations += Annotation)*
		//'terminal' (^fragment?='fragment' name=ValidID | name=ValidID ('returns' type=TypeRef)?) ':'
		//    alternatives=TerminalAlternatives
		//';'
		public Group getGroup() { return cGroup; }
		
		//(annotations += Annotation)*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_0_0() { return cAnnotationsAnnotationParserRuleCall_0_0; }
		
		//'terminal'
		public Keyword getTerminalKeyword_1() { return cTerminalKeyword_1; }
		
		//(^fragment?='fragment' name=ValidID | name=ValidID ('returns' type=TypeRef)?)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//^fragment?='fragment' name=ValidID
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//^fragment?='fragment'
		public Assignment getFragmentAssignment_2_0_0() { return cFragmentAssignment_2_0_0; }
		
		//'fragment'
		public Keyword getFragmentFragmentKeyword_2_0_0_0() { return cFragmentFragmentKeyword_2_0_0_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_0_1() { return cNameAssignment_2_0_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_1_0() { return cNameValidIDParserRuleCall_2_0_1_0; }
		
		//name=ValidID ('returns' type=TypeRef)?
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_1_0() { return cNameAssignment_2_1_0; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_1_0_0() { return cNameValidIDParserRuleCall_2_1_0_0; }
		
		//('returns' type=TypeRef)?
		public Group getGroup_2_1_1() { return cGroup_2_1_1; }
		
		//'returns'
		public Keyword getReturnsKeyword_2_1_1_0() { return cReturnsKeyword_2_1_1_0; }
		
		//type=TypeRef
		public Assignment getTypeAssignment_2_1_1_1() { return cTypeAssignment_2_1_1_1; }
		
		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_2_1_1_1_0() { return cTypeTypeRefParserRuleCall_2_1_1_1_0; }
		
		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }
		
		//alternatives=TerminalAlternatives
		public Assignment getAlternativesAssignment_4() { return cAlternativesAssignment_4; }
		
		//TerminalAlternatives
		public RuleCall getAlternativesTerminalAlternativesParserRuleCall_4_0() { return cAlternativesTerminalAlternativesParserRuleCall_4_0; }
		
		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}
	public class TerminalAlternativesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.TerminalAlternatives");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTerminalGroupParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAlternativesElementsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cVerticalLineKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cElementsTerminalGroupParserRuleCall_1_1_1_0 = (RuleCall)cElementsAssignment_1_1_1.eContents().get(0);
		
		//TerminalAlternatives returns AbstractElement:
		//    TerminalGroup ({Alternatives.elements+=current} ('|' elements+=TerminalGroup)+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//TerminalGroup ({Alternatives.elements+=current} ('|' elements+=TerminalGroup)+)?
		public Group getGroup() { return cGroup; }
		
		//TerminalGroup
		public RuleCall getTerminalGroupParserRuleCall_0() { return cTerminalGroupParserRuleCall_0; }
		
		//({Alternatives.elements+=current} ('|' elements+=TerminalGroup)+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{Alternatives.elements+=current}
		public Action getAlternativesElementsAction_1_0() { return cAlternativesElementsAction_1_0; }
		
		//('|' elements+=TerminalGroup)+
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'|'
		public Keyword getVerticalLineKeyword_1_1_0() { return cVerticalLineKeyword_1_1_0; }
		
		//elements+=TerminalGroup
		public Assignment getElementsAssignment_1_1_1() { return cElementsAssignment_1_1_1; }
		
		//TerminalGroup
		public RuleCall getElementsTerminalGroupParserRuleCall_1_1_1_0() { return cElementsTerminalGroupParserRuleCall_1_1_1_0; }
	}
	public class TerminalGroupElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.TerminalGroup");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTerminalTokenParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cGroupElementsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cElementsTerminalTokenParserRuleCall_1_1_0 = (RuleCall)cElementsAssignment_1_1.eContents().get(0);
		
		//TerminalGroup returns AbstractElement:
		//    TerminalToken ({Group.elements+=current} (elements+=TerminalToken)+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//TerminalToken ({Group.elements+=current} (elements+=TerminalToken)+)?
		public Group getGroup() { return cGroup; }
		
		//TerminalToken
		public RuleCall getTerminalTokenParserRuleCall_0() { return cTerminalTokenParserRuleCall_0; }
		
		//({Group.elements+=current} (elements+=TerminalToken)+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{Group.elements+=current}
		public Action getGroupElementsAction_1_0() { return cGroupElementsAction_1_0; }
		
		//(elements+=TerminalToken)+
		public Assignment getElementsAssignment_1_1() { return cElementsAssignment_1_1; }
		
		//TerminalToken
		public RuleCall getElementsTerminalTokenParserRuleCall_1_1_0() { return cElementsTerminalTokenParserRuleCall_1_1_0; }
	}
	public class TerminalTokenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.TerminalToken");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTerminalTokenElementParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Assignment cCardinalityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cCardinalityAlternatives_1_0 = (Alternatives)cCardinalityAssignment_1.eContents().get(0);
		private final Keyword cCardinalityQuestionMarkKeyword_1_0_0 = (Keyword)cCardinalityAlternatives_1_0.eContents().get(0);
		private final Keyword cCardinalityAsteriskKeyword_1_0_1 = (Keyword)cCardinalityAlternatives_1_0.eContents().get(1);
		private final Keyword cCardinalityPlusSignKeyword_1_0_2 = (Keyword)cCardinalityAlternatives_1_0.eContents().get(2);
		
		///* SuppressWarnings[potentialOverride]: Handled in CardinalityAwareEcoreFactory */
		//TerminalToken returns AbstractElement:
		//    TerminalTokenElement cardinality=('?'|'*'|'+')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//TerminalTokenElement cardinality=('?'|'*'|'+')?
		public Group getGroup() { return cGroup; }
		
		//TerminalTokenElement
		public RuleCall getTerminalTokenElementParserRuleCall_0() { return cTerminalTokenElementParserRuleCall_0; }
		
		//cardinality=('?'|'*'|'+')?
		public Assignment getCardinalityAssignment_1() { return cCardinalityAssignment_1; }
		
		//('?'|'*'|'+')
		public Alternatives getCardinalityAlternatives_1_0() { return cCardinalityAlternatives_1_0; }
		
		//'?'
		public Keyword getCardinalityQuestionMarkKeyword_1_0_0() { return cCardinalityQuestionMarkKeyword_1_0_0; }
		
		//'*'
		public Keyword getCardinalityAsteriskKeyword_1_0_1() { return cCardinalityAsteriskKeyword_1_0_1; }
		
		//'+'
		public Keyword getCardinalityPlusSignKeyword_1_0_2() { return cCardinalityPlusSignKeyword_1_0_2; }
	}
	public class TerminalTokenElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.TerminalTokenElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCharacterRangeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTerminalRuleCallParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cParenthesizedTerminalElementParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cAbstractNegatedTokenParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cWildcardParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cEOFParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//TerminalTokenElement returns AbstractElement:
		//    CharacterRange | TerminalRuleCall | ParenthesizedTerminalElement | AbstractNegatedToken | Wildcard | ^EOF
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//CharacterRange | TerminalRuleCall | ParenthesizedTerminalElement | AbstractNegatedToken | Wildcard | ^EOF
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//CharacterRange
		public RuleCall getCharacterRangeParserRuleCall_0() { return cCharacterRangeParserRuleCall_0; }
		
		//TerminalRuleCall
		public RuleCall getTerminalRuleCallParserRuleCall_1() { return cTerminalRuleCallParserRuleCall_1; }
		
		//ParenthesizedTerminalElement
		public RuleCall getParenthesizedTerminalElementParserRuleCall_2() { return cParenthesizedTerminalElementParserRuleCall_2; }
		
		//AbstractNegatedToken
		public RuleCall getAbstractNegatedTokenParserRuleCall_3() { return cAbstractNegatedTokenParserRuleCall_3; }
		
		//Wildcard
		public RuleCall getWildcardParserRuleCall_4() { return cWildcardParserRuleCall_4; }
		
		//^EOF
		public RuleCall getEOFParserRuleCall_5() { return cEOFParserRuleCall_5; }
	}
	public class ParenthesizedTerminalElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.ParenthesizedTerminalElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cTerminalAlternativesParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//ParenthesizedTerminalElement returns AbstractElement:
		//    '(' TerminalAlternatives ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'(' TerminalAlternatives ')'
		public Group getGroup() { return cGroup; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }
		
		//TerminalAlternatives
		public RuleCall getTerminalAlternativesParserRuleCall_1() { return cTerminalAlternativesParserRuleCall_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}
	public class AbstractNegatedTokenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.AbstractNegatedToken");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNegatedTokenParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cUntilTokenParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AbstractNegatedToken:
		//    NegatedToken | UntilToken
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//NegatedToken | UntilToken
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//NegatedToken
		public RuleCall getNegatedTokenParserRuleCall_0() { return cNegatedTokenParserRuleCall_0; }
		
		//UntilToken
		public RuleCall getUntilTokenParserRuleCall_1() { return cUntilTokenParserRuleCall_1; }
	}
	public class NegatedTokenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.NegatedToken");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cExclamationMarkKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTerminalAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTerminalTerminalTokenElementParserRuleCall_1_0 = (RuleCall)cTerminalAssignment_1.eContents().get(0);
		
		//NegatedToken:
		//    '!' ^terminal=TerminalTokenElement
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'!' ^terminal=TerminalTokenElement
		public Group getGroup() { return cGroup; }
		
		//'!'
		public Keyword getExclamationMarkKeyword_0() { return cExclamationMarkKeyword_0; }
		
		//^terminal=TerminalTokenElement
		public Assignment getTerminalAssignment_1() { return cTerminalAssignment_1; }
		
		//TerminalTokenElement
		public RuleCall getTerminalTerminalTokenElementParserRuleCall_1_0() { return cTerminalTerminalTokenElementParserRuleCall_1_0; }
	}
	public class UntilTokenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.UntilToken");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTerminalAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTerminalTerminalTokenElementParserRuleCall_1_0 = (RuleCall)cTerminalAssignment_1.eContents().get(0);
		
		//UntilToken:
		//    '->' ^terminal=TerminalTokenElement
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'->' ^terminal=TerminalTokenElement
		public Group getGroup() { return cGroup; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }
		
		//^terminal=TerminalTokenElement
		public Assignment getTerminalAssignment_1() { return cTerminalAssignment_1; }
		
		//TerminalTokenElement
		public RuleCall getTerminalTerminalTokenElementParserRuleCall_1_0() { return cTerminalTerminalTokenElementParserRuleCall_1_0; }
	}
	public class WildcardElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.Wildcard");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cWildcardAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//Wildcard:
		//    {Wildcard} '.'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{Wildcard} '.'
		public Group getGroup() { return cGroup; }
		
		//{Wildcard}
		public Action getWildcardAction_0() { return cWildcardAction_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
	}
	public class EOFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.EOF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEOFAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cEOFKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//^EOF:
		//    {^EOF} 'EOF'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{^EOF} 'EOF'
		public Group getGroup() { return cGroup; }
		
		//{^EOF}
		public Action getEOFAction_0() { return cEOFAction_0; }
		
		//'EOF'
		public Keyword getEOFKeyword_1() { return cEOFKeyword_1; }
	}
	public class CharacterRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.CharacterRange");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cKeywordParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cCharacterRangeLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cFullStopFullStopKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightKeywordParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//CharacterRange returns AbstractElement:
		//    Keyword ( {CharacterRange.left=current} '..' right=Keyword)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Keyword ( {CharacterRange.left=current} '..' right=Keyword)?
		public Group getGroup() { return cGroup; }
		
		//Keyword
		public RuleCall getKeywordParserRuleCall_0() { return cKeywordParserRuleCall_0; }
		
		//( {CharacterRange.left=current} '..' right=Keyword)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{CharacterRange.left=current}
		public Action getCharacterRangeLeftAction_1_0() { return cCharacterRangeLeftAction_1_0; }
		
		//'..'
		public Keyword getFullStopFullStopKeyword_1_1() { return cFullStopFullStopKeyword_1_1; }
		
		//right=Keyword
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//Keyword
		public RuleCall getRightKeywordParserRuleCall_1_2_0() { return cRightKeywordParserRuleCall_1_2_0; }
	}
	public class EnumRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.EnumRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cEnumKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameValidIDParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cReturnsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTypeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTypeTypeRefParserRuleCall_3_1_0 = (RuleCall)cTypeAssignment_3_1.eContents().get(0);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cAlternativesAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cAlternativesEnumLiteralsParserRuleCall_5_0 = (RuleCall)cAlternativesAssignment_5.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//EnumRule:
		//    (annotations += Annotation)*
		//    'enum' name=ValidID ('returns' type=TypeRef)? ':'
		//        alternatives=EnumLiterals
		//    ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(annotations += Annotation)*
		//'enum' name=ValidID ('returns' type=TypeRef)? ':'
		//    alternatives=EnumLiterals
		//';'
		public Group getGroup() { return cGroup; }
		
		//(annotations += Annotation)*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_0_0() { return cAnnotationsAnnotationParserRuleCall_0_0; }
		
		//'enum'
		public Keyword getEnumKeyword_1() { return cEnumKeyword_1; }
		
		//name=ValidID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0() { return cNameValidIDParserRuleCall_2_0; }
		
		//('returns' type=TypeRef)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'returns'
		public Keyword getReturnsKeyword_3_0() { return cReturnsKeyword_3_0; }
		
		//type=TypeRef
		public Assignment getTypeAssignment_3_1() { return cTypeAssignment_3_1; }
		
		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_3_1_0() { return cTypeTypeRefParserRuleCall_3_1_0; }
		
		//':'
		public Keyword getColonKeyword_4() { return cColonKeyword_4; }
		
		//alternatives=EnumLiterals
		public Assignment getAlternativesAssignment_5() { return cAlternativesAssignment_5; }
		
		//EnumLiterals
		public RuleCall getAlternativesEnumLiteralsParserRuleCall_5_0() { return cAlternativesEnumLiteralsParserRuleCall_5_0; }
		
		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}
	public class EnumLiteralsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.EnumLiterals");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cEnumLiteralDeclarationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAlternativesElementsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cVerticalLineKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0 = (RuleCall)cElementsAssignment_1_1_1.eContents().get(0);
		
		//EnumLiterals returns AbstractElement:
		//    EnumLiteralDeclaration ({Alternatives.elements+=current} ('|' elements+=EnumLiteralDeclaration)+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//EnumLiteralDeclaration ({Alternatives.elements+=current} ('|' elements+=EnumLiteralDeclaration)+)?
		public Group getGroup() { return cGroup; }
		
		//EnumLiteralDeclaration
		public RuleCall getEnumLiteralDeclarationParserRuleCall_0() { return cEnumLiteralDeclarationParserRuleCall_0; }
		
		//({Alternatives.elements+=current} ('|' elements+=EnumLiteralDeclaration)+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{Alternatives.elements+=current}
		public Action getAlternativesElementsAction_1_0() { return cAlternativesElementsAction_1_0; }
		
		//('|' elements+=EnumLiteralDeclaration)+
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'|'
		public Keyword getVerticalLineKeyword_1_1_0() { return cVerticalLineKeyword_1_1_0; }
		
		//elements+=EnumLiteralDeclaration
		public Assignment getElementsAssignment_1_1_1() { return cElementsAssignment_1_1_1; }
		
		//EnumLiteralDeclaration
		public RuleCall getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0() { return cElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0; }
	}
	public class EnumLiteralDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.Xtext.EnumLiteralDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cEnumLiteralAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cEnumLiteralEEnumLiteralCrossReference_0_0 = (CrossReference)cEnumLiteralAssignment_0.eContents().get(0);
		private final RuleCall cEnumLiteralEEnumLiteralValidIDParserRuleCall_0_0_1 = (RuleCall)cEnumLiteralEEnumLiteralCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cLiteralAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cLiteralKeywordParserRuleCall_1_1_0 = (RuleCall)cLiteralAssignment_1_1.eContents().get(0);
		
		//EnumLiteralDeclaration:
		//    enumLiteral=[ecore::EEnumLiteral|ValidID] ('=' literal=Keyword)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//enumLiteral=[ecore::EEnumLiteral|ValidID] ('=' literal=Keyword)?
		public Group getGroup() { return cGroup; }
		
		//enumLiteral=[ecore::EEnumLiteral|ValidID]
		public Assignment getEnumLiteralAssignment_0() { return cEnumLiteralAssignment_0; }
		
		//[ecore::EEnumLiteral|ValidID]
		public CrossReference getEnumLiteralEEnumLiteralCrossReference_0_0() { return cEnumLiteralEEnumLiteralCrossReference_0_0; }
		
		//ValidID
		public RuleCall getEnumLiteralEEnumLiteralValidIDParserRuleCall_0_0_1() { return cEnumLiteralEEnumLiteralValidIDParserRuleCall_0_0_1; }
		
		//('=' literal=Keyword)?
		public Group getGroup_1() { return cGroup_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_1_0() { return cEqualsSignKeyword_1_0; }
		
		//literal=Keyword
		public Assignment getLiteralAssignment_1_1() { return cLiteralAssignment_1_1; }
		
		//Keyword
		public RuleCall getLiteralKeywordParserRuleCall_1_1_0() { return cLiteralKeywordParserRuleCall_1_1_0; }
	}
	
	
	private final GrammarElements pGrammar;
	private final GrammarIDElements pGrammarID;
	private final AbstractRuleElements pAbstractRule;
	private final AbstractMetamodelDeclarationElements pAbstractMetamodelDeclaration;
	private final GeneratedMetamodelElements pGeneratedMetamodel;
	private final ReferencedMetamodelElements pReferencedMetamodel;
	private final AnnotationElements pAnnotation;
	private final ParserRuleElements pParserRule;
	private final RuleNameAndParamsElements pRuleNameAndParams;
	private final ParameterElements pParameter;
	private final TypeRefElements pTypeRef;
	private final AlternativesElements pAlternatives;
	private final ConditionalBranchElements pConditionalBranch;
	private final UnorderedGroupElements pUnorderedGroup;
	private final GroupElements pGroup;
	private final AbstractTokenElements pAbstractToken;
	private final AbstractTokenWithCardinalityElements pAbstractTokenWithCardinality;
	private final ActionElements pAction;
	private final AbstractTerminalElements pAbstractTerminal;
	private final KeywordElements pKeyword;
	private final RuleCallElements pRuleCall;
	private final NamedArgumentElements pNamedArgument;
	private final LiteralConditionElements pLiteralCondition;
	private final DisjunctionElements pDisjunction;
	private final ConjunctionElements pConjunction;
	private final NegationElements pNegation;
	private final AtomElements pAtom;
	private final ParenthesizedConditionElements pParenthesizedCondition;
	private final ParameterReferenceElements pParameterReference;
	private final TerminalRuleCallElements pTerminalRuleCall;
	private final RuleIDElements pRuleID;
	private final ValidIDElements pValidID;
	private final PredicatedKeywordElements pPredicatedKeyword;
	private final PredicatedRuleCallElements pPredicatedRuleCall;
	private final AssignmentElements pAssignment;
	private final AssignableTerminalElements pAssignableTerminal;
	private final ParenthesizedAssignableElementElements pParenthesizedAssignableElement;
	private final AssignableAlternativesElements pAssignableAlternatives;
	private final CrossReferenceElements pCrossReference;
	private final CrossReferenceableTerminalElements pCrossReferenceableTerminal;
	private final ParenthesizedElementElements pParenthesizedElement;
	private final PredicatedGroupElements pPredicatedGroup;
	private final TerminalRuleElements pTerminalRule;
	private final TerminalAlternativesElements pTerminalAlternatives;
	private final TerminalGroupElements pTerminalGroup;
	private final TerminalTokenElements pTerminalToken;
	private final TerminalTokenElementElements pTerminalTokenElement;
	private final ParenthesizedTerminalElementElements pParenthesizedTerminalElement;
	private final AbstractNegatedTokenElements pAbstractNegatedToken;
	private final NegatedTokenElements pNegatedToken;
	private final UntilTokenElements pUntilToken;
	private final WildcardElements pWildcard;
	private final EOFElements pEOF;
	private final CharacterRangeElements pCharacterRange;
	private final EnumRuleElements pEnumRule;
	private final EnumLiteralsElements pEnumLiterals;
	private final EnumLiteralDeclarationElements pEnumLiteralDeclaration;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public XtextGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pGrammar = new GrammarElements();
		this.pGrammarID = new GrammarIDElements();
		this.pAbstractRule = new AbstractRuleElements();
		this.pAbstractMetamodelDeclaration = new AbstractMetamodelDeclarationElements();
		this.pGeneratedMetamodel = new GeneratedMetamodelElements();
		this.pReferencedMetamodel = new ReferencedMetamodelElements();
		this.pAnnotation = new AnnotationElements();
		this.pParserRule = new ParserRuleElements();
		this.pRuleNameAndParams = new RuleNameAndParamsElements();
		this.pParameter = new ParameterElements();
		this.pTypeRef = new TypeRefElements();
		this.pAlternatives = new AlternativesElements();
		this.pConditionalBranch = new ConditionalBranchElements();
		this.pUnorderedGroup = new UnorderedGroupElements();
		this.pGroup = new GroupElements();
		this.pAbstractToken = new AbstractTokenElements();
		this.pAbstractTokenWithCardinality = new AbstractTokenWithCardinalityElements();
		this.pAction = new ActionElements();
		this.pAbstractTerminal = new AbstractTerminalElements();
		this.pKeyword = new KeywordElements();
		this.pRuleCall = new RuleCallElements();
		this.pNamedArgument = new NamedArgumentElements();
		this.pLiteralCondition = new LiteralConditionElements();
		this.pDisjunction = new DisjunctionElements();
		this.pConjunction = new ConjunctionElements();
		this.pNegation = new NegationElements();
		this.pAtom = new AtomElements();
		this.pParenthesizedCondition = new ParenthesizedConditionElements();
		this.pParameterReference = new ParameterReferenceElements();
		this.pTerminalRuleCall = new TerminalRuleCallElements();
		this.pRuleID = new RuleIDElements();
		this.pValidID = new ValidIDElements();
		this.pPredicatedKeyword = new PredicatedKeywordElements();
		this.pPredicatedRuleCall = new PredicatedRuleCallElements();
		this.pAssignment = new AssignmentElements();
		this.pAssignableTerminal = new AssignableTerminalElements();
		this.pParenthesizedAssignableElement = new ParenthesizedAssignableElementElements();
		this.pAssignableAlternatives = new AssignableAlternativesElements();
		this.pCrossReference = new CrossReferenceElements();
		this.pCrossReferenceableTerminal = new CrossReferenceableTerminalElements();
		this.pParenthesizedElement = new ParenthesizedElementElements();
		this.pPredicatedGroup = new PredicatedGroupElements();
		this.pTerminalRule = new TerminalRuleElements();
		this.pTerminalAlternatives = new TerminalAlternativesElements();
		this.pTerminalGroup = new TerminalGroupElements();
		this.pTerminalToken = new TerminalTokenElements();
		this.pTerminalTokenElement = new TerminalTokenElementElements();
		this.pParenthesizedTerminalElement = new ParenthesizedTerminalElementElements();
		this.pAbstractNegatedToken = new AbstractNegatedTokenElements();
		this.pNegatedToken = new NegatedTokenElements();
		this.pUntilToken = new UntilTokenElements();
		this.pWildcard = new WildcardElements();
		this.pEOF = new EOFElements();
		this.pCharacterRange = new CharacterRangeElements();
		this.pEnumRule = new EnumRuleElements();
		this.pEnumLiterals = new EnumLiteralsElements();
		this.pEnumLiteralDeclaration = new EnumLiteralDeclarationElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.Xtext".equals(grammar.getName())) {
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
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Grammar:
	//    'grammar' name=GrammarID ('with' usedGrammars+=[Grammar|GrammarID] (',' usedGrammars+=[Grammar|GrammarID])*)?
	//    (definesHiddenTokens?='hidden' '(' (hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)? ')')?
	//    metamodelDeclarations+=AbstractMetamodelDeclaration*
	//    (rules+=AbstractRule)+
	//;
	public GrammarElements getGrammarAccess() {
		return pGrammar;
	}
	
	public ParserRule getGrammarRule() {
		return getGrammarAccess().getRule();
	}
	
	//GrammarID returns ecore::EString:
	//    ValidID ('.' ValidID)*;
	public GrammarIDElements getGrammarIDAccess() {
		return pGrammarID;
	}
	
	public ParserRule getGrammarIDRule() {
		return getGrammarIDAccess().getRule();
	}
	
	//AbstractRule : ParserRule | TerminalRule | EnumRule;
	public AbstractRuleElements getAbstractRuleAccess() {
		return pAbstractRule;
	}
	
	public ParserRule getAbstractRuleRule() {
		return getAbstractRuleAccess().getRule();
	}
	
	//AbstractMetamodelDeclaration :
	//    GeneratedMetamodel | ReferencedMetamodel;
	public AbstractMetamodelDeclarationElements getAbstractMetamodelDeclarationAccess() {
		return pAbstractMetamodelDeclaration;
	}
	
	public ParserRule getAbstractMetamodelDeclarationRule() {
		return getAbstractMetamodelDeclarationAccess().getRule();
	}
	
	//// constraint: typeSelect(GeneratedMetamodel).size() == typeSelect(GeneratedMetamodel).alias.size()
	//// generated metamodels have to have different aliases
	//GeneratedMetamodel :
	//    'generate' name=ValidID ePackage=[ecore::EPackage|STRING] ('as' alias=ValidID)?;
	public GeneratedMetamodelElements getGeneratedMetamodelAccess() {
		return pGeneratedMetamodel;
	}
	
	public ParserRule getGeneratedMetamodelRule() {
		return getGeneratedMetamodelAccess().getRule();
	}
	
	//// referenced metamodels may share aliases with other referenced metamodels
	//// and with generated metamodels
	//ReferencedMetamodel :
	//    'import' ePackage=[ecore::EPackage|STRING] ('as' alias=ValidID)?;
	public ReferencedMetamodelElements getReferencedMetamodelAccess() {
		return pReferencedMetamodel;
	}
	
	public ParserRule getReferencedMetamodelRule() {
		return getReferencedMetamodelAccess().getRule();
	}
	
	////fragment Alias returns AbstractMetamodelDeclaration:
	////    'as' alias=ValidID
	////;
	//Annotation returns Annotation:
	//    '@' name = ID
	//;
	public AnnotationElements getAnnotationAccess() {
		return pAnnotation;
	}
	
	public ParserRule getAnnotationRule() {
		return getAnnotationAccess().getRule();
	}
	
	//ParserRule :
	//    (annotations += Annotation)*
	//    (
	//      ^fragment?='fragment' RuleNameAndParams (wildcard?='*' | ('returns' type=TypeRef)?)
	//    | RuleNameAndParams ('returns' type=TypeRef)?
	//    )
	//    (definesHiddenTokens?='hidden' '(' (hiddenTokens+=[AbstractRule|RuleID] (',' hiddenTokens+=[AbstractRule|RuleID])*)? ')')? ':'
	//        alternatives=Alternatives
	//    ';'
	//;
	public ParserRuleElements getParserRuleAccess() {
		return pParserRule;
	}
	
	public ParserRule getParserRuleRule() {
		return getParserRuleAccess().getRule();
	}
	
	//fragment RuleNameAndParams returns ParserRule:
	//    name=ValidID ('<' (parameters+=Parameter (',' parameters+=Parameter)*)? '>')?
	//;
	public RuleNameAndParamsElements getRuleNameAndParamsAccess() {
		return pRuleNameAndParams;
	}
	
	public ParserRule getRuleNameAndParamsRule() {
		return getRuleNameAndParamsAccess().getRule();
	}
	
	//Parameter:
	//    name=ID
	//;
	public ParameterElements getParameterAccess() {
		return pParameter;
	}
	
	public ParserRule getParameterRule() {
		return getParameterAccess().getRule();
	}
	
	//TypeRef :
	//    (metamodel=[AbstractMetamodelDeclaration] '::')? classifier=[ecore::EClassifier]
	//;
	public TypeRefElements getTypeRefAccess() {
		return pTypeRef;
	}
	
	public ParserRule getTypeRefRule() {
		return getTypeRefAccess().getRule();
	}
	
	//Alternatives returns AbstractElement:
	//    ConditionalBranch ({Alternatives.elements+=current} ('|' elements+=ConditionalBranch)+)?
	//;
	public AlternativesElements getAlternativesAccess() {
		return pAlternatives;
	}
	
	public ParserRule getAlternativesRule() {
		return getAlternativesAccess().getRule();
	}
	
	//ConditionalBranch returns AbstractElement:
	//      UnorderedGroup
	//    | {Group} '<' guardCondition=Disjunction '>' (elements+=AbstractToken)+
	//;
	public ConditionalBranchElements getConditionalBranchAccess() {
		return pConditionalBranch;
	}
	
	public ParserRule getConditionalBranchRule() {
		return getConditionalBranchAccess().getRule();
	}
	
	//UnorderedGroup returns AbstractElement:
	//    Group ({UnorderedGroup.elements+=current} ('&' elements+=Group)+)?
	//;
	public UnorderedGroupElements getUnorderedGroupAccess() {
		return pUnorderedGroup;
	}
	
	public ParserRule getUnorderedGroupRule() {
		return getUnorderedGroupAccess().getRule();
	}
	
	//Group returns AbstractElement:
	//    AbstractToken ({Group.elements+=current} (elements+=AbstractToken)+)?
	//;
	public GroupElements getGroupAccess() {
		return pGroup;
	}
	
	public ParserRule getGroupRule() {
		return getGroupAccess().getRule();
	}
	
	//AbstractToken returns AbstractElement:
	//    AbstractTokenWithCardinality |
	//    Action
	//;
	public AbstractTokenElements getAbstractTokenAccess() {
		return pAbstractToken;
	}
	
	public ParserRule getAbstractTokenRule() {
		return getAbstractTokenAccess().getRule();
	}
	
	///* SuppressWarnings[potentialOverride]: Handled in CardinalityAwareEcoreFactory */
	//AbstractTokenWithCardinality returns AbstractElement:
	//    (Assignment | AbstractTerminal) cardinality=('?'|'*'|'+')?
	//;
	public AbstractTokenWithCardinalityElements getAbstractTokenWithCardinalityAccess() {
		return pAbstractTokenWithCardinality;
	}
	
	public ParserRule getAbstractTokenWithCardinalityRule() {
		return getAbstractTokenWithCardinalityAccess().getRule();
	}
	
	//Action returns Action:
	//    '{' type=TypeRef ('.' feature=ValidID operator=('='|'+=') 'current')? '}'
	//;
	public ActionElements getActionAccess() {
		return pAction;
	}
	
	public ParserRule getActionRule() {
		return getActionAccess().getRule();
	}
	
	//AbstractTerminal returns AbstractElement:
	//    Keyword |
	//    RuleCall |
	//    ParenthesizedElement |
	//    // Keyword and RuleCall are used inside of Assignable terminal
	//    // As we do not want to be able to write name==>ID
	//    // the rules for Keyword and RuleCall have been copied
	//    PredicatedKeyword |
	//    PredicatedRuleCall |
	//    // We have to make this one explicit since the ParenthesizedElement does not
	//    // create an object but we have to set the predicated flag
	//    PredicatedGroup
	//;
	public AbstractTerminalElements getAbstractTerminalAccess() {
		return pAbstractTerminal;
	}
	
	public ParserRule getAbstractTerminalRule() {
		return getAbstractTerminalAccess().getRule();
	}
	
	//Keyword :
	//    value=STRING
	//;
	public KeywordElements getKeywordAccess() {
		return pKeyword;
	}
	
	public ParserRule getKeywordRule() {
		return getKeywordAccess().getRule();
	}
	
	//RuleCall :
	//    rule=[AbstractRule|RuleID] ('<' arguments+=NamedArgument (',' arguments+=NamedArgument)* '>')?
	//;
	public RuleCallElements getRuleCallAccess() {
		return pRuleCall;
	}
	
	public ParserRule getRuleCallRule() {
		return getRuleCallAccess().getRule();
	}
	
	//NamedArgument:
	//    ( parameter=[Parameter|ID] calledByName?= '=')?
	//    ( value=Disjunction )
	//;
	public NamedArgumentElements getNamedArgumentAccess() {
		return pNamedArgument;
	}
	
	public ParserRule getNamedArgumentRule() {
		return getNamedArgumentAccess().getRule();
	}
	
	//LiteralCondition:
	//    {LiteralCondition} (true?='true' | 'false')
	//;
	public LiteralConditionElements getLiteralConditionAccess() {
		return pLiteralCondition;
	}
	
	public ParserRule getLiteralConditionRule() {
		return getLiteralConditionAccess().getRule();
	}
	
	//Disjunction returns Condition:
	//    Conjunction ({Disjunction.left=current} '|' right=Conjunction)*
	//;
	public DisjunctionElements getDisjunctionAccess() {
		return pDisjunction;
	}
	
	public ParserRule getDisjunctionRule() {
		return getDisjunctionAccess().getRule();
	}
	
	//Conjunction returns Condition:
	//    Negation ({Conjunction.left=current} '&' right=Negation)*
	//;
	public ConjunctionElements getConjunctionAccess() {
		return pConjunction;
	}
	
	public ParserRule getConjunctionRule() {
		return getConjunctionAccess().getRule();
	}
	
	//Negation returns Condition:
	//    Atom | {Negation} '!' value=Negation
	//;
	public NegationElements getNegationAccess() {
		return pNegation;
	}
	
	public ParserRule getNegationRule() {
		return getNegationAccess().getRule();
	}
	
	//Atom returns Condition:
	//    ParameterReference | ParenthesizedCondition | LiteralCondition
	//;
	public AtomElements getAtomAccess() {
		return pAtom;
	}
	
	public ParserRule getAtomRule() {
		return getAtomAccess().getRule();
	}
	
	//ParenthesizedCondition returns Condition:
	//    '(' Disjunction ')'
	//;
	public ParenthesizedConditionElements getParenthesizedConditionAccess() {
		return pParenthesizedCondition;
	}
	
	public ParserRule getParenthesizedConditionRule() {
		return getParenthesizedConditionAccess().getRule();
	}
	
	//ParameterReference:
	//    parameter=[Parameter|ID]
	//;
	public ParameterReferenceElements getParameterReferenceAccess() {
		return pParameterReference;
	}
	
	public ParserRule getParameterReferenceRule() {
		return getParameterReferenceAccess().getRule();
	}
	
	//TerminalRuleCall returns RuleCall:
	//    rule=[AbstractRule|RuleID]
	//;
	public TerminalRuleCallElements getTerminalRuleCallAccess() {
		return pTerminalRuleCall;
	}
	
	public ParserRule getTerminalRuleCallRule() {
		return getTerminalRuleCallAccess().getRule();
	}
	
	//RuleID returns ecore::EString:
	//    ValidID ('::' ValidID)*
	//;
	public RuleIDElements getRuleIDAccess() {
		return pRuleID;
	}
	
	public ParserRule getRuleIDRule() {
		return getRuleIDAccess().getRule();
	}
	
	//ValidID returns ecore::EString:
	//    ID | 'true' | 'false'
	//;
	public ValidIDElements getValidIDAccess() {
		return pValidID;
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//PredicatedKeyword returns Keyword:
	//    (predicated?='=>' | firstSetPredicated?='->') value=STRING
	//;
	public PredicatedKeywordElements getPredicatedKeywordAccess() {
		return pPredicatedKeyword;
	}
	
	public ParserRule getPredicatedKeywordRule() {
		return getPredicatedKeywordAccess().getRule();
	}
	
	//PredicatedRuleCall returns RuleCall:
	//    (predicated?='=>' | firstSetPredicated?='->') rule=[AbstractRule|RuleID] ('<' arguments+=NamedArgument (',' arguments+=NamedArgument)* '>')?
	//;
	public PredicatedRuleCallElements getPredicatedRuleCallAccess() {
		return pPredicatedRuleCall;
	}
	
	public ParserRule getPredicatedRuleCallRule() {
		return getPredicatedRuleCallAccess().getRule();
	}
	
	//Assignment returns Assignment:
	//    (predicated?='=>' | firstSetPredicated?='->')? feature=ValidID operator=('+='|'='|'?=') ^terminal=AssignableTerminal
	//;
	public AssignmentElements getAssignmentAccess() {
		return pAssignment;
	}
	
	public ParserRule getAssignmentRule() {
		return getAssignmentAccess().getRule();
	}
	
	//AssignableTerminal returns AbstractElement:
	//    Keyword | RuleCall | ParenthesizedAssignableElement | CrossReference
	//;
	public AssignableTerminalElements getAssignableTerminalAccess() {
		return pAssignableTerminal;
	}
	
	public ParserRule getAssignableTerminalRule() {
		return getAssignableTerminalAccess().getRule();
	}
	
	//ParenthesizedAssignableElement returns AbstractElement:
	//    '(' AssignableAlternatives ')'
	//;
	public ParenthesizedAssignableElementElements getParenthesizedAssignableElementAccess() {
		return pParenthesizedAssignableElement;
	}
	
	public ParserRule getParenthesizedAssignableElementRule() {
		return getParenthesizedAssignableElementAccess().getRule();
	}
	
	//AssignableAlternatives returns AbstractElement:
	//    AssignableTerminal ({Alternatives.elements+=current} ('|' elements+=AssignableTerminal)+)?
	//;
	public AssignableAlternativesElements getAssignableAlternativesAccess() {
		return pAssignableAlternatives;
	}
	
	public ParserRule getAssignableAlternativesRule() {
		return getAssignableAlternativesAccess().getRule();
	}
	
	//CrossReference :
	//    '[' type=TypeRef ('|' ^terminal=CrossReferenceableTerminal )? ']'
	//;
	public CrossReferenceElements getCrossReferenceAccess() {
		return pCrossReference;
	}
	
	public ParserRule getCrossReferenceRule() {
		return getCrossReferenceAccess().getRule();
	}
	
	//CrossReferenceableTerminal returns AbstractElement:
	//    Keyword | RuleCall
	//;
	public CrossReferenceableTerminalElements getCrossReferenceableTerminalAccess() {
		return pCrossReferenceableTerminal;
	}
	
	public ParserRule getCrossReferenceableTerminalRule() {
		return getCrossReferenceableTerminalAccess().getRule();
	}
	
	//ParenthesizedElement returns AbstractElement:
	//    '(' Alternatives ')'
	//;
	public ParenthesizedElementElements getParenthesizedElementAccess() {
		return pParenthesizedElement;
	}
	
	public ParserRule getParenthesizedElementRule() {
		return getParenthesizedElementAccess().getRule();
	}
	
	//PredicatedGroup returns Group:
	//    (predicated?='=>' | firstSetPredicated?='->') '(' elements+=Alternatives ')'
	//;
	public PredicatedGroupElements getPredicatedGroupAccess() {
		return pPredicatedGroup;
	}
	
	public ParserRule getPredicatedGroupRule() {
		return getPredicatedGroupAccess().getRule();
	}
	
	//TerminalRule :
	//    (annotations += Annotation)*
	//    'terminal' (^fragment?='fragment' name=ValidID | name=ValidID ('returns' type=TypeRef)?) ':'
	//        alternatives=TerminalAlternatives
	//    ';'
	//;
	public TerminalRuleElements getTerminalRuleAccess() {
		return pTerminalRule;
	}
	
	public ParserRule getTerminalRuleRule() {
		return getTerminalRuleAccess().getRule();
	}
	
	//TerminalAlternatives returns AbstractElement:
	//    TerminalGroup ({Alternatives.elements+=current} ('|' elements+=TerminalGroup)+)?
	//;
	public TerminalAlternativesElements getTerminalAlternativesAccess() {
		return pTerminalAlternatives;
	}
	
	public ParserRule getTerminalAlternativesRule() {
		return getTerminalAlternativesAccess().getRule();
	}
	
	//TerminalGroup returns AbstractElement:
	//    TerminalToken ({Group.elements+=current} (elements+=TerminalToken)+)?
	//;
	public TerminalGroupElements getTerminalGroupAccess() {
		return pTerminalGroup;
	}
	
	public ParserRule getTerminalGroupRule() {
		return getTerminalGroupAccess().getRule();
	}
	
	///* SuppressWarnings[potentialOverride]: Handled in CardinalityAwareEcoreFactory */
	//TerminalToken returns AbstractElement:
	//    TerminalTokenElement cardinality=('?'|'*'|'+')?
	//;
	public TerminalTokenElements getTerminalTokenAccess() {
		return pTerminalToken;
	}
	
	public ParserRule getTerminalTokenRule() {
		return getTerminalTokenAccess().getRule();
	}
	
	//TerminalTokenElement returns AbstractElement:
	//    CharacterRange | TerminalRuleCall | ParenthesizedTerminalElement | AbstractNegatedToken | Wildcard | ^EOF
	//;
	public TerminalTokenElementElements getTerminalTokenElementAccess() {
		return pTerminalTokenElement;
	}
	
	public ParserRule getTerminalTokenElementRule() {
		return getTerminalTokenElementAccess().getRule();
	}
	
	//ParenthesizedTerminalElement returns AbstractElement:
	//    '(' TerminalAlternatives ')'
	//;
	public ParenthesizedTerminalElementElements getParenthesizedTerminalElementAccess() {
		return pParenthesizedTerminalElement;
	}
	
	public ParserRule getParenthesizedTerminalElementRule() {
		return getParenthesizedTerminalElementAccess().getRule();
	}
	
	//AbstractNegatedToken:
	//    NegatedToken | UntilToken
	//;
	public AbstractNegatedTokenElements getAbstractNegatedTokenAccess() {
		return pAbstractNegatedToken;
	}
	
	public ParserRule getAbstractNegatedTokenRule() {
		return getAbstractNegatedTokenAccess().getRule();
	}
	
	//NegatedToken:
	//    '!' ^terminal=TerminalTokenElement
	//;
	public NegatedTokenElements getNegatedTokenAccess() {
		return pNegatedToken;
	}
	
	public ParserRule getNegatedTokenRule() {
		return getNegatedTokenAccess().getRule();
	}
	
	//UntilToken:
	//    '->' ^terminal=TerminalTokenElement
	//;
	public UntilTokenElements getUntilTokenAccess() {
		return pUntilToken;
	}
	
	public ParserRule getUntilTokenRule() {
		return getUntilTokenAccess().getRule();
	}
	
	//Wildcard:
	//    {Wildcard} '.'
	//;
	public WildcardElements getWildcardAccess() {
		return pWildcard;
	}
	
	public ParserRule getWildcardRule() {
		return getWildcardAccess().getRule();
	}
	
	//^EOF:
	//    {^EOF} 'EOF'
	//;
	public EOFElements getEOFAccess() {
		return pEOF;
	}
	
	public ParserRule getEOFRule() {
		return getEOFAccess().getRule();
	}
	
	//CharacterRange returns AbstractElement:
	//    Keyword ( {CharacterRange.left=current} '..' right=Keyword)?
	//;
	public CharacterRangeElements getCharacterRangeAccess() {
		return pCharacterRange;
	}
	
	public ParserRule getCharacterRangeRule() {
		return getCharacterRangeAccess().getRule();
	}
	
	//EnumRule:
	//    (annotations += Annotation)*
	//    'enum' name=ValidID ('returns' type=TypeRef)? ':'
	//        alternatives=EnumLiterals
	//    ';'
	//;
	public EnumRuleElements getEnumRuleAccess() {
		return pEnumRule;
	}
	
	public ParserRule getEnumRuleRule() {
		return getEnumRuleAccess().getRule();
	}
	
	//EnumLiterals returns AbstractElement:
	//    EnumLiteralDeclaration ({Alternatives.elements+=current} ('|' elements+=EnumLiteralDeclaration)+)?
	//;
	public EnumLiteralsElements getEnumLiteralsAccess() {
		return pEnumLiterals;
	}
	
	public ParserRule getEnumLiteralsRule() {
		return getEnumLiteralsAccess().getRule();
	}
	
	//EnumLiteralDeclaration:
	//    enumLiteral=[ecore::EEnumLiteral|ValidID] ('=' literal=Keyword)?
	//;
	public EnumLiteralDeclarationElements getEnumLiteralDeclarationAccess() {
		return pEnumLiteralDeclaration;
	}
	
	public ParserRule getEnumLiteralDeclarationRule() {
		return getEnumLiteralDeclarationAccess().getRule();
	}
	
	//terminal ID: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt: ('0'..'9')+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|'"') )* '"' |
	//            "'" ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT : '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT : '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS         : (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
