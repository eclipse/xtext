/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import junit.framework.TestCase;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerProviderTest extends TestCase {

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

	private LexerProvider provider;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.provider = new LexerProvider(MyLexer.class);
	}
	
	@Override
	protected void tearDown() throws Exception {
		this.provider = null;
		super.tearDown();
	}
	
	public void testResultNotNull() {
		Lexer lexer = provider.get();
		assertNotNull("lexer", lexer);
	}
	
	public void testResultIsMyLexer() {
		Lexer lexer = provider.get();
		assertTrue("lexer instanceof MyLexer", lexer instanceof MyLexer);
	}
	
	public void testResultIsInitialized() {
		MyLexer lexer = (MyLexer) provider.get();
		assertTrue("lexer.initialized", lexer.initialized);
	}
	
	public void testSetup() {
		assertTrue("MyLexer(null).initialized", new MyLexer(null).initialized);
		assertFalse("MyLexer().initialized", new MyLexer().initialized);
	}
}
