/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
public class StringsDiffTest {
	@Test
	public void testDiff_0() {
		assertDiff("foo", "foo", null);
	}

	@Test
	public void testDiff_1() {
		assertDiff("foo", "bar",
				"[foo]\n" +
				"vs\n" +
				"[bar]\n");
	}

	@Test
	public void testDiff_2() {
		assertDiff("foo1", "foobar",
				"foo[1]\n" +
				"vs\n" +
				"foo[bar]\n");
	}

	@Test
	public void testDiff_3() {
		assertDiff("foo", "foofoo",
				"foo[]\n" +
				"vs\n" +
				"foo[foo]\n");
	}

	@Test
	public void testDiff_4() {
		assertDiff("foo", "barfoo",
				"[]foo\n" +
				"vs\n" +
				"[bar]foo\n");
	}

	@Test
	public void testDiff_5() {
		assertDiff("2foo", "barfoo",
				"[2]foo\n" +
				"vs\n" +
				"[bar]foo\n");
	}

	@Test
	public void testDiff_6() {
		assertDiff("0123456789foo1", "0123456789foobar",
				"...3456789foo[1]\n" +
				"vs\n" +
				"...3456789foo[bar]\n");
	}

	@Test
	public void testDiff_7() {
		assertDiff("0123456789foo", "0123456789foofoo",
				"...3456789foo[]\n" +
				"vs\n" +
				"...3456789foo[foo]\n");
	}

	@Test
	public void testDiff_8() {
		assertDiff("foo0123456789", "barfoo0123456789",
				"[]foo0123456...\n" +
				"vs\n" +
				"[bar]foo0123456...\n");
	}

	@Test
	public void testDiff_9() {
		assertDiff("2foo0123456789", "barfoo0123456789",
				"[2]foo0123456...\n" +
				"vs\n" +
				"[bar]foo0123456...\n");
	}

	protected void assertDiff(String one, String two, CharSequence expected) {
		if (expected != null) {
			expected = expected.toString().trim();
		}
		String actual = DiffUtil.diff(one, two);
		if (actual != null) {
			actual = actual.replaceAll(System.lineSeparator(), "\n");
		}
		Assert.assertEquals(expected, actual);
	}
}
