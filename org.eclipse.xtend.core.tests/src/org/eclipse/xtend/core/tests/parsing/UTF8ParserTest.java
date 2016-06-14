/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.parsing;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UTF8ParserTest extends AbstractXtendTestCase {
	
	@Override
	protected XtendFile file(String string, boolean validate) throws Exception {
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string, "UTF-8"), Collections.singletonMap(XtextResource.OPTION_ENCODING, "UTF-8"));
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}
	
	@Test public void testIdentifiers_01() throws Exception {
		XtendFunction func = function("def \u03b1\u03c1\u03b5\u03c4\u03b7() {}");
		assertEquals("\u03b1\u03c1\u03b5\u03c4\u03b7", func.getName());
	}
	
	@Test public void testIdentifiers_02() throws Exception {
		XtendFunction func = function("def ^\u03b1\u03c1\u03b5\u03c4\u03b7() {}");
		assertEquals("\u03b1\u03c1\u03b5\u03c4\u03b7", func.getName());
	}
	
	@Test public void testIdentifiers_03() throws Exception {
		XtendFunction func = function("def \\u03b1\\u03c1\\u03b5\\u03c4\\u03b7() {}");
		assertEquals("\u03b1\u03c1\u03b5\u03c4\u03b7", func.getName());
	}
	
	@Test public void testIdentifiers_04() throws Exception {
		XtendFunction func = function("def ^\\u03b1\\u03c1\\u03b5\\u03c4\\u03b7() {}");
		assertEquals("\u03b1\u03c1\u03b5\u03c4\u03b7", func.getName());
	}
	
}
