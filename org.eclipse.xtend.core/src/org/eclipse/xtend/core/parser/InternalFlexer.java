/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.IOException;
import java.io.Reader;

/**
 * Public interface of JFlex based lexers.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface InternalFlexer {

	/**
	 * Consume the next token and return its type.
	 * Length and text are available via {@link #getTokenLength()}
	 * and {@link #getTokenText()} afterwards.
	 * 
	 * EOF is indicated by the value {@code -1}.
	 */
	int advance() throws IOException;
	
	/**
	 * The length of the previously consumed token.
	 */
	int getTokenLength();

	/**
	 * The text of the previously consumed token.
	 */
	String getTokenText();

	/**
	 * Allows to reuse the current lexer.
	 */
	void yyreset(Reader reader);

}
