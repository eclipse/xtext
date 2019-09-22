/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.parser.antlr;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.example.homeautomation.parser.antlr.internal.InternalRuleEngineParser;
import org.eclipse.xtext.parser.antlr.AbstractIndentationTokenSource;

public class RuleEngineTokenSource extends AbstractIndentationTokenSource {

	public RuleEngineTokenSource(TokenSource delegate) {
		super(delegate);
	}

	@Override
	protected boolean shouldSplitTokenImpl(Token token) {
		return token.getType() == InternalRuleEngineParser.RULE_WS;
	}

	@Override
	protected int getBeginTokenType() {
		return InternalRuleEngineParser.RULE_BEGIN;
	}

	@Override
	protected int getEndTokenType() {
		return InternalRuleEngineParser.RULE_END;
	}

}
