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
import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerProviderTest extends Assert {

	public static class MyLexer extends Lexer {

		private boolean initialized;

		public MyLexer() {
			super();
			initialized = false;
		}

		public MyLexer(CharStream input) {
			super(input);
			initialized = true;
		}
		
		@Override
		public void mTokens() throws RecognitionException {
			throw new RecognitionException();
		}
		
	}

	private LexerProvider<MyLexer> provider;
	
	@Before
	public void setUp() throws Exception {
		this.provider = new LexerProvider<MyLexer>(MyLexer.class);
	}
	
	@After
	public void tearDown() throws Exception {
		this.provider = null;
	}
	
	@Test public void testResultNotNull() {
		Lexer lexer = provider.get();
		assertNotNull("lexer", lexer);
	}
	
	@Test public void testResultIsMyLexer() {
		Lexer lexer = provider.get();
		assertTrue("lexer instanceof MyLexer", lexer instanceof MyLexer);
	}
	
	@Test public void testResultIsInitialized() {
		MyLexer lexer = provider.get();
		assertTrue("lexer.initialized", lexer.initialized);
	}
	
	@Test public void testSetup() {
		assertTrue("MyLexer(null).initialized", new MyLexer(null).initialized);
		assertFalse("MyLexer().initialized", new MyLexer().initialized);
	}
}
