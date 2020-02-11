/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.contentassist.antlr;

import java.io.StringReader;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.ContentAssistFlexerFactory;
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendParser;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class FlexerBasedPartialXtendContentAssistParser extends PartialXtendContentAssistParser {

	@Inject
	private ITokenDefProvider tokenDefProvider;
	
	@Inject
	private ContentAssistFlexerFactory flexerFactory;
	
	@Override
	protected InternalXtendParser createParser() {
		FlexerBasedInternalContentAssistParser result = new FlexerBasedInternalContentAssistParser(tokenDefProvider);
		result.setGrammarAccess(getGrammarAccess());
		return result;
	}
	
	@Override
	protected TokenSource createLexer(CharStream stream) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected TokenSource createTokenSource(String input) {
		return flexerFactory.createTokenSource(new StringReader(input));
	}
	
}
