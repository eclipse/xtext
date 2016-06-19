/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug297105Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug297105TestLanguageStandaloneSetup.class);
	}
	
	@Test public void testBug297105_01() throws Exception {
		getModel("1.1 + 2.2");
	}
	
	@Test public void testBug297105_02() throws Exception {
		getModel("1.1+2.2");
	}
	
	@Test public void testBug297105_03() throws Exception {
		getModel("1.1 + 2.2 ");
	}
	
	@Test public void testBug297105_04() throws Exception {
		getModel("1.1+2.2 ");
	}
	
	@Test public void testBug297105_05() throws Exception {
		getModel(".1 + .2");
	}
	
	@Test public void testBug297105_06() throws Exception {
		getModel(".1+.2");
	}
	
	@Test public void testBug297105_07() throws Exception {
		getModel(".1 + .2 ");
	}
	
	@Test public void testBug297105_08() throws Exception {
		getModel(".1+.2 ");
	}
	
	@Test public void testBug297105_09() throws Exception {
		getModel("1.1e+1 + 2.2e-1");
	}
	
	@Test public void testBug297105_10() throws Exception {
		getModel("1.1e-1+2.2e+1");
	}
	
	@Test public void testBug297105_11() throws Exception {
		getModel("1.1e+1 + 2.2e-1 ");
	}
	
	@Test public void testBug297105_12() throws Exception {
		getModel("1.1e-1+2.2e+1 ");
	}
	
	@Test public void testBug297105_13() throws Exception {
		getModel(".1e+1 + .2e-1");
	}
	
	@Test public void testBug297105_14() throws Exception {
		getModel(".1e-1+.2e+1");
	}
	
	@Test public void testBug297105_15() throws Exception {
		getModel(".1e+1 + .2e-1 ");
	}
	
	@Test public void testBug297105_16() throws Exception {
		getModel(".1e-1+.2e-1 ");
	}
	
	@Test public void testBug297105_17() throws Exception {
		getModel("1 + 2");
	}
	
	@Test public void testBug297105_18() throws Exception {
		getModel("1+2");
	}
	
	@Test public void testBug297105_19() throws Exception {
		getModel("1 + 2 ");
	}
	
	@Test public void testBug297105_20() throws Exception {
		getModel("1+2 ");
	}
}
