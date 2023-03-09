/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.IGrammarAccess.IParserRuleAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractRuleAwareTerminalConsumer extends TerminalConsumer {

	private AbstractRule rule;

	protected AbstractRuleAwareTerminalConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}

	@Override
	public final AbstractRule getGrammarElement() {
		return rule;
	}

	public void setRule(AbstractRule rule) {
		this.rule = rule;
	}

	public void setRule(IParserRuleAccess ruleAccess) {
		this.rule = ruleAccess.getRule();
	}

	@Override
	protected String getRuleName() {
		return getGrammarElement().getName();
	}

	@Override
	public String toString() {
		return super.toString() + " for rule " + getGrammarElement().getName();
	}

}