/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Annotation;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.Conjunction;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Disjunction;
import org.eclipse.xtext.EOF;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LiteralCondition;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.Negation;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParameterReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.services.XtextGrammarAccess;

@SuppressWarnings("all")
public class XtextSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private XtextGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == XtextPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtextPackage.ACTION:
				if (rule == grammarAccess.getAlternativesRule()
						|| action == grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getConditionalBranchRule()
						|| rule == grammarAccess.getUnorderedGroupRule()
						|| action == grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()
						|| rule == grammarAccess.getGroupRule()
						|| action == grammarAccess.getGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getAbstractTokenRule()
						|| rule == grammarAccess.getAbstractTokenWithCardinalityRule()
						|| rule == grammarAccess.getAbstractTerminalRule()
						|| rule == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_Action(context, (Action) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getActionRule()) {
					sequence_Action(context, (Action) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.ALTERNATIVES:
				if (rule == grammarAccess.getAlternativesRule()
						|| action == grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getConditionalBranchRule()
						|| rule == grammarAccess.getUnorderedGroupRule()
						|| action == grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()
						|| rule == grammarAccess.getGroupRule()
						|| action == grammarAccess.getGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getAbstractTokenRule()
						|| rule == grammarAccess.getAbstractTokenWithCardinalityRule()
						|| rule == grammarAccess.getAbstractTerminalRule()
						|| rule == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_Alternatives(context, (Alternatives) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAssignableTerminalRule()
						|| rule == grammarAccess.getParenthesizedAssignableElementRule()
						|| rule == grammarAccess.getAssignableAlternativesRule()
						|| action == grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()) {
					sequence_AssignableAlternatives(context, (Alternatives) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getEnumLiteralsRule()) {
					sequence_EnumLiterals(context, (Alternatives) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_TerminalAlternatives_TerminalToken(context, (Alternatives) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.ANNOTATION:
				sequence_Annotation(context, (Annotation) semanticObject); 
				return; 
			case XtextPackage.ASSIGNMENT:
				if (rule == grammarAccess.getAlternativesRule()
						|| action == grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getConditionalBranchRule()
						|| rule == grammarAccess.getUnorderedGroupRule()
						|| action == grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()
						|| rule == grammarAccess.getGroupRule()
						|| action == grammarAccess.getGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getAbstractTokenRule()
						|| rule == grammarAccess.getAbstractTokenWithCardinalityRule()
						|| rule == grammarAccess.getAbstractTerminalRule()
						|| rule == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAssignmentRule()) {
					sequence_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.CHARACTER_RANGE:
				if (rule == grammarAccess.getCharacterRangeRule()) {
					sequence_CharacterRange(context, (CharacterRange) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_CharacterRange_TerminalToken(context, (CharacterRange) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.CONJUNCTION:
				sequence_Conjunction(context, (Conjunction) semanticObject); 
				return; 
			case XtextPackage.CROSS_REFERENCE:
				sequence_CrossReference(context, (CrossReference) semanticObject); 
				return; 
			case XtextPackage.DISJUNCTION:
				sequence_Disjunction(context, (Disjunction) semanticObject); 
				return; 
			case XtextPackage.EOF:
				if (rule == grammarAccess.getEOFRule()) {
					sequence_EOF(context, (EOF) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_EOF_TerminalToken(context, (EOF) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.ENUM_LITERAL_DECLARATION:
				sequence_EnumLiteralDeclaration(context, (EnumLiteralDeclaration) semanticObject); 
				return; 
			case XtextPackage.ENUM_RULE:
				sequence_EnumRule(context, (EnumRule) semanticObject); 
				return; 
			case XtextPackage.GENERATED_METAMODEL:
				sequence_GeneratedMetamodel(context, (GeneratedMetamodel) semanticObject); 
				return; 
			case XtextPackage.GRAMMAR:
				sequence_Grammar(context, (Grammar) semanticObject); 
				return; 
			case XtextPackage.GROUP:
				if (rule == grammarAccess.getAlternativesRule()
						|| action == grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getConditionalBranchRule()
						|| rule == grammarAccess.getUnorderedGroupRule()
						|| action == grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()
						|| rule == grammarAccess.getGroupRule()
						|| action == grammarAccess.getGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getAbstractTokenRule()
						|| rule == grammarAccess.getAbstractTokenWithCardinalityRule()
						|| rule == grammarAccess.getAbstractTerminalRule()
						|| rule == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_ConditionalBranch_Group_PredicatedGroup(context, (Group) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPredicatedGroupRule()) {
					sequence_PredicatedGroup(context, (Group) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_TerminalGroup_TerminalToken(context, (Group) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.KEYWORD:
				if (rule == grammarAccess.getAlternativesRule()
						|| action == grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getConditionalBranchRule()
						|| rule == grammarAccess.getUnorderedGroupRule()
						|| action == grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()
						|| rule == grammarAccess.getGroupRule()
						|| action == grammarAccess.getGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getAbstractTokenRule()
						|| rule == grammarAccess.getAbstractTokenWithCardinalityRule()
						|| rule == grammarAccess.getAbstractTerminalRule()
						|| rule == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_Keyword_PredicatedKeyword(context, (Keyword) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getKeywordRule()
						|| rule == grammarAccess.getAssignableTerminalRule()
						|| rule == grammarAccess.getParenthesizedAssignableElementRule()
						|| rule == grammarAccess.getAssignableAlternativesRule()
						|| action == grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getCrossReferenceableTerminalRule()
						|| rule == grammarAccess.getCharacterRangeRule()
						|| action == grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()) {
					sequence_Keyword(context, (Keyword) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_Keyword_TerminalToken(context, (Keyword) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPredicatedKeywordRule()) {
					sequence_PredicatedKeyword(context, (Keyword) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.LITERAL_CONDITION:
				sequence_LiteralCondition(context, (LiteralCondition) semanticObject); 
				return; 
			case XtextPackage.NAMED_ARGUMENT:
				sequence_NamedArgument(context, (NamedArgument) semanticObject); 
				return; 
			case XtextPackage.NEGATED_TOKEN:
				if (rule == grammarAccess.getAbstractNegatedTokenRule()
						|| rule == grammarAccess.getNegatedTokenRule()) {
					sequence_NegatedToken(context, (NegatedToken) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_NegatedToken_TerminalToken(context, (NegatedToken) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.NEGATION:
				sequence_Negation(context, (Negation) semanticObject); 
				return; 
			case XtextPackage.PARAMETER:
				sequence_Parameter(context, (Parameter) semanticObject); 
				return; 
			case XtextPackage.PARAMETER_REFERENCE:
				sequence_ParameterReference(context, (ParameterReference) semanticObject); 
				return; 
			case XtextPackage.PARSER_RULE:
				sequence_ParserRule_RuleNameAndParams(context, (ParserRule) semanticObject); 
				return; 
			case XtextPackage.REFERENCED_METAMODEL:
				sequence_ReferencedMetamodel(context, (ReferencedMetamodel) semanticObject); 
				return; 
			case XtextPackage.RULE_CALL:
				if (rule == grammarAccess.getAlternativesRule()
						|| action == grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getConditionalBranchRule()
						|| rule == grammarAccess.getUnorderedGroupRule()
						|| action == grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()
						|| rule == grammarAccess.getGroupRule()
						|| action == grammarAccess.getGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getAbstractTokenRule()
						|| rule == grammarAccess.getAbstractTokenWithCardinalityRule()
						|| rule == grammarAccess.getAbstractTerminalRule()
						|| rule == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_PredicatedRuleCall_RuleCall(context, (RuleCall) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPredicatedRuleCallRule()) {
					sequence_PredicatedRuleCall(context, (RuleCall) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRuleCallRule()
						|| rule == grammarAccess.getAssignableTerminalRule()
						|| rule == grammarAccess.getParenthesizedAssignableElementRule()
						|| rule == grammarAccess.getAssignableAlternativesRule()
						|| action == grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getCrossReferenceableTerminalRule()) {
					sequence_RuleCall(context, (RuleCall) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTerminalRuleCallRule()) {
					sequence_TerminalRuleCall(context, (RuleCall) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_TerminalRuleCall_TerminalToken(context, (RuleCall) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.TERMINAL_RULE:
				sequence_TerminalRule(context, (TerminalRule) semanticObject); 
				return; 
			case XtextPackage.TYPE_REF:
				sequence_TypeRef(context, (TypeRef) semanticObject); 
				return; 
			case XtextPackage.UNORDERED_GROUP:
				sequence_AbstractTokenWithCardinality_UnorderedGroup(context, (UnorderedGroup) semanticObject); 
				return; 
			case XtextPackage.UNTIL_TOKEN:
				if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_TerminalToken_UntilToken(context, (UntilToken) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAbstractNegatedTokenRule()
						|| rule == grammarAccess.getUntilTokenRule()) {
					sequence_UntilToken(context, (UntilToken) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.WILDCARD:
				if (rule == grammarAccess.getTerminalAlternativesRule()
						|| action == grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()
						|| rule == grammarAccess.getTerminalGroupRule()
						|| action == grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()
						|| rule == grammarAccess.getTerminalTokenRule()
						|| rule == grammarAccess.getTerminalTokenElementRule()
						|| rule == grammarAccess.getParenthesizedTerminalElementRule()) {
					sequence_TerminalToken_Wildcard(context, (Wildcard) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getWildcardRule()) {
					sequence_Wildcard(context, (Wildcard) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alternatives returns Action
	 *     Alternatives.Alternatives_1_0 returns Action
	 *     ConditionalBranch returns Action
	 *     UnorderedGroup returns Action
	 *     UnorderedGroup.UnorderedGroup_1_0 returns Action
	 *     Group returns Action
	 *     Group.Group_1_0 returns Action
	 *     AbstractToken returns Action
	 *     AbstractTokenWithCardinality returns Action
	 *     AbstractTerminal returns Action
	 *     ParenthesizedElement returns Action
	 *
	 * Constraint:
	 *     (type=TypeRef (feature=ValidID (operator='=' | operator='+='))? (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_AbstractTokenWithCardinality_Action(ISerializationContext context, Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alternatives returns Alternatives
	 *     Alternatives.Alternatives_1_0 returns Alternatives
	 *     ConditionalBranch returns Alternatives
	 *     UnorderedGroup returns Alternatives
	 *     UnorderedGroup.UnorderedGroup_1_0 returns Alternatives
	 *     Group returns Alternatives
	 *     Group.Group_1_0 returns Alternatives
	 *     AbstractToken returns Alternatives
	 *     AbstractTokenWithCardinality returns Alternatives
	 *     AbstractTerminal returns Alternatives
	 *     ParenthesizedElement returns Alternatives
	 *
	 * Constraint:
	 *     (elements+=Alternatives_Alternatives_1_0 elements+=ConditionalBranch+ (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_AbstractTokenWithCardinality_Alternatives(ISerializationContext context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alternatives returns Assignment
	 *     Alternatives.Alternatives_1_0 returns Assignment
	 *     ConditionalBranch returns Assignment
	 *     UnorderedGroup returns Assignment
	 *     UnorderedGroup.UnorderedGroup_1_0 returns Assignment
	 *     Group returns Assignment
	 *     Group.Group_1_0 returns Assignment
	 *     AbstractToken returns Assignment
	 *     AbstractTokenWithCardinality returns Assignment
	 *     AbstractTerminal returns Assignment
	 *     ParenthesizedElement returns Assignment
	 *
	 * Constraint:
	 *     (
	 *         (predicated?='=&gt;' | firstSetPredicated?='-&gt;')? 
	 *         feature=ValidID 
	 *         (operator='+=' | operator='=' | operator='?=') 
	 *         terminal=AssignableTerminal 
	 *         (cardinality='?' | cardinality='*' | cardinality='+')*
	 *     )
	 * </pre>
	 */
	protected void sequence_AbstractTokenWithCardinality_Assignment(ISerializationContext context, Assignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alternatives returns Group
	 *     Alternatives.Alternatives_1_0 returns Group
	 *     ConditionalBranch returns Group
	 *     UnorderedGroup returns Group
	 *     UnorderedGroup.UnorderedGroup_1_0 returns Group
	 *     Group returns Group
	 *     Group.Group_1_0 returns Group
	 *     AbstractToken returns Group
	 *     AbstractTokenWithCardinality returns Group
	 *     AbstractTerminal returns Group
	 *     ParenthesizedElement returns Group
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             (guardCondition=Disjunction elements+=AbstractToken+) | 
	 *             (elements+=Group_Group_1_0 elements+=AbstractToken+) | 
	 *             ((predicated?='=&gt;' | firstSetPredicated?='-&gt;') elements+=Alternatives)
	 *         ) 
	 *         (cardinality='?' | cardinality='*' | cardinality='+')*
	 *     )
	 * </pre>
	 */
	protected void sequence_AbstractTokenWithCardinality_ConditionalBranch_Group_PredicatedGroup(ISerializationContext context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alternatives returns Keyword
	 *     Alternatives.Alternatives_1_0 returns Keyword
	 *     ConditionalBranch returns Keyword
	 *     UnorderedGroup returns Keyword
	 *     UnorderedGroup.UnorderedGroup_1_0 returns Keyword
	 *     Group returns Keyword
	 *     Group.Group_1_0 returns Keyword
	 *     AbstractToken returns Keyword
	 *     AbstractTokenWithCardinality returns Keyword
	 *     AbstractTerminal returns Keyword
	 *     ParenthesizedElement returns Keyword
	 *
	 * Constraint:
	 *     ((value=STRING | ((predicated?='=&gt;' | firstSetPredicated?='-&gt;') value=STRING)) (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_AbstractTokenWithCardinality_Keyword_PredicatedKeyword(ISerializationContext context, Keyword semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alternatives returns RuleCall
	 *     Alternatives.Alternatives_1_0 returns RuleCall
	 *     ConditionalBranch returns RuleCall
	 *     UnorderedGroup returns RuleCall
	 *     UnorderedGroup.UnorderedGroup_1_0 returns RuleCall
	 *     Group returns RuleCall
	 *     Group.Group_1_0 returns RuleCall
	 *     AbstractToken returns RuleCall
	 *     AbstractTokenWithCardinality returns RuleCall
	 *     AbstractTerminal returns RuleCall
	 *     ParenthesizedElement returns RuleCall
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             (rule=[AbstractRule|RuleID] (arguments+=NamedArgument arguments+=NamedArgument*)?) | 
	 *             ((predicated?='=&gt;' | firstSetPredicated?='-&gt;') rule=[AbstractRule|RuleID] (arguments+=NamedArgument arguments+=NamedArgument*)?)
	 *         ) 
	 *         (cardinality='?' | cardinality='*' | cardinality='+')*
	 *     )
	 * </pre>
	 */
	protected void sequence_AbstractTokenWithCardinality_PredicatedRuleCall_RuleCall(ISerializationContext context, RuleCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alternatives returns UnorderedGroup
	 *     Alternatives.Alternatives_1_0 returns UnorderedGroup
	 *     ConditionalBranch returns UnorderedGroup
	 *     UnorderedGroup returns UnorderedGroup
	 *     UnorderedGroup.UnorderedGroup_1_0 returns UnorderedGroup
	 *     Group returns UnorderedGroup
	 *     Group.Group_1_0 returns UnorderedGroup
	 *     AbstractToken returns UnorderedGroup
	 *     AbstractTokenWithCardinality returns UnorderedGroup
	 *     AbstractTerminal returns UnorderedGroup
	 *     ParenthesizedElement returns UnorderedGroup
	 *
	 * Constraint:
	 *     (elements+=UnorderedGroup_UnorderedGroup_1_0 elements+=Group+ (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_AbstractTokenWithCardinality_UnorderedGroup(ISerializationContext context, UnorderedGroup semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Action returns Action
	 *
	 * Constraint:
	 *     (type=TypeRef (feature=ValidID (operator='=' | operator='+='))?)
	 * </pre>
	 */
	protected void sequence_Action(ISerializationContext context, Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Annotation returns Annotation
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Annotation(ISerializationContext context, Annotation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.ANNOTATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.ANNOTATION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AssignableTerminal returns Alternatives
	 *     ParenthesizedAssignableElement returns Alternatives
	 *     AssignableAlternatives returns Alternatives
	 *     AssignableAlternatives.Alternatives_1_0 returns Alternatives
	 *
	 * Constraint:
	 *     (elements+=AssignableAlternatives_Alternatives_1_0 elements+=AssignableTerminal+)
	 * </pre>
	 */
	protected void sequence_AssignableAlternatives(ISerializationContext context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Assignment returns Assignment
	 *
	 * Constraint:
	 *     ((predicated?='=&gt;' | firstSetPredicated?='-&gt;')? feature=ValidID (operator='+=' | operator='=' | operator='?=') terminal=AssignableTerminal)
	 * </pre>
	 */
	protected void sequence_Assignment(ISerializationContext context, Assignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     CharacterRange returns CharacterRange
	 *
	 * Constraint:
	 *     (left=CharacterRange_CharacterRange_1_0 right=Keyword)
	 * </pre>
	 */
	protected void sequence_CharacterRange(ISerializationContext context, CharacterRange semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.CHARACTER_RANGE__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.CHARACTER_RANGE__LEFT));
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.CHARACTER_RANGE__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.CHARACTER_RANGE__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns CharacterRange
	 *     TerminalAlternatives.Alternatives_1_0 returns CharacterRange
	 *     TerminalGroup returns CharacterRange
	 *     TerminalGroup.Group_1_0 returns CharacterRange
	 *     TerminalToken returns CharacterRange
	 *     TerminalTokenElement returns CharacterRange
	 *     ParenthesizedTerminalElement returns CharacterRange
	 *
	 * Constraint:
	 *     (left=CharacterRange_CharacterRange_1_0 right=Keyword (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_CharacterRange_TerminalToken(ISerializationContext context, CharacterRange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Disjunction returns Conjunction
	 *     Disjunction.Disjunction_1_0 returns Conjunction
	 *     Conjunction returns Conjunction
	 *     Conjunction.Conjunction_1_0 returns Conjunction
	 *     Negation returns Conjunction
	 *     Atom returns Conjunction
	 *     ParenthesizedCondition returns Conjunction
	 *
	 * Constraint:
	 *     (left=Conjunction_Conjunction_1_0 right=Negation)
	 * </pre>
	 */
	protected void sequence_Conjunction(ISerializationContext context, Conjunction semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.COMPOSITE_CONDITION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.COMPOSITE_CONDITION__LEFT));
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.COMPOSITE_CONDITION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.COMPOSITE_CONDITION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getConjunctionAccess().getRightNegationParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AssignableTerminal returns CrossReference
	 *     ParenthesizedAssignableElement returns CrossReference
	 *     AssignableAlternatives returns CrossReference
	 *     AssignableAlternatives.Alternatives_1_0 returns CrossReference
	 *     CrossReference returns CrossReference
	 *
	 * Constraint:
	 *     (type=TypeRef terminal=CrossReferenceableTerminal?)
	 * </pre>
	 */
	protected void sequence_CrossReference(ISerializationContext context, CrossReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Disjunction returns Disjunction
	 *     Disjunction.Disjunction_1_0 returns Disjunction
	 *     Conjunction returns Disjunction
	 *     Conjunction.Conjunction_1_0 returns Disjunction
	 *     Negation returns Disjunction
	 *     Atom returns Disjunction
	 *     ParenthesizedCondition returns Disjunction
	 *
	 * Constraint:
	 *     (left=Disjunction_Disjunction_1_0 right=Conjunction)
	 * </pre>
	 */
	protected void sequence_Disjunction(ISerializationContext context, Disjunction semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.COMPOSITE_CONDITION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.COMPOSITE_CONDITION__LEFT));
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.COMPOSITE_CONDITION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.COMPOSITE_CONDITION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EOF returns EOF
	 *
	 * Constraint:
	 *     {EOF}
	 * </pre>
	 */
	protected void sequence_EOF(ISerializationContext context, EOF semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns EOF
	 *     TerminalAlternatives.Alternatives_1_0 returns EOF
	 *     TerminalGroup returns EOF
	 *     TerminalGroup.Group_1_0 returns EOF
	 *     TerminalToken returns EOF
	 *     TerminalTokenElement returns EOF
	 *     ParenthesizedTerminalElement returns EOF
	 *
	 * Constraint:
	 *     (cardinality='?' | cardinality='*' | cardinality='+')*
	 * </pre>
	 */
	protected void sequence_EOF_TerminalToken(ISerializationContext context, EOF semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EnumLiterals returns EnumLiteralDeclaration
	 *     EnumLiterals.Alternatives_1_0 returns EnumLiteralDeclaration
	 *     EnumLiteralDeclaration returns EnumLiteralDeclaration
	 *
	 * Constraint:
	 *     (enumLiteral=[EEnumLiteral|ValidID] literal=Keyword?)
	 * </pre>
	 */
	protected void sequence_EnumLiteralDeclaration(ISerializationContext context, EnumLiteralDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EnumLiterals returns Alternatives
	 *
	 * Constraint:
	 *     (elements+=EnumLiterals_Alternatives_1_0 elements+=EnumLiteralDeclaration+)
	 * </pre>
	 */
	protected void sequence_EnumLiterals(ISerializationContext context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractRule returns EnumRule
	 *     EnumRule returns EnumRule
	 *
	 * Constraint:
	 *     (annotations+=Annotation* name=ValidID type=TypeRef? alternatives=EnumLiterals)
	 * </pre>
	 */
	protected void sequence_EnumRule(ISerializationContext context, EnumRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractMetamodelDeclaration returns GeneratedMetamodel
	 *     GeneratedMetamodel returns GeneratedMetamodel
	 *
	 * Constraint:
	 *     (name=ValidID ePackage=[EPackage|STRING] alias=ValidID?)
	 * </pre>
	 */
	protected void sequence_GeneratedMetamodel(ISerializationContext context, GeneratedMetamodel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Grammar returns Grammar
	 *
	 * Constraint:
	 *     (
	 *         name=GrammarID 
	 *         (usedGrammars+=[Grammar|GrammarID] usedGrammars+=[Grammar|GrammarID]*)? 
	 *         (definesHiddenTokens?='hidden' (hiddenTokens+=[AbstractRule|RuleID] hiddenTokens+=[AbstractRule|RuleID]*)?)? 
	 *         metamodelDeclarations+=AbstractMetamodelDeclaration* 
	 *         rules+=AbstractRule+
	 *     )
	 * </pre>
	 */
	protected void sequence_Grammar(ISerializationContext context, Grammar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Keyword returns Keyword
	 *     AssignableTerminal returns Keyword
	 *     ParenthesizedAssignableElement returns Keyword
	 *     AssignableAlternatives returns Keyword
	 *     AssignableAlternatives.Alternatives_1_0 returns Keyword
	 *     CrossReferenceableTerminal returns Keyword
	 *     CharacterRange returns Keyword
	 *     CharacterRange.CharacterRange_1_0 returns Keyword
	 *
	 * Constraint:
	 *     value=STRING
	 * </pre>
	 */
	protected void sequence_Keyword(ISerializationContext context, Keyword semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.KEYWORD__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.KEYWORD__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns Keyword
	 *     TerminalAlternatives.Alternatives_1_0 returns Keyword
	 *     TerminalGroup returns Keyword
	 *     TerminalGroup.Group_1_0 returns Keyword
	 *     TerminalToken returns Keyword
	 *     TerminalTokenElement returns Keyword
	 *     ParenthesizedTerminalElement returns Keyword
	 *
	 * Constraint:
	 *     (value=STRING (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_Keyword_TerminalToken(ISerializationContext context, Keyword semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LiteralCondition returns LiteralCondition
	 *     Disjunction returns LiteralCondition
	 *     Disjunction.Disjunction_1_0 returns LiteralCondition
	 *     Conjunction returns LiteralCondition
	 *     Conjunction.Conjunction_1_0 returns LiteralCondition
	 *     Negation returns LiteralCondition
	 *     Atom returns LiteralCondition
	 *     ParenthesizedCondition returns LiteralCondition
	 *
	 * Constraint:
	 *     true?='true'?
	 * </pre>
	 */
	protected void sequence_LiteralCondition(ISerializationContext context, LiteralCondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedArgument returns NamedArgument
	 *
	 * Constraint:
	 *     ((parameter=[Parameter|ID] calledByName?='=')? value=Disjunction)
	 * </pre>
	 */
	protected void sequence_NamedArgument(ISerializationContext context, NamedArgument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractNegatedToken returns NegatedToken
	 *     NegatedToken returns NegatedToken
	 *
	 * Constraint:
	 *     terminal=TerminalTokenElement
	 * </pre>
	 */
	protected void sequence_NegatedToken(ISerializationContext context, NegatedToken semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.ABSTRACT_NEGATED_TOKEN__TERMINAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.ABSTRACT_NEGATED_TOKEN__TERMINAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), semanticObject.getTerminal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns NegatedToken
	 *     TerminalAlternatives.Alternatives_1_0 returns NegatedToken
	 *     TerminalGroup returns NegatedToken
	 *     TerminalGroup.Group_1_0 returns NegatedToken
	 *     TerminalToken returns NegatedToken
	 *     TerminalTokenElement returns NegatedToken
	 *     ParenthesizedTerminalElement returns NegatedToken
	 *
	 * Constraint:
	 *     (terminal=TerminalTokenElement (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_NegatedToken_TerminalToken(ISerializationContext context, NegatedToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Disjunction returns Negation
	 *     Disjunction.Disjunction_1_0 returns Negation
	 *     Conjunction returns Negation
	 *     Conjunction.Conjunction_1_0 returns Negation
	 *     Negation returns Negation
	 *     Atom returns Negation
	 *     ParenthesizedCondition returns Negation
	 *
	 * Constraint:
	 *     value=Negation
	 * </pre>
	 */
	protected void sequence_Negation(ISerializationContext context, Negation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.NEGATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.NEGATION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNegationAccess().getValueNegationParserRuleCall_1_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Disjunction returns ParameterReference
	 *     Disjunction.Disjunction_1_0 returns ParameterReference
	 *     Conjunction returns ParameterReference
	 *     Conjunction.Conjunction_1_0 returns ParameterReference
	 *     Negation returns ParameterReference
	 *     Atom returns ParameterReference
	 *     ParenthesizedCondition returns ParameterReference
	 *     ParameterReference returns ParameterReference
	 *
	 * Constraint:
	 *     parameter=[Parameter|ID]
	 * </pre>
	 */
	protected void sequence_ParameterReference(ISerializationContext context, ParameterReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.PARAMETER_REFERENCE__PARAMETER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.PARAMETER_REFERENCE__PARAMETER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterReferenceAccess().getParameterParameterIDTerminalRuleCall_0_1(), semanticObject.eGet(XtextPackage.Literals.PARAMETER_REFERENCE__PARAMETER, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Parameter returns Parameter
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Parameter(ISerializationContext context, Parameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.PARAMETER__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractRule returns ParserRule
	 *     ParserRule returns ParserRule
	 *
	 * Constraint:
	 *     (
	 *         annotations+=Annotation* 
	 *         fragment?='fragment'? 
	 *         name=ValidID 
	 *         (parameters+=Parameter parameters+=Parameter*)? 
	 *         (wildcard?='*' | type=TypeRef | type=TypeRef)? 
	 *         (definesHiddenTokens?='hidden' (hiddenTokens+=[AbstractRule|RuleID] hiddenTokens+=[AbstractRule|RuleID]*)?)? 
	 *         alternatives=Alternatives
	 *     )
	 * </pre>
	 */
	protected void sequence_ParserRule_RuleNameAndParams(ISerializationContext context, ParserRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PredicatedGroup returns Group
	 *
	 * Constraint:
	 *     ((predicated?='=&gt;' | firstSetPredicated?='-&gt;') elements+=Alternatives)
	 * </pre>
	 */
	protected void sequence_PredicatedGroup(ISerializationContext context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PredicatedKeyword returns Keyword
	 *
	 * Constraint:
	 *     ((predicated?='=&gt;' | firstSetPredicated?='-&gt;') value=STRING)
	 * </pre>
	 */
	protected void sequence_PredicatedKeyword(ISerializationContext context, Keyword semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PredicatedRuleCall returns RuleCall
	 *
	 * Constraint:
	 *     ((predicated?='=&gt;' | firstSetPredicated?='-&gt;') rule=[AbstractRule|RuleID] (arguments+=NamedArgument arguments+=NamedArgument*)?)
	 * </pre>
	 */
	protected void sequence_PredicatedRuleCall(ISerializationContext context, RuleCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractMetamodelDeclaration returns ReferencedMetamodel
	 *     ReferencedMetamodel returns ReferencedMetamodel
	 *
	 * Constraint:
	 *     (ePackage=[EPackage|STRING] alias=ValidID?)
	 * </pre>
	 */
	protected void sequence_ReferencedMetamodel(ISerializationContext context, ReferencedMetamodel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RuleCall returns RuleCall
	 *     AssignableTerminal returns RuleCall
	 *     ParenthesizedAssignableElement returns RuleCall
	 *     AssignableAlternatives returns RuleCall
	 *     AssignableAlternatives.Alternatives_1_0 returns RuleCall
	 *     CrossReferenceableTerminal returns RuleCall
	 *
	 * Constraint:
	 *     (rule=[AbstractRule|RuleID] (arguments+=NamedArgument arguments+=NamedArgument*)?)
	 * </pre>
	 */
	protected void sequence_RuleCall(ISerializationContext context, RuleCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns Alternatives
	 *     TerminalAlternatives.Alternatives_1_0 returns Alternatives
	 *     TerminalGroup returns Alternatives
	 *     TerminalGroup.Group_1_0 returns Alternatives
	 *     TerminalToken returns Alternatives
	 *     TerminalTokenElement returns Alternatives
	 *     ParenthesizedTerminalElement returns Alternatives
	 *
	 * Constraint:
	 *     (elements+=TerminalAlternatives_Alternatives_1_0 elements+=TerminalGroup+ (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_TerminalAlternatives_TerminalToken(ISerializationContext context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns Group
	 *     TerminalAlternatives.Alternatives_1_0 returns Group
	 *     TerminalGroup returns Group
	 *     TerminalGroup.Group_1_0 returns Group
	 *     TerminalToken returns Group
	 *     TerminalTokenElement returns Group
	 *     ParenthesizedTerminalElement returns Group
	 *
	 * Constraint:
	 *     (elements+=TerminalGroup_Group_1_0 elements+=TerminalToken+ (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_TerminalGroup_TerminalToken(ISerializationContext context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalRuleCall returns RuleCall
	 *
	 * Constraint:
	 *     rule=[AbstractRule|RuleID]
	 * </pre>
	 */
	protected void sequence_TerminalRuleCall(ISerializationContext context, RuleCall semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.RULE_CALL__RULE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.RULE_CALL__RULE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1(), semanticObject.eGet(XtextPackage.Literals.RULE_CALL__RULE, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns RuleCall
	 *     TerminalAlternatives.Alternatives_1_0 returns RuleCall
	 *     TerminalGroup returns RuleCall
	 *     TerminalGroup.Group_1_0 returns RuleCall
	 *     TerminalToken returns RuleCall
	 *     TerminalTokenElement returns RuleCall
	 *     ParenthesizedTerminalElement returns RuleCall
	 *
	 * Constraint:
	 *     (rule=[AbstractRule|RuleID] (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_TerminalRuleCall_TerminalToken(ISerializationContext context, RuleCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractRule returns TerminalRule
	 *     TerminalRule returns TerminalRule
	 *
	 * Constraint:
	 *     (annotations+=Annotation* ((fragment?='fragment' name=ValidID) | (name=ValidID type=TypeRef?)) alternatives=TerminalAlternatives)
	 * </pre>
	 */
	protected void sequence_TerminalRule(ISerializationContext context, TerminalRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns UntilToken
	 *     TerminalAlternatives.Alternatives_1_0 returns UntilToken
	 *     TerminalGroup returns UntilToken
	 *     TerminalGroup.Group_1_0 returns UntilToken
	 *     TerminalToken returns UntilToken
	 *     TerminalTokenElement returns UntilToken
	 *     ParenthesizedTerminalElement returns UntilToken
	 *
	 * Constraint:
	 *     (terminal=TerminalTokenElement (cardinality='?' | cardinality='*' | cardinality='+')*)
	 * </pre>
	 */
	protected void sequence_TerminalToken_UntilToken(ISerializationContext context, UntilToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TerminalAlternatives returns Wildcard
	 *     TerminalAlternatives.Alternatives_1_0 returns Wildcard
	 *     TerminalGroup returns Wildcard
	 *     TerminalGroup.Group_1_0 returns Wildcard
	 *     TerminalToken returns Wildcard
	 *     TerminalTokenElement returns Wildcard
	 *     ParenthesizedTerminalElement returns Wildcard
	 *
	 * Constraint:
	 *     (cardinality='?' | cardinality='*' | cardinality='+')*
	 * </pre>
	 */
	protected void sequence_TerminalToken_Wildcard(ISerializationContext context, Wildcard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TypeRef returns TypeRef
	 *
	 * Constraint:
	 *     (metamodel=[AbstractMetamodelDeclaration|ID]? classifier=[EClassifier|ID])
	 * </pre>
	 */
	protected void sequence_TypeRef(ISerializationContext context, TypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractNegatedToken returns UntilToken
	 *     UntilToken returns UntilToken
	 *
	 * Constraint:
	 *     terminal=TerminalTokenElement
	 * </pre>
	 */
	protected void sequence_UntilToken(ISerializationContext context, UntilToken semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtextPackage.Literals.ABSTRACT_NEGATED_TOKEN__TERMINAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtextPackage.Literals.ABSTRACT_NEGATED_TOKEN__TERMINAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), semanticObject.getTerminal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Wildcard returns Wildcard
	 *
	 * Constraint:
	 *     {Wildcard}
	 * </pre>
	 */
	protected void sequence_Wildcard(ISerializationContext context, Wildcard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
