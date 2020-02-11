/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.NoSuchElementException;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TokenAcceptorTest extends Assert {

	private TokenAcceptor tokenAcceptor;
	private int tokenCount;
	private int expectedToken;

	@Before
	public void setUp() throws Exception {
		tokenAcceptor = new TokenAcceptor();
		tokenCount = 0;
		expectedToken = 1;
	}
	
	@After
	public void tearDown() throws Exception {
		tokenAcceptor = null;
		tokenCount = -1;
		expectedToken = -1;
	}
	
	protected Token createToken() {
		tokenCount++;
		return new CommonToken(1, String.valueOf(tokenCount));
	}
	
	protected void accept() {
		Token token = createToken();
		tokenAcceptor.accept(token);
	}
	
	protected void next() {
		Token result = tokenAcceptor.next();
		checkNext(result);
	}

	protected void checkNext(Token token) {
		assertNotNull("Expected: " + expectedToken, token);
		assertEquals(String.valueOf(expectedToken), token.getText());
		expectedToken++;
	}
	
	@Test public void testNextOnEmpty() {
		assertFalse(tokenAcceptor.hasNext());
		try {
			next();
			fail("Expected exception");
		} catch(NoSuchElementException ex) {
			// expected
		}
	}
	
	@Test public void testNextCalledToOften() {
		accept();
		accept();
		next();
		next();
		assertFalse(tokenAcceptor.hasNext());
		try {
			next();
			fail("Expected exception");
		} catch(NoSuchElementException ex) {
			// expected
		}
	}
	
	@Test public void testAlternateCalls() {
		for(int i = 0; i < 10; i++) {
			accept();
			next();
			assertFalse(tokenAcceptor.hasNext());
		}
	}
	
	@Test public void testSubsequentCalls() {
		for(int i = 0; i < 10; i++) {
			accept();
		}
		for(int i = 0; i < 10; i++) {
			next();
		}
		assertFalse(tokenAcceptor.hasNext());
	}
	
	@Test public void testRepeatedSubsequentCalls() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				accept();
			}
			for(int j = 0; j < 10; j++) {
				next();
			}
			assertFalse(tokenAcceptor.hasNext());
		}
	}
	
	private static final int PERF_LOOPS = 100 * 100; // 10 * 1000 * 1000
	private static final int PERF_INNER_LOOPS = 10;
	
	@Test public void testPerformance_01() {
		for(int i = 0; i < PERF_LOOPS; i++) {
			for(int j = 0; j < PERF_INNER_LOOPS; j++) {
				accept();
			}
			for(int j = 0; j < PERF_INNER_LOOPS; j++) {
				next();
			}
		}
	}
	
	@Test public void testPerformance_02() {
		for(int i = 0; i < PERF_LOOPS * PERF_INNER_LOOPS; i++) {
			accept();
			next();
		}
	}
	
	@Test public void testPerformanceNoop() {
		for(int i = 0; i < PERF_LOOPS; i++) {
			for(int j = 0; j < PERF_INNER_LOOPS; j++) {
				Token token = createToken();
				checkNext(token);
			}
		}
	}

}
