/*******************************************************************************
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.serializer;

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
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;

@SuppressWarnings("all")
public class CodetemplatesSyntacticSequencer extends AbstractSyntacticSequencer {

	protected CodetemplatesGrammarAccess grammarAccess;
	protected AbstractElementAlias match_TemplateBodyWithQuotes_WSTerminalRuleCall_0_q;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_2_1_0_1_a;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_2_1_2_a;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_2_1_4_0_a;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_2_1_4_2_a;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_2_1_4_3_1_0_a;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_2_1_4_3_1_2_a;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_2_1_4_3_2_a;
	protected AbstractElementAlias match_Variable_WSTerminalRuleCall_3_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CodetemplatesGrammarAccess) access;
		match_TemplateBodyWithQuotes_WSTerminalRuleCall_0_q = new TokenAlias(false, true, grammarAccess.getTemplateBodyWithQuotesAccess().getWSTerminalRuleCall_0());
		match_Variable_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_1());
		match_Variable_WSTerminalRuleCall_2_1_0_1_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1());
		match_Variable_WSTerminalRuleCall_2_1_2_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2());
		match_Variable_WSTerminalRuleCall_2_1_4_0_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0());
		match_Variable_WSTerminalRuleCall_2_1_4_2_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2());
		match_Variable_WSTerminalRuleCall_2_1_4_3_1_0_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0());
		match_Variable_WSTerminalRuleCall_2_1_4_3_1_2_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2());
		match_Variable_WSTerminalRuleCall_2_1_4_3_2_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2());
		match_Variable_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getVariableAccess().getWSTerminalRuleCall_3());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal WS			: (' '|'\t'|'\r'|'\n')+;
	 */
	protected String getWSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return " ";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_TemplateBodyWithQuotes_WSTerminalRuleCall_0_q.equals(syntax))
				emit_TemplateBodyWithQuotes_WSTerminalRuleCall_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_1_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_2_1_0_1_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_2_1_0_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_2_1_2_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_2_1_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_2_1_4_0_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_2_1_4_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_2_1_4_2_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_2_1_4_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_2_1_4_3_1_0_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_2_1_4_3_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_2_1_4_3_1_2_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_2_1_4_3_1_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_2_1_4_3_2_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_2_1_4_3_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Variable_WSTerminalRuleCall_3_a.equals(syntax))
				emit_Variable_WSTerminalRuleCall_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '&gt;&gt;' '&lt;&lt;' (rule start)
	 *     (rule start) (ambiguity) '&gt;&gt;' parts+=Literal
	 *     (rule start) (ambiguity) '&gt;&gt;' parts+=VariableOrDollar
	 
	 * </pre>
	 */
	protected void emit_TemplateBodyWithQuotes_WSTerminalRuleCall_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '${' (ambiguity) ':' WS* type=ValidID
	 *     (rule start) '${' (ambiguity) name=ValidID
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ValidID (ambiguity) ':' WS* type=ValidID
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_2_1_0_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '${' WS* ':' (ambiguity) type=ValidID
	 *     name=ValidID WS* ':' (ambiguity) type=ValidID
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_2_1_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     type=ValidID (ambiguity) expectingParameters?='('
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_2_1_4_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     expectingParameters?='(' (ambiguity) ')' WS* '}' (rule end)
	 *     expectingParameters?='(' (ambiguity) parameters+=FQN
	 *     expectingParameters?='(' (ambiguity) parameters+=STRING
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_2_1_4_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     parameters+=FQN (ambiguity) ',' WS* parameters+=FQN
	 *     parameters+=FQN (ambiguity) ',' WS* parameters+=STRING
	 *     parameters+=STRING (ambiguity) ',' WS* parameters+=FQN
	 *     parameters+=STRING (ambiguity) ',' WS* parameters+=STRING
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_2_1_4_3_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     parameters+=FQN WS* ',' (ambiguity) parameters+=FQN
	 *     parameters+=FQN WS* ',' (ambiguity) parameters+=STRING
	 *     parameters+=STRING WS* ',' (ambiguity) parameters+=FQN
	 *     parameters+=STRING WS* ',' (ambiguity) parameters+=STRING
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_2_1_4_3_1_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     parameters+=FQN (ambiguity) ')' WS* '}' (rule end)
	 *     parameters+=STRING (ambiguity) ')' WS* '}' (rule end)
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_2_1_4_3_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     expectingParameters?='(' WS* ')' (ambiguity) '}' (rule end)
	 *     name=ValidID (ambiguity) '}' (rule end)
	 *     parameters+=FQN WS* ')' (ambiguity) '}' (rule end)
	 *     parameters+=STRING WS* ')' (ambiguity) '}' (rule end)
	 *     type=ValidID (ambiguity) '}' (rule end)
	 
	 * </pre>
	 */
	protected void emit_Variable_WSTerminalRuleCall_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
