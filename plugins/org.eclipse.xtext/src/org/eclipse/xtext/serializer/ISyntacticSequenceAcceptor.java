package org.eclipse.xtext.serializer;

import org.eclipse.xtext.RuleCall;

/**
 * This interface is a call-back that is being invoked when the ISequenceParser walks through a sequence of tokens.
 * 
 * The events signaled to this interface occur in the same order as if an ordinary parser would parse the sequence of
 * tokens.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISyntacticSequenceAcceptor extends ISemanticSequenceAcceptor, IUnassignedTokenSequenceAcceptor {

	void enterUnassignedParserRuleCall(RuleCall rc);

	void leaveUnssignedParserRuleCall(RuleCall rc);

}
