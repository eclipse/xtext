package org.eclipse.xtext.serializer.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractSyntacticSequencerTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SyntacticSequencerTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AmbiguousTransition_Kw1Keyword_1_q;
	protected AbstractElementAlias match_Prim1_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_Prim1_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_Prim2_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_Prim2_LeftParenthesisKeyword_1_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SyntacticSequencerTestLanguageGrammarAccess) access;
		match_AmbiguousTransition_Kw1Keyword_1_q = new TokenAlias(true, false, grammarAccess.getAmbiguousTransitionAccess().getKw1Keyword_1());
		match_Prim1_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getPrim1Access().getLeftParenthesisKeyword_1_0());
		match_Prim1_LeftParenthesisKeyword_1_0_p = new TokenAlias(false, true, grammarAccess.getPrim1Access().getLeftParenthesisKeyword_1_0());
		match_Prim2_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getPrim2Access().getLeftParenthesisKeyword_1_0());
		match_Prim2_LeftParenthesisKeyword_1_0_p = new TokenAlias(false, true, grammarAccess.getPrim2Access().getLeftParenthesisKeyword_1_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getUnassignedDatatypeRuleRule())
			return getUnassignedDatatypeRuleToken(ruleCall, node);
		return "";
	}
	
	protected String getUnassignedDatatypeRuleToken(RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "kw1";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		if(match_AmbiguousTransition_Kw1Keyword_1_q.equals(transition.getAmbiguousSyntax()))
			emit_AmbiguousTransition_Kw1Keyword_1_q(semanticObject, transition, fromNode, toNode);
		else if(match_Prim1_LeftParenthesisKeyword_1_0_a.equals(transition.getAmbiguousSyntax()))
			emit_Prim1_LeftParenthesisKeyword_1_0_a(semanticObject, transition, fromNode, toNode);
		else if(match_Prim1_LeftParenthesisKeyword_1_0_p.equals(transition.getAmbiguousSyntax()))
			emit_Prim1_LeftParenthesisKeyword_1_0_p(semanticObject, transition, fromNode, toNode);
		else if(match_Prim2_LeftParenthesisKeyword_1_0_a.equals(transition.getAmbiguousSyntax()))
			emit_Prim2_LeftParenthesisKeyword_1_0_a(semanticObject, transition, fromNode, toNode);
		else if(match_Prim2_LeftParenthesisKeyword_1_0_p.equals(transition.getAmbiguousSyntax()))
			emit_Prim2_LeftParenthesisKeyword_1_0_p(semanticObject, transition, fromNode, toNode);
		else acceptNodes(transition, fromNode, toNode);
	}

	/**
	 * Syntax:
	 *     'kw1'?
	 */
	protected void emit_AmbiguousTransition_Kw1Keyword_1_q(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Prim1_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Prim1_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Prim2_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Prim2_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
}
