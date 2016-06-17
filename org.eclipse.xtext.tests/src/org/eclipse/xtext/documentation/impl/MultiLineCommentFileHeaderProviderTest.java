/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.dummy.DummyTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class MultiLineCommentFileHeaderProviderTest extends AbstractXtextTests {

	private IFileHeaderProvider fileHeaderProvider;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(DummyTestLanguageStandaloneSetup.class);
		fileHeaderProvider = get(IFileHeaderProvider.class);
	}

	
	@Test 
	public void testFileHeader_0() throws Exception {
		assertHeaderIs(
				"/*\n" +
				" * my header \n" +
				" */\n"
				, 
				"my header");
	}
	
	@Test 
	public void testFileHeader_1() throws Exception {
		assertHeaderIs("", null);
	}
	
	@Test 
	public void testFileHeader_2() throws Exception {
		assertHeaderIs(
				"   \t\n\n/*\n" +
				" * my header \n" +
				" */\n"
				, 
				"my header");
	}
	
	@Test 
	public void testFileHeader_3() throws Exception {
		assertHeaderIs(
				"element A; " +
				"/*\n" +
				" * my header \n" +
				" */\n"
				, 
				null);
	}
	
	@Test 
	public void testFileHeader_4() throws Exception {
		assertHeaderIs(
				"/*\n" +
				" * my header \n" +
				" */\n" +
				"/*\n" +
				" * element doc\n" +
				" */\n" +
				"element A; "
				, 
				"my header");
	}
	
	@Test 
	public void testFileHeader_5() throws Exception {
		assertHeaderIs(
				"/*\n" +
				" * my header \n" +
				" */\n" +
				"element A; "
				, 
				"my header");
	}
	
	@Test 
	public void testFileHeader_6() throws Exception {
		assertHeaderIs(
				"/*************\n" +
				" * my header *\n" +
				" *************/\n" 
				, 
				"my header");
	}
	
	@Test 
	public void testFileHeader_7() throws Exception {
		assertHeaderIs(
				"element A;" 
				, 
				null);
	}
	
	protected void assertHeaderIs(String model, String expectedHeader) throws Exception {
		Resource resource = getResource(model, "dummy.dummytestlanguage");
		String header = fileHeaderProvider.getFileHeader(resource);
		if(expectedHeader == null)
			assertNull(header);
		else
			assertEquals(expectedHeader, header);
	}
}
