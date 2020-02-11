/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TailWriterTest extends Assert {

	private StringWriter writer;
	private BufferedWriter buff;

	@Before
	public void setUp() {
		writer = new StringWriter();
	}

	@After
	public void tearDown() {
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

	@Test public void testSuppressNothing() throws IOException {
		initWriter(0);
		String s = "foo\nbar\n";
		write(s);
		check(s);
	}

	@Test public void testSuppressNegative() throws Exception {
		initWriter(-1);
		String s = "foo\nbar\n";
		write(s);
		check(s);
	}

	@Test public void testSuppressOne() throws Exception {
		initWriter(1);
		write("foo\nbar\n");
		check("bar\n");
	}

	@Test public void testSuppressTwo() throws Exception {
		initWriter(2);
		write("foo\nbar\nzonk\n");
		check("zonk\n");
	}

	@Test public void testSuppressAll() throws Exception {
		initWriter(4);
		write("foo\nbar\nzonk\n");
		check("");
	}
}
