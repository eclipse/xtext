/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.xtext.linking.lazy.bug311337.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Bug311337Test extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new Bug311337TestLanguageStandaloneSetup());
	}
	
	@Test public void testNoCyclicLinkingException() throws Exception {
		Model model = (Model) getModel(
			"/************************************/\n"+
			"(def) local :\n"+
			"   (child) local_Child : def_depth1\n"+
			"   (ref) local_Child:depth1_Child\n"+
			"\n"+
			"/************************************/\n"+
			"\n"+
			"(def) def_depth1 :\n"+
			"   (child) depth1_Child : def_depth2\n"+
			"\n"+
			"/************************************/\n"+
			"\n"+
			"(def) def_depth2 :\n"+
			"   (child) depth2_Child :\n");
		assertTrue(model.eResource().getErrors().isEmpty());
	}
}
