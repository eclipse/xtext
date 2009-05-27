package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;

public class DefaultUnassignedTextSerializer extends
		AbstractUnassignedTextSerializer {

	protected String serializeByRuleCall(RuleCall ruleCall, EObject current) {
		// Sorry, but there is no generic default implementation for this yet.
		return null;
	}

	protected String serializeByRule(AbstractRule rule, EObject current) {
		// Sorry, but there is no generic default implementation for this yet.
		// A valid implementation would be to automatically derive a valid value
		// for the called rule.
		return null;
	}

	public final String serializeUnassignedRuleCall(RuleCall rc, EObject current) {
		String r = serializeByRuleCall(rc, current);
		if (r != null)
			return r;
		r = serializeByRule(rc.getRule(), current);
		if (r != null)
			return r;
		return super.serializeUnassignedRuleCall(rc, current);
	}

}
