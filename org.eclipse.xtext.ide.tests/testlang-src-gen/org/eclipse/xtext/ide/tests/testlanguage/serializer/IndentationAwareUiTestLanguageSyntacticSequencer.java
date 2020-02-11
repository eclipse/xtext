/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.tests.testlanguage.services.IndentationAwareUiTestLanguageGrammarAccess;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class IndentationAwareUiTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected IndentationAwareUiTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_TreeNode___INDENTTerminalRuleCall_1_0_DEDENTTerminalRuleCall_1_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (IndentationAwareUiTestLanguageGrammarAccess) access;
		match_TreeNode___INDENTTerminalRuleCall_1_0_DEDENTTerminalRuleCall_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0()), new TokenAlias(false, false, grammarAccess.getTreeNodeAccess().getDEDENTTerminalRuleCall_1_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getDEDENTRule())
			return getDEDENTToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getINDENTRule())
			return getINDENTToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * Synthetic terminal rule. The concrete syntax is to be specified by clients.
	 * Defaults to the empty string.
	 */
	protected String getDEDENTToken(EObject semanticObject, RuleCall ruleCall, INode node) { return ""; }
	
	/**
	 * Synthetic terminal rule. The concrete syntax is to be specified by clients.
	 * Defaults to the empty string.
	 */
	protected String getINDENTToken(EObject semanticObject, RuleCall ruleCall, INode node) { return ""; }
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_TreeNode___INDENTTerminalRuleCall_1_0_DEDENTTerminalRuleCall_1_2__q.equals(syntax))
				emit_TreeNode___INDENTTerminalRuleCall_1_0_DEDENTTerminalRuleCall_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     (INDENT DEDENT)?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 */
	protected void emit_TreeNode___INDENTTerminalRuleCall_1_0_DEDENTTerminalRuleCall_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
