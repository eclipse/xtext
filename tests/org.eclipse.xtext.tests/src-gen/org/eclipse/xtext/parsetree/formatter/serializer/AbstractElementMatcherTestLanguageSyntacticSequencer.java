package org.eclipse.xtext.parsetree.formatter.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractElementMatcherTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ElementMatcherTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Prim_LeftParenthesisKeyword_3_0_a;
	protected AbstractElementAlias match_Prim_LeftParenthesisKeyword_3_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ElementMatcherTestLanguageGrammarAccess) access;
		match_Prim_LeftParenthesisKeyword_3_0_a = new TokenAlias(true, true, grammarAccess.getPrimAccess().getLeftParenthesisKeyword_3_0());
		match_Prim_LeftParenthesisKeyword_3_0_p = new TokenAlias(true, false, grammarAccess.getPrimAccess().getLeftParenthesisKeyword_3_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		return "";
	}
	
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Prim_LeftParenthesisKeyword_3_0_a.equals(syntax))
				emit_Prim_LeftParenthesisKeyword_3_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim_LeftParenthesisKeyword_3_0_p.equals(syntax))
				emit_Prim_LeftParenthesisKeyword_3_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Prim_LeftParenthesisKeyword_3_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Prim_LeftParenthesisKeyword_3_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
