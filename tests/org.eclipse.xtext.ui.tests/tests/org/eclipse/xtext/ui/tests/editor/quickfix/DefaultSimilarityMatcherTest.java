/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import org.eclipse.xtext.ui.editor.quickfix.ISimilarityMatcher;
import org.eclipse.xtext.ui.editor.quickfix.ISimilarityMatcher.Default;

import junit.framework.TestCase;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class DefaultSimilarityMatcherTest extends TestCase {
	public void testSimilar() throws Exception {
		Default matcher = new ISimilarityMatcher.Default();
		assertTrue(matcher.isSimilar("foo", "foo"));
		assertTrue(matcher.isSimilar("fio", "foo"));
		assertTrue(matcher.isSimilar("fo", "foo"));
		assertTrue(matcher.isSimilar("fooo", "foo"));
		assertFalse(matcher.isSimilar(null, "foo"));
		assertFalse(matcher.isSimilar("foo", null));
		assertFalse(matcher.isSimilar("foo", "bar"));
		assertFalse(matcher.isSimilar("foo", "Fou"));
	}
}
