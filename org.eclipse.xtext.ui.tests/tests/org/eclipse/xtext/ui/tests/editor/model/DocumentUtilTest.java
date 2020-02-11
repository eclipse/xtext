/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import org.eclipse.xtext.ui.editor.model.DocumentUtil;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.junit.Test;



/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DocumentUtilTest extends AbstractXtextDocumentTest {
	
	DocumentUtil util = new DocumentUtil();
	
	@Test public void testSearchInSamePartition() throws Exception {
		XtextDocument document = getDocument("{/*{*/}/*}*/ ");
		assertEquals(3,util.searchBackwardsInSamePartition("{", document, 10).getOffset());
		assertEquals(0,util.searchBackwardsInSamePartition("{", document, document.getLength()-1).getOffset());
		assertEquals(null,util.searchBackwardsInSamePartition("{", document, 0));
		assertEquals(0,util.searchInSamePartition("{", document, 0).getOffset());
		assertEquals(3,util.searchInSamePartition("{", document, 1).getOffset());
		assertEquals(6,util.searchInSamePartition("}", document, 0).getOffset());
		assertEquals(9,util.searchInSamePartition("}", document, 7).getOffset());
	}
	
	@Test public void testSearchInSamePartition_1() throws Exception {
		String s = "              4";
		XtextDocument document = getDocument(s);
		assertEquals(s.length()-1,util.searchInSamePartition("4", document, 0).getOffset());
	}
	
	@Test public void testSearchInSamePartition_2() throws Exception {
		String s = "              ";
		XtextDocument document = getDocument(s);
		assertNull(util.searchInSamePartition("4", document, 0));
	}
	@Test public void testSearchInSamePartition_3() throws Exception {
		String s = " /*      4      */4";
		XtextDocument document = getDocument(s);
		assertEquals(s.length()-1,util.searchInSamePartition("4", document, 0).getOffset());
	}
	
	
	@Test public void testSearchBackwards_1() throws Exception {
		assertEquals(3,util.searchBackwardsInSamePartition("foo", getDocument("   foo   /*  foo */  "), 20).getOffset());
	}
}
