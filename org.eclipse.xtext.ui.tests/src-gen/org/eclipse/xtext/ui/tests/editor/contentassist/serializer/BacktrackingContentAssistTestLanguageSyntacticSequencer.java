/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.serializer;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.BacktrackingContentAssistTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class BacktrackingContentAssistTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected BacktrackingContentAssistTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Definition___LeftParenthesisKeyword_5_0_RightParenthesisKeyword_5_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (BacktrackingContentAssistTestLanguageGrammarAccess) access;
		match_Definition___LeftParenthesisKeyword_5_0_RightParenthesisKeyword_5_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2()));
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
			if (match_Definition___LeftParenthesisKeyword_5_0_RightParenthesisKeyword_5_2__q.equals(syntax))
				emit_Definition___LeftParenthesisKeyword_5_0_RightParenthesisKeyword_5_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     constrainedName=Identifier (ambiguity) ':' '=' expression=Expression
	 *     constrainedName=Identifier (ambiguity) ':' type=TypeExp
	 
	 * </pre>
	 */
	protected void emit_Definition___LeftParenthesisKeyword_5_0_RightParenthesisKeyword_5_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
