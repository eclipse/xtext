/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.encoding;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EncodingTest extends AbstractXtextTests {

	private static final String ISO_8859_1 = "ISO-8859-1";
	private static final String UTF_8 = "UTF-8";
	private String model;
	private byte[] utfBytes;
	private byte[] isoBytes;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(EncodingTestLanguageStandaloneSetup.class);
		model = "Öclüpß Mödelüng Främwörk";
		utfBytes = model.getBytes(UTF_8);
		isoBytes = model.getBytes(ISO_8859_1);
	}
	
	public void testDefaultEncoding() throws Exception {
		XtextResource resource = createXtextResource();
		assertEquals(Charset.defaultCharset().name(), resource.getEncoding());
	}

	public void testEncodingOption() throws Exception {
		Map<String,String> isoOptions = Collections.singletonMap(XtextResource.OPTION_ENCODING, ISO_8859_1);
		Map<String,String> utfOptions = Collections.singletonMap(XtextResource.OPTION_ENCODING, UTF_8);
		
		assertFalse(Arrays.equals(utfBytes, isoBytes));
		XtextResource resource = createXtextResource();
		
		resource.load(new ByteArrayInputStream(utfBytes), isoOptions);
		assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());

		resource.load(new ByteArrayInputStream(isoBytes), utfOptions);
		assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());

		resource = createXtextResource();
		resource.load(new ByteArrayInputStream(isoBytes), isoOptions);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		ByteArrayOutputStream isoSaveStream = new ByteArrayOutputStream();
		resource.save(isoSaveStream, null);
		isoSaveStream.close();
		byte[] savedIsoBytes = isoSaveStream.toByteArray();
		assertTrue(Arrays.equals(isoBytes, savedIsoBytes));
		
		ByteArrayOutputStream utfSaveStream = new ByteArrayOutputStream();
		resource.save(utfSaveStream, utfOptions);
		byte[] savedUtfBytes = utfSaveStream.toByteArray();
		assertTrue(Arrays.equals(utfBytes, savedUtfBytes));
	}

	protected XtextResource createXtextResource() {
		URI resourceURI = URI.createURI("test.encodingtestlanguage");
		Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(resourceURI);
		XtextResource resource = (XtextResource) factory.createResource(resourceURI);
		return resource;
	}
}
