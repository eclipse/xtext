/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
