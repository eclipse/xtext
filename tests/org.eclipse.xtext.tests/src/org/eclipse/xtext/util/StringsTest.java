/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class StringsTest extends TestCase {

	public void testSplit() throws Exception {
		List<String> split = Strings.split("foo.bar", ".");
		assertEquals(2, split.size());
		assertEquals("foo", split.get(0));
		assertEquals("bar", split.get(1));
	}

	public void testSplit2() throws Exception {
		List<String> split = Strings.split("foobar", ".");
		assertEquals(1, split.size());
		assertEquals("foobar", split.get(0));
	}

	public void testSplit3() throws Exception {

		List<String> split = Strings.split("foobar", "oo");
		assertEquals(2, split.size());
		assertEquals("f", split.get(0));
		assertEquals("bar", split.get(1));

	}

	public void testSplit4() throws Exception {
		List<String> split = Strings.split("foobar", "o");
		assertEquals(3, split.size());
		assertEquals("f", split.get(0));
		assertEquals("", split.get(1));
		assertEquals("bar", split.get(2));
	}
	
	public void testPackUnpack() throws Exception {
		String[] strings = new String[] {
			";" , ":", "foo","bar"
		};
		String packed = Strings.pack(strings);
		String[] newStrings = Strings.unpack(packed);
		assertTrue(Arrays.equals(strings, newStrings));
		assertNull(Strings.pack(null));
		
		strings = new String[] { "" };
		assertTrue(Arrays.equals(strings, Strings.unpack(Strings.pack(strings))));
		assertNull(Strings.pack(null));
		assertNull(Strings.unpack(null));
		assertNull(Strings.unpack(""));
	}
}
