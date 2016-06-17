/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractBacktrackingBug325745ParserTest extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361355
		return false;
	}

	@Test public void testValid_01() throws Exception {
		getModel("foo '+' 1 c.");
	}
	
	@Test public void testValid_02() throws Exception {
		getModel("foo 1 1c.");
	}
	
	@Test public void testValid_03() throws Exception {
		getModel("foo [ 1c.");
	}
	
	@Test public void testValid_04() throws Exception {
		getModel("foo '-' 1c ].");
	}
	
	@Test public void testValid_05() throws Exception {
		getModel("foo '-' [ 1c ].");
	}
	
	@Test public void testValid_06() throws Exception {
		getModel("foo [ '-' 1c ].");
	}
	
	@Test public void testValid_07() throws Exception {
		getModel("foo 1!c 'a' ].");
	}
	
	@Test public void testValid_08() throws Exception {
		getModel("foo 1*c 'a'.");
	}
	
	@Test public void testValid_09() throws Exception {
		getModel("foo 1*!c ] 'a'.");
	}
	
	@Test public void testValid_10() throws Exception {
		getModel("foo 1!.bar 2*c ] 'a'.");
	}
}
