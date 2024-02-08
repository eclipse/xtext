/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.services.Bug299395TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class Bug299395TestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected Bug299395TestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Model___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__a;
	protected AbstractElementAlias match_Model___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__a;
	protected AbstractElementAlias match_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__a;
	protected AbstractElementAlias match_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__p;
	protected AbstractElementAlias match_Model___RightSquareBracketKeyword_2_2_LeftSquareBracketKeyword_2_0__a;
	protected AbstractElementAlias match_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__a;
	protected AbstractElementAlias match_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (Bug299395TestLanguageGrammarAccess) access;
		match_Model___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2()));
		match_Model___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getModelAccess().getLeftSquareBracketKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getRightSquareBracketKeyword_2_2()));
		match_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2()), new TokenAlias(false, false, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0()));
		match_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__p = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2()), new TokenAlias(false, false, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0()));
		match_Model___RightSquareBracketKeyword_2_2_LeftSquareBracketKeyword_2_0__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getModelAccess().getRightSquareBracketKeyword_2_2()), new TokenAlias(false, false, grammarAccess.getModelAccess().getLeftSquareBracketKeyword_2_0()));
		match_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getSubModelAccess().getDigitOneKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getSubModelAccess().getDigitTwoKeyword_1_1()));
		match_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__p = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getSubModelAccess().getDigitOneKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getSubModelAccess().getDigitTwoKeyword_1_1()));
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
			if (match_Model___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__a.equals(syntax))
				emit_Model___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__a.equals(syntax))
				emit_Model___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__a.equals(syntax))
				emit_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__p.equals(syntax))
				emit_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model___RightSquareBracketKeyword_2_2_LeftSquareBracketKeyword_2_0__a.equals(syntax))
				emit_Model___RightSquareBracketKeyword_2_2_LeftSquareBracketKeyword_2_0__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__a.equals(syntax))
				emit_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__p.equals(syntax))
				emit_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('{' '}')*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '[' (']' '[')* keys+=STRING
	 *     (rule start) (ambiguity) ('[' ']')* 'subModel' subModel=SubModel
	 *     (rule start) (ambiguity) ('[' ']')* (rule start)
	 *     strings+=STRING '}' (ambiguity) '[' (']' '[')* keys+=STRING
	 *     strings+=STRING '}' (ambiguity) ('[' ']')* 'subModel' subModel=SubModel
	 *     strings+=STRING '}' (ambiguity) ('[' ']')* (rule end)
	 
	 * </pre>
	 */
	protected void emit_Model___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('[' ']')*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) ('{' '}')* (ambiguity) 'subModel' subModel=SubModel
	 *     (rule start) ('{' '}')* (ambiguity) (rule start)
	 *     strings+=STRING '}' ('{' '}')* (ambiguity) 'subModel' subModel=SubModel
	 *     strings+=STRING '}' ('{' '}')* (ambiguity) (rule end)
	 *     values+=STRING ']' (ambiguity) 'subModel' subModel=SubModel
	 *     values+=STRING ']' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_Model___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('}' '{')*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '{' (ambiguity) strings+=STRING
	 
	 * </pre>
	 */
	protected void emit_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('}' '{')+
	 *
	 * This ambiguous syntax occurs at:
	 *     strings+=STRING (ambiguity) strings+=STRING
	 
	 * </pre>
	 */
	protected void emit_Model___RightCurlyBracketKeyword_1_2_LeftCurlyBracketKeyword_1_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     (']' '[')*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) ('{' '}')* '[' (ambiguity) keys+=STRING
	 *     strings+=STRING '}' ('{' '}')* '[' (ambiguity) keys+=STRING
	 *     values+=STRING (ambiguity) keys+=STRING
	 
	 * </pre>
	 */
	protected void emit_Model___RightSquareBracketKeyword_2_2_LeftSquareBracketKeyword_2_0__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('1' '2')*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 *     strings+=STRING (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('1' '2')+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) strings+=STRING
	 *     strings+=STRING (ambiguity) strings+=STRING
	 
	 * </pre>
	 */
	protected void emit_SubModel___DigitOneKeyword_1_0_DigitTwoKeyword_1_1__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
