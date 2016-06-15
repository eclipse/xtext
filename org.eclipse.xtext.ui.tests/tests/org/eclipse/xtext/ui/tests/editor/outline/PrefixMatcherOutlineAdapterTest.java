/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.outline.quickoutline.PrefixMatcherOutlineAdapter;
import org.eclipse.xtext.ui.editor.outline.quickoutline.StringMatcher;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrefixMatcherOutlineAdapterTest extends StringMatcherTest {

	@Override
	protected StringMatcher createStringMatcher(String pattern) {
		FQNPrefixMatcher fqnPrefixMatcher = new FQNPrefixMatcher();
		fqnPrefixMatcher.setLastSegmentFinder(new FQNPrefixMatcher.DefaultLastSegmentFinder());
		fqnPrefixMatcher.setDelegate(new PrefixMatcher.CamelCase());
		return new PrefixMatcherOutlineAdapter(pattern, fqnPrefixMatcher);
	}
	
	@Test public void testBug393439() {
		StringMatcher matcher = createStringMatcher("*CLass");
		assertTrue(matcher.match("XtendClass"));
	}
	
	@Test public void testFQN() {
		StringMatcher matcher = createStringMatcher("j.u.ArrayList");
		assertTrue(matcher.match("java.util.ArrayList"));
		assertTrue(matcher.match("java.util.concurrent.ArrayList"));
		assertFalse(matcher.match("java.util.concurrent.BlockingArrayList"));
	}
	
	@Test public void testFQNWildcard() {
		StringMatcher matcher = createStringMatcher("j.u.*ArrayList");
		assertTrue(matcher.match("java.util.ArrayList"));
		assertTrue(matcher.match("java.util.concurrent.ArrayList"));
		assertTrue(matcher.match("java.util.concurrent.BlockingArrayList"));
	}
	
	@Test public void testCamelCase() {
		StringMatcher matcher = createStringMatcher("ArrLis");
		assertTrue(matcher.match("ArrayList"));
		assertTrue(matcher.match("java.util.concurrent.ArrayList"));
		assertFalse(matcher.match("java.util.concurrent.BlockingArrayList"));
	}
	
	@Test public void testMethodSignature() {
		StringMatcher matcher = createStringMatcher("cSM ( Str");
		assertTrue(matcher.match("createStringMatcher(String)"));
		assertTrue(matcher.match("createStringMatcher ( String, int)"));
		assertFalse(matcher.match("createStringMatcher(int, String)"));
	}
	
	@Test public void testMethodSignature_02() {
		StringMatcher matcher = createStringMatcher("cSM ( Str, ArrL");
		assertTrue(matcher.match("createStringMatcher(String, java.util.ArrayList)"));
		assertTrue(matcher.match("createStringMatcher ( String, ArrayList)"));
		assertFalse(matcher.match("createStringMatcher(String, FooBar, ArrayList)"));
		assertFalse(matcher.match("createStringMatcher(ArrayList, String)"));
	}
	
	@Test public void testMethodSignature_03() {
		StringMatcher matcher = createStringMatcher("cSM ( Str,, ArrL");
		assertFalse(matcher.match("createStringMatcher(String, java.util.ArrayList)"));
		assertFalse(matcher.match("createStringMatcher ( String, ArrayList)"));
		assertTrue(matcher.match("createStringMatcher(String, FooBar, ArrayList)"));
		assertFalse(matcher.match("createStringMatcher(ArrayList, String)"));
	}
	
	@Test public void testMultiWordLabel_01() {
		StringMatcher matcher = createStringMatcher("mDs");
		assertTrue(matcher.match("generate myDsl"));
	}
	
	@Test public void testMultiWordLabel_02() {
		StringMatcher matcher = createStringMatcher("g MYDs");
		assertTrue(matcher.match("generate myDsl"));
	}
	
	@Test public void testMultiWordLabel_03() {
		StringMatcher matcher = createStringMatcher("g ");
		assertTrue(matcher.match("generate myDsl"));
	}
	
	@Test public void testMultiWordLabelFqn() {
		StringMatcher matcher = createStringMatcher("xtext");
		assertTrue(matcher.match("grammar org.eclipse.xtext.Xtext"));
	}
	
	@Test public void testIgnoredStructuralDelimiterGuard() {
		StringMatcher matcher = createStringMatcher("*:StrMat");
		assertTrue(matcher.match("createStringMatcher(String) : StringMatcher"));
	}
	
	@Test public void testWildcardStarMatching2() {
		StringMatcher matcher = createStringMatcher("*J");
		assertTrue(matcher.match("generateJavaDoc"));
		assertTrue(matcher.match("generateJavaDoc(EObject) : StringConcatenation"));
	}
}
