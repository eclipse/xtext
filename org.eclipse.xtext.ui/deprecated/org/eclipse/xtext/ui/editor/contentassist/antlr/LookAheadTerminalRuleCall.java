/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;

public class LookAheadTerminalRuleCall extends LookAheadTerminal {

	private TerminalRule rule;

	public void setRule(TerminalRule rule) {
		this.rule = rule;
	}

	public TerminalRule getRule() {
		return rule;
	}
	
	@Override
	public boolean matches(AbstractElement element) {
		return (element instanceof RuleCall) && getRule().equals(((RuleCall) element).getRule());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rule == null) ? 0 : rule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LookAheadTerminalRuleCall other = (LookAheadTerminalRuleCall) obj;
		if (rule == null) {
			if (other.rule != null)
				return false;
		}
		else if (!rule.equals(other.rule))
			return false;
		return true;
	}
	
}