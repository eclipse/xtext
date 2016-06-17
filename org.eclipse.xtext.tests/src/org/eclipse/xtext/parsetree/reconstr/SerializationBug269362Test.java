/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model;
import org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguageFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SerializationBug269362Test extends AbstractXtextTests {

	private XtextResource resource;
	private XtextResourceSet resourceSet;
	private Model model;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SerializationBug269362TestLanguageStandaloneSetup.class);
		resourceSet = get(XtextResourceSet.class);
		resource = get(XtextResource.class);
		resourceSet.getResources().add(resource);
		model = SerializationBug269362TestLanguageFactory.eINSTANCE
				.createModel();
		resource.getContents().add(model);
	}

	@Test public void testSerialize_01() throws Exception {
		model.setBar("bar");
		model.setFoo("foo");
		String result = serialize(model);
		assertEquals("foo ^foo bar ^bar", result);
	}

}
