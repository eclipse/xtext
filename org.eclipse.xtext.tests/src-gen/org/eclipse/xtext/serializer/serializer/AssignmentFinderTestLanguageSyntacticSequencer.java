/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class AssignmentFinderTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AssignmentFinderTestLanguageGrammarAccess grammarAccess;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AssignmentFinderTestLanguageGrammarAccess) access;
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getEnum1Rule())
			return getEnum1Token(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEnum2Rule())
			return getEnum2Token(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getTerminal1Rule())
			return getTerminal1Token(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getTerminal2Rule())
			return getTerminal2Token(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * enum Enum1 returns TestEnum: lit1;
	 */
	protected String getEnum1Token(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * enum Enum2 returns TestEnum: lit2;
	 */
	protected String getEnum2Token(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal Terminal1: '%' ('A'..'Z')*;
	 */
	protected String getTerminal1Token(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "%";
	}
	
	/**
	 * terminal Terminal2: '%' ('a'..'z')*;
	 */
	protected String getTerminal2Token(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "%";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

}
