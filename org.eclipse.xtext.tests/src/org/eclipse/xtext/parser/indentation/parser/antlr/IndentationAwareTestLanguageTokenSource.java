/*******************************************************************************
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation.parser.antlr;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.AbstractIndentationTokenSource;
import org.eclipse.xtext.parser.indentation.parser.antlr.internal.InternalIndentationAwareTestLanguageParser;

public class IndentationAwareTestLanguageTokenSource extends AbstractIndentationTokenSource {
	
	public IndentationAwareTestLanguageTokenSource(TokenSource delegate) {
		super(delegate);
	}
	
	@Override
	protected boolean shouldSplitTokenImpl(Token token) {
		return token.getType() == InternalIndentationAwareTestLanguageParser.RULE_WS;
	}

	@Override
	protected int getBeginTokenType() {
		return InternalIndentationAwareTestLanguageParser.RULE_INDENT;
	}

	@Override
	protected int getEndTokenType() {
		return InternalIndentationAwareTestLanguageParser.RULE_DEDENT;
	}
	
}
