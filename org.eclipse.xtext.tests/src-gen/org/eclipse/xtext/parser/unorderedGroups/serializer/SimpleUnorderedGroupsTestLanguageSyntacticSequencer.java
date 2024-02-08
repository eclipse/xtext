/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleUnorderedGroupsTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SimpleUnorderedGroupsTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SimpleUnorderedGroupsTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Model_Bug302585Keyword_1_16_0_or_DigitFiveKeyword_1_4_0_or_DigitFourKeyword_1_3_0_or_DigitOneDigitOneKeyword_1_10_0_or_DigitOneDigitZeroKeyword_1_9_0_or_DigitSevenKeyword_1_6_0_or_DigitSixKeyword_1_5_0_or_DigitThreeKeyword_1_2_0;
	protected AbstractElementAlias match_UnorderedSerialization_DigitOneKeyword_1_0_0_0_a;
	protected AbstractElementAlias match_UnorderedSerialization_DigitOneKeyword_1_0_0_0_p;
	protected AbstractElementAlias match_UnorderedSerialization___DigitOneKeyword_1_0_0_0_p_or_DigitThreeKeyword_1_2_0_or_DigitTwoKeyword_1_1_0__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SimpleUnorderedGroupsTestLanguageGrammarAccess) access;
		match_Model_Bug302585Keyword_1_16_0_or_DigitFiveKeyword_1_4_0_or_DigitFourKeyword_1_3_0_or_DigitOneDigitOneKeyword_1_10_0_or_DigitOneDigitZeroKeyword_1_9_0_or_DigitSevenKeyword_1_6_0_or_DigitSixKeyword_1_5_0_or_DigitThreeKeyword_1_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getModelAccess().getBug302585Keyword_1_16_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getDigitFiveKeyword_1_4_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getDigitFourKeyword_1_3_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getDigitOneDigitOneKeyword_1_10_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getDigitOneDigitZeroKeyword_1_9_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getDigitSevenKeyword_1_6_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getDigitSixKeyword_1_5_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getDigitThreeKeyword_1_2_0()));
		match_UnorderedSerialization_DigitOneKeyword_1_0_0_0_a = new TokenAlias(true, true, grammarAccess.getUnorderedSerializationAccess().getDigitOneKeyword_1_0_0_0());
		match_UnorderedSerialization_DigitOneKeyword_1_0_0_0_p = new TokenAlias(true, false, grammarAccess.getUnorderedSerializationAccess().getDigitOneKeyword_1_0_0_0());
		match_UnorderedSerialization___DigitOneKeyword_1_0_0_0_p_or_DigitThreeKeyword_1_2_0_or_DigitTwoKeyword_1_1_0__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getUnorderedSerializationAccess().getDigitThreeKeyword_1_2_0()), new TokenAlias(false, false, grammarAccess.getUnorderedSerializationAccess().getDigitTwoKeyword_1_1_0()), new TokenAlias(true, false, grammarAccess.getUnorderedSerializationAccess().getDigitOneKeyword_1_0_0_0()));
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
			if (match_Model_Bug302585Keyword_1_16_0_or_DigitFiveKeyword_1_4_0_or_DigitFourKeyword_1_3_0_or_DigitOneDigitOneKeyword_1_10_0_or_DigitOneDigitZeroKeyword_1_9_0_or_DigitSevenKeyword_1_6_0_or_DigitSixKeyword_1_5_0_or_DigitThreeKeyword_1_2_0.equals(syntax))
				emit_Model_Bug302585Keyword_1_16_0_or_DigitFiveKeyword_1_4_0_or_DigitFourKeyword_1_3_0_or_DigitOneDigitOneKeyword_1_10_0_or_DigitOneDigitZeroKeyword_1_9_0_or_DigitSevenKeyword_1_6_0_or_DigitSixKeyword_1_5_0_or_DigitThreeKeyword_1_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_UnorderedSerialization_DigitOneKeyword_1_0_0_0_a.equals(syntax))
				emit_UnorderedSerialization_DigitOneKeyword_1_0_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_UnorderedSerialization_DigitOneKeyword_1_0_0_0_p.equals(syntax))
				emit_UnorderedSerialization_DigitOneKeyword_1_0_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_UnorderedSerialization___DigitOneKeyword_1_0_0_0_p_or_DigitThreeKeyword_1_2_0_or_DigitTwoKeyword_1_1_0__q.equals(syntax))
				emit_UnorderedSerialization___DigitOneKeyword_1_0_0_0_p_or_DigitThreeKeyword_1_2_0_or_DigitTwoKeyword_1_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     (
	  *         '3' | 
	  *         '4' | 
	  *         '5' | 
	  *         '6' | 
	  *         '7' | 
	  *         '10' | 
	  *         '11' | 
	  *         'bug302585'
	  *     )
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 
	 * </pre>
	 */
	protected void emit_Model_Bug302585Keyword_1_16_0_or_DigitFiveKeyword_1_4_0_or_DigitFourKeyword_1_3_0_or_DigitOneDigitOneKeyword_1_10_0_or_DigitOneDigitZeroKeyword_1_9_0_or_DigitSevenKeyword_1_6_0_or_DigitSixKeyword_1_5_0_or_DigitThreeKeyword_1_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '1'*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) forth?='d'
	 *     (rule start) (ambiguity) second?='b'
	 *     (rule start) (ambiguity) third?='c'
	 *     first?='a' (ambiguity) (rule end)
	 *     first?='a' (ambiguity) forth?='d'
	 *     first?='a' (ambiguity) second?='b'
	 *     first?='a' (ambiguity) third?='c'
	 *     forth?='d' (ambiguity) (rule end)
	 *     forth?='d' (ambiguity) forth?='d'
	 *     forth?='d' (ambiguity) second?='b'
	 *     forth?='d' (ambiguity) third?='c'
	 *     second?='b' (ambiguity) (rule end)
	 *     second?='b' (ambiguity) forth?='d'
	 *     second?='b' (ambiguity) second?='b'
	 *     second?='b' (ambiguity) third?='c'
	 *     third?='c' (ambiguity) (rule end)
	 *     third?='c' (ambiguity) forth?='d'
	 *     third?='c' (ambiguity) second?='b'
	 *     third?='c' (ambiguity) third?='c'
	 
	 * </pre>
	 */
	protected void emit_UnorderedSerialization_DigitOneKeyword_1_0_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '1'+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) first?='a'
	 *     first?='a' (ambiguity) first?='a'
	 *     forth?='d' (ambiguity) first?='a'
	 *     second?='b' (ambiguity) first?='a'
	 *     third?='c' (ambiguity) first?='a'
	 
	 * </pre>
	 */
	protected void emit_UnorderedSerialization_DigitOneKeyword_1_0_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('1'+ | '2' | '3')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 
	 * </pre>
	 */
	protected void emit_UnorderedSerialization___DigitOneKeyword_1_0_0_0_p_or_DigitThreeKeyword_1_2_0_or_DigitTwoKeyword_1_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
