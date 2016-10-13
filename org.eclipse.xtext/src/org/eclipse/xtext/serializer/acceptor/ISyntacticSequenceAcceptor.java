package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISyntacticSequenceAcceptor extends ISemanticSequenceAcceptor {

	@Deprecated // no longer supported
	void enterUnassignedParserRuleCall(RuleCall rc);

	@Deprecated // no longer supported
	void leaveUnssignedParserRuleCall(RuleCall rc);

	void acceptUnassignedAction(Action action);

	void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node);

	void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node);

	void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node);

	void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node);
}
