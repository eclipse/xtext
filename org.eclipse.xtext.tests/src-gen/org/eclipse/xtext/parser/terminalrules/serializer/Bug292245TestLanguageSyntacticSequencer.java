/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.terminalrules.services.Bug292245TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class Bug292245TestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected Bug292245TestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Model_ERRORKeyword_1_0_q;
	protected AbstractElementAlias match_Model_FIXKeyword_0_0_q;
	protected AbstractElementAlias match_Model_TICKKeyword_2_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (Bug292245TestLanguageGrammarAccess) access;
		match_Model_ERRORKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getModelAccess().getERRORKeyword_1_0());
		match_Model_FIXKeyword_0_0_q = new TokenAlias(false, true, grammarAccess.getModelAccess().getFIXKeyword_0_0());
		match_Model_TICKKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getModelAccess().getTICKKeyword_2_0());
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
			if (match_Model_ERRORKeyword_1_0_q.equals(syntax))
				emit_Model_ERRORKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model_FIXKeyword_0_0_q.equals(syntax))
				emit_Model_FIXKeyword_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model_TICKKeyword_2_0_q.equals(syntax))
				emit_Model_TICKKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'ERROR'?
	 *
	 * This ambiguous syntax occurs at:
	 *     error+=Error (ambiguity) error+=Error
	 
	 * </pre>
	 */
	protected void emit_Model_ERRORKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'FIX'?
	 *
	 * This ambiguous syntax occurs at:
	 *     fix+=Fix (ambiguity) fix+=Fix
	 
	 * </pre>
	 */
	protected void emit_Model_FIXKeyword_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'TICK'?
	 *
	 * This ambiguous syntax occurs at:
	 *     tick+=Apostrophe (ambiguity) tick+=Apostrophe
	 
	 * </pre>
	 */
	protected void emit_Model_TICKKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
