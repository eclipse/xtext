/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NameBasedFilterTest extends Assert {

	@Test public void testNullUri() {
		assertFalse(new NameBasedFilter().matches(null));
	}
	
	@Test public void testByFileExtension() {
		NameBasedFilter filter = new NameBasedFilter();
		filter.setExtension("foo");
		URI match = URI.createFileURI("path/to/myFile.foo");
		assertTrue(filter.matches(match));
		URI mismatch = URI.createFileURI("path/to/myFile.bar");
		assertFalse(filter.matches(mismatch));
	}
	
	@Test public void testNoCriteria() {
		NameBasedFilter filter = new NameBasedFilter();
		URI match = URI.createFileURI("path/to/myFile.foo");
		assertTrue(filter.matches(match));
		match = URI.createFileURI("path/to/myFile.bar");
		assertTrue(filter.matches(match));
	}
	
	@Test public void testByRegularExpression() {
		NameBasedFilter filter = new NameBasedFilter();
		filter.setRegularExpression("ile\\.fo");
		URI match = URI.createFileURI("path/to/myFile.foo");
		assertTrue(filter.matches(match));
		URI mismatch = URI.createFileURI("path/to/myFile.bar");
		assertFalse(filter.matches(mismatch));
	}
	
	@Test public void testByExtensionAndRegExpr() {
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
