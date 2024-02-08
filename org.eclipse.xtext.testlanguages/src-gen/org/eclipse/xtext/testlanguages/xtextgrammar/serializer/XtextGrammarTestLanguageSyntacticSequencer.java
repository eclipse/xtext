/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.xtextgrammar.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.testlanguages.xtextgrammar.services.XtextGrammarTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class XtextGrammarTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected XtextGrammarTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (XtextGrammarTestLanguageGrammarAccess) access;
		match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
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
			else if (match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     (rule start) (ambiguity) rule=[AbstractRule|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.groups+=}
	 
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
	 *     (rule start) (ambiguity) rule=[AbstractRule|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.groups+=}
	 
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
	 *     (rule start) (ambiguity) rule=[AbstractRule|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.groups+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) rule=[AbstractRule|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.groups+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '{' type=TypeRef
	 *     (rule start) (ambiguity) feature=ID
	 *     (rule start) (ambiguity) rule=[AbstractRule|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.groups+=}
	 *     (rule start) (ambiguity) {Group.tokens+=}
	 
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
	 *     (rule start) (ambiguity) '{' type=TypeRef
	 *     (rule start) (ambiguity) feature=ID
	 *     (rule start) (ambiguity) rule=[AbstractRule|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.groups+=}
	 *     (rule start) (ambiguity) {Group.tokens+=}
	 
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
	 *     (rule start) (ambiguity) rule=[AbstractRule|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.groups+=}
	 *     (rule start) (ambiguity) {CharacterRange.left=}
	 *     (rule start) (ambiguity) {Group.tokens+=}
	 
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
	 *     (rule start) (ambiguity) rule=[AbstractRule|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Alternatives.groups+=}
	 *     (rule start) (ambiguity) {CharacterRange.left=}
	 *     (rule start) (ambiguity) {Group.tokens+=}
	 
	 * </pre>
	 */
	protected void emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
