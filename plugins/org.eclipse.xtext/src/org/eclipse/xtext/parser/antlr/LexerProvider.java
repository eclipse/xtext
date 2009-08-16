/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.CharStream;

import com.google.inject.Provider;

/**
 * A Guice provider implementation, that does not use the default constructor of 
 * the lexer class, but call the other available constructor that takes a CharStream as argument.
 * This provider is a workaround for a bug in ANTLR that leads to partially initialized
 * Lexer instances. They may cause NullPointerExceptions in some rare situations, when
 * backtracking is involved.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerProvider implements Provider<Lexer> {

	private final Class<? extends Lexer> clazz;

	public LexerProvider(Class<? extends Lexer> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * Creates a lexer instance via reflection. The object is not created with the default
	 * constructor because it will not initialize the backtracking state of the lexer.
	 * Instead, we pass <code>null</code> as CharStream argument.
	 */
	public Lexer get() {
		try {
			return clazz.getConstructor(CharStream.class).newInstance(new Object[] { null });
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
