package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;

/**
 * This interface is a call-back that is being invoked when the ISequenceParser walks through a sequence of tokens.
 * 
 * The events signaled to this interface occur in the same order as if an ordinary parser would parse the sequence of
 * tokens.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IParseEventsAcceptor {

	public interface Provider {
		IParseEventsAcceptor get(ParserRule rule, EObject rootObject);
	}

	void acceptAssignedAction(Action action, EObject newCurrent);

	void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, Object value);

	void acceptAssignedCrossRefTerminal(RuleCall terminalRC, Object value);

	void acceptAssignedDatatype(RuleCall datatypeRC, Object value);

	void acceptAssignedEnum(RuleCall enumRC, Object value);

	void acceptAssignedKeyword(Keyword keyword, String value);

	void acceptAssignedTerminal(RuleCall terminalRC, Object value);

	void acceptUnassignedAction(Action action);

	void acceptUnassignedDatatype(RuleCall datatypeRC, Object value);

	void acceptUnassignedEnum(RuleCall enumRC, Object value);

	void acceptUnassignedKeyword(Keyword keyword, String value);

	void acceptUnassignedTerminal(RuleCall terminalRC, Object value);

	void enterAssignedParserRuleCall(RuleCall rc, EObject newCurrent);

	void enterUnassignedParserRuleCall(RuleCall rc);

	void finish();

	void leaveAssignedParserRuleCall(RuleCall rc);

	void leaveUnssignedParserRuleCall(RuleCall rc);

}
