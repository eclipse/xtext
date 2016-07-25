/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class ArithmeticsSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ArithmeticsGrammarAccess grammarAccess;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_0_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ArithmeticsGrammarAccess) access;
		match_PrimaryExpression_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
		match_PrimaryExpression_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
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
			if (match_PrimaryExpression_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PrimaryExpression_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) func=[AbstractDefinition|ID]
	 *     (rule start) (ambiguity) value=NUMBER
	 *     (rule start) (ambiguity) {Div.left=}
	 *     (rule start) (ambiguity) {Minus.left=}
	 *     (rule start) (ambiguity) {Multi.left=}
	 *     (rule start) (ambiguity) {Plus.left=}
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {Div.left=}
	 *     (rule start) (ambiguity) {Minus.left=}
	 *     (rule start) (ambiguity) {Multi.left=}
	 *     (rule start) (ambiguity) {Plus.left=}
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
