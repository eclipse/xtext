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
import java.io.CharConversionException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EncodingTest extends AbstractXtextTests {

	private static final String ISO_8859_1 = "ISO-8859-1";
	private static final String UTF_8 = "UTF-8";
	private String model;
	private byte[] utfBytes;
	private byte[] isoBytes;
	private Map<String, String> isoOptions;
	private Map<String, String> utfOptions;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(EncodingTestLanguageStandaloneSetup.class);
		model = "Öclüpß Mödelüng Främwörk";
		utfBytes = model.getBytes(UTF_8);
		isoBytes = model.getBytes(ISO_8859_1);
		isoOptions = Collections.singletonMap(XtextResource.OPTION_ENCODING, ISO_8859_1);
		utfOptions = Collections.singletonMap(XtextResource.OPTION_ENCODING, UTF_8);
	}
	
	@Override
	public void tearDown() throws Exception {
		model = null;
		utfBytes = null;
		isoBytes = null;
		isoOptions = null;
		utfOptions = null;
		super.tearDown();
	}
	
	@Test public void testDefaultEncoding() throws Exception {
		XtextResource resource = createXtextResource();
		assertEquals(Charset.defaultCharset().name(), resource.getEncoding());
	}
	
	@Test public void testSetup() {
		assertFalse(Arrays.equals(utfBytes, isoBytes));
		assertTrue(Charset.defaultCharset().name().equals(UTF_8) || Charset.defaultCharset().name().equals(ISO_8859_1));
	}
	
	@Test public void testUtfBytesWithIsoOptions() throws Exception {
		XtextResource resource = createXtextResource();
		try {
			resource.load(new ByteArrayInputStream(utfBytes), isoOptions);
			assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());
		} catch (WrappedException e) {
			if (e.getCause() instanceof CharConversionException) {
				// ok
			} else {
				throw e;
			}
		}
		resource.reparse(model);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	@Test public void testIsoBytesWithUtfOptions() throws Exception {
		XtextResource resource = createXtextResource();
		try {
			resource.load(new ByteArrayInputStream(isoBytes), utfOptions);
			assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());
		} catch(WrappedException e) {
			if (e.getCause() instanceof CharConversionException) {
				// ok
			} else {
				throw e;
			}
		}
		resource.reparse(model);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	@Test public void testIsoEncoding() throws Exception {
		XtextResource resource = createXtextResource();
		resource.load(new ByteArrayInputStream(isoBytes), isoOptions);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		resource.reparse(model);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	@Test public void testUtfEncoding() throws Exception {
		XtextResource resource = createXtextResource();
		resource.load(new ByteArrayInputStream(utfBytes), utfOptions);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		resource.reparse(model);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	@Test public void testSaveIsoToIso() throws Exception {
		XtextResource resource = createXtextResource();
		resource.load(new ByteArrayInputStream(isoBytes), isoOptions);
		ByteArrayOutputStream isoSaveStream = new ByteArrayOutputStream();
		resource.save(isoSaveStream, null);
		isoSaveStream.close();
		byte[] savedIsoBytes = isoSaveStream.toByteArray();
		assertTrue(Arrays.equals(isoBytes, savedIsoBytes));
	}
	
	@Test public void testSaveUtfToUtf() throws Exception {
		XtextResource resource = createXtextResource();
		resource.load(new ByteArrayInputStream(utfBytes), utfOptions);
		ByteArrayOutputStream utfSaveStream = new ByteArrayOutputStream();
		resource.save(utfSaveStream, null);
		utfSaveStream.close();
		byte[] savedUtfBytes = utfSaveStream.toByteArray();
		assertTrue(Arrays.equals(utfBytes, savedUtfBytes));
	}
	
	@Test public void testSaveUtfToIso() throws Exception {
		XtextResource resource = createXtextResource();
		resource.load(new ByteArrayInputStream(utfBytes), utfOptions);
		ByteArrayOutputStream isoSaveStream = new ByteArrayOutputStream();
		resource.save(isoSaveStream, isoOptions);
		isoSaveStream.close();
		byte[] savedIsoBytes = isoSaveStream.toByteArray();
		assertTrue(Arrays.equals(isoBytes, savedIsoBytes));
	}
	
	@Test public void testSaveIsoToUtf() throws Exception {
		XtextResource resource = createXtextResource();
		resource.load(new ByteArrayInputStream(isoBytes), isoOptions);
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
