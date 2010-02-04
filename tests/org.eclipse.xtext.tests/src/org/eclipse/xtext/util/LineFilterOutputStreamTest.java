/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LineFilterOutputStreamTest extends TestCase {

	private ByteArrayOutputStream result;

	private LineFilterOutputStream filterStream;

	private String input;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		result = new ByteArrayOutputStream(500);
		filterStream = new LineFilterOutputStream(result, " * $Id" + "$");
		input = "/**\n" +
				" * <copyright>\n" +
				" * </copyright>\n" +
				" *\n" +
				" * $Id" + "$\n" +
				" */\n" +
				"package foo";
	}

	public void testWrite_01() throws IOException {
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

	public void testWrite_02() throws IOException {
		filterStream.write((" * $Id" + "$").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "";
		assertEquals(expected, res);
	}

	public void testWrite_03() throws IOException {
		filterStream.write(("\n * $Id" + "$").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "\n";
		assertEquals(expected, res);
	}

	public void testWrite_04() throws IOException {
		filterStream.write((" * $Id" + "$\n").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "";
		assertEquals(expected, res);
	}

	public void testWrite_05() throws IOException {
		filterStream.write(("*\n * $Id" + "$").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = "*\n";
		assertEquals(expected, res);
	}

	public void testWrite_06() throws IOException {
		filterStream.write((" * $Id" + "$\n *").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = " *";
		assertEquals(expected, res);
	}

	public void testWrite_07() throws IOException {
		filterStream.write((" * $Id" + "$\n *\n").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = " *\n";
		assertEquals(expected, res);
	}

	public void testWrite_08() throws IOException {
		filterStream.write((" * $Id" + "$\n */").getBytes());
		filterStream.flush();
		String res = new String(result.toByteArray());
		String expected = " */";
		assertEquals(expected, res);
	}
}
