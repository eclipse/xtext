/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DatatypeRuleTokenTest extends TestCase {
	
	private static final int TOKEN_TYPE = Integer.MIN_VALUE;
	
	public void testConstructor() {
		DatatypeRuleToken token = new DatatypeRuleToken();
		assertNull(token.getText());
		assertEquals(DatatypeRuleToken.INITIAL_OFFSET, token.getStartOffset());
		assertEquals(DatatypeRuleToken.INITIAL_OFFSET, token.getExpectedOffset());
		assertEquals("DatatypeRuleToken{\n\tstartOffset: -1\n\texpectedOffset: -1\n\tbufferValue: ''\n}", token.toString());
	}
	
	public void testSetText() {
		DatatypeRuleToken token = new DatatypeRuleToken();
		token.setText("text");
		assertEquals("text", token.getText());
		token.setText("longerText");
		assertEquals("longerText", token.getText());
		token.setText("text");
		assertEquals("text", token.getText());
		token.setText("");
		assertNull(token.getText());
	}
	
	public void testMergeFirstToken() {
		CommonToken commonToken = new CommonToken(TOKEN_TYPE, "text");
		commonToken.setStartIndex(4);
		DatatypeRuleToken token = new DatatypeRuleToken();
		token.merge(commonToken);
		assertEquals("text", token.getText());
		assertEquals(8, token.getExpectedOffset());
	}
	
	public void testMergeFirstDatatypeRuleToken() {
		DatatypeRuleToken tokenToMerge = new DatatypeRuleToken();
		tokenToMerge.setText("text");
		tokenToMerge.setStartOffset(6);
		DatatypeRuleToken token = new DatatypeRuleToken();
		token.merge(tokenToMerge);
		assertEquals("text", token.getText());
		assertEquals(10, token.getExpectedOffset());
	}
	
	public void testMergeSecondToken() {
		CommonToken tokenToMerge = new CommonToken(TOKEN_TYPE, "ext");
		tokenToMerge.setStartIndex(6);
		DatatypeRuleToken token = new DatatypeRuleToken();
		token.setStartOffset(tokenToMerge.getStartIndex() - 1);
		token.setExpectedOffset(tokenToMerge.getStartIndex());
		token.setText("t");
		token.merge(tokenToMerge);
		assertEquals("text", token.getText());
		assertEquals(9, token.getExpectedOffset());
	}
	
	public void testMergeSecondDatatypeRuleToken() {
		DatatypeRuleToken tokenToMerge = new DatatypeRuleToken();
		tokenToMerge.setText("ext");
		tokenToMerge.setStartOffset(9);
		DatatypeRuleToken token = new DatatypeRuleToken();
		token.setStartOffset(tokenToMerge.getStartOffset() - 1);
		token.setExpectedOffset(tokenToMerge.getStartOffset());
		token.setText("t");
		token.merge(tokenToMerge);
		assertEquals("text", token.getText());
		assertEquals(12, token.getExpectedOffset());
	}
	
	public void testMergeSecondTokenUnmatched() {
		CommonToken tokenToMerge = new CommonToken(TOKEN_TYPE, "ext");
		tokenToMerge.setStartIndex(6);
		DatatypeRuleToken token = new DatatypeRuleToken();
		token.setStartOffset(tokenToMerge.getStartIndex() - 4);
		token.setExpectedOffset(tokenToMerge.getStartIndex() - 3);
		token.setText("t");
		token.merge(tokenToMerge);
		assertEquals("t ext", token.getText());
		assertEquals(9, token.getExpectedOffset());
	}
	
	public void testMergeSecondDatatypeRuleTokenUnmatched() {
		DatatypeRuleToken tokenToMerge = new DatatypeRuleToken();
		tokenToMerge.setText("ext");
		tokenToMerge.setStartOffset(9);
		DatatypeRuleToken token = new DatatypeRuleToken();
		token.setStartOffset(tokenToMerge.getStartOffset() - 4);
		token.setExpectedOffset(tokenToMerge.getStartOffset() - 3);
		token.setText("t");
		token.merge(tokenToMerge);
		assertEquals("t ext", token.getText());
		assertEquals(12, token.getExpectedOffset());
	}

}
