/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuleFilter {

	private boolean discardUnreachableRules;

	private boolean discardTerminalRules;

	private boolean discardRuleTypeRef = true;

	public List<AbstractRule> getRules(Grammar grammar) {
		return GrammarUtil.allRules(grammar);
	}

	public boolean isDiscardUnreachableRules() {
		return discardUnreachableRules;
	}

	public void setDiscardUnreachableRules(boolean discardUnreachableRules) {
		this.discardUnreachableRules = discardUnreachableRules;
	}

	public boolean isDiscardTerminalRules() {
		return discardTerminalRules;
	}

	public void setDiscardTerminalRules(boolean discardTerminalRules) {
		this.discardTerminalRules = discardTerminalRules;
	}

	public boolean isDiscardRuleTypeRef() {
		return discardRuleTypeRef;
	}

	public void setDiscardRuleTypeRef(boolean discardRuleTypeRef) {
		this.discardRuleTypeRef = discardRuleTypeRef;
	}

}
