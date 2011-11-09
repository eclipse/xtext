package org.eclipse.xtext.validation.serializer;

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
import org.eclipse.xtext.validation.services.ConcreteSyntaxValidationTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractConcreteSyntaxValidationTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_StaticSimplification_Kw1Keyword_1_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ConcreteSyntaxValidationTestLanguageGrammarAccess) access;
		match_StaticSimplification_Kw1Keyword_1_0_q = new TokenAlias(false, true, grammarAccess.getStaticSimplificationAccess().getKw1Keyword_1_0());
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
			if(match_StaticSimplification_Kw1Keyword_1_0_q.equals(syntax))
				emit_StaticSimplification_Kw1Keyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'kw1'?
	 */
	protected void emit_StaticSimplification_Kw1Keyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
