/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Iterator;

import junit.framework.TestCase;

import com.google.common.base.Join;
import com.google.common.collect.Iterators;

public class ChainedIteratorTest extends TestCase {
	
	@SuppressWarnings("unchecked")
	public void testSimple() throws Exception {
		Iterator<String> iter = Iterators.concat(iter("a","b"), iter("c"), iter("d"));
		assertEquals("abcd", Join.join("", iter));
	}
	
	@SuppressWarnings("unchecked")
	public void testSecondArgNull() throws Exception {
		try {
			Iterators.concat(iter("a","b"), null, null);
			fail("NPE expected.");
		} catch(NullPointerException ex) {
			// expected
		}
	}
	
	public void testFirstArgNull() throws Exception {
		try {
			Iterators.concat(null, iter("a","b"));
			fail("nullpointer exception expected");
		} catch (NullPointerException npe){
			//expected
		}
	}
	
	private Iterator<String> iter(String ... elements) {
		return Iterators.forArray(elements, 0, elements.length);
	}
}
