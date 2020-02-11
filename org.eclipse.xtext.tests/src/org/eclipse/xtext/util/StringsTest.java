/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class StringsTest extends Assert {

	@Test public void testSplitByString_1() throws Exception {
		List<String> split = Strings.split("foo.bar", ".");
		assertEquals(2, split.size());
		assertEquals("foo", split.get(0));
		assertEquals("bar", split.get(1));
		List<String> stringSplit = Arrays.asList("foo.bar".split("\\."));
		assertEquals(split, stringSplit);
	}

	@Test public void testSplitByString_2() throws Exception {
		List<String> split = Strings.split("foobar", ".");
		assertEquals(1, split.size());
		assertEquals("foobar", split.get(0));
		List<String> stringSplit = Arrays.asList("foobar".split("\\."));
		assertEquals(split, stringSplit);
	}

	@Test public void testSplitByString_3() throws Exception {
		List<String> split = Strings.split("foobar", "oo");
		assertEquals(2, split.size());
		assertEquals("f", split.get(0));
		assertEquals("bar", split.get(1));
		List<String> stringSplit = Arrays.asList("foobar".split("oo"));
		assertEquals(split, stringSplit);
	}

	@Test public void testSplitByString_4() throws Exception {
		List<String> split = Strings.split("foobar", "o");
		assertEquals(3, split.size());
		assertEquals("f", split.get(0));
		assertEquals("", split.get(1));
		assertEquals("bar", split.get(2));
		List<String> stringSplit = Arrays.asList("foobar".split("o"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByString_5() throws Exception {
		List<String> split = Strings.split("abc::Zonk::", "::");
		assertEquals(2, split.size());
		assertEquals("abc", split.get(0));
		assertEquals("Zonk", split.get(1));
		List<String> stringSplit = Arrays.asList("abc::Zonk::".split("::"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByString_6() throws Exception {
		List<String> split = Strings.split("abc:::Zonk::", "::");
		assertEquals(2, split.size());
		assertEquals("abc", split.get(0));
		assertEquals(":Zonk", split.get(1));
		List<String> stringSplit = Arrays.asList("abc:::Zonk::".split("::"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByString_7() throws Exception {
		List<String> split = Strings.split("abc::::Zonk::", "::");
		assertEquals(3, split.size());
		assertEquals("abc", split.get(0));
		assertEquals("", split.get(1));
		assertEquals("Zonk", split.get(2));
		List<String> stringSplit = Arrays.asList("abc::::Zonk::".split("::"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByString_8() throws Exception {
		List<String> split = Strings.split("abc::Zonk::::", "::");
		assertEquals(2, split.size());
		assertEquals("abc", split.get(0));
		assertEquals("Zonk", split.get(1));
		List<String> stringSplit = Arrays.asList("abc::Zonk::::".split("::"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByString_9() throws Exception {
		List<String> split = Strings.split("::abc::Zonk", "::");
		assertEquals(3, split.size());
		assertEquals("", split.get(0));
		assertEquals("abc", split.get(1));
		assertEquals("Zonk", split.get(2));
		List<String> stringSplit = Arrays.asList("::abc::Zonk".split("::"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByChar_1() throws Exception {
		List<String> split = Strings.split("foo.bar", '.');
		assertEquals(2, split.size());
		assertEquals("foo", split.get(0));
		assertEquals("bar", split.get(1));
		List<String> stringSplit = Arrays.asList("foo.bar".split("\\."));
		assertEquals(split, stringSplit);
	}

	@Test public void testSplitByChar_2() throws Exception {
		List<String> split = Strings.split("foobar", '.');
		assertEquals(1, split.size());
		assertEquals("foobar", split.get(0));
		List<String> stringSplit = Arrays.asList("foobar".split("\\."));
		assertEquals(split, stringSplit);
	}

	@Test public void testSplitByChar_3() throws Exception {
		List<String> split = Strings.split("foobar", 'o');
		assertEquals(3, split.size());
		assertEquals("f", split.get(0));
		assertEquals("", split.get(1));
		assertEquals("bar", split.get(2));
		List<String> stringSplit = Arrays.asList("foobar".split("o"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByChar_4() throws Exception {
		List<String> split = Strings.split("abc:Zonk:", ':');
		assertEquals(2, split.size());
		assertEquals("abc", split.get(0));
		assertEquals("Zonk", split.get(1));
		List<String> stringSplit = Arrays.asList("abc:Zonk:".split(":"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByChar_5() throws Exception {
		List<String> split = Strings.split("abc::Zonk:", ':');
		assertEquals(3, split.size());
		assertEquals("abc", split.get(0));
		assertEquals("", split.get(1));
		assertEquals("Zonk", split.get(2));
		List<String> stringSplit = Arrays.asList("abc::Zonk:".split(":"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByChar_6() throws Exception {
		List<String> split = Strings.split("abc:Zonk::", ':');
		assertEquals(2, split.size());
		assertEquals("abc", split.get(0));
		assertEquals("Zonk", split.get(1));
		List<String> stringSplit = Arrays.asList("abc:Zonk::".split(":"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByChar_7() throws Exception {
		List<String> split = Strings.split(":abc:Zonk", ':');
		assertEquals(3, split.size());
		assertEquals("", split.get(0));
		assertEquals("abc", split.get(1));
		assertEquals("Zonk", split.get(2));
		List<String> stringSplit = Arrays.asList(":abc:Zonk".split(":"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testSplitByChar_8() throws Exception {
		List<String> split = Strings.split("::abc:Zonk", ':');
		assertEquals(4, split.size());
		assertEquals("", split.get(0));
		assertEquals("", split.get(1));
		assertEquals("abc", split.get(2));
		assertEquals("Zonk", split.get(3));
		List<String> stringSplit = Arrays.asList("::abc:Zonk".split(":"));
		assertEquals(split, stringSplit);
	}
	
	@Test public void testPackUnpack() throws Exception {
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
	
	@Test public void testRemoveLeadingWhitespace() throws Exception {
		assertEquals("foo ", Strings.removeLeadingWhitespace("foo "));
		assertEquals("foo ", Strings.removeLeadingWhitespace(" foo "));
		assertEquals("foo ", Strings.removeLeadingWhitespace("\nfoo "));
		assertEquals("foo ", Strings.removeLeadingWhitespace("\tfoo "));
		assertEquals("", Strings.removeLeadingWhitespace("  "));
		try {
			Strings.removeLeadingWhitespace(null);
			fail();
		} catch (NullPointerException e) {
			// expected
		}
	}
	
	@Test public void testCountLineBreaks() throws Exception {
		assertEquals(0, Strings.countLineBreaks("abc", 0, 3));
		assertEquals(1, Strings.countLineBreaks("a\nc", 0, 3));
		assertEquals(2, Strings.countLineBreaks("a\n\n", 0, 3));
		assertEquals(1, Strings.countLineBreaks("a\rc", 0, 3));
		assertEquals(1, Strings.countLineBreaks("a\r\n", 0, 3));
		assertEquals(2, Strings.countLineBreaks("\r\n\n", 0, 3));
	}
	
	@Test public void testConvertBackAndForthWithUnicode() throws Exception {
		for(int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
			String originalString = String.valueOf((char)i);
			String converted = Strings.convertToJavaString(originalString, true);
			assertEquals(originalString, Strings.convertFromJavaString(converted, true));
		}
	}
	
	@Test public void testConvertBackAndForthWithoutUnicode() throws Exception {
		for(int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
			String originalString = String.valueOf((char)i);
			String converted = Strings.convertToJavaString(originalString, false);
			assertEquals(originalString, Strings.convertFromJavaString(converted, false));
		}
	}

	@Test public void testConvertSpecialChars() throws Exception {
		String input = "\b\f\n\r\"\'\\\u4444";
		String expected = "\\b\\f\\n\\r\\\"\\'\\\\\\u4444";
		assertEquals(expected, Strings.convertToJavaString(input, true));
		assertEquals(input, Strings.convertFromJavaString(expected, true));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertIllegalEscapeSequence() throws Exception {
		String input = "\\/";
		Strings.convertFromJavaString(input, true);
	}
	
	@Test
	public void testIsHex() {
		IntPredicate ref = (c) -> {
					switch (c) {
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
						return true;
					default:
						return false;
				}
		};
		for(int c = Character.MIN_VALUE; c <= Character.MAX_VALUE; c++) {
			Assert.assertTrue((char)c +  " \\u" + Integer.toString(c, 16), ref.test(c) == JavaStringConverter.isHex((char) c));
		}
	}
	
}
