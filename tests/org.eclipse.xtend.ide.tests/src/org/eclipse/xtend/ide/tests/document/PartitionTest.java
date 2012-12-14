/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.document;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtend.ide.autoedit.TokenTypeToPartitionMapper;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartitionTest extends AbstractXtendUITestCase {

	private XtextDocument document;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		document = get(XtextDocument.class);
		IDocumentPartitioner partitioner = get(IDocumentPartitioner.class);
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
	}
	
	@Override
	public void tearDown() throws Exception {
		document = null;
		super.tearDown();
	}
	
	@Test public void testInitialPartitioning() {
		String input = "class SomeType {\n" + 
				"	def someOperation() '''\n" + 
				"		Dear,\n" + 
				"		bla bla foo\n" + 
				"		\n" + 
				"		Yours sincerely,\n" + 
				"		\n" + 
				"		Joe Developer\n" + 
				"		\n" + 
				"	'''	\n" + 
				"}";
		document.set(input);
		ITypedRegion[] partitions = document.getDocumentPartitioner().computePartitioning(0, input.length());
		assertEquals(3, partitions.length);
		ITypedRegion first = partitions[0];
		assertEquals(0, first.getOffset());
		assertEquals(input.indexOf("'"), first.getLength());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, first.getType());
		ITypedRegion second = partitions[1];
		assertEquals(input.indexOf("'"), second.getOffset());
		assertEquals(input.lastIndexOf("'") + 1, second.getLength() + second.getOffset());
		assertEquals(TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION, second.getType());
		ITypedRegion third = partitions[2];
		assertEquals(input.lastIndexOf("'") + 1, third.getOffset());
		assertEquals(input.length(), third.getLength() + third.getOffset());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, third.getType());
	}
	
	@Test public void testPartitioningAfterModify_01() throws BadLocationException {
		String input = "class SomeType {\n" + 
				"	def someOperation() '''\n" + 
				"		Dear,\n" + 
				"		bla bla foo\n" + 
				"		\n" + 
				"		Yours sincerely,\n" + 
				"		\n" + 
				"		Joe Developer\n" + 
				"		\n" + 
				"	'''	\n" + 
				"}";
		document.set(input);
		document.replace(input.indexOf("\t\tYours"), 0, "ллл");
		ITypedRegion[] partitions = document.getDocumentPartitioner().computePartitioning(0, input.length()  + 3 /*ллл*/);
		assertEquals(4, partitions.length);
		ITypedRegion first = partitions[0];
		assertEquals(0, first.getOffset());
		assertEquals(input.indexOf("'"), first.getLength());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, first.getType());
		ITypedRegion second = partitions[1];
		assertEquals(input.indexOf("'"), second.getOffset());
		assertEquals(input.indexOf("\t\tYours") + 1, second.getLength() + second.getOffset());
		assertEquals(TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION, second.getType());
		ITypedRegion third = partitions[2];
		assertEquals(input.indexOf("\t\tYours") + 1, third.getOffset());
		assertEquals(input.lastIndexOf("'") + 1 + 3 /*ллл*/, third.getLength() + third.getOffset());
		assertEquals(TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION, third.getType());
		ITypedRegion forth = partitions[3];
		assertEquals(input.lastIndexOf("'") + 1 + 3 /*ллл*/, forth.getOffset());
		assertEquals(input.length() + 3 /*ллл*/, forth.getLength() + forth.getOffset());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, forth.getType());
	}

	@Test public void testPartitioningAfterModify_02() throws BadLocationException {
		String input = "class SomeType {\n" + 
				"	def someOperation() '''\n" + 
				"		Dear,\n" + 
				"		bla bla foo\n" + 
				"		\n" + 
				"		Yours sincerely,\n" + 
				"		\n" + 
				"		Joe Developer\n" + 
				"		\n" + 
				"	'''	\n" + 
				"}";
		document.set(input);
		document.replace(input.indexOf("\t\tYours"), 0, "ллл");
		document.replace(input.indexOf("Joe") + 3 /*ллл*/, 0, "\t");
		ITypedRegion[] partitions = document.getDocumentPartitioner().computePartitioning(0, input.length()  + 4 /*ллл + \t*/);
		assertEquals(4, partitions.length);
		ITypedRegion first = partitions[0];
		assertEquals(0, first.getOffset());
		assertEquals(input.indexOf("'"), first.getLength());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, first.getType());
		ITypedRegion second = partitions[1];
		assertEquals(input.indexOf("'"), second.getOffset());
		assertEquals(input.indexOf("\t\tYours") + 1, second.getLength() + second.getOffset());
		assertEquals(TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION, second.getType());
		ITypedRegion third = partitions[2];
		assertEquals(input.indexOf("\t\tYours") + 1, third.getOffset());
		assertEquals(input.lastIndexOf("'") + 1 + 4 /*ллл + \t*/, third.getLength() + third.getOffset());
		assertEquals(TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION, third.getType());
		ITypedRegion forth = partitions[3];
		assertEquals(input.lastIndexOf("'") + 1 + 4 /*ллл + \t*/, forth.getOffset());
		assertEquals(document.getLength(), forth.getLength() + forth.getOffset());
		assertEquals(input.length() + 4 /*ллл + \t*/, forth.getLength() + forth.getOffset());
		assertEquals(IDocument.DEFAULT_CONTENT_TYPE, forth.getType());
	}

	@Test public void testJavaDoc_ML_COMMENTPartitions() throws BadLocationException {
		String input = "/* some comment */class Foo {}";
		document.set(input);
		ITypedRegion[] partitions = document.getDocumentPartitioner().computePartitioning(0, input.length());
		assertEquals(2, partitions.length);
		assertEquals("__comment", partitions[0].getType());
		document.replace(input.indexOf("/* some comment */"), "/* some comment */".length(), "/** some comment */");
		partitions = document.getDocumentPartitioner().computePartitioning(0, input.length() + 1/* * */);
		assertEquals(2, partitions.length);
		assertEquals("__java_javadoc", partitions[0].getType());
		document.replace(input.indexOf("/* some comment */"), "/** some comment */".length(), "/*** some comment */");
		partitions = document.getDocumentPartitioner().computePartitioning(0, input.length() + 2/* ** */);
		assertEquals(2, partitions.length);
		assertEquals("__comment", partitions[0].getType());

	}
}
