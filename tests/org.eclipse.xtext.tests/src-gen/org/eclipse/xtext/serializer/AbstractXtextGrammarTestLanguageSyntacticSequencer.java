package org.eclipse.xtext.serializer;

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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractXtextGrammarTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected XtextGrammarTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedElement_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (XtextGrammarTestLanguageGrammarAccess) access;
		match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
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
			if(match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_ParenthesizedAssignableElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_ParenthesizedCrossReferenceableElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_ParenthesizedElement_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_ParenthesizedElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_ParenthesizedTerminalElement_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
