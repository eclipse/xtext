package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

public interface IParseTreeConstructorCallback {
	void parserRuleCallStart(IInstanceDescription current, RuleCall call);
	void parserRuleCallEnd();
	void objectCreation(IInstanceDescription current);
	void lexerRuleCall(IInstanceDescription current, RuleCall call);
	void keywordCall(IInstanceDescription current, Keyword call);
	void actionCall(IInstanceDescription oldCurrent,IInstanceDescription newCurrent, Action action);
}
