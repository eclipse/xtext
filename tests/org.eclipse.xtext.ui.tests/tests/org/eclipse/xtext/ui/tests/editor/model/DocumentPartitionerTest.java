/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.XtextAntlrTokenFileProvider;
import org.eclipse.xtext.ui.editor.model.DocumentPartitioner;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.PartitionTokenScanner;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DocumentPartitionerTest extends Assert {

	@Test public void testSimple() throws Exception {
		XtextDocument document = getDocument("/* foo */ bar 345 grammar : so 'baz & so'");
		ITypedRegion partition = document.getPartition(0);
		assertEquals(0, partition.getOffset());
		assertEquals(9, partition.getLength());
		assertEquals(TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION, partition.getType());

		partition = document.getPartition(9);
		assertEquals(9, partition.getOffset());
		assertEquals(22, partition.getLength());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, partition.getType());

		partition = document.getPartition(35);
		assertEquals(31, partition.getOffset());
		assertEquals(10, partition.getLength());
		assertEquals(TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION, partition.getType());
	}
	
	@Test public void testModification() throws Exception {
		XtextDocument document = getDocument("bar 345 grammar : so 'baz & so'");
		document.replace(8, 7, "/*grammar*/");
		ITypedRegion partition = document.getPartition(9);
		assertEquals(8, partition.getOffset());
		assertEquals(11, partition.getLength());
		assertEquals(TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION, partition.getType());
	}
	
	@Test public void testBug401433() throws Exception {
		XtextDocument document = getDocument("     /* */ ");
		document.replace(10, 1, "");
		ITypedRegion partition = document.getPartition(9);
		assertEquals(5, partition.getOffset());
		assertEquals(5, partition.getLength());
		assertEquals(TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION, partition.getType());
		document.replace(9, 1, "");
		partition = document.getPartition(8);
		assertEquals(5, partition.getOffset());
		assertEquals(4, partition.getLength());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, partition.getType());
		document.replace(8, 1, "");
		partition = document.getPartition(7);
		assertEquals(5, partition.getOffset());
		assertEquals(3, partition.getLength());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, partition.getType());
		document.replace(7, 1, "");
		partition = document.getPartition(6);
		assertEquals(5, partition.getOffset());
		assertEquals(2, partition.getLength());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, partition.getType());
		document.replace(6, 1, "");
		partition = document.getPartition(5);
		assertEquals(5, partition.getOffset());
		assertEquals(1, partition.getLength());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, partition.getType());
	}

	public XtextDocument getDocument(String s) {
		TerminalsTokenTypeToPartitionMapper mapper = new TerminalsTokenTypeToPartitionMapper() {{
			setTokenDefProvider(new AntlrTokenDefProvider() {
				{
					setAntlrTokenFileProvider(new XtextAntlrTokenFileProvider());
				}
			});
		}};
		PartitionTokenScanner scanner = new PartitionTokenScanner();
		scanner.setMapper(mapper);
		DocumentPartitioner partitioner = new DocumentPartitioner(scanner, mapper);
		DocumentTokenSource tokenSource = new DocumentTokenSource();
		tokenSource.setLexer(new Provider<Lexer>() {
			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		XtextDocument document = new XtextDocument(tokenSource, null);
		document.setDocumentPartitioner(partitioner);
		partitioner.connect(document);
		document.set(s);
		return document;
	}

}
