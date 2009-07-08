/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import java.util.Arrays;

import org.eclipse.xtext.util.Strings;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LightweightPositionTest extends TestCase {

	public void testMerge_01() {
		LightweightPosition pos = new LightweightPosition(1, 1, 1, "1", "2");
		pos.merge(2, "3");
		checkIds(pos.getIds(), "1", "2", "3");
	}
	
	public void testMerge_02() {
		LightweightPosition pos = new LightweightPosition(1, 1, 2, "2", "3");
		pos.merge(1, "1");
		checkIds(pos.getIds(), "1", "2", "3");
	}
	
	public void testMerge_03() {
		LightweightPosition pos = new LightweightPosition(1, 1, 1, "1", "2");
		pos.merge(2, "2", "3");
		checkIds(pos.getIds(), "1", "2", "3");
	}
	
	public void testMerge_04() {
		LightweightPosition pos = new LightweightPosition(1, 1, 2, "2", "3");
		pos.merge(1, "1", "2");
		checkIds(pos.getIds(), "1", "2", "3");
	}
	
	public void testMerge_05() {
		LightweightPosition pos = new LightweightPosition(1, 1, 1, "1", "2");
		pos.merge(2, "3", "2");
		checkIds(pos.getIds(), "1", "3", "2");
	}
	
	public void testMerge_06() {
		LightweightPosition pos = new LightweightPosition(1, 1, 2, "3", "2");
		pos.merge(1, "1", "2");
		checkIds(pos.getIds(), "1", "3", "2");
	}
	
	private void checkIds(String[] actual, String... expected) {
		assertEquals(Strings.concat(", ", Arrays.asList(actual)) + " vs. " + Strings.concat(", ", Arrays.asList(expected)),
				actual.length, expected.length);
		for(int i = 0; i < actual.length; i++) {
			assertEquals("at index: " + i, expected[i], actual[i]);
		}
	}
}
