/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.xtext.ui.editor.outline.quickoutline.StringMatcher;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class StringMatcherTest extends Assert {

	protected StringMatcher createStringMatcher(String pattern) {
		return new StringMatcher(pattern, true);
	}
	
	@Test public void testSimpleMatching() {
		StringMatcher matcher = createStringMatcher("simple");
		assertTrue(matcher.match("simple"));
		assertFalse(matcher.match("imple"));
	}
	
	@Test public void testWildcardStarMatching() {
		StringMatcher matcher = createStringMatcher("*i");
		assertTrue(matcher.match("abcdei"));
		assertTrue(matcher.match("abcdeii"));
		assertTrue(matcher.match("abcdeiip"));
		assertTrue(matcher.match("i"));
		assertFalse(matcher.match(""));
		assertTrue(matcher.match("(i"));
	}
	
	@Test public void testWildcardQuestionmarkMatching() {
		StringMatcher matcher = createStringMatcher("h?llo");
		assertTrue(matcher.match("hallo"));
		assertTrue(matcher.match("hello"));
		assertTrue(matcher.match("hillo"));
		assertTrue(matcher.match("hellooo"));
		assertFalse(matcher.match("hllo"));
	}
	
	@Test public void testEscapeOpeningParenthesis() {
		StringMatcher matcher = createStringMatcher("print*(");
		assertTrue(matcher.match("println("));
	}
	
	@Test public void testEscapeClosingParenthesis() {
		StringMatcher matcher = createStringMatcher("print*)");
		assertTrue(matcher.match("println(x)"));
	}
	
	@Test public void testEscapeOpeningBrackets() {
		StringMatcher matcher = createStringMatcher("arr*[");
		assertTrue(matcher.match("array["));
	}
	
	@Test public void testEscapeClosingBrackets() {
		StringMatcher matcher = createStringMatcher("arr*]");
		assertTrue(matcher.match("array[x]"));
	}

	@Test public void testEscapeOpeningCurlies() {
		StringMatcher matcher = createStringMatcher("blo*{")  ;
		assertTrue(matcher.match("block{"));
	}
	
	@Test public void testEscapeClosingCurlies() {
		StringMatcher matcher = createStringMatcher("blo*}");
		assertTrue(matcher.match("block{moretext}"));
	}
	
	@Test public void testEscapeManyBraces() {
		StringMatcher matcher = createStringMatcher("blo*([{some*text}])");
		assertTrue(matcher.match("block([{some more text}])"));
	}
	
	@Test public void testBug528817() {
		StringMatcher matcher = createStringMatcher("keyw\\");
		assertFalse(matcher.match("egal"));
	}

}
