/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;

/**
 * Really long running smoke tests for the xtext grammar. Uses all test grammars.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
@RunWith(value = Parameterized.class)
public class ResourceLoadTest extends AbstractXtextTests {

	private String grammarPath;
	private String model;
	
	private static boolean FIRST_ONLY = true; 
	
	public ResourceLoadTest(String grammarPath) {
		this.grammarPath = grammarPath;
	}

	@Parameters
	public static Collection<Object[]> data() {
		List<Object[]> result = Lists.newArrayList();
		try {
			String mweFile = staticReadFileIntoString("org/eclipse/xtext/GenerateAllTestLanguages.mwe2");
			Pattern pattern = Pattern.compile("uri\\s*=\\s*\"([^\"]*)\"");
			Matcher matcher = pattern.matcher(mweFile);
			while (matcher.find()) {
				String grammarURI = matcher.group(1);
				String grammarPath = grammarURI.replaceFirst("classpath:/", "");
				result.add(new Object[] { grammarPath });
				if(FIRST_ONLY) 
					break;
			}
		} catch (Exception exc) {
			// ignore
		}
		return result;
	}
	
	protected static String staticReadFileIntoString(String filePath) throws IOException {
		ClassLoader classLoader = ResourceLoadTest.class.getClassLoader();
		URL url = classLoader.getResource(filePath);
		if (url == null) {
			fail("Could not read resource: '" + filePath + "'. Is your file system case sensitive?");
		} else {
			if(!new File(url.getPath()).getCanonicalPath().endsWith(filePath))
				throw new RuntimeException(filePath + ":\n" +
						"The file does not exist exactly as it was named.\n" +
						"The test is likely to cause trouble on the build server.\n" +
						"Is your filesystem case insensitive? Please verify the spelling.");

			InputStream resourceAsStream = classLoader.getResourceAsStream(filePath);
			try {
				if (resourceAsStream == null) {
					fail("Could not read resource: '" + filePath + "'. Is your file system case sensitive?");
				} else {
						byte[] buffer = new byte[2048];
						int bytesRead = 0;
						StringBuffer b = new StringBuffer();
						do {
							bytesRead = resourceAsStream.read(buffer);
							if (bytesRead != -1)
								b.append(new String(buffer, 0, bytesRead));
						} while (bytesRead != -1);
						String model = b.toString();
						return model;
				}
			} finally {
				if (resourceAsStream != null)
					resourceAsStream.close();
			}
		}
		throw new IllegalStateException("May not happen, but helps to suppress false positives in eclipse' control flow analysis.");
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		model = readFileIntoString(grammarPath);
	}
	
	@Override
	public void tearDown() throws Exception {
		model = null;
		super.tearDown();
	}

	@Test public void testNoExceptionDiagnostics_01() throws Exception {
		for (int i = 0; i < model.length(); i++) {
			String model = this.model.substring(0, i);
			Resource r = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
			assertNoExceptionDiagnostic(r, model);
		}
	}

	@Test public void testNoExceptionDiagnostics_02() throws Exception {
		for (int i = 0; i < model.length(); i++) {
			String model = this.model.substring(i);
			Resource r = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
			assertNoExceptionDiagnostic(r, model);
		}
	}

	@Test public void testNoExceptionDiagnostics_03() throws Exception {
		for (int i = 0; i < model.length() - 1; i++) {
			String model = this.model.substring(0, i) + this.model.substring(i + 1);
			//			System.out.println(model);
			Resource r = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
			assertNoExceptionDiagnostic(r, model);
		}
	}

	@Test public void testNoExceptionDiagnostics_04() throws Exception {
		XtextResource r = getResourceFromString(this.model);
		assertTrue(r.getErrors().isEmpty());
		ICompositeNode node = r.getParseResult().getRootNode();
		for (Iterator<INode> i = node.getAsTreeIterable().iterator(); i.hasNext();) {
			INode childNode = i.next();
			String subModel = model.substring(0, childNode.getOffset())
					+ model.substring(childNode.getOffset() + childNode.getLength());
			Resource res = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
			assertNoExceptionDiagnostic(res, subModel);
		}
	}

	private void assertNoExceptionDiagnostic(Resource r, String model) throws Exception {
		for (Diagnostic d : r.getErrors()) {
			if (d instanceof ExceptionDiagnostic) {
				throw new Exception(model, ((ExceptionDiagnostic) d).getException());
			}
		}
	}

	@Test public void testDummy() {
		assertNotNull(model);
	}

}
