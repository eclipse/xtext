package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;

/**
 * This interface is a call-back that is being invoked when the ISequenceParser walks through a sequence of tokens.
 * 
 * The events signaled to this interface occur in the same order as if an ordinary parser would parse the sequence of
 * tokens.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISyntacticSequenceAcceptor extends IAssignedTokenSequenceAcceptor, IUnassignedTokenSequenceAcceptor {

	INode acceptAssignedAction2(Action action, EObject semanticChild);

	INode acceptAssignedParserRuleCall2(RuleCall ruleCall, EObject semanticChild);

	void enterUnassignedParserRuleCall(RuleCall rc);

	void finish(INode node);

	void leaveUnssignedParserRuleCall(RuleCall rc);

}
