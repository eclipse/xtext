/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
