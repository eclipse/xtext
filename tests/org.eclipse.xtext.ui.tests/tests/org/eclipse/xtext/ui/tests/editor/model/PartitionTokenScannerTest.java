/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.model.PartitionTokenScanner;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PartitionTokenScannerTest extends TestCase {

	public void testWholePart() throws Exception {
		PartitionTokenScanner scanner = getPartitionTokenScanner(t(2, 3),t(4,3),t(2,1),t(34,3));
		scanner.setPartialRange(null, 0, 42, "3", 0);
		
		assertEquals("3",scanner.nextToken().getData());
		assertEquals(0,scanner.getTokenOffset());
		assertEquals(6,scanner.getTokenLength());
		
		assertEquals("1",scanner.nextToken().getData());
		assertEquals(6,scanner.getTokenOffset());
		assertEquals(2,scanner.getTokenLength());
		
		assertEquals("3",scanner.nextToken().getData());
		assertEquals(8,scanner.getTokenOffset());
		assertEquals(34,scanner.getTokenLength());
		
		assertSame(Token.EOF, scanner.nextToken());
	}
	
	public void testMiddlePart() throws Exception {
		PartitionTokenScanner scanner = getPartitionTokenScanner(t(2, 3),t(4,3),t(2,1),t(34,3));
		scanner.setPartialRange(null, 6, 2, "1", 6);
		
		assertEquals("1",scanner.nextToken().getData());
		assertEquals(6,scanner.getTokenOffset());
		assertEquals(2,scanner.getTokenLength());
		
		assertSame(Token.EOF, scanner.nextToken());
	}
	
	
	protected LexerTokenRegion t(int length, int type) {
		return new LexerTokenRegion(length,type);
	}
	
	static class LexerTokenRegion implements ILexerTokenRegion {
		private int offset,length,type;

		public LexerTokenRegion(int length, int type) {
			super();
			this.length = length;
			this.type = type;
		}
		
		public void setOffset(int offset) {
			this.offset = offset;
		}

		public int getLength() {
			return length;
		}

		public int getOffset() {
			return offset;
		}

		public int getLexerTokenType() {
			return type;
		}
		
	}
	
	public PartitionTokenScanner getPartitionTokenScanner(ILexerTokenRegion... tokenDescs) throws Exception {
		final List<ILexerTokenRegion> tokens = Arrays.asList(tokenDescs);
		int offset = 0;
		for (ILexerTokenRegion token : tokens) {
			((LexerTokenRegion)token).setOffset(offset);
			offset+=token.getLength();
		}
		PartitionTokenScanner tokenScanner = new PartitionTokenScanner(){
			@Override
			protected Iterable<ILexerTokenRegion> getTokens(IDocument document) {
				return tokens;
			}
			@Override
			protected boolean shouldMergePartitions(String contentType) {
				return "3".equals(contentType);
			}
		};
		tokenScanner.setMapper(new ITokenTypeToPartitionTypeMapper() {
			
			public String[] getSupportedPartitionTypes() {
				throw new UnsupportedOperationException();
			}
			
			public String getPartitionType(int antlrTokenType) {
				return ""+antlrTokenType;
			}
		});
		return tokenScanner;

	}
}
