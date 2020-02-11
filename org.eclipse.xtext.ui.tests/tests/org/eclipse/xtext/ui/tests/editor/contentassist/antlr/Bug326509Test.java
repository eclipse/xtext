/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.antlr;

import org.antlr.runtime.BitSet;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug326509Test extends Assert {

	public static class TestableParser extends AbstractInternalContentAssistParser {

		public TestableParser() {
			super(null);
		}
		
		public BitSet[] getFollowing() {
			return state.following;
		}
		
		@Override
		public void pushFollow(BitSet bitSet) {
			super.pushFollow(bitSet);
		}

		@Override
		protected Grammar getGrammar() {
			return null;
		}
		
	}
	
	private TestableParser testMe;
	
	@Before
	public void setUp() throws Exception {
		testMe = new TestableParser();
	}
	
	@Test public void testBug326509() {
		for(int i = 0; i <= 200; i++) {
			testMe.pushFollow(new BitSet());
		}
		BitSet[] following = testMe.getFollowing();
		for(int i = 0; i < following.length && i <= 200; i++) {
			assertNotNull(Integer.toString(i), following[i]);
		}
	}
	
}
