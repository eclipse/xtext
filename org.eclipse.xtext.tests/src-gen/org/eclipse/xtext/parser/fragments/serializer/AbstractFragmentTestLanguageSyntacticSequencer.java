/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.fragments.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractFragmentTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected FragmentTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_NamedInParentheses_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_RecursiveFragment_LeftParenthesisKeyword_0_0_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (FragmentTestLanguageGrammarAccess) access;
		match_NamedInParentheses_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getNamedInParenthesesAccess().getLeftParenthesisKeyword_0_0());
		match_RecursiveFragment_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getRecursiveFragmentAccess().getLeftParenthesisKeyword_0_0());
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
			if (match_NamedInParentheses_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_NamedInParentheses_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_RecursiveFragment_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_RecursiveFragment_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) name=ID
	 
	 * </pre>
	 */
	protected void emit_NamedInParentheses_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) prev=NamedByAction
	 
	 * </pre>
	 */
	protected void emit_RecursiveFragment_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
