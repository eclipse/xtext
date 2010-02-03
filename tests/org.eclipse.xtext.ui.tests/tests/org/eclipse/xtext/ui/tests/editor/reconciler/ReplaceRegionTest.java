/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.reconciler;

import junit.framework.TestCase;

import org.eclipse.xtext.ui.editor.reconciler.ReplaceRegion;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ReplaceRegionTest extends TestCase {

	private ReplaceRegion mergedReplace;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mergedReplace = null;
	}

	public void testNonOverlappingLeftContinuousRegions() {
		String document = "0123456789";
		document = checkReplace(document, new ReplaceRegion(8, 1, "ab"));
		assertEquals("01234567ab9", document);

		// replace growing
		document = checkReplace(document, new ReplaceRegion(7, 1, "cd"));
		assertEquals("0123456cdab9", document);
		assertEquals("cdab", mergedReplace.getText());
		assertEquals(7, mergedReplace.getOffset());
		assertEquals(2, mergedReplace.getLength());

		// replace same size
		document = checkReplace(document, new ReplaceRegion(6, 1, "e"));
		assertEquals("012345ecdab9", document);
		assertEquals("ecdab", mergedReplace.getText());
		assertEquals(6, mergedReplace.getOffset());
		assertEquals(3, mergedReplace.getLength());

		// replace shrinking
		document = checkReplace(document, new ReplaceRegion(4, 2, "f"));
		assertEquals("0123fecdab9", document);
		assertEquals("fecdab", mergedReplace.getText());
		assertEquals(4, mergedReplace.getOffset());
		assertEquals(5, mergedReplace.getLength());

		// delete
		document = checkReplace(document, new ReplaceRegion(3, 1, ""));
		assertEquals("012fecdab9", document);
		assertEquals("fecdab", mergedReplace.getText());
		assertEquals(3, mergedReplace.getOffset());
		assertEquals(6, mergedReplace.getLength());

		// insert
		document = checkReplace(document, new ReplaceRegion(3, 0, "g"));
		assertEquals("012gfecdab9", document);
		assertEquals("gfecdab", mergedReplace.getText());
		assertEquals(3, mergedReplace.getOffset());
		assertEquals(6, mergedReplace.getLength());
	}

	public void testNonOverlappingLeftNonContinuousRegions() {
		String document = "0123456789";
		document = checkReplace(document, new ReplaceRegion(9, 1, "ab"));
		assertEquals("012345678ab", document);

		// replace growing
		document = checkReplace(document, new ReplaceRegion(7, 1, "cd"));
		assertEquals("0123456cd8ab", document);
		assertEquals("cd8ab", mergedReplace.getText());
		assertEquals(7, mergedReplace.getOffset());
		assertEquals(3, mergedReplace.getLength());

		// replace same size
		document = checkReplace(document, new ReplaceRegion(5, 1, "e"));
		assertEquals("01234e6cd8ab", document);
		assertEquals("e6cd8ab", mergedReplace.getText());
		assertEquals(5, mergedReplace.getOffset());
		assertEquals(5, mergedReplace.getLength());

		// replace shrinking
		document = checkReplace(document, new ReplaceRegion(2, 2, "f"));
		assertEquals("01f4e6cd8ab", document);
		assertEquals("f4e6cd8ab", mergedReplace.getText());
		assertEquals(2, mergedReplace.getOffset());
		assertEquals(8, mergedReplace.getLength());
	}

	public void testDeleteInsertNonContiguousRegion() throws Exception {
		String document = "0123456789";
		document = checkReplace(document, new ReplaceRegion(4, 2, "abc"));
		assertEquals("0123abc6789", document);

		// delete left
		document = checkReplace(document, new ReplaceRegion(2, 1, ""));
		assertEquals("013abc6789", document);
		assertEquals("3abc", mergedReplace.getText());
		assertEquals(2, mergedReplace.getOffset());
		assertEquals(4, mergedReplace.getLength());

		// insert left
		document = checkReplace(document, new ReplaceRegion(1, 0, "d"));
		assertEquals("0d13abc6789", document);
		assertEquals("d13abc", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(5, mergedReplace.getLength());

		// delete right
		document = checkReplace(document, new ReplaceRegion(8, 1, ""));
		assertEquals("0d13abc689", document);
		assertEquals("d13abc6", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(7, mergedReplace.getLength());

		// insert right
		document = checkReplace(document, new ReplaceRegion(9, 0, "e"));
		assertEquals("0d13abc68e9", document);
		assertEquals("d13abc68e", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(8, mergedReplace.getLength());
	}

	public void testNonOverlappingRightContinuousRegions() {
		String document = "0123456789";
		document = checkReplace(document, new ReplaceRegion(1, 1, "ab"));
		assertEquals("0ab23456789", document);

		// replace growing
		document = checkReplace(document, new ReplaceRegion(3, 1, "cd"));
		assertEquals("0abcd3456789", document);
		assertEquals("abcd", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(2, mergedReplace.getLength());

		// replace same size
		document = checkReplace(document, new ReplaceRegion(5, 1, "e"));
		assertEquals("0abcde456789", document);
		assertEquals("abcde", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(3, mergedReplace.getLength());

		// replace shrinking
		document = checkReplace(document, new ReplaceRegion(6, 2, "f"));
		assertEquals("0abcdef6789", document);
		assertEquals("abcdef", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(5, mergedReplace.getLength());

		// delete
		document = checkReplace(document, new ReplaceRegion(7, 1, ""));
		assertEquals("0abcdef789", document);
		assertEquals("abcdef", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(6, mergedReplace.getLength());

		// insert
		document = checkReplace(document, new ReplaceRegion(7, 0, "g"));
		assertEquals("0abcdefg789", document);
		assertEquals("abcdefg", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(6, mergedReplace.getLength());
	}

	public void testNonOverlappingRightNonContinuousRegions() {
		String document = "0123456789";
		document = checkReplace(document, new ReplaceRegion(1, 1, "ab"));
		assertEquals("0ab23456789", document);

		// replace growing
		document = checkReplace(document, new ReplaceRegion(4, 1, "cd"));
		assertEquals("0ab2cd456789", document);
		assertEquals("ab2cd", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(3, mergedReplace.getLength());

		// replace same size
		document = checkReplace(document, new ReplaceRegion(7, 1, "e"));
		assertEquals("0ab2cd4e6789", document);
		assertEquals("ab2cd4e", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(5, mergedReplace.getLength());

		// replace shrinking
		document = checkReplace(document, new ReplaceRegion(9, 2, "f"));
		assertEquals("0ab2cd4e6f9", document);
		assertEquals("ab2cd4e6f", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(8, mergedReplace.getLength());
	}

	public void testMergeOverlappingRegionsLeft() throws Exception {
		String document = "0123456789";
		document = checkReplace(document, new ReplaceRegion(4, 2, "abc"));
		assertEquals("0123abc6789", document);

		// growing insert
		document = checkReplace(document, new ReplaceRegion(3, 2, "def"));
		assertEquals("012defbc6789", document);
		assertEquals("defbc", mergedReplace.getText());
		assertEquals(3, mergedReplace.getOffset());
		assertEquals(3, mergedReplace.getLength());

		// same size insert
		document = checkReplace(document, new ReplaceRegion(2, 2, "gh"));
		assertEquals("01ghefbc6789", document);
		assertEquals("ghefbc", mergedReplace.getText());
		assertEquals(2, mergedReplace.getOffset());
		assertEquals(4, mergedReplace.getLength());

		// shinking insert
		document = checkReplace(document, new ReplaceRegion(1, 2, "i"));
		assertEquals("0ihefbc6789", document);
		assertEquals("ihefbc", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(5, mergedReplace.getLength());
	}

	public void testMergeOverlappingRegionsRight() throws Exception {
		String document = "0123456789";
		document = checkReplace(document, new ReplaceRegion(4, 2, "abc"));
		assertEquals("0123abc6789", document);

		// growing insert
		document = checkReplace(document, new ReplaceRegion(6, 2, "def"));
		assertEquals("0123abdef789", document);
		assertEquals("abdef", mergedReplace.getText());
		assertEquals(4, mergedReplace.getOffset());
		assertEquals(3, mergedReplace.getLength());

		// same size insert
		document = checkReplace(document, new ReplaceRegion(8, 2, "gh"));
		assertEquals("0123abdegh89", document);
		assertEquals("abdegh", mergedReplace.getText());
		assertEquals(4, mergedReplace.getOffset());
		assertEquals(4, mergedReplace.getLength());

		// shinking insert
		document = checkReplace(document, new ReplaceRegion(9, 2, "i"));
		assertEquals("0123abdegi9", document);
		assertEquals("abdegi", mergedReplace.getText());
		assertEquals(4, mergedReplace.getOffset());
		assertEquals(5, mergedReplace.getLength());
	}

	public void testMultiAppend() throws Exception {
		String document = "a";
		document = checkReplace(document, new ReplaceRegion(1, 0, "b"));
		assertEquals("ab", document);
		document = checkReplace(document, new ReplaceRegion(2, 0, "c"));
		assertEquals("abc", document);
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(0, mergedReplace.getLength());
		assertEquals("bc", mergedReplace.getText());
	}

	public void testMultiPrepend() throws Exception {
		String document = "a";
		document = checkReplace(document, new ReplaceRegion(0, 0, "b"));
		assertEquals("ba", document);
		document = checkReplace(document, new ReplaceRegion(0, 0, "c"));
		assertEquals("cba", document);
		assertEquals("cb", mergedReplace.getText());
		assertEquals(0, mergedReplace.getOffset());
		assertEquals(0, mergedReplace.getLength());
	}

	public void testMultiDeleteHead() throws Exception {
		String document = "abc";
		document = checkReplace(document, new ReplaceRegion(0, 1, ""));
		assertEquals("bc", document);
		document = checkReplace(document, new ReplaceRegion(0, 1, ""));
		assertEquals("c", document);
		assertEquals("", mergedReplace.getText());
		assertEquals(0, mergedReplace.getOffset());
		assertEquals(2, mergedReplace.getLength());
	}
	
	public void testMultiDeleteTail() throws Exception {
		String document = "abc";
		document = checkReplace(document, new ReplaceRegion(2, 1, ""));
		assertEquals("ab", document);
		document = checkReplace(document, new ReplaceRegion(1, 1, ""));
		assertEquals("a", document);
		assertEquals("", mergedReplace.getText());
		assertEquals(1, mergedReplace.getOffset());
		assertEquals(2, mergedReplace.getLength());
	}
	
	private String checkReplace(String document, ReplaceRegion replaceRegion) {
		document = applyReplace(document, replaceRegion);
		if (mergedReplace == null) {
			mergedReplace = replaceRegion;
		}
		else {
			mergedReplace.mergeWith(replaceRegion, document);
		}
		return document;
	}

	private String applyReplace(String document, ReplaceRegion replaceRegion) {
		return document.substring(0, replaceRegion.getOffset()) + replaceRegion.getText()
				+ document.substring(replaceRegion.getOffset() + replaceRegion.getLength());
	}

}
