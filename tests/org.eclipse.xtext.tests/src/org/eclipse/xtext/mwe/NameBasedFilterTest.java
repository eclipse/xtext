/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import org.eclipse.emf.common.util.URI;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NameBasedFilterTest extends TestCase {

	public void testNullUri() {
		assertFalse(new NameBasedFilter().matches(null));
	}
	
	public void testByFileExtension() {
		NameBasedFilter filter = new NameBasedFilter();
		filter.setExtension("foo");
		URI match = URI.createFileURI("path/to/myFile.foo");
		assertTrue(filter.matches(match));
		URI mismatch = URI.createFileURI("path/to/myFile.bar");
		assertFalse(filter.matches(mismatch));
	}
	
	public void testNoCriteria() {
		NameBasedFilter filter = new NameBasedFilter();
		URI match = URI.createFileURI("path/to/myFile.foo");
		assertTrue(filter.matches(match));
		match = URI.createFileURI("path/to/myFile.bar");
		assertTrue(filter.matches(match));
	}
	
	public void testByRegularExpression() {
		NameBasedFilter filter = new NameBasedFilter();
		filter.setRegularExpression("ile\\.fo");
		URI match = URI.createFileURI("path/to/myFile.foo");
		assertTrue(filter.matches(match));
		URI mismatch = URI.createFileURI("path/to/myFile.bar");
		assertFalse(filter.matches(mismatch));
	}
	
	public void testByExtensionAndRegExpr() {
		NameBasedFilter filter = new NameBasedFilter();
		filter.setRegularExpression("ath");
		filter.setExtension("foo");
		URI match = URI.createFileURI("path/to/myFile.foo");
		assertTrue(filter.matches(match));
		URI mismatch = URI.createFileURI("path/to/myFile.bar");
		assertFalse(filter.matches(mismatch));
		mismatch = URI.createFileURI("to/myFile.foo");
		assertFalse(filter.matches(mismatch));
	}
	
}
