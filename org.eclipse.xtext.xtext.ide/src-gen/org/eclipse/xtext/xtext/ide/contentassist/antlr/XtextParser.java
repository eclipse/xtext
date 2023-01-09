/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.xtext.ide.contentassist.antlr.internal.InternalXtextParser;

public class XtextParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(XtextGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, XtextGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getAbstractRuleAccess().getAlternatives(), "rule__AbstractRule__Alternatives");
			builder.put(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives(), "rule__AbstractMetamodelDeclaration__Alternatives");
			builder.put(grammarAccess.getParserRuleAccess().getAlternatives_1(), "rule__ParserRule__Alternatives_1");
			builder.put(grammarAccess.getParserRuleAccess().getAlternatives_1_0_2(), "rule__ParserRule__Alternatives_1_0_2");
			builder.put(grammarAccess.getConditionalBranchAccess().getAlternatives(), "rule__ConditionalBranch__Alternatives");
			builder.put(grammarAccess.getAbstractTokenAccess().getAlternatives(), "rule__AbstractToken__Alternatives");
			builder.put(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0(), "rule__AbstractTokenWithCardinality__Alternatives_0");
			builder.put(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0(), "rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0");
			builder.put(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0(), "rule__Action__OperatorAlternatives_2_2_0");
			builder.put(grammarAccess.getAbstractTerminalAccess().getAlternatives(), "rule__AbstractTerminal__Alternatives");
			builder.put(grammarAccess.getLiteralConditionAccess().getAlternatives_1(), "rule__LiteralCondition__Alternatives_1");
			builder.put(grammarAccess.getNegationAccess().getAlternatives(), "rule__Negation__Alternatives");
			builder.put(grammarAccess.getAtomAccess().getAlternatives(), "rule__Atom__Alternatives");
			builder.put(grammarAccess.getValidIDAccess().getAlternatives(), "rule__ValidID__Alternatives");
			builder.put(grammarAccess.getPredicatedKeywordAccess().getAlternatives_0(), "rule__PredicatedKeyword__Alternatives_0");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getAlternatives_0(), "rule__PredicatedRuleCall__Alternatives_0");
			builder.put(grammarAccess.getAssignmentAccess().getAlternatives_0(), "rule__Assignment__Alternatives_0");
			builder.put(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0(), "rule__Assignment__OperatorAlternatives_2_0");
			builder.put(grammarAccess.getAssignableTerminalAccess().getAlternatives(), "rule__AssignableTerminal__Alternatives");
			builder.put(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives(), "rule__CrossReferenceableTerminal__Alternatives");
			builder.put(grammarAccess.getPredicatedGroupAccess().getAlternatives_0(), "rule__PredicatedGroup__Alternatives_0");
			builder.put(grammarAccess.getTerminalRuleAccess().getAlternatives_2(), "rule__TerminalRule__Alternatives_2");
			builder.put(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0(), "rule__TerminalToken__CardinalityAlternatives_1_0");
			builder.put(grammarAccess.getTerminalTokenElementAccess().getAlternatives(), "rule__TerminalTokenElement__Alternatives");
			builder.put(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives(), "rule__AbstractNegatedToken__Alternatives");
			builder.put(grammarAccess.getGrammarAccess().getGroup(), "rule__Grammar__Group__0");
			builder.put(grammarAccess.getGrammarAccess().getGroup_2(), "rule__Grammar__Group_2__0");
			builder.put(grammarAccess.getGrammarAccess().getGroup_2_2(), "rule__Grammar__Group_2_2__0");
			builder.put(grammarAccess.getGrammarAccess().getGroup_3(), "rule__Grammar__Group_3__0");
			builder.put(grammarAccess.getGrammarAccess().getGroup_3_2(), "rule__Grammar__Group_3_2__0");
			builder.put(grammarAccess.getGrammarAccess().getGroup_3_2_1(), "rule__Grammar__Group_3_2_1__0");
			builder.put(grammarAccess.getGrammarIDAccess().getGroup(), "rule__GrammarID__Group__0");
			builder.put(grammarAccess.getGrammarIDAccess().getGroup_1(), "rule__GrammarID__Group_1__0");
			builder.put(grammarAccess.getGeneratedMetamodelAccess().getGroup(), "rule__GeneratedMetamodel__Group__0");
			builder.put(grammarAccess.getGeneratedMetamodelAccess().getGroup_3(), "rule__GeneratedMetamodel__Group_3__0");
			builder.put(grammarAccess.getReferencedMetamodelAccess().getGroup(), "rule__ReferencedMetamodel__Group__0");
			builder.put(grammarAccess.getReferencedMetamodelAccess().getGroup_2(), "rule__ReferencedMetamodel__Group_2__0");
			builder.put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
			builder.put(grammarAccess.getParserRuleAccess().getGroup(), "rule__ParserRule__Group__0");
			builder.put(grammarAccess.getParserRuleAccess().getGroup_1_0(), "rule__ParserRule__Group_1_0__0");
			builder.put(grammarAccess.getParserRuleAccess().getGroup_1_0_2_1(), "rule__ParserRule__Group_1_0_2_1__0");
			builder.put(grammarAccess.getParserRuleAccess().getGroup_1_1(), "rule__ParserRule__Group_1_1__0");
			builder.put(grammarAccess.getParserRuleAccess().getGroup_1_1_1(), "rule__ParserRule__Group_1_1_1__0");
			builder.put(grammarAccess.getParserRuleAccess().getGroup_2(), "rule__ParserRule__Group_2__0");
			builder.put(grammarAccess.getParserRuleAccess().getGroup_2_2(), "rule__ParserRule__Group_2_2__0");
			builder.put(grammarAccess.getParserRuleAccess().getGroup_2_2_1(), "rule__ParserRule__Group_2_2_1__0");
			builder.put(grammarAccess.getRuleNameAndParamsAccess().getGroup(), "rule__RuleNameAndParams__Group__0");
			builder.put(grammarAccess.getRuleNameAndParamsAccess().getGroup_1(), "rule__RuleNameAndParams__Group_1__0");
			builder.put(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1(), "rule__RuleNameAndParams__Group_1_1__0");
			builder.put(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1(), "rule__RuleNameAndParams__Group_1_1_1__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup(), "rule__TypeRef__Group__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_0(), "rule__TypeRef__Group_0__0");
			builder.put(grammarAccess.getAlternativesAccess().getGroup(), "rule__Alternatives__Group__0");
			builder.put(grammarAccess.getAlternativesAccess().getGroup_1(), "rule__Alternatives__Group_1__0");
			builder.put(grammarAccess.getAlternativesAccess().getGroup_1_1(), "rule__Alternatives__Group_1_1__0");
			builder.put(grammarAccess.getConditionalBranchAccess().getGroup_1(), "rule__ConditionalBranch__Group_1__0");
			builder.put(grammarAccess.getUnorderedGroupAccess().getGroup(), "rule__UnorderedGroup__Group__0");
			builder.put(grammarAccess.getUnorderedGroupAccess().getGroup_1(), "rule__UnorderedGroup__Group_1__0");
			builder.put(grammarAccess.getUnorderedGroupAccess().getGroup_1_1(), "rule__UnorderedGroup__Group_1_1__0");
			builder.put(grammarAccess.getGroupAccess().getGroup(), "rule__Group__Group__0");
			builder.put(grammarAccess.getGroupAccess().getGroup_1(), "rule__Group__Group_1__0");
			builder.put(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup(), "rule__AbstractTokenWithCardinality__Group__0");
			builder.put(grammarAccess.getActionAccess().getGroup(), "rule__Action__Group__0");
			builder.put(grammarAccess.getActionAccess().getGroup_2(), "rule__Action__Group_2__0");
			builder.put(grammarAccess.getRuleCallAccess().getGroup(), "rule__RuleCall__Group__0");
			builder.put(grammarAccess.getRuleCallAccess().getGroup_1(), "rule__RuleCall__Group_1__0");
			builder.put(grammarAccess.getRuleCallAccess().getGroup_1_2(), "rule__RuleCall__Group_1_2__0");
			builder.put(grammarAccess.getNamedArgumentAccess().getGroup(), "rule__NamedArgument__Group__0");
			builder.put(grammarAccess.getNamedArgumentAccess().getGroup_0(), "rule__NamedArgument__Group_0__0");
			builder.put(grammarAccess.getLiteralConditionAccess().getGroup(), "rule__LiteralCondition__Group__0");
			builder.put(grammarAccess.getDisjunctionAccess().getGroup(), "rule__Disjunction__Group__0");
			builder.put(grammarAccess.getDisjunctionAccess().getGroup_1(), "rule__Disjunction__Group_1__0");
			builder.put(grammarAccess.getConjunctionAccess().getGroup(), "rule__Conjunction__Group__0");
			builder.put(grammarAccess.getConjunctionAccess().getGroup_1(), "rule__Conjunction__Group_1__0");
			builder.put(grammarAccess.getNegationAccess().getGroup_1(), "rule__Negation__Group_1__0");
			builder.put(grammarAccess.getParenthesizedConditionAccess().getGroup(), "rule__ParenthesizedCondition__Group__0");
			builder.put(grammarAccess.getRuleIDAccess().getGroup(), "rule__RuleID__Group__0");
			builder.put(grammarAccess.getRuleIDAccess().getGroup_1(), "rule__RuleID__Group_1__0");
			builder.put(grammarAccess.getPredicatedKeywordAccess().getGroup(), "rule__PredicatedKeyword__Group__0");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getGroup(), "rule__PredicatedRuleCall__Group__0");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getGroup_2(), "rule__PredicatedRuleCall__Group_2__0");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getGroup_2_2(), "rule__PredicatedRuleCall__Group_2_2__0");
			builder.put(grammarAccess.getAssignmentAccess().getGroup(), "rule__Assignment__Group__0");
			builder.put(grammarAccess.getParenthesizedAssignableElementAccess().getGroup(), "rule__ParenthesizedAssignableElement__Group__0");
			builder.put(grammarAccess.getAssignableAlternativesAccess().getGroup(), "rule__AssignableAlternatives__Group__0");
			builder.put(grammarAccess.getAssignableAlternativesAccess().getGroup_1(), "rule__AssignableAlternatives__Group_1__0");
			builder.put(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1(), "rule__AssignableAlternatives__Group_1_1__0");
			builder.put(grammarAccess.getCrossReferenceAccess().getGroup(), "rule__CrossReference__Group__0");
			builder.put(grammarAccess.getCrossReferenceAccess().getGroup_2(), "rule__CrossReference__Group_2__0");
			builder.put(grammarAccess.getParenthesizedElementAccess().getGroup(), "rule__ParenthesizedElement__Group__0");
			builder.put(grammarAccess.getPredicatedGroupAccess().getGroup(), "rule__PredicatedGroup__Group__0");
			builder.put(grammarAccess.getTerminalRuleAccess().getGroup(), "rule__TerminalRule__Group__0");
			builder.put(grammarAccess.getTerminalRuleAccess().getGroup_2_0(), "rule__TerminalRule__Group_2_0__0");
			builder.put(grammarAccess.getTerminalRuleAccess().getGroup_2_1(), "rule__TerminalRule__Group_2_1__0");
			builder.put(grammarAccess.getTerminalRuleAccess().getGroup_2_1_1(), "rule__TerminalRule__Group_2_1_1__0");
			builder.put(grammarAccess.getTerminalAlternativesAccess().getGroup(), "rule__TerminalAlternatives__Group__0");
			builder.put(grammarAccess.getTerminalAlternativesAccess().getGroup_1(), "rule__TerminalAlternatives__Group_1__0");
			builder.put(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1(), "rule__TerminalAlternatives__Group_1_1__0");
			builder.put(grammarAccess.getTerminalGroupAccess().getGroup(), "rule__TerminalGroup__Group__0");
			builder.put(grammarAccess.getTerminalGroupAccess().getGroup_1(), "rule__TerminalGroup__Group_1__0");
			builder.put(grammarAccess.getTerminalTokenAccess().getGroup(), "rule__TerminalToken__Group__0");
			builder.put(grammarAccess.getParenthesizedTerminalElementAccess().getGroup(), "rule__ParenthesizedTerminalElement__Group__0");
			builder.put(grammarAccess.getNegatedTokenAccess().getGroup(), "rule__NegatedToken__Group__0");
			builder.put(grammarAccess.getUntilTokenAccess().getGroup(), "rule__UntilToken__Group__0");
			builder.put(grammarAccess.getWildcardAccess().getGroup(), "rule__Wildcard__Group__0");
			builder.put(grammarAccess.getEOFAccess().getGroup(), "rule__EOF__Group__0");
			builder.put(grammarAccess.getCharacterRangeAccess().getGroup(), "rule__CharacterRange__Group__0");
			builder.put(grammarAccess.getCharacterRangeAccess().getGroup_1(), "rule__CharacterRange__Group_1__0");
			builder.put(grammarAccess.getEnumRuleAccess().getGroup(), "rule__EnumRule__Group__0");
			builder.put(grammarAccess.getEnumRuleAccess().getGroup_3(), "rule__EnumRule__Group_3__0");
			builder.put(grammarAccess.getEnumLiteralsAccess().getGroup(), "rule__EnumLiterals__Group__0");
			builder.put(grammarAccess.getEnumLiteralsAccess().getGroup_1(), "rule__EnumLiterals__Group_1__0");
			builder.put(grammarAccess.getEnumLiteralsAccess().getGroup_1_1(), "rule__EnumLiterals__Group_1_1__0");
			builder.put(grammarAccess.getEnumLiteralDeclarationAccess().getGroup(), "rule__EnumLiteralDeclaration__Group__0");
			builder.put(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1(), "rule__EnumLiteralDeclaration__Group_1__0");
			builder.put(grammarAccess.getGrammarAccess().getNameAssignment_1(), "rule__Grammar__NameAssignment_1");
			builder.put(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1(), "rule__Grammar__UsedGrammarsAssignment_2_1");
			builder.put(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1(), "rule__Grammar__UsedGrammarsAssignment_2_2_1");
			builder.put(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0(), "rule__Grammar__DefinesHiddenTokensAssignment_3_0");
			builder.put(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0(), "rule__Grammar__HiddenTokensAssignment_3_2_0");
			builder.put(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1(), "rule__Grammar__HiddenTokensAssignment_3_2_1_1");
			builder.put(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4(), "rule__Grammar__MetamodelDeclarationsAssignment_4");
			builder.put(grammarAccess.getGrammarAccess().getRulesAssignment_5(), "rule__Grammar__RulesAssignment_5");
			builder.put(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1(), "rule__GeneratedMetamodel__NameAssignment_1");
			builder.put(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2(), "rule__GeneratedMetamodel__EPackageAssignment_2");
			builder.put(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1(), "rule__GeneratedMetamodel__AliasAssignment_3_1");
			builder.put(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1(), "rule__ReferencedMetamodel__EPackageAssignment_1");
			builder.put(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1(), "rule__ReferencedMetamodel__AliasAssignment_2_1");
			builder.put(grammarAccess.getAnnotationAccess().getNameAssignment_1(), "rule__Annotation__NameAssignment_1");
			builder.put(grammarAccess.getParserRuleAccess().getAnnotationsAssignment_0(), "rule__ParserRule__AnnotationsAssignment_0");
			builder.put(grammarAccess.getParserRuleAccess().getFragmentAssignment_1_0_0(), "rule__ParserRule__FragmentAssignment_1_0_0");
			builder.put(grammarAccess.getParserRuleAccess().getWildcardAssignment_1_0_2_0(), "rule__ParserRule__WildcardAssignment_1_0_2_0");
			builder.put(grammarAccess.getParserRuleAccess().getTypeAssignment_1_0_2_1_1(), "rule__ParserRule__TypeAssignment_1_0_2_1_1");
			builder.put(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1_1_1(), "rule__ParserRule__TypeAssignment_1_1_1_1");
			builder.put(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0(), "rule__ParserRule__DefinesHiddenTokensAssignment_2_0");
			builder.put(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0(), "rule__ParserRule__HiddenTokensAssignment_2_2_0");
			builder.put(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1(), "rule__ParserRule__HiddenTokensAssignment_2_2_1_1");
			builder.put(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4(), "rule__ParserRule__AlternativesAssignment_4");
			builder.put(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0(), "rule__RuleNameAndParams__NameAssignment_0");
			builder.put(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0(), "rule__RuleNameAndParams__ParametersAssignment_1_1_0");
			builder.put(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1(), "rule__RuleNameAndParams__ParametersAssignment_1_1_1_1");
			builder.put(grammarAccess.getParameterAccess().getNameAssignment(), "rule__Parameter__NameAssignment");
			builder.put(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0(), "rule__TypeRef__MetamodelAssignment_0_0");
			builder.put(grammarAccess.getTypeRefAccess().getClassifierAssignment_1(), "rule__TypeRef__ClassifierAssignment_1");
			builder.put(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1(), "rule__Alternatives__ElementsAssignment_1_1_1");
			builder.put(grammarAccess.getConditionalBranchAccess().getGuardConditionAssignment_1_2(), "rule__ConditionalBranch__GuardConditionAssignment_1_2");
			builder.put(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4(), "rule__ConditionalBranch__ElementsAssignment_1_4");
			builder.put(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1(), "rule__UnorderedGroup__ElementsAssignment_1_1_1");
			builder.put(grammarAccess.getGroupAccess().getElementsAssignment_1_1(), "rule__Group__ElementsAssignment_1_1");
			builder.put(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1(), "rule__AbstractTokenWithCardinality__CardinalityAssignment_1");
			builder.put(grammarAccess.getActionAccess().getTypeAssignment_1(), "rule__Action__TypeAssignment_1");
			builder.put(grammarAccess.getActionAccess().getFeatureAssignment_2_1(), "rule__Action__FeatureAssignment_2_1");
			builder.put(grammarAccess.getActionAccess().getOperatorAssignment_2_2(), "rule__Action__OperatorAssignment_2_2");
			builder.put(grammarAccess.getKeywordAccess().getValueAssignment(), "rule__Keyword__ValueAssignment");
			builder.put(grammarAccess.getRuleCallAccess().getRuleAssignment_0(), "rule__RuleCall__RuleAssignment_0");
			builder.put(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_1(), "rule__RuleCall__ArgumentsAssignment_1_1");
			builder.put(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_2_1(), "rule__RuleCall__ArgumentsAssignment_1_2_1");
			builder.put(grammarAccess.getNamedArgumentAccess().getParameterAssignment_0_0(), "rule__NamedArgument__ParameterAssignment_0_0");
			builder.put(grammarAccess.getNamedArgumentAccess().getCalledByNameAssignment_0_1(), "rule__NamedArgument__CalledByNameAssignment_0_1");
			builder.put(grammarAccess.getNamedArgumentAccess().getValueAssignment_1(), "rule__NamedArgument__ValueAssignment_1");
			builder.put(grammarAccess.getLiteralConditionAccess().getTrueAssignment_1_0(), "rule__LiteralCondition__TrueAssignment_1_0");
			builder.put(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2(), "rule__Disjunction__RightAssignment_1_2");
			builder.put(grammarAccess.getConjunctionAccess().getRightAssignment_1_2(), "rule__Conjunction__RightAssignment_1_2");
			builder.put(grammarAccess.getNegationAccess().getValueAssignment_1_2(), "rule__Negation__ValueAssignment_1_2");
			builder.put(grammarAccess.getParameterReferenceAccess().getParameterAssignment(), "rule__ParameterReference__ParameterAssignment");
			builder.put(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment(), "rule__TerminalRuleCall__RuleAssignment");
			builder.put(grammarAccess.getPredicatedKeywordAccess().getPredicatedAssignment_0_0(), "rule__PredicatedKeyword__PredicatedAssignment_0_0");
			builder.put(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedAssignment_0_1(), "rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1");
			builder.put(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1(), "rule__PredicatedKeyword__ValueAssignment_1");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getPredicatedAssignment_0_0(), "rule__PredicatedRuleCall__PredicatedAssignment_0_0");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedAssignment_0_1(), "rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1(), "rule__PredicatedRuleCall__RuleAssignment_1");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_1(), "rule__PredicatedRuleCall__ArgumentsAssignment_2_1");
			builder.put(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_2_1(), "rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1");
			builder.put(grammarAccess.getAssignmentAccess().getPredicatedAssignment_0_0(), "rule__Assignment__PredicatedAssignment_0_0");
			builder.put(grammarAccess.getAssignmentAccess().getFirstSetPredicatedAssignment_0_1(), "rule__Assignment__FirstSetPredicatedAssignment_0_1");
			builder.put(grammarAccess.getAssignmentAccess().getFeatureAssignment_1(), "rule__Assignment__FeatureAssignment_1");
			builder.put(grammarAccess.getAssignmentAccess().getOperatorAssignment_2(), "rule__Assignment__OperatorAssignment_2");
			builder.put(grammarAccess.getAssignmentAccess().getTerminalAssignment_3(), "rule__Assignment__TerminalAssignment_3");
			builder.put(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1(), "rule__AssignableAlternatives__ElementsAssignment_1_1_1");
			builder.put(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1(), "rule__CrossReference__TypeAssignment_1");
			builder.put(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1(), "rule__CrossReference__TerminalAssignment_2_1");
			builder.put(grammarAccess.getPredicatedGroupAccess().getPredicatedAssignment_0_0(), "rule__PredicatedGroup__PredicatedAssignment_0_0");
			builder.put(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedAssignment_0_1(), "rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1");
			builder.put(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2(), "rule__PredicatedGroup__ElementsAssignment_2");
			builder.put(grammarAccess.getTerminalRuleAccess().getAnnotationsAssignment_0(), "rule__TerminalRule__AnnotationsAssignment_0");
			builder.put(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_2_0_0(), "rule__TerminalRule__FragmentAssignment_2_0_0");
			builder.put(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_0_1(), "rule__TerminalRule__NameAssignment_2_0_1");
			builder.put(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_1_0(), "rule__TerminalRule__NameAssignment_2_1_0");
			builder.put(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1_1_1(), "rule__TerminalRule__TypeAssignment_2_1_1_1");
			builder.put(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4(), "rule__TerminalRule__AlternativesAssignment_4");
			builder.put(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1(), "rule__TerminalAlternatives__ElementsAssignment_1_1_1");
			builder.put(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1(), "rule__TerminalGroup__ElementsAssignment_1_1");
			builder.put(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1(), "rule__TerminalToken__CardinalityAssignment_1");
			builder.put(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1(), "rule__NegatedToken__TerminalAssignment_1");
			builder.put(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1(), "rule__UntilToken__TerminalAssignment_1");
			builder.put(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2(), "rule__CharacterRange__RightAssignment_1_2");
			builder.put(grammarAccess.getEnumRuleAccess().getAnnotationsAssignment_0(), "rule__EnumRule__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEnumRuleAccess().getNameAssignment_2(), "rule__EnumRule__NameAssignment_2");
			builder.put(grammarAccess.getEnumRuleAccess().getTypeAssignment_3_1(), "rule__EnumRule__TypeAssignment_3_1");
			builder.put(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_5(), "rule__EnumRule__AlternativesAssignment_5");
			builder.put(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1(), "rule__EnumLiterals__ElementsAssignment_1_1_1");
			builder.put(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0(), "rule__EnumLiteralDeclaration__EnumLiteralAssignment_0");
			builder.put(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1(), "rule__EnumLiteralDeclaration__LiteralAssignment_1_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private XtextGrammarAccess grammarAccess;

	@Override
	protected InternalXtextParser createParser() {
		InternalXtextParser result = new InternalXtextParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public XtextGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(XtextGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
