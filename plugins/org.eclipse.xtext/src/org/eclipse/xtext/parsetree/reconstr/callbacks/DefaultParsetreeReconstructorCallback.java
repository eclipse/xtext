package org.eclipse.xtext.parsetree.reconstr.callbacks;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback;

public class DefaultParsetreeReconstructorCallback implements IParseTreeConstructorCallback {

	public void actionCall(IInstanceDescription oldCurrent, IInstanceDescription newCurrent, Action action) {
	}

	public void keywordCall(IInstanceDescription current, Keyword call) {
	}

	public void lexerRuleCall(IInstanceDescription current, RuleCall call) {
	}

	public void objectCreation(IInstanceDescription current) {
	}

	public void parserRuleCallEnd() {
	}

	public void parserRuleCallStart(IInstanceDescription current, RuleCall call) {
	}

}
