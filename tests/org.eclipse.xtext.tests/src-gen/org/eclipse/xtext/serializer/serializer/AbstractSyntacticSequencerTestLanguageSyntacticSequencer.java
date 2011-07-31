package org.eclipse.xtext.serializer.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
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
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getUnassignedDatatypeRuleRule())
			return getUnassignedDatatypeRuleToken(semanticObject, ruleCall, node);
		return "";
	}
	
	protected String getUnassignedDatatypeRuleToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "kw1";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AmbiguousTransition_Kw1Keyword_1_q.equals(syntax))
				emit_AmbiguousTransition_Kw1Keyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim1_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_Prim1_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim1_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_Prim1_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim2_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_Prim2_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim2_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_Prim2_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'kw1'?
	 */
	protected void emit_AmbiguousTransition_Kw1Keyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Prim1_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Prim1_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Prim2_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Prim2_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
