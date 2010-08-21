/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextTokenStreamTest extends TestCase implements TokenSource {

	private int tokenCount = 0;
	
	public void testConsumeUntilEOF_large() {
		tokenCount = 25000;
		XtextTokenStream stream = new XtextTokenStream(this, Token.DEFAULT_CHANNEL);
		while(stream.LA(1) != Token.EOF) {
			stream.consume();
			stream.LA(1);
		}
	}
	
	public void testConsumeUntilEOF_small() {
		tokenCount = 25;
		XtextTokenStream stream = new XtextTokenStream(this, Token.DEFAULT_CHANNEL);
		while(stream.LA(1) != Token.EOF) {
			stream.consume();
			stream.LA(1);
		}
	}
	
//	public void test_smallFile_hugeLA() {
//		doTestLookahead(500, 2500);
//	}
//	
//	public void test_avgFile_largeLA() {
//		doTestLookahead(50, 25000);
//	}
//
//	public void test_largeFile_largeLA() {
//		doTestLookahead(50, 2500000);
//	}
//	
//	public void test_largeFile_tinyLA() {
//		doTestLookahead(2, 2500000);
//	}
//	
//	public void test_largeFile_noLA() {
//		doTestLookahead(1, 2500000);
//	}
//	
//	protected void doTestLookahead(int lookAhead, int tokenCount) {
//		this.tokenCount = tokenCount;
//		XtextTokenStream stream = new XtextTokenStream(this, Token.DEFAULT_CHANNEL);
//		while(stream.LA(1) != Token.EOF) {
//			for(int i = 0; i < lookAhead; i++) {
//				for(int j = i + 1; j < lookAhead; j++) {
//					stream.LA(j - i);					
//				}
//				stream.consume();
//			}
//		}
//	}

	public Token nextToken() {
		if (tokenCount == 0)
			return Token.EOF_TOKEN;
		return new CommonToken(tokenCount--, "Text");
	}
	
}
