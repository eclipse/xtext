/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import static com.google.common.collect.Lists.*;

import java.util.ArrayList;

import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IteratorExtensionsTest extends TestCase {
	
	public void testToIterable() throws Exception {
		ArrayList<String> list = newArrayList("A","B");
		for (String s : IteratorExtensions.toIterable(list.iterator())) {
			assertTrue(list.contains(s));
		}
	}
}
