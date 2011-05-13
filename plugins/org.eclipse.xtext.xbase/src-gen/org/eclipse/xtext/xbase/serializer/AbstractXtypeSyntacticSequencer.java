package org.eclipse.xtext.xbase.serializer;

import org.eclipse.emf.ecore.EObject;
import com.google.inject.Inject;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.serializer.impl.AbstractSyntacticSequencer;
import org.eclipse.xtext.serializer.analysis.NfaToGrammar.AbstractElementAlias;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;
import org.eclipse.xtext.RuleCall;

@SuppressWarnings("restriction")
public class AbstractXtypeSyntacticSequencer extends AbstractSyntacticSequencer {

	protected XtypeGrammarAccess grammarAccess;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (XtypeGrammarAccess) access;
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		acceptNodes(transition, fromNode, toNode);
	}

}
