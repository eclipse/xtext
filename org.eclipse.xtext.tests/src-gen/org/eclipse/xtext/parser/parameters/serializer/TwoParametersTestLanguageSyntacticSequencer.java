/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.parameters.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.parameters.services.TwoParametersTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class TwoParametersTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected TwoParametersTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ParserRuleParameters_KeywordKeyword_1_10_1_1_1_q;
	protected AbstractElementAlias match_ParserRuleParameters_KeywordKeyword_1_11_1_1_1_q;
	protected AbstractElementAlias match_ParserRuleParameters_KeywordKeyword_1_8_1_1_1_q;
	protected AbstractElementAlias match_ParserRuleParameters_KeywordKeyword_1_9_1_1_1_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (TwoParametersTestLanguageGrammarAccess) access;
		match_ParserRuleParameters_KeywordKeyword_1_10_1_1_1_q = new TokenAlias(false, true, grammarAccess.getParserRuleParametersAccess().getKeywordKeyword_1_10_1_1_1());
		match_ParserRuleParameters_KeywordKeyword_1_11_1_1_1_q = new TokenAlias(false, true, grammarAccess.getParserRuleParametersAccess().getKeywordKeyword_1_11_1_1_1());
		match_ParserRuleParameters_KeywordKeyword_1_8_1_1_1_q = new TokenAlias(false, true, grammarAccess.getParserRuleParametersAccess().getKeywordKeyword_1_8_1_1_1());
		match_ParserRuleParameters_KeywordKeyword_1_9_1_1_1_q = new TokenAlias(false, true, grammarAccess.getParserRuleParametersAccess().getKeywordKeyword_1_9_1_1_1());
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
			if (match_ParserRuleParameters_KeywordKeyword_1_10_1_1_1_q.equals(syntax))
				emit_ParserRuleParameters_KeywordKeyword_1_10_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParserRuleParameters_KeywordKeyword_1_11_1_1_1_q.equals(syntax))
				emit_ParserRuleParameters_KeywordKeyword_1_11_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParserRuleParameters_KeywordKeyword_1_8_1_1_1_q.equals(syntax))
				emit_ParserRuleParameters_KeywordKeyword_1_8_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParserRuleParameters_KeywordKeyword_1_9_1_1_1_q.equals(syntax))
				emit_ParserRuleParameters_KeywordKeyword_1_9_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'keyword'?
	 *
	 * This ambiguous syntax occurs at:
	 *     scenario=Scenario6 (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParserRuleParameters_KeywordKeyword_1_10_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'keyword'?
	 *
	 * This ambiguous syntax occurs at:
	 *     scenario=Scenario6 (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParserRuleParameters_KeywordKeyword_1_11_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'keyword'?
	 *
	 * This ambiguous syntax occurs at:
	 *     scenario=Scenario6 (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParserRuleParameters_KeywordKeyword_1_8_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'keyword'?
	 *
	 * This ambiguous syntax occurs at:
	 *     scenario=Scenario6 (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParserRuleParameters_KeywordKeyword_1_9_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
