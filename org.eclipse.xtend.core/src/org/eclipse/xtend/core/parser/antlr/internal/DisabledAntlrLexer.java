/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.parser.antlr.internal;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DisabledAntlrLexer extends InternalXtendLexer {

	public DisabledAntlrLexer() {
	}

	public DisabledAntlrLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}

	public DisabledAntlrLexer(CharStream input) {
		super(input);
	}

	@Override
	public Token nextToken() {
		throw new UnsupportedOperationException("Missing binding or override");
	}
	
}
