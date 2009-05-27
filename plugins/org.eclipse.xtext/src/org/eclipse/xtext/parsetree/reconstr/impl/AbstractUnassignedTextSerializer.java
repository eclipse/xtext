package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.reconstr.IUnassignedTextSerializer;

public class AbstractUnassignedTextSerializer implements
		IUnassignedTextSerializer {

	public String serializeUnassignedRuleCall(RuleCall ruleCall, EObject current) {
		throw new RuntimeException(
				"Could not determine the value for the unassigned rulecall of rule "
						+ ruleCall.getRule().getName()
						+ " from within rule "
						+ GrammarUtil.containingRule(ruleCall).getName()
						+ ". You might want to implement IUnassignedTextSerializer or modify your implementation to handle this rulecall.");
	}

}
