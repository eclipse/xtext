/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;

@SuppressWarnings("all")
public class StatemachineSyntacticSequencer extends AbstractSyntacticSequencer {

	protected StatemachineGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Signal_InputSignalParserRuleCall_0_0_or_OutputSignalParserRuleCall_0_1;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (StatemachineGrammarAccess) access;
		match_Signal_InputSignalParserRuleCall_0_0_or_OutputSignalParserRuleCall_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSignalAccess().getInputSignalParserRuleCall_0_0()), new TokenAlias(false, false, grammarAccess.getSignalAccess().getOutputSignalParserRuleCall_0_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getInputSignalRule())
			return getInputSignalToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOutputSignalRule())
			return getOutputSignalToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * InputSignal:
	 * 	'input';
	 */
	protected String getInputSignalToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "input";
	}
	
	/**
	 * OutputSignal:
	 * 	'output';
	 */
	protected String getOutputSignalToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "output";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Signal_InputSignalParserRuleCall_0_0_or_OutputSignalParserRuleCall_0_1.equals(syntax))
				emit_Signal_InputSignalParserRuleCall_0_0_or_OutputSignalParserRuleCall_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     InputSignal | OutputSignal
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'signal' name=ID
	 */
	protected void emit_Signal_InputSignalParserRuleCall_0_0_or_OutputSignalParserRuleCall_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
