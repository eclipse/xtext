/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.reconciler;

import static org.junit.Assert.*;

import org.eclipse.xtext.ui.editor.reconciler.ReconcilerReplaceRegion;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReconcilingRegionBuilderTest {

	@Test
	public void testNonEmptyInserts_0() {
		perfomTestMatrix("01234", "abc", "xyz");
	}

	@Test
	public void testNonEmptyInserts_1() {
		perfomTestMatrix("01234", "abcd", "xy");
	}

	@Test
	public void testNonEmptyInserts_2() {
		perfomTestMatrix("01234", "ab", "wxyz");
	}

	@Test
	public void testEmptyInsert_0() {
		perfomTestMatrix("01234", "", "xyz");
	}

	@Test
	public void testEmptyInsert_1() {
		perfomTestMatrix("01234", "abc", "");
	}

	protected void perfomTestMatrix(String text, String replace0, String replace1) {
		for (int offset0 = 0; offset0 < text.length(); ++offset0) {
			for (int length0 = 0; length0 < text.length(); ++length0) {
				for (int offset1 = 0; offset1 < text.length() + replace0.length() - length0; ++offset1) {
					for (int length1 = 0; length1 < text.length() + replace0.length() - length0; ++length1) {
						String message = "[" + offset0 + "," + length0 + "," + replace0 + "] "
								+ "[" + offset1 + "," + length1 + "," + replace1 + "]";
						try {
							StringBuilder fromBuilder = new StringBuilder(text);
							ReconcilerReplaceRegion.builder(text)
									.add(offset0, length0, replace0)
									.add(offset1, length1, replace1).create().applyTo(fromBuilder);
							StringBuilder direct = new StringBuilder(text)
									.replace(offset0, offset0 + length0, replace0)
									.replace(offset1, offset1 + length1, replace1);
							assertEquals(message, direct.toString(), fromBuilder.toString());
						} catch (RuntimeException e) {
							System.err.println(message);
							throw e;
						}
					}
				}
			}
		}
	}
}
