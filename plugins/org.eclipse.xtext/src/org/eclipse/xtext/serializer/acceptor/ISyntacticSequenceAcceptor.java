package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;

/**
 * This interface is a call-back that is being invoked when the ISequenceParser walks through a sequence of tokens.
 * 
 * The events signaled to this interface occur in the same order as if an ordinary parser would parse the sequence of
 * tokens.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISyntacticSequenceAcceptor extends IUnassignedTokenSequenceAcceptor {

	void acceptAssignedAction(Action action, EObject semanticChild, ICompositeNode node);

	void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild, ICompositeNode node);

	void enterUnassignedParserRuleCall(RuleCall rc);

	void finish();

	void leaveUnssignedParserRuleCall(RuleCall rc);

}
