/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public class ChainedIteratorTest extends Assert {
	
	@Test public void testSimple() throws Exception {
		Iterator<String> iter = Iterators.concat(iter("a","b"), iter("c"), iter("d"));
		assertEquals("abcd", Joiner.on("").join(Lists.newArrayList(iter)));
	}
	
	@Test public void testSecondArgNull() throws Exception {
		try {
			Iterators.concat(iter("a","b"), null, null);
			fail("NPE expected.");
		} catch(NullPointerException ex) {
			// expected
		}
	}
	
	@Test public void testFirstArgNull() throws Exception {
		try {
			Iterators.concat(null, iter("a","b"));
			fail("nullpointer exception expected");
		} catch (NullPointerException npe){
			//expected
		}
	}
	
	private Iterator<String> iter(String ... elements) {
		return Arrays.asList(elements).iterator();
	}
}
