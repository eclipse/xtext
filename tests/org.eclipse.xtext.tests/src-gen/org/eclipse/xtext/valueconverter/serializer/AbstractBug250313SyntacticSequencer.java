package org.eclipse.xtext.valueconverter.serializer;

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
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;

@SuppressWarnings("restriction")
public class AbstractBug250313SyntacticSequencer extends AbstractSyntacticSequencer {

	protected Bug250313GrammarAccess grammarAccess;
	protected AbstractElementAlias match_Model_DigitOneKeyword_0_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (Bug250313GrammarAccess) access;
		match_Model_DigitOneKeyword_0_0_q = new TokenAlias(false, true, grammarAccess.getModelAccess().getDigitOneKeyword_0_0());
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
			if(match_Model_DigitOneKeyword_0_0_q.equals(syntax))
				emit_Model_DigitOneKeyword_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '1'?
	 */
	protected void emit_Model_DigitOneKeyword_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
