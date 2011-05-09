package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * This interface is a call-back that is being invoked when the ISequenceParser walks through a sequence of tokens.
 * 
 * The events signaled to this interface occur in the same order as if an ordinary parser would parse the sequence of
 * tokens.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISyntacticSequenceAcceptor extends ISemanticSequenceAcceptor {

	void enterUnassignedParserRuleCall(RuleCall rc);

	void leaveUnssignedParserRuleCall(RuleCall rc);

	void acceptUnassignedAction(Action action);

	void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node);

	void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node);

	void acceptUnassignedKeyword(Keyword keyword, ILeafNode node);

	void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node);
}
