/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.unassignedtext;

import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class UnassignedTextTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(UnassignedTextTestLanguageStandaloneSetup.class);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	@Test public void testCaseInsensitiveKeyword() throws Exception {
		final String in = "kEyWoRd 7";
		final String out = "KeyWord 7";
		String s = serialize(getModel(in));
		assertEquals(out, s);
	}

	@Test public void testPlural1() throws Exception {
		final String in = "contents: 0 items";
		final String out = "contents: 0 items";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}

	@Test public void testPlural2() throws Exception {
		final String in = "contents: 0 item";
		final String out = "contents: 0 items";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}

	@Test public void testPlural3() throws Exception {
		final String in = "contents: 1 items";
		final String out = "contents: 1 item";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}

	@Test public void testPlural4() throws Exception {
		final String in = "contents: 1 item";
		final String out = "contents: 1 item";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}

	@Test public void testMulti() throws Exception {
		final String in = "multi 1 accegj01 acddegj01 accehj11";
		final String out = "multi 1 accegj01 accegj02 accegj03";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}

	@Test public void testDataType() throws Exception {
		final String in = "datatype 3 'mystr'";
		final String out = "datatype 3 str";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}

	@Test public void testCommonTerminals() throws Exception {
		final String in = "terminals xyz 789 'yo' X";
		final String out = "terminals abc 123 'abc' X";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}
	
	@Test public void testGroup() throws Exception {
		final String in = "group this is a test";
		final String out = "group this is a test";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}
	
	@Test public void testGroup_02() throws Exception {
		final String out = "group this is a test";
		String s = serialize(UnassignedtextFactory.eINSTANCE.createGroupRule()).trim();
		assertEquals(out, s);
	}
}
