/**
 * Copyright (c) 2014, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.IParser;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@Singleton
public class AbstractAntlrParserBasedTokenSourceProvider extends AbstractTokenSourceProvider {
	@Inject
	private IParser parser;

	@Override
	public TokenSource createTokenSource(CharStream stream) {
		if (parser instanceof AbstractAntlrParser) {
			return ((AbstractAntlrParser) parser).createLexer(stream);
		}
		String msg = parser.getClass().getName() + " should be a subclass of " + AbstractAntlrParser.class.getName();
		throw new IllegalStateException(msg);
	}
}
