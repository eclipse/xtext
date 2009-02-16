/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TailWriterTest extends TestCase {

	private StringWriter writer;
	private BufferedWriter buff;

	@Override
	protected void setUp() {
		writer = new StringWriter();
	}

	@Override
	protected void tearDown() {
		writer = null;
		buff = null;
	}

	protected void initWriter(int ignoreLines) {
		buff = new BufferedWriter(new TailWriter(writer, ignoreLines));
	}

	protected void write(String s) throws IOException {
		buff.write(s);
		buff.flush();
	}

	protected void check(String s) {
		assertEquals(s, writer.getBuffer().toString());
	}

	public void testSuppressNothing() throws IOException {
		initWriter(0);
		String s = "foo\nbar\n";
		write(s);
		check(s);
	}

	public void testSuppressNegative() throws Exception {
		initWriter(-1);
		String s = "foo\nbar\n";
		write(s);
		check(s);
	}

	public void testSuppressOne() throws Exception {
		initWriter(1);
		write("foo\nbar\n");
		check("bar\n");
	}

	public void testSuppressTwo() throws Exception {
		initWriter(2);
		write("foo\nbar\nzonk\n");
		check("zonk\n");
	}

	public void testSuppressAll() throws Exception {
		initWriter(4);
		write("foo\nbar\nzonk\n");
		check("");
	}
}
