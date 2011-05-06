/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.hyperlinking;

import junit.framework.Test;

import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class HyperlinkingTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(HyperlinkingTest.class);
	}
	
	@Inject
	private IHyperlinkHelper hyperlinkHelper;

	@Inject
	private WorkbenchTestHelper testHelper;
	
	public void testDispatchMethod() throws Exception {
		String modelAsString = "class Foo {\n"
				+ "  def bar() { foo(new Object()) }\n"
				+ "  def dispatch foo(Object o) { null }\n"
				+ "  def dispatch foo(String s) { null }\n"
				+ "  def dispatch foo(Number n) { null }\n"
				+ "}";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Foo", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("foo"), true);
		assertEquals(3, hyperlinks.length);
		assertEquals("foo(Number) : Object", hyperlinks[0].getHyperlinkText());
		assertEquals("foo(String) : Object", hyperlinks[1].getHyperlinkText());
		assertEquals("foo(Object) : Object", hyperlinks[2].getHyperlinkText());
	}
	
	public void testPlainMethod() throws Exception {
		String modelAsString = "class Foo {\n"
				+ "  def bar() { foo() }\n"
				+ "  def foo() { null }\n"
				+ "}";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Foo", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("foo"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("foo() : Object", hyperlinks[0].getHyperlinkText());
	}
	
	public void testConstructor() throws Exception {
		String modelAsString =
			"class Foo {\n"
				+ "  def bar() { new Foo() }\n"
				+ "}";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Foo", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("Foo", 10), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Foo", hyperlinks[0].getHyperlinkText());
	}

	public void testSuperClass() throws Exception {
		String modelAsString =
			"class Foo extends Object {\n"
				+ "}";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Foo", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("Object"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Object", hyperlinks[0].getHyperlinkText());
	}
	
}
