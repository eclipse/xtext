/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.AbstractIndentationTokenSource;
import org.eclipse.xtext.parser.indentation.parser.antlr.internal.InternalIndentationAwareTestLanguageParser;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IndentationAwareTestLanguageTokenSource extends AbstractIndentationTokenSource {

	public IndentationAwareTestLanguageTokenSource(TokenSource delegate) {
		super();
		setDelegate(delegate);
	}
	
	@Override
	protected boolean shouldSplitTokenImpl(Token token) {
		return token.getType() == InternalIndentationAwareTestLanguageParser.RULE_WS;
	}

	@Override
	protected int getEndTokenType() {
		return InternalIndentationAwareTestLanguageParser.RULE_DEDENT;
	}

	@Override
	protected int getBeginTokenType() {
		return InternalIndentationAwareTestLanguageParser.RULE_INDENT;
	}
	
}
