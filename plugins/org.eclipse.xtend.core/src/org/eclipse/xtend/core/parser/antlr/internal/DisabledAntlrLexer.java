/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		throw new UnsupportedOperationException("Missing binding or override");
	}

	public DisabledAntlrLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
		throw new UnsupportedOperationException("Missing binding or override");
	}

	public DisabledAntlrLexer(CharStream input) {
		super(input);
		throw new UnsupportedOperationException("Missing binding or override");
	}

	@Override
	public Token nextToken() {
		throw new UnsupportedOperationException("Missing binding or override");
	}
	
}
