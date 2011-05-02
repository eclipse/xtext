/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.impl.Serializer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testDummy() {

	}

	//	public void testXtext() throws Exception {
	//		with(XtextStandaloneSetup.class);
	//		XtextResource res = (XtextResource) new XtextResourceSet().getResource(
	//				URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"), true);
	//		String actual = get(Serializer.class).serialize(res.getContents().get(0));
	//		String expected = res.getParseResult().getRootNode().getText();
	//		// FIXME: trim should no be needed. this ws seems to get lost in the formatter
	//		assertEquals(expected.trim(), actual);
	//	}
}
