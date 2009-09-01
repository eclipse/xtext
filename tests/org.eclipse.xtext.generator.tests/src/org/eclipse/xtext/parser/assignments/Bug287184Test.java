/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.assignments;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug287184Test extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(Bug287184TestLanguageStandaloneSetup.class);
	}
	
	public void testBug287184_01() throws Exception {
		String modelAsText = "model ID.ID detail ID.ID";
		Resource res = getResourceFromString(modelAsText);
		assertTrue(res.getErrors().toString(), res.getErrors().isEmpty());
	}
	
	public void testBug287184_02() throws Exception {
		String modelAsText = "model ID.ID associated ID.ID;";
		Resource res = getResourceFromString(modelAsText);
		assertTrue(res.getErrors().toString(), res.getErrors().isEmpty());
	}
	
	public void testBug287184_03() throws Exception {
		String modelAsText = "model ID.ID detail public ID.ID";
		Resource res = getResourceFromString(modelAsText);
		assertTrue(res.getErrors().toString(), res.getErrors().isEmpty());
	}
	
	public void testBug287184_04() throws Exception {
		String modelAsText = "model ID.ID detail public ID.ID detail ID.ID";
		Resource res = getResourceFromString(modelAsText);
		assertTrue(res.getErrors().toString(), res.getErrors().isEmpty());
	}
	
	public void testBug287184_05() throws Exception {
		String modelAsText = "model ID associated ID;";
		Resource res = getResourceFromString(modelAsText);
		assertTrue(res.getErrors().toString(), res.getErrors().isEmpty());
	}
	
	public void testBug287184_06() throws Exception {
		String modelAsText = "model ID detail ID;";
		Resource res = getResourceFromStringAndExpect(modelAsText, 2);
		assertEquals(res.getErrors().toString(), 2, res.getErrors().size());
	}
	
}
