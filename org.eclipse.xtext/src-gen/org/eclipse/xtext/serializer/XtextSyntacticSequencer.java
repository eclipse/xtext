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
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.services.XtextGrammarAccess;

@SuppressWarnings("all")
public class XtextSyntacticSequencer extends AbstractSyntacticSequencer {

	protected XtextGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedCondition_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedCondition_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_RuleNameAndParams___LessThanSignKeyword_1_0_GreaterThanSignKeyword_1_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (XtextGrammarAccess) access;
		match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedCondition_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedCondition_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
		match_RuleNameAndParams___LessThanSignKeyword_1_0_GreaterThanSignKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedCondition_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedCondition_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedCondition_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedCondition_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_RuleNameAndParams___LessThanSignKeyword_1_0_GreaterThanSignKeyword_1_2__q.equals(syntax))
				emit_RuleNameAndParams___LessThanSignKeyword_1_0_GreaterThanSignKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '[' type=TypeRef
	 *     (rule start) (ambiguity) rule=[AbstractRule|RuleID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.elements+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '[' type=TypeRef
	 *     (rule start) (ambiguity) rule=[AbstractRule|RuleID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.elements+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' value=Negation
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) parameter=[Parameter|ID]
	 *     (rule start) (ambiguity) true?='true'
	 *     (rule start) (ambiguity) {Conjunction.left=}
	 *     (rule start) (ambiguity) {Disjunction.left=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedCondition_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' value=Negation
	 *     (rule start) (ambiguity) 'false' ')' (rule start)
	 *     (rule start) (ambiguity) parameter=[Parameter|ID]
	 *     (rule start) (ambiguity) true?='true'
	 *     (rule start) (ambiguity) {Conjunction.left=}
	 *     (rule start) (ambiguity) {Disjunction.left=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedCondition_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '&lt;' guardCondition=Disjunction
	 *     (rule start) (ambiguity) '{' type=TypeRef
	 *     (rule start) (ambiguity) feature=ValidID
	 *     (rule start) (ambiguity) firstSetPredicated?='-&gt;'
	 *     (rule start) (ambiguity) predicated?='=&gt;'
	 *     (rule start) (ambiguity) rule=[AbstractRule|RuleID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.elements+=}
	 *     (rule start) (ambiguity) {Group.elements+=}
	 *     (rule start) (ambiguity) {UnorderedGroup.elements+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedElement_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '&lt;' guardCondition=Disjunction
	 *     (rule start) (ambiguity) '{' type=TypeRef
	 *     (rule start) (ambiguity) feature=ValidID
	 *     (rule start) (ambiguity) firstSetPredicated?='-&gt;'
	 *     (rule start) (ambiguity) predicated?='=&gt;'
	 *     (rule start) (ambiguity) rule=[AbstractRule|RuleID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.elements+=}
	 *     (rule start) (ambiguity) {Group.elements+=}
	 *     (rule start) (ambiguity) {UnorderedGroup.elements+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' terminal=TerminalTokenElement
	 *     (rule start) (ambiguity) '-&gt;' terminal=TerminalTokenElement
	 *     (rule start) (ambiguity) '.' (rule start)
	 *     (rule start) (ambiguity) '.' cardinality='*'
	 *     (rule start) (ambiguity) '.' cardinality='+'
	 *     (rule start) (ambiguity) '.' cardinality='?'
	 *     (rule start) (ambiguity) 'EOF' (rule start)
	 *     (rule start) (ambiguity) 'EOF' cardinality='*'
	 *     (rule start) (ambiguity) 'EOF' cardinality='+'
	 *     (rule start) (ambiguity) 'EOF' cardinality='?'
	 *     (rule start) (ambiguity) rule=[AbstractRule|RuleID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.elements+=}
	 *     (rule start) (ambiguity) {CharacterRange.left=}
	 *     (rule start) (ambiguity) {Group.elements+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' terminal=TerminalTokenElement
	 *     (rule start) (ambiguity) '-&gt;' terminal=TerminalTokenElement
	 *     (rule start) (ambiguity) '.' ')' (rule start)
	 *     (rule start) (ambiguity) '.' cardinality='*'
	 *     (rule start) (ambiguity) '.' cardinality='+'
	 *     (rule start) (ambiguity) '.' cardinality='?'
	 *     (rule start) (ambiguity) 'EOF' ')' (rule start)
	 *     (rule start) (ambiguity) 'EOF' cardinality='*'
	 *     (rule start) (ambiguity) 'EOF' cardinality='+'
	 *     (rule start) (ambiguity) 'EOF' cardinality='?'
	 *     (rule start) (ambiguity) rule=[AbstractRule|RuleID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.elements+=}
	 *     (rule start) (ambiguity) {CharacterRange.left=}
	 *     (rule start) (ambiguity) {Group.elements+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('&lt;' '&gt;')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ValidID (ambiguity) 'returns' type=TypeRef
	 *     name=ValidID (ambiguity) wildcard?='*'
	 
	 * </pre>
	 */
	protected void emit_RuleNameAndParams___LessThanSignKeyword_1_0_GreaterThanSignKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
