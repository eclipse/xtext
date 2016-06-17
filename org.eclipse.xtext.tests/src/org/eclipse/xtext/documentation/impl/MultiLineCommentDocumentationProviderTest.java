/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import org.eclipse.xtext.dummy.DummyTestLanguageStandaloneSetup;
import org.eclipse.xtext.dummy.dummyLang.Element;
import org.eclipse.xtext.dummy.dummyLang.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class MultiLineCommentDocumentationProviderTest extends AbstractXtextTests {

	final String expectedDocumentation = "A is an element.";	
	
	final String document = "element A;";

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(DummyTestLanguageStandaloneSetup.class);
	}

	public String getComment (String modelString) throws Exception {
		return getComment (modelString, 0);
	}
	
	public String getComment (String modelString, int index) throws Exception {
		Model model = (Model) getModel(modelString);
		assertNotNull (model);
		assertNotNull (model.getElements());
		assertTrue (index<model.getElements().size());
		
		Element element = model.getElements().get(index);
		assertNotNull (element);
		
		MultiLineCommentDocumentationProvider mlcdp = getInjector().getInstance(MultiLineCommentDocumentationProvider.class);
		return mlcdp.getDocumentation(element);
	}
	
	@Test public void testSimple() throws Exception {
		String documentation = getComment (
				"/**\n" +
				"* " + expectedDocumentation + "\n" +
				"*/\n" +
				"element A;");
		assertEquals (expectedDocumentation, documentation);
	}

	@Test public void testMissingStartTag() throws Exception {
		String documentation = getComment (
				"/*\n" +
				"* " + expectedDocumentation + "\n" +
				"*/\n" +
				"element A;");
		assertEquals (expectedDocumentation, documentation);
	}
	
	@Test public void testRect() throws Exception {
		String documentation = getComment (
				"/********************************************\n" +
				" **                               **\n" +
				" ** " + expectedDocumentation + " **\n" +
				" **                               **\n" +
				" ********************************************/\n" +
				document);
		assertEquals (expectedDocumentation, documentation);
	}	
	
	@Test public void testWhitespace() throws Exception {
		String documentation = getComment (
				" \t \t /***\n" +
				"** " + expectedDocumentation + " \t \t ** \t \t \n" +
				" \t \t ***/ \t \t \n" +
				document);
		assertEquals (expectedDocumentation, documentation);
	}	
	
	@Test public void testWithSingleLineComment() throws Exception {
		String documentation = getComment (
				"/**\n" +
				"* " + expectedDocumentation + "\n" +
				"*/\n" +
				"// single line comment\n" +
				document);
		assertEquals (expectedDocumentation, documentation);
	}

	@Test public void testMultipleCommentsForOneObject() throws Exception {
		String documentation = getComment (
				"/**\n" +
				"* " + expectedDocumentation + "2\n" +
				"*/\n" +
				"/**\n" +
				"* " + expectedDocumentation + "\n" +
				"*/\n" +
				document);
		assertEquals (expectedDocumentation, documentation);
	}
	
	@Test public void testMultipleComments() throws Exception {
		String s = 	"/**\n" +
			"* " + expectedDocumentation + "\n" +
			"*/\n" +
			document;
		s.replaceAll ("A", "B");
		String documentation = getComment (s.replaceAll ("A", "B") + s, 1);
		assertEquals (expectedDocumentation, documentation);
	}

	@Test public void testMultipleMultiLineComments() throws Exception {
		String documentation = getComment ("/**\n" +
			"* " + expectedDocumentation + "\n" +
			"*/\n" +
			"/* */" +
			document);
		assertEquals ("", documentation);
	}
	
	@Test public void testNoComment() throws Exception {
		String documentation = getComment (document);
		assertNull (documentation);		
	}
}