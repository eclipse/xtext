/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xtext.parser.encoding.EncodingTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.encoding.encodingTest.Model;
import org.eclipse.xtext.parser.encoding.encodingTest.Word;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.ITextRegion;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Bug306325Test extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(EncodingTestLanguageStandaloneSetup.class);
	}

	@Test public void testLocationInUtf8EncodedFile() throws Exception {
		performTestWithEncoding("UTF-8");
		performTestWithEncoding("UTF-16");
		performTestWithEncoding("ISO-8859-1");
	}

	protected void performTestWithEncoding(String encoding) throws UnsupportedEncodingException, IOException {
		String model = "Öclüpß Mödälüng Pröjäkt";
		byte[] utfBytes = model.getBytes(encoding);
		XtextResource resource = createXtextResource();
		resource.load(new ByteArrayInputStream(utfBytes), Collections.singletonMap(XtextResource.OPTION_ENCODING, encoding));
		Model root = (Model) resource.getContents().get(0);
		EList<Word> words = root.getWords();
		assertEquals(3,words.size());
		String[] lexemes = model.split(" ");
		
		ILocationInFileProvider locationInFileProvider = getInjector().getInstance(ILocationInFileProvider.class);
		ITextRegion location0 = locationInFileProvider.getSignificantTextRegion(words.get(0));
		assertEquals(0, location0.getOffset());
		assertEquals(lexemes[0].length(), location0.getLength());
		
		ITextRegion location1 = locationInFileProvider.getSignificantTextRegion(words.get(1));
		assertEquals(lexemes[0].length() + 1, location1.getOffset());
		assertEquals(lexemes[1].length(), location1.getLength());
		
		ITextRegion location2 = locationInFileProvider.getSignificantTextRegion(words.get(2));
		assertEquals(lexemes[0].length() + lexemes[1].length() + 2, location2.getOffset());
		assertEquals(lexemes[2].length(), location2.getLength());
	}
	
	protected XtextResource createXtextResource() {
		URI resourceURI = URI.createURI("test.encodingtestlanguage");
		Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(resourceURI);
		XtextResource resource = (XtextResource) factory.createResource(resourceURI);
		return resource;
	}
	
}
