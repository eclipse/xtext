/**
 * Copyright (c) 2014, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.antlr;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
public abstract class AbstractTokenSourceProvider implements TokenSourceProvider {
	protected CharStream getCharStream(Reader reader) {
		try {
			return new ANTLRReaderStream(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected StringReader getReader(CharSequence text) {
		return new StringReader(text.toString());
	}

	@Override
	public TokenSource createTokenSource(CharSequence text) {
		return createTokenSource(getReader(text));
	}

	@Override
	public TokenSource createTokenSource(Reader reader) {
		return createTokenSource(getCharStream(reader));
	}
}
