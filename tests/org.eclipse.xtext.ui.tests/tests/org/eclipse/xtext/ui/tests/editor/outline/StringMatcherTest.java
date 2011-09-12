/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.xtext.ui.editor.outline.quickoutline.StringMatcher;

import junit.framework.TestCase;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class StringMatcherTest extends TestCase {

	public void testSimpleMatching() {
		StringMatcher matcher = new StringMatcher("simple", true);
		assertTrue(matcher.match("simple"));
		assertFalse(matcher.match("imple"));
	}
	
	public void testWildcardStarMatching() {
		StringMatcher matcher = new StringMatcher("*i", true);
		assertTrue(matcher.match("abcdei"));
		assertTrue(matcher.match("abcdeii"));
		assertFalse(matcher.match("abcdeiip"));
		assertTrue(matcher.match("i"));
		assertFalse(matcher.match(""));
		assertTrue(matcher.match("(i"));
	}
	
	public void testWildcardQuestionmarkMatching() {
		StringMatcher matcher = new StringMatcher("h?llo", true);
		assertTrue(matcher.match("hallo"));
		assertTrue(matcher.match("hello"));
		assertTrue(matcher.match("hillo"));
		assertFalse(matcher.match("hellooo"));
		assertFalse(matcher.match("hllo"));
	}
	
	public void testEscapeOpeningParenthesis() {
		StringMatcher matcher = new StringMatcher("print*(", true);
		assertTrue(matcher.match("println("));
	}
	
	public void testEscapeClosingParenthesis() {
		StringMatcher matcher = new StringMatcher("print*)", true);
		assertTrue(matcher.match("println(x)"));
	}
	
	public void testEscapeOpeningBrackets() {
		StringMatcher matcher = new StringMatcher("arr*[", true);
		assertTrue(matcher.match("array["));
	}
	
	public void testEscapeClosingBrackets() {
		StringMatcher matcher = new StringMatcher("arr*]", true);
		assertTrue(matcher.match("array[x]"));
	}

	public void testEscapeOpeningCurlies() {
		StringMatcher matcher = new StringMatcher("blo*{", true)  ;
		assertTrue(matcher.match("block{"));
	}
	
	public void testEscapeClosingCurlies() {
		StringMatcher matcher = new StringMatcher("blo*}", true);
		assertTrue(matcher.match("block{moretext}"));
	}
	
	public void testEscapeManyBraces() {
		StringMatcher matcher = new StringMatcher("blo*([{some*text}])", true);
		assertTrue(matcher.match("block([{some more text}])"));
	}
	
}
