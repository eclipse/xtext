/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class LineFilterOutputStreamTest extends Assert {

	private ByteArrayOutputStream result;

	private LineFilterOutputStream filterStream;

	private String input;

	@Before
	public void setUp() throws Exception {
		result = new ByteArrayOutputStream(500);
		filterStream = new LineFilterOutputStream(result, " * $Id" + "$", "\n");
		input = "/**\n" +
				" * <copyright>\n" +
				" * </copyright>\n" +
				" *\n" +
				" * $Id" + "$\n" +
				" */\n" +
				"package foo";
	}

	@Test public void testWrite_01() throws IOException {
		filterStream.write(input.getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "/**\n" +
		" * <copyright>\n" +
		" * </copyright>\n" +
		" *\n" +
//		" * $Id" + "$\n" +
		" */\n" +
		"package foo";
		assertEquals(expected, res);
	}

	@Test public void testWrite_02() throws IOException {
		filterStream.write((" * $Id" + "$").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "";
		assertEquals(expected, res);
	}

	@Test public void testWrite_03() throws IOException {
		filterStream.write(("\n * $Id" + "$").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "\n";
		assertEquals(expected, res);
	}

	@Test public void testWrite_04() throws IOException {
		filterStream.write((" * $Id" + "$\n").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "";
		assertEquals(expected, res);
	}

	@Test public void testWrite_05() throws IOException {
		filterStream.write(("*\n * $Id" + "$").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "*\n";
		assertEquals(expected, res);
	}

	@Test public void testWrite_06() throws IOException {
		filterStream.write((" * $Id" + "$\n *").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = " *";
		assertEquals(expected, res);
	}

	@Test public void testWrite_07() throws IOException {
		filterStream.write((" * $Id" + "$\n *\n").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = " *\n";
		assertEquals(expected, res);
	}

	@Test public void testWrite_08() throws IOException {
		filterStream.write((" * $Id" + "$\n */").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = " */";
		assertEquals(expected, res);
	}
}
