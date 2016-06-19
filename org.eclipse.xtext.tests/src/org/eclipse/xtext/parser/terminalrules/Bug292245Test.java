/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug292245Test extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361355
		return false;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug292245TestLanguageStandaloneSetup.class);
	}
	
	@Test public void testBug292245_01() throws Exception {
		getModel("TICK '");
	}
	
	@Test public void testBug292245_02() throws Exception {
		getModel("FIX 'X'");
	}
	
	@Test public void testBug292245_03() throws Exception {
		getModel("ERROR 'X'");
	}
	
	@Test public void testBug292245_04() throws Exception {
		getModel("TICK ' ");
	}
	
	@Test public void testBug292245_05() throws Exception {
		getModel("FIX 'X' ");
	}
	
	@Test public void testBug292245_06() throws Exception {
		getModel("ERROR 'X' ");
	}
	
	@Test public void testBug292245_07() throws Exception {
		getModel("TICK '\n" +
				"FIX 'X'\n" +
				"ERROR 'X'");
	}
	
	@Test public void testBug292245_08() throws Exception {
		getModel("TICK ' \n" +
				"FIX 'X' \n" +
				"ERROR 'X' ");
	}
}
