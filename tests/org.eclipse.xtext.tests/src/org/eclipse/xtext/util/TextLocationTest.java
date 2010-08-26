/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TextLocationTest extends TestCase {

	public void testContainsByOffset() {
		TextLocation location = new TextLocation(3, 4);
		assertTrue(location.contains(3));
		assertTrue(location.contains(6));
		assertFalse(location.contains(2));
		assertFalse(location.contains(7));
	}
	
	public void testContainsByLocation() {
		TextLocation location = new TextLocation(3, 4);
		assertTrue(location.contains(new TextLocation(4,2)));
		assertTrue(location.contains(new TextLocation(4,3)));
		assertTrue(location.contains(new TextLocation(3,2)));
		assertTrue(location.contains(new TextLocation(3,0)));
		assertFalse(location.contains(new TextLocation(2,4)));
		assertFalse(location.contains(new TextLocation(1,1)));
		assertFalse(location.contains(new TextLocation(8,1)));
	}
}
