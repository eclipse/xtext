/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import static org.eclipse.xtext.util.Tuples.*;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentToken;
import org.eclipse.xtext.ui.editor.model.PartitionTokenScanner;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PartitionTokenScannerTest extends TestCase {
	@SuppressWarnings("unchecked")
	public void testWholePart() throws Exception {
		PartitionTokenScanner scanner = getPartitionTokenScanner(pair(2, 3),pair(4,3),pair(2,1),pair(34,3));
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
	
	@SuppressWarnings("unchecked")
	public void testMiddlePart() throws Exception {
		PartitionTokenScanner scanner = getPartitionTokenScanner(pair(2, 3),pair(4,3),pair(2,1),pair(34,3));
		scanner.setPartialRange(null, 6, 2, "1", 6);
		
		assertEquals("1",scanner.nextToken().getData());
		assertEquals(6,scanner.getTokenOffset());
		assertEquals(2,scanner.getTokenLength());
		
		assertSame(Token.EOF, scanner.nextToken());
	}
	
	
	public PartitionTokenScanner getPartitionTokenScanner(Pair<Integer,Integer>... tokenDescs) throws Exception {
		final List<IXtextDocumentToken> tokens = Lists.newArrayList();
		for (final Pair<Integer, Integer> td : tokenDescs) {
			tokens.add(new IXtextDocumentToken() {

				public int getLength() {
					return td.getFirst();
				}

				public int getAntlrTokenType() {
					return td.getSecond();
				}
			});
		}
		PartitionTokenScanner tokenScanner = new PartitionTokenScanner(){
			@Override
			protected List<? extends IXtextDocumentToken> getTokens(IDocument document) {
				return tokens;
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
