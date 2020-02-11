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
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialSerializationTestLanguageGrammarAccess;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class PartialSerializationTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected PartialSerializationTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Node_RefsKeyword_3_0_q;
	protected AbstractElementAlias match_Node_SemicolonKeyword_4_1_or___LeftCurlyBracketKeyword_4_0_0_RightCurlyBracketKeyword_4_0_3__;
	protected AbstractElementAlias match_OptionalValue_Kw1Keyword_1_q;
	protected AbstractElementAlias match_OptionalValue_Kw2Keyword_3_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (PartialSerializationTestLanguageGrammarAccess) access;
		match_Node_RefsKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getNodeAccess().getRefsKeyword_3_0());
		match_Node_SemicolonKeyword_4_1_or___LeftCurlyBracketKeyword_4_0_0_RightCurlyBracketKeyword_4_0_3__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4_0_0()), new TokenAlias(false, false, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_4_0_3())), new TokenAlias(false, false, grammarAccess.getNodeAccess().getSemicolonKeyword_4_1()));
		match_OptionalValue_Kw1Keyword_1_q = new TokenAlias(false, true, grammarAccess.getOptionalValueAccess().getKw1Keyword_1());
		match_OptionalValue_Kw2Keyword_3_q = new TokenAlias(false, true, grammarAccess.getOptionalValueAccess().getKw2Keyword_3());
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
			if (match_Node_RefsKeyword_3_0_q.equals(syntax))
				emit_Node_RefsKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Node_SemicolonKeyword_4_1_or___LeftCurlyBracketKeyword_4_0_0_RightCurlyBracketKeyword_4_0_3__.equals(syntax))
				emit_Node_SemicolonKeyword_4_1_or___LeftCurlyBracketKeyword_4_0_0_RightCurlyBracketKeyword_4_0_3__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_OptionalValue_Kw1Keyword_1_q.equals(syntax))
				emit_OptionalValue_Kw1Keyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_OptionalValue_Kw2Keyword_3_q.equals(syntax))
				emit_OptionalValue_Kw2Keyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'refs'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '#1' (ambiguity) '{' 'ref' ref=[Node|QualifiedName]
	 *     (rule start) '#1' (ambiguity) '{' children+=Node
	 *     (rule start) '#1' (ambiguity) (('{' '}') | ';') (rule start)
	 *     (rule start) (ambiguity) '{' 'ref' ref=[Node|QualifiedName]
	 *     (rule start) (ambiguity) '{' children+=Node
	 *     (rule start) (ambiguity) (('{' '}') | ';') (rule start)
	 *     imports+=Import (ambiguity) '{' 'ref' ref=[Node|QualifiedName]
	 *     imports+=Import (ambiguity) '{' children+=Node
	 *     imports+=Import (ambiguity) (('{' '}') | ';') (rule end)
	 *     name=ID (ambiguity) '{' 'ref' ref=[Node|QualifiedName]
	 *     name=ID (ambiguity) '{' children+=Node
	 *     name=ID (ambiguity) (('{' '}') | ';') (rule end)
	 */
	protected void emit_Node_RefsKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}') | ';'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '#1' 'refs'? (ambiguity) (rule start)
	 *     (rule start) 'refs'? (ambiguity) (rule start)
	 *     imports+=Import 'refs'? (ambiguity) (rule end)
	 *     name=ID 'refs'? (ambiguity) (rule end)
	 *     refs+=[Node|QualifiedName] (ambiguity) (rule end)
	 */
	protected void emit_Node_SemicolonKeyword_4_1_or___LeftCurlyBracketKeyword_4_0_0_RightCurlyBracketKeyword_4_0_3__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'kw1'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '#3' (ambiguity) 'kw2'? (rule start)
	 *     (rule start) '#3' (ambiguity) name=ID
	 *     (rule start) (ambiguity) 'kw2'? (rule start)
	 *     (rule start) (ambiguity) name=ID
	 */
	protected void emit_OptionalValue_Kw1Keyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'kw2'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '#3' 'kw1'? (ambiguity) (rule start)
	 *     (rule start) 'kw1'? (ambiguity) (rule start)
	 *     name=ID (ambiguity) (rule end)
	 */
	protected void emit_OptionalValue_Kw2Keyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
