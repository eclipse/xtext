/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;

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
public class LexerProvider<T extends Lexer> implements Provider<T> {

	private final Class<T> clazz;

	public static <T extends Lexer> LexerProvider<T> create(Class<T> clazz) {
		return new LexerProvider<T>(clazz);
	}
	
	public LexerProvider(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * Creates a lexer instance via reflection. The object is not created with the default
	 * constructor because it will not initialize the backtracking state of the lexer.
	 * Instead, we pass <code>null</code> as CharStream argument.
	 */
	@Override
	public T get() {
		try {
			return clazz.getConstructor(CharStream.class).newInstance(new Object[] { null });
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
