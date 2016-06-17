/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import java.io.ByteArrayOutputStream;

import org.eclipse.xtext.parser.terminalrules.unicode.AbstractString;
import org.eclipse.xtext.parser.terminalrules.unicode.GString;
import org.eclipse.xtext.parser.terminalrules.unicode.Model;
import org.eclipse.xtext.parser.terminalrules.unicode.QuotedString;
import org.eclipse.xtext.parser.terminalrules.unicode.UnicodeFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class UnicodeTest extends AbstractXtextTests {

	private static final String UMLAUTS = "\u00c4\u00d6\u00dc";
	private static final String QUOTED_UMLAUTS = "\\u00c4\\u00d6\\u00dc";
	private static final String MIXED_UMLAUTS = "\u00c4\\u00d6\u00dc";

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(UnicodeTestLanguageStandaloneSetup.class);
	}

	@Test public void testParse() throws Exception {
		XtextResource resource = getResource(UMLAUTS, "test.mydsl");
		Model model = (Model) resource.getContents().get(0);
		for(AbstractString s: model.getStrings()) {
			assertEquals(UMLAUTS, s.getName());
		}
	}
	
	@Test public void testParseSTRING() throws Exception {
		XtextResource resource = getResource("'" + UMLAUTS + "' '" + QUOTED_UMLAUTS + "' '" + MIXED_UMLAUTS +"'", "test.mydsl");
		Model model = (Model) resource.getContents().get(0);
		for(AbstractString s: model.getStrings()) {
			assertEquals(UMLAUTS, s.getName());
		}
	}
	

	@Test public void testWrite() throws Exception {
		XtextResource resource = getResource("", "test.mydsl");
		Model model = UnicodeFactory.eINSTANCE.createModel();
		resource.getContents().add(model);
		GString s0 = UnicodeFactory.eINSTANCE.createGString();
		s0.setName(UMLAUTS);
		model.getStrings().add(s0);
		QuotedString s1 = UnicodeFactory.eINSTANCE.createQuotedString();
		s1.setName(UMLAUTS);
		model.getStrings().add(s1);
		QuotedString s2 = UnicodeFactory.eINSTANCE.createQuotedString();
		s2.setName(QUOTED_UMLAUTS);
		model.getStrings().add(s2);
		QuotedString s3 = UnicodeFactory.eINSTANCE.createQuotedString();
		s3.setName(MIXED_UMLAUTS);
		model.getStrings().add(s3);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		resource.save(outputStream, null);
		String textualModel = new String(outputStream.toByteArray());
		assertEquals(doubleQuote(UMLAUTS + " \"" + UMLAUTS + "\" \"" + QUOTED_UMLAUTS + "\" \"" + MIXED_UMLAUTS + "\""), textualModel); 
	}
	
	protected String doubleQuote(String s) {
		return s.replace("\\", "\\\\");
	}
}
