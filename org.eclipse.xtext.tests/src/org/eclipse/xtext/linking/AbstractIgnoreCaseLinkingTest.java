/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractIgnoreCaseLinkingTest extends AbstractXtextTests {

	@Test public void testSimpleModel() throws Exception {
		String input = "a A {}";
		getModel(input);
	}
	
	@Test public void testNestedModel() throws Exception {
		String input = "a A { b a { c B {} c a {} } }";
		getModel(input);
	}
	
	@Test public void testUnresolvedLink() throws Exception {
		String input = "a notFound {}";
		getModelAndExpect(input, 1);
	}
	
	public abstract void testWithImports() throws Exception;
	
}
