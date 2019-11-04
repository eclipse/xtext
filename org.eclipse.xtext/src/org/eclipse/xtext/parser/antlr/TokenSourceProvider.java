/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.antlr;

import java.io.Reader;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;

import com.google.inject.ImplementedBy;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@ImplementedBy(AbstractAntlrParserBasedTokenSourceProvider.class)
public interface TokenSourceProvider {
	TokenSource createTokenSource(CharSequence text);

	TokenSource createTokenSource(Reader reader);

	TokenSource createTokenSource(CharStream stream);
}
